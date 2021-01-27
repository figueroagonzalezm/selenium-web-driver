package com.selenium.google;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }
    @Test
    public void testGooglePage(){
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.clear();
        searchbox.sendKeys("quality-stream Introducción a la Automatización");
        searchbox.submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals("quality-stream Introducción a la Automatización - Buscar con Google", driver.getTitle());
    }

    @After
    public void tearDown(){
        //driver.quit();
    }
}
