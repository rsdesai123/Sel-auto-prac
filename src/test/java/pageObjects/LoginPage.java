package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Constants;
import utility.Log;
public class LoginPage extends BaseClass{
	private static WebElement element=null;
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	   public final static WebElement signInBlockHeaderTxt(WebDriver driver)
	   {
		return element=driver.findElement(By.xpath(".//*[@id='login_form']/h3"));
	    }	
	   public final static WebElement emailAddressField(WebDriver driver)
		{
			return element=driver.findElement(By.id("email"));
		}
		public final static WebElement passwordField(WebDriver driver)
		{
			return element=driver.findElement(By.id("passwd"));
		}
		public final static WebElement forgotPasswordLink(WebDriver driver)
		{
			return element=driver.findElement(By.linkText("Forgot your password?"));
		}
		public final static WebElement signInBtn(WebDriver driver)
		{
			return element=driver.findElement(By.id("SubmitLogin"));
		}
		public final static WebElement authentication_error1(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//div[@id='center_column']/div[1]/p"));
		}
		public final static WebElement authentication_error2(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//div[@class='alert alert-danger']/ol/li"));
		}
		
		public static void signIntoAccount(WebDriver driver, String userID, String userPW)
		{
			LoginPage.emailAddressField(driver).clear();
			LoginPage.emailAddressField(driver).sendKeys(userID);
			Log.info("User mail ID entered");
			LoginPage.passwordField(driver).clear();
			LoginPage.passwordField(driver).sendKeys(userPW);
			Log.info("User password entered");
			LoginPage.signInBtn(driver).click();
			Log.info("Sign In button clicked");
		}
		
}

