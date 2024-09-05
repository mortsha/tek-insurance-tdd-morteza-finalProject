package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.base.UIBaseClass;

import java.util.List;

public class Settings extends UIBaseClass {

    public Settings(){
        PageFactory.initElements(getDriver(),this);
    }

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
}
