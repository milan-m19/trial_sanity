package pageActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageObject.Collections;
import pageObject.CreateBook;
import pageObject.UpForReview;
import pageObject.ValidatePopUp;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.Library;
import utility.Listeners;

public class UpForReviewMethods extends BaseClass {

	public static void up_For_Review(String fullname) throws InterruptedException {

		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		String contentPublishedPopUp = null;
		String expect = "Rewiever should be able Publish the Content Sucessfully";
		String actual = "Rewiever is unable to Publish the Content";
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			UpForReview review = PageFactory.initElements(driver, UpForReview.class);

			Library.custom_click(review.getHeaderDropdown(), "c-icon");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", review.getWorkspace());

			Thread.sleep(1000);

			Library.custom_click(review.getWorkspace(), "workspace");
			Thread.sleep(1000);
			Library.custom_click(review.getUpForReview(), "up for review");
			Thread.sleep(1000);
			Library.custom_sendkeys(review.getSearchForReview(), fullname, "name search");
			Thread.sleep(1000);
			Library.custom_click(review.getSearchedContentForPublish(), "search content");
			Thread.sleep(1000);
			Library.custom_click(review.getClickSearchContent(), "clickSearchContent");
			Thread.sleep(1000);

//       js.executeScript("arguments[0].scrollIntoView(true);",review.getPublishTheCourse());

//       Thread.sleep(1000);

			int scrollX = 0; // horizontal scroll amount

			int scrollY = 500; // vertical scroll amount

			js.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");

			Library.custom_click(review.getPublishTheCourse(), "publish buttons");
			Thread.sleep(1000);
			Library.custom_click(review.getNoHateSpeech(), "NoHateSpeech");
			Library.custom_click(review.getNoSexualContent(), "NoSexualContent");
			Library.custom_click(review.getNoDiscrimination(), "NoDiscrimination");
			Library.custom_click(review.getSuitableForChildren(), "SuitableForChildren");
			Library.custom_click(review.getAppropriateTitle(), "AppropriateTitle");
			Library.custom_click(review.getCorrectBMC(), "CorrectBMC");
			Library.custom_click(review.getAppropriateTags(), "AppropriateTags");
			Library.custom_click(review.getRelevantKeywords(), "RelevantKeywords");
			Library.custom_click(review.getContentplayscorrectly(), "Contentplayscorrectly");
			Library.custom_click(review.getContentclearOnDesk(), "ContentclearOnDesk");
			Library.custom_click(review.getAudio(), "Audio");
			Library.custom_click(review.getNoSpellingmistakes(), "NoSpellingmistakes");
			Library.custom_click(review.getLanguage(), "Language");
			Library.custom_click(review.getConfirmForPublishBook(), "Confirm Publish");
			Thread.sleep(5000);
			contentPublishedPopUp = popup.getContentPublishedPopUp().getText();

			actual = "Rewiever is able to Publish the Content Sucessfully";
		} finally {

			String popupText = contentPublishedPopUp != null ? contentPublishedPopUp : "N/A";
			Listeners.customAssert(contentPublishedPopUp, popupText, expect, actual);

		}

	}

	public static void LessonPlan_up_For_Review(String fullname) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		UpForReview review = PageFactory.initElements(driver, UpForReview.class);

		String contentPublishedPopUp = null;
		String expect = "Reviewer should be able to Publish the lesson plan Sucessfully";
		String actual = "Reviewer is unable to Published lesson plan";
		try {

			DikshaUtils.waitToBeClickableAndClick(review.getHeaderDropdown());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", review.getWorkspace());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(review.getWorkspace());
			DikshaUtils.waitToBeClickableAndClick(review.getUpForReview());
			DikshaUtils.waitToBeClickableAndClick(review.getSearchForReview());
			review.getSearchForReview().sendKeys(fullname);
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(review.getSearchedContentForPublish());
			DikshaUtils.waitToBeClickableAndClick(review.getClickSearchContent());
			Thread.sleep(2000);
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			DikshaUtils.waitToBeVisibleAndClick(review.getpublishLessonPlan());
			Thread.sleep(1000);
			contentPublishedPopUp = review.getconfirmForPublishLessonPlan().getText();
			DikshaUtils.waitToBeClickableAndClick(review.getconfirmForPublishLessonPlan());

			contentPublishedPopUp = review.getconfirmForPublishLessonPlan().getText();
			Thread.sleep(1000);
			actual = "Reviewer is able to publish lesson plan successfully";
		} finally {
			String Text = review.getconfirmForPublishLessonPlan() != null ? contentPublishedPopUp : "N/A";
			Listeners.customAssert(contentPublishedPopUp, Text, expect, actual);
		}

	}

	public static void Collections_up_For_Review(String fullname) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		UpForReview review = PageFactory.initElements(driver, UpForReview.class);
		Collections collections = PageFactory.initElements(driver, Collections.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Reviewer should be able to publish collection successfully";
		String actual = "Reviewer is unable to publish collection ";
		String ContentsuccessfullyPublishedPopup = null;
		try {
			DikshaUtils.waitToBeClickableAndClick(review.getHeaderDropdown());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", review.getWorkspace());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(review.getWorkspace());
			DikshaUtils.waitToBeClickableAndClick(review.getUpForReview());
			DikshaUtils.waitToBeClickableAndClick(review.getSearchForReview());
			review.getSearchForReview().sendKeys(fullname);
			DikshaUtils.waitToBeClickableAndClick(review.getSearchedContentForPublish());
			DikshaUtils.waitToBeClickableAndClick(review.getClickSearchContent());
			Thread.sleep(2000);
			DikshaUtils.waitToBeVisibleAndClick(collections.getpublishCollections());
			Thread.sleep(1000);
			Library.custom_click(collections.getNoHateSpeech(), "NoHateSpeech");
			Library.custom_click(collections.getNoSexualContent(), "NoSexualContent");
			Library.custom_click(collections.getNoDiscrimination(), "NoDiscrimination");
			Library.custom_click(collections.getSuitableForChildren(), "SuitableForChildren");
			Library.custom_click(collections.getAppropriateTitle(), "AppropriateTitle");
			Library.custom_click(collections.getCorrectBMC(), "CorrectBMC");
			Library.custom_click(collections.getAppropriateTags(), "AppropriateTags");
			Library.custom_click(collections.getRelevantKeywords(), "RelevantKeywords");
			Library.custom_click(collections.getContentplayscorrectly(), "Contentplayscorrectly");
			Library.custom_click(collections.getCanseethecontent(), "Canseethecontent ");
			Library.custom_click(collections.getAudio(), "Audio");
			Library.custom_click(collections.getNoSpellingmistakes(), "NoSpellingmistakes");
			Library.custom_click(collections.getLanguage(), "Language");
			DikshaUtils.waitToBeClickableAndClick(collections.getYesTab());
			Thread.sleep(3000);
			ContentsuccessfullyPublishedPopup = popup.getCoursePublishedPopUp().getText();
			Thread.sleep(1000);
			actual = "Reviewer is able to publish collection successfully";
		} finally {
			String Text = ContentsuccessfullyPublishedPopup != null ? ContentsuccessfullyPublishedPopup : "N/A";
			Listeners.customAssert(ContentsuccessfullyPublishedPopup, Text, expect, actual);
		}

	}

	public static void eTextbook_up_For_Review(String fullname) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		UpForReview review = PageFactory.initElements(driver, UpForReview.class);
		Collections collections = PageFactory.initElements(driver, Collections.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Reviewer should be able to publish etextbook successfully";
		String actual = "Reviewer is unable to publish etextbook ";
		String ContentsuccessfullySavedPopup = null;
		try {
			DikshaUtils.waitToBeClickableAndClick(review.getHeaderDropdown());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", review.getWorkspace());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(review.getWorkspace());
			DikshaUtils.waitToBeClickableAndClick(review.getUpForReview());
			DikshaUtils.waitToBeClickableAndClick(review.getSearchForReview());
			review.getSearchForReview().sendKeys(fullname);
			DikshaUtils.waitToBeClickableAndClick(review.getSearchedContentForPublish());
			DikshaUtils.waitToBeClickableAndClick(review.getClickSearchContent());
			Thread.sleep(2000);
//				driver.switchTo().frame(0);
//				Thread.sleep(2000);
			DikshaUtils.waitToBeVisibleAndClick(collections.getpublishCollections());
			Thread.sleep(1000);
			Library.custom_click(collections.getNoHateSpeech(), "NoHateSpeech");
			Library.custom_click(collections.getNoSexualContent(), "NoSexualContent");
			Library.custom_click(collections.getNoDiscrimination(), "NoDiscrimination");
			Library.custom_click(collections.getSuitableForChildren(), "SuitableForChildren");
			Library.custom_click(collections.getAppropriateTitle(), "AppropriateTitle");
			Library.custom_click(collections.getCorrectBMC(), "CorrectBMC");
			Library.custom_click(collections.getAppropriateTags(), "AppropriateTags");
			Library.custom_click(collections.getRelevantKeywords(), "RelevantKeywords");
			Library.custom_click(collections.getContentplayscorrectly(), "Contentplayscorrectly");
			Library.custom_click(collections.getCanseethecontent(), "Canseethecontent ");
			Library.custom_click(collections.getAudio(), "Audio");
			Library.custom_click(collections.getNoSpellingmistakes(), "NoSpellingmistakes");
			Library.custom_click(collections.getLanguage(), "Language");
			DikshaUtils.waitToBeClickableAndClick(collections.getYesTab());
			Thread.sleep(3000);
			ContentsuccessfullySavedPopup = popup.getBookPublishedPopUp().getText();
			Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is published");
			actual = "Reviewer is able to publish etextbook successfully";
		} finally {
			String Text =  popup.getBookPublishedPopUp() != null ? ContentsuccessfullySavedPopup : "N/A";
			Listeners.customAssert(ContentsuccessfullySavedPopup, Text, expect, actual);
		}

	}



	public static void eTextbookPreviewAndRejectFrom_up_For_Review(String fullname) throws Exception {

		UpForReview review = PageFactory.initElements(driver, UpForReview.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		
		String expected = "Verify creator should be able to reject the etextbook from up for review successfully";
		String actual = "Creator is unable to reject the etextbook from up for review";
		String RejectPopup = null;
		try {
		
		DikshaUtils.waitToBeClickableAndClick(review.getHeaderDropdown());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", review.getWorkspace());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(review.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(review.getUpForReview());
		DikshaUtils.waitToBeClickableAndClick(review.getSearchForReview());
		review.getSearchForReview().sendKeys(fullname);
		DikshaUtils.waitToBeClickableAndClick(review.getSearchedContentForPublish());
		DikshaUtils.waitToBeClickableAndClick(review.getClickSearchContent());
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		DikshaUtils.waitToBeClickableAndClick(review.getRejectTheContent());
		DikshaUtils.waitToBeClickableAndSendKeys(review.getAddReviewComment(), "Feedback");
		DikshaUtils.waitToBeClickableAndClick(review.getSubmitReviewButton());

		Thread.sleep(1000);
//		WebElement RejectPopup = driver.findElement(By.xpath("//strong[text()='Content is sent back for corrections']"));
		 RejectPopup = popup.getRejectTheContentPopup().getText();
//		Assert.assertEquals(reject, "Content is sent back for corrections");
		Thread.sleep(2000);
		actual = "Creator is able to reject the etextbook from up for review successfully";
		
		
		} finally {

			String popupText = RejectPopup !=null ? RejectPopup : "N/A";
			System.out.println(popupText);
			Listeners.customAssert("Content is sent back for corrections", popupText, expected, actual);

		   }

	}

	public static void ReviwerViewCollaboratorAddedToeTextbookFrom_up_For_Review(String fullname) throws Exception {

		UpForReview review = PageFactory.initElements(driver, UpForReview.class);
		CreateBook create = PageFactory.initElements(driver, CreateBook.class);

		String expected = "Verify reviwer should be able to see collaborator added to eTextbook successfully";
		String actual = "Reviwer is unable to see collaborator added to eTextbook";

		boolean checkCollaborator = false;
		String expectedCondition = null;
		
		try {

			if (review.getHeaderDropdown().isDisplayed()) {
				checkCollaborator = true;
		
		DikshaUtils.waitToBeClickableAndClick(review.getHeaderDropdown());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", review.getWorkspace());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(review.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(review.getUpForReview());
		DikshaUtils.waitToBeClickableAndClick(review.getSearchForReview());
		review.getSearchForReview().sendKeys(fullname);
		DikshaUtils.waitToBeClickableAndClick(review.getSearchedContentForPublish());
		DikshaUtils.waitToBeClickableAndClick(review.getClickSearchContent());
		DikshaUtils.waitToBeClickableAndClick(create.getViewCollaborator());
		
		actual = "Reviwer is able to see collaborator added to eTextbook successfully";
		expectedCondition = "True";
	}

} finally {

	Listeners.customAssert("True",expectedCondition, expected, actual);
	
}

	}

	public static void eTextbookAddedInCourse_up_For_Review(String fullname) throws Exception {

		UpForReview review = PageFactory.initElements(driver, UpForReview.class);
		Collections collections = PageFactory.initElements(driver, Collections.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String contentPublishedPopUp = null;
		String expect = "Reviewer should be able to Publish the Content Sucessfully";
		String actual = "Reviewer is unable to Published Content";
		try {
			DikshaUtils.waitToBeClickableAndClick(review.getHeaderDropdown());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", review.getWorkspace());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(review.getWorkspace());
			DikshaUtils.waitToBeClickableAndClick(review.getUpForReview());
			DikshaUtils.waitToBeClickableAndClick(review.getSearchForReview());
			review.getSearchForReview().sendKeys(fullname);
			DikshaUtils.waitToBeClickableAndClick(review.getSearchedContentForPublish());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(review.getClickSearchContent());
			Thread.sleep(2000);
			DikshaUtils.waitToBeVisibleAndClick(collections.getpublishCollections());
			DikshaUtils.waitToBeVisibleAndClick(collections.getYesTab());
			Thread.sleep(2000);
			contentPublishedPopUp = popup.getCoursePublishedPopUp().getText();
			Thread.sleep(1000);
			actual = "Reviewer is able to publish course successfully";
		} finally {
			String Text = popup.getCoursePublishedPopUp() != null ? contentPublishedPopUp : "N/A";
			Listeners.customAssert(contentPublishedPopUp, Text, expect, actual);
		}

	}

	public static void QuestionSet_up_For_Review(String fullname) throws Exception {

		UpForReview review = PageFactory.initElements(driver, UpForReview.class);
		Collections collections = PageFactory.initElements(driver, Collections.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Reviewer should be able to publish question set successfully";
		String actual = "Reviewer unable to publish question set ";
		String ContentsuccessfullyPublishedPopup = null;
		try {
			driver.get("https://diksha.gov.in/workspace/edit/Course/" + fullname + "/upForReview/Review#no");

			DikshaUtils.waitToBeVisibleAndClick(collections.getpublishCollections());
			Thread.sleep(1000);
			Library.custom_click(collections.getNoHateSpeech(), "NoHateSpeech");
			Library.custom_click(collections.getNoSexualContent(), "NoSexualContent");
			Library.custom_click(collections.getNoDiscrimination(), "NoDiscrimination");
			Library.custom_click(collections.getSuitableForChildren(), "SuitableForChildren");
			Library.custom_click(collections.getAppropriateTitle(), "AppropriateTitle");
			Library.custom_click(collections.getCorrectBMC(), "CorrectBMC");
			Library.custom_click(collections.getAppropriateTags(), "AppropriateTags");
			Library.custom_click(collections.getRelevantKeywords(), "RelevantKeywords");
			Library.custom_click(collections.getContentplayscorrectly(), "Contentplayscorrectly");
			Library.custom_click(collections.getCanseethecontent(), "Canseethecontent ");
			Library.custom_click(collections.getAudio(), "Audio");
			Library.custom_click(collections.getNoSpellingmistakes(), "NoSpellingmistakes");
			Library.custom_click(collections.getLanguage(), "Language");
			DikshaUtils.waitToBeClickableAndClick(collections.getYesTab());
			Thread.sleep(3000);
			ContentsuccessfullyPublishedPopup = popup.getCoursePublishedPopUp().getText();
			Thread.sleep(1000);
			actual = "Reviewer is able to publish question set successfully";
		} finally {
			String Text = popup.getCoursePublishedPopUp() != null ? popup.getCoursePublishedPopUp().getText() : "N/A";
			Listeners.customAssert(ContentsuccessfullyPublishedPopup, Text, expect, actual);
		}

	}
}
