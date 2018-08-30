package abc.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends AbstractPage {

    @FindBy(how = How.CSS, using = "a[class='save-button-link']")
    private WebElement addToWishListButton;

    @FindBy(how = How.XPATH, using = ".//div[@class='product-hero']/h1")
    private WebElement productTitle;

    public void clickOnAddToWishListButton() {
        addToWishListButton.click();
        waitAllLoad(5);
    }

    public String grabProductName() {
        return productTitle.getText();
    }
}
