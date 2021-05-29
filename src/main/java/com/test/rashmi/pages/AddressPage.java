package com.test.rashmi.pages;

import org.openqa.selenium.JavascriptExecutor;

import cucumber.api.java.en.Given;

public class AddressPage extends BasePage {
	
private static final String PROCEEDTOCHECKOUT_BUTTON = "//button[@class=\"button btn btn-default button-medium\"]";
			
	public ShippingPage clickOnProceedToCheckout() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)", "");
//		js.executeScript("document.getElementsByName('processAddress')[0].click();", "");
		waitFor(PROCEEDTOCHECKOUT_BUTTON).$(PROCEEDTOCHECKOUT_BUTTON).click();
		System.out.println("Clicked on Proceed to checkout button of Address page");
		return this.switchToPage(ShippingPage.class);
	}
}
