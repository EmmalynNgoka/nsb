
package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import automation.locators.Locators.CampPageLocators;
import automation.utility.DriverUtility;

public class AdvertisementPage extends DriverUtility implements CampPageLocators {
	WebDriver driver;
	TemplatePage templatePage = new TemplatePage();

	public AdvertisementPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void chooseAdvertisement() {
		waitForElementClickable(getElementByCSS(newAdvtBtnCSS));
		getElementByCSS(newAdvtBtnCSS).click();
		templatePage.chooseSubTab("Choose existing");
		waitForElementClickable(getElementListByCSS(imageListCSS).get(2));
		getElementListByCSS(imageListCSS).get(1).click();
		getElementByCSS(saveAdvertizeCSS).click();
	}

	public void verifyAdvertisement() {
		templatePage.verifyVisible(getElementByXpath(successMessageAdvXpath), "Success Message of advertisement");
		templatePage.verifyVisible(getElementByXpath(advSectionXpath), "Advertisement section in Adv tab");
	}
}
