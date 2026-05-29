package SDET_Day26;

import java.io.FileInputStream;
import java.io.IOException;
 
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
public class Logging {
 
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\sagar\\OneDrive\\Desktop\\Wipro_Selenium\\DDT Sheet.xlsx.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		int rows = sh.getLastRowNum();
		
		Logger log = LogManager.getLogger(Logging.class);
		
		for(int i = 1; i<=rows; i++) {
			String username = sh.getRow(i).getCell(0).getStringCellValue();
			String password = sh.getRow(i).getCell(1).getStringCellValue();
			
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
 
			driver.get("https://www.saucedemo.com/");
 
			// Login
			driver.findElement(By.id("user-name")).sendKeys(username);
			log.info("user: " + username);
 
			driver.findElement(By.id("password")).sendKeys(password);
			log.info("pass: " + password);
 
			driver.findElement(By.id("login-button")).click();
			log.info("login button clicked");
//			log.error("Login failed");
			
			
			driver.quit();
		}
		wb.close();
		fis.close();
	}
}