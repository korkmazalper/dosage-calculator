# dosage-calculator
Dosage-calculator calculates the daily dosage of a medicine for different age-groups by the use of OOP principles.

# class diagramm

````mermaid
classDiagram
direction TB
class Adult {
  - Adult(int, int) 
  - validateWeight(int) void
  + calculateDosage(double, int) double
  + createAdult(int, int) Adult
  - validateAge(int) void
}
class Child {
  - Child(int, int) 
  + createChild(int, int) Child
  - validateAge(int) void
  + calculateDosage(double, int) double
  - validateWeight(int) void
}
class DosageCalculator {
  + DosageCalculator() 
  + calculateDosage(Patient) double
}
class DosageCalculatorMain {
  + DosageCalculatorMain() 
  + main(String[]) void
}
class Patient {
  + Patient(PatientType, int, int) 
  - PatientType patientType
  - int age
  - int weight
  + calculateDosage(double, int) double
   int weight
   int age
   PatientType patientType
}
class PatientType {
<<enumeration>>
  - PatientType(int) 
  - int ordinal
  + valueOf(String) PatientType
  + values() PatientType[]
   int ordinal
}

Adult  -->  Patient 
Child  -->  Patient 
Patient "1" *--> "patientType 1" PatientType 
````

# features
- The creation of the instances is controlled by the use of static factory pattern.
- Dosage Calculator calculates the dosage for each type of patients using the calculation methods of patients.
