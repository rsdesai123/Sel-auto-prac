package automationScripts.homepage;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.HomePage;
import utility.Constants;
import utility.Log;
import utility.ReRunFailedTests;
import utility.Util;
/*This test case is to verify the error message displayed when clicked on Newsletter button without entering an email address.*/
public class Auto_Practice_Homepage_Verify_Newsletter_Error_Message_AT03 {
	public static WebDriver driver;
	private static BaseClass baseClass=new BaseClass(driver);
	@Parameters("browser")
	@BeforeMethod
	public static void setUp(String browser)
	{
		try
		{
		baseClass.setBrowser(browser, Constants.url);
		Log.info("Application is launched");
		}
		catch(Exception ex)
		  { 
			  Util.takeScreenShot(driver, Thread.currentThread().getStackTrace()[1].getClassName());
			  System.out.println(ex.getMessage());
		  }
	}
	@Test(retryAnalyzer=ReRunFailedTests.class, description="Verifying Newsletter link error message")
	public static void execute()
	{
	  try
	  {

          driver=baseClass.getDriver();
		  HomePage.BottomPage.newsLetterSubmitBtn(driver).click();
		  Log.info("News Letter submission button clicked");
		  String expectedTxt="Newsletter : Invalid email address.";
		  Assert.assertEquals(expectedTxt, HomePage.BottomPage.newsLetterErrorMsg(driver).getText().trim());
		  Log.info("Newsletter submission Error message verified");
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
