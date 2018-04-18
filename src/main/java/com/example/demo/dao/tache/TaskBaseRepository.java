package com.example.demo.dao.tache;


import com.example.demo.entities.tache.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TaskBaseRepository<T extends Task> extends JpaRepository<T, Long> {

    // public T findByEmail(String email);

}
