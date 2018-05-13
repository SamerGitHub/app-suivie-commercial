package com.example.demo.entities.Engin;




import com.example.demo.entities.AvoirEnginConducteur;
import com.example.demo.entities.Localisation;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Set;

@Entity

public class Engin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true,nullable = false)
    private String matricule;
    private String status;
    private String photo;

    @JsonIgnore
    @OneToMany(mappedBy = "engin", cascade = CascadeType.ALL)
    private Collection<Assurance> assurances;
    @JsonIgnore
    @OneToMany(mappedBy = "engin", cascade = CascadeType.ALL)
    private Collection<Reparation> reparations;
    @JsonIgnore
    @OneToMany(mappedBy = "engin", cascade = CascadeType.ALL)
    private Collection<Taxe> taxes;
    @JsonIgnore
    @OneToMany(mappedBy = "engin", cascade = CascadeType.ALL)
    private Collection<Vidange> vidanges;
    @JsonIgnore
    @OneToMany(mappedBy = "engin",cascade = CascadeType.ALL)
    private Collection<Visite> visites;
    @JsonIgnore
    @OneToMany(mappedBy = "engin",cascade = CascadeType.ALL)
    private Collection<Carburant> carburants;


    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE,
            mappedBy = "engin")
    private Set<AvoirEnginConducteur> avoirEnginConducteurs;


    @OneToOne(//fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    //@JoinColumn(name = "localisation_id", nullable = false)
    private Localisation localisation;

    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "localisation_id", nullable = false)
    private Modele modele;

    public Engin() {

    }

    public Engin(String matricule, String status) {
        this.matricule = matricule;
        this.status = status;
    }

    public Engin(String matricule, String status,String photo, Localisation localisation, Modele modele) {
        this.matricule = matricule;
        this.status = status;
        this.localisation = localisation;
        this.modele = modele;
        this.photo=photo;
    }


    public Set<AvoirEnginConducteur> getAvoirEnginConducteurs() {
        return avoirEnginConducteurs;
    }

    public void setAvoirEnginConducteurs(Set<AvoirEnginConducteur> avoirEnginConducteurs) {
        this.avoirEnginConducteurs = avoirEnginConducteurs;
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

    public Collection<Carburant> getCarburants() {
        return carburants;
    }

    public void setCarburants(Collection<Carburant> carburants) {
        this.carburants = carburants;
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

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
