package SDET_Day9;
import java.util.*;

class Patient {
    int id;
    String name;
    int age;

    Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class Q1_arrayList {
    public static void main(String[] args) {

        ArrayList<Patient> patients = new ArrayList<>();

        patients.add(new Patient(1, "Rahul", 25));
        patients.add(new Patient(2, "Anjali", 25));
        patients.add(new Patient(3, "Naina", 22));

        System.out.println("All Patients:");
        for (Patient p : patients) {
            System.out.println("ID: " + p.id + ", Name: " + p.name + ", Age: " + p.age);
        }

        String searchName = "Aman";
        boolean found = false;

        for (Patient p : patients) {
            if (p.name.equalsIgnoreCase(searchName)) {
                System.out.println("Patient Found:");
                System.out.println("ID: " + p.id + ", Name: " + p.name + ", Age: " + p.age);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Patient not found.");
        }
    }
}