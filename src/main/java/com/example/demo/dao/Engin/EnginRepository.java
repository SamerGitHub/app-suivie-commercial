package com.example.demo.dao.Engin;

import com.example.demo.entities.Engin.Engin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface EnginRepository extends JpaRepository<Engin, Long> {
    public Engin getEnginByMatricule(String mat);
    public Engin getEnginById(Long id);
    public List<Engin> findAllByModeleMarqueTypeEnginType (String type);
    public List<Engin> findAllByModeleMarqueTypeEnginId (Long id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Engin e SET e.photo =:image WHERE e.id =:id")
    public void updatePhoto(@Param("id")Long id, @Param("image")String photo );
}
