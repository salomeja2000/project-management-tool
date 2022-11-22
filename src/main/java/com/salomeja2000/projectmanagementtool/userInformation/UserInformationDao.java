package com.salomeja2000.projectmanagementtool.userInformation;

import java.util.Optional;

public interface UserInformationDao {
    Optional<UserInformation> readUserInformation(int id);
    int createUserInformation(UserInformation userInformation);
    int deleteUserInformation(int id);
    int updateUserInformation(int id, UserInformation newUserInformation);
}