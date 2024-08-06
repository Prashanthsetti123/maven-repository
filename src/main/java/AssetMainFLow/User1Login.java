package AssetMainFLow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class User1Login {
	
	WebDriver driver;
	
	public User1Login(WebDriver driver){
		this.driver=driver;
	}
	
	public void Login_User1(String UserName1,String Password1) throws InterruptedException {
		
		// Email
		WebElement Email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		Email.sendKeys(UserName1);

		// Password
		WebElement Password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		Password.sendKeys(Password1);
		Thread.sleep(500);

		// SignIN
		WebElement SignInbutton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		SignInbutton.click();
		
//		System.out.println("Login Succesfully");
		
		

	
	}
}
	

