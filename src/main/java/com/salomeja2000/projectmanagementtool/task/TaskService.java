package com.salomeja2000.projectmanagementtool.task;

import com.salomeja2000.projectmanagementtool.exception.NotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TaskService {
    private final TaskDao taskDao;

    public List<Task> readAllTasks() {
        return taskDao.readAllTasks();
    }

    public Task readTask(int id) {
        return taskDao.readTask(id).orElseThrow(() -> new NotFoundException("Task not found"));
    }

    public void createTask(Task task) {
        int result = taskDao.createTask(task);
        if (result != 1) {
            throw new IllegalStateException("Could not create a task, try again later");
        }
    }

    public void deleteTask(int id) {
        Optional<Task> tasks = taskDao.readTask(id);
        tasks.ifPresentOrElse(task -> {
            int result = taskDao.deleteTask(id);
            if (result != 1) {
                throw new IllegalStateException("Could not delete the task, try again later");
            }
        }, () -> {
            throw new NotFoundException("Task not found");
        });
    }

    public void updateTask(int id, Task newTask) {
        Optional<Task> tasks = taskDao.readTask(id);
        tasks.ifPresentOrElse(task -> {
            int result = taskDao.updateTask(id, newTask);
            if (result != 1) {
                throw new IllegalStateException("Could not update the task, try again later");
            }
        }, () -> {
            throw new NotFoundException("Task not found");
        });
    }
}
