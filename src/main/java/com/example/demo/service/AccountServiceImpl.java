package com.example.demo.service;

import javax.transaction.Transactional;

import com.example.demo.dao.Engin.TypeEnginRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
import com.example.demo.entities.Engin.TypeEngin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    //deja @bean ds class application intialisé je peux l'utiliser n'importe ou
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private TypeEnginRepository typeEnginRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        //on va faire le hashage du code
        String hash = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hash);

        // TODO Auto-generated method stub
        return userRepository.save(user);
    }

    @Override
    public AppUser updateUserWithOutCryptPass(AppUser user) {
        return userRepository.save(user);
    }

    @Override
    public AppUser findUserById(Long id) {
       return userRepository.getAppUserById(id);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        // TODO Auto-generated method stub
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppRole appRole = roleRepository.findRoleByRoleName(roleName);
        AppUser appUser = userRepository.findByUsername(username);
        appUser.getRoles().add(appRole);
    }

    @Override
    public void addRoleToUserId(Long id, String roleName) {
        AppRole appRole = roleRepository.findRoleByRoleName(roleName);
        AppUser appUser = userRepository.getAppUserById(id);
        appUser.getRoles().add(appRole);
    }

    @Override
    public AppUser findUserByUsername(String username) {
        // TODO Auto-generated method stub
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void addTypeEnginIdToConducteurId(Long idTypeEngin, Long idConducteur) {
        TypeEngin typeEngin1 = typeEnginRepository.getTypeEnginById(idTypeEngin);
        AppUser appUser = userRepository.getAppUserById(idConducteur);

        System.out.println("Useeeeeeeeeeeeeeeeer :"+appUser.getId());

        appUser.getTypeEngins().add(typeEngin1);
    }

    @Override
    public void addTypeEnginToConducteur(String username, String typeEngin) {
        TypeEngin typeEngin1 = typeEnginRepository.findTypeEnginByType(typeEngin);
        AppUser appUser = userRepository.findByUsername(username);
        appUser.getTypeEngins().add(typeEngin1);
    }

    @Override
    public void addTypeEnginToConducteurId(Long id, String typeEngin) {
        TypeEngin typeEngin1 = typeEnginRepository.findTypeEnginByType(typeEngin);
        AppUser appUser = userRepository.getAppUserById(id);
        appUser.getTypeEngins().add(typeEngin1);
    }



}
