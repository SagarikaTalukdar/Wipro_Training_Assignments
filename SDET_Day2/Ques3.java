package SDET_Day2;

//ATM Menu System

public class Ques3 {
	public static void main(String[] args) {
		
		int[] choices = {1, 2, 3, 4};

        for (int choice : choices) {
            switch (choice) {
                case 1:
                    System.out.println("Check Balance");
                    break;
                case 2:
                    System.out.println("Withdraw Money");
                    break;
                case 3:
                    System.out.println("Deposit Money");
                    break;
                case 4:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid Option");
            }
        }
	}

}
