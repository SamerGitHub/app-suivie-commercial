package com.example.demo.entities.tache;


import com.example.demo.entities.Engin.TypeEngin;
import com.example.demo.entities.Produit;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Livraison extends Task {



    private boolean par_Voyage;

    private Float quantite;

    @ManyToOne(fetch = FetchType.EAGER)
    private Produit produit;


    public Livraison() {

    }

    public Livraison(TypeEngin typeEngin, String status, Date dateDeb, Date dateFin, boolean par_Voyage, Float quantite, Produit produit) {
        super(typeEngin, status, dateDeb, dateFin);
        this.par_Voyage = par_Voyage;
        this.quantite = quantite;
        this.produit = produit;
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
