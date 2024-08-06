package AssetMainFLow;


	import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

import AssetMainFLow.User2Login;

	public class ModifyAsset {
		  WebDriver driver;
		
		  public ModifyAsset(WebDriver driver) {
			  this.driver=driver;
		  }

		public void modify(String Quantity,String UnitPrice,String ModifyQTY,String ModifyUnitPrice,String ModifyMessage) throws InterruptedException, AWTException {
				  
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement inboxElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/inboxpage']")));
				inboxElement.click();
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Exception encountered: " + e.getMessage());
			}
			
			Boolean elementFound = false;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			Actions act = new Actions(driver);
			
			while (!elementFound) {
			    // Handling table
			    List<WebElement> AssetsList = driver.findElements(By.xpath("//*[@class=\"ant-table-content\"]//table//tr"));
			    int No_of_Assets = AssetsList.size();
			    System.out.println("The total size: " + No_of_Assets);

			    for (int i = 1; i <= No_of_Assets; i++) {
			    	String reqQTY = driver
							.findElement(By.xpath("//*[@class=\"ant-table-content\"]//table//tr[" + i + "]//td[2]"))
							.getText();
					String reqPrice = driver
							.findElement(By.xpath("//*[@class=\"ant-table-content\"]//table//tr[" + i + "]//td[3]"))
							.getText();
					System.out.println("Retrieved data from the table: " + reqQTY + "::" + reqPrice);

					if (Quantity.equalsIgnoreCase(reqQTY) && UnitPrice.equalsIgnoreCase(reqPrice)) {
						Thread.sleep(2000);
						WebElement Modify_button = driver.findElement(By.xpath("//*[@class=\"ant-table-content\"]//table//tr[" + i+ "]//td[11]//button//span[text()='M']"));
						act.moveToElement(Modify_button).click().perform();
						
						// MOdify Quantity
						WebElement ModifyQty=driver.findElement(By.xpath("//*[@id=\"Quantity\"]"));
		             	Thread.sleep(500);
		             	ModifyQty.sendKeys(Keys.CONTROL + "a");
		             	ModifyQty.sendKeys(Keys.DELETE);
		             	Thread.sleep(500);
		             	ModifyQty.sendKeys(ModifyQTY);
		             	
		             	Thread.sleep(2000);
		             	
		             	
		             	//Modify Unit Price
		             	WebElement MUnitPrice= driver.findElement(By.id("unitPrice"));
//		             	
		             	String unitpricetext=MUnitPrice.getAttribute("id");
		             	int Lengthofthechars=unitpricetext.length();
		             	
		             	for (int i1 = 0; i1 < Lengthofthechars; i1++) {
		             		MUnitPrice.sendKeys(Keys.BACK_SPACE); 
		             		}
		             	Thread.sleep(500);
		             	MUnitPrice.sendKeys(ModifyUnitPrice);
//		             	
		             	//Modify Remarks
		             	WebElement ModifyRemarks=driver.findElement(By.xpath("//*[@id=\"remarks\"]"));
		             	ModifyRemarks.sendKeys(Keys.CONTROL + "a");
		             	ModifyRemarks.sendKeys(Keys.DELETE);
		             	Thread.sleep(500);
		             	
		             	ModifyRemarks.sendKeys(ModifyMessage);
		             	
		             	//Submit Button
		             	WebElement SubmitButton=driver.findElement(By.xpath("//*[@type=\"submit\"]//span"));
		             	SubmitButton.click();
		             	
		             	System.out.println("Modified successfully");
						elementFound = true;
						break;
					}
				}

				if (elementFound) {
					break;
				}
			    

			    // Checking if the "Next" button is disabled
			    String enableornot = driver.findElement(By.xpath("//*[text()=\"Next\"]//parent::li")).getAttribute("aria-disabled");
			    System.out.println("the next button is disabled: " + enableornot);

			    if (enableornot.equalsIgnoreCase("true")) {
			        System.out.println("No more pages to navigate. Element not found.");
			        break; // No need to continue searching if the "Next" button is disabled
			    }

			    // Clicking on the "Next" button to navigate to the next page
			    WebElement NextButton = driver.findElement(By.xpath("//a[text()=\"Next\"]"));
			    NextButton.click();
			}
			

	}

		public static void main(String[] args) throws InterruptedException, AWTException {
			WebDriver driver= new EdgeDriver();
			driver.get("http://35.154.145.139/login");
			driver.manage().window().maximize();
			
			String Qty="5";
			String UnitPrice="55000";
			String ModifyQTY="6";
			String Modify_UnitPrice="66000";
			String ModifyRemarks=" Need to change the Quantity from " + Qty+" to " +  ModifyQTY;
			
			// USER 2 LOGIN
			User2Login u2 = new User2Login(driver);
			System.out.println("user 2 login");
			u2.Login_User2("ramnee37@gmail.com", "123456789");
			
			//practice Modify
			ModifyAsset pmf=new ModifyAsset(driver);
			pmf.modify(Qty, UnitPrice, ModifyQTY, Modify_UnitPrice, ModifyRemarks);

		}
}
