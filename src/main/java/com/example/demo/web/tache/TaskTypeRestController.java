package com.example.demo.web.tache;

import com.example.demo.entities.tache.TaskType;
import com.example.demo.service.tache.TaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskTypeRestController {

    @Autowired
    private TaskTypeService taskTypeService;


    @GetMapping("/taskType")
    public List<TaskType> getAllTaskType()
    {
        return taskTypeService.getAllTaskType();

    }

    @PutMapping("/taskType/update/active")
    public void updateTaskTypeEtat(@RequestBody List <TaskType> taskTypes )
    {


        taskTypeService.updateAllTaskType(taskTypes);
    }

    @GetMapping("/taskType/active")
    public List<TaskType> getActiveTaskType()
    {
        return taskTypeService.getActiveTaskType();

    }

    @GetMapping("/taskType/{id}")
    public TaskType getTaskType(@PathVariable Long id)
    {

        return taskTypeService.getTaskType(id);

    }

    @PostMapping("/taskType")
    public void addTaskType(@RequestBody TaskType taskType)
    {
        taskTypeService.addTaskType(taskType);
    }

    @PutMapping("/taskType")
    public void updateTaskType(@RequestBody TaskType taskType)
    {
        taskTypeService.updateTaskType(taskType);
    }


    @DeleteMapping("/taskType/{id}")
    public void deleteTaskType(@PathVariable Long id)
    {
        taskTypeService.deleteTaskType(id);
    }
}
