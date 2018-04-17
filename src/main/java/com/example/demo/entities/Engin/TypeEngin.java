package com.example.demo.entities.Engin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class TypeEngin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "typeEngin")
    private Collection<Marque> marques;

    @ManyToOne(fetch = FetchType.EAGER)
    private ClassEngin clasEngin;



    public TypeEngin(String type) {
        this.type=type;
    }

    public TypeEngin(String type, ClassEngin clasEngin) {
        this.type = type;
        this.clasEngin = clasEngin;
    }

    public TypeEngin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public ClassEngin getClasEngin() {
        return clasEngin;
    }

    public void setClasEngin(ClassEngin clasEngin) {
        this.clasEngin = clasEngin;
    }
}
