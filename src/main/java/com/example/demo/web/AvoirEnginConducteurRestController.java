package com.example.demo.web;

import com.example.demo.entities.AvoirEnginConducteur;
import com.example.demo.service.AvoirEnginConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AvoirEnginConducteurRestController {
    @Autowired
    private AvoirEnginConducteurService avoirEnginConducteurService;


    @GetMapping("/avoirEnginConducteur")
    public List<AvoirEnginConducteur> getAllAvoirEnginConducteur()
    {
        return avoirEnginConducteurService.getAllAvoirEnginConducteur();

    }


    @GetMapping("/avoirEnginConducteur/conducteur/{username}")
    public List<AvoirEnginConducteur> getAllAvoirEnginConducteurByConducteur(@PathVariable String username)
    {
        System.out.println("avoirEnginConducteur/conducteur :: /"+username);
      //  return avoirEnginConducteurService.getAllAvoirEnginConducteurByConducteur(username);

        return avoirEnginConducteurService.getByConducteurAndLigneCommandeStatusAffecterOrStart(username);



    }



    @GetMapping("/avoirEnginConducteur/{id}")
    public AvoirEnginConducteur getAvoirEnginConducteur(@PathVariable Long id)
    {


        return avoirEnginConducteurService.getAvoirEnginConducteur(id);

    }

    @GetMapping("/avoirEnginConducteur/ligneCommmande/{id}")
    public AvoirEnginConducteur getAvoirEnginConducteurByIdLigneCommande(@PathVariable Long id)
    {

        return avoirEnginConducteurService.getAvoirEnginConducteurByIdLigneCommande(id);

    }


    @PostMapping("/avoirEnginConducteur")
    public void addAvoirEnginConducteur(@RequestBody AvoirEnginConducteur avoirEnginConducteur)
    {
        avoirEnginConducteurService.addAvoirEnginConducteur(avoirEnginConducteur);
    }


    @PostMapping("/avoirEnginConducteur/notification")
    public ResponseEntity<String> addAvoirEnginConducteurNotification(@RequestBody AvoirEnginConducteur avoirEnginConducteur)
    {
        return avoirEnginConducteurService.addAvoirEnginConducteurNotification(avoirEnginConducteur);
    }

    @PutMapping("/avoirEnginConducteur/notification")
    public ResponseEntity<String> updateAvoirEnginConducteurNotification(@RequestBody AvoirEnginConducteur avoirEnginConducteur)
    {
        return avoirEnginConducteurService.updateAvoirEnginConducteurNotification(avoirEnginConducteur);
    }


    @PutMapping("/avoirEnginConducteur")
    public void updateAvoirEnginConducteur(@RequestBody AvoirEnginConducteur avoirEnginConducteur)
    {
        avoirEnginConducteurService.updateAvoirEnginConducteur(avoirEnginConducteur);
    }


    @DeleteMapping("/avoirEnginConducteur/{id}")
    public void deleteAvoirEnginConducteur(@PathVariable Long id)
    {
        avoirEnginConducteurService.deleteAvoirEnginConducteur(id);
    }




}
