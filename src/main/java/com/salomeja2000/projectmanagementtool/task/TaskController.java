package com.salomeja2000.projectmanagementtool.task;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<Task> readAllTasks() {
        return taskService.readAllTasks();
    }

    @GetMapping("{id}")
    public Task readTask(@PathVariable("id") int id) {
        return taskService.readTask(id);
    }

    @PostMapping
    public void createTask(@RequestBody Task task) {
        taskService.createTask(task);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable("id") int id) {
        taskService.deleteTask(id);
    }

    @PutMapping({"{id}"})
    public void updateTask(@PathVariable("id") int id, @RequestBody Task task) {
        taskService.updateTask(id, task);
    }

}
