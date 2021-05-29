package com.test.rashmi.cucumber.steps.serenity;

import com.test.rashmi.pages.AccountPage;
import com.test.rashmi.pages.AddressPage;
import com.test.rashmi.pages.BasePage;
import com.test.rashmi.pages.CartSummaryPage;
import com.test.rashmi.pages.HomePage;
import com.test.rashmi.pages.LoginPage;
import com.test.rashmi.pages.OrderHistoryPage;
import com.test.rashmi.pages.OrderSummaryPage;
import com.test.rashmi.pages.PaymentPage;
import com.test.rashmi.pages.PersonalInfoPage;
import com.test.rashmi.pages.ShippingPage;
import com.test.rashmi.pages.TshirtPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class TShirtSteps extends ScenarioSteps {

	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	TshirtPage tshirtPage;
	CartSummaryPage cartSummaryPage;
	ShippingPage shippingPage;
	AddressPage addressPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderHistoryPage orderHistoryPage;
	AccountPage accountPage;
	PersonalInfoPage personalInfoPage;

	@Step("I click on Signin Button from header")
	public LoginPage navigatetosigninpage() {
		return loginPage.clickOnSignInLink();
	}

	@Step("I add user {0} and {1} and click Signin button")
	public HomePage loginWithExistingUser(String emailid, String password) {
		return loginPage.loginWithExistingUser(emailid, password);
	}

	@Step("I click on category {0} link")
	public TshirtPage clickOnCategoryLink(String categorylink) {
		return homePage.clickOnCategoryLink(categorylink);
	}

	@Step("I Click on First Tshirt image")
	public TshirtPage clickOnFirtTshirtIcon() {
		return tshirtPage.clickOnFirtTshirtIcon();
	}

	@Step("I Click on AddToCart Button")
	public TshirtPage clickOnAddToCart() {
		return tshirtPage.clickOnAddToCart();
	}

	@Step("I Click on ProceedToCheckout Button of Tshirt Page")
	public CartSummaryPage clickOnProceedToCheckoutOfTshirtPage() {
		return tshirtPage.clickOnProceedToCheckoutOfTshirtPage();
	}

	@Step("I Click on ProceedToCheckout Button of Cart Summary")
	public AddressPage clickOnProceedToCheckoutOfCartSummary() {
		return cartSummaryPage.clickOnProceedToCheckoutOfCartSummary();
	}

	@Step("I Click on ProceedToCheckout Button of Address Page")
	public ShippingPage clickOnProceedToCheckoutOfAddressPage() {
		return addressPage.clickOnProceedToCheckout();
	}

	@Step("I Check on TermAndCondition Box of Shipping Page")
	public ShippingPage clickOnTermsAndConditionOfShippingPage() {
		return shippingPage.clickOnTermsAndCondition();
	}

	@Step("I Click on ProceedToCheckout Button of Shipping Page")
	public PaymentPage clickOnProceedToCheckoutOfShippingPage() {
		return shippingPage.clickOnProceedToCheckout();
	}

	@Step("I Click on ProceedToCheckout Button of Shipping Page")
	public OrderSummaryPage clickOnPayByCheckOfPaymentPage() {
		return paymentPage.clickOnPayByCheck();
	}

	@Step("I Click on IConfirmMyOrder Button of Order Summary Page")
	public OrderHistoryPage clickOnIConfirmMyOrderButton() {
		return orderSummaryPage.clickOnIConfirmMyOrderButton();
	}

	@Step("I Verify Order Name on Order History Page")
	public OrderHistoryPage verifyPurchedOrderInHistory(String expectedTname) {
		return orderHistoryPage.verifyPurchedOrderInHistory(expectedTname);
	}

	@Step("I Verify Order Name on Order History Page")
	public AccountPage clickOnAccountPage() {
		return homePage.clickOnAccountPage();
	}

	@Step("I Click on My Personal Infomation Page")
	public PersonalInfoPage clickOnMyPersonalInfomation() {
		return accountPage.clickOnMyPersonalInfomation();
	}

	@Step("I Changed Users {0} on Personal Page")
	public PersonalInfoPage enterFirstNameInPersonalInfoPage(String firstName) {
		return personalInfoPage.fillFirstName(firstName);
	}

	@Step("I Entered {0} as required field on Personal Page")
	public PersonalInfoPage enterOldPasswordInPersonalInfoPage(String password) {
		return personalInfoPage.fillOldPassword(password);
	}

	@Step("I Sumbmit Updated Personal info form")
	public HomePage clickOnSaveButtonOfPersonalInfoPage() {
		return personalInfoPage.clickOnSaveButton();
	}

	@Step("I Verify Updated {0} Users First Name")
	public HomePage verifyUpdatedFirstNameOnHomePage(String expectedFirstName) {
		return homePage.verifyUpdatedFirstNameOnTopRightCorner(expectedFirstName);
	}
}
