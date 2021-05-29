package com.test.rashmi.cucumber.steps;

import com.test.rashmi.cucumber.steps.serenity.TShirtSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class UpdatedPersonalInformationSteps {

	@Steps
	TShirtSteps user;
	String expectedTshirtName = "Faded Short Sleeve T-shirts";

	@Then("I Click on Account Page")
	public void I_Click_On_Account_Page() {
		user.clickOnAccountPage();
	}

	@Then("I Click on My Personal Infomation Page")
	public void I_Click_On_MyPersonalInformation_Page() {
		user.clickOnMyPersonalInfomation();
	}

	@Then("I Changed Users (.*) on Personal Page")
	public void I_Enter_Updated_FirstName_On_MyPersonalInformation_Page(String firstName)
			throws PendingException, InterruptedException {
		user.enterFirstNameInPersonalInfoPage(firstName);
	}

	@Then("I Entered (.*) as required field on Personal Page")
	public void I_Enter_Updated_OldPassword_On_MyPersonalInformation_Page(String password)
			throws PendingException, InterruptedException {
		user.enterOldPasswordInPersonalInfoPage(password);
	}

	@Then("I Sumbmit Updated Personal info form")
	public void I_Submit_Updated_PersonalInformation() {
		user.clickOnSaveButtonOfPersonalInfoPage();
	}

	@Then("I Verify Updated (.*) Users First Name")
	public void I_Verify_Updated_LastName_On_HomePage(String expectedFirstName)
			throws PendingException, InterruptedException {
		user.verifyUpdatedFirstNameOnHomePage(expectedFirstName);
	}
	
	
}
