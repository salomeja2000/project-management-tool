package com.salomeja2000.projectmanagementtool.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int id;
    private String name;
    private boolean isManager;
    private Department department;
    private String jobTitle;
    private int managerId;

    public int getDepartment() {
        return department.toInt();
    }
}
