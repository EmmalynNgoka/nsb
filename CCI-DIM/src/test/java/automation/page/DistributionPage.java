package automation.page;

import org.openqa.selenium.support.PageFactory;

import automation.locators.Locators.DistributionPageLocators;
import automation.utility.DataPropertyReader;
import automation.utility.DriverUtility;

public class DistributionPage extends DriverUtility implements DistributionPageLocators {
	DataPropertyReader dataProperties = new DataPropertyReader();

	public DistributionPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void verifyDistributionMessageForPauseCamp() {
		verifyText(getElementByCSS(distributionMsg1), dataProperties.getProperty("distribution.msg1"),
				"Distribution Message 1");
		verifyText(getElementByCSS(distributionMsg2), dataProperties.getProperty("distribution.msg2"),
				"Distribution Message 2");

	}

	public void verifyDistributionMessageContainsGoal(String goal) {
		String actualGoalTimeLine = getElementListByXpath(timeLineContentListXpath).get(0).getAttribute("meta");
		verifyTrue(actualGoalTimeLine.contains(goal), actualGoalTimeLine, actualGoalTimeLine);
	}
	
	public void verifyFloatingCampIndicator(String campName){
		verifyTextContains(getElementByXpath(String.format(statusOnDistribution, campName)), "F",
				"Status of floating camp on Distribution");
	}
	
	public void verifyFloatingLockedCampIndicator(String campName){
		verifyTextContains(getElementByXpath(String.format(statusOnDistribution, campName)), "F_lock",
				"Status of floating camp and lock Camp on Location Page");
	}
	
	public void clickOnTimeLine(){
		getElementListByXpath(timeLineContentListXpath).get(0).click();
	}
}
