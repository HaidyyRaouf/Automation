package Registration;

import Utilities.DriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage
{
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;


    //Locators
    private By homePageLogo =By.xpath("//img[@src='/static/images/home/logo.png']");

    //validations
    @Step("validate that we are in the home page")
    public HomePage validateHomePageLogo(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        Assert.assertEquals(driver.getTitle(),"Automation Exercise");
        Assert.assertTrue(driver.findElement(homePageLogo).isDisplayed(), "Image not appeared");
        System.out.println("User is in Home Page");
        return this;
    }


}
