package abc.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Data
@NoArgsConstructor
public class WishListPage extends AbstractPage {

    @FindBy(how = How.CLASS_NAME, using = "saved-items-main-button")
    private WebElement wishListLoginButton;

    @FindBy(how = How.XPATH, using = ".//*[@class='savedItems-item-zoomer']/*/h3/a")
    private WebElement firstProductTitleInWishList;

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnWishListLoginButton() {
        wishListLoginButton.click();
    }

    public String grabNameOfFistProductInWishList() {
        return firstProductTitleInWishList.getText();
    }
}
