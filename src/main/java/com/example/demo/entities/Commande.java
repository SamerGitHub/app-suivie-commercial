package com.example.demo.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
public class Commande {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Chantier chantier;

    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;


    @OneToMany(fetch = FetchType.EAGER,
              cascade = CascadeType.REMOVE,
             mappedBy = "commande")
    private Set<LigneCommande> ligneCommandes;


    public Commande() {
    }

    public Commande(AppUser appUser, Chantier chantier, String status, Date createdDate) {
        this.user = appUser;
        this.chantier = chantier;
        this.status = status;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Chantier getChantier() {
        return chantier;
    }

    public void setChantier(Chantier chantier) {
        this.chantier = chantier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Set<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(Set<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }
}

