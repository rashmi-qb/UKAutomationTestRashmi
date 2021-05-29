Feature: User is able to Updated its Personal Infomation

Scenario Outline: Updated Personal Information And Verify
	Given I click on Signin Button from header
	When I add user <emailId> and <password> and click Signin button
	Then I Click on Account Page
	Then I Click on My Personal Infomation Page
	Then I Changed Users <firstName> on Personal Page
	Then I Entered <password> as required field on Personal Page
	Then I Sumbmit Updated Personal info form
	Then I Verify Updated <expectedFirstName> Users First Name
	
	
	Examples: 
		| emailId | password | firstName | expectedFirstName |
		| rashmi.solanki599@gmail.com | Qwert@123 |  UpdatedRashmi | UpdatedRashmi |
		