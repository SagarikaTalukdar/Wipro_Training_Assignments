package SDET_Day17;

// Update employee salary using PreparedStatement.

import java.sql.*;

public class Q4 {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "pass@word1");

            String query = "UPDATE employee SET salary=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, 75000);
            ps.setInt(2, 104);

            int rows = ps.executeUpdate();

            System.out.println(rows + " Record Updated");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}