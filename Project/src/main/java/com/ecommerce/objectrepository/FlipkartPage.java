package com.ecommerce.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.eccomerce.genericlib.CommonLibrary;
import com.eccomerce.genericlib.ExcelLib;
import com.eccomerce.genericlib.IFilePaths;

/**
 * 
 * @author Payel
 *
 */
public class FlipkartPage implements IFilePaths
{
	public FlipkartPage(WebDriver driver) throws Throwable
	{
		driver.get(ExcelLib.getProperty(PROP, "urlFlipkart"));
		PageFactory.initElements(driver, this);
		this.driver = driver;
		common = new CommonLibrary(driver);	
	}

	private WebDriver driver;
	CommonLibrary common;
	
	@FindBy(xpath = "//button[text()='✕']")
	private WebElement closeBtn;
	
	@FindBy(name="q")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//div[text()='Apple iPhone XR (Yellow, 64 GB)']/../following-sibling::div/div/div/div")
	private WebElement flipkartAppleIphonePrice;
	
	
	/**
	 * capture price 
	 * @author Payel
	 * @return 
	 * @throws Throwable
	 **/
	
	public int capturePrice() throws Throwable
	{
		closeBtn.click();
		searchBtn.sendKeys(ExcelLib.getData(EXCEL,"Sheet1", 2, 0),Keys.ENTER);
		int flipkartprice = Integer.parseInt(flipkartAppleIphonePrice.getText().replace(",", "").replace("₹", ""));
		return flipkartprice;
	}
	
	
	
	
	
}
