package automationScripts.homepage;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class Auto_Practice_Homepage_Verify_Terms_And_Conditions_AT04 {
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
	@SuppressWarnings("deprecation")
	@Test(retryAnalyzer=ReRunFailedTests.class, description="Verifying Terms and conditions of using the website")
	public static void execute()
	{
	  try
	  {
		  driver=baseClass.getDriver();
		  HomePage.BottomPage.termsAndConditionLink(driver).click();
		  Log.info("Terms and Conditions link clicked");
		  String expectedTxt="TERMS AND CONDITIONS OF USE";
		  Assert.assertEquals(expectedTxt, HomePage.Terms_Conditions.pageHeaderTxt(driver).getText().trim());
		  Log.info("Terms and conditions page header message verified");
		  String rule="Use this website for all our practices of automation scripts.";
		  Assert.assertEquals(HomePage.Terms_Conditions.pageRule1Txt(driver).getText().contains(rule), true);
		  Log.info("Terms and conditions rule1 message verified");
		  rule="Please try not spamming on this website.";
		  Assert.assertEquals(HomePage.Terms_Conditions.pageRule2Txt(driver).getText().contains(rule), true);
		  Log.info("Terms and conditions rule2 message verified");
		  rule="Your feedback is the most critical piece of advice that we would appreciate.";
		  Assert.assertEquals(HomePage.Terms_Conditions.pageRule3Txt(driver).getText().contains(rule), true);
		  Log.info("Terms and conditions rule3 message verified");
		  HomePage.homeIcon(driver).click();
		  Log.info("Home icon clicked");
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
