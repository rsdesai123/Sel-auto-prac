package automationScripts.myAccount;

import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

/*This test case is to validate the different options/buttons available under My account section.*/
public class Auto_Practice_MyAccounts_Check_Options_AT01 {
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
	@Test(retryAnalyzer=ReRunFailedTests.class, description="To check options present under User account")
	public static void execute()
	{
		try
		{
		driver=baseClass.getDriver();
		HomePage.signIn_btn(driver).click();
		Log.info("Homepage SignIn link clicked");
		ExcelUtils.setExcelFile(Constants.file_path+Constants.file_name, Constants.sheet_name1);
		String suserID=ExcelUtils.getCellData(1, 0);
		String spassWd=ExcelUtils.getCellData(1, 1);
		LoginPage.signIntoAccount(driver, suserID, spassWd);
		Log.info("User logged into the account");
		String exp_acc_info="Welcome to your account. Here you can manage all of your personal information and orders.";
		String account_info=MyAccountPage.myAccountInfo(driver).getText();
		Assert.assertEquals(exp_acc_info, account_info);
		Log.info("Account user welcome text verified");
		List<WebElement> myOptions=MyAccountPage.myAccountOptions(driver);
		for(WebElement btn:myOptions)
		{
			String expectedOpt=btn.getText();
			System.out.println(expectedOpt);
			switch(expectedOpt)
			{
				case "ORDER HISTORY AND DETAILS":
					System.out.println("Order button is present");
					break;
				case "MY CREDIT SLIPS":
					System.out.println("Credit button is present");
					break;
				case "MY ADDRESS":
					System.out.println("Address button is present");
					break;
				case "MY PERSONAL INFORMATION":
					System.out.println("Personal info button is present");
					break;
				case "MY WISHLISTS":
					System.out.println("Wishlist button is present");
					break;
					default:
						System.out.println("Button is not present");
			}
			System.out.println("Button is:"+ expectedOpt);
		}
		}
		catch(Exception e)
		{
			Util.takeScreenShot(driver, Thread.currentThread().getStackTrace()[1].getClassName());
			System.out.println(e.getMessage());
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
