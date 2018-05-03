package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;


    @OneToMany(fetch = FetchType.EAGER,
              cascade = CascadeType.REMOVE,
             mappedBy = "commande")
    private Set<LigneCommande> ligneCommandes;


    public Commande() {
    }

    public Commande(AppUser appUser, Chantier chantier, String status, Date createdDate,String description) {
        this.user = appUser;
        this.chantier = chantier;
        this.status = status;
        this.createdDate = createdDate;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonGetter
    public AppUser getUser() {
        return user;
    }

    @JsonIgnore
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

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", user=" + user +
                ", chantier=" + chantier +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", ligneCommandes=" + ligneCommandes +
                '}';
    }
}

