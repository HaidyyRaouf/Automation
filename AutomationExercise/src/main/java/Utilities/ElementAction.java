package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementAction {
    static WebDriver driver;
    private static int defaultTime;
    private static Wait<WebDriver> wait;

    @Step("Click On locator : {elementLocators}")
    public static void click(By elementLocators) {
        elementWaitingStrategy(driver, elementLocators);
        wait.until(ExpectedConditions.elementToBeClickable(elementLocators));
        driver.findElement(elementLocators).click();
        System.out.println("clicking on element: " + driver.findElement(elementLocators).getAccessibleName() + " and its locators is: " + elementLocators);
    }

    private static void elementWaitingStrategy(WebDriver driver, By elementLocators) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocators));
    }

    @Step(" get Text of {elementLocators}")
    private static String getText(By elementLocators) {
        elementWaitingStrategy(driver, elementLocators);
        return driver.findElement(elementLocators).getText();
    }
}