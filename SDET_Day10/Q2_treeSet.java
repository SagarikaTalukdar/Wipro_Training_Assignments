package SDET_Day10;

import java.util.TreeSet;

public class Q2_treeSet {
	public static void main(String[] args) {
		TreeSet<Integer> patients = new TreeSet<>();
        int[] incomingPatients = {101, 102, 103, 101, 104, 102};

        for (int id : incomingPatients) {

            if (patients.contains(id)) {
                System.out.println("ID " + id + " already registered");
            } 
            else {
                patients.add(id);
                System.out.println("Patient with ID " + id + " added to system");
            }
        }

        System.out.println("List of unique registered patients:");
        for (int id : patients) {
            System.out.println(id);
        }
	}
}
/* Maam's Implementation :

package Collection;
import java.util.*;
 
public class HospitalSystem implements Comparable<HospitalSystem> {
int id;
String name;
 
public HospitalSystem(int id, String name)
{
	this.id=id;
	this.name=name;
}
@Override
public int compareTo(HospitalSystem p)
{
	return this.id - p.id;
}
@Override
public String toString()
{
	return id + " - " + name;
}
 
public static void main(String[] args)
	{
	TreeSet<HospitalSystem> patients=new TreeSet<>();
	
	patients.add(new HospitalSystem(101, "Vinay"));
	patients.add(new HospitalSystem(102, "Sonali"));
	patients.add(new HospitalSystem(103, "Radhya"));
	patients.add(new HospitalSystem(101, "Vinay"));
	
	System.out.println("Unique Registered Patients");
	for(HospitalSystem p: patients)
	{
		System.out.println(p);
	}
 
	}
 
}
 
 */