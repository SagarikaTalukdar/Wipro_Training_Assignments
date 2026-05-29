package SDET_Day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParaBankLogin {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        driver.manage().window().maximize();

        driver.findElement(By.linkText("Register")).click();

        Thread.sleep(3000);

        driver.findElement(By.id("customer.firstName")).sendKeys("Shaurya");
        driver.findElement(By.id("customer.lastName")).sendKeys("Chatterjee");
        driver.findElement(By.id("customer.address.street")).sendKeys("ABC Street");
        driver.findElement(By.id("customer.address.city")).sendKeys("Kolkata");
        driver.findElement(By.id("customer.address.state")).sendKeys("West Bengal");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("123456");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("0987654321");
        driver.findElement(By.id("customer.ssn")).sendKeys("2345678");
        driver.findElement(By.id("customer.username")).sendKeys("Shaurya_02");
        driver.findElement(By.id("customer.password")).sendKeys("2909");
        driver.findElement(By.id("repeatedPassword")).sendKeys("2909");

        driver.findElement(By.xpath("//input[@value='Register']")).click();

        Thread.sleep(5000);

        System.out.println("Registration Successful");

        driver.findElement(By.xpath("//a[text()='home']")).click();

        Thread.sleep(3000);

        driver.findElement(By.name("username")).sendKeys("Shaurya_02");

        Thread.sleep(2000);

        driver.findElement(By.name("password")).sendKeys("2909");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        System.out.println("Login Successful");

        Thread.sleep(5000);

        driver.quit();
    }
}