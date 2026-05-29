package SDET_Day22;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class Q2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/ap/register?_encoding=UTF8&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_newcust");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.findElement(By.id("ap_email_login")).sendKeys("8420952086");
		Thread.sleep(1000);
		
		driver.findElement(By.id("continue")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("ap_password")).sendKeys("KoyelSaga");
		Thread.sleep(1000);
		
		driver.findElement(By.id("signInSubmit")).click();
		
		System.out.println(driver.getTitle());
		
		driver.get("https://amzn.in/d/00s0WZuA");
		Thread.sleep(1000);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);
		
		
		
		driver.quit();
	}
}
