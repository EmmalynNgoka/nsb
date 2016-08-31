Feature: Inventory 
	As an Inventory Manager
	I want to be able to create a new inventory element and define its actual attributes (metadata)
	So that it can be used in the campaign design process, inventory optimization and reporting
	
		
Scenario: Inheritance Foundations 
	Given I am on he Livedooh website 
	When I do login with username "adminuser" and password "Welcome21" 
	Then verify "Dashboard" page should be displayed 
	When I navigate to the "Campaigns" tab 
	Then verify "Campaigns" page should be displayed 
	When I create "10" new campaigns with inventory "Emmas Network" 
	
	
	
