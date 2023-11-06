package pageActions;

import java.util.concurrent.TimeUnit;
import org.apache.commons.math3.analysis.solvers.BaseSecantSolver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObject.CourseConsumption;
import pageObject.Groups;
import pageObject.ValidatePopUp;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.Library;
import utility.Listeners;

public class CourseConsumptionMethods extends BaseClass {

	public static void consume_PDF_Course_Content(String coursename) throws InterruptedException {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

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

		for (int i = 1; i < Count; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseCongratulations());
		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());

		Assert.assertTrue(cc.getcontinuelearningtab().isDisplayed());

	}

	public static void Partiallyconsume_PDF_Course_Content(String coursename) throws InterruptedException {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		Thread.sleep(2000);
		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(5000);
		Library.custom_click(cc.getSearchbutton(), "search button");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
		Thread.sleep(2000);
		Library.custom_click(cc.getJoincourse(), "Join course");
		Thread.sleep(2000);
		// Library.custom_click(cc.getConsentcheckbox(), " Consent Checkbox");
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		Library.custom_click(cc.getShareButton(), "Share Button");
		DikshaUtils.waitForElementToBeVisible(cc.getStartLearning());
		Assert.assertTrue(cc.getStartLearning().isDisplayed());
		DikshaUtils.waitToBeVisibleAndClick(cc.getStartLearning());
		Thread.sleep(2000);
		String pagecount = cc.getPagecount().getText();
		int Count = Integer.parseInt(pagecount);

		for (int i = 1; i < Count; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getcontinuelearningtab().isDisplayed());

	}

	public static void verifyNoCertificateNoteForCourseInCongratulationPopUp(String coursename)
			throws InterruptedException {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

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
	}

	public static void searchContentForConsumption(String coursename) throws InterruptedException {

		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		String expect = "Custodian user should be able to search content via " + coursename
				+ " and consume successfully";
		String actual = "Custodian user is unable to search content via " + coursename + " and consume ";
		String ContentconsumedPopup = null;

		try {
			Thread.sleep(5000);
			cc.getSearchtextfield().clear();
			Thread.sleep(1000);
			Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
			Thread.sleep(5000);
			DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(cc.getSearchedTvLesson());
			Thread.sleep(4000);
			WebElement frame = driver.findElement(By.xpath("//iframe[@id='contentPlayer']"));
			driver.switchTo().frame(frame);
			Thread.sleep(4000);
			DikshaUtils.waitToBeClickableAndClick(cc.getClickNextButton());
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
			Thread.sleep(1000);
			driver.switchTo().frame(frame);
			ContentconsumedPopup = popup.getTvLessonCompleted().getText();
			Assert.assertEquals(ContentconsumedPopup, "You just completed");
			driver.switchTo().defaultContent();
			Thread.sleep(1000);

			DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());

			actual = "Custodian user is able to search content via " + coursename + " and consume successfully";

		} finally {
			String Text = popup.getTvLessonCompleted() != null ? ContentconsumedPopup : "N/A";
			Listeners.customAssert(ContentconsumedPopup, Text, expect, actual);
		}

	}

	public static void searchEtextbookForConsumption(String coursename) throws InterruptedException {

		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		String expect = "Custodian user should be able to search content via " + coursename
				+ " and consume successfully";
		String actual = "Custodian user is unable to search content via " + coursename + " and consume ";
		String ContentconsumedPopup = null;

		try {
			Thread.sleep(5000);
			cc.getSearchtextfield().clear();
			Thread.sleep(1000);
			Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
			Thread.sleep(5000);
			DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(cc.getSearchedETextbook());
			Thread.sleep(4000);
			String pagecount = cc.getPagecount().getText();
			int Count = Integer.parseInt(pagecount);

			for (int i = 1; i < Count; i++) {

				DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
			}

			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
			ContentconsumedPopup = popup.getETextbookCompleted().getText();
			Assert.assertEquals(ContentconsumedPopup, "You just completed");
			driver.switchTo().defaultContent();
			Thread.sleep(1000);

			DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
			actual = "Custodian user is able to search content via " + coursename + " and consume successfully";

		} finally {
			String Text = popup.getTvLessonCompleted() != null ? ContentconsumedPopup : "N/A";
			Listeners.customAssert(ContentconsumedPopup, Text, expect, actual);
		}
	}

	public static void validateBatchExpiryMessage() throws InterruptedException {

		String expected1 = "Verify user should be able to see batch expiry message successfully";
		String actual1 = "User is not able to see batch expiry message";
		boolean checkMessage = false;
		String expectedMessage = null;

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Thread.sleep(3000);

		try {

			if (cc.getBatchExpiryMsg().isDisplayed()) {
				checkMessage = true;
				Assert.assertTrue(cc.getBatchExpiryMsg().isDisplayed());

				actual1 = "User is able to see batch expiry message successfully";
				expectedMessage = "True";
			}
		} finally {

			Listeners.customAssert("True", expectedMessage, expected1, actual1);

		}

	}

	public static void UserconsumeCourseFromGroup(String coursename) throws InterruptedException {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectCourse());

		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getJoincourse());
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		Library.custom_click(cc.getShareButton(), "Share Button");
		DikshaUtils.waitForElementToBeVisible(cc.getStartLearning());
		Assert.assertTrue(cc.getStartLearning().isDisplayed());
		DikshaUtils.waitToBeVisibleAndClick(cc.getStartLearning());
		Thread.sleep(2000);
		String pagecount = cc.getPagecount().getText();
		int Count = Integer.parseInt(pagecount);

		for (int i = 1; i < Count; i++) {

			DikshaUtils.waitToBeClickableAndClick(cc.getNextButton());
		}
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseRatingPopup());
		DikshaUtils.waitToBeClickableAndClick(cc.getCloseCongratulations());
		DikshaUtils.waitToBeClickableAndClick(cc.getBackButton());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getcontinuelearningtab().isDisplayed());
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.CourseProgressKababMenu());
		DikshaUtils.waitToBeVisibleAndClick(cc.SyncProgress());
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0, 0)");

	}

	public static void VerifyConsentSharedIsNotDeclined() {

	}

}
