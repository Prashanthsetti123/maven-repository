package Nagative_scenarios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AssetMainFLow.Screenshot_class;
import AssetMainFLow.User1Login;

public class Negative_testcases {

	// Driver intialization
	WebDriver driver;

	String Hr_Username = "settiPrash@gmail.com";
	String Hr_Password = "123456";

	@BeforeClass
	public void setup() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://35.154.145.139/login");
	}
//	http://35.154.145.139/login
	@Test(priority = 1)
	public void HrLoginWithWrongCredentials() throws InterruptedException, IOException {

		HrLoginWithWrongCredentials u1 = new HrLoginWithWrongCredentials(driver);
		u1.Login_User1(Hr_Username, Hr_Password);

		// screenshot
		Screenshot_class sc = new Screenshot_class(driver);
		sc.takeScreenshot("C:\\Users\\tai-0\\eclipse-workspace\\Index_maven\\screenshots\\loginfailed1.jpg");

	}
}
