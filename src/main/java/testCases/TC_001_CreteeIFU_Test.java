package testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import pageObjects.CreateeIFUPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_001_CreteeIFU_Test extends BaseClass{
	
	
	@Test
	public void Login_Page_Validation() throws InterruptedException, AWTException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername("velango6");
		lp.setPassword("Ch!nkujnj");
		lp.clickRememberMe();
		lp.clickLoginButton();
		Thread.sleep(1000);
		
		CreateeIFUPage createeIFUpageref=new CreateeIFUPage(driver);
		
		createeIFUpageref.CLick_createEIFU();
		Thread.sleep(500);
		createeIFUpageref.setEIFUname("test auto_test_01");
		createeIFUpageref.setEIFUTitle("test Auto_test title 01");
		
		//multiselect
		Robot rb=new Robot();
		createeIFUpageref.selectRegion();
		rb.keyPress(KeyEvent.VK_ENTER);
		createeIFUpageref.selectFranchise();
		rb.keyPress(KeyEvent.VK_ENTER);
		createeIFUpageref.selectproductFamily();
		rb.keyPress(KeyEvent.VK_ENTER);
		createeIFUpageref.selectproductCategory();
		rb.keyPress(KeyEvent.VK_ENTER);
		createeIFUpageref.selectDocumentSpecificFor(1);
		createeIFUpageref.upload_pdf("C:\\Users\\tai-0\\Downloads\\jnj 1.pdf");
		createeIFUpageref.selectRegion();
		rb.keyPress(KeyEvent.VK_ENTER);
		createeIFUpageref.selectCountries();
		rb.keyPress(KeyEvent.VK_ENTER);
		createeIFUpageref.setstrategyID("5440");
		createeIFUpageref.selectEIFULaguageCovered();
		rb.keyPress(KeyEvent.VK_ENTER);
		
		
			
	}
	
	
	
	
}








