package soe360;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Base {

    //note: this strategy (static declaration of WebDriver) might not be good when parallel test cases are configured to run
    //in that case possibly you need to configure the driver initialization at Test Class and be passed as constructor method parameter to the pages classes
    public static WebDriver driver;

    public Base(WebDriver driverParam) {
        driver = driverParam;
    }

//    public WebDriver chromeDriverConnection() {
//        if (driver == null) {
//
//            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
//            driver = new ChromeDriver();
//            System.out.println("New Driver instantiated::::::::");
//        }
//        return driver;
//    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    String getText(WebElement element) {
        return element.getText();
    }

    String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void visit(String url) {
        driver.get(url);
    }

    public void setImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void selectComboValue(String elementId, String value) {
        Select selectBox = new Select(driver.findElement(By.id(elementId)));
        selectBox.selectByValue(value);
    }

    public void selectComboValue(By locator, String value) {
        Select selectBox = new Select(driver.findElement(locator));
        selectBox.selectByValue(value);
    }


    protected void waitForCondition(int seconds, ExpectedCondition<Boolean> condition) {
        WebDriverWait ewait = new WebDriverWait(driver, seconds);
        ewait.until(condition);
    }
}
