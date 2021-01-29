package com.soe360.trm;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class PlaceOrder_Test {

    private static WebDriver driver;
    PlaceOrderPage placeOrder;
    LoginPage loginPage;

    @BeforeClass
    public static void globalSetUp(){
        //if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
            System.out.println("New Driver instantiated::::::::");
            driver.get("http://10.108.129.50:8080/trm/index_order.jsp");
        //}
    }

    @Before
    public void setUp() {
        loginPage = new LoginPage(driver);
        placeOrder = new PlaceOrderPage(driver);
    }

    @Test
    public void testLogIn() {
        loginPage.signIn();
        assertTrue(loginPage.isHomePageDisplayed());
    }

    @Test
    public void testOrderCreation() {
        placeOrder.createOrder();
        assertTrue(placeOrder.isOrderCreated());
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

}
