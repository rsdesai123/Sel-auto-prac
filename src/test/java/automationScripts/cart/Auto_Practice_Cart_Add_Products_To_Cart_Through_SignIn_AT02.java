package automationScripts.cart;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.CartPage;
import pageObjects.CatalogPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utility.Constants;
import utility.Log;
import utility.ReRunFailedTests;
import utility.Util;
/*This test case is to verify that products can be added to the cart through user sign in and verify the added products.*/
public class Auto_Practice_Cart_Add_Products_To_Cart_Through_SignIn_AT02 {
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
	@Test(retryAnalyzer=ReRunFailedTests.class, description="Add product to Cart through user login")
	public static void execute()
	{
	  try
	  {
		  driver=baseClass.getDriver();
		  HomePage.signIn_btn(driver).click();
		  Log.info("Sign in link clicked");
		  String expectTxt="ALREADY REGISTERED?";
	      Assert.assertEquals(expectTxt, LoginPage.signInBlockHeaderTxt(driver).getText().trim());
	      Log.info("SignIn page title verified");
	      LoginPage.signIntoAccount(driver, Constants.userID, Constants.password);
	      expectTxt="Welcome to your account. Here you can manage all of your personal information and orders.";
	      Assert.assertEquals(expectTxt, MyAccountPage.myAccountInfo(driver).getText());
	      Log.info("My account information message verified");
	      driver.navigate().refresh();
	      //Thread.sleep(20);
	      FluentWait<WebDriver> fwait=Util.waitForElementFluentWait(driver);
	      Util.mouseHoverAction(driver, HomePage.HeaderPage.dressesMenu(driver));
	      fwait.until(ExpectedConditions.elementToBeClickable(HomePage.HeaderPage.dresses_subMenu.casualDresses_subMenu(driver)));
		  HomePage.HeaderPage.dresses_subMenu.casualDresses_subMenu(driver).click();
	      Log.info("Casual dresses sub menu clicked");
	      boolean expectCon=CatalogPage.PhotoFrame.frameHeaderText(driver).getText().trim().contains("Casual Dresses");
	      Assert.assertEquals(true, expectCon);
	      Log.info("Casual Dresses page to add product displayed");
	      String prodName=CatalogPage.productName(driver).getText();
	      CatalogPage.addToCartBtn(driver).click();
	      Log.info("Add to Cart button clicked");
	      fwait.until(ExpectedConditions.elementToBeClickable(CartPage.CartLayerPage.cartLayerCloseWinBtn(driver)));
	      String actTxt=CartPage.CartLayerPage.addToCart_SuccessMsg(driver).getText().trim();
	      Assert.assertEquals("Product successfully added to your shopping cart", actTxt);
	      Log.info("Products successfully added to cart");
	      actTxt=CartPage.CartLayerPage.addToCart_NoOfItemsAdded(driver).getText().trim();
	      Assert.assertEquals("There is 1 item in your cart.", actTxt);
	      Log.info("No of Products added to Cart verified");
	      CartPage.CartLayerPage.cartLayerCloseWinBtn(driver).click();
	      Log.info("Cart layer page closed");
	      actTxt=HomePage.cartBtn(driver).getAttribute("textContent");
	      System.out.println("Cart after adding products"+ actTxt);
	      if(actTxt.contains("1") & actTxt.contains("Product"))
	      {
	    	  System.out.println(" 1 Product added to Cart");  
	      }
	      Assert.assertEquals(prodName, CartPage.CartBlock.addedProdName(driver).getAttribute("title"));
	      Log.info("Products added to cart verified");
	      
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

