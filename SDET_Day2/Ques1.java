package SDET_Day2;

//Employee Salary Increment System

public class Ques1 {
	public static void main(String[] args) {
		double[] salaries = {25000, 30000, 35000, 40000, 45000, 50000, 30000, 40000, 65000, 35000};

        for (int i = 0; i < salaries.length; i++) {
            salaries[i] = salaries[i] + (salaries[i] * 0.10);
        }

        System.out.println("Updated Salaries:");
        for (double salary : salaries) {
            System.out.println(salary);
        }
	}

}
