package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CourseConsumption {

	@FindBy(how = How.XPATH, using = "//bdi[contains(text(),'eTextbook')]")
	private WebElement searchedTextbook;

	@FindBy(how = How.XPATH, using = "//input[@title='Search or enter QR code']")
	private WebElement searchtextfield;

	@FindBy(how = How.XPATH, using = "//button[text()='Search']")
	private WebElement searchbutton;

	@FindBy(how = How.XPATH, using = "//bdi[contains(text(),'Course')]")
	private WebElement searchedcourse;

	@FindBy(how = How.XPATH, using = "//bdi[contains(text(),'Tv_Lesson')]")
	private WebElement searchedTvLesson;

	@FindBy(how = How.XPATH, using = "//bdi[contains(text(),'eTextbook')]")
	private WebElement searchedETextbook;

	@FindBy(how = How.XPATH, using = "//button[text()='Join Course']")
	private WebElement joincourse;

	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	private WebElement consentcheckbox;

	@FindBy(how = How.XPATH, using = "//button[text()='Share']")
	private WebElement shareButton;

	@FindBy(how = How.XPATH, using = "//button[text()='Do not share']")
	private WebElement doNotShareButton;

	@FindBy(how = How.XPATH, using = "//button[text()='Start learning']")
	private WebElement startLearning;

	@FindBy(how = How.XPATH, using = "//span[@class='pageNumberFullcount']")
	private WebElement pagecount;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex player-slides ml-8']/sb-player-next-navigation/button")
	private WebElement nextButton;

	@FindBy(how = How.XPATH, using = "//i[@class='close icon']")
	private WebElement closeRatingPopup;

	@FindBy(how = How.XPATH, using = "//button[@class='close-btn']")
	private WebElement closeCongratulations;

	@FindBy(how = How.XPATH, using = "//i[@class='icon-svg icon-svg--xxs icon-back mr-4']")
	private WebElement backButton;

	@FindBy(how = How.XPATH, using = "")
	private WebElement courseCompleted;

	@FindBy(how = How.XPATH, using = "//button[text()='Continue learning']")
	private WebElement continuelearningtab;

	@FindBy(how = How.XPATH, using = "//button[text()='Leave course']")
	private WebElement leaveCoursetab;

	@FindBy(how = How.XPATH, using = "//button[text()=' Leave course ']")
	private WebElement confirmLeavebutton;

	@FindBy(how = How.XPATH, using = "//a[text()=' Courses ']")
	private WebElement coursetab;

	@FindBy(how = How.XPATH, using = "//img[@alt='Navigate to Next']")
	private WebElement clickNextButton;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Batch expiring in')]")
	private WebElement batchExpiryMsg;

	@FindBy(how = How.XPATH, using = "//button[text()=' View all ']")
	private WebElement viewall;

	@FindBy(how = How.XPATH, using = "//button[text()='Close ']")
	private WebElement closetab;

	@FindBy(how = How.XPATH, using = "(//h4[@class='sb--card__title sb__ellipsis sb__ellipsis--two text-left flex-basis-1'])[1]")
	private WebElement coursetitle;

	@FindBy(how = How.XPATH, using = "//span[text()='Hindi']")
	private WebElement coursemedium;

	@FindBy(how = How.XPATH, using = "(//span[text()='Publisher: '])[1]")
	private WebElement coursepublisher;

	@FindBy(how = How.XPATH, using = "/html/body/app-root/div[1]/div/main/app-view-all/div/div/div[2]/div/div/div[2]/div/div[1]/sb-library-card/span/sb-library-card-v2/div/div[1]/div[1]/div/img")
	private WebElement courseimg;

	@FindBy(how = How.XPATH, using = "(//span[text()='Subject: '])[1]")
	private WebElement coursesubject;

	@FindBy(how = How.XPATH, using = "//span[text()='Class 1']")
	private WebElement courseclass;

	@FindBy(how = How.XPATH, using = "//p[text()='Delhi']")
	private WebElement selectAnswer;

	@FindBy(how = How.XPATH, using = "//button[text()=' Share ']")
	private WebElement shareIcon;

	@FindBy(how = How.XPATH, using = "//span[text()='Note: This course does not have a certificate']")
	private WebElement noCertificateNote;

	@FindBy(how = How.XPATH, using = "//div[@class='sbchapter__item']")
	private WebElement moduleContent;

	@FindBy(how = How.XPATH, using = "//span[text()='Credits & license info']")
	private WebElement creditAndLicenceButton;

	@FindBy(how = How.XPATH, using = "//div[text()=' License terms']")
	private WebElement licenceTermSection;

	@FindBy(how = How.XPATH, using = "//span[text()=' For details - ']/a")
	private WebElement licenceLink;

	@FindBy(how = How.XPATH, using = "(//div[@class='ng-star-inserted'])[4]/child::p")
	private WebElement description;

	@FindBy(how = How.XPATH, using = "(//span[text()='Currently, this course does not have a certificate. The course creator may attach a certificate later.'])[2]")
	private WebElement noCertificateforCourse;

	@FindBy(how = How.XPATH, using = "//div[text()=' Tap on stars to rate the content']")
	private WebElement validateRatingPopup;

	@FindBy(how = How.XPATH, using = "//div[@class='mat-select-arrow-wrapper']")
	private WebElement languageDropdown;

	@FindBy(how = How.XPATH, using = "//mat-option[@aria-label='Hindi']")
	private WebElement Hindilanguage;

	@FindBy(how = How.XPATH, using = "//div[text()='कोर्स प्रगति']")
	private WebElement SyncProgressInHindi;

	@FindBy(how = How.XPATH, using = "//div[@class='kabab-menu pull-right ng-star-inserted']")
	private WebElement kababMenu;

	@FindBy(how = How.XPATH, using = "//div[@class='kabab-menu-dropdown-content']")
	private WebElement SyncProgressNowInHindi;

	@FindBy(how = How.XPATH, using = "//p[@class='fsmall mb-0']")
	private WebElement certificaterecieveNote;

	@FindBy(how = How.XPATH, using = "//div[@class='sb-color-primary fnormal font-weight-bold mt-8']")
	private WebElement zeroPercentProgress;

	@FindBy(how = How.XPATH, using = "//a[text()=' Credits ']")
	private WebElement creditsButton;

	@FindBy(how = How.XPATH, using = "//div[text()='ATTRIBUTIONS']")
	private WebElement AttributtionsText;

	@FindBy(how = How.XPATH, using = "//div[text()='ATTRIBUTIONS']/following-sibling::div")
	private WebElement verifyAttributtionsText;

	@FindBy(how = How.XPATH, using = "//*[text()=' Profile data sharing ']")
	private WebElement profileAndDataSharingButton;

	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'Last updated on')]")
	private WebElement lastUpdatedOn;

	@FindBy(how = How.XPATH, using = "(//*[@class='certificate-course-content pl-8'])[1]/child::div")
	private WebElement firstContent;

	@FindBy(how = How.XPATH, using = "//*[@class='d-flex flex-dc flex-basis-1 ml-8']/child::div")
	private WebElement firstContentName;

	@FindBy(how = How.XPATH, using = "//button[@aria-label='zoom in']")
	private WebElement zoomIn;

	@FindBy(how = How.XPATH, using = "//button[@aria-label='zoom out']")
	private WebElement zoomOut;

	@FindBy(how = How.XPATH, using = "//span[text()='Fullscreen']/..")
	private WebElement fullScreen;


	@FindBy(how = How.XPATH, using = "//div[text()='Your score is 1/1']")
	private WebElement scoretext;
	
	public WebElement getScoretext() {
		return scoretext;
	}

	public WebElement getZoomIn() {
		return zoomIn;
	}

	public void setZoomIn(WebElement zoomIn) {
		this.zoomIn = zoomIn;
	}

	public WebElement getZoomOut() {
		return zoomOut;
	}

	public void setZoomOut(WebElement zoomOut) {
		this.zoomOut = zoomOut;
	}

	public WebElement getFullScreen() {
		return fullScreen;
	}

	public void setFullScreen(WebElement fullScreen) {
		this.fullScreen = fullScreen;
	}

	public WebElement getProfileAndDataSharingButton() {
		return profileAndDataSharingButton;
	}

	public WebElement getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public WebElement getFirstContent() {
		return firstContent;
	}

	public WebElement getFirstContentName() {
		return firstContentName;
	}

	public WebElement getCourseProgressKababMenu() {
		return CourseProgressKababMenu;
	}

	public WebElement getSyncProgress() {
		return SyncProgress;
	}

	public WebElement getSortingProgress() {
		return SortingProgress;
	}

	public WebElement getCloseChangeNamePopup() {
		return CloseChangeNamePopup;
	}

	public WebElement getDoNotShowMessageAgainCheckbox() {
		return DoNotShowMessageAgainCheckbox;
	}

	public WebElement getDoNotShowMessageAgainContinueButton() {
		return DoNotShowMessageAgainContinueButton;
	}

	public WebElement getCardNameAsCourse() {
		return CardNameAsCourse;
	}

	public WebElement getCardNameAsCourseAssesment() {
		return CardNameAsCourseAssesment;
	}

	public WebElement getCardNameAsTextbook() {
		return CardNameAsTextbook;
	}

	public WebElement getClkHomeTab() {
		return clkHomeTab;
	}

	public WebElement getClkPrevModule() {
		return clkPrevModule;
	}

	public WebElement getAssertUserNameOnPopUp() {
		return assertUserNameOnPopUp;
	}

	public WebElement getAssertStateOnPopUp() {
		return assertStateOnPopUp;
	}

	public WebElement getAssertDistrictOnPopUp() {
		return assertDistrictOnPopUp;
	}

	public WebElement getAssertMessageFollowedByCheckBox() {
		return assertMessageFollowedByCheckBox;
	}

	public WebElement getAssertContinueLearningBtn() {
		return assertContinueLearningBtn;
	}

	public WebElement getAssertCourseProgress() {
		return assertCourseProgress;
	}

	public WebElement getClkViewMore() {
		return clkViewMore;
	}

	public WebElement getClkCorrectAns1() {
		return clkCorrectAns1;
	}

	public WebElement getClkNavigateToNxt() {
		return clkNavigateToNxt;
	}

	public WebElement getClkNextBtn() {
		return clkNextBtn;
	}

	public WebElement getClkCorrectAns2() {
		return clkCorrectAns2;
	}

	public WebElement getClkCorrectAns3() {
		return clkCorrectAns3;
	}

	public WebElement getClkCorrectAns4() {
		return clkCorrectAns4;
	}

	public WebElement getClkbtnRedo() {
		return clkbtnRedo;
	}

	public WebElement getAssertModuleCompletion() {
		return assertModuleCompletion;
	}

	public WebElement getAssertSubmitToCont() {
		return assertSubmitToCont;
	}

	public WebElement getAssertTotalQuestions() {
		return assertTotalQuestions;
	}

	public WebElement getAssertQuestionAnswered() {
		return assertQuestionAnswered;
	}

	public WebElement getAssertQuestionSkipped() {
		return assertQuestionSkipped;
	}

	public WebElement getAssert0Percentage() {
		return assert0Percentage;
	}

	public WebElement getAssertCompleted() {
		return assertCompleted;
	}

	public WebElement getClkReview() {
		return clkReview;
	}

	public WebElement getAssertModuleProgress() {
		return assertModuleProgress;
	}

	public WebElement getAssertXYcomplelted() {
		return assertXYcomplelted;
	}

	public WebElement getAssertSuccessfullyCompleted() {
		return assertSuccessfullyCompleted;
	}

	public WebElement getAssertCongratulationsMsg() {
		return assertCongratulationsMsg;
	}

	public WebElement getAssertHome() {
		return assertHome;
	}

	public WebElement getAssertDigitalTextBooks() {
		return assertDigitalTextBooks;
	}

	public WebElement getAssertCourse() {
		return assertCourse;
	}

	public WebElement getAssertTVClasses() {
		return assertTVClasses;
	}

	public WebElement getAssertAllTab() {
		return assertAllTab;
	}

	public WebElement getAssertBatchStartDate() {
		return assertBatchStartDate;
	}

	public WebElement getAssertBatchEndDate() {
		return assertBatchEndDate;
	}

	public WebElement getBtnExplore() {
		return btnExplore;
	}

	public WebElement getAssertPopUpMsg() {
		return assertPopUpMsg;
	}

	public WebElement getClkLoginBtnOnPopUp() {
		return clkLoginBtnOnPopUp;
	}

	public WebElement getAssertRedirectTOC() {
		return assertRedirectTOC;
	}

	public WebElement getAssertBatchDetails() {
		return assertBatchDetails;
	}

	public WebElement getAssertTickContent() {
		return assertTickContent;
	}

	public WebElement getAssertTickCourseUnit() {
		return assertTickCourseUnit;
	}

	public WebElement getBtnStartLearning() {
		return btnStartLearning;
	}

	public WebElement getClkFullScreen() {
		return clkFullScreen;
	}

	public WebElement getClkNextIcon() {
		return clkNextIcon;
	}

	public WebElement getClkMinimize() {
		return clkMinimize;
	}

	public WebElement getClkNextModule() {
		return clkNextModule;
	}

	public WebElement getRateTheContent() {
		return rateTheContent;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public WebElement getBtnClose() {
		return btnClose;
	}

	public WebElement getAssert100Percent() {
		return assert100Percent;
	}

	public WebElement getCourseConsumed() {
		return courseConsumed;
	}

	public WebElement getClkKababMenuAfter100Percent() {
		return clkKababMenuAfter100Percent;
	}

	public WebElement getClkSyncProgress() {
		return clkSyncProgress;
	}

	public WebElement getAssertSyncProgress() {
		return assertSyncProgress;
	}

	public WebElement getfirstContent() {
		return firstContent;
	}

	public WebElement getfirstContentName() {
		return firstContentName;
	}

	public WebElement getlastUpdatedOn() {
		return lastUpdatedOn;
	}

	public WebElement getprofileAndDataSharingButton() {
		return profileAndDataSharingButton;
	}

	public WebElement getCreditsButton() {
		return creditsButton;
	}

	public WebElement getDoNotShareButton() {
		return doNotShareButton;
	}

	public WebElement getAttributtionsText() {
		return AttributtionsText;
	}

	public WebElement getVerifyAttributtionsText() {
		return verifyAttributtionsText;
	}

	public WebElement getZeroPercentProgress() {
		return zeroPercentProgress;
	}

	public WebElement getCertificaterecieveNote() {
		return certificaterecieveNote;
	}

	public WebElement getHindilanguage() {
		return Hindilanguage;
	}

	public WebElement getSyncProgressInHindi() {
		return SyncProgressInHindi;
	}

	public WebElement getKababMenu() {
		return kababMenu;
	}

	public WebElement getSyncProgressNowInHindi() {
		return SyncProgressNowInHindi;
	}

	public WebElement getValidateRatingPopup() {
		return validateRatingPopup;
	}

	public WebElement getNoCertificateforCourse() {
		return noCertificateforCourse;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getModuleContent() {
		return moduleContent;
	}

	public WebElement getCreditAndLicenceButton() {
		return creditAndLicenceButton;
	}

	public WebElement getLicenceTermSection() {
		return licenceTermSection;
	}

	public WebElement getLicenceLink() {
		return licenceLink;
	}

	public WebElement getNoCertificateNote() {
		return noCertificateNote;
	}

	public WebElement getShareIcon() {
		return shareIcon;
	}

	public WebElement getSelectAnswer() {
		return selectAnswer;
	}

	@FindBy(how = How.XPATH, using = "//button[text()=' Share ']")
	private WebElement BeforeShareButton;

	@FindBy(how = How.XPATH, using = "//bdi[text()='Sst_sem_3 deled']")
	private WebElement selectCourse;

	@FindBy(how = How.XPATH, using = "//button[text()='Do not share']")
	private WebElement DoNOtShareButton;

	@FindBy(how = How.XPATH, using = "//h4[text()=' Course modules']")
	private WebElement CourseModules;

	@FindBy(how = How.XPATH, using = "//h4[text()='Course details']")
	private WebElement CourseDetails;

	@FindBy(how = How.XPATH, using = "//mat-panel-title[text()=' Batch Details ']")
	private WebElement BatchDetails;

	@FindBy(how = How.XPATH, using = "//span[text()='Credits & license info']")
	private WebElement CreditsAndlicenseinfo;

	@FindBy(how = How.XPATH, using = "//div[text()='100% ']")
	private WebElement CourseProgress100;

	@FindBy(how = How.XPATH, using = "//div[@class='mat-select-arrow-wrapper']")
	private WebElement LanguageDropdown;

	@FindBy(how = How.XPATH, using = "//span[text()='हिंदी']")
	private WebElement LanguageHindi;

	@FindBy(how = How.XPATH, using = "//span[text()='मराठी']")
	private WebElement LanguageMarathi;

	@FindBy(how = How.XPATH, using = "//span[text()='ಕನ್ನಡ']")
	private WebElement LanguageKanada;

	@FindBy(how = How.XPATH, using = "//span[text()='বাংলা']")
	private WebElement LanguageBengali;

	@FindBy(how = How.XPATH, using = "//div[text()=' इस कंटेंट का आनंद लिया? ']")
	private WebElement HindiTextRatingPopup;

	@FindBy(how = How.XPATH, using = "//div[text()=' ಈ ಪಠ್ಯಾಂಶ ಖುಷಿ ನೀಡಿತೇ? ']")
	private WebElement KanadaTextRatingPopup;

	@FindBy(how = How.XPATH, using = "//div[text()=' हा मजकूर आवडला का?  ']")
	private WebElement MarathiTextRatingPopup;

	@FindBy(how = How.XPATH, using = "//div[text()=' এই বিষয়বস্তু উপভোগ করেছেন? ']")
	private WebElement BengaliTextRatingPopup;

	@FindBy(how = How.XPATH, using = "(//i[@class='icon ng-star-inserted active'])[3]")
	private WebElement ThirdRating;

	@FindBy(how = How.XPATH, using = "//button[text()='Continue learning']")
	private WebElement ContinueLearning;

	@FindBy(how = How.XPATH, using = "//button[text()='अभ्यास जारी रखें']")
	private WebElement ContinueLearningHindi;

	@FindBy(how = How.XPATH, using = "//button[text()='ಕಲಿಯುವುದನ್ನು ಮುಂದುವರೆಸಿ']")
	private WebElement ContinueLearningKanada;

	@FindBy(how = How.XPATH, using = "//button[text()='শেখা চালিয়ে যান']")
	private WebElement ContinueLearningBengali;

	@FindBy(how = How.XPATH, using = "//button[text()='अभ्यास सुरु ठेवा ']")
	private WebElement ContinueLearningMarathi;

	@FindBy(how = How.XPATH, using = "(//div[@class='content-metadeta__text  fnormal sb-color-gray-400'])[4]")
	private WebElement CreatedDate;

	@FindBy(how = How.XPATH, using = "(//div[@class='content-metadeta__text  fnormal sb-color-gray-400'])[5]")
	private WebElement UpdatedDate;

	@FindBy(how = How.XPATH, using = "//div[text()='Course']")
	private WebElement ContentTypeAsCourse;

	@FindBy(how = How.XPATH, using = "(//span[@title='EKSTEP'])[1]")
	private WebElement OrgName;

	@FindBy(how = How.XPATH, using = "//div[@class='kabab-menu pull-right ng-star-inserted']")
	private WebElement CourseProgressKababMenu;

	@FindBy(how = How.XPATH, using = "//div[text()=' Sync progress now']")
	private WebElement SyncProgress;

	@FindBy(how = How.XPATH, using = "//*[@id=\"DataTables_Table_0\"]/thead/tr/th[2]")
	private WebElement SortingProgress;
	// th[@class='sorting_asc']

	@FindBy(how = How.XPATH, using = "//button[@class='close-btn']")
	private WebElement CloseChangeNamePopup;

	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	private WebElement DoNotShowMessageAgainCheckbox;

	@FindBy(how = How.XPATH, using = "//button[text()=' Continue ']")
	private WebElement DoNotShowMessageAgainContinueButton;

	@FindBy(how = How.XPATH, using = "//div[text()='Course']")
	private WebElement CardNameAsCourse;

	@FindBy(how = How.XPATH, using = "//div[text()='Course Assessment']")
	private WebElement CardNameAsCourseAssesment;

	@FindBy(how = How.XPATH, using = "//div[text()='Digital Textbook']")
	private WebElement CardNameAsTextbook;

	public WebElement CardNameAsTextbook() {
		return CardNameAsTextbook;
	}

	public WebElement CardNameAsCourseAssesment() {
		return CardNameAsCourseAssesment;
	}

	public WebElement CardNameAsCourse() {
		return CardNameAsCourse;
	}

	public WebElement DoNotShowMessageAgainContinueButton() {
		return DoNotShowMessageAgainContinueButton;
	}

	public WebElement DoNotShowMessageAgainCheckbox() {
		return DoNotShowMessageAgainCheckbox;
	}

	public WebElement CloseChangeNamePopup() {
		return CloseChangeNamePopup;
	}

	public WebElement SortingProgress() {
		return SortingProgress;
	}

	public WebElement SyncProgress() {
		return SyncProgress;
	}

	public WebElement CourseProgressKababMenu() {
		return CourseProgressKababMenu;
	}

	public WebElement getOrgName() {
		return OrgName;
	}

	public WebElement getContentTypeAsCourse() {
		return ContentTypeAsCourse;
	}

	public WebElement getUpdatedDate() {
		return UpdatedDate;
	}

	public WebElement getCreatedDate() {
		return CreatedDate;
	}

	public WebElement getContinueLearningHindi() {
		return ContinueLearningHindi;
	}

	public WebElement getContinueLearningKanada() {
		return ContinueLearningKanada;
	}

	public WebElement getContinueLearningBengali() {
		return ContinueLearningBengali;
	}

	public WebElement getContinueLearningMarathi() {
		return ContinueLearningMarathi;
	}

	public WebElement getContinueLearning() {
		return ContinueLearning;
	}

	public WebElement getThirdRating() {
		return ThirdRating;
	}

	public WebElement getLanguageHindi() {
		return LanguageHindi;
	}

	public void setLanguageHindi(WebElement languageHindi) {
		LanguageHindi = languageHindi;
	}

	public WebElement getLanguageMarathi() {
		return LanguageMarathi;
	}

	public void setLanguageMarathi(WebElement languageMarathi) {
		LanguageMarathi = languageMarathi;
	}

	public WebElement getLanguageKanada() {
		return LanguageKanada;
	}

	public void setLanguageKanada(WebElement languageKanada) {
		LanguageKanada = languageKanada;
	}

	public WebElement getLanguageBengali() {
		return LanguageBengali;
	}

	public void setLanguageBengali(WebElement languageBengali) {
		LanguageBengali = languageBengali;
	}

	public WebElement getHindiTextRatingPopup() {
		return HindiTextRatingPopup;
	}

	public void setHindiTextRatingPopup(WebElement hindiTextRatingPopup) {
		HindiTextRatingPopup = hindiTextRatingPopup;
	}

	public WebElement getKanadaTextRatingPopup() {
		return KanadaTextRatingPopup;
	}

	public void setKanadaTextRatingPopup(WebElement kanadaTextRatingPopup) {
		KanadaTextRatingPopup = kanadaTextRatingPopup;
	}

	public WebElement getMarathiTextRatingPopup() {
		return MarathiTextRatingPopup;
	}

	public void setMarathiTextRatingPopup(WebElement marathiTextRatingPopup) {
		MarathiTextRatingPopup = marathiTextRatingPopup;
	}

	public WebElement getBengaliTextRatingPopup() {
		return BengaliTextRatingPopup;
	}

	public void setBengaliTextRatingPopup(WebElement bengaliTextRatingPopup) {
		BengaliTextRatingPopup = bengaliTextRatingPopup;
	}

	public WebElement getCourseclass() {
		return courseclass;
	}

	public WebElement getSelectCourse() {
		return selectCourse;
	}

	public WebElement getLanguageDropdown() {
		return LanguageDropdown;
	}

	public WebElement getCourseProgress100() {
		return CourseProgress100;
	}

	public WebElement getCourseModules() {
		return CourseModules;
	}

	public void setCourseModules(WebElement courseModules) {
		CourseModules = courseModules;
	}

	public WebElement getCourseDetails() {
		return CourseDetails;
	}

	public void setCourseDetails(WebElement courseDetails) {
		CourseDetails = courseDetails;
	}

	public WebElement getBatchDetails() {
		return BatchDetails;
	}

	public void setBatchDetails(WebElement batchDetails) {
		BatchDetails = batchDetails;
	}

	public WebElement getCreditsAndlicenseinfo() {
		return CreditsAndlicenseinfo;
	}

	public void setCreditsAndlicenseinfo(WebElement creditsAndlicenseinfo) {
		CreditsAndlicenseinfo = creditsAndlicenseinfo;
	}

	public WebElement getDoNOtShareButton() {
		return DoNOtShareButton;
	}

	public WebElement getselectCourse() {
		return selectCourse;
	}

	public WebElement getBeforeShareButton() {
		return BeforeShareButton;
	}

	@FindBy(how = How.XPATH, using = "//a[text()=' Home ']")
	private WebElement clkHomeTab;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Prev. module']")
	private WebElement clkPrevModule;

	@FindBy(how = How.XPATH, using = "(//label[text()='User Name']//following::div[text()='prod user1'])[1]")
	private WebElement assertUserNameOnPopUp;

	@FindBy(how = How.XPATH, using = "//label[text()='State']//following::div[text()='Andhra Pradesh']")
	private WebElement assertStateOnPopUp;

	@FindBy(how = How.XPATH, using = "//label[text()='District']//following::div[text()='Alluri Sita Rama Raju']")
	private WebElement assertDistrictOnPopUp;

	@FindBy(how = How.XPATH, using = "//p[text()=' I consent to share my details with the administrators of this course. All course administrators are bound by the Privacy Policy and Course Terms in their use of my data. ']")
	private WebElement assertMessageFollowedByCheckBox;

	@FindBy(how = How.XPATH, using = "//button[text()='Continue learning']")
	private WebElement assertContinueLearningBtn;

	@FindBy(how = How.XPATH, using = "//div[text()='Course progress']")
	private WebElement assertCourseProgress;

	@FindBy(how = How.XPATH, using = "(//button[contains(text(),'View more')])[1]")
	private WebElement clkViewMore;

	@FindBy(how = How.XPATH, using = "//p[text()='Tiger']")
	private WebElement clkCorrectAns1;

	@FindBy(how = How.XPATH, using = "//img[@alt='Navigate to Next']")
	private WebElement clkNavigateToNxt;

	@FindBy(how = How.XPATH, using = "(//div[text()='Next'])[1]")
	private WebElement clkNextBtn;

	@FindBy(how = How.XPATH, using = "//p[text()='Modi']")
	private WebElement clkCorrectAns2;

	@FindBy(how = How.XPATH, using = "//p[text()='Bengaluru']")
	private WebElement clkCorrectAns3;

	@FindBy(how = How.XPATH, using = "//p[text()='Delhi']")
	private WebElement clkCorrectAns4;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Redo']")
	private WebElement clkbtnRedo;

	@FindBy(how = How.XPATH, using = ("//label[text()='You have completed this module']"))
	private WebElement assertModuleCompletion;

	@FindBy(how = How.XPATH, using = ("//div[text()='Submit to continue.']"))
	private WebElement assertSubmitToCont;

	@FindBy(how = How.XPATH, using = ("//div[text()='Total questions: ']"))
	private WebElement assertTotalQuestions;

	@FindBy(how = How.XPATH, using = ("//div[text()='Questions answered: ']"))
	private WebElement assertQuestionAnswered;

	@FindBy(how = How.XPATH, using = ("//div[text()='Questions skipped: ']"))
	private WebElement assertQuestionSkipped;

	@FindBy(how = How.XPATH, using = ("//div[text()='0% ' ]"))
	private WebElement assert0Percentage;

	@FindBy(how = How.XPATH, using = ("//span[text()='Completed'] "))
	private WebElement assertCompleted;

	@FindBy(how = How.XPATH, using = ("//button[text()=' Review ']"))
	private WebElement clkReview;

	@FindBy(how = How.XPATH, using = "//div[text()='Module progress']")
	private WebElement assertModuleProgress;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'0/1 Completed')]")
	private WebElement assertXYcomplelted;

	@FindBy(how = How.XPATH, using = "//p[text()='You have successfully completed the course']")
	private WebElement assertSuccessfullyCompleted;

	@FindBy(how = How.XPATH, using = "//div[text()='Congratulations!!']")
	private WebElement assertCongratulationsMsg;

	@FindBy(how = How.XPATH, using = "//a[text()=' Home ']")
	private WebElement assertHome;

	@FindBy(how = How.XPATH, using = "//a[text()=' Digital textbooks ']")
	private WebElement assertDigitalTextBooks;

	@FindBy(how = How.XPATH, using = "(//a[text()=' Courses '])[1]")
	private WebElement assertCourse;

	@FindBy(how = How.XPATH, using = "//a[text()=' TV classes ']")
	private WebElement assertTVClasses;

	@FindBy(how = How.XPATH, using = "//a[text()=' TV classes ']")
	private WebElement assertAllTab;

	@FindBy(how = How.XPATH, using = "//div[text()=' Batch start date']//following::div[contains(text(),'2023')][1]")
	private WebElement assertBatchStartDate;

	@FindBy(how = How.XPATH, using = "//div[text()=' Batch end date']//following::div[contains(text(),'2023')][1]	")
	private WebElement assertBatchEndDate;

	@FindBy(how = How.XPATH, using = "//button[text()='Explore DIKSHA']")
	private WebElement btnExplore;

	@FindBy(how = How.XPATH, using = "//div[text()=' To access the course you have to log in and join the course ']")
	private WebElement assertPopUpMsg;

	@FindBy(how = How.XPATH, using = "//a[text()=' Login ']")
	private WebElement clkLoginBtnOnPopUp;

	@FindBy(how = How.XPATH, using = "//h4[text()=' Course modules']")
	private WebElement assertRedirectTOC;

	@FindBy(how = How.XPATH, using = "//mat-panel-title[text()=' Batch Details ']")
	private WebElement assertBatchDetails;

	@FindBy(how = How.XPATH, using = "//i[@class='icon-svg icon-svg--sm ng-star-inserted']")
	private WebElement assertTickContent;

	@FindBy(how = How.XPATH, using = "//i[@aria-label='tick-icon']")
	private WebElement assertTickCourseUnit;

	public WebElement getcourseclass() {
		return courseclass;
	}

	public WebElement getCoursetab() {
		return coursetab;
	}

	public void setCoursetab(WebElement coursetab) {
		this.coursetab = coursetab;
	}

	public WebElement getViewall() {
		return viewall;
	}

	public void setViewall(WebElement viewall) {
		this.viewall = viewall;
	}

	public WebElement getClosetab() {
		return closetab;
	}

	public void setClosetab(WebElement closetab) {
		this.closetab = closetab;
	}

	public WebElement getCoursetitle() {
		return coursetitle;
	}

	public void setCoursetitle(WebElement coursetitle) {
		this.coursetitle = coursetitle;
	}

	public WebElement getCoursemedium() {
		return coursemedium;
	}

	public void setCoursemedium(WebElement coursemedium) {
		this.coursemedium = coursemedium;
	}

	public WebElement getCoursepublisher() {
		return coursepublisher;
	}

	public void setCoursepublisher(WebElement coursepublisher) {
		this.coursepublisher = coursepublisher;
	}

	public WebElement getCourseimg() {
		return courseimg;
	}

	public void setCourseimg(WebElement courseimg) {
		this.courseimg = courseimg;
	}

	public WebElement getCoursesubject() {
		return coursesubject;
	}

	public void setCoursesubject(WebElement coursesubject) {
		this.coursesubject = coursesubject;
	}

	public WebElement getSearchedTextbook() {
		return searchedTextbook;
	}

	public WebElement getsearchedTextbook() {
		return searchedTextbook;
	}

	public WebElement getBatchExpiryMsg() {
		return batchExpiryMsg;
	}

	public WebElement getClickNextButton() {
		return clickNextButton;
	}

	public WebElement getSearchedETextbook() {
		return searchedETextbook;
	}

	public WebElement getSearchedTvLesson() {
		return searchedTvLesson;
	}

	public WebElement getConfirmLeavebutton() {
		return confirmLeavebutton;
	}

	public WebElement getContinuelearningtab() {
		return continuelearningtab;
	}

	public WebElement getLeaveCoursetab() {
		return leaveCoursetab;
	}

	public WebElement getcontinuelearningtab() {
		return continuelearningtab;
	}

	public WebElement getSearchtextfield() {
		return searchtextfield;
	}

	public void setSearchtextfield(WebElement searchtextfield) {
		this.searchtextfield = searchtextfield;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public void setSearchbutton(WebElement searchbutton) {
		this.searchbutton = searchbutton;
	}

	public WebElement getSearchedcourse() {
		return searchedcourse;
	}

	public void setSearchedcourse(WebElement searchedcourse) {
		this.searchedcourse = searchedcourse;
	}

	public WebElement getJoincourse() {
		return joincourse;
	}

	public void setJoincourse(WebElement joincourse) {
		this.joincourse = joincourse;
	}

	public WebElement getConsentcheckbox() {
		return consentcheckbox;
	}

	public void setConsentcheckbox(WebElement consentcheckbox) {
		this.consentcheckbox = consentcheckbox;
	}

	public WebElement getShareButton() {
		return shareButton;
	}

	public void setShareButton(WebElement shareButton) {
		this.shareButton = shareButton;
	}

	public WebElement getStartLearning() {
		return startLearning;
	}

	public void setStartLearning(WebElement startLearning) {
		this.startLearning = startLearning;
	}

	public WebElement getPagecount() {
		return pagecount;
	}

	public void setPagecount(WebElement pagecount) {
		this.pagecount = pagecount;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	public void setNextButton(WebElement nextButton) {
		this.nextButton = nextButton;
	}

	public WebElement getCloseRatingPopup() {
		return closeRatingPopup;
	}

	public void setCloseRatingPopup(WebElement closeRatingPopup) {
		this.closeRatingPopup = closeRatingPopup;
	}

	public WebElement getCloseCongratulations() {
		return closeCongratulations;
	}

	public void setCloseCongratulations(WebElement closeCongratulations) {
		this.closeCongratulations = closeCongratulations;
	}

	public WebElement getBackButton() {
		return backButton;
	}

	public void setBackButton(WebElement backButton) {
		this.backButton = backButton;
	}

	public WebElement getCourseCompleted() {
		return courseCompleted;
	}

	public void setCourseCompleted(WebElement courseCompleted) {
		this.courseCompleted = courseCompleted;
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Start learning']")
	private WebElement btnStartLearning;

	@FindBy(how = How.XPATH, using = "//span[text()='Fullscreen']")
	private WebElement clkFullScreen;

	@FindBy(how = How.XPATH, using = "(//button[@aria-label='navigation-arrows-nextIcon'])[1]")
	private WebElement clkNextIcon;

	@FindBy(how = How.XPATH, using = "//span[text()='Minimize']")
	private WebElement clkMinimize;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Next module']")
	private WebElement clkNextModule;

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='Tap on stars to rate the content']//preceding::i[@class='icon ng-star-inserted']")
	private WebElement rateTheContent;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Submit']")
	private WebElement btnSubmit;

	@FindBy(how = How.XPATH, using = "//button[@aria-label='close dialog']")
	private WebElement btnClose;

	@FindBy(how = How.XPATH, using = "//div[text()='100% ']")
	private WebElement assert100Percent;

	@FindBy(how = How.XPATH, using = "//span[text()='Completed']")
	private WebElement courseConsumed;

	@FindBy(how = How.XPATH, using = "//div[@class='kabab-menu pull-right ng-star-inserted']")
	private WebElement clkKababMenuAfter100Percent;

	@FindBy(how = How.XPATH, using = "//div[text()=' Sync progress now']")
	private WebElement clkSyncProgress;

	@FindBy(how = How.XPATH, using = "//strong[text()='You can view your updated course progress within 24 hours']")
	private WebElement assertSyncProgress;

	public WebElement getclkHomeTab() {
		return clkHomeTab;
	}

	public WebElement getclkPrevModule() {
		return clkPrevModule;
	}

	public WebElement getassertUserNameOnPopUp() {
		return assertUserNameOnPopUp;
	}

	public WebElement getassertStateOnPopUp() {
		return assertStateOnPopUp;
	}

	public WebElement getassertDistrictOnPopUp() {
		return assertDistrictOnPopUp;
	}

	public WebElement getassertMessageFollowedByCheckBox() {
		return assertMessageFollowedByCheckBox;
	}

	public WebElement getassertContinueLearningBtn() {
		return assertContinueLearningBtn;
	}

	public WebElement getassertCourseProgress() {
		return assertCourseProgress;
	}

	public WebElement getclkViewMore() {
		return clkViewMore;
	}

	public WebElement getclkCorrectAns1() {
		return clkCorrectAns1;
	}

	public WebElement getclkNavigateToNxt() {
		return clkNavigateToNxt;
	}

	public WebElement getclkNextBtn() {
		return clkNextBtn;
	}

	public WebElement getclkCorrectAns2() {
		return clkCorrectAns2;
	}

	public WebElement getclkCorrectAns3() {
		return clkCorrectAns3;
	}

	public WebElement getclkCorrectAns4() {
		return clkCorrectAns4;
	}

	public WebElement getclkbtnRedo() {
		return clkbtnRedo;
	}

	public WebElement getassertModuleCompletion() {
		return assertModuleCompletion;
	}

	public WebElement getassertSubmitToCont() {
		return assertSubmitToCont;
	}

	public WebElement getassertTotalQuestions() {
		return assertTotalQuestions;
	}

	public WebElement getassertQuestionAnswered() {
		return assertQuestionAnswered;
	}

	public WebElement getassertQuestionSkipped() {
		return assertQuestionSkipped;
	}

	public WebElement getassert0Percentage() {
		return assert0Percentage;
	}

	public WebElement getassertCompleted() {
		return assertCompleted;
	}

	public WebElement getclkReview() {
		return clkReview;
	}

	public WebElement getassertModuleProgress() {
		return assertModuleProgress;
	}

	public WebElement getassertXYcomplelted() {
		return assertXYcomplelted;
	}

	public WebElement getassertSuccessfullyCompleted() {
		return assertSuccessfullyCompleted;
	}

	public WebElement getassertCongratulationsMsg() {
		return assertCongratulationsMsg;
	}

	public WebElement getassertHome() {
		return assertHome;
	}

	public WebElement getassertDigitalTextBooks() {
		return assertDigitalTextBooks;
	}

	public WebElement getassertCourse() {
		return assertCourse;
	}

	public WebElement getassertTVClasses() {
		return assertTVClasses;
	}

	public WebElement getassertAllTab() {
		return assertAllTab;
	}

	public WebElement getassertBatchStartDate() {
		return assertBatchStartDate;
	}

	public WebElement getassertBatchEndDate() {
		return assertBatchEndDate;
	}

	public WebElement getbtnExplore() {
		return btnExplore;
	}

	public WebElement getassertPopUpMsg() {
		return assertPopUpMsg;
	}

	public WebElement getclkLoginBtnOnPopUp() {
		return clkLoginBtnOnPopUp;
	}

	public WebElement getassertRedirectTOC() {
		return assertRedirectTOC;
	}

	public WebElement getassertBatchDetails() {
		return assertBatchDetails;
	}

	public WebElement getassertTickContent() {
		return assertTickContent;
	}

	public WebElement getassertTickCourseUnit() {
		return assertTickCourseUnit;
	}

	public WebElement getbtnStartLearning() {
		return btnStartLearning;
	}

	public WebElement getclkNextIcon() {
		return clkNextIcon;
	}

	public WebElement getrateTheContent() {
		return rateTheContent;
	}

	public WebElement getbtnSubmit() {
		return btnSubmit;
	}

	public WebElement getbtnClose() {
		return btnClose;
	}

	public WebElement getassert100Percent() {
		return assert100Percent;
	}

	public WebElement getassertcourseConsumed() {
		return courseConsumed;
	}

	public WebElement getclkKababMenuAfter100Percent() {
		return clkKababMenuAfter100Percent;
	}

	public WebElement getclkSyncProgress() {
		return clkSyncProgress;
	}

	public WebElement getassertSyncProgress() {
		return assertSyncProgress;
	}

	public WebElement getclkNextModule() {
		return clkNextModule;
	}
}
