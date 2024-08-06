package Nagative_scenarios;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AssetMainFLow.Screenshot_class;
import AssetMainFLow.User1Login;

public class UserLoginTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Navigate to the login page
        driver.get("http://35.154.145.139/login");  
        driver.manage().window().maximize();
    }

    private void clearFields() {
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        email.clear();
        password.clear();
    }

    @Test(priority = 1)
    public void testInvalidEmailFormat() throws InterruptedException, IOException {
    	String UserName="sp123@gmailcom";
    	String Password="123456789";
    	User1Login login = new User1Login(driver);
        login.Login_User1(UserName,Password );
        Thread.sleep(1500);
        
        // screenshot
        Screenshot_class sc = new Screenshot_class(driver);
        sc.takeScreenshot("C:\\Users\\tai-0\\eclipse-workspace\\Index_maven\\screenshots\\testcase1.jpg");

        // Verify error message
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Invalid Email or Password')]")));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for invalid email format");
    }

    @Test(priority = 2)
    public void testInvalidPassword() throws InterruptedException, IOException {
    	
    	driver.navigate().to("http://35.154.145.139/login");
        clearFields();
        
    	String UserName="settiprashanth@gmail.com";
    	String Password="12345";
    	User1Login login = new User1Login(driver);
        login.Login_User1(UserName,Password );
               
        Thread.sleep(1500);
        // screenshot
        Screenshot_class sc = new Screenshot_class(driver);
        sc.takeScreenshot("C:\\Users\\tai-0\\eclipse-workspace\\Index_maven\\screenshots\\testcase2.jpg");

        // Verify error message
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Invalid Email or Password')]")));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for incorrect password");
    }

    @Test(priority = 3)
    public void testEmptyEmailField() throws InterruptedException, IOException {
     	driver.navigate().to("http://35.154.145.139/login");
        clearFields();
        
        String UserName="";
    	String Password="123456789";
    	User1Login login = new User1Login(driver);
        login.Login_User1(UserName,Password );


        Thread.sleep(1500);   
        // screenshot
        Screenshot_class sc = new Screenshot_class(driver);
        sc.takeScreenshot("C:\\Users\\tai-0\\eclipse-workspace\\Index_maven\\screenshots\\testcase3.jpg");
        // Verify error message
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Please enter your email')]")));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for empty email field");
    }

    @Test(priority = 4)
    public void testEmptyPasswordField() throws InterruptedException, IOException {
    	driver.navigate().to("http://35.154.145.139/login");
        
        clearFields();
        
        String UserName="settiprashanth@gmail.com";
    	String Password="";
    	User1Login login = new User1Login(driver);
        login.Login_User1(UserName,Password );
        
        Thread.sleep(1500);   
        // screenshot
        Screenshot_class sc = new Screenshot_class(driver);
        sc.takeScreenshot("C:\\Users\\tai-0\\eclipse-workspace\\Index_maven\\screenshots\\testcase4.jpg");

        // Verify error message
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Please enter your password')]")));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for empty password field");
    }

    @Test(priority = 5)
    public void testBothFieldsEmpty() throws InterruptedException, IOException {
    	driver.navigate().to("http://35.154.145.139/login");
        
    	clearFields();
        
        String UserName="";
    	String Password="";
    	User1Login login = new User1Login(driver);
        login.Login_User1(UserName,Password );
        
        Thread.sleep(1500);
               
        // screenshot
        Screenshot_class sc = new Screenshot_class(driver);
        sc.takeScreenshot("C:\\Users\\tai-0\\eclipse-workspace\\Index_maven\\screenshots\\testcase5.jpg");

        // Verify email field error message
        WebElement emailErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Please enter your email')]")));
        Assert.assertTrue(emailErrorMessage.isDisplayed(), "Error message not displayed for empty email field");

        // Verify password field error message
        WebElement passwordErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Please enter your password')]")));
        Assert.assertTrue(passwordErrorMessage.isDisplayed(), "Error message not displayed for empty password field");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
