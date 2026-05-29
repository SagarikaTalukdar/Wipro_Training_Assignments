package SDET_Day26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDT_SQL {

    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/seleniumdb",
                    "root",
                    "Sagarika@99");

            System.out.println(
                    "Database Connected Successfully");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                    "SELECT * FROM login_data");

            while (rs.next()) {

                String Username =
                        rs.getString("username");

                String Password =
                        rs.getString("password");

                WebDriver driver = new ChromeDriver();

                driver.get("https://www.saucedemo.com");
                driver.manage().window().maximize();
                System.out.println("Website Opened");

                driver.findElement(By.id("user-name"))
                        .sendKeys(Username);

                System.out.println(
                        "Username Entered : " + Username);

                driver.findElement(By.id("password"))
                        .sendKeys(Password);

                System.out.println("Password Entered");

                driver.findElement(By.id("login-button"))
                        .click();

                System.out.println(
                        "Login Button Clicked");

                System.out.println(
                        "Login Test Completed Successfully");

                driver.quit();

                System.out.println("Browser Closed");

                System.out.println(
                        "-----------------------------------");
            }

            con.close();

            System.out.println(
                    "All Database DDT Test Cases Executed Successfully");

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}