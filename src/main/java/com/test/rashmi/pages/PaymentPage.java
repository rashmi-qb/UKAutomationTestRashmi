package com.test.rashmi.pages;

import org.openqa.selenium.JavascriptExecutor;

import cucumber.api.java.en.Given;

public class PaymentPage extends BasePage {
	private static final String PAYBYCHECK_BUTTON = "//a[@title=\"Pay by check.\"]";
	
	public OrderSummaryPage clickOnPayByCheck() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,600)", "");
		waitFor(PAYBYCHECK_BUTTON).$(PAYBYCHECK_BUTTON).click();
		System.out.println("Clicked on PayByCheck button of Payment page");
		return this.switchToPage(OrderSummaryPage.class);
	}
}
