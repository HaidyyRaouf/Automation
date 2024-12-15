package Registration;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MenuPage {
    private WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By signUpAndLoginButton = By.xpath("//a[@href=\"/login\"]");
    private By usernameIsVisible = By.xpath("//a/b");
    private By deleteButton = By.xpath("//a[@href='/delete_account']");

    //Actions
    @Step("click on signup button")
    public MenuPage clickOnSignupAndLogin() {
        driver.findElement(signUpAndLoginButton).click();
        return this;
    }
    @Step("click on delete button")
    public MenuPage deleteAccount() {
        driver.findElement(deleteButton).click();
        return this;
    }

    //Validations
    @Step("verify that the username is visible in the menu bar")
    public MenuPage verifyThatUsernameIsVisible() {
        System.out.println("Account is Created Successfully");
        Assert.assertEquals("Logged in as " + driver.findElement(usernameIsVisible).getText(), "Logged in as TestName");
        System.out.println("Username is visible");
        return this;

    }
}
