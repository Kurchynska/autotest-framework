package abc.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends AbstractPage {

    @FindBy(how = How.NAME, using = "Username")
    private WebElement loginField;

    @FindBy(how = How.NAME, using = "Password")
    private WebElement passwordField;

    @FindBy(how = How.CSS, using ="p[class='qa-use-email last-child']")
    private WebElement loginTabTitle;

    @FindBy(how = How.ID, using = "signin")
    private  WebElement signinButton;

    @FindBy(how = How.CLASS_NAME, using = "error-block")
    private  WebElement loginErrorMessageBlock;

    public String getTextFromLoginTabTitle(){
        return loginTabTitle.getText();
    }

    public void fillLoginField(String login){
        loginField.sendKeys(login);
    }

    public void fillPasswordField(String password){
        passwordField.sendKeys(password);
    }

    public void clickOnSigninButton(){
        signinButton.click();
        waitAllLoad(5);
    }

    public WebElement getLoginErrorMessageBlock(){
        return loginErrorMessageBlock;
    }
}
