package SDET_Day9;
import java.util.*;

public class HospitalSystem_hashSet {
	public static void main(String[] args) {
        ArrayList<Integer> patients = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int n, id;

        System.out.print("Enter number of patients: ");
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            System.out.print("Enter patient ID: ");
            id = sc.nextInt();

            if(patients.contains(id)) {
                System.out.println("Already registered");
            } else {
                patients.add(id);
                System.out.println("Patient added to the system");
            }
        }
        
        String password;
        sc.nextLine();
        
        System.out.print("Enter staff password: ");
        password = sc.nextLine();

        if(password.equals("admin123")) {
            if(patients.size() == 0) {
                System.out.println("No patients registered yet");
            } else {
                System.out.println("List of registered patients:");
                for(int i = 0; i < patients.size(); i++) {
                    System.out.println(patients.get(i));
                }
            }
        } else {
            System.out.println("Access Denied! Staff only.");
        }
        
        sc.close();
	}
}

