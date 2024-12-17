package registrationTests;

import Registration.*;
import Utilities.DriverFactory;
import Utilities.JsonFileManager;
import Utilities.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;




public class registration {
    WebDriver driver;
    String websiteURL ="https://automationexercise.com";

    DriverFactory driverFactory;

    @BeforeClass
    public void openTheBrowser() {
        driver = DriverFactory.initiateDriver(System.getProperty("browserName"),true, Boolean.parseBoolean(System.getProperty("headless")));
        driver.navigate().to(websiteURL);
        jm = new JsonFileManager("src/test/resources/TestData.json");

    }

    @AfterClass
    public void closeTheBrowser()
    {
        driver.quit();

    }

    @BeforeSuite
            public void beforeSuite(){
        PropertiesReader.loadProperties();
    }

    JsonFileManager jm;
    @Severity(SeverityLevel.CRITICAL)
    @Description("Register new User")
    @Test

    public void registrationTestCase() {
        new HomePage(driver).validateHomePageLogo();
        new MenuPage(driver).clickOnSignupAndLogin();
        new SignupPage(driver).validateNewUserSignUpPage()
        .firstSignUpPage(jm.getTestData("UserName"),"haidyrfaouf74@gmail.com");
        new InfoPage(driver).validateOnEnterAccountInfo()
        .fillingAccountInfo("6","4", "2000", "Haidy_1571999")
        .fillMainInfo("Haidy", "Raouf", "Giza Systems", "new cairo, first settlement")
        .fillingCountryDetails("India","columbia","Bogota","0000")
        .fillTheMobileNumber("01094346757")
        .createAccount();
        new AccountCreated(driver).verifyOnAccountCreatedMessage()
        .continueToTheHomePage();
        new MenuPage(driver).verifyThatUsernameIsVisible()
        .deleteAccount();
        new AccountDeleted(driver).verifyOnAccountDeletedMessage();
    }
}
