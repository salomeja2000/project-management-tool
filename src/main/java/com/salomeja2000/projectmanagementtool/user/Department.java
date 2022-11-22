package com.salomeja2000.projectmanagementtool.user;

public enum Department {
    GENERAL(0),
    ENGINEERING(1),
    OPERATIONS(2),
    PROJECT_MANAGEMENT(3),
    MARKETING(4),
    FINANCE(5);

    private final int department;

    Department(final int department) {
        this.department = department;
    }

    public int toInt() {
        return department;
    }
}
