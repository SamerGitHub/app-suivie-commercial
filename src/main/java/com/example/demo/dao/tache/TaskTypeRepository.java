package com.example.demo.dao.tache;

import com.example.demo.entities.tache.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;


@Repository
public interface TaskTypeRepository extends JpaRepository<TaskType, Long> {

    public TaskType getTaskTypeById(Long id);
    public List<TaskType> findAllByActive(Boolean active);

}
