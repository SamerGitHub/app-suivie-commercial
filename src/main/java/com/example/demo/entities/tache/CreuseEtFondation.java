package com.example.demo.entities.tache;

import com.example.demo.entities.Engin.TypeEngin;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class CreuseEtFondation extends Task {

  private Float nbrHeure;

    public CreuseEtFondation() {
    }

    public CreuseEtFondation(TypeEngin typeEngin, String status, Date dateDeb, Date dateFin, Float nbrHeure) {
        super(typeEngin, status, dateDeb, dateFin);
        this.nbrHeure = nbrHeure;
    }
}
