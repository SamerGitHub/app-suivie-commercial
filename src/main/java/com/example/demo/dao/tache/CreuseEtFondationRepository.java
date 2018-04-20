package com.example.demo.dao.tache;


import com.example.demo.entities.tache.CreuseEtFondation;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CreuseEtFondationRepository extends TaskBaseRepository<CreuseEtFondation> {
}
