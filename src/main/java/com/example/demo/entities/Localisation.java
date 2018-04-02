package com.example.demo.entities;

import com.example.demo.entities.Engin.Engin;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity

public class Localisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String latitude, longitude;


    @OneToOne(fetch = FetchType.EAGER,
            //cascade = CascadeType.REMOVE,
          //  cascade = CascadeType.REMOVE,orphanRemoval = true,
            mappedBy = "localisation")
    private Engin engin;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "localisation")
    private Chantier chantier;

    public Localisation(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Localisation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @JsonIgnore
    public Engin getEngin() {
        return engin;
    }

    //@JsonIgnore
    public void setEngin(Engin engin) {
        this.engin = engin;
    }

    @JsonIgnore
    public Chantier getChantier() {
        return chantier;
    }

    public void setChantier(Chantier chantier) {
        this.chantier = chantier;
    }

    @Override
    public String toString() {
        return "Localisation{" +
                "id=" + id +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", engin=" + engin +
                '}';
    }

}
