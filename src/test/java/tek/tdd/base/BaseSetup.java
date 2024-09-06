package tek.tdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseSetup {

    protected static final long WAIT_TIME_IN_SECONDS = 20;
    private static WebDriver driver;
    private final Properties properties;
    private static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);

    public BaseSetup() {

        try {
            String configFilePath = System.getProperty("user.dir") + "/src/test/resources/configs/dev-config.properties";
            LOGGER.debug("Reading Config file " + configFilePath);
            FileInputStream inputStream = new FileInputStream(configFilePath);
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.debug("Error reading config file {} ", e.getMessage());
            throw new RuntimeException("Something wrong with config file, " + e.getMessage());
        }

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setupBrowser() {
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        LOGGER.debug("Running on browser {} and isHeadless {}", browserType, isHeadless);

        if (browserType.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (isHeadless) options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browserType.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (isHeadless) options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        } else if (browserType.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (isHeadless) options.addArguments("--headless");
            driver = new EdgeDriver(options);
        } else
            throw new RuntimeException("Wrong browser type, choose between chrome, firefox and edge");


        String url = properties.getProperty("ui.url");
        LOGGER.debug("Navigating to url {} ", url);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        driver.manage().window().maximize();

    }


    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
