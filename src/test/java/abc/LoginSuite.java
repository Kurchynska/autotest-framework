package abc;

import abc.po.LoginPage;
import abc.po.MainPage;
import abc.po.WishListPage;
import abc.utils.DriverManager;
import abc.utils.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class LoginSuite extends AbstractTest {

    private WebDriver driver = DriverManager.initBrowser("chrome");
    private LoginPage loginPage = new LoginPage(driver);
    private MainPage mainPage = new MainPage(driver) ;
    private WishListPage wishListPage = new WishListPage(driver) ;

    /**
     * Check user can get to login page from main page
     */
    @Test
    public void checkNavigationToLoginPage(){
        this.goToMyAccountPage();
        Assert.assertEquals(loginPage.getTextFromLoginTabTitle(),"SIGN IN WITH EMAIL");
    }

    /**
     * Check user can login
     */
    @Test
    public void checkLoginToAccount(){
        this.goToMyAccountPage();
        loginPage.fillLoginField(PropertiesManager.getPropertyByKey("email"));
        loginPage.fillPasswordField(PropertiesManager.getPropertyByKey("password"));
        loginPage.clickOnSigninButton();
        mainPage.clickOnAccountIcon();
        Assert.assertEquals(mainPage.getTextFromUserGreatings(), "Hi Anastasiia");
        this.SingOutAfterSingIn();
    }

    /**
     *  Check if correct error message is shown in a case of invalid e-mail input
     */
    @Test
    public void checkLoginWithInvalidCredentials(){
        this.goToMyAccountPage();
        loginPage.fillLoginField("test-fake@fake.com");
        loginPage.fillPasswordField("p123456");
        loginPage.clickOnSigninButton();
        Assert.assertTrue(loginPage.getLoginErrorMessageBlock().isDisplayed());
    }

    /**
     * Check login from Wish List page
     */
    @Test
    public void checkLoginFromWishListPage(){
        mainPage.openMainPage();
        mainPage.clickOnWishListIcon();
        wishListPage.clickOnWishListLoginButton();
        loginPage.fillLoginField(PropertiesManager.getPropertyByKey("email"));
        loginPage.fillPasswordField(PropertiesManager.getPropertyByKey("password"));
        loginPage.clickOnSigninButton();
        wishListPage.clickOnAccountIcon();
        Assert.assertEquals(mainPage.getTextFromUserGreatings(), "Hi Anastasiia");
        this.SingOutAfterSingIn();
    }

    @AfterSuite
    public void quitDriverAfterSuite() {
        driver.quit();
    }

    private void goToMyAccountPage(){
        mainPage.openMainPage();
        mainPage.clickOnAccountIcon();
        mainPage.clickOnSingInLink();
    }

    private void SingOutAfterSingIn(){
        mainPage.openMainPage();
        mainPage.clickOnAccountIcon();
        mainPage.clickOnSingOut();
    }
}