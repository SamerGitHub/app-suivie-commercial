package com.example.demo.web;

import com.example.demo.entities.AvoirEnginConducteur;
import com.example.demo.service.AvoirEnginConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return avoirEnginConducteurService.getAllAvoirEnginConducteurByConducteur(username);

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
