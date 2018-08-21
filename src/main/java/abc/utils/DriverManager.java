package abc.utils;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Data

public class DriverManager {

    private static WebDriver driver;
    private static final String BROWSER_NAME = "browserName";

    private DriverManager() {

    }

    public static WebDriver initDriver() {
        String browserName = System.getProperty(BROWSER_NAME);
        return browserName.equals("chrome")? initChromeDriver(): initFireFoxBrowser();
    }

    private static WebDriver initChromeDriver() {
        if(driver==null)
            driver = new ChromeDriver();
        configureBrowser(driver);
        return driver;
    }

    private static WebDriver initFireFoxBrowser() {
        if(driver==null)
            driver = new FirefoxDriver();
        configureBrowser(driver);
        return driver;
    }

    private static void configureBrowser(WebDriver driver) {
        driver.manage().window().maximize();
    }

    private static WebDriver getDriver(){
        return driver;
    }
}
