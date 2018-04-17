package com.example.demo.web.Engin;

import com.example.demo.entities.Engin.Modele;
import com.example.demo.service.Engin.ModeleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ModeleRestController {

    @Autowired
    private ModeleService modeleService;

    @GetMapping("/modele/marque/{id}")
    public List<Modele> getAllModeleByIdMarque(@PathVariable Long id)
    {

        return modeleService.getAllModeleByidMarque(id);

    }

    @GetMapping("/modele")
    public List<Modele> getAllModele()
    {
        return modeleService.getAllModele();

    }


    @GetMapping("/modele/{id}")
    public Modele getModele(@PathVariable Long id)
    {

        Modele e= modeleService.getModele(id);

        return e;
    }

    @PostMapping("/modele")
    public void addModele(@RequestBody Modele modele)
    {
        modeleService.addModele(modele);
    }

    @PutMapping("/modele")
    public void updateModele(@RequestBody Modele modele)
    {
        modeleService.updateModele(modele);
    }


    @DeleteMapping("/modele/{id}")
    public void deleteModele(@PathVariable Long id) {
        modeleService.deleteModele(id);
    }
}
