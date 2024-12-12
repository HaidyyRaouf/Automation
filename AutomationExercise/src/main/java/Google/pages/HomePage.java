package Google.pages;

import dev.failsafe.internal.util.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    private WebDriver driver;
    private String url="https://www.google.com/ncr";

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    //Locators
    private By searchField_textArea= By.name("q");

    //Actions
    public void navigate (){
        driver.get(url);
    }

    public void googleSearch(String searchData){
        driver.findElement(searchField_textArea).sendKeys(searchData);
        driver.findElement(searchField_textArea).sendKeys(Keys.ENTER);
    }

    public String getTitleText(){
        return driver.getTitle();
    }

    public String getURLText(){
        return driver.getCurrentUrl();
    }

    public WebElement getSearchFieldElement(){
        return driver.findElement(searchField_textArea);
    }
    //Validations
    public void assertGoogleHomePage(){
        org.testng.Assert.assertEquals(driver.getTitle(),"Google");
        org.testng.Assert.assertTrue(driver.getCurrentUrl().contains("google"));
        org.testng.Assert.assertTrue(driver.findElement(searchField_textArea).isDisplayed());


    }

}
