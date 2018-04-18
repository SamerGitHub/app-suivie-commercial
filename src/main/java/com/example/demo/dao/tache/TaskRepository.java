package com.example.demo.dao.tache;

import com.example.demo.entities.tache.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;

@Repository

@Transactional

public interface TaskRepository extends TaskBaseRepository<Task> {


}
