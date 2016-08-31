package automation.page;

import org.openqa.selenium.support.PageFactory;

import automation.locators.Locators.CampPageLocators;
import automation.locators.Locators.DistributionPageLocators;
import automation.locators.Locators.HomePageLocators;
import automation.utility.CommonUtility;
import automation.utility.DriverUtility;
import cucumber.api.java.en.Then;

public class TemplatePage extends DriverUtility
		implements CampPageLocators, HomePageLocators, DistributionPageLocators {

	public TemplatePage() {
		PageFactory.initElements(getDriver(), this);
	}

	CommonUtility utitlity = new CommonUtility();
	DashboardPage dashboardPage = new DashboardPage();
	CampaignPage campaignPage = new CampaignPage();
	LibraryPage libraryPage = new LibraryPage();
	InventoryPage inventoryPage = new InventoryPage();

	public void runAvailabilityCheck() {
		getElementByCSS(dropDownChangeStateCSS).click();
		getElementByCSS(checkAvaiBtnCSS).click();
	}

	public void verifyDistributionMessage(String message) {
		verifyVisible(getElementByCSS(successMsgAvailCheckCSS), message);
		getElementByCSS(successMsgAvailCheckCSS).click();
	}

	public void verifyCampStatus(String status) {
		CommonUtility.wait(3000);
		verifyText(getElementByXpath(statusOfCampXpath), status, "Status of campaign ");
	}

	public void setAsOffered() {
		getElementByCSS(dropDownChangeStateCSS).click();
		waitForElementClickable(getElementByCSS(setAsOfferedCSS));
		getElementByCSS(setAsOfferedCSS).click();
		waitForElementVisible(getElementByCSS(successMessageChangeState));
		CommonUtility.wait(5000);
	}

	public void setAsConfirm() {
		getElementByCSS(dropDownChangeStateCSS).click();
		waitForElementClickable(getElementByCSS(setAsConfirmCSS));
		getElementByCSS(setAsConfirmCSS).click();
		waitForElementVisible(getElementByCSS(successMessageChangeState));
		CommonUtility.wait(5000);
	}

	public void confirmPause() {
		clickPauseCamp();
		getElementByCSS(pauseCampConfirmBtn).click();
	}

	public void clickPauseCamp() {
		getElementByCSS(dropDownChangeStateCSS).click();
		waitForElementClickable(getElementByCSS(pauseCampBtnCSS));
		getElementByCSS(pauseCampBtnCSS).click();
	}

	public void verifyPauseCampDialog() {
		verifyVisible(getElementByCSS(pauseCampConfirmDailogCSS), "Pause Campaign Dailog Box");
		verifyVisible(getElementByCSS(pauseCampConfirmBtn), "Pause Campaign Confirm Button");
		verifyVisible(getElementByCSS(pauseCampCancelBtnCSS), "Pause Campaign Cancel Button");
	}

	public void chooseSubTab(String tabName) {
		waitForElementClickable(getElementByXpath(String.format(tabOnCampPageXpath, tabName)));
		getElementByXpath(String.format(tabOnCampPageXpath, tabName)).click();
	}

	public void chooseTab(String tabName) {
		waitForElementClickable(getElementByXpath(String.format(mainTabXpath, tabName)));
		getElementByXpath(String.format(mainTabXpath, tabName)).click();
	}

	public void chooseHeaderTab(String tabName) {
		waitForElementClickable(getElementByXpath(String.format(headerTabXpath, tabName)));
		getElementByXpath(String.format(headerTabXpath, tabName)).click();;
	}

	public void verifyPage(String page) {
		switch (page) {
		case "Campaigns":
			campaignPage.verifyCampaingPage();
			break;

		case "Dashboard":
			dashboardPage.verifyDashboardPage();
			break;
		case "Library":
			libraryPage.verifyLibraryPage();
			break;
		case "":
			inventoryPage.verifyInvetoryPage();
			break;
		}
	}

	public void verifySuccessMessage(String message) {
		verifyVisible(getElementByXpath(successMsg), "Success Message");
		verifyText(getElementByXpath(successMsg), message, "Success Message");
	}

	@Then("^verify confirmation message \"([^\"]*)\"$")
	public void verify_confirmation_message(String msg) {
		verifyVisible(getElementByXpath(String.format(confirmationMsg, msg)), "Confirmation Message " + msg);
	}

}
