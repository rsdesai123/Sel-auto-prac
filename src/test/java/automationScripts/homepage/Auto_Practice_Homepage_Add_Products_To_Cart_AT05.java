package automationScripts.homepage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.CartPage;
import pageObjects.CatalogPage;
import pageObjects.HomePage;
import utility.Constants;
import utility.Log;
import utility.ReRunFailedTests;
import utility.Util;
/*Verify that products can be added to the cart directly from the homepage and also to validate the number of products added to the cart.*/
public class Auto_Practice_Homepage_Add_Products_To_Cart_AT05 {

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
	@Test(retryAnalyzer=ReRunFailedTests.class, description="Add products to cart from Homepage")
	public static void execute()
	{
	  try
	  {
		  driver=baseClass.getDriver();
		  HomePage.cartBtn(driver).click();
		  Log.info("Cart button clicked");
		  String expectTxt="SHOPPING-CART SUMMARY";
	      Assert.assertEquals(expectTxt, CartPage.ShoppingCartTab.cartTitle(driver).getText().trim());
	      Log.info("Shipping Cart Summary title verified");
	      String shpCartAltWar=CartPage.ShoppingCartTab.cartAlertWarning(driver).getText();
	      System.out.println("Shoppin Cart Alert:"+shpCartAltWar);
	      expectTxt="Your shopping cart is empty.";
	      Assert.assertEquals(expectTxt, shpCartAltWar);
	      Log.info("Shopping cart summary alert warning verified");
	      HomePage.HeaderPage.tShirtsMenu(driver).click();
	      Log.info("T-shirts main menu clicked");
	      boolean expectCon=CatalogPage.PhotoFrame.frameHeaderText(driver).getText().trim().contains("T-shirts");
	      Assert.assertEquals(true, expectCon);
	      Log.info("T-shirts page to add product displayed");
	      CartPage.CartBlock.addToCartProdtsAddedBtn(driver).click();
	      Log.info("Add to Cart button clicked");
	      WebDriverWait wait=Util.waitForElement(driver);
	      wait.until(ExpectedConditions.elementToBeClickable(CartPage.CartLayerPage.cartLayerCloseWinBtn(driver)));
	      String actTxt=CartPage.CartLayerPage.addToCart_SuccessMsg(driver).getText().trim();
	      Assert.assertEquals("Product successfully added to your shopping cart", actTxt);
	      Log.info("Products successfully added to cart");
	      CartPage.CartLayerPage.cartLayerCloseWinBtn(driver).click();
	      Log.info("Cart layer page closed");
	      actTxt=HomePage.cartBtn(driver).getAttribute("textContent");
	      System.out.println("Cart after adding products"+ actTxt);
	      if(actTxt.contains("1") & actTxt.contains("Product"))
	      {
	    	  System.out.println(" 1 Product added to Cart");  
	      }
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
