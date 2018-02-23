@smoke-test @regression
Feature: ToysRus Login 
As a registered user 
In order to Sign In 
I want to login 

Scenario Outline: Test Login 
	Given I go to ToyRUs Home page 
	When I click on Sign In link 
	Then I should see "Create an Account" header label
	And I enter my Email Address as "<ID>" 
	And I enter my Password as "<PASS>" 
	And I click on Login button 
	Then I should go to the page "<Landing_Page>" 
	Examples: 
		|ID						|PASS		|		Landing_Page 	   										|
		|	gtest_t@gmail.com	|Testing123	|Unable to find login information for provided login/email. 		|
		#|Test@gmailcom			|Testing123	|		Login Page 												|
		#|Test@gmail.com			|Te			|		Login Page 												|
		#|Test@gmailcom			|Te			|		Login Page												|