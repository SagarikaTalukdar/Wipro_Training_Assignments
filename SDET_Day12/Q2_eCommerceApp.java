package SDET_Day12;

/*E-Commerce Application
  How can Java File Handling be used to save product orders, invoices, and customer shipping details?
*/

import java.io.*;

public class Q2_eCommerceApp {

    public static void main(String[] args) {

        try {
            BufferedWriter orderWriter = new BufferedWriter(
                    new FileWriter("orders.txt", true));

            orderWriter.write("OrderID:1001 | Product:Laptop | Qty:1 | Price:70000");
            orderWriter.newLine();
            orderWriter.close();

            BufferedWriter invoiceWriter = new BufferedWriter(
                    new FileWriter("invoices.txt", true));

            invoiceWriter.write("InvoiceID:1001 | Amount:70000 | GST:18%");
            invoiceWriter.newLine();
            invoiceWriter.close();

            BufferedWriter shipWriter = new BufferedWriter(
                    new FileWriter("shipping.txt", true));

            shipWriter.write("OrderID:1001 | Name:Gaurav | Address:Kolkata | Phone:9999999999");
            shipWriter.newLine();
            shipWriter.close();

            BufferedReader orderReader = new BufferedReader(
                    new FileReader("orders.txt"));

            String line;
            System.out.println("----- Orders -----");
            while ((line = orderReader.readLine()) != null) {
                System.out.println(line);
            }
            orderReader.close();

            BufferedReader invoiceReader = new BufferedReader(
                    new FileReader("invoices.txt"));

            System.out.println("\n----- Invoices -----");
            while ((line = invoiceReader.readLine()) != null) {
                System.out.println(line);
            }
            invoiceReader.close();

            BufferedReader shipReader = new BufferedReader(
                    new FileReader("shipping.txt"));

            System.out.println("\n----- Shipping Details -----");
            while ((line = shipReader.readLine()) != null) {
                System.out.println(line);
            }
            shipReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
