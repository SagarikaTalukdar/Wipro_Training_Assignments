package SDET_Day12;

/* Hospital Management System
   How will you implement Java IO classes to maintain patient records and generate medical reports?
*/

import java.io.*;

public class Q3_HospitalManagementSystem {

    public static void main(String[] args) {

        try {

            BufferedWriter patientWriter = new BufferedWriter(
                    new FileWriter("patients.txt", true));

            patientWriter.write("ID:101 | Name:Rahul | Age:25 | Disease:Flu");
            patientWriter.newLine();

            patientWriter.write("ID:102 | Name:Anita | Age:30 | Disease:Fever");
            patientWriter.newLine();

            patientWriter.close();

            PrintWriter reportWriter = new PrintWriter(
                    new FileWriter("reports.txt", true));

            reportWriter.println("----- Medical Report -----");
            reportWriter.println("Patient ID: 101");
            reportWriter.println("Name: Rahul");
            reportWriter.println("Diagnosis: Flu");
            reportWriter.println("Prescription: Rest + Medicines");
            reportWriter.println();

            reportWriter.close();

            BufferedReader patientReader = new BufferedReader(
                    new FileReader("patients.txt"));

            String line;
            System.out.println("----- Patient Records -----");

            while ((line = patientReader.readLine()) != null) {
                System.out.println(line);
            }

            patientReader.close();

            BufferedReader reportReader = new BufferedReader(
                    new FileReader("reports.txt"));

            System.out.println("\n----- Medical Reports -----");

            while ((line = reportReader.readLine()) != null) {
                System.out.println(line);
            }

            reportReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}