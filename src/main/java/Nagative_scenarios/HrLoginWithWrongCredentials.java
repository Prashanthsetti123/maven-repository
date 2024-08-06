package Nagative_scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HrLoginWithWrongCredentials {
WebDriver driver;
	
	public HrLoginWithWrongCredentials(WebDriver driver){
		this.driver=driver;
	}
	
	public void Login_User1(String UserName1,String Password1) throws InterruptedException {
		
		// Email
		WebElement Email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		Email.sendKeys(UserName1);

		// Password
		WebElement Password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		Password.sendKeys(Password1);

		// SignIN
		WebElement SignInbutton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		SignInbutton.click();
}
}
