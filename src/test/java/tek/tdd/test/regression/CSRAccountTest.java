package tek.tdd.test.regression;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;
import java.util.List;

public class CSRAccountTest extends UIBaseClass {
    public void loginWithCSRAndClickOnAccount() {
        clickOnElement(homePage.loginLink);
        signInPage.loginToCSRAccount();
        clickOnElement(customerPortalPage.accountsLink);
        extentInfo("Login with CSR Credentials and click on account link");
    }

    @Test(testName = "CSR Account - validate default account row")
    public void loginWithCSRAndValidateAccountDataRow() {
        loginWithCSRAndClickOnAccount();

        List<WebElement> accountRowList = getAllElements(accountsPage.accountTableRowList);
        Assert.assertEquals(accountRowList.size(), 5, "Primary Account table row size should match");
        extentInfo("validating Primary Account table row default should be 5");
    }

    @Test(testName = "CSR Accounts - validate table row by selected", dataProvider = "accountDropdown")
    public void loginWithCSRValidateRowChangeBySelected(int selectDP) {
        loginWithCSRAndClickOnAccount();
        selectDropdownByValue(accountsPage.showDropdown, String.valueOf(selectDP));
        List<WebElement> accountRowList = getAllElements(accountsPage.accountTableRowList);
        Assert.assertEquals(accountRowList.size(), selectDP, "Primary Account table row size should match");
        extentInfo("validating Primary Account table row should be as selected: " + selectDP);
    }

    @DataProvider(name = "accountDropdown")
    private Object[][] accountDropdownData() {
        return new Object[][]{
                {10},
                {25},
                {50},
        };
    }
}
