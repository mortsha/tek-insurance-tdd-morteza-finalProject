package tek.tdd.test.regression;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;

public class HomePageTest extends UIBaseClass {

    @Test(testName = "Home Page - Story1")
    public void validateHomaPageElements() {
        String actualTitle = getDriver().getTitle();
        String expectedTitle = "Tek Insurance UI";
        Assert.assertEquals(actualTitle, expectedTitle, "Title should be same as expected");
        boolean isCreatePrimaryButtonVisible = isElementDisplayed(homePage.createPrimaryAccountLink);
        Assert.assertTrue(isCreatePrimaryButtonVisible, "the element should be displayed");

        boolean isLoginButtonDisplayed = isElementDisplayed(homePage.loginLink);
        Assert.assertTrue(isLoginButtonDisplayed, "the element should be displayed");

        extentInfo("validating title, create primary account button and login button");
    }

}
