package com.salomeja2000.projectmanagementtool.user;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> readAllUsers();
    Optional<User> readUser(int id);
    int createUser(User user);
    int deleteUser(int id);
    int updateUser(int id, User newUser);

}
