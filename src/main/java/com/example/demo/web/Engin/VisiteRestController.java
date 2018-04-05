package com.example.demo.web.Engin;

import com.example.demo.dao.Engin.VisiteRepository;
import com.example.demo.entities.Engin.Visite;
import com.example.demo.service.Engin.VisiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisiteRestController {
    @Autowired
    private VisiteService visiteService;

    @GetMapping("/visite")
    public List<Visite> getAllVisite()
    {
        return visiteService.getAllVisite();

    }


    @GetMapping("/visite/{id}")
    public Visite getVisite(@PathVariable Long id)
    {

        Visite e= visiteService.getVisite(id);

        return e;
    }

    @PostMapping("/visite")
    public void addVisite(@RequestBody Visite visite)
    {
        visiteService.addVisite(visite);
    }

    @PutMapping("/visite")
    public void updateVisite(@RequestBody Visite visite)
    {
        visiteService.updateVisite(visite);
    }


    @DeleteMapping("/visite/{id}")
    public void deleteVisite(@PathVariable Long id)
    {
        visiteService.deleteVisite(id);
    }
}
