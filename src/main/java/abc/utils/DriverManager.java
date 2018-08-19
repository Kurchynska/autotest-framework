package abc.utils;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Data

public class DriverManager {

    private DriverManager(){

    }

    public static WebDriver initBrowser(String browserName){
        if(browserName.equals("chrome"))
            return setChromeDriver();
        else return setFireFoxBrowser();
    }

    private static ChromeDriver setChromeDriver() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static FirefoxDriver setFireFoxBrowser() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
