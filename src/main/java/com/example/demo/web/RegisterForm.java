package com.example.demo.web;


import com.example.demo.entities.AppRole;

import java.util.Collection;

public class RegisterForm {

    private String username;

    private String password;

    private String repassword;

    private Collection<AppRole> roles;

    public Collection<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }


    @Override
    public String toString() {
        return "RegisterForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", repassword='" + repassword + '\'' +
                ", roles=" + roles +
                '}';
    }
}
