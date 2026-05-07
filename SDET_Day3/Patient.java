package SDET_Day3;

//Patient record system: protect patient health info.

import java.util.Scanner;

public class Patient {
	private String name;
	private String diagnosis;
	public void setDetails(String name,String diagnosis) {
		this.name=name;
		this.diagnosis=diagnosis;
	}
	public String getDetails() {
		return "Name: " + name + ", Diagnosis: " + diagnosis;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Patient p = new Patient();
		System.out.print("Enter Patient Name: ");
	    String name = sc.nextLine();
	    System.out.print("Enter Diagnosis: ");
	    String diagnosis = sc.nextLine();
	    p.setDetails(name, diagnosis);
	    System.out.println("\nPatient Details:");
	    System.out.println(p.getDetails());
	    sc.close();
	}
}