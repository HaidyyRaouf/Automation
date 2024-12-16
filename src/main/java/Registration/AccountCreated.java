package Registration;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountCreated {
    public AccountCreated(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
    private By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']");
    private By continueButton = By.xpath("(//a)[10]");

    //Action Methods
    @Step("clicking on continue to navigate to the home page")
    public AccountCreated continueToTheHomePage(){
        driver.findElement(continueButton).click();
        return this;
    }

    //validations
    @Step("verify that the account created successfully")
    public AccountCreated verifyOnAccountCreatedMessage(){
        System.out.println("Regestration form is filled Successfully");
        Assert.assertEquals(driver.findElement(accountCreatedMessage).getText(), "ACCOUNT CREATED!", "Message Is Not Displayed");
            return this;
    }
}
