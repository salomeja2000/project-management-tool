package com.salomeja2000.projectmanagementtool.task;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class TaskRowMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Task(
                resultSet.getInt("id"),
                resultSet.getInt("project_id"),
                resultSet.getString("title"),
                resultSet.getString("description"),
                resultSet.getInt("user_id"),
                getPriorityValue(resultSet.getInt("priority")),
                getStatusValue(resultSet.getInt("status")),
                resultSet.getDate("starting_date"),
                resultSet.getDate("deadline"),
                resultSet.getDate("date_created"),
                resultSet.getDate("date_edited")
        );
    }
    private Priority getPriorityValue(int number) {
        return switch (number) {
            case 0 -> Priority.HIGHEST;
            case 1 -> Priority.HIGH;
            case 2 -> Priority.MEDIUM;
            case 3 -> Priority.LOW;
            default -> Priority.LOWEST;
        };
    }

    private Status getStatusValue(int number) {
        return switch (number) {
            case 1 -> Status.IN_PROGRESS;
            case 2 -> Status.IN_REVIEW;
            case 3 -> Status.QA;
            case 4 -> Status.DONE;
            default -> Status.TO_DO;
        };
    }
}
