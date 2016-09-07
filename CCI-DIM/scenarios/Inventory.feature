Feature: Inventory 
 	As an Inventory Manager
	I want to be able to create a new inventory element and define its actual attributes (metadata)
	So that it can be used in the campaign design process, inventory optimization and reporting
	
@Smoke 
Scenario: Create Flat Inventory Element 
	Given I am on he Livedooh website 
#	When I do login with username "adminuser" and password "Welcome21" 
#	Then verify "Dashboard" page should be displayed 
#	When I navigate to the "Inventory" tab 
#	Then verify "Inventory" page should be displayed 
#	When I add new Inventory "TestInventory"
#	Then verify confirmation message "Inventory saved successfully."
#	And Remove inventory "TestInventory" 
#	And verify confirmation message "Inventory removed successfully." 
#
#@Smoke
#Scenario: Associate an Inventory Element to a parent Element
#	Given I am on he Livedooh website 
#	When I do login with username "adminuser" and password "Welcome21" 
#	Then verify "Dashboard" page should be displayed 
#	When I navigate to the "Inventory" tab 
#	Then verify "Inventory" page should be displayed 
#	When I add new Inventory "TestInventory"
#	Then verify confirmation message "Inventory saved successfully."
#	When I navigate to the "Inventory" tab 
#	And I add new Inventory "TestChild" and select parent "TestInventory"
#	Then verify confirmation message "Inventory saved successfully."
#	And Remove inventory "TestInventory" 
#	And verify confirmation message "Inventory removed successfully."
#
#@Smoke	
#Scenario: Create a child element to a current element 
#	Given I am on he Livedooh website 
#	When I do login with username "adminuser" and password "Welcome21" 
#	Then verify "Dashboard" page should be displayed 
#	When I navigate to the "Inventory" tab 
#	Then verify "Inventory" page should be displayed 
#	When I add new Inventory "TestInventory"
#	Then verify confirmation message "Inventory saved successfully."
#	When I navigate to the "Inventory" tab 
#	And I select inventory "TestInventory" from inventory list
#	Then Inventory details page should be displayed for "TestInventory"
#	When I click on Add Sub-Item button 
#	And veriy create inventory pop up should be displayed 
#	When I add child Inventory "ChildInventory" 
#	Then verify parent of "ChildInventory" is "TestInventory" 
#	And Remove inventory "TestInventory" 
#	And verify confirmation message "Inventory removed successfully."
#
#Scenario: Remove Inventory Element
#	Given I am on he Livedooh website 
#	When I do login with username "adminuser" and password "Welcome21" 
#	Then verify "Dashboard" page should be displayed 
#	When I navigate to the "Inventory" tab 
#	Then verify "Inventory" page should be displayed 
#	When I add new Inventory "TestInventory"
#	Then verify confirmation message "Inventory saved successfully."
#	When I navigate to the "Inventory" tab 
#	And I select inventory "TestInventory" from inventory list
#	Then Inventory details page should be displayed for "TestInventory"
#	When I click on Option button 
#	Then verify Remove Inventory option should be displayed 
#	When I click on Remove Inventory 
#	Then verify warning pop up should be displayed
#	When I click on confirm button
#	Then verify confirmation message "Inventory removed successfully."
#	
#
#Scenario: Starting point to browse the Inventory Element Topology
#	Given I am on he Livedooh website 
#	When I do login with username "adminuser" and password "Welcome21" 
#	Then verify "Dashboard" page should be displayed 
#	When I navigate to the "Inventory" tab 
#	Then verify "Inventory" page should be displayed 
#	When I add new Inventory "TestInventory"
#	Then verify confirmation message "Inventory saved successfully."
#	When I navigate to the "Inventory" tab 
#	And I add new Inventory "TestChild" and select parent "TestInventory"
#	Then verify confirmation message "Inventory saved successfully."
#	And I navigate to the "Inventory" tab
#	When I search for inventory "TestChild" from inventory list 
#	Then verify inventory "TestChild" is displayed without a parent
#	And Remove inventory "TestChild" 
#	And verify confirmation message "Inventory removed successfully."
#
#
#  Scenario: View / Edit Inventory Element
#    Given I am on he Livedooh website
#    When I do login with username "adminuser" and password "Welcome21"
#    Then verify "Dashboard" page should be displayed
#    When I navigate to the "Inventory" tab
#    Then verify "Inventory" page should be displayed
#    When I add new Inventory "TestInventory"
#	Then verify confirmation message "Inventory saved successfully."
#    When I navigate to the "Inventory" tab 
#	And I add new Inventory "TestChild" and select parent "TestInventory"
#	Then verify confirmation message "Inventory saved successfully."
#	And I navigate to the "Inventory" tab
#    When I select inventory "TestInventory" from inventory list
#	Then Inventory details page should be displayed for "TestInventory"
#	And Remove inventory "TestInventory" 
#	And verify confirmation message "Inventory removed successfully."
# 
#Scenario: Drill down in the Element Typology
#    Given I am on he Livedooh website
#    When I do login with username "adminuser" and password "Welcome21"
#    Then verify "Dashboard" page should be displayed
#    When I navigate to the "Inventory" tab
#    Then verify "Inventory" page should be displayed
#    When I add new Inventory "TestInventory"
#	Then verify confirmation message "Inventory saved successfully."
#    When I navigate to the "Inventory" tab 
#	And I add new Inventory "TestChild" and select parent "TestInventory"
#	Then verify confirmation message "Inventory saved successfully."
#	And I navigate to the "Inventory" tab
#	When I select inventory "TestInventory" from inventory list
#	Then Inventory details page should be displayed for "TestInventory"
#	And verify child inventory is diplayed on Inventory details page
#	When I select child inventory "TestChild" from Inventory details page
#	Then verify in breadcrumb link parent of "TestChild" is "TestInventory" 
#	And Remove inventory "TestInventory" 
#	And verify confirmation message "Inventory removed successfully."
#		
#		
#Scenario: Inheritance Foundations
#	Given I am on he Livedooh website 
#	When I do login with username "adminuser" and password "Welcome21" 
#	Then verify "Dashboard" page should be displayed 
#	When I navigate to the "Inventory" tab 
#	Then verify "Inventory" page should be displayed 
#	When I add new Inventory "TestInheri" 
#	And I select sub tab "Prohibitions" 
#	Then verify Prohibitions page should be displayed 
#	When I add Prohibition with type "Language" and value "English"
#	Then verify confirmation message should be displayed 
#	And navigate back to inventory page 
#	When I add new Inventory "TestChild" and select parent "TestInheri" 
#	Then verify confirmation message should be displayed 
#	And I select sub tab "Prohibitions" 
#	Then Verify Prohibition value should be type "Language" and value "English"
#	And Verify user can overwrite inherited value
#	And Remove inventory "TestInheri" 
#	And verify confirmation message "Inventory removed successfully." 

