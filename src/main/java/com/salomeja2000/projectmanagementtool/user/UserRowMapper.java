package com.salomeja2000.projectmanagementtool.user;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getBoolean("is_manager"),
                getDepartmentValue(resultSet.getInt("department")),
                resultSet.getString("job_title"),
                resultSet.getInt("manager_id")
        );
    }

    private Department getDepartmentValue(int number) {
        return switch (number) {
            case 1 -> Department.ENGINEERING;
            case 2 -> Department.OPERATIONS;
            case 3 -> Department.PROJECT_MANAGEMENT;
            case 4 -> Department.MARKETING;
            case 5 -> Department.FINANCE;
            default -> Department.GENERAL;
        };
    }
}