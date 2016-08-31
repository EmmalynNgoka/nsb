Feature: Create a New Creative 
	As a Campaign Manager
	I want to be able to create a campaign design
	So that my client can

Scenario: Create a New Creative 
	Given I am on he Livedooh website 
	When I do login with username "adminuser" and password "Welcome21" 
	Then verify "Dashboard" page should be displayed 
	When I navigate to the "Library" tab 
	Then verify "Library" page should be displayed 
	When I add new creative "CreativeTesting"
	Then verify creative is created with name "CreativeTesting" on Library page
	
	
	
 
 
 
	
	