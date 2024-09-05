package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.base.UIBaseClass;

import java.util.List;

public class SettingsPage extends UIBaseClass {

    public SettingsPage() {
        PageFactory.initElements(getDriver(), this);
    }

   @FindBy(xpath = "//button[text()='Mailing Address']")
   public WebElement mailingAddressSectionButton;

    @FindBy(xpath = "//button[text()='Phones']")
    public WebElement phonesSectionButton;

    @FindBy(xpath = "//button[text()='Cars']")
    public WebElement carsSectionButton;

    @FindBy(xpath = "//h2[text()='Settings']")
    public WebElement settingsHeader;

    @FindBy(xpath = "//p[contains(text(),'ID')]//preceding::p")
    public WebElement userFullName;

    @FindBy(xpath = "//p[text()='EMAIL ADDRESS']//following-sibling::p")
    public WebElement userEmailAddress;

    @FindBy(xpath = "//p[text()='GENDER']//following-sibling::p")
    public WebElement userGender;

    @FindBy(xpath = "//p[text()='MARITAL STATUS']//following-sibling::p")
    public WebElement userMaritalStatus;

    @FindBy(xpath = "//p[text()='EMPLOYMENT STATUS']//following-sibling::p")
    public WebElement userEmploymentStatus;

    @FindBy(xpath = "//p[text()='DATE OF BIRTH']//following-sibling::p")
    public WebElement userDOB;

    @FindBy(xpath = "//h2[starts-with(@class,'chakra-heading')]//../div/div//div[starts-with(@class,'chakra-stack')]//following-sibling::p")
    public List<WebElement> userInformationList;

    @FindBy(xpath = "//button[text()='Add Mailing Address']")
    public WebElement addMailingAddressButton;

    @FindBy(xpath = "//button[text()='Add Phone']")
    public WebElement addPhoneButton;

    @FindBy(xpath = "//button[text()='Add Car']")
    public WebElement addCarButton;

}
