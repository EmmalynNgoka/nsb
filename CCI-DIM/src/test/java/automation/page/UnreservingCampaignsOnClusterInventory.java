package automation.page;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.locators.Locators.InventoryPageLocators;
import automation.locators.UnreservingCampaignLoc;
import automation.utility.DriverUtility;
import automation.utility.StepDef;

public class UnreservingCampaignsOnClusterInventory implements UnreservingCampaignLoc, InventoryPageLocators {

	StepDef steps = new StepDef();
	InventoryPage inventory = new InventoryPage();

	@BeforeTest
	public void setUp() {
		steps.setUp(null);
	}

	@Test
	public void deleteCamp() {

		steps.I_am_on_he_Livedooh_website();
		steps.I_do_login_with_username_and_password("cci", "Welcome21");
		steps.verify_page_should_be_displayed("Dashboard");
		steps.I_navigate_to_the_tab("Inventory");
		steps.verify_page_should_be_displayed("Inventory");
		
		inventory.I_select_inventory_from_inventory_list("&ClusterDemo");
		inventory.unreservedCamp();
	}

	@AfterTest
	public void quit() {
		DriverUtility.getDriver().quit();
	}

}
