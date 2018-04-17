package com.example.demo.entities;

import com.example.demo.entities.Engin.Engin;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity

public class Localisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Float latitude, longitude;


    @OneToOne(fetch = FetchType.EAGER,
            //cascade = CascadeType.REMOVE,
          //  cascade = CascadeType.REMOVE,orphanRemoval = true,
            mappedBy = "localisation")
    private Engin engin;

    @OneToOne(fetch = FetchType.EAGER,
            //cascade = CascadeType.ALL,
            mappedBy = "localisation")
    private Chantier chantier;

    public Localisation(Float latitude, Float longitude) {
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

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
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
