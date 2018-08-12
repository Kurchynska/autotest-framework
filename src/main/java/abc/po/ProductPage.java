package abc.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Data
@NoArgsConstructor
public class ProductPage extends AbstractPage {

    private ProductCategoryPage productCategoryPage = new ProductCategoryPage(driver);

    @FindBy(how = How.CSS, using = "a[class='save-button-link']")
    private WebElement addToWishListButton;

    @FindBy(how = How.XPATH, using = ".//*[@class='product-hero']/h1")
    private WebElement productTitle;

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public void openFirstProductPage() {
        this.openLandingPage();
        this.clickOnClothingMenuButton();
        this.clickOnNewInClothingMenuButton();
        productCategoryPage.clickOnFirstProductOnCategoryPage();
    }

    public void clickOnAddToWishListButton() {
        addToWishListButton.click();
    }

    public String grabProductName() {
        return productTitle.getText();
    }
}
