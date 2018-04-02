package com.example.demo.service;


import com.example.demo.dao.TaskRepository;
import com.example.demo.entities.Task;
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
