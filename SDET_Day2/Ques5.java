package SDET_Day2;

//Shopping Cart Total Calculator

public class Ques5 {
	public static void main(String[] args) {
		
		double[] prices = {100, 250, 75, 0};

        double total = 0;

        for (double price : prices) {
            if (price == 0) {
                break;
            }
            total += price;
        }

        System.out.println("Total Amount: " + total);
	}

}
