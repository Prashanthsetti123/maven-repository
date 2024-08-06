package Asset;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AssetMainFLow.CreateAsset;
import AssetMainFLow.ModifyAsset;
import AssetMainFLow.Reject_Asset;
import AssetMainFLow.User1Login;
import AssetMainFLow.User2Login;
import AssetMainFLow.Verify_the_Asset;
import AssetMainFLow.deliverTheProduct;
import AssetMainFLow.ApproveAsset;

public class Testcases {
		
	String Qty="152";
	String UnitPrice="54120";
	
	String ModifyQTY="16";
	String Modify_UnitPrice="16541";
	String ModifyRemarks=" Need to change the Quantity from " + Qty +" to " +  ModifyQTY;
	String RemarkMessage="Not necessary now";
	
	//Driver intialization	
	WebDriver driver;
	
	//integrating the credentials class
    User_Credentials credentials=new User_Credentials();
    
    @BeforeClass
    public void setup() {
    	driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://35.154.145.139/login"); 
    }

    @Test(priority = 1)
    public void verifyHRLogin() throws InterruptedException {
        WebElement usernameField = driver.findElement(By.xpath("//input[@id=\"email\"]")); 
        WebElement passwordField = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        WebElement SignInbutton = driver.findElement(By.xpath("//button[@type=\"submit\"]")); 

        usernameField.sendKeys(credentials.Hr_Username); 
        passwordField.sendKeys(credentials.Hr_Password); 
        SignInbutton.click();

        String expectedUrl = "http://35.154.145.139/login"; 
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "HR login failed!");
        System.out.println("Hr Login Successfully");
        Thread.sleep(3000);
        LogoutUser lu=new LogoutUser(driver);
        lu.logout();
    }

    @Test(priority = 2)
    public void verifyManagerLogin() throws InterruptedException {
		WebElement usernameField = driver.findElement(By.xpath("//input[@id=\"email\"]")); 
		WebElement passwordField = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		WebElement SignInbutton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        
		usernameField.sendKeys(credentials.Manager_UserName); 
        passwordField.sendKeys(credentials.Manager_Password); 
        SignInbutton.click();

        String expectedUrl = "http://35.154.145.139/login"; // replace with expected URL
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Manager login failed!");
        
        System.out.println("Manager Login Successfully");
        Thread.sleep(3000);
        LogoutUser lu=new LogoutUser(driver);
        lu.logout();
    }
    @Test(priority = 3)
    public void CreateAssetAndVerify() throws InterruptedException {
    	
    	//user1 login
    	User1Login u1=new User1Login(driver);
		u1.Login_User1(credentials.Hr_Username, credentials.Hr_Password);
		
    	//create Asset
    	CreateAsset ca=new CreateAsset(driver);
		ca.NewAsset(Qty, UnitPrice, "C:\\Users\\tai-0\\Downloads\\dummy.pdf");
		
		//verify the created asset 
		Verify_the_Asset va=new Verify_the_Asset(driver);
		va.VerifyTheStatus(Qty, UnitPrice);
		System.out.println("Asset created Successfully");
		Thread.sleep(3000);
		
		//logout user
		 LogoutUser lu=new LogoutUser(driver);
	     lu.logout();
    	
    }
    
    @Test(priority =4)
    public void modifyCreatedAsset() throws InterruptedException, AWTException {
    	
    	//Manager login
    	User2Login u1=new User2Login(driver);
		u1.Login_User2(credentials.Manager_UserName, credentials.Manager_Password);
		
		//Modify the Asset
		ModifyAsset Ma=new ModifyAsset(driver);
		Ma.modify(Qty, UnitPrice, ModifyQTY, Modify_UnitPrice, ModifyRemarks);
		
		//verify the created asset 
		Verify_the_Asset va=new Verify_the_Asset(driver);
		va.VerifyTheStatus(ModifyQTY, Modify_UnitPrice);
		System.out.println("Modified Asset Successfully");
		Thread.sleep(3000);
		
		//logout user
		 LogoutUser lu=new LogoutUser(driver);
	     lu.logout();
	
    }
    
    @Test(priority = 5)
    public void ManagerApproveTheAssetAndVerify() throws InterruptedException {
    	
    	//Manager login
    	User2Login u1=new User2Login(driver);
		u1.Login_User2(credentials.Manager_UserName, credentials.Manager_Password);
		
    	// Approve Asset
		ApproveAsset apas=new ApproveAsset(driver);
		apas.AssetApproval(ModifyQTY,Modify_UnitPrice);
		
		//verify the created asset 
		Verify_the_Asset va=new Verify_the_Asset(driver);
		va.VerifyTheStatus(ModifyQTY, Modify_UnitPrice);
		System.out.println("Asset Approved Successfully");
		Thread.sleep(3000);
		
		//logout user
		 LogoutUser lu=new LogoutUser(driver);
	     lu.logout();
	
    }
    
//    @Test(priority = 6)
    public void ManagerRejectTheAssetAndVerify() throws InterruptedException {
    	//Manager login
    	User2Login u1=new User2Login(driver);
		u1.Login_User2(credentials.Manager_UserName, credentials.Manager_Password);
		
		//Reject Asset
		Reject_Asset ra=new Reject_Asset(driver);
		ra.RejectAsset(Qty, UnitPrice, RemarkMessage);
		
		//verify the created asset 
		Verify_the_Asset va=new Verify_the_Asset(driver);
		va.VerifyTheStatus(ModifyQTY, Modify_UnitPrice);
		System.out.println("Asset Rejected Successfully");
		Thread.sleep(3000);
		
		//logout user
		 LogoutUser lu=new LogoutUser(driver);
	     lu.logout();
    }
    
    @Test(priority = 7)
    public void HRDeliversApprovedAssetAndVerify() throws InterruptedException {
    	
    	//user1 login
    	User1Login u1=new User1Login(driver);
		u1.Login_User1(credentials.Hr_Username, credentials.Hr_Password);
		
		// DELIVER THE PRODUCT
		AssetMainFLow.deliverTheProduct dtp=new deliverTheProduct(driver);
		dtp.deliverTheAsset(ModifyQTY,Modify_UnitPrice);
		Thread.sleep(2000);
		
		//verify the created asset 
		Verify_the_Asset va=new Verify_the_Asset(driver);
		va.VerifyTheStatus(ModifyQTY, Modify_UnitPrice);
		System.out.println("Asset Delivered Successfully");
		Thread.sleep(3000);
		
		//logout user
		 LogoutUser lu=new LogoutUser(driver);
	     lu.logout();
		    
    }
    
//    @Test(priority = 8)
    
    public void VerifyProductReadyForDelivery() throws InterruptedException {
    	
    	//user1 login
    	User1Login u1=new User1Login(driver);
		u1.Login_User1(credentials.Hr_Username, credentials.Hr_Password);
    	
    	Verify_the_Asset va=new Verify_the_Asset(driver);
		va.AssetStatusForDelivery(Qty, UnitPrice);
		Thread.sleep(3000);
		
		//logout user
		 LogoutUser lu=new LogoutUser(driver);
	     lu.logout();
    }


}
