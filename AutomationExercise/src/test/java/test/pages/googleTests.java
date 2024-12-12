package test.pages;

import Google.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class googleTests {
    private WebDriver driver;
    HomePage homePage;
    @Test
    public void googleSearch1(){
        HomePage homePage = new HomePage(driver);
        homePage.navigate();
        Assert.assertEquals(homePage.getTitleText(),"Google");
        Assert.assertTrue(homePage.getURLText().contains("google"));
        Assert.assertTrue(homePage.getSearchFieldElement().isDisplayed());
        homePage.googleSearch("Headway 2024");
    }

    @Test
    public void googleSearch2(){
        HomePage homePage = new HomePage(driver);
        homePage.navigate();
        Assert.assertEquals(homePage.getTitleText(),"Google");
        Assert.assertTrue(homePage.getURLText().contains("google"));
        Assert.assertTrue(homePage.getSearchFieldElement().isDisplayed());
        homePage.googleSearch("Headway 2024");
    }

    @Test
    public void googleSearch3(){
        homePage.navigate();
        homePage.assertGoogleHomePage();
        homePage.googleSearch("Headway 2024");

    }

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
