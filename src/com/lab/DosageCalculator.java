package com.lab;

public class DosageCalculator {
    public double calculateDosage(Patient patient) {
        return patient.calculateDosage(patient.getWeight(), patient.getAge());
    }
}
