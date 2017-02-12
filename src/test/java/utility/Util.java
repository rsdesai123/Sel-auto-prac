package utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	
	public static WebDriver driver;
	private static WebElement element;
	
	public static WebDriverWait waitForElement(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		return wait;
	}
	public static FluentWait waitForElementFluentWait(WebDriver driver)
	{
		FluentWait<WebDriver> fwait=new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.MILLISECONDS).ignoring(Throwable.class);
	    return fwait;
	}
	
	public static void takeScreenShot(WebDriver driver, String fileName)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(src, new File(Constants.screenshot_filepath+fileName+".png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
	    act.moveToElement(element).perform();
	}
	public static class SelectFuns
	{
	public static Select selectDropDownValue(WebDriver driver, WebElement element)
	{
		Select sel=new Select(element);
		return sel;
	}
	public static void selectByIndex(WebDriver driver, WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public static void selectByValue(WebDriver driver, WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	public static void selectByVisibleTxt(WebDriver driver, WebElement element,String txt)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(txt);
	}
	}
	public static class PageScroll
	{
		public static void pageScrollUp(WebDriver driver)
		{
			JavascriptExecutor jsx=(JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,-1500)","");
		}
		public static void pageScrollDown(WebDriver driver)
		{
			JavascriptExecutor jsx=(JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,400)","");
		}
	}
	
	public static void autoFileUpload(WebDriver driver, String autoITexe) throws IOException
	{
		Runtime.getRuntime().exec(autoITexe);
	}
	public static String getText(WebDriver driver, WebElement element){
	    return (String) ((JavascriptExecutor) driver).executeScript("return jQuery(arguments[0]).text();", element);
	}

}
