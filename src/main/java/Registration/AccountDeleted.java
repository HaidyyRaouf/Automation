package Registration;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountDeleted {
    public AccountDeleted(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
    private By accountDeletedMessage = By.xpath("//b[contains(text(),'Account Deleted!')]");
    private By continueButton2 = By.xpath("//a[@data-qa='continue-button']");

    //Action Methods
    @Step("clicking on continue to navigate to the home page")
    public AccountDeleted navigatingToTheHomePage(){
        driver.findElement(continueButton2).click();
        return this;
    }

    //validations
    @Step("verify that the account deleted successfully")
    public AccountDeleted verifyOnAccountDeletedMessage(){
        System.out.println("User Pressed on Delete Account");
        Assert.assertTrue(driver.findElement(accountDeletedMessage).isDisplayed(),"Message is not appeared");
        return this;
    }
}
