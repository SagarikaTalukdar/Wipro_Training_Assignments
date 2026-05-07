package SDET_Day3;

//Bank Account: allow only secure deposit/withdrawal.

import java.util.Scanner;

class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } 
        else {
            System.out.println("Invalid deposit!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } 
        else {
            System.out.println("Invalid withdrawal!");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Encapsulation_Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount acc = new BankAccount();

        System.out.print("Enter deposit amount: ");
        double d = sc.nextDouble();
        acc.deposit(d);

        System.out.print("Enter withdrawal amount: ");
        double w = sc.nextDouble();
        acc.withdraw(w);

        System.out.println("Final Balance: " + acc.getBalance());
        
        sc.close();
    }
}

