package SDET_Day12;

/* Employee Management System
   How will you use Serialization in Java to save and retrieve employee objects from files?
*/

import java.io.*;

class Employee implements Serializable {
 int id;
 String name;
 double salary;

 Employee(int id, String name, double salary) {
     this.id = id;
     this.name = name;
     this.salary = salary;
 }
}

public class Q5_EmployeeManagementSystem {

 public static void main(String[] args) {

     try {
         ObjectOutputStream oos = new ObjectOutputStream(
                 new FileOutputStream("employee.dat"));

         Employee e1 = new Employee(101, "Gaurav", 50000);
         Employee e2 = new Employee(102, "Rahul", 60000);

         oos.writeObject(e1);
         oos.writeObject(e2);

         oos.close();

         ObjectInputStream ois = new ObjectInputStream(
                 new FileInputStream("employee.dat"));

         System.out.println("----- Employee Data -----");

         Employee emp1 = (Employee) ois.readObject();
         Employee emp2 = (Employee) ois.readObject();

         System.out.println(emp1.id + " " + emp1.name + " " + emp1.salary);
         System.out.println(emp2.id + " " + emp2.name + " " + emp2.salary);

         ois.close();

     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}