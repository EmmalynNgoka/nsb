package automation.page;

import java.util.Random;

import org.openqa.selenium.support.PageFactory;

import automation.locators.Locators.CampPageLocators;
import automation.utility.CommonUtility;
import automation.utility.DriverUtility;

public class CreateCampaignPage extends DriverUtility implements CampPageLocators {

	CommonUtility utitlity = new CommonUtility();
	TemplatePage templatePage = new TemplatePage();

	public CreateCampaignPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void createCampaing(String name, String goal, boolean isFloating) {

		String endDate = "30";
		getElementByCSS(createNewCampBtnCSS).click();
		getElementListByXpath(calendarIconXpath).get(1).click();
		CommonUtility.wait(2000);
		getElementListByXpath(String.format(calendarEndDateXpath, endDate)).get(1).click();
		getElementByXpath(campNameXpath).sendKeys(name);
		templatePage.chooseSubTab("Goals");
		if (isFloating) {
			waitForAjaxToComplete();
			verifyFloatingCapmVisible();
			getElementByXpath(floatingCampCheckboxXpath).click();
		}
		setUpGoals(goal);
	}

	public void verifyCampaingPage() {
		verifyVisible(getElementByCSS(createNewCampBtnCSS), "New Compaign Button");
	}

	public String getCampName() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		System.out.println("==>" + "Test" + randomInt);
		return "Test" + randomInt;
	}

	public void verifyFloatingCapmVisible() {
		verifyVisible(getElementByXpath(floatingCampCheckboxXpath), "Floating Campaign Checkbox");
	}

	public void clickOnLockedCampCheckBox() {
		waitForElementVisible(getElementByXpath(lockedCampXpath));
		getElementByXpath(lockedCampXpath).click();
	}

	public void verifyLockCampCheckboxNotVisible() {
		verifyNotPresent(lockedCampXpath);
	}

	public void verifyFloatingCapmGrayedout() {
		verifyTrue(!getElementByXpath(floatingCampCheckboxXpath).isEnabled(),
				"Floating Campaign Checkbox is Grayed out", "Floating Campaign Checkbox is Not Grayed out");
	}

	public void verifyLockCampEnable() {
		verifyTrue(getElementByXpath(lockedCampXpath).isEnabled(), "lock Campaign Checkbox is Enable",
				"Floating Campaign Checkbox is Not Enable");
	}

	public void verifyCampIndicatorOnCampPage(String campName) {
		CommonUtility.wait(5000);
		verifyVisible(getElementByXpath(String.format(floatingIndicationOnCampaignPageXpath, campName)),
				"Floating Camp indicator on Camp Page");
		verifyText(getElementByXpath(String.format(floatingIndicationOnCampaignPageXpath, campName)), "F",
				"Floating Camp indicator on Camp Page");
	}

	public void clickOnCamp(String campName) {
		getElementByXpath(String.format(campNameCampPage, campName)).click();
	}

	public void setUpGoals(String goal) {
		getElementByXpath(screenPlayXpath).click();
		getElementByXpath(goalXpath).sendKeys(goal);
		getElementByXpath(staticCompXpath).click();
		getElementByCSS(saveChangesGoalsCSS).click();
	}

}
