package com.example.demo.web;

import com.example.demo.entities.Engin;
import com.example.demo.service.EnginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnginRestController {

    @Autowired
    private EnginService enginService;

    @GetMapping("/engin")
    public List<Engin> getAllEngin()
    {
        return enginService.getAllEngin();

    }


    @GetMapping("/engin/{id}")
    public Engin getEngin(@PathVariable Long id)
    {

        Engin e= enginService.getEngin(id);

        return e;
    }

    @PostMapping("/engin")
    public void addEngin(@RequestBody Engin engin)
    {
        enginService.addEngin(engin);
    }

    @PutMapping("/engin/{id}")
    public void updateEngin(@RequestBody Engin engin)
    {
        enginService.updateEngin(engin);
    }


    @DeleteMapping("/engin/{id}")
    public void deleteEngin(@PathVariable Long id)
    {
        enginService.deleteEngin(id);
    }
}
