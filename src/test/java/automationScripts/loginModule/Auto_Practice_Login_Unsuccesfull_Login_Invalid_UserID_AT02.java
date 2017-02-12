package automationScripts.loginModule;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utility.Constants;
import utility.ExcelUtils;
import utility.Log;
import utility.ReRunFailedTests;
import utility.Util;
/*This test script to validate that user cannot login to the application successfully when incorrect user ID is entered. */
public class Auto_Practice_Login_Unsuccesfull_Login_Invalid_UserID_AT02 {
	
	private static WebDriver driver=null;
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
	@Test(retryAnalyzer=ReRunFailedTests.class, description="User cannot login to application with incorrect userID")
	public static void execute()
	{
	try {
		  driver=baseClass.getDriver();
		  HomePage.signIn_btn(driver).click();
		  Log.info("Homepage SignIn button clicked");
		  ExcelUtils.setExcelFile(Constants.file_path+Constants.file_name, "UserCredentials");
		  String invalidID=ExcelUtils.getCellData(1, 2);
		  System.out.println("Invalid id:"+ invalidID);
		  String validPW=ExcelUtils.getCellData(1, 1);
		  LoginPage.signIntoAccount(driver, invalidID, validPW);
		  String error1=LoginPage.authentication_error1(driver).getText();
		  System.out.println("Authentication error1:"+ error1);
		  Assert.assertEquals(error1, "There is 1 error");
		  Assert.assertTrue(error1, true);
		  Log.info("Error 1 compared");
		  String error2=LoginPage.authentication_error2(driver).getText();
		  System.out.println("Authentication error2:"+ error2);
		  Assert.assertEquals(error2, "Authentication failed.");
		  Log.info("Error 2 compared");
		} 
	    catch (Exception e) 
	    {
	    	Util.takeScreenShot(driver, Thread.currentThread().getStackTrace()[1].getClassName());
	    	e.printStackTrace();
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
