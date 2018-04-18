package com.example.demo.dao;


import com.example.demo.entities.tache.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/*//@RepositoryRestResource*/
@Repository
public interface TaskRepository  extends JpaRepository<Task, Long>  {

  Task getTaskById(Long id);

}
