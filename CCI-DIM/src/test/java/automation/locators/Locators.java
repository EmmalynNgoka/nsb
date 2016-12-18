package automation.locators;

public interface Locators {

	public interface LoginPageLocators {
		String userNameXpath = "//input[@name='user']";
		String passwordXpath = "//input[@type='password']";
		String signInXpath = "//input[@type='submit']";
	}

	public interface HomePageLocators {
		String webLogoCSS = "#brand-logo";
		String headerSectionCSS = "#main-stats";
		String bodySectionCSS = ".scrollable-vertical-only";
		String mainTabXpath = "//span[@class='ng-binding' and text()='%s']";
		String headerTabXpath = "//a[contains(text(),'%s')]";
		String tabOnCampPageXpath = "//h4[contains(text(),'%s')]";
		String confirmationMsg = "//*[contains(text(),'%s')]";

	}

	public interface CampPageLocators {
		String floatingCampCheckboxXpath = "//input[@data-ng-model=\"campaign.goal.isFloating\"]";
		String floatingIndicationOnCampaignPageXpath = "//a[@class=\"name ng-scope\"]//span[contains(text(),'%s')]//ancestor::div[contains(@class,'ng-scope ngRow')]//i[@class='campaign-icon-floating']";

		String searchButtonCSS = ".ngHeaderButtonArrow";
		String searchTextBoxXpath = "//input[@ng-model=\"filterText\"]";
		String checkBoxForCampCSS = ".ngSelectionCheckbox";
		String trashCampCSS = "#btn-trash";
		String loadingSpinnerXpath = "//div[text()='Please Wait...']";
		String campListPlaysToDate = "//span[text()='%s']//parent::a//parent::div/parent::div/parent::div/div[10]/div[2]/span";
		String campListCampName = "//span[text()='%s']";
		String proofOfPlayLink = "//tr[@class='first']//a";
		String reportPagePlays = "//span[@class='ng-scope']//strong[@class='ng-binding']";
		String calendarIconLinkList = "//i[@class='icon-calendar']";
		String calendarMonthList = "//strong[@class='ng-binding']";
		String calendarMonthSelect = "//span[text()='%s']";
		String calendarDateSelect = "//span[@class='ng-binding' and text()='%s']";
		String frequencyLimitorCheckboxXpath = "//input[@data-ng-model=\"campaign.goal.hasLimit\"]";;
		String createNewCampBtnCSS = "#btn-add-campaign";
		String campNameXpath = "//input[@data-ng-model='model.campaign.name']";
		String calendarIconXpath = "//i[@class='icon-calendar']";
		String calendarEndDateXpath = "//span[@class='ng-binding' and text()='%s']";
		String saveCampBtnCSS = "#save-button-initial";

		String screenPlayXpath = "//input[@value='DAILY_PLAYS_SCREEN']";
		String goalXpath = "//input[@data-ng-model='campaign.goal.targetPlays']";
		String staticCompXpath = "//input[@data-ng-model='campaign.goal.isFixedSchedule']";
		String saveChangesGoalsCSS = "#save-button-goals";

		String successMsg = "//strong[@class='ng-binding ng-scope']";

		String newAdvtBtnCSS = "#btn-add-advertisement";
		String imageListCSS = ".img>img";
		String saveAdvertizeCSS = ".btn-flat.primary";
		String successMessageAdvXpath = "//strong[contains(text(),\"Advertisement created successfully\")]";

		String advSectionXpath = "//tr[@data-ng-repeat=\"creative in creatives\"]";

		String advCheckBoxMediaPlan = "//input[@data-ng-click=\"selectCreative(creative)\"]";
		String addPlanConfigXpath = "//span[contains(text(),'Add plan configuration')]";

		String locationTabXpath = "//button[@tooltip=\"Manage locations\"]";
		String addLocationBtnCSS = "#btn-add-inventory>span";

		String inventorySearchBoxCSS = "#inputSearch";
		String inventorySelectAllCheckBoxXpath = "//h4[contains(.,'TEST LIVEDOOH')]/parent::div/input";

		String locationAddedSucssMsgXpath = "//div[@ng-transclude='']/strong";
		String locationSectionMediaPlanXpath = "//tr[@data-ng-repeat=\"location in adMediaPlan.locations\"]";
		String scheduleSection = "//tr[@data-ng-repeat=\"schedule in adSchedules\"]";

		String scheduleTabXpath = "//button[@tooltip=\"Manage schedules\"]";

		String addScheduleBtnCSS = "#btn-add-schedule";
		String timingScheduleCSS = ".span1.text-center.ng-pristine.ng-valid";
		String scheduleAddedCSS = ".show-hand.ng-scope";

		String dropDownChangeStateCSS = ".dropdown-toggle.btn.btn-tool";
		String lockedCampXpath = "//input[@data-ng-model=\"campaign.goal.isFloatingLocked\"]";
		String campNameCampPage = "//a[@class=\"name ng-scope\"]//span[contains(text(),'%s')]";
	}

	public interface DistributionPageLocators {
		String checkAvaiBtnCSS = ".btn-flat.white-text.full-width.primary.campaign-status-button";
		String setAsOfferedCSS = ".btn-flat.info.campaign-status-button.white-text.full-width";
		String setAsConfirmCSS = ".btn-flat.success.campaign-status-button.white-text.full-width";
		String cancelCampCSS = ".btn-flat.btn-danger.white-text.full-width";

