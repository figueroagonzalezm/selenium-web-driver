package com.soe360.icrs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ICRS_LoginTest {
    private WebDriver driver;
    By usernameLocator = By.id("formLogin:usernameTxt");
    By passwordLocator = By.id("formLogin:passwordTxt");
    By btnLogInLocator = By.id("formLogin:loginBtn");

    By pageHeadTextLocator = By.xpath("//div[contains(text(), 'ICRS Servicio')]");


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://10.108.129.50:8080/serviciosRelianz/");
    }
    @Test
    public void testICRSLogin(){
        WebElement usernameBox = driver.findElement(usernameLocator);
        WebElement passwordBox = driver.findElement(passwordLocator);
        WebElement buttonLogin = driver.findElement(btnLogInLocator);


        usernameBox.clear();
        passwordBox.clear();

        usernameBox.sendKeys("8789429");
        passwordBox.sendKeys("mafg");
        buttonLogin.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement pageHeadText = driver.findElement(pageHeadTextLocator);
        String headText = pageHeadText.getText();
        System.out.println(headText);
        assertEquals("ICRS Servicio", headText);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
