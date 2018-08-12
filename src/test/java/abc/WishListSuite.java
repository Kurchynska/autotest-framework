package abc;


import abc.po.LoginPage;
import abc.po.MainPage;
import abc.po.ProductPage;
import abc.po.WishListPage;
import abc.utils.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListSuite {

    private WebDriver driver = new ChromeDriver();
    private MainPage mainPage = new MainPage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private WishListPage wishListPage = new WishListPage(driver);
    private ProductPage productPage = new ProductPage(driver);
    private PropertiesManager propertiesManager = new PropertiesManager();

    @BeforeMethod
    public void SingInBeforeTest(){
        driver.manage().window().maximize();
        mainPage.openLandingPage();
        mainPage.clickOnWishListIcon();
        wishListPage.clickOnWishListLoginButton();
        loginPage.fillLoginField(propertiesManager.getDataFromPropertyFile().getProperty("email"));
        loginPage.fillPasswordField(propertiesManager.getDataFromPropertyFile().getProperty("password"));
        loginPage.clickOnSigninButton();
    }

    @AfterMethod
    public void SingOutAfterTest(){
        mainPage.openLandingPage();
        mainPage.clickOnAccountIcon();
        mainPage.clickOnSingOut();
    }

    /**
     *  Check that product was added to the wish list
     */

    @Test
    public void checkAddProductToWishList(){
        productPage.openFirstProductPage();
        productPage.clickOnAddToWishListButton();
        String productName = productPage.grabProductName();
        productPage.clickOnWishListIcon();
        Assert.assertEquals(wishListPage.grabNameOfFistProductInWishList(), productName);
    }

    @AfterSuite
    public void quitDriverAfterSuite(){
        driver.quit();
    }
}
