package com.example.demo.entities.tache;

import com.example.demo.entities.Engin.TypeEngin;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Remblaiment extends Task {


    private Float nbrHeure;



    public Remblaiment(TypeEngin typeEngin, String status, Date dateDeb, Date dateFin, Float nbrHeure) {
        super(typeEngin, status, dateDeb, dateFin);
        this.nbrHeure = nbrHeure;
    }

    public Remblaiment() {
    }

    public Float getNbrHeure() {
        return nbrHeure;
    }

    public void setNbrHeure(Float nbrHeure) {
        this.nbrHeure = nbrHeure;
    }
}
