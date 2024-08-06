package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;
	
	public BasePage(WebDriver driver) throws AWTException
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
}
