package SDET_Day1;
import java.util.Scanner;

// Student information system

public class Day1Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your name : ");
		String name = sc.nextLine();
		
		System.out.print("Enter your age : ");
		int age = sc.nextInt();
		
		System.out.println("Enter your marks of 3 subjects : ");
		System.out.print("Maths : ");
		float math = sc.nextFloat();
		System.out.print("Physics : ");
		float phy = sc.nextFloat();
		System.out.print("Chemistry : ");
		float chem = sc.nextFloat();
		
		System.out.print("Enter your grade : ");
		int grade = sc.nextInt();
		
		float avg = (math + phy + chem) / 3;
		
		System.out.println("Name : " + name + " Age : " + age + " Grade : " + grade);
		System.out.println("Maths : " + math + " Physics : " + phy + " Chemistry : " + chem);
		System.out.println("Average is : " + avg);
		
		sc.close();
	}
}
