package tek.tdd.test.smoke;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;
import tek.tdd.utility.JavaUtilities;

public class PrimaryAccountAddInformationTest extends UIBaseClass {

    private void loginToPrimaryAccountNavigateToSettings() {
        clickOnElement(homePage.loginLink);
        signInPage.singInCredentials("David.Lur6251", "Password123");
        String actualHeaderTitle = getElementText(primaryAccountPage.accountHeaderTitle);
        Assert.assertEquals(actualHeaderTitle, "Primary Account Portal", "Header account title should match");

        clickOnElement(primaryAccountPage.settingLink);
        String actualSettingHeader = getElementText(settingsPage.settingsHeader);
        Assert.assertEquals(actualSettingHeader, "Settings", "Both Settings header should match");
        extentInfo("Validate Primary Account title and navigate to settings and validate title");
    }

    @Test(testName = "Primary Account - Add Address")
    public void loginWithPrimaryAccountAddAddress() {
        loginToPrimaryAccountNavigateToSettings();

        clickOnElement(settingsPage.mailingAddressSectionButton);
        clickOnElement(settingsPage.addMailingAddressButton);
        selectDropdownByText(addAddressPage.addressTypeDropdown, JavaUtilities.getAddressType());
        String addressLine = JavaUtilities.getAddressLine();
        sendText(addAddressPage.addressLineInput, addressLine);
        sendText(addAddressPage.cityInput, JavaUtilities.getCity());
        sendText(addAddressPage.stateInput, JavaUtilities.getState());
        sendText(addAddressPage.postalCodeInput, JavaUtilities.getPostalCode());
        clickOnElement(addAddressPage.submitButton);
        extentInfo("Adding Address to account");

//        String xpath = "//p[text()='" + addressLine + "']//parent::div//parent::div//preceding-sibling::div/button";
//        clickOnElement(By.xpath(xpath));
//        extentInfo("deleting Phone from account");
    }

    //button[@aria-label='delete car']
    @Test(testName = "Primary Account - Add Phone")
    public void loginWithPrimaryAccountAddPhone() {
        loginToPrimaryAccountNavigateToSettings();

        clickOnElement(settingsPage.phonesSectionButton);
        clickOnElement(settingsPage.addPhoneButton);
        selectDropdownByText(addPhonePage.phoneTypeDropdown, JavaUtilities.getPhoneType());
        String phoneNumber = JavaUtilities.getRandomPhoneNumber();
        sendText(addPhonePage.phoneNumberInput, phoneNumber);
        sendText(addPhonePage.extensionInput, JavaUtilities.getExtension());
        selectDropdownByText(addPhonePage.phoneTimeDropdown, JavaUtilities.getPhoneTime());
        clickOnElement(addAddressPage.submitButton);
        extentInfo("Adding Phone to account");

//        String phoneNumberFormatted = JavaUtilities.phoneNumberFormatter(phoneNumber);
//        String xpath = "//p[text()='" + phoneNumberFormatted + "']//parent::div//parent::div//preceding-sibling::div/button";
//        clickOnElement(By.xpath(xpath));
//        clickOnElement(addAddressPage.confirmButton);
//        Assert.assertTrue(isElementDisplayed(addPhonePage.deletePhoneMessage), "Delete toast message should display");
//        Assert.assertTrue(Boolean.parseBoolean(getAttributeValue(addPhonePage.deletePhoneMessage)), "Success Status should be true");
//        extentInfo("deleting Phone from account");

    }

    @Test(testName = "Primary Account - Add Car")
    public void loginWithPrimaryAccountAddCar() {
        loginToPrimaryAccountNavigateToSettings();

        clickOnElement(settingsPage.carsSectionButton);
        clickOnElement(settingsPage.addCarButton);
        String carMake = JavaUtilities.getMake();
        sendText(addCarPage.makeInput, carMake);
        sendText(addCarPage.modelInput, JavaUtilities.getModel());
        sendText(addCarPage.yearInput, JavaUtilities.getCarYear());
        sendText(addCarPage.licensePlateInput, JavaUtilities.getLicensePlate());
        clickOnElement(addAddressPage.submitButton);
        extentInfo("Adding Car to account");

//        String xpath = "//p[text()='" + carMake + "']//parent::div//parent::div//preceding-sibling::div/button";
//        clickOnElement(By.xpath(xpath));
//        extentInfo("deleting car from account");
    }
}
