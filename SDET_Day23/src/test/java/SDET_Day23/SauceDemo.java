package SDET_Day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
public class SauceDemo
{
 
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.out.println("Launching Browser");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
	}
	 @Test
	    public void loginAndCheckout() throws InterruptedException {

	        // Enter Username
	        driver.findElement(By.id("user-name")).sendKeys("standard_user");

	        Thread.sleep(2000);

	        // Enter Password
	        driver.findElement(By.id("password")).sendKeys("secret_sauce");

	        Thread.sleep(2000);

	        // Click Login
	        driver.findElement(By.id("login-button")).click();

	        Thread.sleep(3000);

	        // Select Product
	        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();

	        Thread.sleep(3000);

	        // Add Product To Cart
	        driver.findElement(By.id("add-to-cart")).click();

	        Thread.sleep(3000);

	        // Back To Products
	        driver.findElement(By.id("back-to-products")).click();

	        Thread.sleep(3000);

	        // Open Cart
	        driver.findElement(By.className("shopping_cart_link")).click();

	        Thread.sleep(3000);

	        // Checkout
	        driver.findElement(By.id("checkout")).click();

	        Thread.sleep(3000);

	        // Enter First Name
	        driver.findElement(By.id("first-name")).sendKeys("Sagarika");

	        Thread.sleep(2000);

	        // Enter Last Name
	        driver.findElement(By.id("last-name")).sendKeys("Talukdar");

	        Thread.sleep(2000);

	        // Enter Postal Code
	        driver.findElement(By.id("postal-code")).sendKeys("123456");

	        Thread.sleep(2000);

	        // Continue Checkout
	        driver.findElement(By.id("continue")).click();

	        Thread.sleep(3000);

	        // Finish Order
	        driver.findElement(By.id("finish")).click();

	        Thread.sleep(3000);

	        // Print Title
	        System.out.println(driver.getTitle());

	        // Success Message
	        System.out.println("Order placed successfully");
	    }
	@AfterMethod
	public void tearDown()
	{
		System.out.println("Closing Browser");
		driver.quit();
		
	}
	
}