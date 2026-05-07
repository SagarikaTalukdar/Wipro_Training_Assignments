package SDET_Day10;

import java.util.*;

public class Q3_HashMap {
	public static void main(String[] args) {
		
		HashMap <Integer, String> patients = new HashMap<>();
		 patients.put(103, "Sagarika");
		 patients.put(321, "Shaurya");
		 patients.put(222, "Arpan");
		 patients.put(401, "Sagnik");
		 patients.put(124, "Gaurav");
		 patients.put(103, "Sagarika");
		 
		 System.out.println(patients);
		 
		 patients.put(124, "Gaurav Kumar");
		 
		 System.out.println(patients.get(401));
		 
		 System.out.println(patients.containsKey(102));
		 System.out.println(patients.containsValue("Arpan"));
		 
		 patients.remove(103);
		 
		 System.out.println(patients);
		 
		 System.out.println(patients.size());
		 
		 patients.clear();
	}
}
