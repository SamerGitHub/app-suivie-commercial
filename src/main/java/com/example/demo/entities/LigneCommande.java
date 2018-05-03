package com.example.demo.entities;

import com.example.demo.entities.tache.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
public class LigneCommande {
    @Id
    @GeneratedValue
    private Long id;

    private String designation;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Commande commande;

   //@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "id")
    @ManyToOne(fetch = FetchType.EAGER,
           cascade = CascadeType.ALL)
    private Task task;


    public LigneCommande() {

    }

    public LigneCommande(Commande commande, Task task) {
        this.commande = commande;
        this.task = task;
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
