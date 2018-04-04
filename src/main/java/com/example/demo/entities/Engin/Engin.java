package com.example.demo.entities.Engin;




import com.example.demo.entities.Localisation;

import javax.persistence.*;
import java.util.Collection;

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

    @OneToMany(mappedBy = "engin")
    private Collection<Assurance> assurances;

    @OneToMany(mappedBy = "engin")
    private Collection<Reparation> reparations;

    @OneToMany(mappedBy = "engin")
    private Collection<Taxe> taxes;

    @OneToMany(mappedBy = "engin")
    private Collection<Vidange> vidanges;

    @OneToMany(mappedBy = "engin")
    private Collection<Visite> visites;



    @OneToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "localisation_id", nullable = false)
    private Localisation localisation;

    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "localisation_id", nullable = false)
    private TypeEngin typeEngin;

    public TypeEngin getTypeEngin() {
        return typeEngin;
    }

    public void setTypeEngin(TypeEngin typeEngin) {
        this.typeEngin = typeEngin;
    }

    public Collection<Assurance> getAssurances() {
        return assurances;
    }

    public void setAssurances(Collection<Assurance> assurances) {
        this.assurances = assurances;
    }

    public Collection<Reparation> getReparations() {
        return reparations;
    }

    public void setReparations(Collection<Reparation> reparations) {
        this.reparations = reparations;
    }

    public Collection<Taxe> getTaxes() {
        return taxes;
    }

    public void setTaxes(Collection<Taxe> taxes) {
        this.taxes = taxes;
    }

    public Collection<Vidange> getVidanges() {
        return vidanges;
    }

    public void setVidanges(Collection<Vidange> vidanges) {
        this.vidanges = vidanges;
    }

    public Collection<Visite> getVisites() {
        return visites;
    }

    public void setVisites(Collection<Visite> visites) {
        this.visites = visites;
    }

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
