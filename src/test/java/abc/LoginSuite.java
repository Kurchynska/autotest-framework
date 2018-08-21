package abc;

import abc.po.LoginPage;
import abc.po.MainPage;
import abc.po.WishListPage;
import static abc.utils.PropertiesManager.getPropertyByKey;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class LoginSuite extends AbstractTest {

    private LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage() ;
    private WishListPage wishListPage = new WishListPage() ;

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
        goToMyAccountPage();
        loginPage.fillLoginField(getPropertyByKey("email"));
        loginPage.fillPasswordField(getPropertyByKey("password"));
        loginPage.clickOnSigninButton();
        mainPage.clickOnAccountIcon();
        Assert.assertEquals(mainPage.getTextFromUserGreatings(), "Hi " + getPropertyByKey("userName"));
        singOutAfterMethod();
    }

    /**
     *  Check if correct error message is shown in a case of invalid e-mail input
     */
    @Test
    public void checkLoginWithInvalidCredentials(){
        goToMyAccountPage();
        loginPage.fillLoginField(getPropertyByKey("invalidEmail"));
        loginPage.fillPasswordField(getPropertyByKey("invalidPassword"));
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
        loginPage.fillLoginField(getPropertyByKey("email"));
        loginPage.fillPasswordField(getPropertyByKey("password"));
        loginPage.clickOnSigninButton();
        wishListPage.clickOnAccountIcon();
        Assert.assertEquals(mainPage.getTextFromUserGreatings(), "Hi " + getPropertyByKey("userName"));
        singOutAfterMethod();
    }

    private void singOutAfterMethod(){
        mainPage.openMainPage();
        mainPage.clickOnAccountIcon();
        mainPage.clickOnSingOut();
    }

    @AfterSuite
    public void quitDriverAfterSuite() {
        mainPage.getDriver().quit();
    }

    private void goToMyAccountPage(){
        mainPage.openMainPage();
        mainPage.clickOnAccountIcon();
        mainPage.clickOnSingInLink();
    }
}