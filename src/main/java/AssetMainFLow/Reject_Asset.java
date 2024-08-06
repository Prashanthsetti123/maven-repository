package AssetMainFLow;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AssetMainFLow.User2Login;

public class Reject_Asset {

	WebDriver driver;

	public Reject_Asset(WebDriver driver) {
		this.driver = driver;
	}

	public void RejectAsset(String Quantity, String UnitPrice,String Remark_Message) throws InterruptedException {

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

			for (int i = 1; i < No_of_Assets; i++) {
				String reqQTY = driver.findElement(By.xpath("//*[@class=\"ant-table-content\"]//table//tr[" + i + "]//td[2]")).getText();
				String reqPrice = driver.findElement(By.xpath("//*[@class=\"ant-table-content\"]//table//tr[" + i + "]//td[3]")).getText();
				System.out.println("Retrieved data from the table: " + reqQTY + "::" + reqPrice);

				if (Quantity.equalsIgnoreCase(reqQTY) && UnitPrice.equalsIgnoreCase(reqPrice)) {
					Thread.sleep(2000);
					WebElement Approved_button1 = driver.findElement(By.xpath("//*[@class=\"ant-table-content\"]//table//tr[" + i+ "]//td[11]//button//span[text()='R']"));
					act.moveToElement(Approved_button1).click().perform();
					//remark text box
					WebElement RemarksTextBox= driver.findElement(By.xpath("//*[@placeholder=\"Enter remarks\"]"));
					RemarksTextBox.sendKeys(Remark_Message);
					WebElement ok_buttonInPOP_Up = driver.findElement(By.xpath("//*[@class=\"ant-modal-footer\"]//button[2]"));
					Thread.sleep(2000);
					act.moveToElement(ok_buttonInPOP_Up).click().perform();
					Thread.sleep(1000);
					elementFound = true;
					System.out.println(" Asset Rejected ");
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
			System.out.println("the next button is disabled::" + enableornot);

			if (enableornot.equalsIgnoreCase("true")) {
				System.out.println("No more pages to navigate. Element not found.");
				elementFound = true;
				break;
			}

			System.out.println("Navigating to the next page");
			NextButton.click();

		}
	}
//public static void main(String[] args) throws InterruptedException, AWTException {
//	WebDriver driver= new ChromeDriver();
//	driver.get("http://65.1.131.175/login");
//	driver.manage().window().maximize();
//	
//	String Qty="9";
//	String UnitPrice="1";
//	String RemarkMessage="Not necessary now";
//	String ModifyQTY="11";
//	String Modify_UnitPrice="100000";
//	String ModifyRemarks="need to be change qty to 11 from";
//	
//	// USER 2 LOGIN
//	User2Login u2 = new User2Login(driver);
//	System.out.println("user 2 login");
//	u2.Login_User2("meenakumarimaligeli@gmail.com", "user2@1234");
//	System.out.println("user 2 successfully logout");
	
	//rejection Asset
//	Reject_Asset ra=new Reject_Asset(driver);
//	ra.AssetApproval(Qty, UnitPrice, RemarkMessage);
	
	// Modify Asset
//	ModifyAsset ma=new ModifyAsset(driver);
//	ma.modify(Qty, UnitPrice, ModifyQTY, Modify_UnitPrice, ModifyRemarks);
//
//	//practice Modify
//	Practmodify pmf=new Practmodify(driver);
//	pmf.modify(Qty, UnitPrice, ModifyQTY, Modify_UnitPrice, ModifyQTY);

//}
}
