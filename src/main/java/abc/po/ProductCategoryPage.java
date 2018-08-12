package abc.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductCategoryPage extends AbstractPage {

    @FindBy(how = How.XPATH, using = ".//*[@data-auto-id='productList']//a")
    private WebElement firstProductOnCategoryPage;

    public void clickOnFirstProductOnCategoryPage(){
        firstProductOnCategoryPage.click();
    }

    public ProductCategoryPage(WebDriver driver){
        super(driver);
    }
}
