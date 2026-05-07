package SDET_Day2;

//Login Validation

public class Day2Q2 {
	public static void main(String[] args) {
		
		String cusername = "Sagarika";
		String cpassword = "1234";
		
		String username = "Sagarika";
		String password = "1234";
		
		if (username == cusername && password == cpassword) {
			System.out.println("Login Succesful!");
		}
		else {
			System.out.println("Login Failure!");
		}
	}
}
