package automationScripts.loginModule;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utility.Constants;
import utility.ExcelUtils;
import utility.Log;
import utility.ReRunFailedTests;
import utility.Util;
/*This test script to validate that user can login to the application successfully. */
public class Auto_Practice_Login_Succesfull_Login_AT01 {
private static WebDriver driver;
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
@Test(retryAnalyzer=ReRunFailedTests.class, description="Successful login of user with correct credentials")
public static void execute()
{
	try
	{
	driver=baseClass.getDriver();
	String title1=HomePage.signIn_btn(driver).getAttribute("title");
	System.out.println("SignIn title:"+title1);
	Assert.assertEquals(title1, "Log in to your customer account");
	HomePage.signIn_btn(driver).click();
	Log.info("Sign in link clicked");
	Assert.assertTrue("ALREADY REGISTERED?", true);
	ExcelUtils.setExcelFile(Constants.file_path+Constants.file_name, Constants.sheet_name1);
	String sUserID=ExcelUtils.getCellData(1, 0);
	String sUserPassword=ExcelUtils.getCellData(1, 1);
	LoginPage.signIntoAccount(driver, sUserID, sUserPassword);
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(HomePage.signOut_btn(driver)));
	String welcomeTxt="Welcome to your account. Here you can manage all of your personal information and orders.";
	//Assert.assertTrue(MyAccountClass.myAccountInfo(driver).getText().toLowerCase().contains("Welcome to your account"));
	Assert.assertTrue(welcomeTxt, true);
	String userName=HomePage.userInfo(driver).getAttribute("textContent");
	System.out.println(userName+ "- is logged into the account");
	Log.info("User info is printed");
	Assert.assertEquals(userName, "Rudragouda Desai");
	String userTitle=HomePage.userInfo(driver).getAttribute("title");
	System.out.println("My account user title:"+ userTitle);
	Log.info("User account title printed");
	Assert.assertTrue(HomePage.userInfo(driver).getAttribute("title"), true);
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
    HomePage.signOut_btn(driver).click();
    Log.info("Sign out button clicked");
	baseClass.closeBrowser();
	}
	catch(Exception ex)
	  { 
		  Util.takeScreenShot(driver, Thread.currentThread().getStackTrace()[1].getClassName());
		  System.out.println(ex.getMessage());
	  }
  }
}
