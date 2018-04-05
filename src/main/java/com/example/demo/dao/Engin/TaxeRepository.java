package com.example.demo.dao.Engin;

import com.example.demo.entities.Engin.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeRepository  extends JpaRepository<Taxe, Long> {
    public Taxe getTaxeById(Long id);
}
