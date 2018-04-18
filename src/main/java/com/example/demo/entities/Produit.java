package com.example.demo.entities;

import com.example.demo.entities.tache.Livraison;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Produit {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;


    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "produit")
    private Collection<Livraison> livraisons;

    public Produit() {
    }

    public Produit(String nom) {
        this.nom = nom;
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

    public Collection<Livraison> getLivraisons() {
        return livraisons;
    }

    public void setLivraisons(Collection<Livraison> livraisons) {
        this.livraisons = livraisons;
    }
}
