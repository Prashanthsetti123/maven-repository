package AssetMainFLow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class User2Login {
WebDriver driver;
	
	public User2Login(WebDriver driver){
		this.driver=driver;
	}
	
	public void Login_User2(String User2,String Password2) {
		
		// Email
		WebElement Email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		Email.sendKeys(User2);

		// Password
		WebElement Password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		Password.sendKeys(Password2);

		// SignIN
		WebElement SignInbutton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		SignInbutton.click();
	}
}
