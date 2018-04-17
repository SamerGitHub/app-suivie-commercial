package com.example.demo.entities.Engin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Reparation {

    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateReparation;
    private Float prix;
    private String description;


    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE,
            //  cascade = CascadeType.REMOVE,orphanRemoval = true,
            mappedBy = "reparation")
    private Collection<LigneReparation> ligneReparations;



    @ManyToOne(fetch = FetchType.EAGER)
    private Engin engin;

    public Reparation() {

    }

    public Reparation(Date dateReparation, Float prix, String description, Engin engin) {
        this.dateReparation = dateReparation;
        this.prix = prix;
        this.description = description;
        this.engin = engin;
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



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateReparation() {
        return dateReparation;
    }

    public void setDateReparation(Date dateReparation) {
        this.dateReparation = dateReparation;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }


    public Engin getEngin() {
        return engin;
    }

    public void setEngin(Engin engin) {
        this.engin = engin;
    }
}
