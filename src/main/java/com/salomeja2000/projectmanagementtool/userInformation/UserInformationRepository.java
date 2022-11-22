package com.salomeja2000.projectmanagementtool.userInformation;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class UserInformationRepository implements UserInformationDao {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public Optional<UserInformation> readUserInformation(int id) {
        String statement = """
            SELECT Id, User_ID, Email, Phone, Home_Address, City, Postal_Code
            FROM User_Information
            WHERE Id = ?;
            """;
        return jdbcTemplate.query(statement, new UserInformationRowMapper(), id).stream().findFirst();
    }

    @Override
    public int createUserInformation(UserInformation userInformation) {
        String statement = """
            INSERT INTO User_Information (User_ID, Email, Phone, Home_Address, City, Postal_Code)
            VALUES (?, ?, ?, ?, ?, ?);
            """;
        return jdbcTemplate.update(
            statement,
            userInformation.getUserId(),
            userInformation.getEmail(),
            userInformation.getPhone(),
            userInformation.getHomeAddress(),
            userInformation.getCity(),
            userInformation.getPostalCode()
        );
    }

    @Override
    public int deleteUserInformation(int id) {
        String statement = """
            DELETE FROM User_Information 
            WHERE Id = ?;
            """;
        return jdbcTemplate.update(statement, id);
    }

    @Override
    public int updateUserInformation(int id, UserInformation newUserInformation) {
        String statement = """
            UPDATE User_Information
            SET Email = ?, Phone = ?, Home_Address = ?, City = ?, Postal_Code = ?
            WHERE ID = ?;
            """;
        return jdbcTemplate.update(
                statement,
                newUserInformation.getEmail(),
                newUserInformation.getPhone(),
                newUserInformation.getHomeAddress(),
                newUserInformation.getCity(),
                newUserInformation.getPostalCode(),
                id
        );
    }
}
