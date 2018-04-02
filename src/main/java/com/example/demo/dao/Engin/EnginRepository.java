package com.example.demo.dao.Engin;

import com.example.demo.entities.Engin.Engin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnginRepository extends JpaRepository<Engin, Long> {
    public Engin getEnginById(Long id);


}
