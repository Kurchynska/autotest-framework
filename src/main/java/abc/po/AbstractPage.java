package abc.po;

import abc.utils.DriverManager;
import abc.utils.PropertiesManager;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

@Data
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
            using = ".//*[@href = 'http://www.asos.com/women/new-in/new-in-clothing/cat/?cid=2623&nlid=ww|clothing|shop+by+product']")
    private WebElement newInClothingMenuButton;

    @FindBy(how = How.CSS, using = "button[data-id='0edf7894-4f2f-42fb-896d-3e91a01704b1']")
    private WebElement shoesMenuButton;

    @FindBy(how = How.XPATH,
            using = ".//*[@id='chrome-sticky-header']/div[2]/nav/div/div[4]/div[2]/div/section/div[2]/ul/li[2]/a")
    private WebElement newInShoesMenuButton;

    public AbstractPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnClothingMenuButton() {
        clothingMenuButton.click();
        waitAllLoad(5);
    }

    public void clickOnNewInClothingMenuButton() {
        newInClothingMenuButton.click();
    }

    public void openMainPage() {
        driver.get(PropertiesManager.getPropertyByKey("landing"));
    }

    public void clickOnSingInLink() {
        waitAllLoad(10);
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
        this.openMainPage();
        this.clickOnShoesMenuButton();
        this.clickOnNewInShoesMenuButton();
    }

    public static void waitAllLoad(int seconds){
        //driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
