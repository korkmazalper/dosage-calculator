package com.lab;

public enum PatientType {
    CHILD(1), ADULT(2), SENIOR(3);
    private final int ordinal;

    PatientType (int ordinal) {
        this.ordinal = ordinal;
    }
    public int getOrdinal() {
        return ordinal;
    }
}
