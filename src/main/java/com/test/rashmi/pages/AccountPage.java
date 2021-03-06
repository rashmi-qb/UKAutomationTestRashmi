package com.test.rashmi.pages;

public class AccountPage extends BasePage {

	private static final String MYPERSONALINFO_LINK = "//a[@title=\"Information\"]";
	
	
	public PersonalInfoPage clickOnMyPersonalInfomation() {
		waitFor(MYPERSONALINFO_LINK).$(MYPERSONALINFO_LINK).click();
		System.out.println("Clicked on My Personal Infomation from Accounts page");
		return this.switchToPage(PersonalInfoPage.class);
	}

}
