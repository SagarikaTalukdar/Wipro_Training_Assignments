package SDET_Day25;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FlightBookingFluentWait {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com");

        driver.findElement(By.name("fromPort")).sendKeys("Boston");
        driver.findElement(By.name("toPort")).sendKeys("London");

        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

        FluentWait<WebDriver>wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
            	.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);

        WebElement table = wait.until(d -> d.findElement(By.className("table")));

        System.out.println("Flight table displayed successfully");

//        driver.quit();
    }
}