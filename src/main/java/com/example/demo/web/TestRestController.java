package com.example.demo.web;

import java.util.List;


import com.example.demo.dao.TaskRepository;
import com.example.demo.entities.tache.Task;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestRestController {
	@Autowired
private TaskRepository taskRepository;

/*role autowired public TestRestController(TaskRepository taskRepository) {

	this.taskRepository = taskRepository;
}*/
	@GetMapping("/tasks")
	public List<Task> listTasks(){
	return	taskRepository.findAll();
	}

	@GetMapping("/tasks/{id}")
	public Task getTask(@PathVariable Long id){

		return	taskRepository.getTaskById(id);

	}
	@DeleteMapping("/tasks/{id}")
	public void deleteTask(@PathVariable Long id){

			taskRepository.deleteById(id);

	}
	@PostMapping("/tasks")
	public Task save(@RequestBody Task t) {
		return	taskRepository.save(t);
	}


}
