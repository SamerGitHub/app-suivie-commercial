package com.example.demo;

import com.example.demo.dao.*;
import com.example.demo.dao.Engin.*;
import com.example.demo.dao.tache.*;
import com.example.demo.entities.*;
import com.example.demo.entities.Engin.*;
import com.example.demo.entities.tache.CreuseEtFondation;
import com.example.demo.entities.tache.Livraison;
import com.example.demo.entities.tache.Task;
import com.example.demo.entities.tache.TaskType;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Stream;
//firas

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private AvoirEnginConducteurRepository avoirEnginConducteurRepository;
    @Autowired
    private TaskTypeRepository taskTypeRepository;
    @Autowired
    private CompagnieAssuranceRepository compagnieAssuranceRepository;
    @Autowired
    private ChantierRepository chantierRepository;
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private LivraisonRepository livraisonRepository;
    @Autowired
    private RemblaimentRepository remblaimentRepository;
    @Autowired
    private CreuseEtFondationRepository creuseEtFondationRepository;
    @Autowired
    private PieceRepository pieceRepository;
    @Autowired
    private LigneReparationRepository ligneReparationRepository;
    @Autowired
    private MarqueRepository marqueRepository;
    @Autowired
    private ModeleRepository modeleRepository;
    @Autowired
    private ReparationRepository reparationRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private VidangeRepository vidangeRepository;
    @Autowired
    private AssuranceRepository assuranceRepository;
    @Autowired
    private VisiteRepository visiteRepository;
    @Autowired
    private TaxeRepository taxeRepository;
    @Autowired
    private TypeEnginRepository typeEnginRepository;
    @Autowired
    private LocalisationRepository localisationRepository;
    @Autowired
    private EnginRepository enginRepository;
    @Autowired
    private ClassEnginRepository classEnginRepository;
    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {

        /*
        Stream.of("t1", "t2", "t3").forEach(t -> {
            taskRepository.save(new Task(null, t) {
            });
        });

        taskRepository.findAll().forEach(t -> {
            System.out.println(t.getTaskName());

        });*/

        taskTypeRepository.save(new TaskType("Livraison", "Livraison", true));
        taskTypeRepository.save(new TaskType("CreuseEtFondation", "Creuse et fondation", true));
        taskTypeRepository.save(new TaskType("Location", "Location d'engin", false));
        taskTypeRepository.save(new TaskType("NettoyageTerrain", "Nettoyage de terrain", false));

        ClassEngin ce1 = classEnginRepository.save(new ClassEngin("Engins de transports"));
        ClassEngin ce2 = classEnginRepository.save(new ClassEngin("Engins de chargements"));
        ClassEngin ce3 = classEnginRepository.save(new ClassEngin("Engins extractions"));
        ClassEngin ce4 = classEnginRepository.save(new ClassEngin("Engins de betons"));


        TypeEngin te1 = new TypeEngin("camion");
        TypeEngin te2 = new TypeEngin("Poids Lourd");
        TypeEngin te3 = new TypeEngin("Semi Remorque");
        te1.setClasEngin(ce1);
        te2.setClasEngin(ce1);
        te3.setClasEngin(ce1);

        TypeEngin teR1 = typeEnginRepository.save(te1);
        TypeEngin teR2 = typeEnginRepository.save(te2);
        TypeEngin teR3 = typeEnginRepository.save(te3);


        TypeEngin te4 = new TypeEngin("chargeuses sur pneus");
        TypeEngin te5 = new TypeEngin("chargeuses sur chenilles");
        TypeEngin te6 = new TypeEngin("chargeuse-pelleteuse");
        te4.setClasEngin(ce2);
        te5.setClasEngin(ce2);
        te6.setClasEngin(ce2);
        TypeEngin teR4 = typeEnginRepository.save(te4);
        TypeEngin teR5 = typeEnginRepository.save(te5);
        TypeEngin teR6 = typeEnginRepository.save(te6);


        TypeEngin te7 = new TypeEngin("pelles sur chenilles");
        TypeEngin te8 = new TypeEngin("pelles sur pneus");
        te7.setClasEngin(ce3);
        te8.setClasEngin(ce3);
        TypeEngin teR7 = typeEnginRepository.save(te7);
        TypeEngin teR8 = typeEnginRepository.save(te8);

        TypeEngin te9 = new TypeEngin("Camion malaxeur (toupie)");
        TypeEngin te10 = new TypeEngin("Pompe a beton automotrice");
        te9.setClasEngin(ce4);
        te10.setClasEngin(ce4);
        TypeEngin teR9 = typeEnginRepository.save(te9);
        TypeEngin teR10 = typeEnginRepository.save(te10);

        AppUser user1 = accountService.saveUser(new AppUser("hassen", "samer", "hsensamer88@gmail.com", "97885703", "samer", "1234"));
        AppUser user2 = accountService.saveUser(new AppUser("ben abd jalil", "achraf", "achraf_abd_jalil@gmail.com", "95123654", "achraf", "1234"));
        AppUser user3 = accountService.saveUser(new AppUser("eltaief", "mohammed", "mohammed_eltaif@gmail.com", "54156948", "mohammed", "1234"));
        AppUser user4 = accountService.saveUser(new AppUser("arfawi", "ali", "ali_arfawi@gmail.com", "22156348", "ali", "1234"));
        AppUser user5 = accountService.saveUser(new AppUser("slimani", "farhat", "farhat_slimani@gmail.com", "23486127", "farhat", "1234", "dlQ1_pYvCWc:APA91bHCJ_7gZYrStPLMS8PiSahvRm4NYauAAsK1XrN-nYGJBXK-pm_vzjZe7oOk5OuyvIfxEIGfgOxYlDEXG6IG2eN1M951JDWtzw3fB77M33FOsNH1Zsx_RxzXLQ-WblRRHSbZMOcG"));
        AppUser user6 = accountService.saveUser(new AppUser("amar", "lotfi", "lotfi_amar@gmail.com", "98186732", "lotfi", "1234"));
        AppUser user7 = accountService.saveUser(new AppUser("ben haj", "hmed", "hmed_ben_haj@gmail.com", "98255132", "hmed", "1234"));
        AppUser user8 = accountService.saveUser(new AppUser("ben hsine", "rjab", "rjab_ben_hsine@gmail.com", "97331472", "rjab", "1234"));
        AppUser user9 = accountService.saveUser(new AppUser("fekih", "abdallah", "abdallah_fekih@gmail.com", "96662115", "abdallah", "1234"));


        accountService.saveRole(new AppRole(null, "ADMIN"));
        accountService.saveRole(new AppRole(null, "SECRETAIRE"));
        accountService.saveRole(new AppRole(null, "CONDUCTEUR"));
        accountService.saveRole(new AppRole(null, "COMMERCIAL"));
        accountService.saveRole(new AppRole(null, "RESP_DE_PARC"));

        accountService.addRoleToUser("samer", "ADMIN");
        accountService.addRoleToUser("samer", "COMMERCIAL");
        accountService.addRoleToUser("mohammed", "SECRETAIRE");
        accountService.addRoleToUser("achraf", "COMMERCIAL");
        accountService.addRoleToUser("ali", "CONDUCTEUR");
        accountService.addTypeEnginIdToConducteurId(teR6.getId(), user4.getId());
        accountService.addTypeEnginIdToConducteurId(teR2.getId(), user4.getId());
        accountService.addRoleToUser("farhat", "CONDUCTEUR");
        accountService.addTypeEnginIdToConducteurId(teR3.getId(), user5.getId());
        accountService.addRoleToUser("lotfi", "RESP_DE_PARC");
        accountService.addRoleToUser("hmed", "CONDUCTEUR");
        accountService.addTypeEnginIdToConducteurId(teR3.getId(), user7.getId());
        accountService.addRoleToUser("rjab", "CONDUCTEUR");
        accountService.addTypeEnginIdToConducteurId(teR5.getId(), user8.getId());
        accountService.addTypeEnginIdToConducteurId(teR8.getId(), user8.getId());

        accountService.addRoleToUser("abdallah", "CONDUCTEUR");
        accountService.addTypeEnginIdToConducteurId(teR2.getId(), user9.getId());
        // accountService.deleteUser(6l);

       /*  String tokenDevice="d95ND-Zj5Oo:APA91bFrfK-0N4TMDcvo-RnBuM2b_MiV4DV5P6TyblEAoGJQNjxbIhuQyBv1Jklfi01FDnJleZ_bgiAD-d7kgb28OjguqqvVZ-4kztPCNWpML5DO0oHL42QXnID_pyOKNPFN9-V0ZSRx";
         accountService.updateDeviceToken(user5.getUsername(),tokenDevice);
       */

//marque Engin Selon le type d'engin

        Marque mqCat1 = new Marque("Caterpillar");
        Marque mqCat2 = new Marque("Caterpillar");
        Marque mqCat3 = new Marque("Caterpillar");
        Marque mqCat4 = new Marque("Caterpillar");
        Marque mqCat5 = new Marque("Caterpillar");

        mqCat1.setTypeEngin(teR6);
        Marque mqR1 = marqueRepository.save(mqCat1);

        mqCat2.setTypeEngin(teR4);
        Marque mqR2 = marqueRepository.save(mqCat2);

        mqCat3.setTypeEngin(teR5);
        Marque mqR3 = marqueRepository.save(mqCat3);

        mqCat4.setTypeEngin(teR7);
        Marque mqR44 = marqueRepository.save(mqCat4);

        mqCat5.setTypeEngin(teR8);
        Marque mqR45 = marqueRepository.save(mqCat5);


        Marque mq2 = new Marque("Hitachi");

        mq2.setTypeEngin(te6);
        Marque mqR4 = marqueRepository.save(mq2);
        mq2.setTypeEngin(te4);
        Marque mqR5 = marqueRepository.save(mq2);
        mq2.setTypeEngin(te5);
        Marque mqR6 = marqueRepository.save(mq2);

        Marque mqVol1 = new Marque("Volvo");
        Marque mqVol2 = new Marque("Volvo");
        Marque mqVol3 = new Marque("Volvo");

        mqVol1.setTypeEngin(teR3);
        Marque mqR7 = marqueRepository.save(mqVol1);
        mqVol2.setTypeEngin(teR2);
        Marque mqR8 = marqueRepository.save(mqVol2);
        mqVol3.setTypeEngin(te1);
        Marque mqR9 = marqueRepository.save(mqVol3);


        Marque mqHyn1 = new Marque("Hyundai");
        Marque mqHyn2 = new Marque("Hyundai");
        Marque mqHyn3 = new Marque("Hyundai");

        mqHyn1.setTypeEngin(te6);
        Marque mqR10 = marqueRepository.save(mqHyn1);
        mqHyn2.setTypeEngin(te4);
        Marque mqR11 = marqueRepository.save(mqHyn2);
        mqHyn3.setTypeEngin(te5);
        Marque mqR12 = marqueRepository.save(mqHyn3);

        Marque mqTx1 = new Marque("Terex");
        Marque mqTx2 = new Marque("Terex");
        Marque mqTx3 = new Marque("Terex");

        mqTx1.setTypeEngin(te7);
        Marque mqR13 = marqueRepository.save(mqTx1);
        mqTx2.setTypeEngin(te8);
        Marque mqR14 = marqueRepository.save(mqTx2);
        mqTx3.setTypeEngin(te9);
        Marque mqR15 = marqueRepository.save(mqTx3);

        Marque mqCas1 = new Marque("Case");
        Marque mqCas2 = new Marque("Case");
        Marque mqCas3 = new Marque("Case");
        Marque mqCas4 = new Marque("Case");

        mqCas1.setTypeEngin(te6);
        Marque mqR16 = marqueRepository.save(mqCas1);
        mqCas2.setTypeEngin(te4);
        Marque mqR17 = marqueRepository.save(mqCas2);
        mqCas3.setTypeEngin(te5);
        Marque mqR18 = marqueRepository.save(mqCas3);
        mqCas4.setTypeEngin(te5);
        Marque mqR122 = marqueRepository.save(mqCas3);

        Marque mqPoc1 = new Marque("Poclain");
        Marque mqPoc2 = new Marque("Poclain");
        Marque mqPoc3 = new Marque("Poclain");

        mqPoc1.setTypeEngin(te7);
        Marque mqR19 = marqueRepository.save(mqPoc1);
        mqPoc2.setTypeEngin(te8);
        Marque mqR20 = marqueRepository.save(mqPoc2);


        Marque mqNh1 = new Marque("New Holland");
        Marque mqNh2 = new Marque("New Holland");
        Marque mqNh3 = new Marque("New Holland");

        mqNh1.setTypeEngin(te9);
        Marque mqR21 = marqueRepository.save(mqNh1);
        mqNh2.setTypeEngin(te10);
        Marque mqR22 = marqueRepository.save(mqNh2);


//Modele Engin
        //Catterpillar-chargeuse pelleteuse
        Modele m1 = new Modele("428E");
        m1.setMarque(mqR1);
        Modele mod1 = modeleRepository.save(m1);
        Modele m2 = new Modele("428C");
        m2.setMarque(mqR1);
        Modele mod2 = modeleRepository.save(m2);
        Modele m3 = new Modele("428D");
        m3.setMarque(mqR1);
        Modele mod3 = modeleRepository.save(m3);

        //Volvo-SemiRemorque
        Modele m4 = new Modele("FH12");
        m4.setMarque(mqR7);
        Modele mod4 = modeleRepository.save(m4);
        Modele m5 = new Modele("FH16");
        m5.setMarque(mqR7);
        Modele mod5 = modeleRepository.save(m5);

        //Case-chargeuse pelleteuse
        Modele m6 = new Modele("580ST");
        m6.setMarque(mqR16);
        Modele mod6 = modeleRepository.save(m6);
        Modele m7 = new Modele("590ST");
        m7.setMarque(mqR16);
        Modele mod7 = modeleRepository.save(m7);
        Modele m8 = new Modele("695ST");
        m8.setMarque(mqR16);
        Modele mod8 = modeleRepository.save(m8);

        //catterpillar -chargeur sur pneu
        Modele m9 = new Modele("906M");
        m9.setMarque(mqR2);
        Modele mod9 = modeleRepository.save(m9);
        Modele m10 = new Modele("907M");
        m10.setMarque(mqR2);
        Modele mod10 = modeleRepository.save(m10);
        Modele m11 = new Modele("908M");
        m11.setMarque(mqR2);
        Modele mod11 = modeleRepository.save(m11);


        Modele m12 = new Modele("500v");
        m12.setMarque(mqR7);
        Modele mod12 = modeleRepository.save(m12);
        Modele m13 = new Modele("483G");
        m13.setMarque(mqR8);
        Modele mod13 = modeleRepository.save(m13);
        Modele m14 = new Modele("OM40");
        m14.setMarque(mqR9);
        Modele mod14 = modeleRepository.save(m14);
        Modele m15 = new Modele("A720");
        m15.setMarque(mqR10);
        Modele mod15 = modeleRepository.save(m15);
        Modele m16 = new Modele("B850");
        m16.setMarque(mqR11);
        Modele mod16 = modeleRepository.save(m16);
        Modele m17 = new Modele("45E7");
        m17.setMarque(mqR12);
        Modele mod17 = modeleRepository.save(m17);
        Modele m18 = new Modele("315D");
        m18.setMarque(mqR44);
        Modele mod18 = modeleRepository.save(m18);


        Modele m42 = new Modele("M315F");
        m42.setMarque(mqR45);
        Modele mod19 = modeleRepository.save(m42);


        Modele m19 = modeleRepository.save(new Modele("F150", marqueRepository.save(new Marque("FIAT", te1))));
        Modele m20 = modeleRepository.save(new Modele("F140", marqueRepository.save(new Marque("FIAT", te2))));
        Modele m21 = modeleRepository.save(new Modele("F160", marqueRepository.save(new Marque("FIAT", te3))));
        Modele m22 = modeleRepository.save(new Modele("MKR", marqueRepository.save(new Marque("ISUZU", te1))));


        Localisation l = new Localisation(35.894761f, 10.594485f);
        Localisation l2 = new Localisation(35.236115f, 10.649798f);
        Localisation l3 = new Localisation(35.868934f, 10.585955f);
        Localisation l4 = new Localisation(35.868934f, 10.585955f);
        Localisation l5 = new Localisation(15.868934f, 15.585955f);


        Engin e1 = enginRepository.save(new Engin("14248", "EnMission", "engin1.jpg", l, mod10));//ch sur pneu
        Engin e2 = enginRepository.save(new Engin("24615", "EnPanne", "engin2.jpg", l2, mod1)); //ch pellse
        Engin e3 = enginRepository.save(new Engin("16454", "Disponible", "engin3.jpg", l3, mod3));//ch pellse
        Engin e4 = enginRepository.save(new Engin("113TU6869", "Disponible", "engin4.jpg", l4, mod4));//semi
        Engin e5 = enginRepository.save(new Engin("90TU2842", "Disponible", "semi99.jpg", new Localisation(15.868934f, 15.585955f), mod4));//semi
        Engin e6 = enginRepository.save(new Engin("100TU1238", "Disponible", "berlet496182.jpg", new Localisation(15.868934f, 15.585955f), m20));//poidsLourd
        Engin e7 = enginRepository.save(new Engin("102TU1352", "Disponible", "isuzuNKR.jpg", new Localisation(15.868934f, 15.585955f), m22));//camion
        Engin e8 = enginRepository.save(new Engin("23486", "Disponible", "charSurCh.jpg", new Localisation(15.868934f, 15.585955f), mod17));//ch sur chenille
        Engin e9 = enginRepository.save(new Engin("11477", "Disponible", "pelleSurChenille.png", new Localisation(15.868934f, 15.585955f), mod18));//pelle sur chenille
        Engin e10 = enginRepository.save(new Engin("33488", "Disponible", "pelleSurPneu.jpg", new Localisation(15.868934f, 15.585955f), mod19));//pelle sur chenille


        Visite v1 = new Visite();
        v1.setEngin(e1);
        v1.setDateDeb(new Date(2018 - 1900, 1 - 1, 5));
        v1.setDateFin(new Date(2018 - 1900, 2 - 1, 5));
        v1.setStatus("Accepter");
        v1.setPrix(100f);
        visiteRepository.save(v1);

        Visite v2 = new Visite();
        v2.setEngin(e2);
        v2.setDateDeb(new Date(2018 - 1900, 1 - 1, 5));
        v2.setPrix(50f);
        v2.setDateFin(new Date(2018 - 1900, 1, 5));
        v2.setStatus("Refuser");
        v2.setDescription("problème de feux avant");
        visiteRepository.save(v2);


        Taxe t1 = new Taxe(new Date(2018 - 1900, 1 - 1, 6), new Date(2018 - 1900, 2 - 1, 6), 450f);
        t1.setEngin(e1);
        taxeRepository.save(t1);

        Taxe t2 = new Taxe(new Date(2018 - 1900, 1 - 1, 6), new Date(2018 - 1900, 2 - 1, 6), 450f);
        t2.setEngin(e2);
        taxeRepository.save(t2);


        CompagnieAssurance compagnieAssurance1 = compagnieAssuranceRepository.save(new CompagnieAssurance("Compagnie GAT Assurance"));

        Assurance a1 = new Assurance(new Date(2018 - 1900, 1 - 1, 6), new Date(2018 - 1900, 2 - 1, 6), 450f, compagnieAssurance1);
        a1.setEngin(e1);
        assuranceRepository.save(a1);

        Assurance a2 = new Assurance(new Date(2018 - 1900, 1 - 1, 6), new Date(2018 - 1900, 2 - 1, 6), 450f, compagnieAssurance1);
        a2.setEngin(e2);
        assuranceRepository.save(a2);


        Piece p1 = pieceRepository.save(new Piece("Demarreur", "damarreurDesc"));
        Piece p2 = pieceRepository.save(new Piece("Alternateur", "alternateurDesc"));
        Piece p3 = pieceRepository.save(new Piece("Essieux", "EssieuxrDesc"));
        Piece p4 = pieceRepository.save(new Piece("Freins", "FreinsDesc"));
        Piece p5 = pieceRepository.save(new Piece("Suspension", "SuspensionDesc"));
        Piece p6 = pieceRepository.save(new Piece("Circuit d'air", "Circuit d'airDesc"));
        Piece p7 = pieceRepository.save(new Piece("Electricité et éclairage", "Electricité et éclairageDesc"));


        Reparation r1 = new Reparation(new Date(), 560f, "reparationNum1", e1);
        reparationRepository.save(r1);
        ligneReparationRepository.save(new LigneReparation(r1, p1, "nouvelle", 500f));
        ligneReparationRepository.save(new LigneReparation(r1, p2, "memePiece", 60f));

        Reparation r2 = new Reparation(new Date(), 860f, "reparationnum2", e2);
        reparationRepository.save(r2);
        ligneReparationRepository.save(new LigneReparation(r2, p3, "occasion", 400f));
        ligneReparationRepository.save(new LigneReparation(r2, p4, "nouvelle", 430f));


        vidangeRepository.save(new Vidange("vidange moteur", "20w50", new Date(), 300f, "dsklfjklsdfj", e2));
        vidangeRepository.save(new Vidange("vidange boite", "40M60", new Date(), 300f, "aaazeaze", e3));


        Client client1 = new Client("mohammed", "ltaif", "22789456", "mohammed_eltaif@gmail.com", "kalaa kbira", "mohammed.jpg");
        Client client2 = new Client("achraf", "abd Jalil", "21456789", "achraf_abd_jalil@gmail.com", "msaken", "achraf.jpg");
        Client client3 = new Client("samer", "hassen", "97885703", "hsensamer88@gmail.com", "hammem sousse", "samer.jpg");
        Client client4 = new Client("adel", "mabrouk", "99456123", "adel_mabrouk@gmail.com", "sahloul 2", "adel.jpg");

        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);
        clientRepository.save(client4);


        Chantier chantier1 = chantierRepository.save(new Chantier("Sahloul4", "rue sahloul 4", "chantier sahloul de mohammed ", new Date(), client1, new Localisation(31.121f, 10.454f)));
        Chantier chantier2 = chantierRepository.save(new Chantier("hammemSousse", "rue yasser arafet", "chantier sahloul de samer ", new Date(), client2, new Localisation(33.121f, 11.454f)));
        Chantier chantier3 = chantierRepository.save(new Chantier("Sahloul2", "rue sahloul 2 ", "chantier sahloul de mohammed ", new Date(), client3, new Localisation(35.121f, 12.454f)));


        Produit produit1 = produitRepository.save(new Produit("Sable"));
        Produit produit2 = produitRepository.save(new Produit("Gravier_12/20"));
        Produit produit3 = produitRepository.save(new Produit("Gravier_25/40"));
        Produit produit4 = produitRepository.save(new Produit("Gravier_3/5"));

        Commande commande1 = commandeRepository.save(new Commande(accountService.findUserByUsername("samer"), chantier1, "confirmer", new Date(), "commande de la part Mr karim"));
        // Commande commande2 = commandeRepository.save(new Commande(accountService.findUserByUsername("achraf"), chantier1, "nouveau", new Date()));

        /* Task task1 = livraisonRepository.save(new Livraison(teR1, "periorite1", new Date(), new Date(), true, 2f, produit1));
        Task task2 = livraisonRepository.save(new Livraison(teR2, "periotite2", new Date(), new Date(), true, 23f, produit2));
        Task task3 = creuseEtFondationRepository.save(new CreuseEtFondation(teR6, "periorite1", new Date(), new Date(), 5f));
       */
        LigneCommande ligneCommande1 = ligneCommandeRepository.save(new LigneCommande(commande1, new Livraison(teR3, "Priorite1", new Date(), new Date(), true, 2f, produit1), "affecter", "Livraison 2 semi-remorque  sable"));
        avoirEnginConducteurRepository.save(new AvoirEnginConducteur(ligneCommande1, e4, user5, user3, new Date()));
        LigneCommande ligneCommande2 = ligneCommandeRepository.save(new LigneCommande(commande1, new Livraison(teR2, "Priorite2", new Date(), new Date(), true, 5f, produit2), "nonAffecter", "Livraison 2 poids-lourds  Gravier_12/20"));
        LigneCommande ligneCommande3 = ligneCommandeRepository.save(new LigneCommande(commande1, new CreuseEtFondation(teR6, "Priorite3", new Date(), new Date(), 5f), "affecter", "creuse et fondation 5 heures chargeuse-pelleteuse"));
        avoirEnginConducteurRepository.save(new AvoirEnginConducteur(ligneCommande3, e3, user4, user1, new Date()));
        LigneCommande ligneCommande4 = ligneCommandeRepository.save(new LigneCommande(commande1, new CreuseEtFondation(teR5, "Priorite1", new Date(), new Date(), 4f), "nonAffecter", "creuse et fondation 4 heures chargeuses sur chenilles"));
        LigneCommande ligneCommande5 = ligneCommandeRepository.save(new LigneCommande(commande1, new Livraison(teR3, "Priorite2", new Date(), new Date(), true, 5f, produit2), "affecter", "Livraison 5 semi-remorque  Gravier_12/20"));
        avoirEnginConducteurRepository.save(new AvoirEnginConducteur(ligneCommande5, e4, user5, user3, new Date()));


        /*e1.setLocalisation(l5);
        enginRepository.save(e1);*/ //dans le cas update il faut envoyer id de la localisation
        // sinon une nouvelle localisation va etre créer

           /* enginRepository.deleteById(e1.getId());
        enginRepository.deleteById(e2.getId());
        enginRepository.deleteById(e3.getId());
        enginRepository.deleteById(e3.getId())*/

    }

    //bean application toute les methode vont excuter  peut les utiliser n'importe ou il faut le metre dans la  class elle-meme
    @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }


}

