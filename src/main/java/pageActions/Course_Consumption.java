package pageActions;

import java.awt.Window;
import java.util.concurrent.TimeUnit;
import org.apache.commons.math3.analysis.solvers.BaseSecantSolver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObject.CourseAssesment;
import pageObject.CourseConsumption;
import pageObject.CreateBatchForCourse;
import pageObject.LoginPage;
import pageObject.Logout;
import pageObject.UploadPdfContent;
import pageObject.ValidatePopUp;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.Library;
import utility.Listeners;

public class Course_Consumption extends BaseClass {

	public static void consume_PDF_Course_Content(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);

		Thread.sleep(7000);
		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());

		String pagecount = cc.getPagecount().getText();
		int Count = Integer.parseInt(pagecount);

		for (int i = 1; i < Count; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(cc.getCloseCongratulations());
		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());

	}

	public static void consumeCourseContent(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String expect = "User should be able to consume course successfully";
		String actual = "User is unable to consume course";
		String Congratulation = null;
		
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);

		try {
		Thread.sleep(7000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());
		Thread.sleep(2000);
		String pagecount = cc.getPagecount().getText();
		int Count = Integer.parseInt(pagecount);

		for (int i = 1; i < Count; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}

		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getCloseRatingPopup());
		Thread.sleep(1000);

		WebElement ContentSavePopup = driver.findElement(By.xpath("//div[text()='Congratulations!!']"));
		
		Congratulation = popup.getCompletionCongratulationPopup().getText();
		Assert.assertEquals(Congratulation, "Congratulations!!");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getCloseCongratulations());
		DikshaUtils.waitToBeVisibleAndClick(cc.getBackButton());

		actual = "User is able to consume course successfully";
	} finally {
		String Text = Congratulation != null ? Congratulation : "N/A";
		Listeners.customAssert("Congratulations!!", Text, expect, actual);
	}
		
	}

	public static void UserAbleToConsumeContentChangeLanguageAndVerifyPopup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);

		Thread.sleep(2000);

		DikshaUtils.waitToBeClickableAndClick(cc.getLanguageDropdown());
		DikshaUtils.waitToBeClickableAndClick(cc.getLanguageMarathi());
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());

		String pagecount = cc.getPagecount().getText();
		int Count = Integer.parseInt(pagecount);

		for (int i = 1; i < Count; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}

		Thread.sleep(1000);
		Assert.assertTrue(cc.getMarathiTextRatingPopup().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(cc.getCloseCongratulations());
		DikshaUtils.waitToBeVisibleAndClick(cc.getBackButton());

		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getLanguageDropdown());
		DikshaUtils.waitToBeClickableAndClick(cc.getLanguageHindi());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getContinueLearningHindi());

		for (int i = 1; i < Count; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}

		Thread.sleep(1000);
		Assert.assertTrue(cc.getHindiTextRatingPopup().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getBackButton());

		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getLanguageDropdown());
		DikshaUtils.waitToBeVisibleAndClick(cc.getLanguageBengali());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getContinueLearningBengali());

		for (int i = 1; i < Count; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}

		Thread.sleep(1000);
		Assert.assertTrue(cc.getBengaliTextRatingPopup().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getBackButton());

		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getLanguageDropdown());
		DikshaUtils.waitToBeVisibleAndClick(cc.getLanguageKanada());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getContinueLearningKanada());

		for (int i = 1; i < Count; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}

		Thread.sleep(1000);
		Assert.assertTrue(cc.getKanadaTextRatingPopup().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getBackButton());

	}

	public static void ValidateConsumetionOfCourse100() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		Thread.sleep(1000);
		Assert.assertTrue(cc.getCourseProgress100().isDisplayed());
		DikshaUtils.waitToBeVisibleAndClick(cc.getBackButton());

	}

	public static void verifySyncProgressInRegionalLanguage(String coursename) throws InterruptedException {

CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		
		String RegionalLanguage = null;
	     String expect = "Custodian user should be able to verify sync progress in Regional Language Sucessfully";
	     String actual = "Custodian user is unable to verify sync progress in Regional Language";
		try {
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getLanguageDropdown());
		DikshaUtils.waitToBeClickableAndClick(cc.getHindilanguage());
		Thread.sleep(1000);
		Assert.assertTrue(cc.getSyncProgressInHindi().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getKababMenu());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getSyncProgressNowInHindi().isDisplayed());
		RegionalLanguage=cc.getSyncProgressNowInHindi().getText();
		DikshaUtils.waitToBeClickableAndClick(cc.getSyncProgressNowInHindi());
		actual = "Custodian user is able to verify sync progress in Regional Language Sucessfully";

		} finally {
			String Text = RegionalLanguage != null ? RegionalLanguage : "N/A";
			Listeners.customAssert(" अब प्रगति को समन्वयित करें", Text, expect, actual);
		}
	}

	public static void verifyCoursePlaysModulesWise(String coursename) throws InterruptedException {

		String expect = "Course should be plays modules wise";
		String actual = "Course did not plays modules wise";
		String ContentsuccessfullyConsume = null;
		try {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(4000);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Assert.assertTrue(createBatch.getCourseModulesText().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getModuleContent());
		Thread.sleep(1000);
		Assert.assertTrue(cc.getShareIcon().isDisplayed());

		String pagecount = cc.getPagecount().getText();
		int Count = Integer.parseInt(pagecount);

		for (int i = 1; i < Count; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
		Thread.sleep(1000);
		
		WebElement ContentSavePopup = driver.findElement(By.xpath("//div[text()='Congratulations!!']"));

        ContentsuccessfullyConsume = ContentSavePopup.getText();

		DikshaUtils.waitToBeVisibleAndClick(cc.getCloseCongratulations());
		actual = "Course are plays modules wise";
		}finally {
			String Text = ContentsuccessfullyConsume != null ? ContentsuccessfullyConsume : "N/A";

            Listeners.customAssert("Congratulations!!", Text, expect, actual);
			
		}
	}

//	public static void searchContentForConsumption(String coursename) throws InterruptedException {
//
//		WebElement home = null;
//	    String except = "Search content for consumption " + coursename + " Successfully";
//	    String actual = "Unable to search content for consumption  " + coursename;
//	    
//	    try {
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
//
//		Thread.sleep(2000);
//		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
//		Thread.sleep(1000);
//		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
//
//		DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
//		
//		home = driver.findElement(By.xpath("//*[text()=' Home ']"));
//        Thread.sleep(2000);
//        
//        actual = "Successfully login as " + coursename;
//    }  finally {
//        String homeText = home != null ? home.getText() : "N/A";
//        System.out.println(homeText);
//        Listeners.customAssert("Home", homeText, except, actual);
//    }
//}
	
	public static void searchContentForConsumption(String coursename) throws InterruptedException {
        
		WebElement loginPopup = null;
		String expect = "Login Popup Should Appear";
		String actual = "Login Popup Not Appeared";
		try {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        CourseConsumption cc=PageFactory.initElements(driver, CourseConsumption.class);
        Thread.sleep(2000);
        DikshaUtils.waitToBeClickableAndSendKeys(cc.getSearchtextfield(), coursename);
       // Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
        Thread.sleep(1000);
        DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());

        DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
        DikshaUtils.waitForElementToBeVisible(cc.getJoincourse());
        DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
        Thread.sleep(3000);

		loginPopup = driver.findElement(By.xpath("//*[contains(text(),'Login')]"));
		Thread.sleep(2000);

		actual = "Login Popup is Appeared";
	} finally {
		String loginPopupText = loginPopup != null ? loginPopup.getText() : "N/A";
		System.out.println(loginPopupText);
		Listeners.customAssert("Login", loginPopupText, expect, actual);
	}
	}

	public static void searchContentAndConsumption(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndSendKeys(cc.getSearchtextfield(), coursename);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getsearchedTextbook());

		Thread.sleep(1000);
		String pagecount = cc.getPagecount().getText();
		int Count = Integer.parseInt(pagecount);

		for (int i = 1; i < Count; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}

		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());

	}

	public static void UserDisplayCourseCardDetailsAndViewAllAndCloseButttonInMyCourseSection() throws Exception {

		String expected1 = "Verify user should be able to see course card details in my course section successfully";
		String actual1 = "User is not able to see course card details in my course section successfully";

		boolean checkDetails = false;
		String expectedDetails = "NA";

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		try {

			if (cc.getCoursetab().isDisplayed()) {
				checkDetails = true;

				DikshaUtils.waitToBeClickableAndClick(cc.getCoursetab());
				Assert.assertTrue(cc.getViewall().isDisplayed());
				DikshaUtils.waitToBeClickableAndClick(cc.getViewall());
				Thread.sleep(2000);
				Assert.assertTrue(cc.getCourseimg().isDisplayed());
				Assert.assertTrue(cc.getCoursetitle().isDisplayed());
//				Assert.assertTrue(cc.getCoursemedium().isDisplayed());
//				System.out.println("Course Medium Is Displayed");
//				Assert.assertTrue(cc.getcourseclass().isDisplayed());
//				System.out.println("Course Class Is Displayed");
				Assert.assertTrue(cc.getCoursepublisher().isDisplayed());
				Assert.assertTrue(cc.getCoursesubject().isDisplayed());
				Thread.sleep(2000);
				Assert.assertTrue(cc.getClosetab().isDisplayed());
				System.out.println("Close Button Is Displayed");

				actual1 = "User is able to see course card details in my course section successfully";
				expectedDetails = "True";
			}

		} finally {

			Listeners.customAssert("True", expectedDetails, expected1, actual1);

		}
	}

	public static void consumeCourseAssesment(String coursename) throws Exception {

		String expect = "User should consume course assesment successfully";
		String actual = "Unable to consume course assesment";
		String ContentsuccessfullyConsume = null;
		try {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		CourseAssesment assesment = PageFactory.initElements(driver, CourseAssesment.class);

		Thread.sleep(7000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());

		String pagecount = cc.getPagecount().getText();
		int Count = Integer.parseInt(pagecount);

		for (int i = 1; i < Count; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
		Thread.sleep(1000);

		WebElement ContentSavePopup = driver.findElement(By.xpath("//div[text()='Congratulations!!']"));
		ContentsuccessfullyConsume = ContentSavePopup.getText();
		Assert.assertEquals(ContentsuccessfullyConsume, "Congratulations!!");
		actual = "User consume course assesment successfully";
		}finally {
			String Text = ContentsuccessfullyConsume != null ? ContentsuccessfullyConsume : "N/A";
			System.out.println(Text);
            Listeners.customAssert("Congratulations!!", Text, expect, actual);
			
		}
	}

	public static void verifyCourseProgressIfUserConsumesPDFIncomplete(String coursename) throws InterruptedException {

		String expect = "Course progress should be display after fully consume PDF";
		String actual = "Course progress is not display after fully consume PDF";
		String ContentsuccessfullyConsume = null;
		try {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);

		Thread.sleep(7000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());
		for (int i = 1; i < 2; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}
		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		String progress = cc.getZeroPercentProgress().getText();
		System.out.println(progress);
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());
		// Assert.assertEquals(progress, "Congratulations!!");
		String pagecount = cc.getPagecount().getText();
		int Count = Integer.parseInt(pagecount);

		for (int i = 1; i < Count; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
		Thread.sleep(1000);

		WebElement ContentSavePopup = driver.findElement(By.xpath("//div[text()='Congratulations!!']"));
		ContentsuccessfullyConsume = ContentSavePopup.getText();
		//Assert.assertEquals(ContentsuccessfullyConsume, "Congratulations!!");
		actual = "Course progress is display after fully consume PDF";
		}finally {
			String Text = ContentsuccessfullyConsume != null ? ContentsuccessfullyConsume : "N/A";
			System.out.println(Text);
            Listeners.customAssert("Congratulations!!", Text, expect, actual);
			
		}
	}

	public static void consumeCourseAndValidateRecieveCetificateNote(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		String certificateRecieveNote = null;
		String expect = "Custodian user should be able to consume content and get certificate recieve message Sucessfully";
		String actual = "Custodian user is unable to consume content and get certificate recieve message";
		try {
		Thread.sleep(7000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());

		String pagecount = cc.getPagecount().getText();
		int Count = Integer.parseInt(pagecount);

		for (int i = 1; i < Count; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
		Thread.sleep(1000);

		WebElement ContentSavePopup = driver.findElement(By.xpath("//div[text()='Congratulations!!']"));
		String ContentsuccessfullyConsume = ContentSavePopup.getText();
		Assert.assertEquals(ContentsuccessfullyConsume, "Congratulations!!");
		Thread.sleep(1000);

		 certificateRecieveNote = cc.getCertificaterecieveNote().getText();
		Assert.assertEquals(certificateRecieveNote,
				"You will be notified about the course certificate on your registered contact details within 7 days");
		
		actual = "Custodian user is able to consume content and get certificate recieve message Sucessfully";

		} finally {
			String Text = certificateRecieveNote != null ? certificateRecieveNote : "N/A";
			Listeners.customAssert(certificateRecieveNote, Text, expect, actual);
		}
	}

	public static void verifyDifferentFieldsInCourseAssessment(String coursename) throws Exception {

		String expect = "Licence term section should be display in course TOC";
		String actual = "Licence term section is not display in";
		String licenceTermSection = null;
		try {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		CourseAssesment assesment = PageFactory.initElements(driver, CourseAssesment.class);

		Thread.sleep(5000);
		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		Thread.sleep(1000);
		Assert.assertTrue(cc.getCreditAndLicenceButton().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getCreditAndLicenceButton());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		Assert.assertTrue(cc.getLicenceTermSection().isDisplayed());
		Assert.assertTrue(cc.getLicenceLink().isDisplayed());
		licenceTermSection = cc.getLicenceTermSection().getText();
		actual = "Licence term section is display in course TOC";
		}finally {
			
			String Text = licenceTermSection != null ? licenceTermSection : "N/A";
			System.out.println(Text);
            Listeners.customAssert("License terms", Text, expect, actual);
			
		}
	}

	public static void verifyAttributNameInCourse(String coursename) throws Exception {

		String expect = "Attribution name should be displayed to user";
		String actual = "Attribution name is not displayed to user";
		String text = null;
		try {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		CourseAssesment assesment = PageFactory.initElements(driver, CourseAssesment.class);

		Thread.sleep(5000);
		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		Thread.sleep(1000);
		Assert.assertTrue(cc.getCreditAndLicenceButton().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getCreditAndLicenceButton());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getCreditsButton());
		Thread.sleep(1000);
		Assert.assertTrue(cc.getAttributtionsText().isDisplayed());
		text = cc.getVerifyAttributtionsText().getText();
		//Assert.assertEquals(text, "One, Three, Two");
		actual = "Attribution is displayed to user";
		}finally {
			String Text = text != null ? text : "N/A";
			Listeners.customAssert("One, Three, Two", Text, expect, actual);
			
		}

	}

	public static void verifyCertificateNameEditPopup(String coursename) throws Exception {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		CourseAssesment assesment = PageFactory.initElements(driver, CourseAssesment.class);

		Thread.sleep(5000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());

	}

	public static void VerifyDescriptionAndConsumeCourseAssesment(String coursename) throws Exception {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		CourseAssesment assesment = PageFactory.initElements(driver, CourseAssesment.class);

		Thread.sleep(5000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		Thread.sleep(1000);
		Assert.assertTrue(cc.getDescription().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());
		Thread.sleep(4000);
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getSelectAnswer());
		DikshaUtils.waitToBeClickableAndClick(assesment.getQueNextButton());
		Thread.sleep(1000);
		Assert.assertTrue(assesment.getTotalQuestions().isDisplayed());
		Assert.assertTrue(assesment.getQuestionsAnswered().isDisplayed());
		Assert.assertTrue(assesment.getQuestionsSkipped().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(assesment.getSubmitcourseassesmentbutton());
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		DikshaUtils.waitToBeClickableAndClick(assesment.getSelectRating());
		DikshaUtils.waitToBeClickableAndClick(assesment.getSubmitButton());
		Thread.sleep(2000);
		WebElement ContentSavePopup = driver.findElement(By.xpath("//div[text()='Congratulations!!']"));
		String ContentsuccessfullyConsume = ContentSavePopup.getText();
		Assert.assertEquals(ContentsuccessfullyConsume, "Congratulations!!");
		Thread.sleep(6000);
		DikshaUtils.waitToBeClickableAndClick(assesment.getCongratulationCloseButton());
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		Thread.sleep(1000);

	}

	public static void verifyNoCertificateForCourse(String coursename) throws Exception {


		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		CourseAssesment assesment = PageFactory.initElements(driver, CourseAssesment.class);

		String noCertificateNote = null;
		String expect = "Custodian user should be able to view no certificate note for course Sucessfully";
		String actual = "Custodian user is unable to view no certificate note for course ";
		try {
		Thread.sleep(5000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		Thread.sleep(1000);
		Assert.assertTrue(cc.getDescription().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getNoCertificateforCourse().isDisplayed());
		noCertificateNote=cc.getNoCertificateforCourse().getText();
		actual = "Custodian user is able to view no certificate for course Sucessfully";

		} finally {
			String Text = noCertificateNote != null ? noCertificateNote : "N/A";
			Listeners.customAssert(noCertificateNote, Text, expect, actual);
		}
	}

	public static void verifyNumberOfAttempts(String coursename) throws Exception {

		String expect = "User should be able to attempt only specified number of attempts";
		String actual = "Unable to attempt only specified number of attempts";
		String courselimit = null;
		try {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		CourseAssesment assesment = PageFactory.initElements(driver, CourseAssesment.class);

		Thread.sleep(6000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());
		Thread.sleep(4000);
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getSelectAnswer());
		DikshaUtils.waitToBeClickableAndClick(assesment.getQueNextButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(assesment.getSubmitcourseassesmentbutton());
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		DikshaUtils.waitToBeClickableAndClick(assesment.getSelectRating());
		DikshaUtils.waitToBeClickableAndClick(assesment.getSubmitButton());

		Thread.sleep(2000);

		WebElement ContentSavePopup = driver.findElement(By.xpath("//div[text()='Congratulations!!']"));
		String ContentsuccessfullyConsume = ContentSavePopup.getText();
		Assert.assertEquals(ContentsuccessfullyConsume, "Congratulations!!");
		Thread.sleep(6000);
		DikshaUtils.waitToBeClickableAndClick(assesment.getCongratulationCloseButton());
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(assesment.getRedoButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getSelectAnswer());
		DikshaUtils.waitToBeClickableAndClick(assesment.getQueNextButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(assesment.getSubmitcourseassesmentbutton());
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		DikshaUtils.waitToBeClickableAndClick(assesment.getSelectRating());
		DikshaUtils.waitToBeClickableAndClick(assesment.getSubmitButton());
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(assesment.getRedoButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getSelectAnswer());
		DikshaUtils.waitToBeClickableAndClick(assesment.getQueNextButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(assesment.getSubmitcourseassesmentbutton());
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		DikshaUtils.waitToBeClickableAndClick(assesment.getSelectRating());
		DikshaUtils.waitToBeClickableAndClick(assesment.getSubmitButton());
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		DikshaUtils.waitToBeClickableAndClick(assesment.getRedoButton());
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		courselimit = assesment.getLimitExceedText().getText();
		//Assert.assertEquals(courselimit, " You have exceeded the maximum number of attempts that can be submitted ");
		actual = "Successfully attempt only specified number of attempts";
		}finally {
			String Text = courselimit != null ? courselimit : "N/A";
			Listeners.customAssert("You have exceeded the maximum number of attempts that can be submitted", Text, expect, actual);
			
		}
	}
	public static void verifyGreenTick(String coursename) throws Exception {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		CourseAssesment assesment = PageFactory.initElements(driver, CourseAssesment.class);
		String greenTick = null;
		String expect = "Custodian user should be able to verify that share icon is default enabled Sucessfully";
		String actual = "Custodian user is unable to verify  share icon is default enabled";
		try {
		Thread.sleep(6000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(3000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());
		Thread.sleep(4000);
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getSelectAnswer());
		DikshaUtils.waitToBeClickableAndClick(assesment.getQueNextButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(assesment.getSubmitcourseassesmentbutton());
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		DikshaUtils.waitToBeClickableAndClick(assesment.getSelectRating());
		DikshaUtils.waitToBeClickableAndClick(assesment.getSubmitButton());

		Thread.sleep(2000);
		WebElement ContentSavePopup = driver.findElement(By.xpath("//div[text()='Congratulations!!']"));
		String ContentsuccessfullyConsume = ContentSavePopup.getText();
		Assert.assertEquals(ContentsuccessfullyConsume, "Congratulations!!");
		Thread.sleep(6000);
		DikshaUtils.waitToBeClickableAndClick(assesment.getCongratulationCloseButton());
		Thread.sleep(1000);
		Assert.assertTrue(assesment.getGreenTick().isDisplayed());
		greenTick=assesment.getGreenTick().getText();
		actual = "Custodian user is able to verify that share icon is default enabled Sucessfully";

		} finally {
			String Text = greenTick != null ? greenTick : "N/A";
			Listeners.customAssert(greenTick, Text, expect, actual);
		}
	}
	public static void verifyConsentPopUp(String coursename) throws InterruptedException {
		String expect = "Consent PopUp should not displayed for minor user";
		String actual = "Consent PopUp should is displayed for minor user";
		String startLearning =null;
		try {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);

		Thread.sleep(7000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		Assert.assertTrue(cc.getStartLearning().isDisplayed());
		startLearning = cc.getStartLearning().getText();
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());
		actual = "Consent PopUp is not displayed for minor user";
		}finally {
			String Text = startLearning != null ? startLearning : "N/A";
			System.out.println(Text);
			Listeners.customAssert("Start learning", Text, expect, actual);
			
		}

	}

	public static void verifyShareButtonIsDefaultDisableInConsentPopUp(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		String shareButton = null;
		String expect = "Custodian user should be able to verify that share icon is default enabled Sucessfully";
		String actual = "Custodian user is unable to verify  share icon is default enabled";
		try {
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
		shareButton=cc.getShareButton().getText();
		Assert.assertFalse(cc.getShareButton().isEnabled());
		actual = "Custodian user is able to verify that share icon is default enabled Sucessfully";

		} finally {
			String Text = shareButton != null ? shareButton : "N/A";
			Listeners.customAssert(shareButton, Text, expect, actual);
		}
	}

	public static void verifyDoNotShareButtonForConsentPopUp(String coursename) throws InterruptedException {
		
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);

		
		String expect = "Consent should be off post clicking donotshare button";
		String actual = "Consent is not off post clicking donotshare button";
		String startLearning = null;
	
		
		try {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		Thread.sleep(7000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(000);
		Assert.assertTrue(cc.getDoNotShareButton().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getDoNotShareButton());
		Thread.sleep(1000);
		Assert.assertTrue(cc.getStartLearning().isDisplayed());
		startLearning = cc.getStartLearning().getText();
		actual = "Consent is off post clicking donotshare button";
		}finally {
			String Text = startLearning != null ? startLearning : "N/A";
			System.out.println(Text);
			Listeners.customAssert("Start learning", Text, expect, actual);
			
		}

	}

	public static void verifyEitherShareOrDoNotShareButtonsInconsentPopUp(String coursename)
			throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);

		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(000);
		Assert.assertTrue(cc.getDoNotShareButton().isDisplayed());
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getShareButton().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());

	}

	public static void consumePdfMp4AndAssessmentContent(String coursename) throws InterruptedException {
		String expect = "User should consume the content successfully";
		String actual = "Unable to consume the content";
		String courseProgress = null;
		try {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CourseAssesment assesment = PageFactory.initElements(driver, CourseAssesment.class);
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);

		Thread.sleep(7000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());

		String pagecount = cc.getPagecount().getText();
		
		int Count = Integer.parseInt(pagecount);

		for (int i = 1; i < Count; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getcontinuelearningtab());

		Thread.sleep(4000);
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getSelectAnswer());
		DikshaUtils.waitToBeClickableAndClick(assesment.getQueNextButton());
		DikshaUtils.waitToBeClickableAndClick(assesment.getSubmitcourseassesmentbutton());
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		DikshaUtils.waitToBeClickableAndClick(assesment.getSelectRating());
		DikshaUtils.waitToBeClickableAndClick(assesment.getSubmitButton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Thread.sleep(1000);
		WebElement courseProgresstext = driver.findElement(By.xpath("//div[text()='66% ']"));
		courseProgress = courseProgresstext.getText();
		Assert.assertEquals(courseProgress, "66% Completed");
		actual = "User should consume the content successfully";
		}finally {
			String Text = courseProgress != null ? courseProgress : "N/A";

            Listeners.customAssert("66% Completed", Text, expect, actual);
			
		}
	}

	public static void consumeCourseAssesmentAndVerifyReviewOption(String coursename) throws Exception {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		CourseAssesment assesment = PageFactory.initElements(driver, CourseAssesment.class);

		Thread.sleep(7000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());

		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());
		Thread.sleep(4000);
		driver.switchTo().frame(0);
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(assesment.getQueNextButton());
		Thread.sleep(1000);
		Assert.assertTrue(assesment.getReviewButton().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(assesment.getReviewButton());
		DikshaUtils.waitToBeVisibleAndClick(assesment.getSelectAnsDelhi());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(assesment.getQueNextButton());
		Thread.sleep(1000);
		Assert.assertTrue(assesment.getReviewButton().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(assesment.getReviewButton());

	}

	public static void consumeCourseAssesmentAndAttempUnattemptedQuestion(String coursename) throws Exception {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		CourseAssesment assesment = PageFactory.initElements(driver, CourseAssesment.class);

		Thread.sleep(7000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());
		Thread.sleep(4000);
		driver.switchTo().frame(0);
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(assesment.getQueNextButton());
		Thread.sleep(1000);
		Assert.assertTrue(assesment.getReviewButton().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(assesment.getReviewButton());
		DikshaUtils.waitToBeVisibleAndClick(assesment.getSelectAnsMumbai());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(assesment.getQueNextButton());
		Thread.sleep(1000);
		Assert.assertTrue(assesment.getReviewButton().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(assesment.getReviewButton());
		DikshaUtils.waitToBeVisibleAndClick(assesment.getSelectAnsDelhi());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(assesment.getQueNextButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Thread.sleep(1000);
		WebElement courseProgresstext = driver.findElement(By.xpath("//div[text()='66% ']"));
		String courseProgress = courseProgresstext.getText();
		Assert.assertEquals(courseProgress, "66% Completed");
	}

	public static void addDiffrentContentAndValidateRatingPopup(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CourseAssesment assesment = PageFactory.initElements(driver, CourseAssesment.class);
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);

		String ratingPopup = null;
		String expect = "Custodian user should be able to verify rating popup Sucessfully";
		String actual = "Custodian user is unable to verify rating popup ";
		try {

		Thread.sleep(7000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());

		String pagecount = cc.getPagecount().getText();
		int Count = Integer.parseInt(pagecount);

		for (int i = 1; i < Count; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}
		Thread.sleep(2000);
		Assert.assertTrue(cc.getValidateRatingPopup().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getcontinuelearningtab());

		Thread.sleep(4000);
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getSelectAnswer());
		DikshaUtils.waitToBeClickableAndClick(assesment.getQueNextButton());
		DikshaUtils.waitToBeClickableAndClick(assesment.getSubmitcourseassesmentbutton());
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		ratingPopup=cc.getValidateRatingPopup().getText();
		Assert.assertTrue(cc.getValidateRatingPopup().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(assesment.getSelectRating());
		DikshaUtils.waitToBeClickableAndClick(assesment.getSubmitButton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Thread.sleep(1000);
		WebElement courseProgresstext = driver.findElement(By.xpath("//div[text()='66% ']"));
		String courseProgress = courseProgresstext.getText();
		Assert.assertEquals(courseProgress, "66% Completed");
		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		actual = "Custodian user is able to verify rating popup Sucessfully";

		} finally {
			String Text = ratingPopup != null ? ratingPopup : "N/A";
			Listeners.customAssert(ratingPopup, Text, expect, actual);
		}
	}

	public static void verifyShareIcon(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CourseAssesment assesment = PageFactory.initElements(driver, CourseAssesment.class);
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		
		String shareButton = null;
		String expect = "Custodian user should be able to verify share icon Sucessfully";
		String actual = "Custodian user is unable to verify share icon ";
		try {

		Thread.sleep(7000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getShareIcon().isDisplayed());
		shareButton=cc.getShareButton().getText();
		actual = "Custodian user is able to verify share icon Sucessfully";

		} finally {
			String Text = shareButton != null ? shareButton : "N/A";
			Listeners.customAssert(shareButton, Text, expect, actual);
		}
	}

	public static void ConsumeCousreAndSyncProgress() throws InterruptedException {
		WebElement Progress = null;
	    String expect = "sync progress now Button Should Displayed";
	    String actual = "sync progress now Button Is Not Displayed ";
	    try {
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnStartLearning());

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
		Thread.sleep(3000);

		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnClose());

		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());

		Assert.assertTrue(cc.getassert100Percent().isDisplayed() && cc.getassertcourseConsumed().isDisplayed());
		System.out.println("100% Contents Consumed Successfully on course progess section");

		DikshaUtils.waitToBeClickableAndClick(cc.getclkKababMenuAfter100Percent());

		Assert.assertTrue(cc.getclkSyncProgress().isDisplayed());
		System.out.println("Sync Progress Is Displayed After 100% Consumption and clicking on Kabab Menu");

		DikshaUtils.waitToBeClickableAndClick(cc.getclkSyncProgress());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getassertSyncProgress().isDisplayed());
		System.out.println(
				"Custodain user successfully able to click on sync progress now button and sync progress now popup message is displayed ");
	   
		 Progress = driver.findElement(By.xpath("//div[text()='100% ']"));
	        Thread.sleep(2000);
	        
	        actual = "Sync progress now Button Is Displayed ";
	    }finally {
	    	String ProgressText = Progress != null ? Progress.getText() : "N/A";
	        System.out.println(ProgressText);
	        Listeners.customAssert("100% Completed", ProgressText, expect, actual);
	    }
	    

	}

	public static void ConsumeTwoContents() throws InterruptedException {
		WebElement Progress = null;
//		WebElement Progress12 = null;
	    String expect = "User Is Able To Consume The Course Successfully";
	    String actual = "User Is Not Able To Consume The Course";
	    
//	    String expect1 = "User Is Able To Consume The Course Successfully1";
//	    String actual1 = "User Is Not Able To Consume The Course1";
	    
	    try {
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnStartLearning());

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
		
		Thread.sleep(2000);

		DikshaUtils.waitToBeClickableAndClick(cc.getclkNextModule());

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());
		Thread.sleep(2000);
		

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
		Thread.sleep(3000);

		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnClose());
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Thread.sleep(1000);
		Assert.assertTrue(cc.getassert100Percent().isDisplayed() && cc.getassertcourseConsumed().isDisplayed());
		System.out.println("100% Contents Consumed Successfully on course progess section");

		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(cc.getclkKababMenuAfter100Percent());

		Thread.sleep(3000);
		Assert.assertTrue(cc.getclkSyncProgress().isDisplayed());
		System.out.println("Sync Progress Is Displayed After 100% Consumption and clicking on Kabab Menu");

		DikshaUtils.waitToBeClickableAndClick(cc.getclkSyncProgress());

		Thread.sleep(2000);
		Assert.assertTrue(cc.getassertSyncProgress().isDisplayed());
		System.out.println(
				"Custodain user successfully able to click on sync progress now button and sync progress now popup message is displayed ");
		
		Progress = driver.findElement(By.xpath("//div[@class='sb-color-primary fnormal font-weight-bold mt-8']"));
        Thread.sleep(2000);
        
        actual = "User Is Able To Consume The Course ";
        
	    }finally {
//	    	String ProgressText = Progress.getText();
//	        System.out.println(ProgressText);
//	        Listeners.customAssert("100% Completed", ProgressText, expect, actual);
	    }
	    
	}
	public static void verifyLastUpdatedConsentDate(String coursename) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(7000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		js.executeScript("window.scrollBy(0,500)");
		DikshaUtils.waitToBeVisibleAndClick(cc.getprofileAndDataSharingButton());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getlastUpdatedOn().isDisplayed());

	}

	public static void verifyUserShouldPlayedWithFirstContentOfFirstModule(String coursename)
			throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(7000);
		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());
		Thread.sleep(2000);
		String firstContent = cc.getfirstContent().getText();
		js.executeScript("arguments[0].scrollIntoView(true);", cc.getfirstContentName());
		String firstContentName = cc.getfirstContentName().getText();
		Assert.assertEquals(firstContent, firstContentName);

	}

	public static void PartiallyConsumeAndNavigateToHmePage(String course) throws InterruptedException {
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnStartLearning());

		for (int i = 0; i < 4; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getclkHomeTab());
		Thread.sleep(2000);
		String s1 = "//span[text()='Continue Learning']//following::bdi[text()='";
		String s2 = course;
		String s3 = "']";

		WebElement s4 = driver.findElement(By.xpath(s1 + s2 + s3));

		Assert.assertTrue(s4.isDisplayed());
		System.out.println("Coures is Displayed under continue learning section");

	}

	public static void verifyNextAndPrevModulButton() throws InterruptedException {
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnStartLearning());

		for (int i = 0; i < 4; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

//	DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());
//	
//	DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());

		Assert.assertTrue(cc.getclkNextModule().isDisplayed());
		System.out.println("Next Module button is Displayed On The Page");

		DikshaUtils.waitToBeClickableAndClick(cc.getclkNextModule());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getclkPrevModule().isDisplayed());
		System.out.println("Previous Module button is Displayed after click on Next Module Button On The Page");

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());

		Thread.sleep(3000);

		Thread.sleep(2000);
