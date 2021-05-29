package com.test.rashmi.pages;

import static com.test.rashmi.utils.YamlReader.getData;

import org.openqa.selenium.JavascriptExecutor;

import cucumber.api.java.en.Given;

public class PersonalInfoPage extends BasePage {

	private static final String FIRSTNAME_FIELD = "//input[@name=\"firstname\"]";
	private static final String OLDPASSWORD_FIELD = "//input[@id=\"old_passwd\"]";
	private static final String SAVE_BUTTON = "//button[@class=\"btn btn-default button button-medium\"]";
	
	

	public PersonalInfoPage fillFirstName(String firstName) {

		$(FIRSTNAME_FIELD).clear();
		$(FIRSTNAME_FIELD).type(firstName);
		System.out.println("Entered First Name : "+ firstName);
		return this;
	}

	public PersonalInfoPage fillOldPassword(String password) {
		$(OLDPASSWORD_FIELD).type(password);
		System.out.println("Entered Password Name : "+ password);		
		return this;
	}

	public HomePage clickOnSaveButton(){
		waitFor(SAVE_BUTTON).$(SAVE_BUTTON).click();
		System.out.println("Clicked on Save Button");
		return this.switchToPage(HomePage.class);
	}

}
