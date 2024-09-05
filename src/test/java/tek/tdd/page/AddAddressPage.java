package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class AddAddressPage extends SeleniumUtility {
    public AddAddressPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//header[text()='Add Address']")
    public WebElement addAddressHeader;
    @FindBy(id = "addressType")
    public WebElement addressTypeDropdown;

    @FindBy(id = "addressLine1")
    public WebElement addressLineInput;

    @FindBy(id = "city")
    public WebElement cityInput;

    @FindBy(id = "state")
    public WebElement stateInput;

    @FindBy(id = "postalCode")
    public WebElement postalCodeInput;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//button[text()='Confirm']")
    public WebElement confirmButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelButton;
}
