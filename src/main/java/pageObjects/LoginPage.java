package pageObjects;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	WebDriver driver;
	
	public LoginPage(WebDriver driver) throws AWTException
	{
		super(driver);
	}
	

@FindBy(xpath="//input[@id='inFormLoginUsername-inner']") WebElement Username;
@FindBy(xpath="//input[@id='inFormLoginPassword-inner']") WebElement Password;
@FindBy(xpath="//div[@id='oCheckBox-CbBg']") WebElement RememberMe;
@FindBy(xpath="//span[@id='formLoginButton-content']") WebElement LoginButton;


public void setUsername(String Uname) {
	Username.sendKeys(Uname);

}

public void setPassword(String pwd) {
	Password.sendKeys(pwd);

}

public void clickRememberMe()
{
	RememberMe.click();
}

public void clickLoginButton()
{
	LoginButton.click();
}

}
