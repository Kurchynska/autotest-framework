package abc;

import abc.po.*;
import abc.utils.DriverManager;
import abc.utils.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListSuite {

    private WebDriver driver = DriverManager.initBrowser("chrome");
    private MainPage mainPage = new MainPage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private WishListPage wishListPage = new WishListPage(driver);
    private ProductPage productPage = new ProductPage(driver);
    private ProductCategoryPage productCategoryPage = new ProductCategoryPage(driver);

    @BeforeMethod
    public void SingInBeforeTest(){
        mainPage.openMainPage();
        mainPage.clickOnWishListIcon();
        wishListPage.clickOnWishListLoginButton();
        loginPage.fillLoginField(PropertiesManager.getPropertyByKey("email"));
        loginPage.fillPasswordField(PropertiesManager.getPropertyByKey("password"));
        loginPage.clickOnSigninButton();
    }

    @AfterMethod
    public void SingOutAfterTest(){
        mainPage.openMainPage();
        mainPage.clickOnAccountIcon();
        mainPage.clickOnSingOut();
    }

    /**
     *  Check that product was added to the wish list
     */

    @Test
    public void checkAddProductToWishList(){
        productPage.openMainPage();
        productPage.clickOnClothingMenuButton();
        productPage.clickOnNewInClothingMenuButton();
        productCategoryPage.clickOnFirstProductOnCategoryPage();
        productPage.clickOnAddToWishListButton();
        String productName = productPage.grabProductName();
        productPage.clickOnWishListIcon();
        Assert.assertEquals(wishListPage.grabNameOfFistProductInWishList(), productName);
    }

    /**
     *  check that product can be added to wish list from Category page and check removing
     *  from wish list
     */

    @Test
    public void checkAddToWishListFromCategoryPage(){
        productCategoryPage.openShoesCategoryPage();
        productCategoryPage.clickOnWishListFirstProduct();
        String productTitle = productCategoryPage.grabTextProductTitle();
        productCategoryPage.clickOnWishListIcon();
        Assert.assertEquals(wishListPage.grabNameOfFistProductInWishList(), productTitle);
        wishListPage.deleteFirstProductInWishList();
        wishListPage.clickOnWishListIcon();
        Assert.assertNotEquals(wishListPage.grabNameOfFistProductInWishList(), productTitle);
    }

    @AfterSuite
    public void quitDriverAfterSuite(){
        driver.quit();
    }
}
