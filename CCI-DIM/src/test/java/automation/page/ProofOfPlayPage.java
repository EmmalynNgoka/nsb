package automation.page;

import automation.locators.Locators.CampPageLocators;
import automation.utility.CommonUtility;
import automation.utility.DriverUtility;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProofOfPlayPage extends DriverUtility implements CampPageLocators {

	@When("^I select campaign \"([^\"]*)\" from campaign listing page$")
	public void I_select_campaign_from_campaign_listing_page(String campName) {
		searchForCamp(campName);
		I_click_on_campaign(campName);
	}

	@And("^I search campaign \"([^\"]*)\" on campaign listing page$")
	public void searchForCamp(String campName) {
		CommonUtility.wait(5000);
		getElementByCSS(searchButtonCSS).click();
		CommonUtility.wait(3000);
		getElementByXpath(searchTextBoxXpath).sendKeys(campName);
		CommonUtility.wait(3000);
	}

	@Given("^Store value of Plays to Date field for campaign \"([^\"]*)\"$")
	public void Store_value_of_Plays_to_Date_field(String campName) {
		String plays = getElementByXpath(String.format(campListPlaysToDate, campName)).getText();
		System.out.println(plays);
		System.setProperty("plays.to.date", plays);
	}

	@When("^I click on Proof of play reports$")
	public void I_click_on_Proof_Of_Play() {
		getElementByXpath(proofOfPlayLink).click();
	}

	@When("^I click on campaign \"([^\"]*)\"$")
	public void I_click_on_campaign(String campName) {
		String loc = String.format(campListCampName, campName);
		getElementByXpath(loc).click();
	}

	@When("^I enter the campaign start date \"([^\"]*)\"$")
	public void I_enter_the_campaign_start_date(String date) {
		getElementListByXpath(calendarIconLinkList).get(0).click();
		getElementListByXpath(calendarMonthList).get(0).click();
		String startMonth = date.split(" ")[1].trim();
		String startDate = date.split(" ")[0].trim();
		getElementByXpath(String.format(calendarMonthSelect, startMonth)).click();
		getElementByXpath(String.format(calendarDateSelect, startDate)).click();
	}

	@Then("^verify that the plays to date is generated and the same no as the play to date on campaign lister page$")
	public void verify_that_the_plays_to_date_is_generated() {
		int actvalue = 0;
		String expValue = System.getProperty("plays.to.date").toString();
		for (int i = 0; i < getElementListByXpath(reportPagePlays).size(); i++) {
			actvalue = actvalue + Integer.parseInt(getElementListByXpath(reportPagePlays).get(i).getText());
		}
		String actValue = getElementListByXpath(reportPagePlays).get(0).getText();
		System.out.println(expValue + actValue);
		verifyTrue(expValue.equals(actValue), expValue + " = " + actValue, expValue + " = " + actValue);
	}

}
