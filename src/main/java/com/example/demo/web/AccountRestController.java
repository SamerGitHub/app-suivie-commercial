package com.example.demo.web;


import com.example.demo.dao.UserRepository;

import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
import com.example.demo.entities.Engin.TypeEngin;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
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



    @PostMapping("/user/update/tokenDevice")
    public String updateDeviceToken(@RequestBody AppUser appUser) {
        System.out.println("username ::"+appUser.getUsername());
        System.out.println("tokenDevice ::"+appUser.getDeviceToken());



      accountService.updateDeviceToken(appUser.getUsername(),appUser.getDeviceToken());

            return "update succes";


    }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        System.out.println("id:::::::::::" + id);
        accountService.deleteUser(id);

    }

    @PostMapping("/registerRole")
    public AppUser registerwithrole(@RequestBody RegisterForm form) {
        System.out.println(form.toString());
        if (!form.getPassword().equals(form.getRepassword()))
            throw new RuntimeException("you must confirm password");
        AppUser app = accountService.findUserByUsername(form.getUsername());
        if (app != null) throw new RuntimeException("this is already exist");

        if (form.getRoles()== null ||  form.getRoles().size() == 0) throw new RuntimeException("Il faut choisir au minimum un rôle");

        if(form.isConducteur()) {
            if(form.getTypeEngins() ==null || form.getTypeEngins().size()==0)  throw new RuntimeException("Il faut choisir au minimum un type engin pour ce conducteur");
        }


        AppUser appUser = new AppUser();

        appUser.setUsername(form.getUsername());
        appUser.setPassword(form.getPassword());
        appUser.setEmail(form.getEmail());
        appUser.setTel(form.getTel());
        appUser.setNom(form.getNom());
        appUser.setPrenom(form.getPrenom());

       AppUser newUser= accountService.saveUser(appUser);

        for (AppRole a : form.getRoles()) {
            System.out.println("role: " + a.getRoleName());
            accountService.addRoleToUser(appUser.getUsername(), a.getRoleName());
        }

        if(form.isConducteur()){
            for (TypeEngin t : form.getTypeEngins()) {
                System.out.println("typeEngin: " + t.getType());
                accountService.addTypeEnginIdToConducteurId(t.getId(),newUser.getId());
            }

        }


        return appUser;
    }

    @PutMapping("/updateUser")
    public int updateUser(@RequestBody RegisterForm form) {
        System.out.println(form.toString());

        if (form.getId() != null && form.getUsername() != null && form.getRoles()!=null) {

            if (form.getRoles().size() == 0) throw new RuntimeException("Il faut choisir au minimum un rôle");

            AppUser appUOld = accountService.findUserById(form.getId());
            AppUser app = accountService.findUserByUsername(form.getUsername());
            if (app != null) {
                if (appUOld.getId() != app.getId()) throw new RuntimeException("this username is for other user");
            }


            if (form.getPassword() != null && form.getRepassword() != null) {
                if(form.getPassword().equals("")&&form.getRepassword().equals(""))
                {
                    System.out.println("no password donne");
                    AppUser appUserOld = accountService.findUserById(form.getId());

                    AppUser appUserNew = new AppUser(form.getNom(), form.getPrenom(), form.getEmail(), form.getTel(), form.getUsername(), appUserOld.getPassword());
                    appUserNew.setId(form.getId());

                    AppUser updatedUser = accountService.updateUserWithOutCryptPass(appUserNew);
                    if(form.isConducteur()) {
                        if(form.getTypeEngins() ==null || form.getTypeEngins().size()==0)  throw new RuntimeException("Il faut choisir au minimum un type engin pour ce conducteur");

                        for (TypeEngin t : form.getTypeEngins()) {
                            System.out.println("typeEngin: " + t.getId() +" user :: "+form.getId());
                            accountService.addTypeEnginIdToConducteurId(t.getId(),form.getId());
                        }
                    }



                    for (AppRole a : form.getRoles()) {
                        System.out.println("role: " + a.getRoleName());
                        accountService.addRoleToUserId(form.getId(), a.getRoleName());
                    }



                    return 1;
                }else
                {
                    System.out.println("password donne");

                    if (!form.getPassword().equals(form.getRepassword()))
                        throw new RuntimeException("you must confirm password");

                    AppUser appUser = new AppUser(form.getNom(), form.getPrenom(), form.getEmail(), form.getTel(), form.getUsername(), form.getPassword());
                    appUser.setId(form.getId());

                    accountService.saveUser(appUser);

                    if(form.isConducteur()) {
                        if(form.getTypeEngins() ==null || form.getTypeEngins().size()==0)  throw new RuntimeException("Il faut choisir au minimum un type engin pour ce conducteur");

                        for (TypeEngin t : form.getTypeEngins()) {
                            System.out.println("typeEngin: " + t.getType());
                            accountService.addTypeEnginIdToConducteurId(t.getId(),form.getId());
                        }
                    }


                    for (AppRole a : form.getRoles()) {
                        System.out.println("role: " + a.getRoleName());
                        accountService.addRoleToUserId(form.getId(), a.getRoleName());
                    }



                    return 2;

                }



            }else {
                System.out.println("passwod ou repass null");
                return 0;
        }

        }else {

            throw new RuntimeException("Verifiez donner saisie");
        }


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
    @CrossOrigin
    @RequestMapping(value = "/users/secretaire", method = RequestMethod.GET)

    public List<AppUser> getUsersForSecretaire() {


        List<AppUser> listU= userdao.findAll();
        List<AppUser> listS= new ArrayList<>();
        for (AppUser a :listU )
        {
          if(!hasRoleSecOrAdmin(a.getRoles()))
          {
              listS.add(a);
          }
        }
        return listS;
    }
    @CrossOrigin
    @RequestMapping(value = "/users/conducteur/typeEngin/{type}", method = RequestMethod.GET)

    public List<AppUser> getConducteursBytypeEngin(@PathVariable String type) {


        List<AppUser> listU= userdao.findAll();
        List<AppUser> listS= new ArrayList<>();
        for (AppUser a :listU )
        {
            if(conduire(a.getTypeEngins(),type))
            {
                listS.add(a);
            }
        }
        return listS;
    }




    private boolean hasRoleSecOrAdmin(Collection<AppRole> appRoles)
    {
        for(AppRole ap : appRoles)
        {
            if(ap.getRoleName().equals("ADMIN")||ap.getRoleName().equals("SECRETAIRE")){
                return true;
            }
        }
        return false;

    }


    private boolean conduire(Collection<TypeEngin> typeEngins,String typeEngin)
    {
        for(TypeEngin te : typeEngins)
        {
            if(te.getType().equals(typeEngin)){
                return true;
            }
        }
        return false;

    }




}

