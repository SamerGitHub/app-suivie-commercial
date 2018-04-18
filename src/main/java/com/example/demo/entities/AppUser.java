package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity

public class AppUser {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles = new ArrayList<>();


  // @LazyCollection(LazyCollectionOption.FALSE)
   @JsonIgnore
   @OneToMany(//fetch = FetchType.EAGER,
           cascade = CascadeType.REMOVE,
            mappedBy = "user")
    private Collection<Commande> commandes;;

    public AppUser() {

        // TODO Auto-generated constructor stub
    }


    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //quand on va le recuperer il ignore

   // @JsonIgnore

    public String getPassword() {
        return password;
    }

    @JsonSetter
    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }

    public AppUser(Long id, String username, String password, Collection<AppRole> roles) {

        this.id = id;
        this.username = username;

        this.password = password;
        this.roles = roles;
    }

}
