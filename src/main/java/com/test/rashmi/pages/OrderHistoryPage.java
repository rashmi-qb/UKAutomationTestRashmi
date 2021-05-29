package com.test.rashmi.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import cucumber.api.java.en.Given;

public class OrderHistoryPage extends BasePage {
	
			
	private static final String ACCOUNT_LINK = "//a[@class=\"account\"]";		
	private static final String ORDER_BUTTON = "//a[@title=\"Orders\"]";
	private static final String DETAIL_BUTTON = "(//td[@class=\"history_detail footable-last-column\"]//*[@class=\"btn btn-default button button-small\"])[1]";
	private static final String ACTUALPRODUCTNAME_BUTTON = "(//tbody//tr[@class=\"item\"])[1]//td[@class=\"bold\"]//label";
	
	
	public OrderHistoryPage verifyPurchedOrderInHistory(String expectedTname) {
		
		waitFor(ACCOUNT_LINK).$(ACCOUNT_LINK).click();
		System.out.println("Clicked on accounts page");
		
		waitFor(ORDER_BUTTON).$(ORDER_BUTTON).click();
		System.out.println("Clicked on Order History button");
				
		waitFor(DETAIL_BUTTON).$(DETAIL_BUTTON).click();
		System.out.println("Clicked on Details from order History page");
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,800)", "");
		
		waitForTextToAppear("Faded Short Sleeve T-shirts - Color : Orange, Size : S");
		
		Assert.assertTrue(waitFor(ACTUALPRODUCTNAME_BUTTON).$(ACTUALPRODUCTNAME_BUTTON).getText().trim().contains(expectedTname),  "[Assert Failed]: Product is not appearing in order History page.");
		System.out.println("[Assert Passed: Product is appearing in order History page. Product is: "+waitFor(ACTUALPRODUCTNAME_BUTTON).$(ACTUALPRODUCTNAME_BUTTON).getText()+" and expected : "+expectedTname);

		return this;
	}
	
}
