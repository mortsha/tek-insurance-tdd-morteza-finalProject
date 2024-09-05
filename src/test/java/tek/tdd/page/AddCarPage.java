package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class AddCarPage extends SeleniumUtility {
    public AddCarPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//header[text()='Add Car']")
    public WebElement addCarHeader;

    @FindBy(id = "make")
    public WebElement makeInput;

    @FindBy(name = "model")
    public WebElement modelInput;

    @FindBy(id = "year")
    public WebElement yearInput;

    @FindBy(id = "licensePlate")
    public WebElement licensePlateInput;

}
