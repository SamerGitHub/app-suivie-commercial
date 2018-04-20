package com.example.demo.entities.Engin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Piece {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String nom;
    private String description;


    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "piece")
    private Collection<LigneReparation> ligneReparations;

    public Piece() {
    }

    public Piece(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public Collection<LigneReparation> getLigneReparations() {
        return ligneReparations;
    }

    public void setLigneReparations(Collection<LigneReparation> ligneReparations) {
        this.ligneReparations = ligneReparations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
