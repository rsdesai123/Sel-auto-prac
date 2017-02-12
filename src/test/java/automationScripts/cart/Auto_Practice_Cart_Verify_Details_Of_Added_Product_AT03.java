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
/*This test case is to verify the details of the product added to the cart.*/
public class Auto_Practice_Cart_Verify_Details_Of_Added_Product_AT03 {
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
	@Test(retryAnalyzer=ReRunFailedTests.class,description="Add products to Cart through user login")
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
	      Assert.assertEquals("There is 1 item in your cart.", actTxt);
	      Log.info("No of Products added to cart verified");
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
		  System.out.println(ex.getMessage());
	  }
	}
	@Test(retryAnalyzer=ReRunFailedTests.class,dependsOnMethods={"execute"}, description="Verify details of product added to cart")
	public static void execute1()
	{
		try
		{
		HomePage.cartBtn(driver).click();
		Log.info("Cart button on homepage clicked");
		Util.PageScroll.pageScrollDown(driver);
		String prodDesc=(CartPage.ShoppingCartTab.prodDescription(driver)).getAttribute("textContent");
		System.out.println("Product Description:"+ prodDesc);
		Assert.assertTrue(CartPage.ShoppingCartTab.prodDescription(driver).getAttribute("textContent").contains("Printed Dress"));
		Log.info("Product description printed");
		Assert.assertEquals(CartPage.ShoppingCartTab.prodAvailabilityStatus(driver).getText().contains("In stock"), true);
		Log.info("Product availability status checked");
		System.out.println("Product Unit Price:"+ CartPage.ShoppingCartTab.prodUnitPrice(driver).getText());
		Log.info("Product Unit Price printed");
		Assert.assertEquals(CartPage.ShoppingCartTab.prodQty(driver).getAttribute("value"), "1");
		Log.info("Product quantity verified");
		System.out.println("Total Unit Price:"+CartPage.ShoppingCartTab.prodTotalPrice(driver).getText());
		Log.info("Total unit price printed");
		System.out.println("Total Products cost:"+CartPage.ShoppingCartTab.prodTotalProductsCost(driver).getText());
		Log.info("Total product cost printed");
		System.out.println("Total shipping cost:"+CartPage.ShoppingCartTab.prodTotalShippingCost(driver).getText());
		Log.info("Total shipping cost printed");
		System.out.println("Total product Price without tax:"+CartPage.ShoppingCartTab.prodTotalPriceWithoutTax(driver).getText());
		Log.info("Total product price without tax printed");
		System.out.println("Total product tax:"+CartPage.ShoppingCartTab.prodTotalTax(driver).getText());
		Log.info("Total product tax printed");
		System.out.println("Total container price of product:"+CartPage.ShoppingCartTab.prodTotalContainerPrice(driver).getAttribute("textContent"));
		Log.info("Total container price printed");
		CartPage.ShoppingCartTab.prodQtyUp(driver).click();
		Log.info("Button to increase product quantity by one unit clicked");
		driver.navigate().refresh();
	    System.out.println("Product quantity:"+CartPage.ShoppingCartTab.prodQty(driver).getAttribute("value"));
		Assert.assertEquals(CartPage.ShoppingCartTab.prodQty(driver).getAttribute("value"), "2");
		//String prodQuantity=Util.getText(driver, CartPage.ShoppingCartTab.prodQty(driver));
		//Assert.assertEquals(prodQuantity, "2");
		Log.info("Product quantity increased by one unit and same is verified");
		CartPage.ShoppingCartTab.prodQtyDown(driver).click();
		Log.info("Button to decrease product quantity by one unit clicked");
		driver.navigate().refresh();
		System.out.println("Product quantity:"+CartPage.ShoppingCartTab.prodQty(driver).getAttribute("value"));
	    Assert.assertEquals(CartPage.ShoppingCartTab.prodQty(driver).getAttribute("value"), "1");
		Log.info("Product quantity decreased by one unit and same is verified");
		int count=0;
		List<String> myadd=new ArrayList<String>();
		for (int i=1;i<=7;i++)
		{
			String delAdd=CartPage.ShoppingCartTab.deliveryAddressContent(driver, i);
			String invAdd=CartPage.ShoppingCartTab.invoiceAddressContent(driver, i);
			//System.out.println("Delivery Address:"+delAdd+"/n"+"Invoice Address:"+invAdd);
			if(delAdd.equalsIgnoreCase(invAdd))
			{
				count++;
				myadd.add(delAdd);
			}
		}
			if(count==6)
			{
				System.out.println("Delivery Address and Invoice Address are same");
			}
			System.out.println("My Address:");
			for(String add:myadd)
			{
				System.out.println(add);
			}
			Log.info("Delivery address and Invoice addresses are verified");
			CartPage.homeIcon(driver).click();
			Log.info("Homepage icon clicked");
			Assert.assertEquals(HomePage.homePageLogo(driver).isDisplayed(), true);
			HomePage.signOut_btn(driver).click();
			Log.info("Signout button clicked");
		}
		catch(Exception ex)
		{
			Util.takeScreenShot(driver, Thread.currentThread().getStackTrace()[1].getClassName());
			System.out.println(ex.getMessage());
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
