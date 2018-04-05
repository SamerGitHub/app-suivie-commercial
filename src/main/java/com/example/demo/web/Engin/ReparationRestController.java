package com.example.demo.web.Engin;

import com.example.demo.entities.Engin.Reparation;
import com.example.demo.service.Engin.ReparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReparationRestController {

    @Autowired
    private ReparationService reparationService;

    @GetMapping("/reparation")
    public List<Reparation> getAllReparation()
    {
        return reparationService.getAllReparation();

    }


    @GetMapping("/reparation/{id}")
    public Reparation getReparation(@PathVariable Long id)
    {

        Reparation e= reparationService.getReparation(id);

        return e;
    }

    @PostMapping("/reparation")
    public void addReparation(@RequestBody Reparation reparation)
    {
        reparationService.addReparation(reparation);
    }

    @PutMapping("/reparation")
    public void updateReparation(@RequestBody Reparation reparation)
    {
        reparationService.updateReparation(reparation);
    }


    @DeleteMapping("/reparation/{id}")
    public void deleteReparation(@PathVariable Long id)
    {
        reparationService.deleteReparation(id);
    }
}
