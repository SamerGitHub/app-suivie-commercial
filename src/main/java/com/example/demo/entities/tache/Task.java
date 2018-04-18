package com.example.demo.entities.tache;

import com.example.demo.entities.LigneCommande;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "task_type")
public abstract class Task  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeb;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;

    private String taskName;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "task")
    private Collection<LigneCommande> ligneCommandes;



    public Task(Long id, String taskName) {
        this.id=id;
        this.taskName = taskName;
    }
    public Task() {

    }

    public Task(String status, Date dateDeb, Date dateFin, String taskName) {
        this.status = status;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.taskName = taskName;
    }


    public Collection<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(Collection<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
