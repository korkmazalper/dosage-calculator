package com.lab.solutonOfamazon;

public class HealthCareDosage {
    // Task 1: Refactor Input Validation
    public static double calculateDosage(String patientType, double weight, int age) {
        /* TODO 1: use Amazon Q Developer's Explain Option to analyze input validation gaps.
            - highlight the calculateDosage method in your IDE and activate the Explain feature.
            - look for potential issues such as:
                - missing validation for weight > 0.
                - missing validation for age >= 0.
                - handling invalid or unsupported patientType values.
            - reflect on:
                - what could go wrong with the current code?
                - how could invalid inputs affect the overall system behavior?
        */

        /* TODO 2: use Amazon Q Developer's Refactor Option to add validation logic for weight and age.
            - ensure weight > 0 and age >= 0 are checked.
            - return "Error: Invalid input values" for invalid inputs.
        */
        if (weight <= 0 || age < 0) {
            throw new IllegalArgumentException("Error: Invalid input values");
        }

        /* TODO 3: use Amazon Q Developer's Refactor Option to validate patientType.#
            - add logic to ensure only "child", "adult", or "infant" are allowed.
            - return "Error: Invalid patient type" for other values.
        */
        if (!patientType.equalsIgnoreCase("child") &&
                !patientType.equalsIgnoreCase("adult") &&
                !patientType.equalsIgnoreCase("infant")) {
            throw new IllegalArgumentException("Error: Invalid patient type");
        }

        /* TODO 4: use Amazon Q Developer's Explain Option to Analyze Hardcoded Patterns.
            - highlight the calculateDosage method in your IDE.
            - use the Explain feature and focus on analyzing repetitive logic in the switch-case blocks.
            - reflect on:
                - how does hardcoding impact code maintainability and scalability?
                - what would make the code more reusable or easier to modify in the future?
        */
   /* TODO 7: use Amazon Q Developer's Explain Option to analyze current logic.
            - highlight the calculateDosage method and focus on how new patient types are currently handled.
        - use Explain to identify:
            - whether the code is flexible enough to accommodate new patient types like "infant".
            - potential areas where adding new cases might introduce errors or redundancy.
        - Reflect on:
            - what changes could make the code easier to extend for future patient types?
            - how can modularity help in integrating new types?
    */
        /* TODO 6: use Amazon Q Developer's Refactor Option to Integrate Modular Methods.
            - replace repetitive logic with calls to modular methods in the switch statement.
            - ensure the code is more readable and maintainable.
        */
        switch (patientType.toLowerCase()) {
            case "child":
                return calculateChildDosage(weight);
            case "adult":
                return calculateAdultDosage(weight, age);
            case "infant":
                /* TODO 9: use Amazon Q Developer's Refactor Option to Integrate the New Patient Type.
                    - add a case for "infant" in the Switch statement.
                    - call the calculateInfantDosage method for the "infant" case.
                */
                return calculateInfantDosage(weight);
            default:
                throw new IllegalArgumentException("Error: Invalid patient type");
        }
    }

    // Task 2: Modularize Dosage Logic
     /* TODO 5: use Amazon Q Developer's Refactor Option to Create Modular Methods.
                - highlight the repetitive logic in the if-else statements.
                - use the Refactor option to create modular methods:
                    - calculateChildDosage(double weight) for child dosage logic (weight * 2.5).
                    - calculateAdultDosage(double weight, int age) for adult dosage logic (age > 60 ? weight * 1.8 : weight * 2.0).
     */
    private static double calculateChildDosage(double weight) {
        return weight * 2.5;
    }

    private static double calculateAdultDosage(double weight, int age) {
        return age > 60 ? weight * 1.8 : weight * 2.0;
    }
    /* TODO 7: use Amazon Q Developer's Explain Option to analyze current logic.
             - highlight the calculateDosage method and focus on how new patient types are currently handled.
         - use Explain to identify:
             - whether the code is flexible enough to accommodate new patient types like "infant".
             - potential areas where adding new cases might introduce errors or redundancy.
         - Reflect on:
             - what changes could make the code easier to extend for future patient types?
             - how can modularity help in integrating new types?
     */
    private static double calculateInfantDosage(double weight) {
        /* TODO 8: use Amazon Q Developer's Refactor Option to add a new method calculateInfantDosage.
            - highlight repetitive patterns in dosage calculations.
            - use the Refactor option to create a method calculateInfantDosage(double weight).
            - add the formula for infant dosage (weight * 3.0) in this method.
        */
        return weight * 3.0;
    }

    // Task 4: Refactor for Scalability
    /* TODO 10: use Amazon Q Developer's Explain Option to Analyze Scalability.
        - highlight the switch statement in the calculateDosage method and activate Explain.
        - focus on:
            - suggestions for refactoring the switch-case logic into a more scalable structure (e.g., polymorphism).
            - identifying potential performance bottlenecks if new patient types were added.
        - reflect on:
            - how would the current structure handle a system with dozens of patient types?
            - what alternative approaches, like interfaces or design patterns, could improve scalability?
    */

    /* TODO 11: use Amazon Q Developer's Refactor Option to Implement a Patient Interface.
        - create a Patient interface with a method: double calculateDosage(double weight, int age).
        - ensure it can be implemented for different patient types (Child, Adult, Infant).
    */
    interface Patient {
        double calculateDosage(double weight, int age);
    }

    /* TODO 12: use Amazon Q Developer's Refactor Option to Create Concrete Classes for Patient Types.
        - create classes for Child, Adult, and Infant.
        - implement the Patient interface in each class, override double calculateDosage(double weight, int age),
          and define their dosage calculation logic:
            - Child: weight * 2.5.
            - Adult: age > 60 ? weight * 1.8 : weight * 2.0.
            - Infant: weight * 3.0.
    */
    static class Child implements Patient {
        public double calculateDosage(double weight, int age) {
            return weight * 2.5;
        }
    }

    static class Adult implements Patient {
        public double calculateDosage(double weight, int age) {
            return age > 60 ? weight * 1.8 : weight * 2.0;
        }
    }

    static class Infant implements Patient {
        public double calculateDosage(double weight, int age) {
            return weight * 3.0;
        }
    }

    public static double calculateDosage(Patient patient, double weight, int age) {
        /* TODO 12: integrate Polymorphism for Patient Types.
            - use the Patient interface to calculate dosage based on the type of patient (Child, Adult, Infant).
        */
        return patient.calculateDosage(weight, age);
    }

    public static void main(String[] args) {
        // Polymorphism-based approach
        Patient childPatient = new Child();
        Patient adultPatient = new Adult();
        Patient infantPatient = new Infant();

        System.out.println(childPatient.calculateDosage(30, 10)); // Expected: 75.0
        System.out.println(adultPatient.calculateDosage(70, 65)); // Expected: 126.0
        System.out.println(infantPatient.calculateDosage(5, 1));  // Expected: 15.0

        // Testing original calculateDosage method
        try {
            System.out.println(calculateDosage("child", 30, 10)); // Expected: 75.0
            System.out.println(calculateDosage("adult", 70, 65)); // Expected: 126.0
            System.out.println(calculateDosage("infant", 5, 1));  // Expected: 15.0
            System.out.println(calculateDosage("kids", 30, 10));  // Expected: Error: Invalid patient type
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}