package com.test.rashmi.pages;

import org.testng.Assert;


public class HomePage extends BasePage {
	
	
	
	private static final String CATEGORY_LINK_A = "(//*[@title='";
	private static final String CATEGORY_LINK_B = "'])[2]";
	private static final String ACCOUNT_LINK = "//a[@class=\"account\"]";
	private static final String USERNAME_TEXT = "//a[@class=\"account\"]//span";
	
	public TshirtPage clickOnCategoryLink(String categorylink) {
		String category =  CATEGORY_LINK_A + categorylink + CATEGORY_LINK_B;
		waitFor(category).$(category).click();
		System.out.println("Clicked on "+categorylink+" button");
		return this.switchToPage(TshirtPage.class);
	}
	
	public AccountPage clickOnAccountPage() {
		waitFor(ACCOUNT_LINK).$(ACCOUNT_LINK).click();
		System.out.println("Clicked on accounts page");
		return this.switchToPage(AccountPage.class);
	}

	public HomePage verifyUpdatedFirstNameOnTopRightCorner(String expectedFirstName) {

		waitForTextToAppear("Your personal information has been successfully updated.");
		Assert.assertTrue(
				waitFor(USERNAME_TEXT).$(USERNAME_TEXT).getText().trim().split(" ")[0].equalsIgnoreCase(expectedFirstName),
				"[Assert Failed]: Personal Info First Name is not updated. First name is: "+ waitFor(USERNAME_TEXT).$(USERNAME_TEXT).getText().trim().split(" ")[1] + " and expected : "
						+ expectedFirstName);
		System.out.println("[Assert Passed: Personal Info First Name is updated. First name is: "
				+ waitFor(USERNAME_TEXT).$(USERNAME_TEXT).getText().trim().split(" ")[0] + " and expected : "
				+ expectedFirstName);
		return this;
	}
	
}
