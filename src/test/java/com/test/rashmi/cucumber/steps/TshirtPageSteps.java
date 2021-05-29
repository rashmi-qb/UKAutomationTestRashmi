package com.test.rashmi.cucumber.steps;

import com.test.rashmi.cucumber.steps.serenity.TShirtSteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class TshirtPageSteps {

	@Steps
	TShirtSteps user;
	String expectedTshirtName = "Faded Short Sleeve T-shirts";
	

	@Given("I click on Signin Button from header")
	public void I_click_on_sign_in_Button_from_header() {
		user.navigatetosigninpage();
	}
	
	@When("I add user (.*) and (.*) and click Signin button")
	public void I_add_email_and_password(String emailId, String password)throws PendingException, InterruptedException
	{
		user.loginWithExistingUser(emailId, password);
	}
	
	@Then("I click on category (.*) link")
	public void I_click_on_Category_Button(String categorylink) {
		user.clickOnCategoryLink(categorylink);
	}
				
	@Then("I Click on First Tshirt image")
	public void I_click_on_First_Tshirt_Image() {
		user.clickOnFirtTshirtIcon();
	}
		
	@Then("I Click on AddToCart Button")
	public void I_click_on_addToCart() {
		user.clickOnAddToCart();
	}
		
	@Then("I Click on ProceedToCheckout Button of Tshirt Page")
	public void I_click_on_ProceedToCheckout_Of_Tshirt_Page() {
		user.clickOnProceedToCheckoutOfTshirtPage();
	}
	
	@Then("I Click on ProceedToCheckout Button of Cart Summary")
	public void I_click_on_ProceedToCheckout_Of_Cart_Summary() {
		user.clickOnProceedToCheckoutOfCartSummary();
	}
	
	@Then("I Click on ProceedToCheckout Button of Address Page")
	public void I_click_on_ProceedToCheckout_Of_Address_Page() {
		user.clickOnProceedToCheckoutOfAddressPage();
	}
	
	@Then("I Check on TermAndCondition Box of Shipping Page")
	public void I_click_On_TermsAndCondition_Of_Shipping_Page() {
		user.clickOnTermsAndConditionOfShippingPage();
	}
	
	@Then("I Click on ProceedToCheckout Button of Shipping Page")
	public void I_click_On_ProceedToCheckout_Of_Shipping_Page() {
		user.clickOnProceedToCheckoutOfShippingPage();
	}
	
	@Then("I Click on PayByCheck Button of Payment Page")
	public void I_Click_On_PayByCheck_Of_Payment_Page() {
		user.clickOnPayByCheckOfPaymentPage();
	}
	
	@Then("I Click on IConfirmMyOrder Button of Order Summary Page")
	public void I_Click_On_IConfirmMyOrder_Button_Of_OrderSummary_Page() {
		user.clickOnIConfirmMyOrderButton();
	}
	
	@Then("I Verify Order Name on Order History Page")
	public void I_Verify_Order_Name_On_Order_History_Page() {
		user.verifyPurchedOrderInHistory(expectedTshirtName);
	}
	
	/*
	 * @Then("I get Expected Tshirt Name from Tshirt Page") public void
	 * I_Get_Expected_Tshit_Name_From_TshirtPage() { expectedTshirtName =
	 * user.getexpectedTshirtName(); }
	 */
	
}




