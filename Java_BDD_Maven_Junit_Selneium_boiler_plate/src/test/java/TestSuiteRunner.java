import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.BaseUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-reports.html",
                "json:target/testSuite-html-reports/cucumber.json"}, monochrome = true, tags = "<Tags seperated by comma>"
)
public class TestSuiteRunner {
    static WebDriver driver= null;

    @BeforeClass
    public static void setUp() throws IOException {
        DesiredCapabilities cap = null;
        int port = 0;
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("browserConfig.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String browser = properties.getProperty("browser.type");
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", properties.getProperty("browser.chrome.path"));
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-dev-shm-usage");
                cap= new DesiredCapabilities();
                cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                driver = new ChromeDriver();

            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", properties.getProperty("browser.firefox.path"));
                cap= new DesiredCapabilities();
                driver = new FirefoxDriver();
            }
            new BaseUtil().setDriver(driver);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
        driver.close();
    }
}