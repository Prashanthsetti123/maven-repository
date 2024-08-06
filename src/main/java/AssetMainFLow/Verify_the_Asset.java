package AssetMainFLow;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Verify_the_Asset {
    WebDriver driver;

    public Verify_the_Asset(WebDriver driver) {
        this.driver = driver;
    }

    public void VerifyTheStatus(String Quantity, String UnitPrice) throws InterruptedException {
        boolean elementFound = false;

        // Navigate to the Asset page
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//*[@class=\"ant-menu-title-content\"]//a[text()=\"Asset\"]")).click();

        Actions act = new Actions(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        do {
            List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
            for (int i = 2; i < rows.size(); i++) { // Start from 2 assuming the first row is a header
                String reqQTY = driver.findElement(By.xpath("//table//tr[" + i + "]//td[2]")).getText();
                String reqPrice = driver.findElement(By.xpath("//table//tr[" + i + "]//td[3]")).getText();

                if (Quantity.equalsIgnoreCase(reqQTY) && UnitPrice.equalsIgnoreCase(reqPrice)) {
//                    System.out.println("Retrieved data from the table: " + reqQTY + "::" + reqPrice);
                    Thread.sleep(2000);
                    WebElement Status = driver.findElement(By.xpath("//table//tr[" + i + "]//td[11]"));

                    String statusText = Status.getText();
                    System.out.println("The Asset status is: " + statusText);

                    // Highlight row based on status
                    WebElement rowToHighlight = driver.findElement(By.xpath("//table//tr[" + i + "]"));
                    if (statusText.equalsIgnoreCase("Approved")) {
                        jsExecutor.executeScript("arguments[0].style.backgroundColor='yellow'", rowToHighlight);
                        System.out.println("The Asset is Approved and highlighted in yellow.");
                        elementFound = true;
                    } else if (statusText.equalsIgnoreCase("Pending")) {
                        jsExecutor.executeScript("arguments[0].style.backgroundColor='orange'", rowToHighlight);
                        System.out.println("The Asset is Pending and highlighted in orange.");
                        elementFound = true;
                    }

                    // Break if an asset with the status is found and highlighted
                    if (elementFound) {
                        break;
                    }
                }
            }

            if (elementFound) {
                break;
            }

            // Check if the "Next" button is disabled
            String enableOrNot = driver.findElement(By.xpath("//*[text()=\"Next\"]//parent::li")).getAttribute("aria-disabled");
//            System.out.println("The next button is disabled: " + enableOrNot);

            if (enableOrNot.equalsIgnoreCase("true")) {
//                System.out.println("No more pages to navigate. Element not found.");
                break;
            }

            // Navigate to the next page
//            System.out.println("Navigating to the next page");
            WebElement nextButton = driver.findElement(By.xpath("//a[text()=\"Next\"]"));
            nextButton.click();
            Thread.sleep(2000); 
        } while (true);

          if (!elementFound) {
            System.out.println("The specified element was not found on any page.");
        }
    
    }
    
    
    
    public void AssetStatusForDelivery(String Quantity, String UnitPrice) throws InterruptedException {
        boolean elementFound = false;

        // Navigate to the Asset page
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//*[@class=\"ant-menu-title-content\"]//a[text()=\"Asset\"]")).click();

        Actions act = new Actions(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        do {
            List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
            for (int i = 2; i < rows.size(); i++) { // Start from 2 assuming the first row is a header
                String reqQTY = driver.findElement(By.xpath("//table//tr[" + i + "]//td[2]")).getText();
                String reqPrice = driver.findElement(By.xpath("//table//tr[" + i + "]//td[3]")).getText();

                if (Quantity.equalsIgnoreCase(reqQTY) && UnitPrice.equalsIgnoreCase(reqPrice)) {
//                    System.out.println("Retrieved data from the table: " + reqQTY + "::" + reqPrice);
                    Thread.sleep(2000);
                    WebElement Status = driver.findElement(By.xpath("//table//tr[" + i + "]//td[11]"));

                    String statusText = Status.getText();
                    System.out.println("The Asset status is: " + statusText);

                    // Highlight row based on status
                    WebElement rowToHighlight = driver.findElement(By.xpath("//table//tr[" + i + "]"));
                    if (statusText.equalsIgnoreCase("Approved")) {
                        jsExecutor.executeScript("arguments[0].style.backgroundColor='green'", rowToHighlight);
                        System.out.println("The Asset is Approved and highlighted in green.");
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("alert('The Asset is ready for Deliver...!');");
                        Thread.sleep(1000);
                        driver.switchTo().alert().accept();
                        elementFound = true;
                    } else if (statusText.equalsIgnoreCase("Pending")) {
                        jsExecutor.executeScript("arguments[0].style.backgroundColor='orange'", rowToHighlight);
                        System.out.println("The Asset is Pending and highlighted in orange.");
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("alert('The Asset Status is still in pending...!');");
                        
                        elementFound = true;
                    }

                    // Break if an asset with the status is found and highlighted
                    if (elementFound) {
                        break;
                    }
                }
            }

            if (elementFound) {
                break;
            }

            // Check if the "Next" button is disabled
            String enableOrNot = driver.findElement(By.xpath("//*[text()=\"Next\"]//parent::li")).getAttribute("aria-disabled");
//            System.out.println("The next button is disabled: " + enableOrNot);

            if (enableOrNot.equalsIgnoreCase("true")) {
//                System.out.println("No more pages to navigate. Element not found.");
                break;
            }

            // Navigate to the next page
//            System.out.println("Navigating to the next page");
            WebElement nextButton = driver.findElement(By.xpath("//a[text()=\"Next\"]"));
            nextButton.click();
            Thread.sleep(2000); 
        } while (true);

          if (!elementFound) {
            System.out.println("The specified element was not found on any page.");
        }
    
    }


//	public static void main(String[] args) throws InterruptedException {
//		WebDriver driver= new ChromeDriver();
//		driver.get("http://43.205.119.116/login");
//		driver.manage().window().maximize();
//		
//		String Qty="106";
//		String UnitPrice="106000";
//		String RejectMessage="No requirement now,planning in future";
//		
//		// USER 1 LOGIN
//		
//		User1Login u1=new User1Login(driver);
//		System.out.println("user 1 login");
//		u1.Login_User1("settiprashanth@gmail.com", "123456789");
//			
//		Verify_the_Asset va=new Verify_the_Asset(driver);
//		va.VerifyTheStatus(Qty, UnitPrice);
//	}
}
