package AssetMainFLow;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot_class {
	WebDriver driver;
	String filePath;
	public  Screenshot_class(WebDriver driver) {
		this.driver = driver;
	}
	
	public void takeScreenshot(String FilePath) throws IOException {
		this.filePath=FilePath;
		TakesScreenshot scrShot =(TakesScreenshot) driver;
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(filePath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
}
