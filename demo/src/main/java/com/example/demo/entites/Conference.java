package com.example.demo.entites;



import com.example.demo.Enumeration.*;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Data
@Builder
@Entity
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String titre;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateFin;

    @Column(nullable = false)
    private String thematique;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Etatconference Etat;


    @OneToMany(mappedBy = "conferance", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Soumission> soumissions = new ArrayList<>();



    public Conference() {}

    public Conference(Etatconference etat, String thematique, Date dateFin, Date dateDebut, String titre) {
        Etat = etat;
        this.thematique = thematique;
        this.dateFin = dateFin;
        this.dateDebut = dateDebut;
        this.titre = titre;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public String getThematique() {
        return thematique;
    }

    public Etatconference getEtat() {
        return Etat;
    }

    public List<Soumission> getSoumissions() {
        return soumissions;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setThematique(String thematique) {
        this.thematique = thematique;
    }

    public void setEtat(Etatconference etat) {
        Etat = etat;
    }



    public void setSoumissions(List<Soumission> soumissions) {
        this.soumissions = soumissions;
    }
}


