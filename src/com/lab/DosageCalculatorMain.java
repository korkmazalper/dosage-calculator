package com.lab;

public class DosageCalculatorMain {
    public static void main (String[] args) {
        try{
            Child child = Child.createChild(10, 15);
            Adult adult = Adult.createAdult(30, 70);
            Senior senior=Senior.createSenior(70, 60);
            DosageCalculator dosageCalculator=new DosageCalculator();
            System.out.println("Daily dosage für "+ child.getPatientType() +" : "+ dosageCalculator.calculateDosage(child));
            System.out.println("Daily dosage für "+ adult.getPatientType() +" : "+dosageCalculator.calculateDosage(adult));
            System.out.println("Daily dosage für "+ senior.getPatientType() +" : "+dosageCalculator.calculateDosage(senior));
            }catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }

    }
}
