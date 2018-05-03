package com.example.demo.entities.Engin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class CompagnieAssurance {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "compagnieAssurance", cascade = CascadeType.ALL)
    private Collection<Assurance> assurances;


    public CompagnieAssurance() {

    }

    public CompagnieAssurance(String nom) {
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

    public Collection<Assurance> getAssurances() {
        return assurances;
    }

    public void setAssurances(Collection<Assurance> assurances) {
        this.assurances = assurances;
    }
}
