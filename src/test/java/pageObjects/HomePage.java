package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseClass
{
   private static WebElement element=null;
	public HomePage(WebDriver driver) {
		super(driver);
		//this.driver=driver;
	}
    private static By signIn=By.xpath(".//a[@class='login']");
   private static By contactUs=By.linkText("Contact us");
    private static By signOut=By.linkText("Sign out");
    public static WebElement signIn_btn(WebDriver driver)
    {
    	return element=driver.findElement(signIn);
    }
    public static WebElement signOut_btn(WebDriver driver)
    {
    	return element=driver.findElement(signOut);
    }
    public static WebElement contactUs(WebDriver driver)
    {
    	return element=driver.findElement(contactUs);
    }
    public final static WebElement userInfo(WebDriver driver)
    {
    	//return element=driver.findElement(By.xpath(".//div[@class='header_user_info']/a/span"));
    	return element=driver.findElement(By.cssSelector(".account"));
    }
    public final static WebElement homePageLogo(WebDriver driver)
    {
    	return element=driver.findElement(By.xpath(".//*[@id='header_logo']/a/img"));
    }
    public static class BottomPage
    {
    public final static WebElement newsLetterEmailField(WebDriver driver)
    {
    	return element=driver.findElement(By.id("newsletter-input"));
    }
    public final static WebElement newsLetterSubmitBtn(WebDriver driver)
    {
    	return element=driver.findElement(By.name("submitNewsletter"));
    }
    public final static WebElement newsLetterErrorMsg(WebDriver driver)
    {
    	return element=driver.findElement(By.xpath(".//*[@id='columns']/p"));
    }
    public final static WebElement newsLetterSuccessMsg(WebDriver driver)
    {
    	return element=driver.findElement(By.xpath(".//*[@id='columns']/p"));
    }
    public final static WebElement termsAndConditionLink(WebDriver driver)
    {
    	return element=driver.findElement(By.xpath(".//*[@id='block_various_links_footer']/ul/li[6]"));
    }
    }
    public static class Terms_Conditions
    {
    	public final static WebElement pageHeaderTxt(WebDriver driver)
    	{
    		return element=driver.findElement(By.xpath(".//*[@id='center_column']/div/h1"));
    	}
    	public final static WebElement pageRule1Txt(WebDriver driver)
    	{
    		return element=driver.findElement(By.xpath(".//*[@id='center_column']/div/p[1]"));
    	}
    	public final static WebElement pageRule2Txt(WebDriver driver)
    	{
    		return element=driver.findElement(By.xpath(".//*[@id='center_column']/div/p[2]"));
    	}
    	public final static WebElement pageRule3Txt(WebDriver driver)
    	{
    		return element=driver.findElement(By.xpath(".//*[@id='center_column']/div/p[3]"));
    	}
    }
    public static class HeaderPage
    {
    	public final static WebElement womenMenu(WebDriver driver)
    	{
    		//return element=driver.findElement(By.linkText("Women"));
    		return element=driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[1]/a"));
    	}
    	public final static WebElement dressesMenu(WebDriver driver)
    	{
    		//return element=driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[2]/a"));
    		return element=driver.findElement(By.linkText("DRESSES"));
    	}
    	public final static WebElement tShirtsMenu(WebDriver driver)
    	{
    		return element=driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a"));
    	}
        public static class tops_subMenu
        {
        	public final static WebElement tShirt_subMenu(WebDriver driver)
        	{
        		return element=driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a"));
        	}
        	public final static WebElement blouses_subMenu(WebDriver driver)
        	{
        		return element=driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[2]/a"));
        	}
        }
        public static class dresses_subMenu
        { 
        	public final static WebElement casualDresses_subMenu(WebDriver driver)
        	{
        		return element=driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[2]/ul/li[1]/a"));
        	}
        	public final static WebElement eveningDresses_subMenu(WebDriver driver)
        	{
        		return element=driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[2]/ul/li[2]/a"));
        	}
        	public final static WebElement summerDresses_subMenu(WebDriver driver)
        	{
        		return element=driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[2]/ul/li[3]/a"));
        	}
        }
    }
     public final static WebElement searchField(WebDriver driver)
     {
    	 return element=driver.findElement(By.id("search_query_top"));
     }
     public final static WebElement searchBtn(WebDriver driver)
     {
    	 return element=driver.findElement(By.name("submit_search"));
     }
     public final static WebElement cartBtn(WebDriver driver)
     {
    	 return element=driver.findElement(By.xpath(".//*[@id='header']/div[3]/div/div/div[3]/div/a"));
     }
     public final static WebElement homeIcon(WebDriver driver)
     {
    	 return element=driver.findElement(By.cssSelector(".home"));
     }
     public final static WebElement autoPracTxt(WebDriver driver)
     {
    	 return element=driver.findElement(By.xpath(".//div[@id='editorial_block_center']/h1"));
     }
}