//	DikshaUtils.waitToBeClickableAndClick(cc.getbtnClose());

		Assert.assertTrue(cc.getclkPrevModule().isDisplayed());
		System.out.println("Still Previous Module button is Displayed after As First module is partially consumed");

		DikshaUtils.waitToBeClickableAndClick(cc.getclkPrevModule());
		Thread.sleep(2000);

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
	}

	public static void verifyCourseProgressContinueLearningButton() throws InterruptedException {
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnStartLearning());

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
		Thread.sleep(3000);

		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getassertContinueLearningBtn().isDisplayed());
		System.out.println("'Start Learning' button changed to 'Continue Learning' button");
		DikshaUtils.waitToBeClickableAndClick(cc.getassertContinueLearningBtn());

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
		Thread.sleep(3000);

		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnClose());

		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getassertCourseProgress().isDisplayed());
		System.out.println("Course Progress should be displayed on the Right hand side");

	}

	public static String verifyUserCanBeAbleToConsumeTheCourseOnMyProfile(String course) throws InterruptedException {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		DikshaUtils.waitToBeVisibleAndClick(loginpage.getHeaderDropdown());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(loginpage.getclkProfile());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getclkViewMore());

		String s1 = "//a[contains(text(),'";
		String s2 = course;
		String s3 = "')]";
		WebElement s4 = driver.findElement(By.xpath(s1 + s2 + s3));

		DikshaUtils.waitToBeClickableAndClick(s4);
		Thread.sleep(2000);

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnStartLearning());

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
		Thread.sleep(3000);

		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getassertContinueLearningBtn().isDisplayed());
		System.out.println("'Start Learning' button changed to 'Continue Learning' button");
		DikshaUtils.waitToBeClickableAndClick(cc.getassertContinueLearningBtn());

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
		Thread.sleep(3000);

		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnClose());

		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getassertCourseProgress().isDisplayed());
		System.out.println("Course Progress should be displayed on the Right hand side");

		return course;
	}

	public static void verifyUserAfterJoiningTheCourseCanViewTheEndDate() throws InterruptedException {
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnStartLearning());

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
		Thread.sleep(3000);

		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getassertContinueLearningBtn().isDisplayed());
		System.out.println("'Start Learning' button changed to 'Continue Learning' button");
		DikshaUtils.waitToBeClickableAndClick(cc.getassertContinueLearningBtn());

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
		Thread.sleep(3000);

		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnClose());

		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getassertCourseProgress().isDisplayed());
		System.out.println("Course Progress should be displayed on the Right hand side");
	}

	public static void verifyUserSelectsTheOngoingFromMyProfileAndConsume(String course) throws InterruptedException {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		DikshaUtils.waitToBeVisibleAndClick(loginpage.getHeaderDropdown());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(loginpage.getclkProfile());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getclkViewMore());

		String s1 = "//a[contains(text(),'";
		String s2 = course;
		String s3 = "')]";
		WebElement s4 = driver.findElement(By.xpath(s1 + s2 + s3));

		DikshaUtils.waitToBeClickableAndClick(s4);
		Thread.sleep(2000);

		Assert.assertTrue(cc.getassertRedirectTOC().isDisplayed());

		Assert.assertTrue(cc.getbtnStartLearning().isDisplayed());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnStartLearning());

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		Assert.assertTrue(cc.getrateTheContent().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
		Thread.sleep(3000);
	}
	
	public static void verifyFullScreenZoomInZoomOutForPDFConsumption(String coursename) throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
	Logout log = PageFactory.initElements(driver, Logout.class);
	String courseProgress = null;
	String expect = "Custodian user should be able to consume content in zoom mode Sucessfully";
	String actual = "Custodian user is unable to consume content in zoom mode";
	try {
	Thread.sleep(5000);

	DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
	DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
	cc.getSearchtextfield().sendKeys(coursename);
	DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
	Thread.sleep(3000);
	DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());

	DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
	Thread.sleep(2000);
	DikshaUtils.waitToBeClickableAndClick(cc.getConsentcheckbox());
	Thread.sleep(2000);
	DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
	DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)");
	DikshaUtils.waitToBeClickableAndClick(cc.getFullScreen());
	Thread.sleep(2000);
	Assert.assertTrue(cc.getZoomIn().isDisplayed());
	Assert.assertTrue(cc.getZoomOut().isDisplayed());
	String pagecount = cc.getPagecount().getText();
	int Count = Integer.parseInt(pagecount);

	for (int i = 1; i < Count; i++) {

		DikshaUtils.waitToBeClickableAndClick(cc.getZoomIn());
		DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getZoomOut());
	}

	driver.navigate().back();
	Thread.sleep(2000);
	WebElement courseProgresstext = driver.findElement(By.xpath("//div[text()='100% ']"));
	courseProgress = courseProgresstext.getText();
	Assert.assertEquals(courseProgress, "100% Completed");
	actual = "Custodian user is able to consume content in zoom mode Successfully";

	} finally {
		String Text = courseProgress != null ? courseProgress : "N/A";
		Listeners.customAssert(courseProgress, Text, expect, actual);
	}
}
public static void verifyNoCertificateNoteForCourseInCongratulationPopUp(String coursename) throws InterruptedException {
		
		CourseConsumption cc=PageFactory.initElements(driver, CourseConsumption.class);
		String noCertificateNote = null;
		String expect = "Custodian user should be able to view no certificate note for course after consumption Sucessfully";
		String actual = "Custodian user is unable to view no certificate note for course after consumption ";
		try {
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
	    DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
	    DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
	    DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
	    Thread.sleep(1000);
	    DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());
		Thread.sleep(2000);
		String pagecount = cc.getPagecount().getText();
		int Count = Integer.parseInt(pagecount);
		
		for(int i=1;i<Count;i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getNoCertificateNote().isDisplayed());
		noCertificateNote=cc.getNoCertificateNote().getText();
		actual = "Custodian user is able to view no certificate for course after consumption Sucessfully";

		} finally {
			String Text = noCertificateNote != null ? noCertificateNote : "N/A";
			Listeners.customAssert(noCertificateNote, Text, expect, actual);
		}
	}
