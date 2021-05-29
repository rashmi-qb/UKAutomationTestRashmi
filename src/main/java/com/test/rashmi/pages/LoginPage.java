package com.test.rashmi.pages;

/**
 * 
 * @author Rashmi.Solanki Defining - Loign page locators and its action
 */

public class LoginPage extends BasePage {

	private static final String SIGN_IN_BUTTON = "//a[@class='login']";
	private static final String USER_NAME_INPUT = "//input[@id='email']";
	private static final String PASSWORD_INPUT = "//input[@id='passwd']";
	private static final String LOGIN_BUTTON = "//button[@id='SubmitLogin']";

	public LoginPage clickOnSignInLink() {
		open();
		waitFor(SIGN_IN_BUTTON).$(SIGN_IN_BUTTON).click();
		System.out.println("Clicked on SignIn button");
		return this;
	}

	public HomePage loginWithExistingUser(String emailId, String password) {
		
		waitFor(USER_NAME_INPUT).$(USER_NAME_INPUT).type(emailId);
		System.out.println("Entered email");
		
		waitFor(PASSWORD_INPUT).$(PASSWORD_INPUT).type(password);
		System.out.println("Entered Password");
		
		waitFor(LOGIN_BUTTON).$(LOGIN_BUTTON).click();
		System.out.println("User reached to Home Page Successfully");
		
		return this.switchToPage(HomePage.class);
	
	}

}
