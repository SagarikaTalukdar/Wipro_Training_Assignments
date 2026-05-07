package SDET_Day5;

/* 2. You are building a payment system where the method processPayment() contains secure logic and should not be 
	overridden by any subclass. Question: How will you design a class using the final keyword to prevent method 
	overriding? Implement with an example.
*/

class PaymentSystem{
    final void processPayment() {
        System.out.println("Processing secure payment...");
    }
}

class Ccard extends PaymentSystem {
    void show() {
        System.out.println("Payment done using Credit Card");
    }
}

public class Final_Method {
    public static void main(String[] args) {
        Ccard obj = new Ccard();
        obj.processPayment();
        obj.show();
    }
}