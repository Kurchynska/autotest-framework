package abc;

import abc.po.*;
import static abc.utils.PropertiesManager.getPropertyByKey;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListSuite {

    private MainPage mainPage = new MainPage();
    private LoginPage loginPage = new LoginPage();
    private WishListPage wishListPage = new WishListPage();
    private ProductPage productPage = new ProductPage();
    private ProductCategoryPage productCategoryPage = new ProductCategoryPage();

    @BeforeMethod
    public void singInBeforeTest(){
        mainPage.openMainPage();
        mainPage.clickOnWishListIcon();
        wishListPage.clickOnWishListLoginButton();
        loginPage.fillLoginField(getPropertyByKey("email"));
        loginPage.fillPasswordField(getPropertyByKey("password"));
        loginPage.clickOnSigninButton();
    }

    @AfterMethod
    public void singOutAfterTest(){
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
        wishListPage.deleteFirstProductInWishList();
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
        mainPage.getDriver().quit();
    }
}
