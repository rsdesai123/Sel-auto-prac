package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends BaseClass{
   private static WebElement element=null;
   public static WebDriver driver;
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	public final static WebElement myAccountInfo(WebDriver driver)
	{
		return element=driver.findElement(By.xpath(".//p[@class='info-account']"));
	}
	public final static List<WebElement> myAccountOptions(WebDriver driver)
	{
		List<WebElement> options=driver.findElements(By.xpath("//ul[@class='myaccount-link-list']"));
		return options;
	}
	public final static WebElement myOrderBtn(WebDriver driver)
	{
		return element=driver.findElement(By.xpath(".//*[@id='center_column']/div/div[1]/ul/li[1]/a/span"));
	}
	public final static WebElement myCreditBtn(WebDriver driver)
	{
		return element=driver.findElement(By.xpath(".//*[@id='center_column']/div/div[1]/ul/li[2]/a/span"));
	}
	public final static WebElement myAddressBtn(WebDriver driver)
	{
		return element=driver.findElement(By.xpath(".//*[@id='center_column']/div/div[1]/ul/li[3]/a/span"));
	}
	public final static WebElement myPersonalInfoBtn(WebDriver driver)
	{
		return element=driver.findElement(By.xpath(".//*[@id='center_column']/div/div[1]/ul/li[4]/a/span"));
	}
	public final static WebElement myWishlistBtn(WebDriver driver)
	{
		return element=driver.findElement(By.xpath(".//*[@id='center_column']/div/div[2]/ul/li/a/span"));
	}
	public static class MyPersonalInfo
	{
		public static WebElement infoText_txt(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/div/p[1]"));
		}
		public static WebElement firstName_field(WebDriver driver)
		{
			return element=driver.findElement(By.id("firstname"));
		}
		public static WebElement lastName_field(WebDriver driver)
		{
			return element=driver.findElement(By.id("lastname"));
		}
		public static WebElement emailAddress_field(WebDriver driver)
		{
			return element=driver.findElement(By.id("email"));
		}
		public static WebElement dob_days_dropbx(WebDriver driver)
		{
			return element=driver.findElement(By.id("days"));
		}
		public static WebElement dob_months_dropbx(WebDriver driver)
		{
			return element=driver.findElement(By.id("months"));
		}
		public static WebElement dob_years_dropbx(WebDriver driver)
		{
			return element=driver.findElement(By.id("years"));
		}
		public static WebElement oldPasswd_field(WebDriver driver)
		{
			return element=driver.findElement(By.id("old_passwd"));
		}
		public static WebElement newPasswd_field(WebDriver driver)
		{
			return element=driver.findElement(By.id("passwd"));
		}
		public static WebElement confirmationPasswd_field(WebDriver driver)
		{
			return element=driver.findElement(By.id("confirmation"));
		}
		public static WebElement signUpNewsLetter_chkbx(WebDriver driver)
		{
			return element=driver.findElement(By.id("uniform-newsletter"));
		}
		public static WebElement specialOffers_chkbx(WebDriver driver)
		{
			return element=driver.findElement(By.id("uniform-option"));
		}
		public static WebElement save_btn(WebDriver driver)
		{
			return element=driver.findElement(By.name("submitIdentity"));
		}
		public static WebElement backToAccount_btn(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/ul/li[1]/a/span"));
		}
		public static WebElement home_btn(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/ul/li[2]/a/span"));
		}
		public static WebElement saveInfoSuccess_text(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/div/p"));
		}
		public static WebElement incorrectPW_text(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/div/div/ol/li"));
		}
		
	}

}
