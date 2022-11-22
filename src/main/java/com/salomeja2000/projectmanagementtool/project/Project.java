package com.salomeja2000.projectmanagementtool.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Project {
    private int id;
    private String title;
    private int managerId;
    private Date dateCreated;
    private Date dateEdited;
    private Date startingDate;
    private Date endingDate;
    private Status status;
    private String description;

    public int getStatus() {
        return status.toInt();
    }
}
