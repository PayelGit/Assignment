package com.eccomerce.genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;


/**
 * 
 * @author Payel
 *
 */
@Listeners(com.eccomerce.genericlib.Listener.class)
public class BaseClass implements IAutoConstants, IFilePaths {
	/* create an object for excel library */
	public static WebDriver driver;
	
	public EventFiringWebDriver edr;
	
	/**
	 * Initializing reports
	 * @throws Throwable 
	 */
	@BeforeSuite
	public void configBeforeSuite() throws Throwable {
		ExtentReportLib.extentInit();
	}

	/**
	 * Launch the selected browser
	 * @throws Throwable
	 */
	@BeforeTest
	public void configBeforeTest() throws Throwable {
		/* Get the url and type of browser from runtime parameters */
		
		String browser = ExcelLib.getProperty(PROP, "browser");
		

		if (browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		} 
		else if (browser.equals("chrome"))
		{

			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		edr = new EventFiringWebDriver(driver);
		
	}

	
	/**
	 * Close the browser
	 */
	@AfterTest
	public void configAfterTest() {
		driver.quit();
	}

	/**
	 * 
	 * Appends the report HTML file with all the test results and 
	 * closes the underlying stream
	 * Kills driver executable instances
	 * @throws Throwable 
	 */
	@AfterSuite
	public void configAfterSuite() throws Throwable {
		Runtime.getRuntime().exec("taskkill -im chromedriver.exe /f");
		Runtime.getRuntime().exec("taskkill -im geckodriver.exe /f");
	}
}
