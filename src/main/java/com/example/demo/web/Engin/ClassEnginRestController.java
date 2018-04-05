package com.example.demo.web.Engin;

import com.example.demo.entities.Engin.ClassEngin;
import com.example.demo.service.Engin.ClassEnginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassEnginRestController {

    @Autowired
    private ClassEnginService classEnginService;

    @GetMapping("/classEngin")
    public List<ClassEngin> getAllClassEngin()
    {
        return classEnginService.getAllClassEngin();

    }

    @GetMapping("/classEngin/{id}")
    public ClassEngin getClassEngin(@PathVariable Long id)
    {

        ClassEngin e= classEnginService.getClassEngin(id);

        return e;
    }

    @PostMapping("/classEngin")
    public void addClassEngin(@RequestBody ClassEngin classEngin)
    {
        classEnginService.addClassEngin(classEngin);
    }

    @PutMapping("/classEngin")
    public void updateClassEngin(@RequestBody ClassEngin classEngin)
    {
        classEnginService.updateClassEngin(classEngin);
    }


    @DeleteMapping("/classEngin/{id}")
    public void deleteClassEngin(@PathVariable Long id)
    {
        classEnginService.deleteClassEngin(id);
    }
}
