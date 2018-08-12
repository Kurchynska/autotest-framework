package abc.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

@Data
@NoArgsConstructor
public class MainPage extends AbstractPage {

    @FindBy(how = How.CLASS_NAME, using = "_2T5vKuV")
    private WebElement userGreatingText;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromUserGreatings() {
        return userGreatingText.getText();
    }
}
