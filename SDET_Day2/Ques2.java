package SDET_Day2;

//Password Retry System

public class Ques2 {
	public static void main(String[] args) {
		String correctPassword = "admin123";
        String[] attempts = {"1234", "pass", "admin123"};

        int maxAttempts = 3;
        boolean success = false;

        for (int i = 0; i < maxAttempts; i++) {
            if (attempts[i].equals(correctPassword)) {
                System.out.println("Login Successful");
                success = true;
                break;
            } else {
                System.out.println("Wrong Password");
            }
        }

        if (!success) {
            System.out.println("Account Locked");
        }
	}

}
