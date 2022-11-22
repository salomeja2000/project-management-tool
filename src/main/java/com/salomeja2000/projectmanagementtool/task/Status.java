package com.salomeja2000.projectmanagementtool.task;

public enum Status {
    TO_DO(0),
    IN_PROGRESS(1),
    IN_REVIEW(2),
    QA(3),
    DONE(4);

    private final int status;

    Status(final int status) {
        this.status = status;
    }

    public int toInt() {
        return status;
    }
}
