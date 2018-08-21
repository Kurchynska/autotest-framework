package abc.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WishListPage extends AbstractPage {

    @FindBy(how = How.CLASS_NAME, using = "saved-items-main-button")
    private WebElement wishListLoginButton;

    @FindBy(how = How.XPATH, using = ".//div[@class='savedItems-item-zoomer']//h3/a")
    private WebElement firstProductTitleInWishList;

    @FindBy(how = How.XPATH, using = ".//*[@class='bag-item-remove-holder']/button")
    private WebElement deleteButtonWishList;

    public void deleteFirstProductInWishList(){
        deleteButtonWishList.click();
        waitAllLoad(5);
    }

    public void clickOnWishListLoginButton() {
        wishListLoginButton.click();
    }

    public String grabNameOfFistProductInWishList() {
        return firstProductTitleInWishList.getText();
    }
}
