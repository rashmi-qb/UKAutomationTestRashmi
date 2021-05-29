Feature: User is able to Order T-Shirt

Scenario Outline: Purchace T-Shirt and Verify in Order Summary Page
	Given I click on Signin Button from header
	When I add user <emailId> and <password> and click Signin button
	Then I click on category <categorylink> link 
	Then I Click on First Tshirt image
	Then I Click on AddToCart Button
	Then I Click on ProceedToCheckout Button of Tshirt Page
	Then I Click on ProceedToCheckout Button of Cart Summary
	Then I Click on ProceedToCheckout Button of Address Page
	Then I Check on TermAndCondition Box of Shipping Page
	Then I Click on ProceedToCheckout Button of Shipping Page
	Then I Click on PayByCheck Button of Payment Page
	Then I Click on IConfirmMyOrder Button of Order Summary Page
	Then I Verify Order Name on Order History Page
	
	
	Examples: 
		| emailId | password | categorylink |
		| rashmi.solanki599@gmail.com | Qwert@123 | T-shirts |
		