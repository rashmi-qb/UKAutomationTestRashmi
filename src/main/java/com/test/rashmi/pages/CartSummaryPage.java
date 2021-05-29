package com.test.rashmi.pages;

import cucumber.api.java.en.Given;

public class CartSummaryPage extends BasePage {
	
	
	
	private static final String PROCEEDTOCHECKOUT_BUTTON = "//p[@class=\"cart_navigation clearfix\"]//a[@title=\"Proceed to checkout\"]";
		
	
	public AddressPage clickOnProceedToCheckoutOfCartSummary() {
		waitFor(PROCEEDTOCHECKOUT_BUTTON).$(PROCEEDTOCHECKOUT_BUTTON).click();
		System.out.println("Clicked on Proceed to checkout button of Cart Summary");
		return this.switchToPage(AddressPage.class);
	}

}
