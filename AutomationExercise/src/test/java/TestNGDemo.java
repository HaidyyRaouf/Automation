import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGDemo {
    WebDriver driver;
    String websiteURL ="https://automationexercise.com";

    //Locators
    //private By searchField = By.cssSelector("");
    private By homePageLogo =By.xpath("//img[@src='/static/images/home/logo.png']");
    private By signUpAndLoginButton = By.xpath("//a[@href=\"/login\"]");
    private By userName = By.xpath("//input[@data-qa=\"signup-name\"]");
    private By email=By.xpath("//input[@data-qa=\"signup-email\"]");
    private By signUpButton =By.xpath("//button[@data-qa=\"signup-button\"]");
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
    private By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']");
    private By continueButton = By.xpath("(//a)[10]");
    private By usernameIsVisible = By.xpath("//a/b");
    private By deleteButton = By.xpath("//a[@href='/delete_account']");
    private By accountDeletedMessage = By.xpath("//b[contains(text(),'Account Deleted!')]");
    private By continueButton2 = By.xpath("//a[@data-qa='continue-button']");

    @BeforeClass
    public void openTheBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(websiteURL);
    }

    @Test
    public void registrationTestCase() {
        validateHomePageLogo();
        clickOnSignupAndLogin();
        validateNewUserSignUpPage();
        firstSignUpPage("Haidy Raouf","haidyraouf74@gmail.com");
        validateOnEnterAccountInfo();
        fillingAccountInfo("6","4", "2000", "Haidy_1571999");
        fillMainInfo("Haidy", "Raouf", "Giza Systems", "new cairo, first settlement");
        fillingCountryDetails("India","columbia","Bogota","0000");
        fillTheMobileNumber("01094346757");
        createAccount();
        verifyOnAccountCreatedMessage();
        continueToTheHomePage();
        verifyThatUsernameIsVisible();
        deleteAccount();
        verifyOnAccountDeletedMessage();
        //Assert.assertEquals(driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).getText(),"Account Deleted!","Message not appeared");
        navigatingToTheHomePage();
        System.out.println("Account is deleted");
    }
   /* @Test
    public void googleSearch ()
    {
        googleSearch("Headway 2024");
        //Assert.assertEquals(getFirstSearchResultsText, "Headway Intern 2024");
    }*/



    @AfterClass
   public void closeTheBrowser()
    {
        driver.quit();

    }
 //Action Method
   /* private void googleSearch(String searchData){
        driver.findElement(searchField).sendKeys(searchData);
        driver.findElement(searchField).sendKeys(keys.ENTER);

    }*/

public  void clickOnSignupAndLogin (){
        driver.findElement(signUpAndLoginButton).click();
    }

 public void firstSignUpPage(String name , String Email){
     driver.findElement(userName).sendKeys(name);
     driver.findElement(email).sendKeys(Email);
     driver.findElement(signUpButton).click();
 }
 public void fillingAccountInfo(String Day, String Month, String Year,String Password)
 {
     driver.findElement(title).click();
     new Select(driver.findElement(day)).selectByValue(Day);
     new Select(driver.findElement(month)).selectByValue(Month);
     new Select(driver.findElement(year)).selectByValue(Year);
     driver.findElement(password).sendKeys(Password);
     driver.findElement(newsLetterCheckPoint).click();
     driver.findElement(specialOfferCheckPoint).click();

 }



 public void fillingCountryDetails(String Country, String State, String City, String ZipCode) {
        new Select(driver.findElement(country)).selectByValue(Country);
        //Enter state , city , zipcode and mobile number
        driver.findElement(state).sendKeys(State);
        driver.findElement(city).sendKeys(City);
        driver.findElement(zipCode).sendKeys(ZipCode);
    }
    public void fillTheMobileNumber(String number){
        driver.findElement(mobileNumber).sendKeys(number);

    }
    public void createAccount(){
        driver.findElement(createAccountButton).click();
    }
    public void continueToTheHomePage(){
        driver.findElement(continueButton).click();
    }
    public void deleteAccount(){
        driver.findElement(deleteButton).click();
    }
    public void navigatingToTheHomePage(){
        driver.findElement(continueButton2).click();
    }

    //validations
    public void validateHomePageLogo(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        Assert.assertEquals(driver.getTitle(),"Automation Exercise");
        Assert.assertTrue(driver.findElement(homePageLogo).isDisplayed(), "Image not appeared");
        System.out.println("User is in Home Page");


    }
    public void validateNewUserSignUpPage(){
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]")).isDisplayed(), "New User Signup!");
        System.out.println("User is in Signup Page");


    }
    public void validateOnEnterAccountInfo(){
        System.out.println("User signup successfully");
        Assert.assertTrue(driver.findElement(accountInformationMessage).isDisplayed(),"The Message is not displayed");
        System.out.println("Enter the account information");


    }
    public void fillMainInfo(String First,String Last, String Company,String Address){
        driver.findElement(firstName).sendKeys(First);
        driver.findElement(lastName).sendKeys(Last);
        driver.findElement(company).sendKeys(Company);
        driver.findElement(address1).sendKeys(Address);
    }
public void verifyOnAccountCreatedMessage(){
    System.out.println("Regestration form is filled Successfully");
    Assert.assertEquals(driver.findElement(accountCreatedMessage).getText(), "ACCOUNT CREATED!", "Message Is Not Displayed");

}
public void verifyThatUsernameIsVisible(){
    System.out.println("Account is Created Successfully");

//    Assert.assertEquals(driver.findElement(usernameIsVisible).getText(),"Haidy Raouf");
    Assert.assertEquals("Logged in as "+

            driver.findElement(usernameIsVisible).getText(),"Logged in as Haidy Raouf");
    System.out.println("Username is visible");



}
public void verifyOnAccountDeletedMessage(){
    System.out.println("User Pressed on Delete Account");
    Assert.assertTrue(driver.findElement(accountDeletedMessage).isDisplayed(),"Message is not appeared");

}
}
