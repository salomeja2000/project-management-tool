package com.salomeja2000.projectmanagementtool.userInformation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInformation {
    private int id;
    private int userId;
    private String email;
    private String phone;
    private String homeAddress;
    private String city;
    private String postalCode;
}
