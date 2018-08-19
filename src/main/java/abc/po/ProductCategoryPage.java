package abc.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

public class ProductCategoryPage extends AbstractPage {

    @FindBy(how = How.XPATH, using = ".//*[@data-auto-id='productList']//a")
    private WebElement firstProductOnCategoryPage;

    @FindBy(how = How.XPATH, using = ".//*[@data-auto-id='productList']//button")
    private WebElement wishListFirstProduct;

    @FindBy(how = How.XPATH, using = ".//*[@data-auto-id='productTileDescription']/div/div/p")
    private WebElement titleFistProductInCategory;

    public String grabTextProductTitle(){
        return titleFistProductInCategory.getText();
    }

    public void clickOnFirstProductOnCategoryPage() {
        super.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        firstProductOnCategoryPage.click();
    }

    public void clickOnWishListFirstProduct() {
        wishListFirstProduct.click();
        super.getDriver().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    }

    public ProductCategoryPage(WebDriver driver) {
        super(driver);
    }
}
