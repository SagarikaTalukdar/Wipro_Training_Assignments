package SDET_Day22;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Amazon {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-accountList"))).click();

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email_login"))).sendKeys("7872183370");

       
        driver.findElement(By.id("continue")).click();

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password"))).sendKeys("Shaurya@29092002");

      
        driver.findElement(By.id("signInSubmit")).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        By.id("twotabsearchtextbox")))
                .sendKeys("Samsung",Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"a-autoid-5-announce\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ewc-compact-actions-container\"]/div/div[2]/span/span/a")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}