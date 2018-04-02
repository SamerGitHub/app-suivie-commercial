package com.example.demo.entities;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

@Entity
public class Chantier {
    @Id
    @GeneratedValue
    private Long id;
    private String adresse;
    @LastModifiedDate
    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    private Client client;

    @OneToOne(fetch = FetchType.EAGER)
    private Localisation localisation;

    public Chantier() {

    }

    public Chantier(String adresse, String description) {
        this.adresse = adresse;
        this.description = description;
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
