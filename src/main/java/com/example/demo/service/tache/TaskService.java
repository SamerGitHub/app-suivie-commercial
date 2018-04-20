package com.example.demo.service.tache;


import com.example.demo.dao.tache.TaskRepository;
import com.example.demo.entities.tache.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;


    public List<Task> getAllTask()
    {

        return taskRepository.findAll();

    }

    public Task getTask(Long id)
    {
        return taskRepository.getTaskById(id);
    }

    public void addTask(Task task) {


        taskRepository.save(task);

    }

    public void updateTask(Task task) {


        taskRepository.save(task);

    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);

    }
    
}
