package com.salomeja2000.projectmanagementtool.task;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class TaskRepository implements TaskDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Task> readAllTasks() {
        String statement = """
            SELECT Id, Project_ID, Title, Description, User_Id, Priority, Status, Starting_Date, Deadline, Date_Created, Date_Edited
            FROM Tasks;
            """;
        return jdbcTemplate.query(statement, new TaskRowMapper());
    }

    @Override
    public Optional<Task> readTask(int id) {
        String statement = """
            SELECT Id, Project_ID, Title, Description, User_Id, Priority, Status, Starting_Date, Deadline, Date_Created, Date_Edited
            FROM Tasks
            WHERE Id = ?;
            """;
        return jdbcTemplate.query(statement, new TaskRowMapper(), id).stream().findFirst();
    }

    @Override
    public int createTask(Task task) {
        String statement = """
            INSERT INTO Tasks (Project_ID, Title, Description, User_Id, Priority, Status, Starting_Date, Deadline, Date_Created, Date_Edited)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

        return jdbcTemplate.update(
            statement,
            task.getProjectId(),
            task.getTitle(),
            task.getDescription(),
            task.getUserId(),
            task.getPriority(),
            task.getStatus(),
            task.getStartingDate(),
            task.getDeadline(),
            task.getDateCreated(),
            task.getDateEdited()
        );
    }

    @Override
    public int deleteTask(int id) {
        String statement = """
            DELETE FROM Tasks 
            WHERE Id = ?;
            """;
        return jdbcTemplate.update(statement, id);
    }

    @Override
    public int updateTask(int id, Task newTask) {
        String statement = """
            UPDATE Tasks
            SET Project_ID = ?, Title = ?, Description = ?, User_Id = ?, Priority = ?, Status = ?, Starting_Date = ?, Deadline = ?, Date_Created = ?, Date_Edited = ?
            WHERE Id = ?;
            """;
        return jdbcTemplate.update(
            statement,
            newTask.getProjectId(),
            newTask.getTitle(),
            newTask.getDescription(),
            newTask.getUserId(),
            newTask.getPriority(),
            newTask.getStatus(),
            newTask.getStartingDate(),
            newTask.getDeadline(),
            newTask.getDateCreated(),
            newTask.getDateEdited(),
            id
        );
    }
}
