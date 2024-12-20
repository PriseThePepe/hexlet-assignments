package exercise.controller;

import java.util.List;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskMapper taskMapper;
    // BEGIN
    @GetMapping
    public List<TaskDTO> index() {
       var tasks = taskRepository.findAll();
       return tasks.stream()
               .map(task -> taskMapper.map(task))
               .toList();
    }
    @GetMapping(path = "{id}")
    public TaskDTO show(@PathVariable long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found"));
        return taskMapper.map(task);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@RequestBody @Valid TaskCreateDTO dtoData) {
        var task = taskMapper.map(dtoData);
        taskRepository.save(task);
        return taskMapper.map(task);
    }
    @PutMapping(path = "{id}")
    public TaskDTO update(@PathVariable long id, @RequestBody TaskUpdateDTO updateData) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found"));
        var user = userRepository.findById(updateData.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));;
        taskMapper.update(updateData,task);
        taskRepository.save(task);
        user.addTask(task);
        userRepository.save(user);
        return taskMapper.map(task);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) {
        taskRepository.deleteById(id);
    }
    // END
}
