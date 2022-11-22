package com.salomeja2000.projectmanagementtool.userInformation;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInformationRowMapper implements RowMapper<UserInformation> {

    @Override
    public UserInformation mapRow(ResultSet resultSet, int i) throws SQLException {
        return new UserInformation(
                resultSet.getInt("id"),
                resultSet.getInt("user_id"),
                resultSet.getString("email"),
                resultSet.getString("phone"),
                resultSet.getString("home_address"),
                resultSet.getString("city"),
                resultSet.getString("postal_code")
        );
    }
}
