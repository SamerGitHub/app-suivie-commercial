package com.example.demo.entities.Engin;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class ClassEngin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String classificaton;


    @JsonIgnore
    @OneToMany(mappedBy = "clasEngin")
    private Collection<TypeEngin> typeEngins;
/*
    @OneToMany(mappedBy = "clasEngin")
    private Collection<Engin> engins;
*/

    public ClassEngin(String classificaton) {
        this.classificaton = classificaton;

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

    public String getClassificaton() {
        return classificaton;
    }

    public void setClassificaton(String classificaton) {
        this.classificaton = classificaton;
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