public static void VerifyAndConsumeCourseAssesment(String coursename) throws Exception {

	CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
	Logout log = PageFactory.initElements(driver, Logout.class);
	CourseAssesment assesment = PageFactory.initElements(driver, CourseAssesment.class);
	String Scoretext = null;
	String expect = "Custodian user should be able to consume course assessment Sucessfully";
	String actual = "Custodian user is unable to consume course assessment ";
	try {

		Thread.sleep(5000);

		DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		Thread.sleep(1000);
		Assert.assertTrue(cc.getDescription().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		DikshaUtils.waitToBeClickableAndClick(cc.getStartLearning());
		Thread.sleep(4000);
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getSelectAnswer());
		DikshaUtils.waitToBeClickableAndClick(assesment.getQueNextButton());
		Thread.sleep(1000);
		Assert.assertTrue(assesment.getTotalQuestions().isDisplayed());
		Assert.assertTrue(assesment.getQuestionsAnswered().isDisplayed());
		Assert.assertTrue(assesment.getQuestionsSkipped().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(assesment.getSubmitcourseassesmentbutton());
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		DikshaUtils.waitToBeClickableAndClick(assesment.getSelectRating());
		DikshaUtils.waitToBeClickableAndClick(assesment.getSubmitButton());
		Thread.sleep(2000);
		WebElement ContentSavePopup = driver.findElement(By.xpath("//div[text()='Congratulations!!']"));
		String ContentsuccessfullyConsume = ContentSavePopup.getText();
		Assert.assertEquals(ContentsuccessfullyConsume, "Congratulations!!");
		Thread.sleep(6000);
		DikshaUtils.waitToBeClickableAndClick(assesment.getCongratulationCloseButton());
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		Scoretext=cc.getScoretext().getText();
		actual = "Custodian user is able to consume course assessment Sucessfully";

	} finally {
		String Text = Scoretext != null ? Scoretext : "N/A";
		Listeners.customAssert("Your score is 1/1", Text, expect, actual);
	}
}
}
