package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class HomePage extends SeleniumUtility {

    public HomePage() {
        PageFactory.initElements(getDriver(), this);

    }

    @FindBy(linkText = "Create Primary Account")
    public WebElement createPrimaryAccountLink;

    @FindBy(linkText = "Login")
    public WebElement loginLink;


}
