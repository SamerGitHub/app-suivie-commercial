package com.example.demo.service;

import javax.transaction.Transactional;

import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
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

    @Override
    public AppUser saveUser(AppUser user) {
        //on va faire le hashage du code
        String hash = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hash);

        // TODO Auto-generated method stub
        return userRepository.save(user);
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
    public AppUser findUserByUsername(String username) {
        // TODO Auto-generated method stub
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
