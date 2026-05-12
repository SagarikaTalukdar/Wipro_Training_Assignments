package SDET_Day17;

// Count total employees using SQL COUNT().

import java.sql.*;

public class Q6 {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "pass@word1");

            String query = "SELECT COUNT(*) FROM employee";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                System.out.println("Total Employees: " + rs.getInt(1));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}