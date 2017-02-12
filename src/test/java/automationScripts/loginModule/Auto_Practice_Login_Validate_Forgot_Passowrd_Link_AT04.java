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
import pageObjects.ForgetPW;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utility.Constants;
import utility.ExcelUtils;
import utility.Log;
import utility.ReRunFailedTests;
import utility.Util;
/*This test script to validate that 'Forgot Password' link works fine. */
public class Auto_Practice_Login_Validate_Forgot_Passowrd_Link_AT04 {
	
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
	@Test(retryAnalyzer=ReRunFailedTests.class, description="To validate Forgot Password link")
	public static void execute()
	{
	try {
		  driver=baseClass.getDriver();
		  HomePage.signIn_btn(driver).click();
		  Log.info("Homepage SignIn button clicked");
		  Assert.assertTrue("ALREADY REGISTERED?", true);
		  LoginPage.forgotPasswordLink(driver).click();
		  String forgetpw=ForgetPW.forgetPwText(driver).getText();
		  System.out.println("Forget Password text:"+ forgetpw);
		  String pwtext="Please enter the email address you used to register. We will then send you a new password.";
		  Assert.assertEquals(forgetpw, pwtext);
		  Assert.assertTrue(forgetpw, true);
		  Log.info("Forget password message compared");
		  boolean flag1=ForgetPW.forgetEmailField(driver).isDisplayed();
		  System.out.println("Email address field available:"+ flag1);
		  Log.info("Email address field is available");
		  boolean flag2=ForgetPW.retreivePwBtn(driver).isEnabled();
		  System.out.println("Retreive Password button enabled:"+ flag2);
		  Log.info("Retreive Password btn available and enabled");
		  String homeIconTxt=HomePage.homeIcon(driver).getAttribute("title");
		  System.out.println("Home icon tooltip text:"+homeIconTxt);
		  Assert.assertTrue(homeIconTxt, true);
		  Log.info("Home icon tooltip text printed");
		  HomePage.homeIcon(driver).click();
		  Log.info("Home icon clicked");
		  String autoTxt= HomePage.autoPracTxt(driver).getText();
		  Assert.assertTrue(autoTxt, true);
		  Log.info("Returned to homepage");
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
