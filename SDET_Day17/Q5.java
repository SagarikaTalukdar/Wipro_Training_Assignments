package SDET_Day17;

// Create stored procedure for employee search.

import java.sql.*;

public class Q5 {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "pass@word1");

            CallableStatement cs =
                    con.prepareCall("{call SearchEmployee(?)}");

            cs.setInt(1, 101);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " "
                        + rs.getString("name"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}