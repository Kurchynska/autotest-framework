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
public class ProductPage extends AbstractPage {

    @FindBy(how = How.CSS, using = "a[class='save-button-link']")
    private WebElement addToWishListButton;

    @FindBy(how = How.XPATH, using = ".//*[@class='product-hero']/h1")
    private WebElement productTitle;

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public void clickOnAddToWishListButton() {
        addToWishListButton.click();
        super.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    public String grabProductName() {
        return productTitle.getText();
    }
}
