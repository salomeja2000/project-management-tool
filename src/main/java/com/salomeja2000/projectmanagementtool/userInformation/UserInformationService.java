package com.salomeja2000.projectmanagementtool.userInformation;

import com.salomeja2000.projectmanagementtool.exception.NotFoundException;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserInformationService {
    private final UserInformationDao userInformationDao;

    public UserInformation readUserInformation(int id) {
        return userInformationDao.readUserInformation(id).orElseThrow(() -> new NotFoundException("User information not found"));
    }

    public void createUserInformation(UserInformation userInformation) {
        int result = userInformationDao.createUserInformation(userInformation);
        if (result != 1) {
            throw new IllegalStateException("Could not create an entry, try again later");
        }
    }

    public void deleteUserInformation(int id) {
        Optional<UserInformation> entries = userInformationDao.readUserInformation(id);
        entries.ifPresentOrElse(userInformation -> {
            int result = userInformationDao.deleteUserInformation(id);
            if (result != 1) {
                throw new IllegalStateException("Could not delete an entry, try again later");
            }
        }, () -> {
            throw new NotFoundException("User information not found");
        });
    }

    public void updateUserInformation(int id, UserInformation newUserInformation) {
        Optional<UserInformation> entries = userInformationDao.readUserInformation(id);
        entries.ifPresentOrElse(userInformation -> {
            int result = userInformationDao.updateUserInformation(id, newUserInformation);
            if (result != 1) {
                throw new IllegalStateException("Could not update the user, try again later");
            }
        }, () -> {
            throw new NotFoundException("User information not found");
        });
    }
}
