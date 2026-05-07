package SDET_Day6;

import java.util.Scanner;

interface ATMSystem {
 void enterPIN(int pin) throws Exception;
}

class ATM implements ATMSystem {
 int correctPIN = 1234;

 public void enterPIN(int pin) throws Exception {
     if (pin != correctPIN) {
         throw new Exception("Incorrect PIN!");
     } else {
         System.out.println("PIN accepted. Access granted.");
     }
 }
}

public class ExceptionHandling_Q1 {
 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);
     ATMSystem atm = new ATM();

     try {
         System.out.println("Insert card...");
         System.out.print("Enter PIN: ");
         int pin = sc.nextInt();

         atm.enterPIN(pin);

     } catch (Exception e) {
         System.out.println("Exception: " + e.getMessage());

     } finally {
         System.out.println("Transaction logged.");
     }

     sc.close();
 }
}