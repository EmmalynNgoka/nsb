package automation.page;

import org.openqa.selenium.support.PageFactory;

import automation.locators.Locators.CampPageLocators;
import automation.utility.CommonUtility;
import automation.utility.DriverUtility;

public class CampaignPage extends DriverUtility implements CampPageLocators {

	public CampaignPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void trashCamp(String campName) throws InterruptedException {
		CommonUtility.wait(5000);
		getElementByCSS(searchButtonCSS).click();
		CommonUtility.wait(3000);
		getElementByXpath(searchTextBoxXpath).sendKeys(campName);
		CommonUtility.wait(5000);
		getElementByCSS(checkBoxForCampCSS).click();
		CommonUtility.wait(2000);
		getElementByCSS(trashCampCSS).click();
		waitForElementNotVisible(loadingSpinnerXpath);
	}

	public void verifyCampaingPage() {
		verifyVisible(getElementByCSS(createNewCampBtnCSS), "New Compaign Button");
	}

}
