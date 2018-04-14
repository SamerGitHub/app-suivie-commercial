package com.example.demo.web.Engin;

import com.example.demo.entities.Engin.Marque;
import com.example.demo.service.Engin.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarqueRestController {

    @Autowired
    private MarqueService marqueService;

    @GetMapping("/marque/typeEngin/{id}")
    public List<Marque> getAllMarqueByIdTypeEngin(@PathVariable Long id)
    {

        return marqueService.getAllMarqueByidtypeEngin(id);

    }

    @GetMapping("/marque")
    public List<Marque> getAllMarque()
    {
        return marqueService.getAllMarque();

    }


    @GetMapping("/marque/{id}")
    public Marque getMarque(@PathVariable Long id)
    {

        Marque e= marqueService.getMarque(id);

        return e;
    }

    @PostMapping("/marque")
    public void addMarque(@RequestBody Marque marque)
    {
        marqueService.addMarque(marque);
    }

    @PutMapping("/marque")
    public void updateMarque(@RequestBody Marque marque)
    {
        marqueService.updateMarque(marque);
    }


    @DeleteMapping("/marque/{id}")
    public void deleteMarque(@PathVariable Long id) {
        marqueService.deleteMarque(id);
    }
}
