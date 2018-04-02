package com.example.demo.dao.Engin;

import com.example.demo.entities.Engin.ClassEngin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassEnginRepository extends JpaRepository<ClassEngin, Long> {

    public ClassEngin getClassEnginById(Long id);
    public ClassEngin getClassEnginByClassificaton(String classification);
    public ClassEngin getClassEnginByType(String type);
    public ClassEngin getClassEnginByClassificatonAndType(String classification,String type);
}
