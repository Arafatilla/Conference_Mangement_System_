package com.example.demo.entites;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Data
@Entity
public class DetailsSoumission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date dateDeSoumission;

    private Date dateDeModification;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "soumission_id", referencedColumnName = "id")
    private Soumission soumission;

    public DetailsSoumission(Date dateDeSoumission, Date dateDeModification, Soumission soumission) {
        this.dateDeSoumission = dateDeSoumission;
        this.dateDeModification = dateDeModification;
        this.soumission = soumission;
    }

    public DetailsSoumission() {

    }


}
