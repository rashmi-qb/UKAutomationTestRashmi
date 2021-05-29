package com.test.rashmi.pages;

import org.openqa.selenium.JavascriptExecutor;

import cucumber.api.java.en.Given;

public class OrderSummaryPage extends BasePage {
	
private static final String ICONFIRMMYORDER_BUTTON = "//button[@class=\"button btn btn-default button-medium\"]";
			
	public OrderHistoryPage clickOnIConfirmMyOrderButton() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,700)", "");
		waitFor(ICONFIRMMYORDER_BUTTON).$(ICONFIRMMYORDER_BUTTON).click();
		System.out.println("Clicked on I confirm my Order Button form order summary page");
		waitForTextToAppear("Your order on My Store is complete.");
		return this.switchToPage(OrderHistoryPage.class);
	}
}

