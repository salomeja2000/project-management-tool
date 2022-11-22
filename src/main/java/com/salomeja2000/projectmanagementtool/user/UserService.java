package com.salomeja2000.projectmanagementtool.user;

import com.salomeja2000.projectmanagementtool.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserDao userDao;

    public List<User> readAllUsers() {
        return userDao.readAllUsers();
    }

    public User readUser(int id) {
        return userDao.readUser(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    public void createUser(User user) {
        int result = userDao.createUser(user);
        if (result != 1) {
            throw new IllegalStateException("Could not create a user, try again later");
        }
    }

    public void deleteUser(int id) {
        Optional<User> users = userDao.readUser(id);
        users.ifPresentOrElse(user -> {
            int result = userDao.deleteUser(id);
            if (result != 1) {
                throw new IllegalStateException("Could not delete the user, try again later");
            }
        }, () -> {
            throw new NotFoundException("User not found");
        });
    }

    public void updateUser(int id, User newUser) {
        Optional<User> users = userDao.readUser(id);
        users.ifPresentOrElse(user -> {
            int result = userDao.updateUser(id, newUser);
            if (result != 1) {
                throw new IllegalStateException("Could not update the user, try again later");
            }
        }, () -> {
            throw new NotFoundException("User not found");
        });
    }
}
