package com.example.demo.controllers;

import com.example.demo.Services.implementation.ConferenceService;
import com.example.demo.entites.*;
import com.example.demo.Enumeration.*;
import com.example.demo.Services.implementation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.Services.implementation.AffecterRoleService.*;

@RestController
@RequestMapping("/api/conferences") // URL de base pour ce contrôleur
public class GestionDesConferences {

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private UserAppService userAppService;
    @Autowired
    AffecterRoleService affecterRoleService;
    @Autowired
    SoumissionService soumissionService;

    // 1. Récupérer toutes les conférences
    @GetMapping
    public List<Conference> getAllConferences() {
        return conferenceService.getAllConferences();
    }

    // 2. Récupérer une conférence par ID
    @GetMapping("/{id}")
    public ResponseEntity<Conference> getConferenceById(@PathVariable int id) {
        return conferenceService.getConferenceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    // 3. Créer une nouvelle conférence
    @PostMapping("/conferences/addConference")
    public ResponseEntity<Conference> createConference(
            @RequestBody Conference newConference, // Les détails de la conférence à créer
            @RequestParam Long createurId // L'ID de l'utilisateur créateur
    ) {
        // Récupérer l'utilisateur créateur depuis le service
        UserApp createur = userAppService.getUserAppById(createurId);
        if (createur == null) {
            throw new RuntimeException("User not found with id: " + createurId);
        }

        // Appeler la méthode dans le service en passant la conférence et le créateur
        Conference savedConference = conferenceService.createConference(newConference, createur);

        // Retourner la conférence créée avec un statut HTTP 200 OK
        return ResponseEntity.ok(savedConference);
    }



    // 4. Mettre à jour une conférence existante
    @PutMapping("/{id}")
    public ResponseEntity<Conference> updateConference(@PathVariable int id, @RequestBody Conference updatedConference) {
        return conferenceService.updateConference(id, updatedConference)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. Supprimer une conférence
    @DeleteMapping("/Remove/{id}")
    public ResponseEntity<Void> deleteConference(@PathVariable int id) {
        if (conferenceService.deleteConference(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // 6. Ajouter une soumission et affecter le rôle "auteur" à l'utilisateur
    @PostMapping("/{conferenceId}/soumission")
    public ResponseEntity<Soumission> addSoumissionToConference(
            @PathVariable int conferenceId, // ID de la conférence
            @RequestBody Soumission soumission, // Soumission à ajouter
            @RequestParam Long userId // ID de l'utilisateur qui soumet
    ) {
        // Récupérer l'utilisateur depuis la base de données
        UserApp user = userAppService.getUserAppById(userId);
        if (user== null) {
            throw new RuntimeException("User not found with id: " + userId);
        }
        // Récupérer la conférence
        Conference conference = conferenceService.getConferenceById(conferenceId)
                .orElseThrow(() -> new RuntimeException("Conference not found with id: " + conferenceId));

        // Ajouter la soumission à la conférence
        soumission.setConferance(conference);
        Soumission savedSoumission = soumissionService.addSoumission(soumission);

        // Ajouter la soumission à la liste des soumissions de la conférence
        conference.getSoumissions().add(savedSoumission);
        // Mettre à jour la conférence pour persister la relation
        conferenceService.updateConference(conferenceId, conference);

        // Affecter le rôle "auteur" à l'utilisateur pour cette soumission
        affecterRoleService.affecterRole(user, conference, ERole.AUTEUR);

        // Retourner la soumission avec un statut 200 OK
        return ResponseEntity.ok(savedSoumission);
    }



}
