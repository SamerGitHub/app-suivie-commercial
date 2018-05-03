package com.example.demo.service;


import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(AppUser user);

    public AppUser updateUserWithOutCryptPass(AppUser user);

    public AppUser findUserById(Long id);

    public AppRole saveRole(AppRole role);

    public void addRoleToUser(String username, String roleName);

    public void addRoleToUserId(Long id, String roleName);

    public AppUser findUserByUsername(String username);

    public void deleteUser(Long id);


    public void addTypeEnginIdToConducteurId(Long idTypeEngin, Long idConducteur);

    public void addTypeEnginToConducteur(String username, String typeEngin);

    public void addTypeEnginToConducteurId(Long id, String typeEngin);
}
