package com.salomeja2000.projectmanagementtool.user;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> readAllUsers() {
        return userService.readAllUsers();
    }

    @GetMapping("{id}")
    public User readUser(@PathVariable("id") int id) {
            return userService.readUser(id);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }

    @PutMapping({"{id}"})
    public void updateUser(@PathVariable("id") int id, @RequestBody User user) {
        userService.updateUser(id, user);
    }
}
