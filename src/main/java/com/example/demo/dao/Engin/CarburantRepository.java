package com.example.demo.dao.Engin;

import com.example.demo.entities.Engin.Carburant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarburantRepository  extends JpaRepository<Carburant, Long> {

    public Carburant getCarburantById(Long id);
}
