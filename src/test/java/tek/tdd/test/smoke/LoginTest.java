package tek.tdd.test.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;

public class LoginTest extends UIBaseClass {

    public void loginPageValidateTitle() {
        clickOnElement(homePage.loginLink);
        String actualSignInText = getElementText(signInPage.signInAccountHeader);
        Assert.assertEquals(actualSignInText, "Sign in to your Account", "Sign in account header should match");
        extentInfo("Navigating to login page and validate title");
    }

    @Test(testName = "Login - CSRAccount")
    public void loginToCSRWithCredentials() {
        loginPageValidateTitle();
        signInPage.singInCredentials("supervisor", "tek_supervisor");
        String actualHeaderTitle = getElementText(primaryAccountPage.accountHeaderTitle);
        Assert.assertEquals(actualHeaderTitle, "Customer Service Portal", "Header account title should match");
        Assert.assertTrue(isElementDisplayed(customerPortalPage.accountsLink), "Account link should displayed");
        Assert.assertTrue(isElementDisplayed(customerPortalPage.plansLink), "Plans link should displayed");
        extentInfo("Login to CSR account and validate links");

    }

    @Test(testName = "Login - PrimaryAccount")
    public void loginToPrimaryPortalWithCredentials() {
        loginPageValidateTitle();
        signInPage.singInCredentials("David.Lur1635", "Password123");
        String actualHeaderTitle = getElementText(primaryAccountPage.accountHeaderTitle);
        Assert.assertEquals(actualHeaderTitle, "Primary Account Portal", "Header account title should match");
        Assert.assertTrue(isElementDisplayed(primaryAccountPage.dashboardLink), "Dashboard link should displayed");
        Assert.assertTrue(isElementDisplayed(primaryAccountPage.requestQuoteLink), "Request Quote link should displayed");
        Assert.assertTrue(isElementDisplayed(primaryAccountPage.plansLink), "Plans link should displayed");
        Assert.assertTrue(isElementDisplayed(primaryAccountPage.paymentsLink), "Payments link should displayed");
        Assert.assertTrue(isElementDisplayed(primaryAccountPage.settingLink), "Settings link should displayed");
        extentInfo("Login to Primary account and validate links");
    }

    @Test(testName = "Login - Negative", dataProvider = "InvalidTestData")
    public void LoginNegativeTesting(String username, String password, String expectedErrorMessage) {
        loginPageValidateTitle();
        signInPage.singInCredentials(username, password);
        String errorMessage = getElementText(signInPage.errorMessage);
        String actualError = errorMessage.replaceAll("ERROR","").trim();
        Assert.assertEquals(actualError, expectedErrorMessage, "Error message should match");
        extentInfo("Login with invalid data and validate error message");
    }

    @DataProvider(name = "InvalidTestData")
    private String[][] invalidTestData() {
        return new String[][]{
                {"wrongUsername", "Password@123", "User wrongUsername not found"},
                {"David.Lur3120", "wrongPassword", "Password not matched"},
                {"wrongUsername", "wrongPassword", "User wrongUsername not found"},
        };
    }
}
