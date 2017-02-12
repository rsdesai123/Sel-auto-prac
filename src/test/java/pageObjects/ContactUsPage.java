package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage extends BaseClass {
	public static WebDriver driver;
	private static WebElement element;
	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	public static WebElement headerTxt(WebDriver driver)
	{
		return element=driver.findElement(By.xpath(".//*[@id='center_column']/form/fieldset/h3"));
	}
	
	public static WebElement dropboxTxt(WebDriver driver)
	{
		return element=driver.findElement(By.xpath("//*[@id='center_column']/form/fieldset/div[1]/div[1]/div[1]/label"));
	}
	public static WebElement dropbox(WebDriver driver)
	{
		return element=driver.findElement(By.id("id_contact"));
	}
	public static WebElement ddCustServTxt(WebDriver driver)
	{
		return element=driver.findElement(By.xpath(".//*[@id='desc_contact2']"));
	}
	public static WebElement ddWebmasterTxt(WebDriver driver)
	{
		return element=driver.findElement(By.xpath(".//*[@id='desc_contact1']"));
	}
	public static WebElement emailAddrsField(WebDriver driver)
	{
		return element=driver.findElement(By.id("email"));
	}
	public static WebElement orderRefField(WebDriver driver)
	{
		return element=driver.findElement(By.id("id_order"));
	}
	public static WebElement fileUploadBtn(WebDriver driver)
	{
		return element=driver.findElement(By.id("fileUpload"));
	}
	public static WebElement nameOfFileUploaded(WebDriver driver)
	{
		return element=driver.findElement(By.className("filename"));
	}
	public static WebElement saveBtn(WebDriver driver)
	{
		return element=driver.findElement(By.id("submitMessage"));
	}
	public static WebElement messageField(WebDriver driver)
	{
		return element=driver.findElement(By.id("message"));
	}
	public static WebElement messgSaveTxt(WebDriver driver)
	{
		return element=driver.findElement(By.xpath(".//*[@id='center_column']/p"));
	}
	public static WebElement homeBtn(WebDriver driver)
	{
		return element=driver.findElement(By.xpath(".//*[@id='center_column']/ul/li/a/span"));
	}
}
