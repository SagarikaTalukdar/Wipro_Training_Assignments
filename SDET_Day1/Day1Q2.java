package SDET_Day1;

// Employee Salary Calculator

public class Day1Q2 {
	public static void main(String[] args) {
		double basics = 30000;
		double bonus = 2000;
		double tax = 3000;
		double net_salary = basics+bonus-tax;
		System.out.println("Net salary : " + net_salary);
	}
}
