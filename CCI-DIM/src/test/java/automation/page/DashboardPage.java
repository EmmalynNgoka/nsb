package automation.page;

import org.openqa.selenium.support.PageFactory;

import automation.locators.Locators.HomePageLocators;
import automation.utility.CommonUtility;
import automation.utility.DriverUtility;

public class DashboardPage extends DriverUtility implements HomePageLocators {

	
	public DashboardPage() {
		PageFactory.initElements(getDriver(), this);
	}
	CommonUtility utitlity = new CommonUtility();

	public void verifyDashboardPage() {
		verifyVisible(getElementByCSS(webLogoCSS), "Company Logo");
		verifyVisible(getElementByCSS(headerSectionCSS), "Header Section");
		verifyVisible(getElementByCSS(bodySectionCSS), "Body Section");

	}

}
