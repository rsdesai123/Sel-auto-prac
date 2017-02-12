package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPW extends BaseClass {
 private static WebElement element;
	public ForgetPW(WebDriver driver) {
		super(driver);
	}
	public final static WebElement forgetPwText(WebDriver driver)
	{
		return element=driver.findElement(By.cssSelector(".box>p"));
	}
	public final static WebElement retreivePwBtn(WebDriver driver)
	{
		return element=driver.findElement(By.xpath(".//button[@class='btn btn-default button button-medium']"));
	}
	public final static WebElement forgetEmailField(WebDriver driver)
	{
		return element=driver.findElement(By.cssSelector("#email"));
	}

}
