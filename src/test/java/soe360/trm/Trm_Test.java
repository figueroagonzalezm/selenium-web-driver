package soe360.trm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Trm_Test {
    private WebDriver driver;
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");

    By welcomeLinkLocator  = By.partialLinkText("Bienvenido,");


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("http://10.108.129.50:8080/trm");

        driver.get("http://10.108.129.50:8080/trm/index_order.jsp");
    }
    @Test
    public void testTrmLogin(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement usernameBox = driver.findElement(usernameLocator);
        WebElement passwordBox = driver.findElement(passwordLocator);

        usernameBox.sendKeys("mfigueroa");
        passwordBox.sendKeys("Cambiame.1");
        passwordBox.submit();

        WebElement welcomeLink = driver.findElement(welcomeLinkLocator);

        selectComboValue("bahia", "11");


        assertTrue(welcomeLink.isDisplayed());
    }

    @After
    public void tearDown(){
        //driver.quit();
    }

    public void enterElementText(final String elementId, final String value) {
        final WebElement webElement = driver.findElement(By.id(elementId));
        webElement.clear();
        webElement.sendKeys(value);
    }
    public void selectComboValue(final String elementId, final String value) {
        final Select selectBox = new Select(driver.findElement(By.id(elementId)));
        selectBox.selectByValue(value);
    }
}
