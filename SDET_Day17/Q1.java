package SDET_Day17;

// Insert 5 employee records using PreparedStatement.

import java.sql.*;

public class Q1 {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "pass@word1");

            String query = "INSERT INTO employee VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, 101);
            ps.setString(2, "Rahul");
            ps.setString(3, "IT");
            ps.setDouble(4, 55000);
            ps.executeUpdate();

            ps.setInt(1, 102);
            ps.setString(2, "Anita");
            ps.setString(3, "HR");
            ps.setDouble(4, 45000);
            ps.executeUpdate();

            ps.setInt(1, 103);
            ps.setString(2, "Amit");
            ps.setString(3, "Finance");
            ps.setDouble(4, 60000);
            ps.executeUpdate();

            ps.setInt(1, 104);
            ps.setString(2, "Priya");
            ps.setString(3, "IT");
            ps.setDouble(4, 70000);
            ps.executeUpdate();

            ps.setInt(1, 105);
            ps.setString(2, "Karan");
            ps.setString(3, "Sales");
            ps.setDouble(4, 48000);
            ps.executeUpdate();

            System.out.println("5 Records Inserted");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}