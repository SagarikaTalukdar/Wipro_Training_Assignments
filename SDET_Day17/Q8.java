package SDET_Day17;

// Create login validation using JDBC.

import java.sql.*;
import java.util.Scanner;

public class Q8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "pass@word1");

            String query =
                    "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Invalid Username or Password");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        sc.close();
    }
}