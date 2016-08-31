package automation.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import automation.locators.Locators.CampPageLocators;
import automation.utility.CommonUtility;
import automation.utility.DriverUtility;

public class MediaPlanPage extends DriverUtility implements CampPageLocators {

	public MediaPlanPage() {
		PageFactory.initElements(getDriver(), this);
	}

	CommonUtility utitlity = new CommonUtility();

	public void addPlanConfiguration() {
		clickElementUsingJs(getElementByXpath(addPlanConfigXpath));
		verifyVisible(getElementByXpath(advSectionXpath), "Advertisement section in Adv tab");
	}

	public void addLocation() {
		getElementByXpath(advCheckBoxMediaPlan).click();
		getElementByXpath(locationTabXpath).click();
		getElementByCSS(addLocationBtnCSS).click();
		waitForElementNotVisible(loadingSpinnerXpath);
		CommonUtility.wait(3000);
		getElementByCSS(inventorySearchBoxCSS).sendKeys("Emmas Network");
		getElementByCSS(inventorySearchBoxCSS).clear();
		getElementByCSS(inventorySearchBoxCSS).sendKeys("Emmas Network");
		CommonUtility.wait(6000);
		clickElementUsingJs(getElementByXpath(inventorySelectAllCheckBoxXpath));
		getElementByCSS(saveAdvertizeCSS).click();
	}

	public void addSchedule(String startDate, String endDate, String startTimeHour, String startTimeMin,
			String endTimeHour, String endTimeMin) {
		waitForAjaxToComplete();
		CommonUtility.wait(3000);
		getElementByXpath(scheduleTabXpath).click();
		getElementByCSS(addScheduleBtnCSS).click();
		waitForAjaxToComplete();
		waitForElementClickable(getElementListByXpath(String.format(calendarEndDateXpath, startDate)).get(0));
		getElementListByXpath(String.format(calendarEndDateXpath, startDate)).get(0).click();
		waitForElementClickable(getElementListByXpath(String.format(calendarEndDateXpath, startDate)).get(1));
		getElementListByXpath(String.format(calendarEndDateXpath, endDate)).get(1).click();
		List<WebElement> list = getElementListByCSS(timingScheduleCSS);
		list.get(0).clear();
		list.get(0).sendKeys(startTimeHour);
		list.get(1).clear();
		list.get(1).sendKeys(startTimeMin);
		list.get(2).clear();
		list.get(2).sendKeys(endTimeHour);
		list.get(3).clear();
		list.get(3).sendKeys(endTimeMin);
		CommonUtility.wait(2000);
		getElementByCSS(saveAdvertizeCSS).click();
	}
}
