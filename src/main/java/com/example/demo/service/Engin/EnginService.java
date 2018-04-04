package com.example.demo.service.Engin;


import com.example.demo.dao.Engin.ClassEnginRepository;
import com.example.demo.dao.Engin.EnginRepository;
import com.example.demo.dao.LocalisationRepository;
import com.example.demo.entities.Engin.ClassEngin;
import com.example.demo.entities.Engin.Engin;
import com.example.demo.entities.Localisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnginService {
    @Autowired
    private EnginRepository enginRepository;
    @Autowired
    private LocalisationRepository localisationRepository;
    @Autowired
    private ClassEnginRepository classEnginRepository;


    public List<Engin> getAllEngin() {

        return enginRepository.findAll();

    }

    public Engin getEngin(Long id) {
        return enginRepository.getEnginById(id);
    }

    public void addEngin(Engin engin) {
        engin.setLocalisation(localisationRepository.save(new Localisation(0f, 0f)));
        enginRepository.save(engin);

/*
        if(engin.getClasEngin()==null)throw new RuntimeException("ClassEngin Not found in body");
        if (engin.getClasEngin().getType() == null)
            throw new RuntimeException("Type ClassEngin Not found in body");
        if (engin.getClasEngin().getClassificaton() == null)
            throw new RuntimeException("Classification ClassEngin Not found in body");


        ClassEngin ce = classEnginRepository.getClassEnginByClassificatonAndType(engin.getClasEngin().getClassificaton(), engin.getClasEngin().getType());


        if (ce != null) {
            engin.setLocalisation(localisationRepository.save(new Localisation(0f, 0f)));
            engin.setClasEngin(ce);
            enginRepository.save(engin);
        } else {
            throw new RuntimeException("Classification Not Exist in DB");

        }
*/

    }

    public void updateEngin(Engin engin) {
/*
        Engin e=enginRepository.getEnginById(engin.getId());
        if(e!=null)
        {
            if(engin.getClasEngin()==null)throw new RuntimeException("ClassEngin Not found in body");
            if (engin.getClasEngin().getType() == null)
                throw new RuntimeException("Type ClassEngin Not found in body");
            if (engin.getClasEngin().getClassificaton() == null)
                throw new RuntimeException("Classification ClassEngin Not found in body");
            ClassEngin ce = classEnginRepository.getClassEnginByClassificatonAndType(engin.getClasEngin().getClassificaton(), engin.getClasEngin().getType());

            if(ce==null)throw new RuntimeException("verifiez type et classification");

            engin.setLocalisation(e.getLocalisation());
            enginRepository.save(engin);
            //classEnginRepository.save(engin.getClasEngin());
        }else
            throw new RuntimeException("Engin not found");

*/
    }

    public void deleteEngin(Long id){


          Engin e= enginRepository.getEnginById(id);
          if(e!=null)
          {
              enginRepository.deleteById(id);
              localisationRepository.delete(e.getLocalisation());

          }else throw new RuntimeException("Engin not exist");

    }

}
