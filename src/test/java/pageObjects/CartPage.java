package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BaseClass {
    private static WebElement element=null;
	public CartPage(WebDriver driver) {
		super(driver);
	}
	public static class CartLayerPage
	{
		public final static WebElement addToCart_SuccessMsg(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='layer_cart']/div[1]/div[1]/h2"));
		}
		public final static WebElement addToCart_NoOfItemsAdded(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/h2"));
		}
		public final static WebElement cartLayerCloseWinBtn(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='layer_cart']/div[1]/div[1]/span"));
		}
	}
	public static class ShoppingCartTab
	{
		public final static WebElement cartTitle(WebDriver driver)
		{
			return element=driver.findElement(By.id("cart_title"));
		}
		public final static WebElement cartAlertWarning(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/p"));
		}
		public final static WebElement shoppingCartPrdsCount(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='cart_title']/span"));
		}
		public final static WebElement prodAvailabilityStatus(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@class='cart_avail']/span"));
		}
		public final static WebElement proceedToCheckoutBtn(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/p[2]/a[1]/span"));
		}
		public final static WebElement prodDescription(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//p[@class='product-name']/a"));
		}
		public final static WebElement prodName(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//p[@class='product-name']"));
		}
		public final static WebElement prodUnitPrice(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='product_3_13_0_8957']/td[4]"));
		}
		public final static WebElement prodQty(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@class='cart_quantity text-center']/input[1]"));
		}
		public final static WebElement prodQtyUp(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@class='icon-plus']"));
		}
		public final static WebElement prodQtyDown(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@class='icon-minus']"));
		}
		public final static WebElement prodTotalPrice(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='product_3_13_0_8957']/td[6]"));
		}
		public final static WebElement prodDeleteBtn(WebDriver driver)
		{
			return element=driver.findElement(By.className("cart_quantity_delete"));
		}
		public final static WebElement prodTotalProductsCost(WebDriver driver)
		{
			return element=driver.findElement(By.id("total_product"));
		}
		public final static WebElement prodTotalShippingCost(WebDriver driver)
		{
			return element=driver.findElement(By.id("total_shipping"));
		}
		public final static WebElement prodTotalPriceWithoutTax(WebDriver driver)
		{
			return element=driver.findElement(By.id("total_price_without_tax"));
		}
		public final static WebElement prodTotalTax(WebDriver driver)
		{
			return element=driver.findElement(By.id("total_tax"));
		}
		public final static WebElement prodTotalContainerPrice(WebDriver driver)
		{
			return element=driver.findElement(By.id("total_price_container"));
		}
		public final static String deliveryAddressContent(WebDriver driver, int i)
		{
			String xpath1=".//*[@class='address first_item item box']/li[";
			String xpath2="]";
			String xpath=xpath1+i+xpath2;
			String delAdd=driver.findElement(By.xpath(xpath)).getText();
			return delAdd;
		}
		public final static String invoiceAddressContent(WebDriver driver, int i)
		{
			String xpath1=".//*[@class='address last_item alternate_item box']/li[";
			String xpath2="]";
			String xpath=xpath1+i+xpath2;
			String invAdd=driver.findElement(By.xpath(xpath)).getText();
			return invAdd;
		}
	}
	public static class Adresses
	{
		public final static WebElement chooseDeliveryAdd_Txt(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/form/div/div[1]/div[1]/div/label"));
		}
		public final static WebElement chooseDeliveryAdd_dropdown(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='id_address_delivery']"));
		}
		public final static WebElement deliveryAddAsBillingAdd_ChkBx(WebDriver driver)
		{
			return element=driver.findElement(By.id("addressesAreEquals"));
		}
		public final static WebElement addCommentBox(WebDriver driver)
		{
			return element=driver.findElement(By.name("message"));
		}
		public final static WebElement proceedToCheckoutBtn(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/form/p/button"));
		}
	}
	public static class Shipping
	{
		public final static WebElement termsOfService_Chkbx(WebDriver driver)
		{
			return element=driver.findElement(By.id("uniform-cgv"));
		}
		public final static WebElement termsOfService_ChkbxTxt(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='form']/div/p[2]"));
		}
		public final static WebElement proceedToCheckoutBtn(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='form']/p/button"));
		}
		public final static WebElement termsOfServiceErrorBoxTxt(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='order']/div[2]/div/div/div/div/p"));
		}
		public final static WebElement termsOfServiceErrorBoxCloseBtn(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='order']/div[2]/div/div/a"));
		}
		
	}
	public static class Payment
	{
		public final static WebElement pageHeadingTxt(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/h1"));
		}
		public final static WebElement payByBankWireOptn(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='HOOK_PAYMENT']/div[1]/div/p/a"));
		}
	}
	public static class OrderSummary
	{
		public final static WebElement pageSubHeadingTxt(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/form/div/h3"));
		}
		public final static WebElement payModeChoseTxt(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/form/div/p[1]"));
		}
		public final static WebElement ConfirmMyOrderBtn(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='cart_navigation']/button"));
		}
	}
	public static class OrderConfirmation
	{
		public final static WebElement pageSubHeadingTxt(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/div/p/strong"));
		}
		public final static WebElement bankAccOwnerName(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/div/p/strong"));
		}
		public final static WebElement bankName(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/div/strong[3]"));
		}
		public final static WebElement orderReference(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/div"));
		}
		public final static WebElement orderConfirmationTxt(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/div/strong[4]"));
		}
	}
	public static class CartBlock
	{
		public final static WebElement addToCartProdtsAddedBtn(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='header']/div[3]/div/div/div[3]/div/a"));
		}
		public final static WebElement addedProdName(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='header']/div[3]/div/div/div[3]/div/div/div/div/dl/dt/div/div[1]/a"));
		}
		public final static WebElement checkOutBtn(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='button_order_cart']/span"));
		}
		public final static WebElement shippingPriceField(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='header']/div[3]/div/div/div[3]/div/div/div/div/div/div[1]"));
		}
		public final static WebElement totalPriceField(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='header']/div[3]/div/div/div[3]/div/div/div/div/div/div[2]"));
		}
	}
	public final static WebElement homeIcon(WebDriver driver)
	{
		return element=driver.findElement(By.className("home"));
	}
}
