package com.example.demo.entites;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import com.example.demo.entites.*;

import java.util.ArrayList;
import java.util.List;


@Data

@Entity
public class Soumission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;


    // Liste des auteurs (UserApp)
    @ManyToMany
    @JoinTable(
            name = "soumission_auteurs",
            joinColumns = @JoinColumn(name = "soumission_id"),
            inverseJoinColumns = @JoinColumn(name = "user_app_id"))
    private List<UserApp> auteurs;

    @OneToOne(cascade = CascadeType.ALL)
    private DetailsSoumission detailsSoumission;

    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conferance;

    @OneToMany
    private   List<Evaluation> evaluations=new ArrayList<>();

    public Soumission() {}

    public Soumission(int id, String nom, String description, DetailsSoumission detailsSoumission, Conference conferance) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.detailsSoumission = detailsSoumission;
        this.conferance = conferance;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setDetailsSoumission(DetailsSoumission detailsSoumission) {
        this.detailsSoumission = detailsSoumission;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setConferance(Conference conferance) {
        this.conferance = conferance;
    }



    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public DetailsSoumission getDetailsSoumission() {
        return detailsSoumission;
    }

    public Conference getConferance() {
        return conferance;
    }



    public void setAuteurs(List<UserApp> auteurs) {
        this.auteurs = auteurs;
    }

    public List<UserApp> getAuteurs() {
        return auteurs;
    }
}
