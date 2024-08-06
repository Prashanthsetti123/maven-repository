package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateeIFUPage extends BasePage{
	
	WebDriver driver;
	Robot rb=new Robot();
	
	public CreateeIFUPage(WebDriver driver) throws AWTException {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
//General Information

@FindBy(xpath="//*[@class=\"flex-1 pl-3 pr-0\"]//a[2]") WebElement createEIFU;
@FindBy(xpath="//input[@id='eifuName']") WebElement EIFUname;
@FindBy(xpath="//input[@id='eifuTitle']") WebElement EIFUTitle;
@FindBy(xpath="//input[@id='docCode']") WebElement EIFUdocumentCode;
@FindBy(xpath="//input[@id='subscriberVersion']") WebElement EIFUsubscriberVersion;
@FindBy(xpath="//select[@id='primaryIFU']") WebElement selectPrimaryIFUPrimaryEIFU;
@FindBy(xpath="//input[@id='releaseDate']") WebElement releaseDate;
@FindBy(xpath="//input[@id='projectLead']") WebElement projectLead;


//Audience / Hierarchy

@FindBy(xpath="//div[@name='targetAudience']//div[@class='ant-select-selection-overflow']") WebElement selectTargetAudience;
@FindBy(xpath="//select[@id='enterprise']") WebElement selectEnterpriseDD;
@FindBy(xpath="//div[@name='franchise']//div[@class='ant-select-selection-overflow']") WebElement selectFranchise;
@FindBy(xpath="//div[@name='productFamily']//div[@class='ant-select-selection-overflow']") WebElement productFamily;
@FindBy(xpath="//div[@name='productCategory']//div[@class='ant-select-selection-overflow']") WebElement productCategory;
@FindBy(xpath="//select[@id='documentSpecificFor']") WebElement selectDocumentSpecificFor;
@FindBy(xpath="//textarea[@id='keywordsStatements']") WebElement keywordsStatements;

//Region

@FindBy(xpath="//div[@name='region']//div[@class='ant-select-selection-overflow']") WebElement selectRegion;
@FindBy(xpath="//div[@class='ant-select w-full rounded-lg bg-[#F3F3F8] css-aj6r5i ant-select-multiple ant-select-show-arrow ant-select-open ant-select-show-search']//div[@class='ant-select-selection-overflow']") WebElement selectCountries;
@FindBy(xpath="//input[@id='strategyId0']") WebElement strategyID;
@FindBy(xpath="//div[@name='eifuLanguages']//div[@class='ant-select-selector']") WebElement selectEIFULaguageCovered;
@FindBy(xpath="//input[@id='plmChangeNumber']") WebElement PlmChangeNumber;
@FindBy(xpath="//input[@id='ecoNumber']") WebElement eCONumber;
@FindBy(xpath="//input[@name='ecoDate']") WebElement selectDate;

//Variants & Product Codes

@FindBy(xpath="//label[normalize-space()='Choose File']") WebElement chooseFile_CSV;

//Additional Detail

@FindBy(xpath="//input[@id='safetyFlag']") WebElement typeSafetyFlag;
@FindBy(xpath="//input[@id='gtinUdi']") WebElement gTINUDI;
@FindBy(xpath="//textarea[@id='publisherNotices']") WebElement publisherNotices;

//upload pdf file
@FindBy(xpath="//button[normalize-space()='Click to Upload']") WebElement clickToUpload;

//Supporting Documents
@FindBy(xpath="//span[@class='ant-btn-icon']//*[name()='svg']") WebElement Plus_icon;

@FindBy(xpath="//label[@for='filepicker_0']") WebElement Support_chooseFile;
@FindBy(xpath="//select[@id='docType']") WebElement doc_type;
@FindBy(xpath="//div[@class='flex flex-row space-x-2']//button[1]//span[1]//*[name()='svg']//*[name()='circle' and contains(@cx,'12')]") WebElement View_selectDoc;
@FindBy(xpath="//div[@id='root']//button[2]//span[1]//*[name()='svg']") WebElement Delete_selectType;
@FindBy(xpath="//button[normalize-space()='Draft']") WebElement draft;
@FindBy(xpath="//button[normalize-space()='Submit']") WebElement submit;

//Click on Create eIFU
public void CLick_createEIFU() {
	createEIFU.click();
}

//General information Actions

public void setEIFUname(String ename) {
	EIFUname.sendKeys(ename);

}

public void setEIFUTitle(String title) {
	EIFUTitle.sendKeys(title);

}

public void setEIFUdocumentCode(String documentCode) {
	EIFUdocumentCode.sendKeys(documentCode);

}

public void setEIFUsubscriberVersion(String subscriberVersion) {
	EIFUsubscriberVersion.sendKeys(subscriberVersion);

}

public void selectPrimaryIFUPrimaryEIFU(int indexNumber) {
	Select sc=new Select(selectPrimaryIFUPrimaryEIFU);
	sc.selectByIndex(indexNumber);
	

}

public void setreleaseDate(String reqDate) {
	releaseDate.sendKeys(reqDate);

}
public void setprojectLead(String Plead) {
	projectLead.sendKeys(Plead);
		
}

//Audience / Hierarchy Actions
public void selectTargetAudience() throws InterruptedException {
	selectTargetAudience.click();
	Thread.sleep(500);
	
//	selectTargetAudience.click();//need to check locator
	
}
public void selectEnterpriseDD(int indexNumber) {
	Select sc=new Select(selectEnterpriseDD);
	sc.selectByIndex(indexNumber);

}
public void selectFranchise() throws InterruptedException {
	selectFranchise.click();
	Thread.sleep(500);
	
}

public void selectproductFamily() throws InterruptedException {
	productFamily.click();
	Thread.sleep(500);
	
}

public void selectproductCategory() throws InterruptedException {
	productCategory.click();
	Thread.sleep(500);

	
}

public void selectDocumentSpecificFor(int indexNumber) {
	Select sc=new Select(selectDocumentSpecificFor);
	sc.selectByIndex(indexNumber);

}

public void setkeywordsStatements(String keywords) {
	keywordsStatements.sendKeys(keywords);

}

public void upload_pdf(String pdfDocPath) {
	clickToUpload.sendKeys(pdfDocPath);

}

//Region Actions

public void selectRegion() throws InterruptedException {
	selectRegion.click();
	Thread.sleep(500);
	
}

public void selectCountries() throws InterruptedException {
	selectCountries.click();
	Thread.sleep(1000);
	selectCountries.click();//need to change locator try sendkeys keys.return
	
}
//strategyID
public void setstrategyID(String statID) {
	strategyID.sendKeys(statID);

}

public void selectEIFULaguageCovered() throws InterruptedException {
	selectEIFULaguageCovered.click();
	Thread.sleep(1000);
	selectEIFULaguageCovered.click();//need to change locator try sendkeys keys.return
	
}

public void ClickPlus_icon() {
	Plus_icon.click();
}

public void upload_Support_chooseFile(String DocPath) {
	Support_chooseFile.sendKeys(DocPath);

}

public void select_doc_type(int indexNumber) {
	Select sc=new Select(doc_type);
	sc.selectByIndex(indexNumber);

}


public void Click_Submit() {
	submit.click();
}












//public String getConfirmationMsg() {
//	try {
//		return (msgConfirmation.getText());
//	} catch (Exception e) {
//		return (e.getMessage());
//
//	}
//}
}
