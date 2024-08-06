package AssetMainFLow;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAsset {
	WebDriver driver;
	
	public CreateAsset(WebDriver driver) {
		this.driver=driver;
	}
	
	public void NewAsset(String QTY,String UnitPrice,String pdfFilePath  ) throws InterruptedException {
				//Asset type
				Actions act=new Actions(driver);
				Thread.sleep(1000);
				try {
				    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
					Thread.sleep(2000);
					WebElement assetType=driver.findElement(By.xpath("//input[@id=\"assetType\"]"));
					act.moveToElement(assetType).click().perform();
					Thread.sleep(500);
				} catch (NoSuchElementException e) {
				    // Handle NoSuchElementException, for example:
				    System.out.println("Element not found: " + e.getMessage());
				}
				
				// Select the type of Asset
				WebElement Type=driver.findElement(By.xpath("//*[text()=\"Laptop\"]"));
				act.moveToElement(Type).click().perform();
				
				//Quantity
				driver.findElement(By.xpath("//*[@id=\"Quantity\"]")).sendKeys(QTY);
				Thread.sleep(1000);
				
				//Unit Price
				driver.findElement(By.xpath("//*[@id=\"unitPrice\"]")).sendKeys(UnitPrice);
				Thread.sleep(1000);
				
				//upload pdf
				driver.findElement(By.xpath("//*[@type=\"file\"]")).sendKeys(pdfFilePath);
				Thread.sleep(1000);

				//submit
				driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
				Thread.sleep(1000);
				
				System.out.println("Asset request created successfully");
			}
	

//	//public static void main(String[] args) throws InterruptedException {
//		WebDriver driver= new ChromeDriver();
//		driver.get("http://43.205.119.116/login");
//		driver.manage().window().maximize();
//		
//		String Qty="4";
//		String UnitPrice="44000";
//		String RejectMessage="No requirement now,planning in future";
//		
//		// USER 1 LOGIN
//		User1Login u1=new User1Login(driver);
//		System.out.println("user 1 login");
//		u1.Login_User1("settiprashanth@gmail.com", "123456789");
//		
//
//		// CREATE NEW ASSET
//		CreateAsset ca=new CreateAsset(driver);
//		ca.NewAsset(Qty, UnitPrice, "C:\\Users\\tai-0\\Downloads\\dummy.pdf");
//		
//		// USER LOGOUT
//		LogoutUser lal=new LogoutUser(driver);
//		lal.logout();
//	
//	}
}


