package com.example.demo.entites;

import com.example.demo.Enumeration.EtatEvaluation;
import jakarta.persistence.*;
import com.example.demo.entites.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Utilisation de Long au lieu de int

    private String commentaire; // Renommé 'description' en 'commentaire' pour plus de clarté

    @Enumerated(EnumType.STRING)
    private EtatEvaluation etat;

    private int note; // Ajout d'une note sur 10


    @ManyToOne
    private Soumission soumission; // La soumission évaluée


    @ManyToOne
    @JoinColumn(nullable = false)
    private UserApp evaluateur;
    public Evaluation(){}
    public Evaluation(EtatEvaluation etat, int note, String commentaire, Soumission soumission) {
        this.etat = etat;
        this.note = note;
        this.commentaire = commentaire;
        this.soumission = soumission;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setEtat(EtatEvaluation etat) {
        this.etat = etat;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setSoumission(Soumission soumission) {
        this.soumission = soumission;
    }

    public void setEvaluateur(UserApp evaluateur) {
        this.evaluateur = evaluateur;
    }

    public Long getId() {
        return id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public EtatEvaluation getEtat() {
        return etat;
    }

    public int getNote() {
        return note;
    }

    public Soumission getSoumission() {
        return soumission;
    }

    public UserApp getEvaluateur() {
        return evaluateur;
    }
}
