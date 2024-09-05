package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class PrimaryAccountPage extends SeleniumUtility {

    public PrimaryAccountPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//div[contains(@class,'header')]//a//following-sibling::h2")
    public WebElement accountHeaderTitle;

    @FindBy(linkText = "Dashboard")
    public WebElement dashboardLink;
    @FindBy(linkText = "Request Quote")
    public WebElement requestQuoteLink;

    @FindBy(linkText = "Plans")
    public WebElement plansLink;

    @FindBy(linkText = "Payments")
    public WebElement paymentsLink;

    @FindBy(linkText = "Settings")
    public WebElement settingLink;




}

