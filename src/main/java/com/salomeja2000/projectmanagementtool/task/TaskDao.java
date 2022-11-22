package com.salomeja2000.projectmanagementtool.task;

import java.util.List;
import java.util.Optional;

public interface TaskDao {
    List<Task> readAllTasks();
    Optional<Task> readTask(int id);
    int createTask(Task task);
    int deleteTask(int id);
    int updateTask(int id, Task newTask);
}