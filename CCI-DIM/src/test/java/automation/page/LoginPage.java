package automation.page;

import org.openqa.selenium.support.PageFactory;

import automation.locators.Locators.LoginPageLocators;
import automation.utility.CommonUtility;
import automation.utility.DriverUtility;

public class LoginPage extends DriverUtility implements LoginPageLocators {

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	TemplatePage templatePage = new TemplatePage();
	CommonUtility utility = new CommonUtility();
	

	public void doLogin(String username, String password) {
		if (isPresent("xpath", userNameXpath) && getElementByXpath(userNameXpath).isDisplayed()) {
			getElementByXpath(userNameXpath).sendKeys(username);
			getElementByXpath(passwordXpath).sendKeys(password);
			getElementByXpath(signInXpath).click();
		}
		templatePage.chooseTab("Dashboard");
	}

	public void openLiveDoohWebSite(String url) {
		getDriver().get(url);
	}

	public void testMethod() {
		verifyTrue(true, "Wow! passed", "Ohoooooooo Failed");

	}
}