		String successMsgAvailCheckCSS = ".ng-binding.toast-title";
		String statusOfCampXpath = "//div[@class='span12 inline']/span";

		String successMessageChangeState = ".ng-binding.ng-scope";
		String distributionMsg2 = ".center>h6";
		String distributionMsg1 = ".distribution-result-line.green";

		String timeLineContentListXpath = "//span[@class=\"timeline-tooltip timeline-content\"]";

		String statusOnDistribution = "//div[@class='timeline-groups-text']//strong[text()='%s']/preceding::i[position()=1]";
		String pauseCampBtnCSS = ".btn-flat.white-text.full-width.btn-warning";
		String pauseCampConfirmDailogCSS = ".modal-header.ng-scope";
		String pauseCampConfirmBtn = ".btn-flat.primary";
		String pauseCampCancelBtnCSS = ".reset";
	}

	public interface LibraryPageLocators {
		String addCreativeBtnCSS = "#btn-add-creative";
		String headerSectionLibraryCSS = ".row.filter-block.header";
		String creativeListCSS = "#pad-wrapper";

		String creativeNameXpath = "//input[@data-ng-model=\"creative.name\"]";
		String creativeLengthXpath = "//input[@data-ng-model=\"creative.length\"]";
		String creativeTagsXpath = "//input[contains(@id,\"id_input_tags\")]";
		String creativeOrientationXpath = "//input[contains(@value,'%s')]";
		String uploadBtnCSS = "#__angularUploaderFileInput";
		String uploadProgressCSS = ".progress.progress-success";
		String uploadCancelBtnCSS = ".btn-link";
		String successMsgUploadCSS = ".control-info.ng-binding";
		String saveCreativesCSS = ".btn.btn-flat.primary";
		String sucessMsgCreativeCSS = ".ng-binding.ng-scope";
		String creativeOnLibraryXpath = "//div[@class=\"ad-name\"]//span[@class=\"ng-binding\" and contains(text(),'%s')]";
	}

	public interface InventoryPageLocators {
		String addInventoryButtonCSS = "#btn-add-inventory";
		String addInvetoryDialogCSS = ".modal-title";
		String inventoryNameXpath = "//input[@data-ng-model='inventory.name']";
		String invetoryTypeXpath = "//select[@data-ng-model='inventory.type']";
		String createButtonCSS = ".btn-flat.primary";
		String startButtonCSS = ".btn-flat.ng-scope.btn-success";
		String invetorySuccessMessageXpath = "//*[text()='Inventory saved successfully.']";
		String inventoryParentOptionXpath = "//select[@data-ng-model='inventory.idParent']";
		String inventoryRelationListXpath = "//h3[@class='pull-left']//a";
		String addSubItemBtnXpath = "//a[@id='btn-add-inventory-sub-item']";
		String inventoryDetalsPageDetails = "//div[@class=\"row inventory-item-props\"]";
		String searchInventoryTextBox = "//input[@data-ng-model='filterName']";
		String inventoryListInventoryName = "//div[@class='ngCanvas']/div[1]//span[text()='%s']";
		String loadingSpinnerXpath = "//div[@class='cg-busy-default-text ng-binding']";

		String optionBtnInventoryDetailPage = "//div[@class='btn-group']/a";
		String removeInventoryBtn = "//a[@data-ng-click=\"deleteInventory()\"]";
		String removeInvConfirmationPopUp = "//div[@window-class=\"inventory-confirmation-modal-window\"]";
		String removeInvwarningMsg = "//h5[contains(@class,'alert')]";
		String removeInvConfirmRemove = "//button[contains(.,'Yes, ')]";
		String removeInvCancelRemove = "//a[@ng-click=\"close()\"]";

		String inventoryDetailPageTitle = "//h3";
		String childInventoryList = "//div[@class='ngCanvas']";
		String childInventory = "//*[text()='%s']";
		String breadCrumbInventoryList = "//ul[@class=\"breadcrumb\"]/li/a";
		String settingsIcon = "//a[@ng-click=\"showDetailsView()\"]";

		// Inherintace
		String orientationPortrait = "//input[@value=\"PORTRAIT\"]";
		String orientationLandScape = "value=\"LANDSCAPE\"";

		String addProhibitionTextBox = "//input[@data-ng-model=\"model.inputCurrent\"]";
		String saveChangesBtn = "//button[@data-ng-click=\"onClickSave()\"]";
		String prohibitionValue = "//label[@class=\"ng-binding\"]";
		String prohibitionType = "//label[@class=\"taglist-category ng-binding\"]";
		String prohibitionOverwriteBtn = "//button[contains(.,'Overwrite')]";

		String backToInventory = "//i[@class=\"icon-arrow-left\"]";

		// Unreserving inventory
		String runningInventory = "//div[@data-ng-click=\"goToCampaignTab()\"]/a";
		String campListInventory = "//table[@class=\"table table-hover\"]//tbody/tr//a";
		String waitCampEle = "//table[@class=\"table table-hover\"]//tbody/tr[1]//a";
		String setAsNotReserved = ".btn-flat.btn-warning.white-text.full-width";
		String confirmNotReserved = "//div[@class=\"modal-footer ng-scope\"]/button";
		String successUnreserved = ".//div[@id='toast-container']/div";

	}
}