package com.lab;



public final class Senior extends Patient {
    private static final int MIN_SENIOR_AGE = 60;
    private static final String AGE_ERROR_MESSAGE = "Error: Senior's age must be 60 or older.";
    private static final String WEIGHT_ERROR_MESSAGE = "Error: Invalid weight for a senior.";
    private static final double BASE_DOSAGE = 1.5;


    private Senior (int age, int weight) {
        super(PatientType.SENIOR, age, weight);
    }

    public static Senior createSenior(final int age, final int weight) {
        validateAge(age);
        validateWeight(weight);
        return new Senior(age, weight);
    }

    private static void validateAge(final int age) {
        if (age < MIN_SENIOR_AGE) {
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
        return BASE_DOSAGE*PatientType.SENIOR.getOrdinal();
    }
}
