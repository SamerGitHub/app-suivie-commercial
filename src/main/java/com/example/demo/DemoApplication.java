package com.example.demo;

import com.example.demo.dao.Engin.ClassEnginRepository;
import com.example.demo.dao.Engin.EnginRepository;
import com.example.demo.dao.Engin.TypeEnginRepository;
import com.example.demo.dao.LocalisationRepository;
import com.example.demo.dao.TaskRepository;
import com.example.demo.entities.*;
import com.example.demo.entities.Engin.ClassEngin;
import com.example.demo.entities.Engin.Engin;
import com.example.demo.entities.Engin.TypeEngin;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;
//firas

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private TypeEnginRepository typeEnginRepository;
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

        ClassEngin ce1 = classEnginRepository.save(new ClassEngin("Engins de transports"));
        ClassEngin ce2 = classEnginRepository.save(new ClassEngin("Engins de chargements"));
        ClassEngin ce3 = classEnginRepository.save(new ClassEngin("Engins extractions"));
        ClassEngin ce4 = classEnginRepository.save(new ClassEngin("Engins de betons"));

        TypeEngin te1=new TypeEngin("camion");TypeEngin te2=new TypeEngin("Poids Lourd");TypeEngin te3=new TypeEngin("Semi Remorque");
        te1.setClasEngin(ce1);
        te2.setClasEngin(ce1);
        te3.setClasEngin(ce1);
        typeEnginRepository.save(te1);typeEnginRepository.save(te2);typeEnginRepository.save(te2);


        TypeEngin te4=new TypeEngin("chargeuses sur pneus");TypeEngin te5=new TypeEngin("chargeuses sur chenilles");TypeEngin te6=new TypeEngin("chargeuse-pelleteuse");
        te4.setClasEngin(ce2);
        te5.setClasEngin(ce2);
        te6.setClasEngin(ce2);
        typeEnginRepository.save(te4);typeEnginRepository.save(te5);typeEnginRepository.save(te6);


        TypeEngin te7=new TypeEngin("pelles sur chenilles");TypeEngin te8=new TypeEngin("pelles sur pneus");
        te7.setClasEngin(ce3);
        te8.setClasEngin(ce3);
        typeEnginRepository.save(te7);typeEnginRepository.save(te8);

        TypeEngin te9=new TypeEngin("Camion malaxeur (toupie)");TypeEngin te10=new TypeEngin("Pompe a beton automotrice");
        te9.setClasEngin(ce4);
        te10.setClasEngin(ce4);
        typeEnginRepository.save(te9);typeEnginRepository.save(te10);

        Engin e1 = new Engin("163TU4773", "Volvo", "200", "EnMission");
        Engin e2 = new Engin("101TU9108", "Scania", "102", "EnPanne");
        Engin e3 = new Engin("7465", "Catterpillar", "428E", "Disponible");
        Engin e4 = new Engin("8465", "Catterpillar", "428C", "Disponible");

        Localisation l = localisationRepository.save(new Localisation(35.894761f, 10.594485f));
        Localisation l2 = localisationRepository.save(new Localisation(35.236115f, 10.649798f));
        Localisation l3 = localisationRepository.save(new Localisation(35.868934f, 10.585955f));
        Localisation l4 = localisationRepository.save(new Localisation(35.868934f, 10.585955f));

        e1.setTypeEngin(te1);e2.setTypeEngin(te2);e3.setTypeEngin(te6);e4.setTypeEngin(te6);
        e1.setLocalisation(l);e2.setLocalisation(l2); e3.setLocalisation(l3);e4.setLocalisation(l4);
        enginRepository.save(e1);enginRepository.save(e2); enginRepository.save(e3);enginRepository.save(e4);




/*
        enginRepository.deleteById(e1.getId());

        System.out.println("main ::::  After delete engin");

        localisationRepository.delete(e1.getLocalisation());

        System.out.println("main ::::  After delete localisation");
       */







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

