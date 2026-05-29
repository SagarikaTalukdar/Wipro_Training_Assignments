package SDET_Day25;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class implicitWait {
 
	public static void main(String[] args) throws InterruptedException {
 
		WebDriver driver =new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demoqa.com/dynamic-properties");
		
		//Thread.sleep(5000);
		driver.findElement(By.id("visibleAfter")).click();
		System.out.println("Button Clicked");
		driver.quit();
		}
}