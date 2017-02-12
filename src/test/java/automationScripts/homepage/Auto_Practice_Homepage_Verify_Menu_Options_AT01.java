package automationScripts.homepage;
/*This test case is to verify the number of menus present on the homepage and also to verify that each menu option is working fine.*/
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.CatalogPage;
import pageObjects.HomePage;
import utility.Constants;
import utility.Log;
import utility.ReRunFailedTests;
import utility.Util;

public class Auto_Practice_Homepage_Verify_Menu_Options_AT01 {
private static WebDriver driver;
private static BaseClass baseClass=new BaseClass(driver);
@Parameters("browser")
@BeforeMethod
public static void setUp(String browser)
{
	try
	{
	baseClass.setBrowser(browser, Constants.url);
	Log.info("Application is launched");
	//driver=baseClass.getDriver();
	/*System.setProperty("webdriver.chrome.driver", Constants.chrome_driver_path);
	driver=new ChromeDriver();
	driver.get(Constants.url);
	Log.info("Application is launched");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
	}
	catch(Exception ex)
	  { 
		  Util.takeScreenShot(driver, Thread.currentThread().getStackTrace()[1].getClassName());
		  System.out.println(ex.getMessage());
	  }
}
@SuppressWarnings("deprecation")
@Test(retryAnalyzer=ReRunFailedTests.class, description="Verifying menu options of homepage")
public static void execute()
{
  try{
	    driver=baseClass.getDriver();
		Util.mouseHoverAction(driver, HomePage.HeaderPage.womenMenu(driver));
		String tooltip1=HomePage.HeaderPage.womenMenu(driver).getText();
		System.out.println("WOMEN menu tooltip text:"+tooltip1);
		Assert.assertEquals("WOMEN", tooltip1);
		Log.info("Women menu tooltip text verified");
		Util.mouseHoverAction(driver, HomePage.HeaderPage.womenMenu(driver));
		List<WebElement> tops_submenus=driver.findElements(By.xpath(".//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li/a"));
		for(WebElement element:tops_submenus)
		{
			System.out.println("Submenus under WOMEN-Tops menu:"+ element.getAttribute("textContent"));
		}
		Log.info("Submenus of 'Women->Tops are prrinted");
		List<WebElement> dresses_submenus=driver.findElements(By.xpath(".//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li/a"));
		for(WebElement element:dresses_submenus)
		{
			System.out.println("Submenus under WOMEN-Dressess menu:"+ element.getAttribute("textContent"));
		}
		Log.info("Submenus of 'Women->Dresses are printed");
		System.out.println("Tooltip text of T-shirts:"+HomePage.HeaderPage.tops_subMenu.tShirt_subMenu(driver).getAttribute("textContent"));
		System.out.println("Tooltip text of Blouses:"+HomePage.HeaderPage.tops_subMenu.blouses_subMenu(driver).getAttribute("textContent"));
		Log.info("Tooltip texts of Women->Tops submenus printed");
		Util.mouseHoverAction(driver, HomePage.HeaderPage.dressesMenu(driver));
		String tooltip2=HomePage.HeaderPage.dressesMenu(driver).getText();
		System.out.println("Tooltip text of DRESSES menu:"+tooltip2);
		Assert.assertEquals("DRESSES", tooltip2);
		Log.info("Tooltip text of DRESSES menu verified");
		Util.mouseHoverAction(driver, HomePage.HeaderPage.dressesMenu(driver));
		List<WebElement> dresses_submenus2=driver.findElements(By.xpath(".//*[@id='block_top_menu']/ul/li[2]/ul/li/a"));
		for(WebElement element:dresses_submenus2)
		{
			System.out.println("Submenus under DRESSES menu:"+ element.getAttribute("textContent"));
		}
		Log.info("Submenus of 'Women->Dresses are printed");
		Util.mouseHoverAction(driver, HomePage.HeaderPage.dresses_subMenu.casualDresses_subMenu(driver));
		System.out.println("Tooltip text of Casual Dresses:"+HomePage.HeaderPage.dresses_subMenu.casualDresses_subMenu(driver).getAttribute("textContent"));
		Util.mouseHoverAction(driver, HomePage.HeaderPage.dresses_subMenu.eveningDresses_subMenu(driver));
		System.out.println("Tooltip text of Evening Dresses:"+HomePage.HeaderPage.dresses_subMenu.eveningDresses_subMenu(driver).getAttribute("textContent"));
		Util.mouseHoverAction(driver, HomePage.HeaderPage.dresses_subMenu.summerDresses_subMenu(driver));
		System.out.println("Tooltip text of Summer Dresses:"+HomePage.HeaderPage.dresses_subMenu.summerDresses_subMenu(driver).getAttribute("textContent"));
		Log.info("Tooltip texts of Women->Tops submenus printed");
		Util.mouseHoverAction(driver, HomePage.HeaderPage.tShirtsMenu(driver));
		String tooltip3=HomePage.HeaderPage.tShirtsMenu(driver).getText();
		System.out.println("Tooltip text of T_SHIRTS menu:"+tooltip3);
		Assert.assertEquals("T-SHIRTS", tooltip3);
		Log.info("Tooltip text of T-SHIRTS menu verified");
		driver.navigate().refresh();
		FluentWait<WebDriver> fwait=Util.waitForElementFluentWait(driver);
	    Util.mouseHoverAction(driver,HomePage.HeaderPage.womenMenu(driver));
		fwait.until(ExpectedConditions.elementToBeClickable(HomePage.HeaderPage.tops_subMenu.tShirt_subMenu(driver)));
	    HomePage.HeaderPage.tops_subMenu.tShirt_subMenu(driver).click();
		Assert.assertEquals(CatalogPage.PhotoFrame.frameHeaderText(driver).getText().trim(), "T-shirts");
		Assert.assertEquals(CatalogPage.PhotoFrame.photoFrameTextLine1(driver).getText().contains("take a look"), true);
		Assert.assertEquals(CatalogPage.PhotoFrame.photoFrameTextLine2(driver).getText().contains("shapes and style"), true);
		Log.info("T-shirts photo frame text under Catalog page verified");
		CatalogPage.homeIcon(driver).click();
		Util.mouseHoverAction(driver, HomePage.HeaderPage.womenMenu(driver));
		fwait.until(ExpectedConditions.elementToBeClickable(HomePage.HeaderPage.tops_subMenu.blouses_subMenu(driver)));
		HomePage.HeaderPage.tops_subMenu.blouses_subMenu(driver).click();
		Assert.assertEquals(CatalogPage.PhotoFrame.frameHeaderText(driver).getText().trim(), "Blouses");
		Assert.assertEquals(CatalogPage.PhotoFrame.photoFrameText(driver).getText().contains("favorites blouses"), true);
		Log.info("Blouses photo frame text under Catalog page verified");
		CatalogPage.homeIcon(driver).click();
		Util.mouseHoverAction(driver, HomePage.HeaderPage.dressesMenu(driver));
		fwait.until(ExpectedConditions.elementToBeClickable(HomePage.HeaderPage.dresses_subMenu.casualDresses_subMenu(driver)));
		HomePage.HeaderPage.dresses_subMenu.casualDresses_subMenu(driver).click();
		Assert.assertEquals(CatalogPage.PhotoFrame.frameHeaderText(driver).getText().trim(), "Casual Dresses");
		Assert.assertEquals(CatalogPage.PhotoFrame.photoFrameTextLine1(driver).getText().contains("dress for every day"), true);
		Assert.assertEquals(CatalogPage.PhotoFrame.photoFrameTextLine2(driver).getText().contains("selection of dresses"), true);
		Log.info("Casual Dresses photo frame text under Catalog page verified");
		CatalogPage.homeIcon(driver).click();
		Util.mouseHoverAction(driver, HomePage.HeaderPage.dressesMenu(driver));
		fwait.until(ExpectedConditions.elementToBeClickable(HomePage.HeaderPage.dresses_subMenu.eveningDresses_subMenu(driver)));
		HomePage.HeaderPage.dresses_subMenu.eveningDresses_subMenu(driver).click();
		Assert.assertEquals(CatalogPage.PhotoFrame.frameHeaderText(driver).getText().trim(), "Evening Dresses");
		Assert.assertEquals(CatalogPage.PhotoFrame.photoFrameText(driver).getText().contains("unforgettable evening"), true);
		Log.info("Evening Dresses photo frame text under Catalog page verified");
		CatalogPage.homeIcon(driver).click();
		Util.mouseHoverAction(driver, HomePage.HeaderPage.dressesMenu(driver));
		fwait.until(ExpectedConditions.elementToBeClickable(HomePage.HeaderPage.dresses_subMenu.summerDresses_subMenu(driver)));
		HomePage.HeaderPage.dresses_subMenu.summerDresses_subMenu(driver).click();
		Assert.assertEquals(CatalogPage.PhotoFrame.frameHeaderText(driver).getText().trim(), "Summer Dresses");
		Assert.assertEquals(CatalogPage.PhotoFrame.photoFrameText(driver).getText().contains("long dress, silk dress"), true);
		Log.info("Summer Dresses photo frame text under Catalog page verified");
		CatalogPage.homeIcon(driver).click();
		Assert.assertTrue(HomePage.autoPracTxt(driver).getText(), true);
	 }
  catch(Exception ex)
  {
	  Util.takeScreenShot(driver, Thread.currentThread().getStackTrace()[1].getClassName());
	  ex.printStackTrace();
	  System.out.println(ex);
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
