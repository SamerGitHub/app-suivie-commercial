package com.example.demo.entities.Engin;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Carburant {
    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private Float km;
    private Float prix;

    @ManyToOne(fetch = FetchType.EAGER)
    private Engin engin;
    public Carburant() {

    }
    public Carburant(Date date, Float km, Float prix) {
        this.date = date;
        this.km = km;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getKm() {
        return km;
    }

    public void setKm(Float km) {
        this.km = km;
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
