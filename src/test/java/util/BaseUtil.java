package util;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseUtil {

    static private WebDriver driver;
    WebDriverWait wait;

    public WebDriver getDriver() {
        return this.driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String Url) {
        getDriver().get(Url);
        wait = new WebDriverWait(getDriver(), 30);
    }

    public WebElement actionOnUIElement(String actionType, String elementType, String elementStr, String enterText) {
        WebElement element = null;
        try {
            Class cls = Class.forName("org.openqa.selenium.By");
            Method method = cls.getDeclaredMethod(elementType, String.class);
            wait = new WebDriverWait(getDriver(), 300);
            element = wait.until(ExpectedConditions.presenceOfElementLocated((By) method.invoke(method, new String(elementStr))));

            if (actionType.equalsIgnoreCase("click")) {
                element.click();
                getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            } else if (actionType.equalsIgnoreCase("enterText")) {
                element.clear();
                element.sendKeys(enterText);
            } else if (actionType.equalsIgnoreCase("getElement")) {
                return (element);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            getDriver().quit();
        }
        return element;
    }

    public void verifyText(WebElement element, String expected, String message) {
        Assert.assertEquals(message, expected, element.getText());
    }

    public void verifyOrderIdText(WebElement element, String message) {
        Assert.assertTrue(message, element.getText().contains("sample-store-"));
    }
    public void invokeImplicitWait(int inSeconds){
        getDriver().manage().timeouts().pageLoadTimeout(inSeconds, TimeUnit.SECONDS);
    }
    public void handleIFrame(int i) {
        if (i == 0) {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(i));
        } else if (i == 1) {
            getDriver().switchTo().defaultContent();
        } else if (i == 2) {
            getDriver().switchTo().parentFrame();
        }
    }

    public Actions getActionBuilder() {
        return new Actions(getDriver());
    }


    public void takeSnapshot(String fileNameRef){
        Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
        TakesScreenshot snap =((TakesScreenshot)getDriver());
        try {
            File srcFile=snap.getScreenshotAs(OutputType.FILE);
            File destFile = new File("./images/" + cap.getBrowserName().toLowerCase() + "/" + fileNameRef+".png");
            FileUtils.copyFile(srcFile, destFile);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
