package com.example.demo.web.tache;

import com.example.demo.entities.tache.Task;
import com.example.demo.service.tache.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskRestController {
    
    @Autowired
    private TaskService taskService;


    @GetMapping("/task")
    public List<Task> getAllTask()
    {
        return taskService.getAllTask();

    }


    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable Long id)
    {

        return taskService.getTask(id);

    }

    @PostMapping("/task")
    public void addTask(@RequestBody Task task)
    {
        taskService.addTask(task);
    }

    @PutMapping("/task/{id}")
    public void updateTask(@RequestBody Task task)
    {
        taskService.updateTask(task);
    }


    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable Long id)
    {
        taskService.deleteTask(id);
    }
}

