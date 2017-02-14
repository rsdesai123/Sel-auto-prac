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
import utility.Constants;
import utility.Log;
import utility.ReRunFailedTests;
import utility.Util;

/*Verify that user can place the order for the product which is already added to the cart and to verify the successful order placement.*/
public class Auto_Practice_Cart_Already_AddedProduct_Place_The_Order_AT01 {
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
	@Test(retryAnalyzer=ReRunFailedTests.class, description="Place order of the already added product from the cart")
	public static void execute()
	{
	  try
	  {   
		  driver=baseClass.getDriver();
		  HomePage.HeaderPage.tShirtsMenu(driver).click();
		  CatalogPage.addToCartBtn(driver).click();
		  WebDriverWait wait=Util.waitForElement(driver);
		  wait.until(ExpectedConditions.elementToBeClickable(CartPage.CartLayerPage.cartLayerCloseWinBtn(driver)));
		  CartPage.CartLayerPage.cartLayerCloseWinBtn(driver).click();
		  CatalogPage.homeIcon(driver).click();
		  Log.info("Product added to cart");
		  Util.mouseHoverAction(driver, CartPage.CartBlock.addToCartProdtsAddedBtn(driver));
		  FluentWait<WebDriver> fwait=Util.waitForElementFluentWait(driver);
		  fwait.until(ExpectedConditions.elementToBeClickable(CartPage.CartBlock.checkOutBtn(driver)));
		  CartPage.CartBlock.checkOutBtn(driver).click();
		  Log.info("Checkout button on Cart block clicked");
		  String expectedTxt="Your shopping cart contains: 1 Product";
		  Assert.assertEquals(expectedTxt, CartPage.ShoppingCartTab.shoppingCartPrdsCount(driver).getText().trim());
		  Log.info("Number of products under shoppig cart verified");
		  Assert.assertEquals(CartPage.ShoppingCartTab.prodAvailabilityStatus(driver).getText().contains("In stock"), true);
		  Log.info("The product added to cart is in stock");
          CartPage.ShoppingCartTab.proceedToCheckoutBtn(driver).click();
          Log.info("Proceed to checkout button clicked");
          Util.PageScroll.pageScrollDown(driver);
          wait.until(ExpectedConditions.elementToBeClickable(LoginPage.signInBlockHeaderTxt(driver)));
          System.out.println(LoginPage.signInBlockHeaderTxt(driver).getAttribute("textContent"));
		  Assert.assertEquals(true,LoginPage.signInBlockHeaderTxt(driver).getAttribute("textContent").contains("Already registered?"));
		  Log.info("Sing in to account tab opened");
		  LoginPage.signIntoAccount(driver, Constants.userID, Constants.password);
		  Log.info("User logged into account");
		  Assert.assertEquals(CartPage.Adresses.chooseDeliveryAdd_Txt(driver).getText().contains("Choose a delivery address"), true);
		  Log.info("Tab to select delivery address is opened");
		  boolean flag=CartPage.Adresses.deliveryAddAsBillingAdd_ChkBx(driver).isSelected();
		  System.out.println("Use delivery address as billing address chxbox checked:"+ flag);
		  Log.info("'Use the delivery address as the billing address' checkbox is checked");
	      Util.SelectFuns.selectByIndex(driver, CartPage.Adresses.chooseDeliveryAdd_dropdown(driver), 1);
	      Log.info("Delivery address 'My alternate address' is selected");
	      String selectedAdd=Util.SelectFuns.selectDropDownValue(driver, CartPage.Adresses.chooseDeliveryAdd_dropdown(driver)).getFirstSelectedOption().getText();
		  System.out.println("Address option selected:"+ selectedAdd);
		  Util.PageScroll.pageScrollDown(driver);
		  CartPage.Adresses.addCommentBox(driver).sendKeys("Delivery placed order on time");
		  Log.info("Comments added about the placed order");
		  fwait.until(ExpectedConditions.elementToBeClickable(CartPage.Adresses.proceedToCheckoutBtn(driver)));
		  CartPage.Adresses.proceedToCheckoutBtn(driver).click();
		  Log.info("Proceed to checkout button on Address tab clicked");
		  String TOSText="I agree to the terms of service and will adhere to them unconditionally. (Read the Terms of Service)";
		  Assert.assertEquals(TOSText, CartPage.Shipping.termsOfService_ChkbxTxt(driver).getText().trim());
	      Log.info("Shipping tab gets opened");
	      Assert.assertEquals(false, CartPage.Shipping.termsOfService_Chkbx(driver).isSelected());
	      Log.info("Terms of service checkbox not checked");
	      CartPage.Shipping.proceedToCheckoutBtn(driver).click();
	      Log.info("Proceed to checkout button on Shipping tab clicked");
	      String errorTxt=CartPage.Shipping.termsOfServiceErrorBoxTxt(driver).getText();
	      System.out.println(errorTxt);
	      CartPage.Shipping.termsOfServiceErrorBoxCloseBtn(driver).click();
	      Log.info("Error box closed");
	      driver.navigate().refresh();
	      wait.until(ExpectedConditions.elementToBeClickable(CartPage.Shipping.termsOfService_Chkbx(driver)));
	      CartPage.Shipping.termsOfService_Chkbx(driver).click();
	      Log.info("'Terms of service' checkbox checked");
	      CartPage.Shipping.proceedToCheckoutBtn(driver).click();
	      Log.info("Proceed to checkout button on Shipping tab clicked");
	      wait.until(ExpectedConditions.visibilityOf(CartPage.Payment.pageHeadingTxt(driver)));
	      System.out.println(CartPage.Payment.pageHeadingTxt(driver).getText());
	      Assert.assertEquals(CartPage.Payment.pageHeadingTxt(driver).getText().equalsIgnoreCase("Please choose your payment method"), true);
		  CartPage.Payment.payByBankWireOptn(driver).click();
		  Log.info("Bankwire pament option selected");
		  Assert.assertTrue(CartPage.OrderSummary.payModeChoseTxt(driver).getText(), true);
		  Log.info("Order summary tab opened");
		  CartPage.OrderSummary.ConfirmMyOrderBtn(driver).click();
		  Log.info("'I Confirm My Order' button clicked");
		  String orderConTxt="Your order on My Store is complete.";
		  Assert.assertEquals(orderConTxt, CartPage.OrderConfirmation.pageSubHeadingTxt(driver).getText().trim());
	      Log.info("Order confirmation text verified");
	      String orderConfirmTxt=CartPage.OrderConfirmation.orderReference(driver).getText();
	      String [] strArr=orderConfirmTxt.split("-");
	      for(String arrEle:strArr)
	      {
	    	  System.out.println(arrEle);
	    	  if(arrEle.contains("order reference"))
		      {
	    		  System.out.println("Order reference:"+ arrEle);
		    	  Log.info("Order reference text verified");
		      }
	      }
	      //System.out.println(orderConfirmTxt);
	      Assert.assertEquals("Your order will be sent as soon as we receive payment.", CartPage.OrderConfirmation.orderConfirmationTxt(driver).getText());
	      Log.info("Order payment received text verified");
		  HomePage.homeIcon(driver).click();
		  Log.info("Home icon clicked");
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
