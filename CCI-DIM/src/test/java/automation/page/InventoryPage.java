package automation.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import automation.locators.Locators.CampPageLocators;
import automation.locators.Locators.InventoryPageLocators;
import automation.utility.CommonUtility;
import automation.utility.DriverUtility;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InventoryPage extends DriverUtility implements InventoryPageLocators, CampPageLocators {

	public InventoryPage() {
		PageFactory.initElements(getDriver(), this);
	}

	CommonUtility utility = new CommonUtility();

	public void verifyInvetoryPage() {
		verifyVisible(getElementByCSS(addInventoryButtonCSS), "Add Inventory button on Inventory page");
	}

	public void clickOnAddInventory() {
		getElementByCSS(addInventoryButtonCSS).click();
	}

	public void verifyCreateInventoryPouUp() {
		verifyVisible(getElementByCSS(addInvetoryDialogCSS), "Add inventory dialog box");
	}

	public void clickOnStartInventoryBtn() {
		verifyVisible(getElementByCSS(startButtonCSS), "Start Inventory button");
		getElementByCSS(startButtonCSS).click();
	}

	public void createInvetory(String invetoryName, boolean isParent, String parentInventory) {
		getElementByXpath(inventoryNameXpath).sendKeys(invetoryName);
		Select invetoryType = new Select(getElementByXpath(invetoryTypeXpath));
		invetoryType.selectByVisibleText("Location");
		if (isParent) {
			Select parentInventoryOption = new Select(getElementByXpath(inventoryParentOptionXpath));
			parentInventoryOption.selectByVisibleText(parentInventory);
		}
		getElementByCSS(createButtonCSS).click();
	}

	@When("^I add new Inventory \"([^\"]*)\"$")
	public void I_add_new_Inventory(String name) {
		clickOnAddInventory();
		verifyCreateInventoryPouUp();
		createInvetory(name, false, "");
		clickOnStartInventoryBtn();
	}

	@When("^I add child Inventory \"([^\"]*)\"$")
	public void I_add_child_Inventory(String name) {
		createInvetory(name, false, "");
	}

	@When("^I add new Inventory \"([^\"]*)\" and select parent \"([^\"]*)\"$")
	public void I_add_new_Inventory_and_select_parent(String inventoryName, String parentInventory) {
		clickOnAddInventory();
		verifyCreateInventoryPouUp();
		createInvetory(inventoryName, true, parentInventory);
		clickOnStartInventoryBtn();
	}

	@Then("^verify confirmation message should be displayed$")
	public void verify_confirmation_message_should_be_displayed() {
		verifyVisible(getElementByXpath(invetorySuccessMessageXpath), "inventory success message");
	}

	@Then("^Inventory details page should be displayed for \"([^\"]*)\"$")
	public void Inventory_details_page_should_be_displayed(String inventory) {
		verifyVisible(getElementByXpath(inventoryDetalsPageDetails), "Inventory details page");
		verifyVisible(getElementByXpath(addSubItemBtnXpath), "Add sub-item button");
		verifyText(getElementByXpath(inventoryDetailPageTitle), inventory, "Inventory Detail page title");
	}

	@When("^I click on Add Sub-Item button$")
	public void I_click_on_Add_Sub_Item_button() {
		clickElementUsingJs(getElementByXpath(addSubItemBtnXpath));
	}

	@When("^veriy create inventory pop up should be displayed$")
	public void veriy_create_inventory_pop_up_should_be_displayed() {
		verifyVisible(getElementByCSS(addInvetoryDialogCSS), "Add inventory dialog box");
	}

	@Then("^verify parent of \"([^\"]*)\" is \"([^\"]*)\"$")
	public void verify_parent_of_is(String child, String parent) {
		CommonUtility.wait(3000);
		verifyText(getElementListByXpath(inventoryRelationListXpath).get(0), parent, "Parent Inventory");
		verifyText(getElementListByXpath(inventoryRelationListXpath).get(1), child, "Child Inventory");

	}

	@When("^I search for inventory \"([^\"]*)\" from inventory list$")
	public void searchForInventory(String inventory) {
		CommonUtility.wait(2000);
		getElementByXpath(searchInventoryTextBox).clear();
		getElementByXpath(searchInventoryTextBox).sendKeys(inventory);
		CommonUtility.wait(2000);
	}

	@Then("^verify inventory \"([^\"]*)\" is displayed without a parent$")
	public void verifyInventoryOnInventoryList(String inventory) {
		verifyVisible(getElementByXpath(String.format(inventoryListInventoryName, inventory)),
				"Inventory on Inventory List page");
	}

	@When("^I select inventory \"([^\"]*)\" from inventory list$")
	public void I_select_inventory_from_inventory_list(String inventory) {
		searchForInventory(inventory);
		getElementByXpath(String.format(inventoryListInventoryName, inventory)).click();
	}

	@When("^I click on Option button$")
	public void I_click_on_Option_button() {
		getElementByXpath(optionBtnInventoryDetailPage).click();
	}

	@Then("^verify Remove Inventory option should be displayed$")
	public void verify_Remove_Inventory_option_should_be_displayed() {
		verifyVisible(getElementByXpath(removeInventoryBtn), "Remove Inventory button");
	}

	@When("^I click on Remove Inventory$")
	public void I_click_on_Remove_Inventory() {
		clickElementUsingJs(getElementByXpath(removeInventoryBtn));
	}

	@Then("^verify warning pop up should be displayed$")
	public void verify_warning_pop_up_should_be_displayed() {
		verifyVisible(getElementByXpath(removeInvConfirmationPopUp), "Remove Inventory confirmation pop up");
		verifyVisible(getElementByXpath(removeInvConfirmRemove), "Yes button on Confirmation pop up");
		verifyVisible(getElementByXpath(removeInvCancelRemove), "No button on Confirmation pop up");
	}

	@And("^verify child inventory is diplayed on Inventory details page$")
	public void verify_child_inventory_is_diplayed_on_Inventory_details_page() {
		int sizeOfCanvasForInventoryList = getElementListByXpath(childInventoryList).size();
		verifyTrue(sizeOfCanvasForInventoryList == 2, "Child Inventory is diplayed on inventory details page",
				"Child Inventory is not diplayed on inventory details page");
	}

	@When("^I select child inventory \"([^\"]*)\" from Inventory details page$")
	public void I_select_child_inventory_from_Inventory_details_page(String inventory) {
		getElementByXpath(String.format(childInventory, inventory)).click();
	}

	@Then("^verify in breadcrumb link parent of \"([^\"]*)\" is \"([^\"]*)\"$")
	public void verify_in_breadcrumb_link_parent_of_is(String child, String parent) {
		CommonUtility.wait(3000);
		verifyText(getElementListByXpath(breadCrumbInventoryList).get(0), parent, "Parent Inventory");
		verifyText(getElementListByXpath(breadCrumbInventoryList).get(1), child, "Child Inventory");
	}

	@When("^I click on settings button$")
	public void I_click_on_settings_button() {
		getElementByXpath(settingsIcon).click();
	}

	@When("^I add Prohibition with type \"([^\"]*)\" and value \"([^\"]*)\"$")
	public void I_add_Prohibition_with_type_and_value(String type, String value) {
		getElementByXpath(addProhibitionTextBox).sendKeys(type + "\n" + value + "\n");
		getElementByXpath(saveChangesBtn).click();
	}

	@Then("^Verify Prohibition value should be type \"([^\"]*)\" and value \"([^\"]*)\"$")
	public void Verify_Prohibition_value_should_be_type_and_value(String type, String value) {
		verifyText(getElementByXpath(prohibitionType), type, "Prohibition type");
		verifyText(getElementByXpath(prohibitionValue), value, "Prohibition value");
	}

	@Then("^verify Prohibitions page should be displayed$")
	public void verify_Prohibitions_page_should_be_displayed() {

	}

	@Then("^navigate back to inventory page$")
	public void navigate_back_to_inventory_page() {
		getElementByXpath(backToInventory).click();
	}

	@Then("^Verify user can overwrite inherited value$")
	public void verifyOverwriteBtn() {
		verifyVisible(getElementByXpath(prohibitionOverwriteBtn), "Overwrite button on prohibition");
	}

	@And("^Remove inventory \"([^\"]*)\"$")
	public void Remove_inventory(String inventory) {
		TemplatePage templatePage = new TemplatePage();
		templatePage.chooseTab("Inventory");
		searchForInventory(inventory);
		getElementByXpath(String.format(inventoryListInventoryName, inventory)).click();
		I_click_on_Option_button();
		I_click_on_Remove_Inventory();
		waitForElementClickable(getElementByXpath(removeInvConfirmRemove));
		clickElementUsingJs(getElementByXpath(removeInvConfirmRemove));
	}

	@When("^I click on confirm button$")
	public void clickOnConfirm() {
		clickElementUsingJs(getElementByXpath(removeInvConfirmRemove));
	}

	public void clickOnRunningCamp() {
		getElementByXpath(runningInventory).click();
	}

	public void unreservedCamp() {
		waitForElementPresent("xpath", runningInventory);
		CommonUtility.wait(5000);
		getElementByXpath(runningInventory).click();
		waitForElementPresent("xpath", waitCampEle);
		List<WebElement> campList = getElementListByXpath(campListInventory);

		while (campList.size() != 0) {
			waitForElementPresent("xpath", waitCampEle);
			campList.get(0).click();
			waitForElementPresent("css", dropDownChangeStateCSS);
			clickElementUsingJs(getElementByCSS(dropDownChangeStateCSS));
			clickElementUsingJs(getElementByCSS(setAsNotReserved));
			clickElementUsingJs(getElementByXpath(confirmNotReserved));
			waitForElementPresent("xpath", successUnreserved);
			driver.navigate().back();
			CommonUtility.wait(5000);
			campList = getElementListByXpath(campListInventory);
		}
	}

}
