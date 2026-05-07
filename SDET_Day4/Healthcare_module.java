package SDET_Day4;

class Patient {
 private int id;
 private String name;
 private int age;
 private String illness;

 public Patient(int id, String name, int age, String illness) {
     this.id = id;
     this.name = name;
     this.age = age;
     this.illness = illness;
 }

 public int getId() { return id; }
 public String getName() { return name; }
 public int getAge() { return age; }
 public String getIllness() { return illness; }
}

interface PatientService {
 void registerPatient(Patient patient);
 void showPatients();
}

class PatientServiceImpl implements PatientService {
 private Patient[] patients = new Patient[10];
 private int count = 0;

 public void registerPatient(Patient patient) {
     if (count < patients.length) {
         patients[count] = patient;
         count++;
     } else {
         System.out.println("Patient list is full");
     }
 }

 public void showPatients() {
     for (int i = 0; i < count; i++) {
         Patient p = patients[i];
         System.out.println("ID: " + p.getId());
         System.out.println("Name: " + p.getName());
         System.out.println("Age: " + p.getAge());
         System.out.println("Illness: " + p.getIllness());
         System.out.println("----------------------");
     }
 }
}

abstract class Doctor {
 String name;

 public Doctor(String name) {
     this.name = name;
 }

 abstract void diagnose(Patient p);
}

class GeneralPhysician extends Doctor {

 public GeneralPhysician(String name) {
     super(name);
 }

 void diagnose(Patient p) {
     System.out.println("Dr. " + name + " (General Physician) treats " + p.getName());
 }
}

class Cardiologist extends Doctor {

 public Cardiologist(String name) {
     super(name);
 }

 void diagnose(Patient p) {
     if (p.getIllness().toLowerCase().contains("heart")) {
         System.out.println("Dr. " + name + " (Cardiologist) treats heart patient: " + p.getName());
     } else {
         System.out.println("Dr. " + name + " (Cardiologist) suggests General Physician for " + p.getName());
     }
 }
}

public class Healthcare_module {
 public static void main(String[] args) {

     PatientService service = new PatientServiceImpl();

     Patient p1 = new Patient(1, "Mukhila", 25, "Fever");
     Patient p2 = new Patient(2, "Braj", 40, "Heart Problem");

     service.registerPatient(p1);
     service.registerPatient(p2);

     service.showPatients();

     Doctor d1 = new GeneralPhysician("Basu");
     Doctor d2 = new Cardiologist("Roy");

     d1.diagnose(p1);
     d1.diagnose(p2);

     d2.diagnose(p1);
     d2.diagnose(p2);
 }
}
