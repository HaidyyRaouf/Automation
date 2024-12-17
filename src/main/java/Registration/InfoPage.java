package Registration;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class InfoPage {
    public InfoPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    private By accountInformationMessage =By.xpath("(//b)[1]");
    private By title = By.id("id_gender2");
    private By password = By.xpath("//input[@data-qa=\"password\"]");
    private By day = By.id("days");
    private By month= By.id("months");
    private By year = By.id("years");
    private By newsLetterCheckPoint = By.id("newsletter");
    private By specialOfferCheckPoint =  By.id("optin");
    private By firstName= By.xpath("//input[@data-qa=\"first_name\"]");
    private By lastName =By.xpath("//input[@data-qa=\"last_name\"]");
    private By company= By.xpath("//input[@data-qa=\"company\"]");
    private By address1 = By.xpath("//input[@data-qa=\"address\"]");
    private By country = By.id("country");
    private By state= By.xpath("//input[@data-qa=\"state\"]");
    private By city=  By.xpath("//input[@data-qa=\"city\"]");
    private By zipCode  =By.xpath("//input[@data-qa=\"zipcode\"]");
    private By mobileNumber=  By.xpath("//input[@data-qa=\"mobile_number\"]");
    private By createAccountButton =  By.xpath("//button[@data-qa='create-account']");

    //Action methods
    @Step("filling account info")
    public InfoPage fillingAccountInfo(String Day, String Month, String Year,String Password,String Country, String State, String City, String ZipCode,String number, String First,String Last, String Company,String Address)
    {
        driver.findElement(title).click();
        new Select(driver.findElement(day)).selectByValue(Day);
        new Select(driver.findElement(month)).selectByValue(Month);
        new Select(driver.findElement(year)).selectByValue(Year);
        driver.findElement(password).sendKeys(Password);
        driver.findElement(newsLetterCheckPoint).click();
        driver.findElement(specialOfferCheckPoint).click();
        new Select(driver.findElement(country)).selectByValue(Country);
        //Enter state , city , zipcode and mobile number
        driver.findElement(state).sendKeys(State);
        driver.findElement(city).sendKeys(City);
        driver.findElement(zipCode).sendKeys(ZipCode);
        driver.findElement(mobileNumber).sendKeys(number);
        driver.findElement(firstName).sendKeys(First);
        driver.findElement(lastName).sendKeys(Last);
        driver.findElement(company).sendKeys(Company);
        driver.findElement(address1).sendKeys(Address);

        return this;

    }




    @Step("clicking on create account")
    public InfoPage createAccount(){
        driver.findElement(createAccountButton).click();
        return this;
    }



    //validations
    @Step("verify that we are in the information page")
    public InfoPage validateOnEnterAccountInfo(){
        System.out.println("User signup successfully");
        Assert.assertTrue(driver.findElement(accountInformationMessage).isDisplayed(),"The Message is not displayed");
        System.out.println("Enter the account information");
        return this;

    }

}
