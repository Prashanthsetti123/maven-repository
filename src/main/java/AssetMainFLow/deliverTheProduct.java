package AssetMainFLow;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import AssetMainFLow.LogoutUser;
import AssetMainFLow.User1Login;
import AssetMainFLow.User2Login;

public class deliverTheProduct {
    WebDriver driver;
   
    public deliverTheProduct(WebDriver driver) {
	
		this.driver = driver;
	}
	public void deliverTheAsset(String Quantity,String UnitPrice) throws InterruptedException {
       
       	// Inbox Page
        Thread.sleep(1000);
        WebElement Inbox_Page = driver.findElement(By.xpath("(//a[@href='/inboxpage'])[1]"));
        Inbox_Page.click();
        Thread.sleep(2000);

        // Handling table
        List<WebElement> AssetsList = driver.findElements(By.xpath("//*[@class=\"ant-table-content\"]//table//tr"));
        int No_of_Assets = AssetsList.size();
//        System.out.println("The total size: " + No_of_Assets);
        Actions act=new Actions(driver);
       
        Boolean elementFound=false;
        while(true) {
        // Iterate through table rows
        for (int i = 1; i <No_of_Assets; i++) { // Start from 2 assuming the first row is a header
            String reqQTY = driver.findElement(By.xpath("//table//tr[\" + i + \"]//td[2]")).getText();
            String reqPrice = driver.findElement(By.xpath("//table//tr[\" + i + \"]//td[3]")).getText();
           
            
            if (Quantity.equalsIgnoreCase(reqQTY) && UnitPrice.equalsIgnoreCase(reqPrice)) {
//            	 System.out.println("Retrieved data from the table: " + reqQTY + "::" + reqPrice);
            	Thread.sleep(2000);
            	WebElement DeliverButton=driver.findElement(By.xpath("//table//tr[" + i + "]//td[11]//button//span[text()='D']"));
            	act.moveToElement(DeliverButton).click().perform();
                Thread.sleep(1000);
//                System.out.println("Delivered successfully");
                elementFound=true;                
                break;
            }
        }  
        if (elementFound) {
            break;
        }
        WebElement NextButton = driver.findElement(By.xpath("//a[text()=\"Next\"]"));
        
        //checking condition with attribute of next button
        String enableornot=driver.findElement(By.xpath("//*[text()=\"Next\"]//parent::li")).getAttribute("aria-disabled");
//        System.out.println("the next button is disabled::"+enableornot);
        
        if (enableornot.equalsIgnoreCase("true")) {
//            System.out.println("No more pages to navigate. Element not found.");
            break;
        }

//        System.out.println("Navigating to the next page");
        NextButton.click();
    }
	}
	
//	public void CannotDeliverTheAsset(String Quantity, String UnitPrice) throws InterruptedException {
//	    // Inbox Page
//	    Thread.sleep(1000);
//	    WebElement inboxPage = driver.findElement(By.xpath("(//a[@href='/inboxpage'])[1]"));
//	    inboxPage.click();
//	    Thread.sleep(2000);
//
//	    // Handling table
//	    List<WebElement> assetsList = driver.findElements(By.xpath("//*[@class=\"ant-table-content\"]//table//tr"));
//	    int noOfAssets = assetsList.size();
//	    Actions act = new Actions(driver);
//
//	    boolean elementFound = false;
//	    while (true) {
//	        // Iterate through table rows
//	        for (int i = 1; i <= noOfAssets; i++) { // Start from 1 assuming the first row is a header
//	            String reqQTY = driver.findElement(By.xpath("//table//tr[\" + i + \"]//td[2]")).getText();
//	            String reqPrice = driver.findElement(By.xpath("//table//tr[\" + i +\"]//td[3]")).getText();
//
//	                         
//	            if (Quantity.equalsIgnoreCase(reqQTY) && UnitPrice.equalsIgnoreCase(reqPrice)) {
//	                System.out.println("Retrieved data from the table: " + reqQTY + "::" + reqPrice);
//	                Thread.sleep(2000);
//
//	                // Find Deliver Button
//	                WebElement deliverButton = driver.findElement(By.xpath("//table//tr[\" + i + \"]//td[11]//button"));
//
//	                // Check if the Deliver button is disabled
//	                if (deliverButton.getAttribute("disabled") != null) {
//	                    System.out.println("The Deliver button is disabled. Cannot deliver the asset.");
//	                } else {
//	                    act.moveToElement(deliverButton).click().perform();
//	                    System.out.println("Deliver button clicked. Asset delivered successfully.");
//	                }
//
//	                elementFound = true;
//	                break;
//	            }
//	        }
//
//	        if (elementFound) {
//	            break;
//	        }
//
//	        // Check if the "Next" button is disabled
//	        WebElement nextButton = driver.findElement(By.xpath("//a[text()=\"Next\"]"));
//	        String enableOrNot = driver.findElement(By.xpath("//*[text()=\"Next\"]//parent::li")).getAttribute("aria-disabled");
//
//	        if (enableOrNot.equalsIgnoreCase("true")) {
//	            break;
//	        }
//
//	        // Navigate to the next page
//	        nextButton.click();
//	        Thread.sleep(2000); // Adding a short delay to allow the next page to load
//	    }
//	}


	
//	public static void main(String[] args) throws InterruptedException {
//		WebDriver driver= new ChromeDriver();
//		driver.get("http://43.205.119.116/login");
//		driver.manage().window().maximize();
//		
//		String Qty="22";
//		String UnitPrice="22";
//		String RejectMessage="No requirement now,planning in future";
//	
//	/*	// USER 2 LOGIN
//		User2Login u2=new User2Login(driver);
//		System.out.println("user 2 login");
//		u2.Login_User2("ramnee37@gmail.com", "123456789");
//	
//	
//		// APPROVE ASSET
//		ApproveAsset apas=new ApproveAsset(driver);
//		apas.AssetApproval(Qty,UnitPrice);
//		
//		//Logout for user 1 login
//		LogoutUser lal=new LogoutUser(driver);
//		lal.logout();
//*/		
//		//user 1 login for approval
//		User1Login u1=new User1Login(driver);
//		u1.Login_User1("settiprashanth@gmail.com", "123456789");
//		
//		// DELIVER THE PRODUCT
//		deliverTheProduct dtp=new deliverTheProduct(driver);
//		dtp.deliverTheAsset(Qty,UnitPrice);
//		Thread.sleep(2000);
//				
//}
}
