package SDET_Day5;

/* 1. You are developing a banking application. Each customer has an Account Number that should never change once 
	assigned. Question: How will you use the final keyword to ensure the account number cannot be modified after 
	initialization? Write a Java program. 
*/

class BankAccount {
    final int BankAcNo;
    BankAccount(int accNo) {
        BankAcNo = accNo;
    }

    void display() {
        System.out.println("Account Number: " + BankAcNo);
    }
}

public class Final_Variable {
    public static void main(String[] args) {
        BankAccount obj = new BankAccount(12345);
        obj.display();
    }
}
