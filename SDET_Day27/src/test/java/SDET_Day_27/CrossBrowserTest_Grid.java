package SDET_Day_27;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest_Grid {

    WebDriver driver;

    @Parameters("browser")
    @Test
    public void launchBrowser(String browser) throws Exception {

        if(browser.equalsIgnoreCase("chrome"))
        {
            ChromeOptions options = new ChromeOptions();

            driver = new RemoteWebDriver(
                    new URL("http://localhost:4444"),
                    options);
        }
        else if(browser.equalsIgnoreCase("edge"))
        {
            EdgeOptions options = new EdgeOptions();

            driver = new RemoteWebDriver(
                    new URL("http://localhost:4444"),
                    options);
        }

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com");

        System.out.println("Browser Launched : " + browser);
        System.out.println("Title : " + driver.getTitle());

        driver.quit();
    }
}