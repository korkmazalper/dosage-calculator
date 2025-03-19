package com.lab;

public abstract class Patient {

    private PatientType patientType;
    private int age;
    private int weight;

    public abstract double calculateDosage(double weight, int age);

    public Patient (PatientType patientType, int age, int weight) {
        if(age<0 || weight<=0){
            throw new IllegalArgumentException("Error: Invalid patient data");
        }
        this.patientType = patientType;
        this.age = age;
        this.weight = weight;
    }

    public PatientType getPatientType () {
        return patientType;
    }

    public void setPatientType (PatientType patientType) {
        this.patientType = patientType;
    }

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public int getWeight () {
        return weight;
    }

    public void setWeight (int weight) {
        this.weight = weight;
    }
}
