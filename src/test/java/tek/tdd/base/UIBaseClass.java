package tek.tdd.base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tek.tdd.page.*;
import tek.tdd.utility.JavaUtilities;
import tek.tdd.utility.SeleniumUtility;

import java.time.format.DateTimeFormatter;

@Listeners({ExtentITestListenerClassAdapter.class})
public class UIBaseClass extends SeleniumUtility {

    public static final DateTimeFormatter formatter = JavaUtilities.dateFormatter("MMMM d, yyyy");
    private static final Logger LOGGER = LogManager.getLogger(UIBaseClass.class);
    public HomePage homePage;
    public CreatePrimaryAccountPage createPrimaryAccountPage;
    public SignUpPage signUpPage;
    public SignInPage signInPage;
    public PrimaryAccountPage primaryAccountPage;
    public ProfilePage profilePage;
    public CustomerPortalPage customerPortalPage;
    public PlansPage plansPage;
    public AccountsPage accountsPage;
    public Settings settings;


    @BeforeMethod
    public void setupTest(){
        LOGGER.debug("Setup test and opening browser");
        setupBrowser();
        homePage = new HomePage();
        createPrimaryAccountPage = new CreatePrimaryAccountPage();
        signUpPage = new SignUpPage();
        signInPage = new SignInPage();
        primaryAccountPage = new PrimaryAccountPage();
        profilePage = new ProfilePage();
        customerPortalPage = new CustomerPortalPage();
        plansPage = new PlansPage();
        accountsPage = new AccountsPage();
        settings = new Settings();
    }

    @AfterMethod
    public void testCleanUp(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            TakesScreenshot screenshot = (TakesScreenshot)  getDriver();
            String shot = screenshot.getScreenshotAs(OutputType.BASE64);

            ExtentTestManager.getTest().fail("Test failed taking screenshot ", MediaEntityBuilder.createScreenCaptureFromBase64String(shot).build());
        }
        LOGGER.debug("Running after each test and quite browser");
        quitBrowser();
    }

}
