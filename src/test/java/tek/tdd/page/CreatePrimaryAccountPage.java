package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class CreatePrimaryAccountPage extends SeleniumUtility {

    public CreatePrimaryAccountPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//h2[text()='Create Primary Account Holder']")
    public WebElement createPrimaryAccountHeader;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "title")
    public WebElement prefixDropdown;

    @FindBy(id = "gender")
    public WebElement genderDropdown;

    @FindBy(id = "employmentStatus")
    public WebElement employmentStatusInput;

    @FindBy(id = "maritalStatus")
    public WebElement maritalStatusDropdown;

    @FindBy(id = "dateOfBirth")
    public WebElement dateOfBirthInput;

    @FindBy(xpath = "//button[text()='Create Account']")
    public WebElement createAccountButton;

    @FindBy(className = "chakra-alert")
    public WebElement errorMessage;

}
