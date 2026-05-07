package SDET_Day5;

/*3. You are creating a security module (like encryption logic) and you want to make sure no other developer can extend 
	and modify this class.Question: How will you use the final keyword to restrict inheritance? Write a Java example
*/

final class Security {
    void encrypt() {
        System.out.println("Data encrypted successfully");
    }
}

public class Final_Class {
    public static void main(String[] args) {
        Security obj = new Security();
        obj.encrypt();
    }
}