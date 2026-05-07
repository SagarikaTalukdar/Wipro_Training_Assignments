package SDET_Day12;

/* Food Delivery Application
   How can Java File Handling help in storing restaurant menus, customer orders, and delivery logs?
*/

import java.io.*;

public class Q4_FoodDeliveryApp {

    public static void main(String[] args) {

        try {
            BufferedWriter menuWriter = new BufferedWriter(
                    new FileWriter("menu.txt"));

            menuWriter.write("Pizza - 300");
            menuWriter.newLine();
            menuWriter.write("Burger - 150");
            menuWriter.newLine();
            menuWriter.write("Pasta - 250");
            menuWriter.close();

            BufferedReader menuReader = new BufferedReader(
                    new FileReader("menu.txt"));

            String line;
            System.out.println("----- MENU -----");

            while ((line = menuReader.readLine()) != null) {
                System.out.println(line);
            }

            menuReader.close();

            BufferedWriter orderWriter = new BufferedWriter(
                    new FileWriter("orders.txt", true)); // append mode

            orderWriter.write("OrderID:301 | Item:Pizza | Address:Kolkata");
            orderWriter.newLine();
            orderWriter.close();

            BufferedWriter deliveryWriter = new BufferedWriter(
                    new FileWriter("delivery.txt", true));

            deliveryWriter.write("OrderID:301 | Status:Delivered");
            deliveryWriter.newLine();
            deliveryWriter.close();

            BufferedReader orderReader = new BufferedReader(
                    new FileReader("orders.txt"));

            System.out.println("\n----- CUSTOMER ORDERS -----");

            while ((line = orderReader.readLine()) != null) {
                System.out.println(line);
            }

            orderReader.close();

            BufferedReader deliveryReader = new BufferedReader(
                    new FileReader("delivery.txt"));

            System.out.println("\n----- DELIVERY LOGS -----");

            while ((line = deliveryReader.readLine()) != null) {
                System.out.println(line);
            }

            deliveryReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}