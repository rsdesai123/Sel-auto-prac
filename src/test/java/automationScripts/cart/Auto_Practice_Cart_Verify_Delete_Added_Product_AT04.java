package automationScripts.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
/*This test case is to verify that a product added to the cart can be deleted by user successfully.*/
public class Auto_Practice_Cart_Verify_Delete_Added_Product_AT04 {
	public static WebDriver driver;
	private static BaseClass baseClass=new BaseClass(driver);
	@Parameters("browser")
	@BeforeClass
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
	@Test(retryAnalyzer=ReRunFailedTests.class,description="Add two product to Cart through user login")
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
	     // driver.navigate().refresh();
	      Thread.sleep(20);
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
	      Assert.assertEquals(actTxt, "There is 1 item in your cart.");
	      Log.info("No of Products added to cart verified");
	      CartPage.CartLayerPage.cartLayerCloseWinBtn(driver).click();
	      Log.info("Cart layer page closed");
	      HomePage.HeaderPage.tShirtsMenu(driver).click();
	      Assert.assertEquals(CatalogPage.PhotoFrame.frameHeaderText(driver).getText().contains("T-shirts"), true);
	      CatalogPage.addToCartBtn(driver).click();
	      Log.info("Add to Cart button clicked");
	      fwait.until(ExpectedConditions.elementToBeClickable(CartPage.CartLayerPage.cartLayerCloseWinBtn(driver)));
	      String actTxt1=CartPage.CartLayerPage.addToCart_SuccessMsg(driver).getText().trim();
	      Assert.assertEquals("Product successfully added to your shopping cart", actTxt1);
	      Log.info("Products successfully added to cart");
	      actTxt=CartPage.CartLayerPage.addToCart_NoOfItemsAdded(driver).getText().trim();
	      Assert.assertEquals("There are 2 items in your cart.", actTxt);
	      Log.info("No of Products added to cart verified");
	      CartPage.CartLayerPage.cartLayerCloseWinBtn(driver).click();
	      Log.info("Cart layer page closed");
	      actTxt=HomePage.cartBtn(driver).getAttribute("textContent");
	      System.out.println("Cart after adding products"+ actTxt);
	      if(actTxt.contains("2") & actTxt.contains("Products"))
	      {
	    	  System.out.println(" 2 Products added to Cart");  
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
	@Test(retryAnalyzer=ReRunFailedTests.class,dependsOnMethods={"execute"}, description="Verify added product can be deleted from cart")
	public static void execute1()
	{
		try
		{
		HomePage.cartBtn(driver).click();
		Log.info("Cart button on homepage clicked");
		Assert.assertTrue(CartPage.ShoppingCartTab.cartTitle(driver).getText().contains("SHOPPING-CART SUMMARY"));
		Log.info("Shopping Cart page opened");
		Util.PageScroll.pageScrollDown(driver);
		System.out.println("No of products added:"+CartPage.ShoppingCartTab.shoppingCartPrdsCount(driver).getAttribute("textContent"));
		System.out.println("First product:"+CartPage.ShoppingCartTab.prodDescription(driver).getAttribute("textContent"));
		Assert.assertEquals(CartPage.ShoppingCartTab.prodQty(driver).getAttribute("value"), "1");
		Log.info("Product 1 quantity verified");
		System.out.println("Second product:"+CartPage.ShoppingCartTab.prodDescription(driver).getAttribute("textContent"));
		Assert.assertEquals(CartPage.ShoppingCartTab.prodQty(driver).getAttribute("value"), "1");
		Log.info("Product 2 quantity verified");
		String products=CartPage.ShoppingCartTab.prodName(driver).getAttribute("innerText");
		driver.navigate().refresh();
		CartPage.ShoppingCartTab.prodDeleteBtn(driver).click();
		Log.info("Button to delete product clicked");
		driver.navigate().refresh();
		CartPage.homeIcon(driver).click();
		Log.info("Homepage icon clicked");
		Assert.assertEquals(HomePage.homePageLogo(driver).isDisplayed(), true);
	    Util.mouseHoverAction(driver,HomePage.cartBtn(driver));
	    String remainingProd= CartPage.CartBlock.addedProdName(driver).getAttribute("title");
	    System.out.println("Product not deleted from cart:"+remainingProd);
	    Assert.assertEquals(products.contains(remainingProd), true);
	    Log.info("Only one product remaining in cart");
	    HomePage.signOut_btn(driver).click();
		Log.info("Signout button clicked");	
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	@AfterClass
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
