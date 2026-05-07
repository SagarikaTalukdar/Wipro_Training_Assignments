package SDET_Day3;

//Employee class: hide salary and allow access only through getter/setter.

import java.util.Scanner;

class Employee {
    private double salary;

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } 
        else {
            System.out.println("Invalid salary!");
        }
    }

    public double getSalary() {
        return salary;
    }
}

public class Encapsulation_Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee emp = new Employee();

        System.out.print("Enter salary: ");
        double s = sc.nextDouble();

        emp.setSalary(s);
        System.out.println("Employee Salary: " + emp.getSalary());
        
        sc.close();
    }
}

