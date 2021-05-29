package com.test.rashmi.pages;

import org.openqa.selenium.JavascriptExecutor;

import cucumber.api.java.en.Given;

public class ShippingPage extends BasePage {
	
	private static final String AGREETERMSCONDITION_CHECKBOX = "//div[@class=\"checker\"]//span";
	private static final String PROCEEDTOCHECKOUT_BUTTON = "//*[@name=\"processCarrier\"]";
	
	
	public ShippingPage clickOnTermsAndCondition() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,500)", "");
		waitFor(AGREETERMSCONDITION_CHECKBOX).$(AGREETERMSCONDITION_CHECKBOX).click();
		System.out.println("Clicked on Terms And Condition");
		return this;
	}
	
	
	public PaymentPage clickOnProceedToCheckout() {
		waitFor(PROCEEDTOCHECKOUT_BUTTON).$(PROCEEDTOCHECKOUT_BUTTON).click();
		System.out.println("Clicked on Proceed to checkout button of Shipping page");
		return this.switchToPage(PaymentPage.class);
	}
}
