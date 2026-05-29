package SDET_Day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();

        Thread.sleep(3000);

        driver.findElement(By.id("add-to-cart")).click();

        Thread.sleep(3000);

        driver.findElement(By.id("back-to-products")).click();

        Thread.sleep(3000);

        driver.findElement(By.className("shopping_cart_link")).click();

        Thread.sleep(3000);

        driver.findElement(By.id("checkout")).click();

        Thread.sleep(3000);

        driver.findElement(By.id("first-name")).sendKeys("Shaurya");

        Thread.sleep(2000);

        driver.findElement(By.id("last-name")).sendKeys("Chatterjee");

        Thread.sleep(2000);

        driver.findElement(By.id("postal-code")).sendKeys("123456");

        Thread.sleep(2000);

        driver.findElement(By.id("continue")).click();

        Thread.sleep(3000);

        driver.findElement(By.id("finish")).click();

        Thread.sleep(3000);

        System.out.println(driver.getTitle());

        System.out.println("Order placed successfully");

        driver.quit();
    }
}