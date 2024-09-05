package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class CustomerPortalPage extends SeleniumUtility {
    public CustomerPortalPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//h2[text()='Customer Service Portal']")
    public WebElement customerServicePortalTitle;

    @FindBy(linkText = "Accounts")
    public WebElement accountsLink;

    @FindBy(linkText = "Plans")
    public WebElement plansLink;


}
