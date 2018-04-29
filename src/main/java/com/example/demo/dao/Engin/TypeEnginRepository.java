package com.example.demo.dao.Engin;

import com.example.demo.entities.Engin.TypeEngin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TypeEnginRepository extends JpaRepository<TypeEngin, Long> {
    public TypeEngin getTypeEnginById(Long id);
    public List<TypeEngin> findAllByClasEnginId (Long id);
    public List<TypeEngin> findAllByClasEnginClassification (String classification);

}
