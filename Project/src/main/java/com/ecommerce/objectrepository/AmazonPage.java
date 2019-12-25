package com.ecommerce.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/**
 * 
 * @author Payel
 *
 */
import com.eccomerce.genericlib.CommonLibrary;
import com.eccomerce.genericlib.ExcelLib;
import com.eccomerce.genericlib.ExtentReportLib;
import com.eccomerce.genericlib.IFilePaths;

public class AmazonPage implements IFilePaths
{
	public WebDriver getDriver()
	{
		return driver;
	}

	private WebDriver driver;
	

	CommonLibrary common;
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchBox;
	@FindBy(xpath = "//span[text()='Apple iPhone XR (64GB) - Yellow']/../../../../../../..//span[@class='a-price-whole']")
	private WebElement amazonPrice;
	public WebElement getAmazonPrice()
	{
		return amazonPrice;
	}

	/**
	 * Initiate xpatham driver
	 * @author Payel
	 * @throws Throwable 
	 */
	public AmazonPage(WebDriver driver) throws Throwable
	{
		driver.get(ExcelLib.getProperty(PROP, "urlAmazon"));
		PageFactory.initElements(driver, this);
		this.driver = driver;
		common = new CommonLibrary(driver);	
	}
	
	public WebElement getSearchBox() 
	{
		return searchBox;
	}
	
	/**
	 * capture price 
	 * @author Payel
	 * @throws Throwable
	 **/
	public int captureAmazonprice() throws Throwable
	{
		searchBox.sendKeys(ExcelLib.getData(EXCEL,"Sheet1", 1, 0),Keys.ENTER);
		int amazonprice = Integer.parseInt(amazonPrice.getText().replace(",", ""));
		return amazonprice;
	}

	
	
	
	
	
	
	
	
	
}
