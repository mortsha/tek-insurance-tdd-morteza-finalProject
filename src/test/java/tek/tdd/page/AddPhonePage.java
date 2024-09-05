package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class AddPhonePage extends SeleniumUtility {
    public AddPhonePage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//header[text()='Add Phone']")
    public WebElement addPhoneHeader;

    @FindBy(id = "phoneType")
    public WebElement phoneTypeDropdown;

    @FindBy(id = "phoneNumber")
    public WebElement phoneNumberInput;

    @FindBy(id = "phoneExtension")
    public WebElement extensionInput;

    @FindBy(id = "phoneTime")
    public WebElement phoneTimeDropdown;

    @FindBy(xpath = "//div[contains(text(),'Delete phone')]")
    public WebElement deletePhoneMessage;

}
