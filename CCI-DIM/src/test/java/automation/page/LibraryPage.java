package automation.page;

import java.io.File;

import org.openqa.selenium.support.PageFactory;

import automation.locators.Locators.LibraryPageLocators;
import automation.utility.CommonUtility;
import automation.utility.DriverUtility;

public class LibraryPage extends DriverUtility implements LibraryPageLocators {

	public LibraryPage() {
		PageFactory.initElements(getDriver(), this);
	}

	CommonUtility utility = new CommonUtility();

	public void verifyLibraryPage() {
		verifyVisible(getElementByCSS(addCreativeBtnCSS), "Add Creative Button On Library Page");
		verifyVisible(getElementByCSS(headerSectionLibraryCSS), "Header Section on Library Page");
		verifyVisible(getElementByCSS(creativeListCSS), "List of Creatives On Library Page");
	}

	public void addCreative(String creativeName, String creativeLength, String creativeTags, String orientation) {
		getElementByCSS(addCreativeBtnCSS).click();
		getElementByXpath(creativeNameXpath).sendKeys(creativeName);
		getElementByXpath(creativeLengthXpath).clear();
		getElementByXpath(creativeLengthXpath).sendKeys(creativeLength);
		waitForElementClickable(getElementByXpath(creativeTagsXpath));
		getElementByXpath(creativeTagsXpath).sendKeys("Language");
		getElementByXpath(creativeTagsXpath).sendKeys(creativeTags);
		getElementByXpath(String.format(creativeOrientationXpath, orientation.toUpperCase())).click();
		String imgFilePath = "\\resources\\TestVideo.mp4";
		String imgFile = new File(System.getProperty("user.dir"), imgFilePath).toString();
		getElementByCSS(uploadBtnCSS).sendKeys(imgFile);
		verifyVisible(getElementByCSS(uploadCancelBtnCSS), "Upload Cancel Button");
		verifyVisible(getElementByCSS(uploadProgressCSS), "Upload progress bar");
		waitForElementNotPresent("CSS", uploadCancelBtnCSS);
		verifyVisible(getElementByCSS(successMsgUploadCSS), "Success message for Uploaded video");
		waitForElementClickable(getElementByCSS(saveCreativesCSS));
		getElementByCSS(saveCreativesCSS).click();
	}

	public void verifyCreativeOnLibraryPage(String creativeName) {
		CommonUtility.wait(3000);
		verifyVisible(getElementByXpath(String.format(creativeOnLibraryXpath, creativeName)),
				"Creative " + creativeName + "");
	}

}
