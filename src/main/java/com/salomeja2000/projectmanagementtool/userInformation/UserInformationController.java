package com.salomeja2000.projectmanagementtool.userInformation;

import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/user-information")
public class UserInformationController {
    private final UserInformationService userInformationService;

    @GetMapping("{id}")
    public UserInformation readUserInformation(@PathVariable("id") int id) {
        return userInformationService.readUserInformation(id);
    }

    @PostMapping
    public void createUserInformation(@RequestBody UserInformation userInformation) {
        userInformationService.createUserInformation(userInformation);
    }

    @DeleteMapping("{id}")
    public void deleteUserInformation(@PathVariable("id") int id) {
        userInformationService.deleteUserInformation(id);
    }

    @PutMapping({"{id}"})
    public void updateUserInformation(@PathVariable("id") int id, @RequestBody UserInformation userInformation) {
        userInformationService.updateUserInformation(id, userInformation);
    }
}
