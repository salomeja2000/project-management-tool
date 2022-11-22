package com.salomeja2000.projectmanagementtool.task;

public enum Priority {
    HIGHEST(0),
    HIGH(1),
    MEDIUM(2),
    LOW(3),
    LOWEST(4);

    private final int priority;

    Priority(final int priority) {
        this.priority = priority;
    }

    public int toInt() {
        return priority;
    }
}
