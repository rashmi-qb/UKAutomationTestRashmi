package com.test.rashmi.cucumber.steps.serenity;


import java.io.IOException;

import com.test.rashmi.pages.AccountPage;
import com.test.rashmi.pages.AddressPage;
import com.test.rashmi.pages.BasePage;
import com.test.rashmi.pages.CartSummaryPage;
// import com.test.rashmi.pages.DashBoardPage;
// import com.test.rashmi.pages.HelpPage;
import com.test.rashmi.pages.HomePage;
import com.test.rashmi.pages.LoginPage;
import com.test.rashmi.pages.OrderHistoryPage;
import com.test.rashmi.pages.OrderSummaryPage;
// import com.test.rashmi.pages.OrdersPage;
import com.test.rashmi.pages.PaymentPage;
import com.test.rashmi.pages.PersonalInfoPage;
//import com.test.rashmi.pages.ProductsPage;
//import com.test.rashmi.pages.ProfilePage;
//import com.test.rashmi.pages.PurchaseConfirmation;
//import com.test.rashmi.pages.PurchaseInfoPage;
//import com.test.rashmi.pages.PurchasePage;
import com.test.rashmi.pages.ShippingPage;
import com.test.rashmi.pages.TshirtPage;
import com.test.rashmi.utils.PetCategories;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class TShirtSteps extends ScenarioSteps {

	BasePage basePage;
	
//	AccountsPage accountPage;
//	DashBoardPage dashBoardPage;
//	ProductsPage productsPage;
//	OrdersPage ordersPage;
//	PurchaseInfoPage purchaseInfoPage;
//	PurchasePage purchasePage;
//	PurchaseConfirmation purchaseConfirmation;
//	ProfilePage profilePage;
	
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

	/************************************************************************************************
	 * **********************************************************************************************
	 * 
	 * BASE PAGE STEPS
	 * 
	 *************************************************************************************************
	 *************************************************************************************************/

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
	
	/*
	 * String expectedTName;
	 * 
	 * @Then("I get Expected Tshirt Name from Tshirt Page") public String
	 * getexpectedTshirtName() { expectedTName = tshirtPage.getTshirtName(); return
	 * expectedTName; }
	 */

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
	public PersonalInfoPage enterLastNameInPersonalInfoPage(String lastName) {
		return personalInfoPage.fillLastName(lastName);
	}

	@Step("I Entered {0} as required field on Personal Page")
	public PersonalInfoPage enterOldPasswordInPersonalInfoPage(String password) {
		return personalInfoPage.fillOldPassword(password);
	}
	
	@Step("I Sumbmit Updated Personal info form")
	public HomePage clickOnSaveButtonOfPersonalInfoPage() {
		return personalInfoPage.clickOnSaveButton();
	}
	
	@Step("I Verify Updated {0} Users Last Name")
	public HomePage verifyUpdatedLastNameOnHomePage(String expectedLastName) {
		return homePage.verifyUpdatedLastNameOnTopRightCorner(expectedLastName);
	}
	


	
	
	
	
	
//	
//	
//
//	@Step("Signing out from the store")
//	public DashBoardPage signOut() {
//
//		return basePage.signOut();
//	}
//
//	//	@Step("Navigating to Login Page")
//	//	public LoginPage navigateToLoginPage() {
//	//
//	//		return basePage.navigateToSignOnPage();
//	//	}
//
//	@Step("Navigating to products page by cliking on : {0} link on header")
//	public ProductsPage navigateToProductCategory(PetCategories productCategory) {
//
//		return basePage.navigateToProductCategory(productCategory);
//	}
//
//	@Step("Navigating to Products Page by clicking on shopping cart")
//	public ProductsPage navigateToShoppingCartPage() {
//
//		return basePage.navigateToShoppingCart();
//	}
//
//	@Step("Navigating to Help Page")
//	public HelpPage navigateToHelpPage() {
//
//		return basePage.navigateToHelpPage();
//	}
//
//	@Step("Clicking on Company Logo & navigating to the DashBoard")
//	public DashBoardPage navigateToDashBoard() {
//
//		return basePage.navigateToDashBoard();
//	}
//
//	@Step("Navigating to Accounts Page")
//	public AccountsPage navigateToMyAccountsPage() {
//
//		return basePage.navigateToAccountPage();
//	}
//
//	@Step("Searching for product: {0}")
//	public ProductsPage searchForProduct(String productName) {
//
//		return basePage.searchForProduct(productName);
//	}
//
//
//	/************************************************************************************************
//	 * **********************************************************************************************
//	 * 
//	 * LOGIN PAGE STEPS
//	 * 
//	 *************************************************************************************************
//	 *************************************************************************************************/
//	//
//	//	@Step("Getting Invalid Login Message")
//	//	public String getMessageOnInvalidLogin() {
//	//
//	//		return loginPage.getMessageOnInvalidLogin();
//	//	}
//	//
//	//	@Step("Navigating to user registration page")
//	//	public AccountsPage navigateToRegistrationPage() {
//	//
//	//		return loginPage.navigateToRegistrationPage();
//	//	}
//	//
//	//	@Step("Logging into the application with userName: {0} & passsword: {1}")
//	//	public DashBoardPage doLogin(String userName, String password) {
//	//
//	//		basePage.clickSignOnLink();
//	//		return loginPage.doLogin(userName, password);
//	//	}
//
//
//	/************************************************************************************************
//	 * **********************************************************************************************
//	 * 
//	 * ACCOUNT PAGE STEPS
//	 * 
//	 *************************************************************************************************
//	 *************************************************************************************************/
//
//
//	@Step("Adding new user information with userName: {0} ,password: {1} , repeatPassword: {2}")
//	public AccountsPage addNewUserInformation(String userName , String password 
//			, String repeatPassword) {
//
//		return accountPage.addNewUserInformation(userName, password, repeatPassword);
//	}
//
//
//	@Step("Adding account information- firstname:{0} , lastName:{1}," +
//			" email:{2}, phone:{3}, addr1:{4}, addr2: {5}, city:{6}, "  +
//			"state:{7}, zip:{8}, country:{9} ")
//	public AccountsPage addAccountInformation(String firstName , 
//			String lastName , 
//			String email ,
//			String phone ,
//			String addr1 , 
//			String addr2 ,
//			String city ,
//			String state , 
//			String zip ,
//			String country) {
//
//
//		return accountPage.addAccountInformation(firstName,
//				lastName, 
//				email, 
//				phone, 
//				addr1, 
//				addr2, 
//				city, 
//				state, 
//				zip, 
//				country);
//	}
//
//	@Step("Adding profile information - language:{0} ,category: {1} ,myList: {2} ,myBanner:{3}")
//	public AccountsPage addProfileInformation(String language, 
//			String category , 
//			boolean myList , 
//			boolean myBanner) {
//
//		return accountPage.addProfileInformation(language, 
//				category, 
//				myList, 
//				myBanner);	
//	}
//
//	@Step("Saving account information")
//	public DashBoardPage clickSaveAccountInformation() {
//
//		return accountPage.clickSaveAccountInformation();
//
//	}
//
//
//	/************************************************************************************************
//	 * **********************************************************************************************
//	 * 
//	 * DASHBOARD PAGE STEPS
//	 * 
//	 *************************************************************************************************
//	 *************************************************************************************************/
//
//	@Step("Getting the greeting message")
//	public String getGreetingMessage() {
//
//		return dashBoardPage.getGreetingMessage();
//	}
//
//	@Step("Selecting {0} petcatgory form center display")
//	public ProductsPage selectProductFromCenterDisplay(PetCategories petCategories) {
//
//		return dashBoardPage.selectProductFromCenterDisplay(petCategories);
//	}
//
//	@Step("Selecting {0} petcatgory form side bar")
//	public ProductsPage selectProductFromSideBar(PetCategories petCategories) {
//
//		return dashBoardPage.selectProductFromSideBarDisplay(petCategories);
//	}
//
//
//	/************************************************************************************************
//	 * **********************************************************************************************
//	 * 
//	 * PRODUCTS PAGE STEPS
//	 * 
//	 *************************************************************************************************
//	 *************************************************************************************************/
//
//	@Step("Selecting a pet with petcategory:{0} , and petName:{1}")
//	public ProductsPage selectPetByName( PetCategories petcategory , String petName) {
//
//		return productsPage.selectPetByName(petcategory, petName);
//	}
//
//	@Step("Adding {0} to the shopping cart")
//	public ProductsPage addToCartSpecificProduct(String specificProductName) {
//
//		return productsPage.addToCartSpecificProduct(specificProductName);
//	}
//
//
//	@Step("Selecting pet {0} by viewing details and adding it to cart")
//	public ProductsPage addToCartByViewingItemDetails( String specificProduct ,
//			String...details ) {
//
//		return productsPage.addToCartByViewingItemDetails(specificProduct, details);
//	}
//
//	@Step("Selecting {0} from the search results")
//	public ProductsPage selectProductFromSearchTable( String productName) {
//
//		return productsPage.selectProductFromSearchTable(productName);
//	}
//
//	@Step("Interacting with the shopping cart")
//	public ProductsPage shoppingCart( String productDescription ,  int quantity) {
//
//		return productsPage.shoppingCart(productDescription, quantity);
//	}
//
//	@Step("Remove item {0} from shopping cart")
//	public boolean removeItemFromCart(String productName ) {
//
//		return productsPage.removeItemFromCart(productName);
//	}
//
//	@Step("Click on Proceed to checkout")
//	public OrdersPage clickOnProceedToCheckout() {
//
//		return productsPage.clickOnProceedToCheckout();
//	}
//
//
//	/************************************************************************************************
//	 * **********************************************************************************************
//	 * 	
//	 * ORDERS PAGE STEPS
//	 * 
//	 *************************************************************************************************
//	 *************************************************************************************************/
//	@Step("Entering purchase information & placing order")
//	public OrdersPage enterPaymentAndBillingDetails(String cardType,
//			String cardNumber,
//			String expiryDate,
//			String firstname,
//			String lastname,
//			String addr1,
//			String addr2,
//			String city,
//			String state,
//			String zip,
//			String country){
//
//
//		return ordersPage.enterPaymentAndBillingDetails(cardType, 
//				cardNumber, 
//				expiryDate, 
//				firstname, 
//				lastname, 
//				addr1, 
//				addr2, 
//				city, 
//				state, 
//				zip, 
//				country);
//
//	}
//
//
//
//	@Step("Clicking on Ship to different checkbox" )
//	public OrdersPage clickShipToDifferentAddress() {
//
//		return ordersPage.clickShipToDifferentAddress();
//	}
//
//	@Step("Entering Shipping information")
//	public OrdersPage enterShippingInfo(String firstName , String lastName , String addr1
//			,String addr2,String city ,String state , String zip, String country){
//
//		return ordersPage.enterShippingInfo(firstName, lastName, addr1, addr2, city, 
//				state, zip, country);
//	}
//
//	@Step("Clicking on Continue Button")
//	public OrdersPage clickOnContinueBtn(){
//
//		return ordersPage.clickOnContinueBtn();
//	}
//
//	@Step("Clicking on Confirm button")
//	public OrdersPage clickOnConfirmBtn(){
//
//		return ordersPage.clickOnConfirmBtn();
//	}
//
//	@Step("Verify if order has been placed")
//	public void verifyIfOrderSubmitted(){
//
//		ordersPage.verifyIfOrderSubmitted();
//	}
//
//	/*********************** KPLUS Base Page******************/
//
//
//	@Step("Navigating to Purchase Login Page")
//	public PurchaseInfoPage navigateToPurchaseInfoPage() {
//
//		return basePage.navigateToPurchaseInfoPage();
//	}
//
//
//
//
////	@Step("I add user email id and password and click Signin button")
////
////	public ProfilePage LoginwithValidUser()
////	{
////		return loginPage.LoginwithValidUser();
////	}
//
//	
////	/*********************Purchase Info Page Steps*******************/
//
//
//	@Step("Select {0} from Professional Category dropdown")
//
//	public PurchaseInfoPage selectProfessionalCategory(String category) {
//
//		return purchaseInfoPage.selectProfessionalCategory(category);
//	}
//
//	@Step("Price of category {0} is {1}")
//
//	public String getPrice(String category, String expectedPrice) {
//
//		return purchaseInfoPage.getPrice(category, expectedPrice);
//	}
//
//	@Step("Select {0} checkbox")
//
//	public PurchaseInfoPage selectCheckbox(String category) {
//		return purchaseInfoPage.selectCheckbox(category);
//	}
//
//	@Step ("I Select checkbox for indmodule (0)")
//	public void selectINDMODCheckbox(String indmod1, String indmod2, String indmod3, String indmod4 ) {
//		 purchaseInfoPage.selectINDMODCheckbox(indmod1);
//		 purchaseInfoPage.selectINDMODCheckbox(indmod2); 
//		 purchaseInfoPage.selectINDMODCheckbox(indmod3); 
//		 purchaseInfoPage.selectINDMODCheckbox(indmod4);
//		 
//		 
//	}
////	@Step ("I Select checkbox for indmodule (0)")
////	public PurchaseInfoPage selectINDMODCheckbox(String indmod) {
////		return purchaseInfoPage.selectINDMODCheckbox(indmod);
////	}
////	@Step ("I Select checkbox for indmodule (0)")
////	public PurchaseInfoPage selectINDMODCheckbox(String indmod) {
////		return purchaseInfoPage.selectINDMODCheckbox(indmod);
////	}
////	@Step ("I Select checkbox for indmodule (0)")
////	public PurchaseInfoPage selectINDMODCheckbox(String indmod) {
////		return purchaseInfoPage.selectINDMODCheckbox(indmod);
////	}
////	
//	
//	
//	@Step("Price of indmod {0} is {1}")
//	public String priceOfINDMod(String indmod, String price)
//			{
//		return purchaseInfoPage.getINDModPrice(indmod, price);
//			}
//	
//	@Step("Total Price on Purchase info page is {0}")
//	public String totalPrice(String totalprice) {
//		return purchaseInfoPage.getTotalPrice(totalprice);
//	}
//
//	
//	@Step("Click continue button")
//
//	public PurchasePage clickContinueAndNavigateToPurchasePage() {
//		return purchaseInfoPage.clickContinueAndNavigateToPurchasePage();
//	}
//
//	/*********************Purchase Page Steps*******************/
//	
//	@Step("Check Discounted Total price on Purchase form as")
//	public String checkTotalDiscountedPrice(String totalprice)
//	{
//		return purchasePage.checkTotalDiscountedPrice(totalprice);
//	}
//
//	@Step("Adding user information")
//
//	public PurchasePage addUserInformation(String lastName) {
//
//		return purchasePage.addUserInformation(lastName);
//	}
//
//	@Step("I add first name as {0}")
//	public PurchasePage addFirstName(String firstName) {
//		return purchasePage.addFirstName(firstName);
//
//	}
//
//	@Step("I add last name")
//	public PurchasePage addLastName(String lastName) {
//		return purchasePage.addLastName(lastName);
//
//	}
//
//	@Step("I add Address as {0}")
//	public PurchasePage addAddress(String address) {
//		return purchasePage.addAddress(address);
//
//	}
//
//	@Step("I add city as {0}")
//	public PurchasePage addCity(String city) {
//		return purchasePage.addCity(city);
//
//	}
//
//	@Step("I select country as {0}")	
//	public PurchasePage addCountry(String country) {
//		return purchasePage.addCountry(country);
//
//	}
//
//	@Step("I select state as {0}")	
//	public PurchasePage addState(String state) {
//		return purchasePage.addState(state);
//
//	}
//
//	@Step("I select province as {0}")	
//	public PurchasePage addProvince(String province) {
//		return purchasePage.addProvince(province);
//
//	}
//
//	@Step("I add zip code as {0}")	
//	public PurchasePage addZipCode(String zipCode) {
//		return purchasePage.addZipCode(zipCode);
//
//	}
//
//	@Step("I add postal code as {0}")	
//	public PurchasePage addPostalCode(String postalCode) {
//		return purchasePage.addPostalCode(postalCode);
//
//	}
//
//	@Step("I select speciality as {0}")	
//	public PurchasePage selectSpeciality(String speciality) {
//		return purchasePage.selectSpeciality(speciality);
//
//	}
//
//	@Step("I select place of work or study as {0}")	
//	public PurchasePage selectPlaceOfWorkOrStudy(String placeOfWorkOrStudy) {
//		return purchasePage.selectPlaceOfWorkOrStudy(placeOfWorkOrStudy);
//
//	}
//
//
//	@Step("Adding Existing user information")
//
//	public PurchasePage addExistingUserInformation() {
//
//		return purchasePage.addExistingUserInformation();
//	}
//
//	@Step("Adding account information with email: {0}")
//
//	public PurchasePage addAccountInformation(String email) {
//
//		return purchasePage.addAccountInformation(email);
//	}
//
//	@Step("Adding card information")
//
//	public PurchasePage addCardInformation() {
//
//		return purchasePage.addCardInformation();
//	}
//
//	@Step("Click submit button")
//
//	public PurchaseConfirmation clickSubmit() {
//
//		return purchasePage.clickSubmit();
//	}
//
//	@Step("Tax price added is {0}")
//
//	public String getTaxPrice(String expectedTaxPrice) {
//
//		return purchasePage.getTaxPrice();
//	}
//
//	/*********************Purchase Confirmation Page Steps*******************/
//
//	@Step("Verify Confirmation Message")
//
//	public PurchaseConfirmation verifyConfirmationMessage() {
//
//		return purchaseConfirmation.verifyConfirmationMessage();
//	}
//
//	@Step("Click your profile link")
//
//	public ProfilePage clickYourProfile(String lastName) {
//
//		return purchaseConfirmation.clickYourProfile(lastName);
//	}
//
//	@Step("Verify Already Purchased Product Message")
//
//	public PurchaseConfirmation verifyExtendAccessButton() {
//
//		return purchaseConfirmation.verifyExtendAccessButton();
//	}
//
//
//	@Step("Verify Already Purchased Product Message")
//
//	public PurchaseConfirmation verifyAlreadyPurchasedProductMessage() {
//
//		return purchaseConfirmation.verifyAlreadyPurchasedProductMessage();
//	}
//
//	/*********************Profile Page Steps*******************/
//
//	@Step("Verify Welcome Message")
//
//	public ProfilePage verifyWelcomeMessage(String lastName) {
//
//		return profilePage.verifyWelcomeMessage(lastName);
//	}
//
//	@Step("Click Sign Out button")
//
//	public HomePage clickSignOut() {
//
//		return profilePage.clickSignOut();
//	}
//
//	@Step("I download the Receipt")
//
//	public ProfilePage downloadReceipt() {
//		return profilePage.downloadReceipt();
//
//	}
//
//	@Step("Receipt contains {0}")
//
//	public String readPdf(String expectedPrice) throws IOException {
//		return profilePage.readPdf();
//
//	}
//
//	
//	
//

}
