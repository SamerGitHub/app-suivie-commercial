package com.example.demo.entities.Engin;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class ClassEngin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String classification;


    @JsonIgnore
    @OneToMany(mappedBy = "clasEngin")
    private Collection<TypeEngin> typeEngins;
/*
    @OneToMany(mappedBy = "clasEngin")
    private Collection<Engin> engins;
*/

    public ClassEngin(String classification) {
        this.classification = classification;

    }

    public ClassEngin() {

    }

    public Collection<TypeEngin> getTypeEngins() {
        return typeEngins;
    }

    public void setTypeEngins(Collection<TypeEngin> typeEngins) {
        this.typeEngins = typeEngins;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classificaton) {
        this.classification = classificaton;
    }



/*
    @JsonIgnore
    public Collection<Engin> getEngins() {
        return engins;
    }

    public void setEngins(Collection<Engin> engins) {
        this.engins = engins;
    }

*/
}
