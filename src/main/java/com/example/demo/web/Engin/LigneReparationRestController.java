package com.example.demo.web.Engin;

import com.example.demo.entities.Engin.LigneReparation;
import com.example.demo.entities.Engin.Piece;
import com.example.demo.service.Engin.LigneReparationService;
import com.example.demo.service.Engin.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LigneReparationRestController {
    @Autowired
    private LigneReparationService ligneReparationService;

    @GetMapping("/ligneReparation")
    public List<LigneReparation> getAllLigneReparation()
    {
        return ligneReparationService.getAllLigneReparation();

    }


    @GetMapping("/ligneReparation/{id}")
    public LigneReparation getLigneReparation(@PathVariable Long id)
    {

        LigneReparation e= ligneReparationService.getLigneReparation(id);

        return e;
    }

    @PostMapping("/ligneReparation")
    public void addLigneReparation(@RequestBody LigneReparation ligneReparation)
    {
        ligneReparationService.addLigneReparation(ligneReparation);
    }

    @PutMapping("/ligneReparation")
    public void updateLigneReparation(@RequestBody LigneReparation ligneReparation)
    {
        ligneReparationService.updateLigneReparation(ligneReparation);
    }


    @DeleteMapping("/ligneReparation/{id}")
    public void deleteLigneReparation(@PathVariable Long id)
    {
        ligneReparationService.deleteLigneReparation(id);
    }
}
