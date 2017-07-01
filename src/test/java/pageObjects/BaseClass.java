package pageObjects;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import utility.Constants;
import utility.Log;
public class BaseClass {
	public static WebDriver driver;
	public static String driverPath=Constants.chrome_driver_path;
	public BaseClass(WebDriver driver)
	{
		BaseClass.driver=driver;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setBrowser(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath);
	//System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Selenium 2.53 related\\chromedriver.exe");
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setBinary("E:\\Softwares\\Selenium 2.53 related\\chrome64_53.0.2785.116\\chrome.exe");
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		File pathBinary = new File("C:\\program files\\Mozilla Firefox (x86)\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
    public void closeBrowser()
    {
    	driver.close();
    	Log.info("Driver session closed");
    }
}
