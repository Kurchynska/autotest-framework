package abc.po;

import abc.utils.PropertiesManager;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

@Data
@NoArgsConstructor
public abstract class AbstractPage {

    protected WebDriver driver;
    private PropertiesManager propertiesManager = new PropertiesManager();

    @FindBy(how = How.CSS, using = "button[data-testid='accountIcon']")
    private WebElement accountIcon;

    @FindBy(how = How.CSS, using = "a[data-testid='savedItemsIcon']")
    private WebElement wishListIcon;

    @FindBy(how = How.CSS, using = "a[data-testid='myaccount-link']")
    private WebElement myAccountPageLink;

    @FindBy(how = How.CSS, using = "a[data-testid='signin-link']")
    private WebElement singInLink;

    @FindBy(how = How.CSS, using = "a[data-testid='signout-link']")
    private WebElement singOutLink;

    @FindBy(how = How.CSS, using = "button[data-id='96b432e3-d374-4293-8145-b00772447cde']")
    private WebElement clothingMenuButton;

    @FindBy(how = How.XPATH,
            using = ".//*[@id='chrome-sticky-header']//nav/div/div[3]/div[2]/div/section/div[2]/ul/li/a")
    private WebElement newInClothingMenuButton;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnClothingMenuButton(){
        clothingMenuButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnNewInClothingMenuButton(){
        newInClothingMenuButton.click();
    }

    public void openLandingPage() {
        driver.get(propertiesManager.getDataFromPropertyFile().getProperty("landing"));
    }

    public void clickOnSingInLink() {
        singInLink.click();
    }

    public void clickOnAccountIcon() {
        accountIcon.click();
        try {
            Thread.sleep(5000);                        //TODO: need to change to explicity wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnMyAccountPageLink() {
        myAccountPageLink.click();
    }

    public void clickOnWishListIcon() {
        wishListIcon.click();
        try {
            Thread.sleep(5000);                  //TODO: need to change to explicity wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnSingOut() {
        singOutLink.click();
    }


}
