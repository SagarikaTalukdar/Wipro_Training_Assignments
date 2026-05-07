package SDET_Day10;
import java.util.*;

public class Q3_TreeMap {
	public static void main(String[] args) {
		
		TreeMap<Integer, String> patients = new TreeMap<>();
		patients.put(123, "Arka");
        patients.put(234, "Aniket");
        patients.put(301, "Debadyuti");
        patients.put(434, "Vasudha");
        patients.put(105, "Mukhila");
        
        System.out.println(patients);
        
        patients.put(105, "Mukhila Rai");
        
        System.out.println(patients.get(105));
        System.out.println(patients.get(434));
        
        System.out.println(patients.containsKey(108));
		System.out.println(patients.containsValue("Arka"));
		 
        patients.remove(301);
        
        System.out.println(patients.size());
        
        patients.clear();
	}
}