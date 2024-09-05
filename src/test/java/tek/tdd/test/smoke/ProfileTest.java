package tek.tdd.test.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;

public class ProfileTest extends UIBaseClass {

    @Test(testName = "Profile - validateCSRProfile")
    public void loginWithCSRAndValidateProfilePage(){
        clickOnElement(homePage.loginLink);
        signInPage.singInCredentials("supervisor", "tek_supervisor");
        clickOnElement(profilePage.profileButton);
        String actualStatus = getElementText(profilePage.statusProfile);
        Assert.assertEquals(actualStatus,"Active", "Both status should match");

        String actualUserType = getElementText(profilePage.userTypeProfile);
        Assert.assertEquals(actualUserType,"CSR", "Both user type should match");

        String actualUserName = getElementText(profilePage.usernameProfile);
        Assert.assertEquals(actualUserName,"supervisor","Both username should match");

        String actualFullName = getElementText(profilePage.fullNameProfile);
        Assert.assertEquals(actualFullName,"Supervisor","Both full name should match");

        String actualAuth = getElementText(profilePage.authoritiesProfile);
        Assert.assertEquals(actualAuth,"admin", "Both authorities should match");


        clickOnElement(profilePage.logoutButton);

        isElementDisplayed(homePage.loginLink);
        isElementDisplayed(homePage.createPrimaryAccountLink);
        extentInfo("Login to CSR account and validate profile and log out");

    }

}
