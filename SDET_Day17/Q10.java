package SDET_Day17;

// Implement CRUD operations using JDBC.

import java.sql.*;
import java.util.Scanner;

public class Q10 {

    static final String URL =
            "jdbc:mysql://localhost:3306/company";

    static final String USER = "root";
    static final String PASSWORD = "pass@word1";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            int choice;

            do {

                System.out.println("\n===== CRUD OPERATIONS =====");
                System.out.println("1. Insert Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee Salary");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");

                System.out.print("Enter Choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:

                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        String insertQuery =
                                "INSERT INTO employees VALUES(?,?,?,?)";

                        PreparedStatement ps1 =
                                con.prepareStatement(insertQuery);

                        ps1.setInt(1, id);
                        ps1.setString(2, name);
                        ps1.setString(3, dept);
                        ps1.setDouble(4, salary);

                        int insert = ps1.executeUpdate();

                        System.out.println(insert +
                                " Record Inserted");

                        break;

                    case 2:

                        String selectQuery =
                                "SELECT * FROM employees";

                        Statement st =
                                con.createStatement();

                        ResultSet rs =
                                st.executeQuery(selectQuery);

                        System.out.println(
                                "\nID\tNAME\tDEPARTMENT\tSALARY");

                        while (rs.next()) {

                            System.out.println(
                                    rs.getInt("id") + "\t"
                                    + rs.getString("name") + "\t"
                                    + rs.getString("department") + "\t"
                                    + rs.getDouble("salary"));
                        }

                        break;

                    case 3:

                        System.out.print(
                                "Enter Employee ID: ");

                        int updateId = sc.nextInt();

                        System.out.print(
                                "Enter New Salary: ");

                        double newSalary = sc.nextDouble();

                        String updateQuery =
                                "UPDATE employee SET salary=? WHERE id=?";

                        PreparedStatement ps2 =
                                con.prepareStatement(updateQuery);

                        ps2.setDouble(1, newSalary);
                        ps2.setInt(2, updateId);

                        int update = ps2.executeUpdate();

                        System.out.println(update +
                                " Record Updated");

                        break;

                    case 4:

                        System.out.print(
                                "Enter Employee ID to Delete: ");

                        int deleteId = sc.nextInt();

                        String deleteQuery =
                                "DELETE FROM employee WHERE id=?";

                        PreparedStatement ps3 =
                                con.prepareStatement(deleteQuery);

                        ps3.setInt(1, deleteId);

                        int delete = ps3.executeUpdate();

                        System.out.println(delete +
                                " Record Deleted");

                        break;

                    case 5:

                        System.out.println("Program Ended");
                        break;

                    default:

                        System.out.println("Invalid Choice");
                }

            } while (choice != 5);

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }

        sc.close();
    }
}