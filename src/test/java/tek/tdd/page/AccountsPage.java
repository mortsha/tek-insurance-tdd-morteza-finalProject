package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.base.UIBaseClass;

import java.util.List;

public class AccountsPage extends UIBaseClass {

    public AccountsPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> accountTableRowList;

    @FindBy(className = "chakra-select")
    public WebElement showDropdown;

}
