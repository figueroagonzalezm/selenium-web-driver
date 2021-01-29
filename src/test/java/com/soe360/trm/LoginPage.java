package com.soe360.trm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import soe360.Base;

import java.util.concurrent.TimeUnit;

public class LoginPage extends Base {

    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");

    By welcomeLinkLocator  = By.partialLinkText("Bienvenido,");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void signIn(){
        //setImplicitWait(30);
        if(isDisplayed(usernameLocator)){
            type("mfigueroa", usernameLocator);
            type("Cambiame.1", passwordLocator);
            findElement(passwordLocator).submit();
        }else{
            System.out.println("username texbox was not present");
        }
    }

    public boolean isHomePageDisplayed(){
        return isDisplayed(welcomeLinkLocator);
    }
}
