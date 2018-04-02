package com.example.demo.web;

import com.example.demo.entities.Localisation;
import com.example.demo.service.LocalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocalisationRestController {

    @Autowired
    private LocalisationService localisationService;

    @GetMapping("/localisation")
    public List<Localisation> getAllLocalisation()
    {
        return localisationService.getAllLocalisation();

    }


    @GetMapping("/localisation/{id}")
    public Localisation getLocalisation(@PathVariable Long id)
    {
        Localisation e=new Localisation();
        e= localisationService.getLocalisation(id);
        // System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+e.toString());
        return e;
    }

    @PostMapping("/localisation")
    public void addLocalisation(@RequestBody Localisation localisation)
    {
        localisationService.addLocalisation(localisation);
    }

    @PutMapping("/localisation/{id}")
    public void updateLocalisation(@RequestBody Localisation localisation, @PathVariable Long id)
    {
        localisationService.updateLocalisation(id,localisation);
    }


    @DeleteMapping("/localisation/{id}")
    public void deleteLocalisation(@PathVariable Long id)
    {
        localisationService.deleteLocalisation(id);
    }
}
