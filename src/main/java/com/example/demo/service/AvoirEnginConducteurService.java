package com.example.demo.service;


import com.example.demo.dao.AvoirEnginConducteurRepository;
import com.example.demo.dao.LigneCommandeRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.AppUser;
import com.example.demo.entities.AvoirEnginConducteur;
import com.example.demo.entities.LigneCommande;
import com.example.demo.firebase.FcmPushTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AvoirEnginConducteurService {
    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;
    @Autowired
    private UserRepository userdao;
    @Autowired
    private AvoirEnginConducteurRepository avoirEnginConducteurRepository;

    public List<AvoirEnginConducteur> getAllAvoirEnginConducteur() {

        return avoirEnginConducteurRepository.findAll();

    }

    public List<AvoirEnginConducteur> getAllAvoirEnginConducteurByConducteur(String username) {

        return avoirEnginConducteurRepository.findAllByConducteurUsername(username);

    }

    public List<AvoirEnginConducteur> getByConducteurAndLigneCommandeStatusAffecterOrStart(String username) {

        return avoirEnginConducteurRepository.findByConducteurUsernameAndLigneCommandeStatus(username, "affecter", "start");

    }


    public AvoirEnginConducteur getAvoirEnginConducteur(Long id) {
        return avoirEnginConducteurRepository.getAvoirEnginConducteurById(id);
    }

    public AvoirEnginConducteur getAvoirEnginConducteurByIdLigneCommande(Long id) {
        return avoirEnginConducteurRepository.getAvoirEnginConducteurByLigneCommandeId(id);
    }

    public ResponseEntity<String> addAvoirEnginConducteurNotification(AvoirEnginConducteur avoirEnginConducteur) {

        avoirEnginConducteur.setId(null);


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        AppUser user = userdao.findByUsername(loggedUsername);

        avoirEnginConducteur.setCreatedDate(new Date());
        avoirEnginConducteur.setSecretaire(user);

        avoirEnginConducteurRepository.save(avoirEnginConducteur);


        LigneCommande lc = ligneCommandeRepository.getLigneCommandeById(avoirEnginConducteur.getLigneCommande().getId());
        lc.setStatus("affecter");
        ligneCommandeRepository.save(lc);

        String message = "";

        try {
            String response = FcmPushTest.pushFCMNotificationToOneUser(userdao.getOne(avoirEnginConducteur.getConducteur().getId()).getDeviceToken(), 123456L);
            System.out.println("firebase response server :: " + response);

            message = "You successfully send notification !";

            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception ex) {
            System.out.println("Exeption firebase response server  : " + ex.getMessage());
            message = "FAIL to send notification !";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }



    }

    public ResponseEntity<String> updateAvoirEnginConducteurNotification(AvoirEnginConducteur avoirEnginConducteur) {


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        AppUser user = userdao.findByUsername(loggedUsername);

        avoirEnginConducteur.setCreatedDate(new Date());
        avoirEnginConducteur.setSecretaire(user);

        avoirEnginConducteurRepository.save(avoirEnginConducteur);
        String message = "";

        try {
            String response = FcmPushTest.pushFCMNotificationToOneUser(userdao.getOne(avoirEnginConducteur.getConducteur().getId()).getDeviceToken(), 123456L);
            System.out.println("firebase response server :: " + response);
            message = "You successfully send notification u !";

            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception ex) {
            System.out.println("Exeption firebase response server  : " + ex.getMessage());
            message = "FAIL to send notification u !";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }


    }

    public void addAvoirEnginConducteur(AvoirEnginConducteur avoirEnginConducteur) {

        avoirEnginConducteur.setId(null);


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        AppUser user = userdao.findByUsername(loggedUsername);

        avoirEnginConducteur.setCreatedDate(new Date());
        avoirEnginConducteur.setSecretaire(user);

        avoirEnginConducteurRepository.save(avoirEnginConducteur);


        try {
            String response = FcmPushTest.pushFCMNotificationToOneUser(userdao.getOne(avoirEnginConducteur.getConducteur().getId()).getDeviceToken(), 123456L);
            System.out.println("firebase response server :: " + response);
        } catch (Exception ex) {
            System.out.println("Exeption firebase response server  : " + ex.getMessage());
        }


        LigneCommande lc = ligneCommandeRepository.getLigneCommandeById(avoirEnginConducteur.getLigneCommande().getId());
        lc.setStatus("affecter");
        ligneCommandeRepository.save(lc);


    }

    public void updateAvoirEnginConducteur(AvoirEnginConducteur avoirEnginConducteur) {


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        AppUser user = userdao.findByUsername(loggedUsername);

        avoirEnginConducteur.setCreatedDate(new Date());
        avoirEnginConducteur.setSecretaire(user);

        avoirEnginConducteurRepository.save(avoirEnginConducteur);


        try {
            String response = FcmPushTest.pushFCMNotificationToOneUser(userdao.getOne(avoirEnginConducteur.getConducteur().getId()).getDeviceToken(), 123456L);
            System.out.println("firebase response server :: " + response);
        } catch (Exception ex) {
            System.out.println("Exeption firebase response server  : " + ex.getMessage());
        }


    }

    public void deleteAvoirEnginConducteur(Long id) {
        avoirEnginConducteurRepository.deleteById(id);

    }
}
