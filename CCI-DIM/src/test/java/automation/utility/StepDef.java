package automation.utility;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import automation.page.AdvertisementPage;
import automation.page.CampaignPage;
import automation.page.CreateCampaignPage;
import automation.page.DistributionPage;
import automation.page.LibraryPage;
import automation.page.LoginPage;
import automation.page.MediaPlanPage;
import automation.page.TemplatePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {

	private static Scenario scenario;
	public static WebDriver driver;
	ConfigPropertyReader properties = new ConfigPropertyReader();
	static String campName;

	@Before
	public void setUp(Scenario scenario) {
		setUpBrowser();
		StepDef.scenario = scenario;
		DriverUtility.setDriver(driver);
	}

	@After
	public void embedScreenshot(Scenario scenario) {

		try {
			scenario.embed(getScreenShot(), "image/png");
			getDriver().quit();
		} catch (WebDriverException wde) {
			System.err.println(wde.getMessage());
		} catch (ClassCastException cce) {
			cce.printStackTrace();
		}

		if (DataPropertyReader.getIsTestFailed()) {
			throw new RuntimeException("Scenario has Failed");
		}
	}

	// Login Page Method

	@Given("^Test method$")
	public void test() {
		LoginPage loginPage = new LoginPage();
		System.out.println("Test");
		loginPage.testMethod();
	}

	@Given("^I am on he Livedooh website$")
	public void I_am_on_he_Livedooh_website() {
		LoginPage loginPage = new LoginPage();
		loginPage.openLiveDoohWebSite(properties.getBaseUrl());
	}

	@When("^I do login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void I_do_login_with_username_and_password(String username, String password) {
		LoginPage loginPage = new LoginPage();
		loginPage.doLogin(username, password);
	}

	// Dashboard Page Method

	@Then("^verify \"([^\"]*)\" page should be displayed$")
	public void verify_page_should_be_displayed(String page) {
		TemplatePage templatePage = new TemplatePage();
		templatePage.verifyPage(page);
	}

	@When("^I navigate to the \"([^\"]*)\" tab$")
	public void I_navigate_to_the_tab(String tab) {
		TemplatePage templatePage = new TemplatePage();
		templatePage.chooseTab(tab);
	}

	// Create Campaign Page Method

	@When("^I create \"([^\"]*)\" new campaigns with inventory \"([^\"]*)\"$")
	public void I_create_new_campaigns_with_inventory(String numberOfCamp, String inventory) {
		for (int i = 0; i < Integer.parseInt(numberOfCamp); i++) {
			try {
				I_create_campaign_with_goal("1085");
				I_select_tab_on_create_campaign_page("Advertisements");
				create_advertisements_from_existing_video();
				I_add_media_plan_configuration_for_the_campaign();
				I_run_availability_check();
				I_select_from_Campaign_Status_drop_down("Set As Offered");
				I_select_from_Campaign_Status_drop_down("Set As Confirmed");
				TemplatePage templatePage = new TemplatePage();
				templatePage.chooseTab("Campaigns");
				CommonUtility.wait(3000);
			} catch (Exception e) {
				TemplatePage templatePage = new TemplatePage();
				e.printStackTrace();
				templatePage.chooseTab("Campaigns");
				CommonUtility.wait(3000);

			}
		}

	}

	@When("^I create campaign with goal \"([^\"]*)\"$")
	public void I_create_campaign_with_goal(String goal) {
		CreateCampaignPage createCampPage = new CreateCampaignPage();
		campName = createCampPage.getCampName();
		createCampPage.createCampaing(campName, goal, false);
	}

	@When("^I create floating campaign with goal \"([^\"]*)\"$")
	public void I_create_floating_campaign_with_goal(String goal) {
		CreateCampaignPage createCampPage = new CreateCampaignPage();
		campName = createCampPage.getCampName();
		createCampPage.createCampaing(campName, goal, true);
	}

	@Then("^verify success message \"(.*)\" should be displayed$")
	public void verify_success_message(String message) {
		// templatePage.verifySuccessMessage(message);
	}

	@When("^I select \"([^\"]*)\" tab on create campaign page$")
	public void I_select_tab_on_create_campaign_page(String tab) {
		TemplatePage templatePage = new TemplatePage();
		templatePage.chooseHeaderTab(tab);
	}

	@When("^create advertisements from existing video$")
	public void create_advertisements_from_existing_video() {
		AdvertisementPage advertisementPage = new AdvertisementPage();
		advertisementPage.chooseAdvertisement();
	}

	@Then("^verify advertisement should be displayed on Advertisements page$")
	public void verify_advertisement_should_be_displayed_on_Advertisements_page() {
		AdvertisementPage advertisementPage = new AdvertisementPage();
		advertisementPage.verifyAdvertisement();
	}

	// Advertisement related method

	@When("^I add media plan configuration for the campaign$")
	public void I_add_media_plan_configuration_for_the_campaign() {
		MediaPlanPage mediaPlanPage = new MediaPlanPage();
		TemplatePage templatePage = new TemplatePage();
		templatePage.chooseHeaderTab("Media plan");
		mediaPlanPage.addPlanConfiguration();
		mediaPlanPage.addLocation();
		mediaPlanPage.addSchedule("28", "02", "06", "00", "23", "59");
		CommonUtility.wait(2000);
	}

	@When("^I select sub tab \"([^\"]*)\"$")
	public void I_select_sub_tab(String tabName) {
		TemplatePage templatePage = new TemplatePage();
		templatePage.chooseSubTab(tabName);
	}

	@When("^I run availability check$")
	public void I_run_availability_check() {
		TemplatePage templatePage = new TemplatePage();
		templatePage.runAvailabilityCheck();
	}

	@Then("^verify message \"([^\"]*)\" on distribution$")
	public void verify_message_on_distribution(String message) {
		TemplatePage templatePage = new TemplatePage();
		templatePage.verifyDistributionMessage(message);
	}

	@Then("^verify campaing status should be \"([^\"]*)\"$")
	public void verify_campaing_status_should_be(String status) {
		TemplatePage templatePage = new TemplatePage();
		templatePage.verifyCampStatus(status);
	}

	@When("^I select \"([^\"]*)\" from Campaign Status drop down$")
	public void I_select_from_Campaign_Status_drop_down(String tab) {
		TemplatePage templatePage = new TemplatePage();
		switch (tab) {
		case "Set As Offered":
			templatePage.setAsOffered();
			break;
		case "Set As Confirmed":
			templatePage.setAsConfirm();
			break;

		default:
			break;
		}
	}

	// Availability Check Method

	@When("^I click on Pause Campaign button$")
	public void I_click_on_Pause_Campaign_button() {
		TemplatePage templatePage = new TemplatePage();
		templatePage.clickPauseCamp();
		CommonUtility.wait(2000);
	}

	@Then("^verify Pause Campaign dialog should be displayed$")
	public void verify_Pause_Campaign_dialog_should_be_displayed() {
		TemplatePage templatePage = new TemplatePage();
		templatePage.verifyPauseCampDialog();
	}

	@When("^I select confirm button$")
	public void I_select_confirm_button() {
		TemplatePage templatePage = new TemplatePage();
		templatePage.confirmPause();
	}

	// Distribution Page Metho

	@Then("^verify distribution message for zero allocation$")
	public void verify_distribution_message_for_zero_allocation() {
		DistributionPage distributionPage = new DistributionPage();
		distributionPage.verifyDistributionMessageForPauseCamp();
	}

	@Then("^verify distribution message contains the goal \"([^\"]*)\"$")
	public void verify_distribution_message_contains_the_goal(String goal) {
		DistributionPage distributionPage = new DistributionPage();
		distributionPage.verifyDistributionMessageContainsGoal(goal);
	}

	@Then("^delete the current campaign$")
	public void delete_the_current_campaign() throws InterruptedException {
		CampaignPage campPage = new CampaignPage();
		campPage.trashCamp(campName);
	}

	// Library Page Method

	@When("^I add new creative \"([^\"]*)\"$")
	public void I_add_new_creative(String creative) {
		LibraryPage libraryPage = new LibraryPage();
		libraryPage.addCreative(creative, "06", "English", "Landscape");
	}

	@Then("^verify creative is created with name \"([^\"]*)\" on Library page$")
	public void verify_creative_is_created_with_name_on_Library_page(String creative) {
		LibraryPage libraryPage = new LibraryPage();
		libraryPage.verifyCreativeOnLibraryPage(creative);
	}

	// Floating camp method

	@Then("^verify locked campaign checkbox should not be visible$")
	public void verify_locked_campaign_checkbox_should_not_be_visible() {
		CreateCampaignPage createCampPage = new CreateCampaignPage();
		createCampPage.verifyLockCampCheckboxNotVisible();
	}

	@Then("^verify floating campaign checkbox should be grayed out$")
	public void verify_floating_campaign_checkbox_should_be_grayed_out() {
		CreateCampaignPage createCampPage = new CreateCampaignPage();
		createCampPage.verifyFloatingCapmGrayedout();
	}

	@Then("^verify locked checkbox should be enable$")
	public void verify_locked_checkbox_should_be_enable() {
		CreateCampaignPage createCampPage = new CreateCampaignPage();
		createCampPage.verifyLockCampEnable();
	}

	@When("^navigate to network location page$")
	public void navigate_to_network_location_page() {
		DistributionPage distributionPage = new DistributionPage();
		TemplatePage templatePage = new TemplatePage();
		templatePage.chooseHeaderTab("Distribution");
		distributionPage.clickOnTimeLine();
	}

	@Then("^verify floating campaign indicator on location page$")
	public void verify_floating_campaign_indicator_on_location_page() {
		DistributionPage distributionPage = new DistributionPage();
		distributionPage.verifyFloatingCampIndicator(campName);
	}

	@When("^I navigate back$")
	public void I_navigate_back() {
		getDriver().navigate().back();
	}

	@When("^click on lock campaign checkbox$")
	public void click_on_lock_campaign_checkbox() {
		CreateCampaignPage createCampPage = new CreateCampaignPage();
		createCampPage.clickOnLockedCampCheckBox();
	}

	@Then("^verify floating and lock campaign indicator on location page$")
	public void verify_floating_and_lock_campaign_indicator_on_location_page() {
		DistributionPage distributionPage = new DistributionPage();
		distributionPage.verifyFloatingLockedCampIndicator(campName);
	}

	// Driver manager method

	public byte[] getScreenShot() {
		byte[] scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
		return scrFile;
	}

	public static void writeLog(String log) {
		log = String.format("<b><p style =\"color:#228B22;\">%s</p></b>", log);
		scenario.write(log);
	}

	private void setUpBrowser() {
		chooseBrowser(properties.getDefaultBrowser());
		driver.manage().window().maximize();
	}

	/**
	 * This method used to create driver for specified browser
	 * 
	 * @param browser
	 */
	private void chooseBrowser(String browser) {
		System.out.println(browser);
		switch (browser) {
		case "firefoxDriver":

			driver = new FirefoxDriver();
			break;

		case "chromeDriver":

			System.setProperty("webdriver.chrome.driver", properties.getDriverFile());
			driver = new ChromeDriver();
			break;
		}
	}

	/**
	 * This method used to wait till particular element present
	 * 
	 * @param locStrategy
	 * @param locator
	 */

	public static WebDriver getDriver() {
		return driver;
	}

	public void attachedScreenshot() {

	}
}
