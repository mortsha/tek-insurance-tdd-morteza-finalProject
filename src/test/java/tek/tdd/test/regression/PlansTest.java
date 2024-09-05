package tek.tdd.test.regression;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;
import tek.tdd.utility.JavaUtilities;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class PlansTest extends UIBaseClass {


    public void loginToCSRAndClickOnPlans() {
        clickOnElement(homePage.loginLink);
        signInPage.singInCredentials("supervisor", "tek_supervisor");
        clickOnElement(customerPortalPage.plansLink);

    }

    @Test(testName = "Plans - loginWithCSRAndValidatePlansData")
    public void csrAccountAndValidatePlansData() {
        loginToCSRAndClickOnPlans();

        List<WebElement> plansRowElements = getAllElements(plansPage.plansTableRowList);
        Assert.assertEquals(plansRowElements.size(), 4, "Plans row should match");
    }

    @Test(testName = "Plans - validateDatesOnPlans")
    public void validateDateCreateAndExpireOnPlans() {
        loginToCSRAndClickOnPlans();
        try {
            List<WebElement> createdList = getAllElements(plansPage.dateCreatedList);
            for (WebElement createdDate : createdList) {
                LocalDate expectedCreateDate = JavaUtilities.getTodayDate(0);

                LocalDate actualCreateDate = LocalDate.parse(createdDate.getText(), formatter);
                Assert.assertEquals(actualCreateDate, expectedCreateDate, "Both Created Date should match");
            }

            List<WebElement> expireList = getAllElements(plansPage.dateExpireList);
            for (WebElement expireDate : expireList) {
                LocalDate expectedExpireDate = JavaUtilities.getTodayDate(1);

                LocalDate actualExpireDate = LocalDate.parse(expireDate.getText(), formatter);
                Assert.assertEquals(actualExpireDate, expectedExpireDate, "Both Expire Date should match");

            }

        } catch (DateTimeParseException e) {
            throw new RuntimeException("Invalid Date format " + e.getMessage());
        }


    }

}
