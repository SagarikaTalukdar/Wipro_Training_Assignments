package SDET_Day2;

// ATM Withdrawal

public class Day2Q3 {
	public static void main(String[] args) {
		
		float balance = 60000;
		float withdrawAmount = 90000;
		
		if (balance>= withdrawAmount) {
			balance = balance - withdrawAmount;
			System.out.println("Withdrawal Successful!");
			System.out.println("Remaining Balance : " + balance);
		}
		else {
			System.out.println("Insufficient Balance!");
		}
	}

}