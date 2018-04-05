package com.example.demo.entities.Engin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vidange {

    @Id
    @GeneratedValue
    private Long id;
    private String huile ;
    @Temporal(TemporalType.DATE)
    private Date dateVidange;
    private Float prix;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Engin engin;

    public Vidange() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHuile() {
        return huile;
    }

    public void setHuile(String huile) {
        this.huile = huile;
    }

    public Date getDateVidange() {
        return dateVidange;
    }

    public void setDateVidange(Date dateVidange) {
        this.dateVidange = dateVidange;
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
