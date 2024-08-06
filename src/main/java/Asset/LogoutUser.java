package Asset;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutUser {
	
	WebDriver driver;
    public  LogoutUser(WebDriver driver) {
    	this.driver=driver;
    }
    public void logout() {
        try {

           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Logout button
            WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']//div/div/li[2]")));
            logoutButton.click();
            Thread.sleep(1000); // Adding sleep to wait for the logout confirmation dialog to appear

            // OK button of the logout confirmation window
            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button']//span[text()='Ok']")));
            okButton.click();


        } catch (Exception e) {
            // Print the exception for debugging
            System.out.println("Exception encountered: " + e.getMessage());
        }
    }
}
