package tek.tdd.test.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;
import tek.tdd.utility.JavaUtilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CreateAccountTest extends UIBaseClass {

    private String emailToUse;
    private String fullName;
    protected static String usernameCreatedAccount;

    public void navigateToCreateAccountPageValidateTitle() {
        clickOnElement(homePage.createPrimaryAccountLink);
        String actualFormTitle = getElementText(createPrimaryAccountPage.createPrimaryAccountHeader);
        String expectedFormTitle = "Create Primary Account Holder";
        Assert.assertEquals(actualFormTitle, expectedFormTitle, "Title in create primary account page should match");
        extentInfo("validating the create primary account header title");
    }

    public void fillTheCreatePrimaryAccountForm(String firstName, String lastName, String email, String employmentStatus, String gender,
                                                String maritalStatus, String prefix, String dob) {
        navigateToCreateAccountPageValidateTitle();
        sendText(createPrimaryAccountPage.firstNameInput, firstName);
        sendText(createPrimaryAccountPage.lastNameInput, lastName);
        sendText(createPrimaryAccountPage.emailInput, email);
        sendText(createPrimaryAccountPage.employmentStatusInput, employmentStatus);
        selectDropdownByText(createPrimaryAccountPage.genderDropdown, gender);
        selectDropdownByText(createPrimaryAccountPage.maritalStatusDropdown, maritalStatus);
        selectDropdownByText(createPrimaryAccountPage.prefixDropdown, prefix);
        sendText(createPrimaryAccountPage.dateOfBirthInput, dob);
        clickOnElement(createPrimaryAccountPage.createAccountButton);
    }


    @Test(testName = "Create Account - Story2")
    public void fillCreateAccountFormAndNavigateToSignUpPage() {
        String firstName = "David";
        String lastName = "Lur";
        fullName = firstName + "." + lastName;
        emailToUse = JavaUtilities.getRandomEmail(fullName);
        fillTheCreatePrimaryAccountForm(firstName, lastName, emailToUse, "tester", "Male", "Single",
                "Mr.", "10/10/2000");

        String actualSingUpHeader = getElementText(signUpPage.signUpHeader);
        Assert.assertEquals(actualSingUpHeader, "Sign up your account", "Sign up header should match");

        String actualEmailCreated = getElementText(signUpPage.emailCreatedOnSignUp);
        Assert.assertEquals(actualEmailCreated, emailToUse, "Email in sign up page should match");

    }

    @Test(testName = "Create Account - Story5")
    public void createNewAccountE2EValidation() {
        String firstName = JavaUtilities.getFirstName();
        String lastName = JavaUtilities.getLastName();
        fullName = firstName + "." + lastName;
        emailToUse = JavaUtilities.getRandomEmail(fullName);
        String employmentStatus = JavaUtilities.getEmploymentStatus();
        String gender = JavaUtilities.getGender();
        String maritalStatus = JavaUtilities.getMaritalStatus();
        String prefix = JavaUtilities.getPrefix();
        String dob = JavaUtilities.getDOB();

        fillTheCreatePrimaryAccountForm(firstName, lastName, emailToUse, employmentStatus, gender, maritalStatus, prefix, dob);

        String actualSingUpHeader = getElementText(signUpPage.signUpHeader);
        Assert.assertEquals(actualSingUpHeader, "Sign up your account", "Sign up header should match");

        String actualEmailCreated = getElementText(signUpPage.emailCreatedOnSignUp);
        Assert.assertEquals(actualEmailCreated, emailToUse, "Email in sign up page should match");
        usernameCreatedAccount = emailToUse.substring(0, emailToUse.indexOf('@'));

        signUpPage.signUpWithCredentials(usernameCreatedAccount, "Password123");

        //redirect to sign in page
        waitTime(2);

        String actualSignInText = getElementText(signInPage.signInAccountHeader);
        Assert.assertEquals(actualSignInText, "Sign in to your Account", "Sign in account header should match");

        signInPage.singInCredentials(usernameCreatedAccount, "Password123");
        String actualHeaderTitle = getElementText(primaryAccountPage.accountHeaderTitle);
        Assert.assertEquals(actualHeaderTitle, "Primary Account Portal", "Header account title should match");

        clickOnElement(profilePage.profileButton);

        String actualProfileFullName = getElementText(profilePage.fullNameProfile);
        String fullNameProfile = fullName.replaceAll("\\.", " ");
        Assert.assertEquals(actualProfileFullName, fullNameProfile, "FullName in profile should match");

        clickOnElement(profilePage.closeButton);
        clickOnElement(primaryAccountPage.settingLink);
        // validating user information in settings
        String actualUserFullName = getElementText(settingsPage.userFullName);
        String expectedUserFullName = prefix + " " + firstName + " " + lastName;
        Assert.assertEquals(actualUserFullName, expectedUserFullName, "Both User full name in setting should match");

        String actualEmail = getElementText(settingsPage.userEmailAddress);
        Assert.assertEquals(actualEmail, emailToUse, "Both User email in settings should match");

        String actualGender = getElementText(settingsPage.userGender);
        Assert.assertEquals(actualGender, gender, "Both gender in setting should match");

        String actualMS = getElementText(settingsPage.userMaritalStatus);
        Assert.assertEquals(actualMS, maritalStatus, "Both marital status in setting should match");

        String actualES = getElementText(settingsPage.userEmploymentStatus);
        Assert.assertEquals(actualES, employmentStatus, "Both employment status in setting should match");

        String actualDOB = getElementText(settingsPage.userDOB);
        try {
            DateTimeFormatter actualFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            LocalDate actualDate = LocalDate.parse(actualDOB, actualFormatter);
            DateTimeFormatter desiredFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = actualDate.format(desiredFormatter);
            Assert.assertEquals(formattedDate, dob, "Both Date of birth in settings should match");
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Invalid date format " + e.getMessage());
        }


        clickOnElement(profilePage.profileButton);
        clickOnElement(profilePage.logoutButton);

    }

    @Test(testName = "Create account - Existing and age below 18", dataProvider = "CreateAccountNegativeData")
    public void createAccountNegativeExistingEmailAndAgeBelow18(String firstName, String lastName, String email, String employmentStatus,
                                                                String gender, String maritalStatus, String prefix, String dob, String expectedError) {
        fillTheCreatePrimaryAccountForm(firstName, lastName, email, employmentStatus, gender, maritalStatus, prefix, dob);
        String errorMessage = getElementText(createPrimaryAccountPage.errorMessage);
        String actualErrorMessage = errorMessage.replaceAll("ERROR", "").trim();
        Assert.assertEquals(actualErrorMessage, expectedError, "Error message should match");
    }

    @DataProvider(name = "CreateAccountNegativeData")
    public String[][] createNewAccountNegativeData() {
        return new String[][]{
                {"David", "Lur", "David.Lur4593@happy.ca", "tester", "Male", "Married", "Mr.", "10/15/2010", "you must be 18 years or older to create account"},
                {"David", "Lur", "David.Lur3120@happy.ca", "tester", "Male", "Married", "Mr.", "10/15/2000", "Account with email David.Lur3120@happy.ca is exist"},
        };
    }

}
