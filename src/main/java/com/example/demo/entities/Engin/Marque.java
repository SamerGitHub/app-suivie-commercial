package com.example.demo.entities.Engin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;

    @ManyToOne(fetch = FetchType.EAGER)
    private TypeEngin typeEngin;

    @JsonIgnore
    @OneToMany(mappedBy = "marque")
    private Collection<Modele> modeles;

    public Marque(String nom, TypeEngin typeEngin) {
        this.nom = nom;
        this.typeEngin = typeEngin;
    }

    public Marque() {

    }

    public Marque(String nom) {
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

    public TypeEngin getTypeEngin() {
        return typeEngin;
    }

    public void setTypeEngin(TypeEngin typeEngin) {
        this.typeEngin = typeEngin;
    }

    public Collection<Modele> getModeles() {
        return modeles;
    }

    public void setModeles(Collection<Modele> modeles) {
        this.modeles = modeles;
    }
}
