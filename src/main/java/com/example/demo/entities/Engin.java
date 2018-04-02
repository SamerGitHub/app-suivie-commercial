package com.example.demo.entities;




import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.Constraint;

@Entity

public class Engin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String matricule;
    private String marque;
    private String modele;
    private String status;

    //meme nom d'attribut ClassEngin clasEngin;

    @ManyToOne(fetch = FetchType.EAGER)
    private ClassEngin clasEngin;



    @OneToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "localisation_id", nullable = false)
    private Localisation localisation;


    public Engin() {

    }

    public Engin(String matricule, String marque, String modele, String status) {
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.status = status;


    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public ClassEngin getClasEngin() {
        return clasEngin;
    }

    public void setClasEngin(ClassEngin clasEngin) {
        this.clasEngin = clasEngin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
