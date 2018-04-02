package com.example.demo.web;


import com.example.demo.dao.UserRepository;

import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;


@RestController
@CrossOrigin
public class AccountRestController {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AccountService accountService;

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id)
    {
           System.out.println("id:::::::::::"+id);
           accountService.deleteUser(id);

    }

    @PostMapping("/registerRole")
    public AppUser registerwithrole(@RequestBody RegisterForm form) {
        System.out.println(form.toString());
        if (!form.getPassword().equals(form.getRepassword()))
            throw new RuntimeException("you must confirm");
        AppUser app = accountService.findUserByUsername(form.getUsername());
        if (app != null) throw new RuntimeException("this is already exist");

        AppUser appUser = new AppUser();

        appUser.setUsername(form.getUsername());
        appUser.setPassword(form.getPassword());

        accountService.saveUser(appUser);
/*
        Stream.of(form.getRoles()).forEach(a->
        {

            a.forEach(r->
            {
                System.out.println("r:"+r.getRoleName());
            });
        });
*/
        for (AppRole a : form.getRoles()) {
            System.out.println("role: " + a.getRoleName());
            accountService.addRoleToUser(appUser.getUsername(), a.getRoleName());
        }


        return appUser;
    }

    @PostMapping("/register")
    public AppUser register(@RequestBody RegisterForm form) {
        if (!form.getPassword().equals(form.getRepassword()))
            throw new RuntimeException("you must confirm");
        AppUser app = accountService.findUserByUsername(form.getUsername());
        if (app != null) throw new RuntimeException("this is already exist");

        AppUser appUser = new AppUser();
        appUser.setUsername(form.getUsername());

        appUser.setPassword(form.getPassword());
        //AppUser appUser=new AppUser(null,form.getUsername(),null,form.getPassword());
        return accountService.saveUser(appUser);
    }

    @Autowired
    UserRepository userdao;

    @CrossOrigin
    @RequestMapping(value = "/userL", method = RequestMethod.GET)

    public AppUser getUser() {


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        AppUser use2r = userdao.findByUsername(loggedUsername);


        return use2r;
    }

    @CrossOrigin

    @RequestMapping(value = "/users", method = RequestMethod.GET)

    public List<AppUser> getUsers() {



        //   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //  String loggedUsername = auth.getName();
        // AppUser use2r = userdao.findByUsername(loggedUsername);

    /*    List<AppUser> lappu=userdao.findAll();
       for(AppUser a:lappu)
       {
            a.setPassword(bCryptPasswordEncoder.);
       }*/

        return userdao.findAll();
    }


}
