package com.example.demo.entities.tache;

import com.example.demo.entities.Engin.TypeEngin;
import com.example.demo.entities.LigneCommande;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;



@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "task_type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Livraison.class, name = "Livraison"),
        @JsonSubTypes.Type(value = CreuseEtFondation.class, name = "CreuseEtFondation"),
        @JsonSubTypes.Type(value = Remblaiment.class, name = "Remblaiment")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "task_type")
public abstract class Task  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private TypeEngin typeEngin;

    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeb;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;

    @Column(insertable=false,updatable = false)
    private String task_type;


    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "task")
    private Collection<LigneCommande> ligneCommandes;






    public Task(TypeEngin typeEngin, String status, Date dateDeb, Date dateFin) {
        this.typeEngin = typeEngin;
        this.status = status;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
    }

    public TypeEngin getTypeEngin() {
        return typeEngin;
    }

    public void setTypeEngin(TypeEngin typeEngin) {
        this.typeEngin = typeEngin;
    }

    public Task(String status, Date dateDeb, Date dateFin) {
        this.status = status;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;

    }

    public Task() {
    }

    public String getTask_type() {
        return task_type;
    }

    public void setTask_type(String task_type) {
        this.task_type = task_type;
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", typeEngin=" + typeEngin +
                ", status='" + status + '\'' +
                ", dateDeb=" + dateDeb +
                ", dateFin=" + dateFin +

                '}';
    }
}
