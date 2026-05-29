package SDET_Day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ParaBank {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		System.out.println("Launching Browser");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/register.htm");
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void register() throws InterruptedException {
		
		driver.findElement(By.id("customer.firstName")).sendKeys("Sagarika");
		Thread.sleep(1000);
		
		driver.findElement(By.id("customer.lastName")).sendKeys("Talukdar");
		Thread.sleep(1000);
		
		driver.findElement(By.id("customer.address.street")).sendKeys("Sealdah");
		Thread.sleep(1000);
		
		driver.findElement(By.id("customer.address.city")).sendKeys("Kolkata");
		Thread.sleep(1000);
		
		driver.findElement(By.id("customer.address.state")).sendKeys("West Bengal");
		Thread.sleep(1000);
		
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("700009");
		Thread.sleep(1000);
		
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("8420952086");
		Thread.sleep(1000);
		
		driver.findElement(By.id("customer.ssn")).sendKeys("12345678");
		Thread.sleep(1000);
		
		driver.findElement(By.id("customer.username")).sendKeys("saga");
		Thread.sleep(1000);
		
		driver.findElement(By.id("customer.password")).sendKeys("00000");
		Thread.sleep(1000);
		
		driver.findElement(By.id("repeatedPassword")).sendKeys("00000");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		Thread.sleep(1000);
		
		System.out.println(driver.getTitle());
	}
	
	 @Test(priority = 2)
	public void login() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("saga");
		Thread.sleep(1000);
		
		driver.findElement(By.name("password")).sendKeys("00000");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
        Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("Closing Browser");
		driver.quit();
		
	}
	
}