package automationScripts.myAccount;

import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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

/*This test case is to validate that user's personal information available under My account section can be updated successfully.*/
public class Auto_Practice_MyAccounts_Check_My_Personal_Information_AT02 {
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
	@SuppressWarnings("deprecation")
	@Test(retryAnalyzer=ReRunFailedTests.class, description="To check User's personal information details")
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
		if(MyAccountPage.myPersonalInfoBtn(driver).isEnabled())
		{
			MyAccountPage.myPersonalInfoBtn(driver).click();
			Log.info("My Personal Information button clicked");
     	}
		String info_title="Please be sure to update your personal information if it has changed.";
		Assert.assertEquals(info_title, MyAccountPage.MyPersonalInfo.infoText_txt(driver).getText());
		Log.info("My account information text verified");
		Assert.assertEquals("Rudragouda", MyAccountPage.MyPersonalInfo.firstName_field(driver).getAttribute("value"));
		Log.info("First name verified");
		Assert.assertEquals("Desai", MyAccountPage.MyPersonalInfo.lastName_field(driver).getAttribute("value"));
		Log.info("Last name verified");
		Assert.assertEquals("rsdesaiglb@gmail.com", MyAccountPage.MyPersonalInfo.emailAddress_field(driver).getAttribute("value"));
		Log.info("Email address verified");
		String day_value=Util.SelectFuns.selectDropDownValue(driver, MyAccountPage.MyPersonalInfo.dob_days_dropbx(driver)).getFirstSelectedOption().getText().trim();
		System.out.println("Day value selected:"+day_value);
		Assert.assertEquals("23",day_value);
		Log.info("DOB_Day verified");
		String month_value=Util.SelectFuns.selectDropDownValue(driver, MyAccountPage.MyPersonalInfo.dob_months_dropbx(driver)).getFirstSelectedOption().getText().trim();
		System.out.println("Month value selected:"+month_value);
		Assert.assertEquals("August",month_value);
		Log.info("DOB_Month verified");
		String year_value=Util.SelectFuns.selectDropDownValue(driver, MyAccountPage.MyPersonalInfo.dob_years_dropbx(driver)).getFirstSelectedOption().getText().trim();
		System.out.println("Year value selected:"+year_value);
		Assert.assertEquals("1988",year_value);
		Log.info("DOB_Year verified");
		boolean flag1=MyAccountPage.MyPersonalInfo.backToAccount_btn(driver).isEnabled();
		Log.info("Back to account button enabled");
		System.out.println("Back to Account button enabled:"+ flag1);
		boolean flag2=MyAccountPage.MyPersonalInfo.home_btn(driver).isEnabled();
		Log.info("Home button enabled");
		System.out.println("Back to Account button enabled:"+ flag2);
		MyAccountPage.MyPersonalInfo.backToAccount_btn(driver).click();
		Log.info("Back to account button clicked");
		Assert.assertTrue(MyAccountPage.myAccountInfo(driver).getText(), true);
		MyAccountPage.myPersonalInfoBtn(driver).click();
		Log.info("My Personal Information button clicked");
		Assert.assertTrue(MyAccountPage.MyPersonalInfo.infoText_txt(driver).getText(), true);
		ExcelUtils.setExcelFile(Constants.file_path+Constants.file_name, Constants.sheet_name1);
		MyAccountPage.MyPersonalInfo.oldPasswd_field(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		Log.info("Current password entered");
		MyAccountPage.MyPersonalInfo.save_btn(driver).click();
		Log.info("Save button clicked");
		String save_info_txt=MyAccountPage.MyPersonalInfo.saveInfoSuccess_text(driver).getText();
		String expec_txt="Your personal information has been successfully updated.";
		Assert.assertEquals(expec_txt, save_info_txt);
		Log.info("Personal information save message verified");
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
