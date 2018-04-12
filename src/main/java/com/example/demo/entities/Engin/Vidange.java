package com.example.demo.entities.Engin;



import javax.persistence.*;
import java.util.Date;

@Entity
public class Vidange {

    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private String huile ;
    @Temporal(TemporalType.DATE)
    private Date dateVidange;
    private Float prix;
    private String description;


    @ManyToOne(fetch = FetchType.EAGER)
    private Engin engin;

    public Vidange() {
    }

    public Vidange(String type, String huile, Date dateVidange, Float prix, String description) {
        this.type = type;
        this.huile = huile;
        this.dateVidange = dateVidange;
        this.prix = prix;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
