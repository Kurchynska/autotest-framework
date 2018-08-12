package abc.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Data
@NoArgsConstructor
public class DriverManager {

    public ChromeDriver setChromeDriver() {
        ChromeDriver driver = new ChromeDriver();
        return driver;
    }

    public FirefoxDriver setFireFoxBrowser() {
        FirefoxDriver driver = new FirefoxDriver();
        return driver;
    }
}
