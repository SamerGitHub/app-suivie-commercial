package com.example.demo.service.Engin;

import com.example.demo.dao.Engin.ClassEnginRepository;
import com.example.demo.entities.Engin.ClassEngin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassEnginService {


    @Autowired
    private ClassEnginRepository classEnginRepository;



    public List<ClassEngin> getAllClassEngin()
    {

        return classEnginRepository.findAll();

    }

    public ClassEngin getClassEngin(Long id)
    {
        return classEnginRepository.getClassEnginById(id);
    }

    public void addClassEngin(ClassEngin classEngin) {

        //  classEngin.setLocalisation(localisationRepository.save(classEngin.getLocalisation()));
        classEnginRepository.save(classEngin);

    }

    public void updateClassEngin(ClassEngin classEngin) {


        classEnginRepository.save(classEngin);

    }

    public void deleteClassEngin(Long id) {
        classEnginRepository.deleteById(id);

    }
}
