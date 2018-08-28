package abc.po;

import abc.utils.DriverManager;
import abc.utils.PropertiesManager;
import lombok.Data;
import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

@Data
@Log
public abstract class AbstractPage {

    private WebDriver driver = DriverManager.initDriver();

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
            using = ".//div[@class='headroom headroom--unfixed']//nav/div/div[3]/div/div[2]/div/section/div[2]/ul/li/a")
    private WebElement newInClothingMenuButton;

    @FindBy(how = How.CSS, using = "button[data-id='0edf7894-4f2f-42fb-896d-3e91a01704b1']")
    private WebElement shoesMenuButton;

    @FindBy(how = How.XPATH,
            using = ".//div[@id='chrome-sticky-header']/div[2]/nav/div/div[4]/div[2]/div/section/div[2]/ul/li[2]/a")
    private WebElement newInShoesMenuButton;

    public AbstractPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnClothingMenuButton() {
        clothingMenuButton.click();
        waitAllLoad(5);
    }

    public String getTextFromSingOutLink() {
        return singOutLink.getText();
    }

    public void clickOnNewInClothingMenuButton() {
        newInClothingMenuButton.click();
    }

    public void openMainPage() {
        driver.get(PropertiesManager.getPropertyByKey("landing"));
    }

    public void clickOnSingInLink() {
        waitAllLoad(5);
        singInLink.click();
    }

    public void clickOnAccountIcon() {
        accountIcon.click();
        waitAllLoad(5);
    }

    public void clickOnWishListIcon() {
        wishListIcon.click();
        waitAllLoad(5);
    }

    public void clickOnSingOut() {
        singOutLink.click();
    }

    public void clickOnShoesMenuButton() {
        shoesMenuButton.click();
        waitAllLoad(5);
    }

    public void clickOnNewInShoesMenuButton() {
        newInShoesMenuButton.click();
    }

    public void openShoesCategoryPage() {
        openMainPage();
        clickOnShoesMenuButton();
        clickOnNewInShoesMenuButton();
    }

    public static void waitAllLoad(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            log.severe(String.format("Can't wait InterruptedException"));
        }
    }
}
