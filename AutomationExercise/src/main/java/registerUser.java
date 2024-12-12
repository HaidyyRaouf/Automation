import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class registerUser {
    public static void main(String[] args) {
        // openTheBrowser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://automationexercise.com");

        //registration
        driver.findElement(By.linkText("Signup / Login")).click();

        //enterValidNameAndEmailInSignUpPage
        driver.findElement(By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)")).sendKeys("Haidy Raouf");
        driver.findElement(By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)")).sendKeys("haidyraouf74@gmail.com");
        driver.findElement(By.cssSelector("#form > div > div > div:nth-child(3) > div > form > button")).click();

        //fillingAccountInformationFields
        driver.findElement(By.cssSelector("#form > div > div > div > div.login-form > form > div.clearfix > div:nth-child(4) > label")).click();
        driver.findElement(By.cssSelector("#password")).sendKeys("Haidy_1571999");
        //xpath = //tagname[@attribute='value']
        //drop down list
        WebElement dayDropDown = driver.findElement(By.xpath("//select[@data-qa='days']"));
        Select daySelect = new Select(dayDropDown);
        WebElement monthDropDown = driver.findElement(By.xpath("//select[@data-qa='months']"));
        Select monthSelect = new Select(monthDropDown);
        WebElement yearDropDown = driver.findElement(By.xpath("//select[@data-qa='years']"));
        Select yearSelect = new Select(yearDropDown);
        daySelect.selectByVisibleText("15");
        monthSelect.selectByIndex(7);
        yearSelect.selectByValue("1999");

        //Click on the two Checkpoints below birthdate
        driver.findElement(By.cssSelector("#form > div > div > div > div.login-form > form > div:nth-child(7)")).click();
        driver.findElement(By.cssSelector("#form > div > div > div > div.login-form > form > div:nth-child(8)")).click();

        //Enter first , last names , company and address
        driver.findElement(By.cssSelector("#first_name")).sendKeys("Haidy");
        driver.findElement(By.cssSelector("#last_name")).sendKeys("Raouf");
        driver.findElement(By.cssSelector("#company")).sendKeys("Giza Systems");
        driver.findElement(By.cssSelector("#address1")).sendKeys("new cairo, first settlement");

        //Country dropdown
        WebElement countryDropDown = driver.findElement(By.xpath("//select[@data-qa='country']"));
        Select countrySelect = new Select(countryDropDown);
        countrySelect.selectByVisibleText("Canada");

        //Enter state , city , zipcode and mobile number
        driver.findElement(By.cssSelector("#state")).sendKeys("columbia");
        driver.findElement(By.cssSelector("#city")).sendKeys("Bogota");
        driver.findElement(By.cssSelector("#zipcode")).sendKeys("0000");
        driver.findElement(By.cssSelector("#mobile_number")).sendKeys("01094346757");

        //Click on create account button
        driver.findElement(By.cssSelector("#form > div > div > div > div.login-form > form > button")).click();

        //Click on Continue Button
        driver.findElement(By.cssSelector("#form > div > div > div > div > a")).click();

        //click on delete account
        driver.findElement(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a")).click();











    }
}
