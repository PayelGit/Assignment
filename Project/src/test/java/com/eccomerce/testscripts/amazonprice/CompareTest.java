package com.eccomerce.testscripts.amazonprice;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.eccomerce.genericlib.BaseClass;
import com.ecommerce.objectrepository.AmazonPage;
import com.ecommerce.objectrepository.FlipkartPage;

public class CompareTest extends BaseClass
{
	@Test
	public void comparePriceTest() throws Throwable {
	
	/* Navigating to Amazon */
	AmazonPage amazon = new AmazonPage(BaseClass.driver);
	
	/* search the product and get the price of a product */
	int amazonPrice = amazon.captureAmazonprice();
	
	/* navigating to flipkart */
	FlipkartPage flipkart = new FlipkartPage(BaseClass.driver);
	
	/*search the product and  get the price of a product */
	int flipkartPrice = flipkart.capturePrice();
	
	/* Compare the price from amazon and flipkart and display it in console */
	if(amazonPrice > flipkartPrice)
	{
		Reporter.log("Flipkart has Lesser Price than Amazon", true);
		Reporter.log("Price : "+flipkartPrice, true);
	}
	else if (amazonPrice < flipkartPrice) 
	{
		Reporter.log("Amazon has Lesser Price than flipkart", true);
		Reporter.log("Price : "+amazonPrice, true);
	}
	else
	{
		Reporter.log("Amazon and Flipkart Both have same price", true);
	}
	
	
}
	
}
