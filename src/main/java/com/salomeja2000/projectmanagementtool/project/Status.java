package com.salomeja2000.projectmanagementtool.project;

public enum Status {
    INITIATION(0),
    PLANNING(1),
    EXECUTION(2),
    MONITORING_AND_CONTROLLING(3),
    CLOSURE(4),
    ARCHIVED(5);

    private final int status;

    Status(final int status) {
        this.status = status;
    }

    public int toInt() {
        return status;
    }
}
