package abc.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends AbstractPage {

    @FindBy(how = How.CLASS_NAME, using = "_2T5vKuV")
    private WebElement userGreatingText;

    public String getTextFromUserGreatings() {
        return userGreatingText.getText();
    }
}
