package abc;

import abc.po.LoginPage;
import abc.po.MainPage;
import abc.po.WishListPage;
import abc.utils.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginSuite {

    private LoginPage loginPage;
    private MainPage mainPage;
    private WishListPage wishListPage;
    private WebDriver driver;
    private PropertiesManager propertiesManager = new PropertiesManager();


    /**
     * Check user can get to login page from main page
     */
    @BeforeMethod
    public void setUpBrowserBeforeTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        wishListPage = new WishListPage(driver);
    }
    @AfterMethod
    public  void closeBrowserAfterTest(){
        driver.quit();
    }

    @Test
    public void checkNavigationToLoginPage(){
        mainPage.openLandingPage();
        mainPage.clickOnAccountIcon();
        mainPage.clickOnSingInLink();
        Assert.assertEquals(loginPage.getTextFromLoginTabTitle(),"SIGN IN WITH EMAIL");
    }

    /**
     * Check user can login
     */

    @Test
    public void checkLoginToAccount(){
        mainPage.openLandingPage();
        mainPage.clickOnAccountIcon();
        mainPage.clickOnSingInLink();
        loginPage.fillLoginField(propertiesManager.getDataFromPropertyFile().getProperty("email"));
        loginPage.fillPasswordField(propertiesManager.getDataFromPropertyFile().getProperty("password"));
        loginPage.clickOnSigninButton();
        mainPage.clickOnAccountIcon();
        Assert.assertEquals(mainPage.getTextFromUserGreatings(), "Hi Anastasiia");
    }

    /**
     *  Assert error message will be shown in case not valid email is set
     */

    @Test
    public void checkLoginWithInvalidEmail(){
        mainPage.openLandingPage();
        mainPage.clickOnAccountIcon();
        mainPage.clickOnMyAccountPageLink();
        loginPage.fillLoginField("test-fake@fake.com");
        loginPage.fillPasswordField(propertiesManager.getDataFromPropertyFile().getProperty("password"));
        loginPage.clickOnSigninButton();
        Assert.assertTrue(loginPage.assertLoginErrorMessageDisplayed());
    }

    /**
     * Assert error message will be shown in case not valid password is set
     */

    @Test
    public void checkLoginWithInvalidPassword(){
        mainPage.openLandingPage();
        mainPage.clickOnAccountIcon();
        mainPage.clickOnMyAccountPageLink();
        loginPage.fillLoginField(propertiesManager.getDataFromPropertyFile().getProperty("email"));
        loginPage.fillPasswordField("12345");
        loginPage.clickOnSigninButton();
        Assert.assertTrue(loginPage.assertLoginErrorMessageDisplayed());
    }

    /**
     * Assert error message will be shown in case not valid login and password is set
     */

    @Test
    public void checkLoginWithInvalidCredentials(){
        mainPage.openLandingPage();
        mainPage.clickOnAccountIcon();
        mainPage.clickOnMyAccountPageLink();
        loginPage.fillLoginField("test-fake@fake.com");
        loginPage.fillPasswordField("123456789");
        loginPage.clickOnSigninButton();
        Assert.assertTrue(loginPage.assertLoginErrorMessageDisplayed());
    }

    /**
     * Check login from Wish List page
     */
    @Test
    public void checkLoginFromWishListPage(){
        mainPage.openLandingPage();
        mainPage.clickOnWishListIcon();
        wishListPage.clickOnWishListLoginButton();
        loginPage.fillLoginField("kyrchinskaa@gmail.com");
        loginPage.fillPasswordField("Password4Nastya!");
        loginPage.clickOnSigninButton();
        wishListPage.clickOnAccountIcon();
        Assert.assertEquals(mainPage.getTextFromUserGreatings(), "Hi Anastasiia");
    }
}












