package com.example.demo.entities.Engin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Assurance {
    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateDeb;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    private Float prix;

    @ManyToOne(fetch = FetchType.EAGER)
    private CompagnieAssurance compagnieAssurance;

    @ManyToOne(fetch = FetchType.EAGER)
    private Engin engin;

    public Assurance() {
    }

    public Assurance(Date dateDeb, Date dateFin, Float prix,CompagnieAssurance compagnieAssurance) {
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.prix = prix;
        this.compagnieAssurance=compagnieAssurance;
    }


    public CompagnieAssurance getCompagnieAssurance() {
        return compagnieAssurance;
    }

    public void setCompagnieAssurance(CompagnieAssurance compagnieAssurance) {
        this.compagnieAssurance = compagnieAssurance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
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
