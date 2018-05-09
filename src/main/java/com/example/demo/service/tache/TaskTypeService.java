package com.example.demo.service.tache;


import com.example.demo.dao.tache.TaskTypeRepository;
import com.example.demo.entities.tache.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskTypeService {
    @Autowired
    private TaskTypeRepository taskTypeRepository;

    public List<TaskType> getAllTaskType()
    {

        return taskTypeRepository.findAll();

    }
    public List<TaskType> getActiveTaskType()
    {

        return taskTypeRepository.findAllByActive(true);

    }


    public TaskType getTaskType(Long id)
    {
        return taskTypeRepository.getTaskTypeById(id);
    }

    public void addTaskType(TaskType taskType) {

        taskType.setId(null);
        taskTypeRepository.save(taskType);

    }

    public void updateTaskType(TaskType taskType) {


        taskTypeRepository.save(taskType);

    }
    public void updateAllTaskType(List<TaskType> taskTypes) {

        for(TaskType t:taskTypes)
         taskTypeRepository.save(t);

    }



    public void deleteTaskType(Long id) {
        taskTypeRepository.deleteById(id);

    }
}
