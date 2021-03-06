package com.example.demo.service;

import com.example.demo.dao.AvoirEnginConducteurRepository;
import com.example.demo.dao.CommandeRepository;
import com.example.demo.dao.LigneCommandeRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.AppUser;
import com.example.demo.entities.AvoirEnginConducteur;
import com.example.demo.entities.Commande;
import com.example.demo.entities.Engin.TypeEngin;
import com.example.demo.entities.LigneCommande;
import com.example.demo.entities.tache.Livraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private AvoirEnginConducteurRepository avoirEnginConducteurRepository;
    @Autowired
    private UserRepository userdao;
    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;
    @Autowired
    private CommandeRepository commandeRepository;

    public List<Commande> getAllCommande() {

        return commandeRepository.findAll();

    }

    public List<Commande> getAllCommandeByChantierId(Long id) {

        return commandeRepository.getCommandeByChantierId(id);

    }


    public Commande getCommande(Long id) {
        return commandeRepository.getCommandeById(id);
    }


    public void addCommande(Commande commande) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        System.out.println("logged Username ::: " + loggedUsername);
        AppUser use2r = userdao.findByUsername(loggedUsername);
        if (use2r != null) System.out.println("user  :::" + use2r.getPrenom());
        commande.setUser(use2r);
        commande.setCreatedDate(new Date());
        commande.setId(null);
        Commande c = commandeRepository.save(commande);
        for (LigneCommande lc : commande.getLigneCommandes()) {

            lc.setId(null);
            lc.setCommande(c);
            lc.getTask().setId(null);
            LigneCommande ligneCommande=ligneCommandeRepository.save(lc);
            if (lc.getStatus().equals("affecter")) {

                lc.getAvoirEnginConducteur().setLigneCommande(ligneCommande);
                lc.getAvoirEnginConducteur().setCreatedDate(new Date());
                lc.getAvoirEnginConducteur().setSecretaire(use2r);
                avoirEnginConducteurRepository.save(lc.getAvoirEnginConducteur());
            }


        }

      /* if (lc.getTask() instanceof Livraison){
                System.out.println("Livraison");
                Livraison l=new Livraison();
                l=(Livraison)lc.getTask();
                lc.setTask(new Livraison(l.getTypeEngin(), "periotite2", new Date(), new Date(), true, 23f, l.getProduit()));
                ligneCommandeRepository.save(lc);
            }
            else
            {
                System.out.println("not Livraison");
            }*/

    }

    public void updateCommande(Commande commande) {

        System.out.println("IdCommande ::  " + commande.getId());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        System.out.println("logged Username ::: " + loggedUsername);
        AppUser use2r = userdao.findByUsername(loggedUsername);
        if (use2r != null) System.out.println("user  :::" + use2r.getPrenom());
        commande.setUser(use2r);
        commande.setCreatedDate(new Date());



        for (LigneCommande lc : commande.getLigneCommandes()) {

            if(lc.getId()==-1)
            {
                System.out.println("id ligneCommande -1");
                lc.setId(null);
            }

            lc.setCommande(commande);

            //lc.getTask().setId(null);
         ligneCommandeRepository.save(lc);

        }



        Commande c = commandeRepository.save(commande);


    }

    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);

    }
}
