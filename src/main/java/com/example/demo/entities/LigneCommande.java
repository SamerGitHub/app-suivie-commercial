package com.example.demo.entities;

import com.example.demo.entities.tache.Task;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;



@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class LigneCommande {
    @Id
    @GeneratedValue
    private Long id;

    private String designation;

    private String status;

 //   @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Commande commande;

   //@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "id")
    @ManyToOne(fetch = FetchType.EAGER,
           cascade = CascadeType.ALL)
    private Task task;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE,
            mappedBy = "ligneCommande")
    private Set<AvoirEnginConducteur> avoirEnginConducteurs;


  //  @Column(insertable=false,updatable = false)
   @Transient
    private AvoirEnginConducteur avoirEnginConducteur;

    public LigneCommande() {

    }

    public Set<AvoirEnginConducteur> getAvoirEnginConducteurs() {
        return avoirEnginConducteurs;
    }

    public void setAvoirEnginConducteurs(Set<AvoirEnginConducteur> avoirEnginConducteurs) {
        this.avoirEnginConducteurs = avoirEnginConducteurs;
    }

    public AvoirEnginConducteur getAvoirEnginConducteur() {
        return avoirEnginConducteur;
    }

    public void setAvoirEnginConducteur(AvoirEnginConducteur avoirEnginConducteur) {
        this.avoirEnginConducteur = avoirEnginConducteur;
    }

    public LigneCommande(Commande commande, Task task, String status ,String designation) {
        this.commande = commande;
        this.task = task;
        this.status=status;
        this.designation=designation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "LigneCommande{" +
                "id=" + id +

                ", task=" + task +
                '}';
    }
}
