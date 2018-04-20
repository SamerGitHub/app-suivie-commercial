package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Chantier {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String titre;
    private String adresse;

    private String description;

    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date createdDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Localisation localisation;

    @JsonIgnore
    @OneToMany(mappedBy = "chantier",
            cascade = CascadeType.REMOVE)
    private Collection<Commande> commandes;
    public Chantier() {

    }

    public Chantier(String titre, String adresse, String description, Date createdDate, Client client, Localisation localisation) {
        this.titre = titre;
        this.adresse = adresse;
        this.description = description;
        this.createdDate = createdDate;
        this.client = client;
        this.localisation = localisation;
    }

    public Chantier(String adresse, String description) {
        this.adresse = adresse;
        this.description = description;
    }

    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }
}
