package automationScripts.homepage;
/*This test case is to validate the process of sending the information with attachment to the customer service.*/
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import pageObjects.BaseClass;
import pageObjects.ContactUsPage;
import pageObjects.HomePage;
import utility.Constants;
import utility.Log;
import utility.ReRunFailedTests;
import utility.Util;

public class Auto_Practice_Homepage_ContactUs_Send_Details_AT02 {
public static WebDriver driver;
private static BaseClass baseClass=new BaseClass(driver);
@Parameters("browser2")
@BeforeMethod
public static void setUp(@Optional("firefox") String browser2)
{
	try
	{
	baseClass.setBrowser(browser2, Constants.url);
	Log.info("Application is launched");
	}
	catch(Exception ex)
	  { 
		  Util.takeScreenShot(driver, Thread.currentThread().getStackTrace()[1].getClassName());
		  System.out.println(ex.getMessage());
	  }
}
  @Test(retryAnalyzer=ReRunFailedTests.class, description="Send contact details")
  public static void execute() 
  {
	  try
	  {
      driver=baseClass.getDriver();
	  HomePage.contactUs(driver).click();
	  Log.info("Contact Us link on hompeage is clicked");
	  Assert.assertEquals(ContactUsPage.dropboxTxt(driver).getText().trim(),"Subject Heading");
	  List<WebElement> ddOptions=Util.SelectFuns.selectDropDownValue(driver, ContactUsPage.dropbox(driver)).getOptions();
	  for(WebElement opts:ddOptions)
	  {
		  System.out.println("Drop down option - "+opts.getText());		  
	  }
	  Log.info("Subject Heading dropdown options are printed");
	  Util.SelectFuns.selectByValue(driver, ContactUsPage.dropbox(driver), "2");  
	  Log.info("'Customer service' option selected from the dropdown");
	  ContactUsPage.emailAddrsField(driver).clear();
	  ContactUsPage.emailAddrsField(driver).sendKeys(Constants.userID);
	  Log.info("Email address enetered");
	  ContactUsPage.orderRefField(driver).clear();
	  ContactUsPage.orderRefField(driver).sendKeys("12345");
	  Log.info("Order reference entered");
	  ContactUsPage.fileUploadBtn(driver).click();
	  Thread.sleep(2000);
	  Log.info("File upload button clicked");
	  //Util.autoFileUpload(driver, "C:\\Users\\Sony\\Documents\\AutoPrac.exe");
	  Runtime.getRuntime().exec("C:\\Users\\Sony\\Documents\\AutoPrac.exe");
	  Log.info("File uploaded successfully");
	  ContactUsPage.messageField(driver).clear();
	  ContactUsPage.messageField(driver).sendKeys("Please exchange the product");
	  Log.info("Text entered into Message box");
	  String fileName=ContactUsPage.nameOfFileUploaded(driver).getAttribute("textContent");
	  System.out.println("File selected for upload:"+ fileName);
	  Thread.sleep(20);
	  ContactUsPage.saveBtn(driver).click();
	  Log.info("Save button clicked");
	  String expMsg="Your message has been successfully sent to our team.";
	  Assert.assertEquals(ContactUsPage.messgSaveTxt(driver).getText().trim(), expMsg);
	  Log.info("Successfully sent message text verified");
	  ContactUsPage.homeBtn(driver).click();
	  Log.info("Home button clicked");
	  Assert.assertTrue(true, HomePage.autoPracTxt(driver).getText());
	  }
	  catch(Exception ex)
	  {
		  Util.takeScreenShot(driver, Thread.currentThread().getStackTrace()[1].getClassName());
		  System.out.println(ex.getMessage());
	  }
  }
  @AfterMethod
  public static void tearDown() 
  {
	  try
	  {
	  baseClass.closeBrowser();
	  }
	  catch(Exception ex)
	  { 
		  Util.takeScreenShot(driver, Thread.currentThread().getStackTrace()[1].getClassName());
		  System.out.println(ex.getMessage());
	  }
  }

}
