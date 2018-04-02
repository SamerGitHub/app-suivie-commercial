package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class ClassEngin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String classificaton;
    private String type;


    @OneToMany(mappedBy = "clasEngin")
    private Collection<Engin> engins;


    public ClassEngin(String classificaton, String type) {
        this.classificaton = classificaton;
        this.type = type;
    }

    public ClassEngin() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassificaton() {
        return classificaton;
    }

    public void setClassificaton(String classificaton) {
        this.classificaton = classificaton;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @JsonIgnore
    public Collection<Engin> getEngins() {
        return engins;
    }

    public void setEngins(Collection<Engin> engins) {
        this.engins = engins;
    }


}
