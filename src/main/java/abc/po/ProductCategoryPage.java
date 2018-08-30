package abc.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductCategoryPage extends AbstractPage {

    @FindBy(how = How.XPATH, using = ".//div[@data-auto-id='productList']//a")
    private WebElement firstProductOnCategoryPage;

    @FindBy(how = How.XPATH, using = ".//div[@data-auto-id='productList']//button")
    private WebElement wishListFirstProduct;

    @FindBy(how = How.XPATH, using = ".//div[@data-auto-id='productTileDescription']/div/div/p")
    private WebElement titleFistProductInCategory;

    public String grabTextProductTitle() {
        return titleFistProductInCategory.getText();
    }

    public void clickOnFirstProductOnCategoryPage() {
        waitAllLoad(5);
        firstProductOnCategoryPage.click();
    }

    public void clickOnWishListFirstProduct() {
        wishListFirstProduct.click();
        waitAllLoad(5);
    }
}
