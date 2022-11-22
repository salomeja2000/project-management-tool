package com.salomeja2000.projectmanagementtool.user;

public enum Department {
    ENGINEERING(1),
    OPERATIONS(2),
    PROJECT_MANAGEMENT(3),
    MARKETING(4),
    FINANCE(5),
    GENERAL(6);

    private final int department;

    Department(final int department) {
        this.department = department;
    }

    public int toInt() {
        return department;
    }
}
