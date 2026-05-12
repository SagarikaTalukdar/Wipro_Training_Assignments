package SDET_Day17;

// Fetch employees department-wise.

import java.sql.*;

public class Q9 {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "pass@word1");

            String query =
                    "SELECT * FROM employee ORDER BY department";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " "
                        + rs.getString("name") + " "
                        + rs.getString("department") + " "
                        + rs.getDouble("salary"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}