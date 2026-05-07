package SDET_Day5;

//develop payment system using interface and default method.

import java.util.Scanner;

interface Payment{
	void pay(double amount);
	default void trans_status() {
		System.out.println("Transaction Succesful!");
	}
}

class Cash implements Payment {
	public void pay(double amount) {
		System.out.println("Paid " + amount + " using Cash.");
	}
}

class CreditCard implements Payment {
	public void pay(double amount) {
		System.out.println("Paid " + amount + " using Credit Card.");
	}
}

class DeditCard implements Payment {
	public void pay(double amount) {
		System.out.println("Paid " + amount + " using Dedit Card.");
	}
}

class UPI implements Payment {
	public void pay(double amount) {
		System.out.println("Paid " + amount + " using UPI.");
	}
}

public class Inferface_Default {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Select payment method(Cash / Credit Card / UPI): ");
		String pay_method = sc.nextLine();
		
		System.out.println("Select Amount: ");
		double amount = sc.nextDouble();
        Payment p;

        if(pay_method.equalsIgnoreCase("Cash")) {
            p = new Cash();
        }
        else if(pay_method.equalsIgnoreCase("Credit Card")) {
            p = new CreditCard();
        }
        else if(pay_method.equalsIgnoreCase("Dedit Card")) {
            p = new DeditCard();
        }
        else if(pay_method.equalsIgnoreCase("UPI")) {
            p = new UPI();
        }
        else {
            System.out.println("Invalid method");
            sc.close();
            return;
        }

        p.pay(amount);
        p.trans_status();
        
        sc.close();
	}
}
