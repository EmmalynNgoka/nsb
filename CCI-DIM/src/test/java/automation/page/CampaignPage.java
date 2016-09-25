package automation.page;

import org.openqa.selenium.support.PageFactory;

import automation.locators.Locators.CampPageLocators;
import automation.utility.CommonUtility;
import automation.utility.DriverUtility;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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

	@When("^I click on Create Campaing button$")
	public void I_click_on_Create_Campaing_button() {
		getElementByCSS(createNewCampBtnCSS).click();
	}

	@When("^Select subtab \"([^\"]*)\"$")
	public void Select_subtab(String subTab) {
		TemplatePage templatePage = new TemplatePage();
		templatePage.chooseSubTab("Goals");
	}

	@Then("^verify frequency limiter checkbox should be displayed$")
	public void verify_frequency_limiter_checkbox_should_be_displayed() {
		verifyVisible(getElementByXpath(frequencyLimitorCheckboxXpath), "Frequency limiter");
	}

	public void verifyCampaingPage() {
		verifyVisible(getElementByCSS(createNewCampBtnCSS), "New Compaign Button");
	}

}
