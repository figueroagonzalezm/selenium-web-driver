package com.soe360.trm;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import soe360.Base;

import java.util.Arrays;
import java.util.List;

public class PlaceOrderPage extends Base {

    By otLocator = By.id("ot");
    By bahiaLocator = By.id("bahia");
    By guardarLocator = By.id("guardar");
    By articleCodeLocator = By.cssSelector("input[id^='codi_arti_fina']");
    By articleAmountLocator = By.cssSelector("input[id^='cant_digi']");

    By articleCode2Locator = By.cssSelector("input[id^='codi_arti']");

    By newRowLocator = By.id("nuev_fila");
    By confirmationMessageLocator = By.xpath("//strong[contains(text(), 'Su pedido ha sido enviado')]");

    List<String> articlesCodeValues = Arrays.asList("16MM50", "16MM", "G40");
    List<String> articlesAmountValues = Arrays.asList("1", "1", "1");

    public PlaceOrderPage(WebDriver driver) {
        super(driver);
    }

    public void createOrder() {
        selectComboValue(bahiaLocator, "11");
        type("PRUEBA1", otLocator);
        click(newRowLocator);
        click(newRowLocator);
        List<WebElement> txtArticlesCode = findElements(articleCodeLocator);
        List<WebElement> txtArticlesAmount = findElements(articleAmountLocator);
        List<WebElement> txtArticlesCode2 = findElements(articleCode2Locator);


        int i;
        for (i = 0; i < txtArticlesCode.size(); i++) {
            txtArticlesCode.get(i).sendKeys(articlesCodeValues.get(i));
            txtArticlesCode.get(i).sendKeys(Keys.TAB);
            txtArticlesAmount.get(i).sendKeys(articlesAmountValues.get(i));
        }
        //waits for the value of hidden field articleCode to has a value
        ExpectedCondition<Boolean> condition = ExpectedConditions
                .attributeToBeNotEmpty(txtArticlesCode2.get(i - 1), "value");
        waitForCondition(10, condition);

        click(guardarLocator);
    }

    public boolean isOrderCreated() {
        //setImplicitWait(30);
        return isDisplayed(confirmationMessageLocator);
    }
}
