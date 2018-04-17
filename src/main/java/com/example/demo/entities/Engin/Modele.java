package com.example.demo.entities.Engin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Modele {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String nom;


    @ManyToOne(fetch = FetchType.EAGER)
    private Marque marque;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,
            //cascade = CascadeType.REMOVE,
            //  cascade = CascadeType.REMOVE,orphanRemoval = true,
            mappedBy = "modele")
    private Collection<Engin> engins;

    public Modele() {

    }

    public Modele(String nom, Marque marque) {
        this.nom = nom;
        this.marque = marque;
    }

    public Modele(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Collection<Engin> getEngins() {
        return engins;
    }

    public void setEngins(Collection<Engin> engins) {
        this.engins = engins;
    }
}
