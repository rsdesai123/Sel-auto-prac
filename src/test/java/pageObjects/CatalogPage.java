package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogPage extends BaseClass{
   
	public static WebDriver driver;
	private static WebElement element=null;
	public CatalogPage(WebDriver driver) {
		super(driver);
	}
	public static class PhotoFrame
	{
		public static WebElement frameHeaderText(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/div[1]/div/div/span"));
		}
		public static WebElement photoFrameTextLine1(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/div[1]/div/div/div/p[1]"));
		}
		public static WebElement photoFrameTextLine2(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/div[1]/div/div/div/p[2]"));
		}
		public static WebElement photoFrameText(WebDriver driver)
		{
			return element=driver.findElement(By.xpath(".//*[@id='center_column']/div[1]/div/div/div"));
		}
	}
	public static WebElement homeIcon(WebDriver driver)
	{
		return element=driver.findElement(By.xpath(".//*[@id='columns']/div[1]/a[1]/i"));
	}
	public static WebElement addToCartBtn(WebDriver driver)
	{
		return element=driver.findElement(By.xpath(".//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span"));
	}
	public final static WebElement productName(WebDriver driver)
	{
		return element=driver.findElement(By.xpath(".//*[@id='center_column']/ul/li/div/div[2]/h5/a"));
	}
}
