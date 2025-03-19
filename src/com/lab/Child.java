package com.lab;

public final class Child extends Patient {
    private static final int MAX_CHILD_AGE = 12;
    private static final String AGE_ERROR_MESSAGE = "Error: Child's age must be 12 or younger.";
    private static final String WEIGHT_ERROR_MESSAGE = "Error: Invalid weight for a child.";
    private static final double BASE_DOSAGE = 1.0;

    private Child(final int age, final int weight) {
        super(PatientType.CHILD, age, weight);
    }

    public static Child createChild(final int age, final int weight) {
        validateAge(age);
        validateWeight(weight);
        return new Child(age, weight);
    }

    private static void validateAge(final int age) {
        if (age > MAX_CHILD_AGE) {
            throw new IllegalArgumentException(AGE_ERROR_MESSAGE);
        }
    }

    private static void validateWeight(final int weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException(WEIGHT_ERROR_MESSAGE);
        }
    }

    @Override
    public double calculateDosage(final double weight, final int age) {
        return BASE_DOSAGE*PatientType.CHILD.getOrdinal();
    }
}
