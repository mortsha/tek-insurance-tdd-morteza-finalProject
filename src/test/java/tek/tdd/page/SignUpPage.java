package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class SignUpPage extends SeleniumUtility {

    public SignUpPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//h2[text()='Sign up your account']")
    public WebElement signUpHeader;

    @FindBy(xpath = "//h2[text()='Sign up your account']//following-sibling::h2[2]")
    public WebElement emailCreatedOnSignUp;

    @FindBy(id = "username")
    public WebElement userNameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "confirm")
    public WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitButton;

    public void signUpWithCredentials(String username, String password) {
        sendText(userNameInput, username);
        sendText(passwordInput, password);
        sendText(confirmPasswordInput, password);
        clickOnElement(submitButton);
    }


}
