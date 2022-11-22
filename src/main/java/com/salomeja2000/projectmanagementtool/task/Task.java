package com.salomeja2000.projectmanagementtool.task;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {

    private int id;
    private int projectId;
    private String title;
    private String description;
    private int userId;
    private Priority priority;
    private Status status;
    private Date startingDate;
    private Date deadline;
    private Date dateCreated;
    private Date dateEdited;

    public int getPriority() {
        return priority.toInt();
    }

    public int getStatus() {
        return status.toInt();
    }
}
