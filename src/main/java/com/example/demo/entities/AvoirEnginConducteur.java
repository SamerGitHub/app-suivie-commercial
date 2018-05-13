package com.example.demo.entities;

import com.example.demo.entities.Engin.Engin;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AvoirEnginConducteur {
    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    private LigneCommande ligneCommande;

    @ManyToOne(fetch = FetchType.EAGER)
    private Engin engin;


    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser conducteur;

    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser secretaire;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;


    public AvoirEnginConducteur() {
    }

    public AvoirEnginConducteur(LigneCommande ligneCommande,Engin engin, AppUser conducteur, AppUser secretaire,Date createdDate) {
        this.ligneCommande=ligneCommande;
        this.engin = engin;
        this.conducteur = conducteur;
        this.secretaire = secretaire;
        this.createdDate=createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Engin getEngin() {
        return engin;
    }

    public void setEngin(Engin engin) {
        this.engin = engin;
    }

    public AppUser getConducteur() {
        return conducteur;
    }

    public void setConducteur(AppUser conducteur) {
        this.conducteur = conducteur;
    }

    public AppUser getSecretaire() {
        return secretaire;
    }

    public void setSecretaire(AppUser secretaire) {
        this.secretaire = secretaire;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public LigneCommande getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(LigneCommande ligneCommande) {
        this.ligneCommande = ligneCommande;
    }
}
