package com.salomeja2000.projectmanagementtool.user;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class UserRepository implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<User> readAllUsers() {
        String statement = """
                SELECT Id, Name, Is_Manager, Department, Job_Title, Manager_Id
                FROM Users
                LIMIT 20;
                """;
        return jdbcTemplate.query(statement, new UserRowMapper());
    }

    @Override
    public Optional<User> readUser(int id) {
        String statement = """
                SELECT Id, Name, Is_Manager, Department, Job_Title, Manager_Id
                FROM Users
                WHERE Id = ?;
                """;
        return jdbcTemplate.query(statement, new UserRowMapper(), id).stream().findFirst();
    }

    public int createUser (User user) {
        String statement = """
            INSERT INTO Users (Name, Is_Manager, Department, Job_Title, Manager_Id)
            VALUES ( ?, ?, ?, ?, ? );
            """;

        return jdbcTemplate.update(
                statement,
                user.getName(),
                user.isManager(),
                user.getDepartment(),
                user.getJobTitle(),
                user.getManagerId()
        );
    }

    @Override
    public int deleteUser(int id) {
        String statement = """
            DELETE FROM Users 
            WHERE Id = ?;
            """;

        return jdbcTemplate.update(statement,id);
    }

    @Override
    public int updateUser(int id, User newUser) {
        String statement = """
            UPDATE Users 
            SET Name  = ?, Is_Manager = ?, Department = ?, Job_Title = ?, Manager_Id = ?
            WHERE Id = ?;
            """;

        return jdbcTemplate.update(
                statement,
                newUser.getName(),
                newUser.isManager(),
                newUser.getDepartment(),
                newUser.getJobTitle(),
                newUser.getManagerId(),
                id
        );
    }

}
