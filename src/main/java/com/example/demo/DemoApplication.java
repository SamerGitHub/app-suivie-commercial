package com.example.demo;

import com.example.demo.dao.ClassEnginRepository;
import com.example.demo.dao.EnginRepository;
import com.example.demo.dao.LocalisationRepository;
import com.example.demo.dao.TaskRepository;
import com.example.demo.entities.*;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private LocalisationRepository localisationRepository;
    @Autowired
    private EnginRepository enginRepository;
    @Autowired
    private ClassEnginRepository classEnginRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {

        Stream.of("t1", "t2", "t3").forEach(t -> {
            taskRepository.save(new Task(null, t));
        });

        taskRepository.findAll().forEach(t -> {
            System.out.println(t.getTaskName());

        });
        accountService.saveUser(new AppUser(null, "admin", "1234", null));
        accountService.saveUser(new AppUser(null, "user", "1234", null));
        accountService.saveUser(new AppUser(null, "slim", "1234", null));

        accountService.saveRole(new AppRole(null, "ADMIN"));
        accountService.saveRole(new AppRole(null, "USER"));
        accountService.saveRole(new AppRole(null, "CONDUCTEUR"));
        accountService.saveRole(new AppRole(null, "COMMERCIAL"));

        accountService.addRoleToUser("admin", "ADMIN");
        accountService.addRoleToUser("admin", "USER");
        accountService.addRoleToUser("user", "USER");
        accountService.addRoleToUser("slim", "CONDUCTEUR");

        // accountService.deleteUser(6l);

        ClassEngin ce = classEnginRepository.save(new ClassEngin("Engins de transports", "Camion"));
        Engin e = new Engin("mat", "marq", "mod", "status");
        Localisation l = localisationRepository.save(new Localisation("11", "22"));
        e.setClasEngin(ce);
        e.setLocalisation(l);
        Engin e1 = enginRepository.save(e);
/*
        enginRepository.deleteById(e1.getId());

        System.out.println("main ::::  After delete engin");

        localisationRepository.delete(e1.getLocalisation());

        System.out.println("main ::::  After delete localisation");
       */


        classEnginRepository.save(new ClassEngin("Engins de transports", "Poids Lourd"));
        classEnginRepository.save(new ClassEngin("Engins de transports", "Semi Remorque"));


        classEnginRepository.save(new ClassEngin("Engins de chargements", "chargeuses sur pneus"));
        classEnginRepository.save(new ClassEngin("Engins de chargements", "chargeuses sur chenilles"));
        classEnginRepository.save(new ClassEngin("Engins de chargements", "Chargeuse-pelleteuse"));

        classEnginRepository.save(new ClassEngin("Engins extractions", "pelles sur chenilles"));
        classEnginRepository.save(new ClassEngin("Engins extractions", "pelles sur pneus"));


        classEnginRepository.save(new ClassEngin("Engins de betons", "Camion malaxeur (toupie)"));
        classEnginRepository.save(new ClassEngin("Engins de betons", "Pompe a beton automotrice"));




/*
        Engin e1 =new Engin("mat1","marq1","mod1","stat1");
        Localisation l1=new Localisation("lang1","long1");
        ClassEngin ce1=new ClassEngin("class1","type1");
        l1.setEngin(e1);
        e1.setLocalisation(l1);
        e1.setClasEngin(ce1);

        enginRepository.save(e1);


        Engin e2 =new Engin("mat2","marq2","mod2","stat2");
        Localisation l2=new Localisation("lang2","long2");
        ClassEngin ce2=new ClassEngin("class2","type2");
        classEnginRepository.save(ce2);
        l2.setEngin(e2);
        e2.setLocalisation(l2);
        e2.setClasEngin(ce2);
         enginRepository.save(e2);
*/


    }

    //bean application toute les methode vont excuter  peut les utiliser n'importe ou il faut le metre dans la  class elle-meme
    @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }
}

