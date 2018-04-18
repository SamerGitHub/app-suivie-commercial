package com.example.demo.entities.tache;


import com.example.demo.entities.Produit;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Livraison extends Task {

    private String typeEngin;

    private boolean par_Voyage;

    private Float quantite;

    @ManyToOne(fetch = FetchType.EAGER)
    private Produit produit;


    public Livraison() {

    }

    public Livraison(String status, Date dateDeb, Date dateFin, String taskName, String typeEngin, boolean par_Voyage, Float quantite, Produit produit) {
        super(status, dateDeb, dateFin, taskName);
        this.typeEngin = typeEngin;
        this.par_Voyage = par_Voyage;
        this.quantite = quantite;
        this.produit = produit;
    }

    public String getTypeEngin() {
        return typeEngin;
    }

    public void setTypeEngin(String typeEngin) {
        this.typeEngin = typeEngin;
    }

    public boolean isPar_Voyage() {
        return par_Voyage;
    }

    public void setPar_Voyage(boolean par_Voyage) {
        this.par_Voyage = par_Voyage;
    }

    public Float getQuantite() {
        return quantite;
    }

    public void setQuantite(Float quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
