package com.test.rashmi.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollToBy;
import net.serenitybdd.screenplay.actions.ScrollToTarget;
import net.serenitybdd.screenplay.actions.ScrollToWebElement;

public class TshirtPage extends BasePage {

	private static final String CATEGORY_LINK_A = "//*[@title='";
	private static final String CATEGORY_LINK_B = "']";
	private static final String TSHIRT_NAME = "//a[@title=\"Faded Short Sleeve T-shirts\"]";
	private static final String TSHIRT_IMAGE = "//a[@class=\"product_img_link\"]";
	private static final String ADDTOCART_BUTTON = " //p[@id=\"add_to_cart\"]//button";
	private static final String PROCEEDTOCHECKOUT_BUTTON = "//*[@title=\"Proceed to checkout\"]";
	
	

	public TshirtPage clickOnCategoryLink(String categorylink) {
		String category = CATEGORY_LINK_A + categorylink + CATEGORY_LINK_B;
		waitFor(category).$(category).click();
		System.out.println("Clicked on " + categorylink + " button");
		return this.switchToPage(TshirtPage.class);
	}

	public String getTshirtName() {
		String expectedTshirtname = waitFor(TSHIRT_NAME).$(TSHIRT_NAME).getText(); 
		return expectedTshirtname;
	}
	
	
	public TshirtPage clickOnFirtTshirtIcon() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,250)", "");

		waitFor(TSHIRT_IMAGE).$(TSHIRT_IMAGE).click();
		System.out.println("Clicked on tshirt image");
		return this;
	}

	public TshirtPage clickOnAddToCart() {
		waitFor(ADDTOCART_BUTTON).$(ADDTOCART_BUTTON).click();
		System.out.println("Clicked on Add To cart Button");
		return this;
	}

	public CartSummaryPage clickOnProceedToCheckoutOfTshirtPage() {
		waitFor(PROCEEDTOCHECKOUT_BUTTON).$(PROCEEDTOCHECKOUT_BUTTON).click();
		System.out.println("Clicked on Proceed to Checkout Button of Tshirt");
		return this.switchToPage(CartSummaryPage.class);
	}
}
