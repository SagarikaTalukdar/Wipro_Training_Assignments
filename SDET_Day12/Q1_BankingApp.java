package SDET_Day12;

/* Banking Application
   How will you use Java IO File Handling to store customer transaction history and read account details from files?
*/
import java.io.*;

public class Q1_BankingApp {

    public static void main(String[] args) {

        try {
        	BufferedWriter accWriter = new BufferedWriter(new FileWriter("accounts.txt"));
            accWriter.write("101 Gaurav 15000");
            accWriter.newLine();
            accWriter.write("102 Rahul 12000");
            accWriter.newLine();
            accWriter.close();

            BufferedWriter transWriter = new BufferedWriter(new FileWriter("transactions.txt", true));

            transWriter.write("AccNo:101 | Deposit:5000");
            transWriter.newLine();

            transWriter.write("AccNo:102 | Withdraw:2000");
            transWriter.newLine();

            transWriter.close();

            BufferedReader accReader = new BufferedReader(new FileReader("accounts.txt"));

            String line;
            System.out.println("------Account Details------");

            while ((line = accReader.readLine()) != null) {
                System.out.println(line);
            }

            accReader.close();

            BufferedReader transReader = new BufferedReader(new FileReader("transactions.txt"));

            System.out.println("\n----Transaction History----");

            while ((line = transReader.readLine()) != null) {
                System.out.println(line);
            }

            transReader.close();

        }
        catch (IOException e) {
        	e.printStackTrace();
        }
    }
}