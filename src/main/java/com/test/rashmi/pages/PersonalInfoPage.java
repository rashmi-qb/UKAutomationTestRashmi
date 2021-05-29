package com.test.rashmi.pages;

import static com.test.rashmi.utils.YamlReader.getData;

import org.openqa.selenium.JavascriptExecutor;

import cucumber.api.java.en.Given;

public class PersonalInfoPage extends BasePage {

	private static final String LASTNAME_FIELD = "//input[@name=\"lastname\"]";
	private static final String OLDPASSWORD_FIELD = "//input[@id=\"old_passwd\"]";
	private static final String SAVE_BUTTON = "//button[@class=\"btn btn-default button button-medium\"]";
	
	

	public PersonalInfoPage fillLastName(String lastName) {

		$(LASTNAME_FIELD).clear();
		$(LASTNAME_FIELD).type(lastName);
		System.out.println("Entered Last Name : "+ lastName);
		return this;
	}

	public PersonalInfoPage fillOldPassword(String password) {
		$(OLDPASSWORD_FIELD).type(password);
		System.out.println("Entered Last Name : "+ password);		
		return this;
	}

	public HomePage clickOnSaveButton(){
		waitFor(SAVE_BUTTON).$(SAVE_BUTTON).click();
		System.out.println("Clicked on Save Button");
		return this.switchToPage(HomePage.class);
	}

}
