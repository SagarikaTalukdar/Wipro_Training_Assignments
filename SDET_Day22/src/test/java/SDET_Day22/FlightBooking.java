package SDET_Day22;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightBooking {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://phptravels.net/");

        driver.manage().window().maximize();

        Thread.sleep(3000);

        driver.findElement(By.id("acknowledgeDemoWarning")).click();

        System.out.println("Popup Closed Successfully");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[text()='Flights']")).click();

        System.out.println("Flights Tab Clicked Successfully");

        Thread.sleep(3000);

        // Departure City
        WebElement from = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@placeholder='Departure City or Airport']")));

        from.sendKeys("CCU");

        Thread.sleep(2000);

        from.sendKeys(Keys.ARROW_DOWN);
        from.sendKeys(Keys.ENTER);

        System.out.println("Departure City Selected");

        // Arrival City
        WebElement to = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@placeholder='Arrival City or Airport']")));

        to.sendKeys("DEL");

        Thread.sleep(2000);

        to.sendKeys(Keys.ARROW_DOWN);
        to.sendKeys(Keys.ENTER);

        System.out.println("Arrival City Selected");

        // Dynamic Date Selection
        LocalDate futureDate = LocalDate.now().plusDays(10);

        String day = String.valueOf(futureDate.getDayOfMonth());

        String fullDate = futureDate.format(
                DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        WebElement date = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.name("flights_departure_date")));

        date.click();

        WebElement selectDay = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(@class,'day') and text()='" + day + "']")));

        selectDay.click();

        System.out.println("Departure Date Selected : " + fullDate);

        // Close Overlay
        driver.findElement(By.tagName("body")).click();

        Thread.sleep(2000);

        // Passenger Dropdown
        WebElement traveller = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@name='passengers']/following-sibling::div")));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", traveller);

        // Increase Adults
        WebElement adultPlus = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//button[contains(@class,'rounded-full')])[2]")));

        adultPlus.click();

        System.out.println("Passengers Increased Successfully");

        // Search Flights
        WebElement searchBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(.,'Search Flights')]")));

        js.executeScript("arguments[0].click();", searchBtn);

        System.out.println("Flight Search Successful");

        // Wait for Results
        Thread.sleep(10000);

        // Book Now
        js.executeScript(
            "arguments[0].click();",
            driver.findElement(By.xpath("(//button[contains(.,'Book Now')])[1]"))
        );

        System.out.println("Flight Booked Successfully");

        Thread.sleep(5000);

        driver.quit();
    }
}