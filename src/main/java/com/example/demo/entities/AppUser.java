package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.example.demo.entities.Engin.TypeEngin;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity

public class AppUser {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String tel;

    @Column(unique = true)
    private String username;

    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<TypeEngin> typeEngins = new HashSet<TypeEngin>();;


  // @LazyCollection(LazyCollectionOption.FALSE)
   @JsonIgnore
   @OneToMany(//fetch = FetchType.EAGER,
           cascade = CascadeType.REMOVE,
            mappedBy = "user")
    private Collection<Commande> commandes;;

    public AppUser() {

        // TODO Auto-generated constructor stub
    }

    public AppUser(Long id, String username, String password, Collection<AppRole> roles) {

        this.id = id;
        this.username = username;

        this.password = password;
        this.roles = roles;
    }

    public AppUser(String nom, String prenom, String email, String tel, String username, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.username = username;
        this.password = password;
    }


    public Set<TypeEngin> getTypeEngins() {
        return typeEngins;
    }

    public void setTypeEngins(Set<TypeEngin> typeEngins) {
        this.typeEngins = typeEngins;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

   @JsonIgnore
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



}
