package AssetMainFLow;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AssetMainFLow.CreateAsset;
import AssetMainFLow.LogoutUser;
import AssetMainFLow.User1Login;
import AssetMainFLow.User2Login;

public class ApproveAsset {
	WebDriver driver;

	public ApproveAsset(WebDriver driver) {
		this.driver = driver;
	}

	public void AssetApproval(String Quantity, String UnitPrice) throws InterruptedException {

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
//			System.out.println("The total size: " + No_of_Assets);

			for (int i = 1; i < No_of_Assets; i++) {
				String reqQTY = driver
						.findElement(By.xpath("//*[@class=\"ant-table-content\"]//table//tr[" + i + "]//td[2]"))
						.getText();
				String reqPrice = driver
						.findElement(By.xpath("//*[@class=\"ant-table-content\"]//table//tr[" + i + "]//td[3]"))
						.getText();
//				System.out.println("Retrieved data from the table: " + reqQTY + "::" + reqPrice);

				if (Quantity.equalsIgnoreCase(reqQTY) && UnitPrice.equalsIgnoreCase(reqPrice)) {
					Thread.sleep(2000);
					WebElement Approved_button1 = driver
							.findElement(By.xpath("//*[@class=\"ant-table-content\"]//table//tr[" + i
									+ "]//td[11]//button//span[text()='A']"));
					act.moveToElement(Approved_button1).click().perform();
					WebElement ok_buttonInPOP_Up = driver
							.findElement(By.xpath("//*[@class=\"ant-modal-footer\"]//button[2]"));
					Thread.sleep(2000);
					act.moveToElement(ok_buttonInPOP_Up).click().perform();
					Thread.sleep(1000);
					elementFound = true;
					System.out.println("Approved successfully");
					break;
				}
			}

			if (elementFound) {
				break;
			}

			WebElement NextButton = driver.findElement(By.xpath("//a[text()=\"Next\"]"));

			// checking condition with attribute of next button
			String enableornot = driver.findElement(By.xpath("//*[text()=\"Next\"]//parent::li"))
					.getAttribute("aria-disabled");
//			System.out.println("the next button is disabled::" + enableornot);

			if (enableornot.equalsIgnoreCase("true")) {
//				System.out.println("No more pages to navigate. Element not found.");
				elementFound = true;
				break;
			}

//			System.out.println("Navigating to the next page");
			NextButton.click();

		}
	}

//	public static void main(String[] args) throws InterruptedException, AWTException {
//		WebDriver driver= new ChromeDriver();
//		driver.get("http://65.1.131.175/login");
//		driver.manage().window().maximize();
//		
//		String Qty="103";
//		String UnitPrice="103000";
//		String ModifyQTY="103";
//		String Modify_UnitPrice="103000";
//		String ModifyRemarks="need to be change qty to "+ModifyQTY+"from"+Qty;
		
		// USER 2 LOGIN
//		User2Login u2 = new User2Login(driver);
//		System.out.println("user 2 login");
//		u2.Login_User2("ramnee37@gmail.com", "123456789");
//		
//		//practice Modify
//		ModifyAsset pmf=new ModifyAsset(driver);
//		pmf.modify(Qty, UnitPrice, ModifyQTY, Modify_UnitPrice, ModifyRemarks);

//
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://65.1.131.175/login");
//		driver.manage().window().maximize();
//
//		String Qty = "107";
//		String UnitPrice = "107000";
		// USER 1 LOGIN
//		User1Login u1 = new User1Login(driver);
//		System.out.println("user 1 login");
//		u1.Login_User1("shaikdadavali092@gmail.com", "user1@1234");
//
//		// CREATE NEW ASSET
//		CreateAsset ca = new CreateAsset(driver);
//		ca.NewAsset(Qty, UnitPrice, "C:\\Users\\tai-0\\Downloads\\dummy.pdf");
////
//		// user2 login
//		User2Login u2 = new User2Login(driver);
//		System.out.println("user 2 login");
//		u2.Login_User2("meenakumarimaligeli@gmail.com", "user2@1234");
//
//		// approve
//		ApproveAsset ap = new ApproveAsset(driver);
//		ap.AssetApproval(Qty, UnitPrice);
//
//		// logout
//		LogoutUser lu = new LogoutUser(driver);
//		lu.logout();
//
//
//		u1.Login_User1("settiprashanth@gmail.com", "123456789");
//		User1Login u1=new User1Login(driver);
//		System.out.println("user 1 login");
//		u1.Login_User1("settiprashanth@gmail.com", "123456789");
//
//		// deliver the product
//		deliverTheProduct dtp = new deliverTheProduct(driver);
//		dtp.deliverTheAsset(Qty, UnitPrice);
//		dtp.VerifyTheStatus(Qty, UnitPrice);
	
	
//
//	}
}
