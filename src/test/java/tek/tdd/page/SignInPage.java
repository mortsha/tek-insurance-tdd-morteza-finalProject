package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class SignInPage extends SeleniumUtility {
    public SignInPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//h2[text()='Sign in to your Account']")
    public WebElement signInAccountHeader;

    @FindBy(id = "username")
    public WebElement userNameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Sign In']")
    public WebElement signInButton;

    @FindBy(className = "banner-error")
    public WebElement errorMessage;

    public void singInCredentials(String username, String password) {
        extentInfo("Sign in with " + username + " and " + password);
        sendText(userNameInput, username);
        sendText(passwordInput, password);
        clickOnElement(signInButton);
    }

    public void loginToCSRAccount(){
        extentInfo("Login to CSR account with credentials");
        sendText(userNameInput, "supervisor");
        sendText(passwordInput, "tek_supervisor");
        clickOnElement(signInButton);
    }

}
