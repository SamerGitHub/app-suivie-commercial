package com.example.demo.web;

import com.example.demo.entities.Chantier;
import com.example.demo.service.ChantierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChantierRestContoller {
    @Autowired
    ChantierService chantierService;


    @GetMapping("/chantier")
    public List<Chantier> getAllChantier()
    {
        return chantierService.getAllChantier();

    }


    @GetMapping("/chantier/{id}")
    public Chantier getChantier(@PathVariable Long id)
    {

        return chantierService.getChantier(id);

    }

    @PostMapping("/chantier")
    public void addChantier(@RequestBody Chantier chantier)
    {
        chantierService.addChantier(chantier);
    }

    @PutMapping("/chantier/{id}")
    public void updateChantier(@RequestBody Chantier chantier)
    {
        chantierService.updateChantier(chantier);
    }


    @DeleteMapping("/chantier/{id}")
    public void deleteChantier(@PathVariable Long id)
    {
        chantierService.deleteChantier(id);
    }
}
