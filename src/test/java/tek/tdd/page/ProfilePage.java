package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class ProfilePage extends SeleniumUtility {

    public ProfilePage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(xpath = "//button[@aria-label='profile']")
    public WebElement profileButton;

    @FindBy(xpath ="//p[text()='FULL NAME']//following-sibling::p")
    public WebElement fullNameProfile;

    @FindBy(xpath = "//button[text()='Logout']")
    public WebElement logoutButton;
    @FindBy(xpath = "//p[text()='STATUS']//following-sibling::p")
    public WebElement statusProfile;

    @FindBy(xpath = "//p[text()='USERNAME']//following-sibling::p")
    public WebElement usernameProfile;
    @FindBy(xpath = "//p[text()='USER TYPE']//following-sibling::p")
    public WebElement userTypeProfile;
    @FindBy(xpath = "//p[text()='AUTHORITIES']//following-sibling::ul")
    public WebElement authoritiesProfile;

    @FindBy(xpath = "//button[@aria-label='Close']")
    public WebElement closeButton;
}
