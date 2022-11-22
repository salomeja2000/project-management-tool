package com.salomeja2000.projectmanagementtool.project;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ProjectRowMapper implements RowMapper<Project> {
    @Override
    public Project mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Project(
                resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getInt("manager_id"),
                resultSet.getDate("date_created"),
                resultSet.getDate("date_edited"),
                resultSet.getDate("starting_date"),
                resultSet.getDate("ending_date"),
                getProjectStatus(resultSet.getInt("status")),
                resultSet.getString("description")
        );
    }

    private Status getProjectStatus(int number) {
        return switch (number) {
            case 1 -> Status.PLANNING;
            case 2 -> Status.EXECUTION;
            case 3 -> Status.MONITORING_AND_CONTROLLING;
            case 4 -> Status.CLOSURE;
            case 5 -> Status.ARCHIVED;
            default -> Status.INITIATION;
        };
    }
}
