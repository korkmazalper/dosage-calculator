package com.lab;



public final class Adult extends Patient {
    private static final int MIN_ADULT_AGE = 13;
    private static final String AGE_ERROR_MESSAGE = "Error: Adult's age must be 13 or older.";
    private static final String WEIGHT_ERROR_MESSAGE = "Error: Invalid weight for an adult.";
    private static final double BASE_DOSAGE = 1;


    private Adult(int age, int weight) {
        super(PatientType.ADULT, age, weight);
    }

    public static Adult createAdult(final int age, final int weight) {
        validateAge(age);
        validateWeight(weight);
        return new Adult(age, weight);
    }

    private static void validateAge(final int age) {
        if (age < MIN_ADULT_AGE) {
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
        return BASE_DOSAGE*PatientType.ADULT.getOrdinal();
    }
}
