package Registration;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupPage {
    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    private By userName = By.xpath("//input[@data-qa=\"signup-name\"]");
    private By email=By.xpath("//input[@data-qa=\"signup-email\"]");
    private By signUpButton =By.xpath("//button[@data-qa=\"signup-button\"]");

    //Action Methods
    @Step(" filling the data in the signup page")
    public SignupPage firstSignUpPage(String name , String Email){
        driver.findElement(userName).sendKeys(name);
        driver.findElement(email).sendKeys(Email);
        driver.findElement(signUpButton).click();
        return  this;
    }

    //validations
    @Step("verify that we are in the signup page")
    public SignupPage validateNewUserSignUpPage(){
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]")).isDisplayed(), "New User Signup!");
        //or the xpath may be div[@class="signup-form"]/h2
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");
        System.out.println("User is in Signup Page");
        return this;

    }
}
