package pageActions;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObject.CourseConsumption;
import pageObject.CourseCreation;
import pageObject.CreateBatchForCourse;
import pageObject.CreateBook;
import pageObject.Draft;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.Published;
import pageObject.UpForReview;
import pageObject.ValidatePopUp;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.Listeners;

public class Book_Creation extends BaseClass {

	public static void VerifyCreatorAbleToGenerateAndDownloadQRCode() throws Exception {

		CreateBook create = PageFactory.initElements(driver, CreateBook.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Creator should be able to generate and download QR code successfully";
		String actual = "Creator is unable to generate and download QR code";
		String DownloadQrCodePopUp = null;

		try {

			DikshaUtils.waitToBeClickableAndClick(create.getHeaderDropdown());
			DikshaUtils.waitToBeClickableAndClick(create.getWorkspace());
			DikshaUtils.waitToBeClickableAndClick(create.getBook());

			String Name = DikshaUtils.set_Content_Name("eTextbook_");
			excel.updateData("TestData", "eTextbook", Name, "");

			DikshaUtils.waitToBeClickableAndSendKeys(create.getBookname(), Name);
			DikshaUtils.waitToBeVisibleAndClick(create.getBookname());
			DikshaUtils.waitToBeVisibleAndClick(create.getStartCreating());
			DikshaUtils.waitToBeVisibleAndClick(create.getQRCodeDropdown());
			DikshaUtils.waitToBeVisibleAndClick(create.getGenerateQRCode());
			DikshaUtils.waitToBeClickableAndSendKeys(create.getNoOfQRCode(), "2");
			DikshaUtils.waitToBeVisibleAndClick(create.getRequestButton());
			DikshaUtils.waitToBeVisibleAndClick(create.getQRCodeDropdown());
			DikshaUtils.waitToBeVisibleAndClick(create.getDownloadQRCode());

			DownloadQrCodePopUp = popup.getDownloadQRCodePopup().getText();
//		Assert.assertEquals(DownloadQrCodePopUp, "QR codes downloaded");
			Thread.sleep(2000);

			actual = "Creator is able to generate and download QR code successfully";

		} finally {
			String Text = DownloadQrCodePopUp != null ? DownloadQrCodePopUp : "N/A";
			Listeners.customAssert("QR codes downloaded", Text, expect, actual);
		}
	}

	public static void VerifyCreatorAbleToValidateQRCode() throws Exception {

		CreateBook create = PageFactory.initElements(driver, CreateBook.class);
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);

		String expected = "Verify user should be able to validate QR code successfully";
		String actual = "User is unable to validate QR code";

		String ConfirmQRCode = null;
		boolean checkcondition = false;

		try {

			if (HomePage.getHomeTab().isDisplayed()) {
				checkcondition = true;

				DikshaUtils.waitToBeClickableAndClick(create.getHeaderDropdown());
				DikshaUtils.waitToBeClickableAndClick(create.getWorkspace());
				DikshaUtils.waitToBeClickableAndClick(create.getBook());

				String Name = DikshaUtils.set_Content_Name("eTextbook_");
				excel.updateData("TestData", "eTextbook", Name, "");

				DikshaUtils.waitToBeClickableAndSendKeys(create.getBookname(), Name);
				DikshaUtils.waitToBeVisibleAndClick(create.getBookname());
				DikshaUtils.waitToBeVisibleAndClick(create.getStartCreating());

				Thread.sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				// js.executeScript("arguments[0].scrollIntoView(true);",create.getYesQRCodeRequired());
				js.executeScript("window.scrollBy(0,900)");
				Thread.sleep(1000);

				DikshaUtils.waitToBeClickableAndClick(create.getYesQRCodeRequired());
				DikshaUtils.waitToBeClickableAndSendKeys(create.getEnterQRCode(), "V9X1R7");
				DikshaUtils.waitToBeClickableAndClick(create.getQRCodeBlueTick());

				Thread.sleep(1000);
				Assert.assertTrue(create.getConfirmQRCodeBlueTick().isDisplayed());

				DikshaUtils.waitToBeClickableAndClick(create.getAddChild());

				DikshaUtils.waitToBeClickableAndClick(create.getYesQRCodeRequired());
				DikshaUtils.waitToBeClickableAndSendKeys(create.getEnterQRCode(), "B5P3M2");
				DikshaUtils.waitToBeClickableAndClick(create.getQRCodeBlueTick());

				Thread.sleep(1000);
				Assert.assertTrue(create.getConfirmQRCodeBlueTick().isDisplayed());

				actual = " user is able to validate QR code successfully";
				ConfirmQRCode = "True";
			}

		} finally {

			Listeners.customAssert("True", ConfirmQRCode, expected, actual);

		}
	}

	public static String VerifyCreatorAbleToAddCollaboratorInTextbook() throws Exception {

		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		CreateBook create = PageFactory.initElements(driver, CreateBook.class);

		String ContentsendPopup = null;
		String expected = "Verify creator should be able to add collaborator in textbook successfully";
		String actual = "Creator is Unable to add collaborator in textbook";

		try {

			DikshaUtils.waitToBeClickableAndClick(create.getHeaderDropdown());
			DikshaUtils.waitToBeClickableAndClick(create.getWorkspace());
			DikshaUtils.waitToBeClickableAndClick(create.getBook());

			String Name = DikshaUtils.set_Content_Name("eTextbook_");

			DikshaUtils.waitToBeClickableAndSendKeys(create.getBookname(), Name);
			DikshaUtils.waitToBeVisibleAndClick(create.getBookname());
			DikshaUtils.waitToBeVisibleAndClick(create.getStartCreating());

			JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("arguments[0].scrollIntoView(true);",Upload.getSelectBoardSyllabus());
			js.executeScript("window.scrollBy(0, 900)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(create.getSelectBoardSyllabus());
			DikshaUtils.waitToBeClickableAndClick(create.getBoardSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectMedium());
			DikshaUtils.waitToBeClickableAndClick(create.getMediumSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectClass());
			DikshaUtils.waitToBeClickableAndClick(create.getClassSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectSubject());
			DikshaUtils.waitToBeClickableAndClick(create.getSubjectSelected());

			js.executeScript("arguments[0].scrollIntoView(true);", create.getCopyright());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(create.getCopyright());
			create.getCopyright().sendKeys("2023");
			js.executeScript("window.scrollTo(0, 0)");
			DikshaUtils.waitToBeClickableAndClick(create.getSaveAsDraft());
			Thread.sleep(5000);
			DikshaUtils.waitToBeClickableAndClick(create.getAddChild());

			WebElement ContentSavePopup = driver.findElement(By.xpath("//strong[text()='Content is saved']"));
			String ContentsuccessfullySavedPopup = ContentSavePopup.getText();
			Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
			Thread.sleep(1000);

			DikshaUtils.waitToBeClickableAndClick(create.getAddCollaborator());
			DikshaUtils.waitToBeClickableAndSendKeys(create.getSearchCollaborator(), "ContentCreator2.0");
			Thread.sleep(1000);
			create.getSearchCollaborator().sendKeys(Keys.ENTER);
			DikshaUtils.waitToBeVisibleAndClick(create.getSelectContentCollaborator());
			Thread.sleep(1000);
			js.executeScript("arguments[0].scrollIntoView(true);", create.getDoneButton());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(create.getDoneButton());

			Thread.sleep(1000);
			WebElement CollaboratorPopup = driver
					.findElement(By.xpath("//strong[text()='Collaborators updated successfully']"));
			String CollaboratorssuccessfullyPopup = CollaboratorPopup.getText();
			Assert.assertEquals(CollaboratorssuccessfullyPopup, "Collaborators updated successfully");
			Thread.sleep(1000);

			DikshaUtils.waitToBeClickableAndClick(create.getSubmitForreviewButton());
			DikshaUtils.waitToBeClickableAndClick(create.getTermsAndConditionCheckbox());
			DikshaUtils.waitToBeClickableAndClick(create.getNewCoursesubmitButton());
			Thread.sleep(2000);

			ContentsendPopup = popup.getSendForReviewPopUp().getText();
			actual = "Sucessfuly Content send for review";

			excel.updateData("TestData", "Collections", Name, "");
			return Name;

		} finally {

			String popupText = ContentsendPopup != null ? ContentsendPopup : "N/A";
			System.out.println(popupText);
			Listeners.customAssert(ContentsendPopup, popupText, expected, actual);

//	    Assert.assertEquals(ContentsendPopup, "Content is sent for review");
//		Thread.sleep(2000);

		}

	}

	public static String VerifyCreatorAbleToAddCollaboratorInLiveTextbook() throws Exception {

		CreateBook create = PageFactory.initElements(driver, CreateBook.class);

		DikshaUtils.waitToBeClickableAndClick(create.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(create.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(create.getBook());

		String Name = DikshaUtils.set_Content_Name("eTextbook_");

		DikshaUtils.waitToBeClickableAndSendKeys(create.getBookname(), Name);
		DikshaUtils.waitToBeVisibleAndClick(create.getBookname());
		DikshaUtils.waitToBeVisibleAndClick(create.getStartCreating());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView(true);",Upload.getSelectBoardSyllabus());
		js.executeScript("window.scrollBy(0, 900)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(create.getSelectBoardSyllabus());
		DikshaUtils.waitToBeClickableAndClick(create.getBoardSelected());
		DikshaUtils.waitToBeClickableAndClick(create.getSelectMedium());
		DikshaUtils.waitToBeClickableAndClick(create.getMediumSelected());
		DikshaUtils.waitToBeClickableAndClick(create.getSelectClass());
		DikshaUtils.waitToBeClickableAndClick(create.getClassSelected());
		DikshaUtils.waitToBeClickableAndClick(create.getSelectSubject());
		DikshaUtils.waitToBeClickableAndClick(create.getSubjectSelected());

		js.executeScript("arguments[0].scrollIntoView(true);", create.getCopyright());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(create.getCopyright());
		create.getCopyright().sendKeys("2023");
		DikshaUtils.waitToBeClickableAndClick(create.getAddChild());
		js.executeScript("window.scrollTo(0, 0)");
		DikshaUtils.waitToBeClickableAndClick(create.getSaveAsDraft());
		Thread.sleep(1000);

		WebElement ContentSavePopup = driver.findElement(By.xpath("//strong[text()='Content is saved']"));
		String ContentsuccessfullySavedPopup = ContentSavePopup.getText();
		Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(create.getSubmitForreviewButton());
		DikshaUtils.waitToBeClickableAndClick(create.getTermsAndConditionCheckbox());
		DikshaUtils.waitToBeClickableAndClick(create.getNewCoursesubmitButton());
		Thread.sleep(1000);

		excel.updateData("TestData", "Collections", Name, "");

		return Name;

	}

	public static String CreatebookAndSaveAsDraft() throws Exception {

		CreateBook create = PageFactory.initElements(driver, CreateBook.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expected = "Verify creator should be able to create book and save as draft successfully";
		String actual = "Creator is Unable to create book and save as draft";

		String SavedAsDraftPopup = null;

		try {

			DikshaUtils.waitToBeClickableAndClick(create.getHeaderDropdown());
			DikshaUtils.waitToBeClickableAndClick(create.getWorkspace());
			DikshaUtils.waitToBeClickableAndClick(create.getBook());

			String Name = DikshaUtils.set_Content_Name("eTextbook_");

			DikshaUtils.waitToBeClickableAndSendKeys(create.getBookname(), Name);
			DikshaUtils.waitToBeVisibleAndClick(create.getBookname());
			DikshaUtils.waitToBeVisibleAndClick(create.getStartCreating());

			JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("arguments[0].scrollIntoView(true);",Upload.getSelectBoardSyllabus());
			js.executeScript("window.scrollBy(0, 900)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(create.getSelectBoardSyllabus());
			DikshaUtils.waitToBeClickableAndClick(create.getBoardSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectMedium());
			DikshaUtils.waitToBeClickableAndClick(create.getMediumSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectClass());
			DikshaUtils.waitToBeClickableAndClick(create.getClassSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectSubject());
			DikshaUtils.waitToBeClickableAndClick(create.getSubjectSelected());

			js.executeScript("arguments[0].scrollIntoView(true);", create.getCopyright());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(create.getCopyright());
			create.getCopyright().sendKeys("2023");
			js.executeScript("window.scrollTo(0, 0)");
			DikshaUtils.waitToBeClickableAndClick(create.getSaveAsDraft());
			Thread.sleep(5000);
			DikshaUtils.waitToBeClickableAndClick(create.getAddChild());
			DikshaUtils.waitToBeVisibleAndClick(content.getAddFromLibraryButton());

			DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
			String textbook = excel.getContentName("PDF1");
			DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), textbook);
			content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
			DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
			DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());
			DikshaUtils.waitToBeVisibleAndClick(create.getSaveAsDraft());
			Thread.sleep(5000);
			SavedAsDraftPopup = popup.getSaveAsDraftPopUp().getText();
			Assert.assertEquals(SavedAsDraftPopup, "Content is saved");
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(create.getBackButton());
			Thread.sleep(5000);

			actual = "creator is able to create book and save as draft successfully";
			excel.updateData("TestData", "Collections", Name, "");
			return Name;

		} finally {

			String popupText = SavedAsDraftPopup != null ? SavedAsDraftPopup : "N/A";
			System.out.println(popupText);
			Listeners.customAssert("Content is saved", popupText, expected, actual);

		}
	}

	public static void EditTheBookFromDraft(String fullname) throws Exception {

		Draft draft = PageFactory.initElements(driver, Draft.class);
		CreateBook create = PageFactory.initElements(driver, CreateBook.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expected = "Verify creator should be able to edit the book from draft successfully";
		String actual = "Creator is Unable to edit the book from draft";

		String ContentsuccessfullySavedPopup = null;

		try {

			DikshaUtils.waitToBeClickableAndClick(draft.getHeaderDropdown());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", draft.getWorkspace());
			DikshaUtils.waitToBeClickableAndClick(draft.getWorkspace());
			DikshaUtils.waitToBeClickableAndClick(draft.getDraft());
			DikshaUtils.waitToBeClickableAndClick(draft.getSearchForPublished());
			draft.getSearchForPublished().sendKeys(fullname);
			DikshaUtils.waitToBeClickableAndClick(draft.getSearchIcon());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(draft.getClickSearchContent());
			Thread.sleep(2000);
			DikshaUtils.waitToBeVisibleAndClick(create.getAddChild());
			Thread.sleep(2000);
			DikshaUtils.waitToBeVisibleAndClick(create.getYesQRCodeRequired());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndSendKeys(create.getEnterQRCode(), "B5P3M2");
			Thread.sleep(2000);
			DikshaUtils.waitToBeVisibleAndClick(create.getQRCodeBlueTick());
			Thread.sleep(2000);
			js.executeScript("window.scrollTo(0, 0)");
			DikshaUtils.waitToBeVisibleAndClick(create.getSaveAsDraft());
			Thread.sleep(5000);
			ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
			Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(create.getSubmitForreviewButton());
			Thread.sleep(4000);
			DikshaUtils.waitToBeVisibleAndClick(create.getTermsAndConditionCheckbox());
			DikshaUtils.waitToBeClickableAndClick(create.getNewCoursesubmitButton());
			DikshaUtils.waitToBeClickableAndClick(draft.getDeleteContentFromDraft());
			DikshaUtils.waitToBeClickableAndClick(draft.getConfirmDeleteContentFromDraft());

			actual = "Creator is able to edit the book from draft successfully";

		} finally {

			String popupText = ContentsuccessfullySavedPopup != null ? ContentsuccessfullySavedPopup : "N/A";
			System.out.println(popupText);
			Listeners.customAssert("Content is saved", popupText, expected, actual);

		}

	}

	public static String CreateBookAndSendForReview() throws Exception {

		CreateBook create = PageFactory.initElements(driver, CreateBook.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expected = "Verify creator should be create book and send for review successfully";
		String actual = "Creator is unable to create book and send for review";
		String ContentsendPopup = null;
		try {

			DikshaUtils.waitToBeClickableAndClick(create.getHeaderDropdown());
			DikshaUtils.waitToBeClickableAndClick(create.getWorkspace());
			DikshaUtils.waitToBeClickableAndClick(create.getBook());

			String Name = DikshaUtils.set_Content_Name("eTextbook_");

			DikshaUtils.waitToBeClickableAndSendKeys(create.getBookname(), Name);
			DikshaUtils.waitToBeVisibleAndClick(create.getBookname());
			DikshaUtils.waitToBeVisibleAndClick(create.getStartCreating());

			JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("arguments[0].scrollIntoView(true);",Upload.getSelectBoardSyllabus());
			js.executeScript("window.scrollBy(0, 900)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(create.getSelectBoardSyllabus());
			DikshaUtils.waitToBeClickableAndClick(create.getBoardSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectMedium());
			DikshaUtils.waitToBeClickableAndClick(create.getMediumSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectClass());
			DikshaUtils.waitToBeClickableAndClick(create.getClassSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectSubject());
			DikshaUtils.waitToBeClickableAndClick(create.getSubjectSelected());

			js.executeScript("arguments[0].scrollIntoView(true);", create.getCopyright());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(create.getCopyright());
			create.getCopyright().sendKeys("2023");
			js.executeScript("window.scrollTo(0, 0)");
			DikshaUtils.waitToBeClickableAndClick(create.getSaveAsDraft());
			Thread.sleep(5000);
			String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
			Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(create.getAddChild());
			DikshaUtils.waitToBeVisibleAndClick(content.getAddFromLibraryButton());

			DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
			String textbook = excel.getContentName("PDF1");
			DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), textbook);
			content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
			DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
			DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());

			DikshaUtils.waitToBeClickableAndClick(create.getSubmitForreviewButton());
			DikshaUtils.waitToBeClickableAndClick(create.getTermsAndConditionCheckbox());
			DikshaUtils.waitToBeClickableAndClick(create.getNewCoursesubmitButton());
			Thread.sleep(2000);
			ContentsendPopup = popup.getSendForReviewPopUp().getText();
//		Assert.assertEquals(ContentsendPopup, "Content is sent for review");
			Thread.sleep(5000);

			actual = "Creator is able to create book and send for review successfully";
			return Name;

		} finally {

			String popupText = ContentsendPopup != null ? ContentsendPopup : "N/A";
			System.out.println(popupText);
			Listeners.customAssert("Content is sent for review", popupText, expected, actual);

		}
	}

	public static void AddingNewContentInPublishedBook(String Fullname) throws Exception {

		CreateBook create = PageFactory.initElements(driver, CreateBook.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		Published publish = PageFactory.initElements(driver, Published.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(create.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(create.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(publish.getPublished());
		DikshaUtils.waitToBeClickableAndSendKeys(publish.getSearchForPublished(), Fullname);
		publish.getSearchForPublished().sendKeys(Keys.ENTER);
		DikshaUtils.waitToBeVisibleAndClick(publish.getSearchedCourse());
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.navigate().refresh();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().refresh();
		DikshaUtils.waitToBeVisibleAndClick(create.getAddChild());
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(content.getAddFromLibraryButton());

		DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
		String textbook = excel.getContentName("PDF1");
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), textbook);
		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());

		DikshaUtils.waitToBeClickableAndClick(create.getSubmitForreviewButton());
		DikshaUtils.waitToBeClickableAndClick(create.getTermsAndConditionCheckbox());
		DikshaUtils.waitToBeClickableAndClick(create.getNewCoursesubmitButton());
		Thread.sleep(5000);

	}

	public static String CreateBookAddCollaboratorAndSendForReview() throws Exception {

		CreateBook create = PageFactory.initElements(driver, CreateBook.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expected = "Verify creator should be create book and add collaborator and send for review successfully";
		String actual = "Creator is unable to create book and add collaborator and send for review";
		String ContentsendPopup = null;
		try {

			DikshaUtils.waitToBeClickableAndClick(create.getHeaderDropdown());
			DikshaUtils.waitToBeClickableAndClick(create.getWorkspace());
			DikshaUtils.waitToBeClickableAndClick(create.getBook());

			String Name = DikshaUtils.set_Content_Name("eTextbook_");

			DikshaUtils.waitToBeClickableAndSendKeys(create.getBookname(), Name);
			DikshaUtils.waitToBeVisibleAndClick(create.getBookname());
			DikshaUtils.waitToBeVisibleAndClick(create.getStartCreating());

			JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("arguments[0].scrollIntoView(true);",Upload.getSelectBoardSyllabus());
			js.executeScript("window.scrollBy(0, 900)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(create.getSelectBoardSyllabus());
			DikshaUtils.waitToBeClickableAndClick(create.getBoardSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectMedium());
			DikshaUtils.waitToBeClickableAndClick(create.getMediumSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectClass());
			DikshaUtils.waitToBeClickableAndClick(create.getClassSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectSubject());
			DikshaUtils.waitToBeClickableAndClick(create.getSubjectSelected());

			js.executeScript("arguments[0].scrollIntoView(true);", create.getCopyright());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(create.getCopyright());
			create.getCopyright().sendKeys("2023");
			js.executeScript("window.scrollTo(0, 0)");
			DikshaUtils.waitToBeClickableAndClick(create.getSaveAsDraft());
			Thread.sleep(5000);
			String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
			Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(create.getAddChild());
			DikshaUtils.waitToBeVisibleAndClick(content.getAddFromLibraryButton());
			DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
			String textbook = excel.getContentName("PDF1");
			DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), textbook);
			content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
			DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
			DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());

			DikshaUtils.waitToBeClickableAndClick(create.getAddCollaborator());
			DikshaUtils.waitToBeClickableAndSendKeys(create.getSearchCollaborator(), "ContentCreator2.0");
			Thread.sleep(1000);
			create.getSearchCollaborator().sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			DikshaUtils.waitToBeVisibleAndClick(create.getSelectContentCollaborator());

			js.executeScript("arguments[0].scrollIntoView(true);", create.getDoneButton());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(create.getDoneButton());

			Thread.sleep(1000);
			WebElement CollaboratorPopup = driver
					.findElement(By.xpath("//strong[text()='Collaborators updated successfully']"));
			String CollaboratorssuccessfullyPopup = CollaboratorPopup.getText();
			Assert.assertEquals(CollaboratorssuccessfullyPopup, "Collaborators updated successfully");
			Thread.sleep(1000);

			DikshaUtils.waitToBeClickableAndClick(create.getSubmitForreviewButton());
			DikshaUtils.waitToBeClickableAndClick(create.getTermsAndConditionCheckbox());
			DikshaUtils.waitToBeClickableAndClick(create.getNewCoursesubmitButton());
			Thread.sleep(2000);
			ContentsendPopup = popup.getSendForReviewPopUp().getText();
			Assert.assertEquals(ContentsendPopup, "Content is sent for review");
			Thread.sleep(2000);

			actual = "Creator is able to create book and add collaborator and send for review successfully";

			excel.updateData("TestData", "Collections", Name, "");
			return Name;

		} finally {

			String popupText = ContentsendPopup != null ? ContentsendPopup : "N/A";
			System.out.println(popupText);
			Listeners.customAssert("Content is sent for review", popupText, expected, actual);

		}

	}

	public static void CopyThePublishedBookAndSendForReview(String Fullname) throws Exception {

		CreateBook create = PageFactory.initElements(driver, CreateBook.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		Draft draft = PageFactory.initElements(driver, Draft.class);

		String expected = "Verify creator should be copy the published book and send for review successfully";
		String actual = "Creator is unable to  copy the published book and send for review";
		String ContentsuccessfullySavedPopup = null;
		try {

			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(create.getDigitalTextbook());
			DikshaUtils.waitToBeClickableAndSendKeys(home.getSearchtextfield(), Fullname);
			DikshaUtils.waitToBeClickableAndClick(home.getSearchbutton());

			Thread.sleep(2000);
//			DikshaUtils.waitToBeClickableAndClick(draft.getClickSearchContent());
//			Thread.sleep(2000);
			
			DikshaUtils.waitToBeClickableAndClick(draft.getClickSearchContent1());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(create.getCopyButton());
			Thread.sleep(2000);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("arguments[0].scrollIntoView(true);",Upload.getSelectBoardSyllabus());
			js.executeScript("window.scrollBy(0, 900)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(create.getSelectBoardSyllabus());
			DikshaUtils.waitToBeClickableAndClick(create.getBoardSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectMedium());
			DikshaUtils.waitToBeClickableAndClick(create.getMediumSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectClass());
			DikshaUtils.waitToBeClickableAndClick(create.getClassSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectSubject());
			DikshaUtils.waitToBeClickableAndClick(create.getSubjectSelected());
			
			DikshaUtils.waitToBeVisibleAndClick(create.getAddChild());
			Thread.sleep(2000);
			DikshaUtils.waitToBeVisibleAndClick(create.getYesQRCodeRequired());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndSendKeys(create.getEnterQRCode(), "B5P3M2");
			Thread.sleep(2000);
			DikshaUtils.waitToBeVisibleAndClick(create.getQRCodeBlueTick());
			Thread.sleep(2000);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, 0)");
			DikshaUtils.waitToBeVisibleAndClick(create.getSaveAsDraft());
			Thread.sleep(5000);
			ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
			Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(create.getSubmitForreviewButton());
			Thread.sleep(4000);
			DikshaUtils.waitToBeVisibleAndClick(create.getTermsAndConditionCheckbox());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(create.getNewCoursesubmitButton());
			Thread.sleep(2000);
//			DikshaUtils.waitToBeClickableAndClick(draft.getDeleteContentFromDraft());
//			DikshaUtils.waitToBeClickableAndClick(draft.getConfirmDeleteContentFromDraft());

			actual = "Creator is able to copy the published book and send for review successfully";
		} finally {
			String Text = ContentsuccessfullySavedPopup != null ? ContentsuccessfullySavedPopup : "N/A";
			Listeners.customAssert("Content is saved", Text, expected, actual);
		}
	}

	public static String CreateBookWithQRCodeAndSendForReview() throws Exception {

		CreateBook create = PageFactory.initElements(driver, CreateBook.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Creator should be able to create book with qr code and send for review successfully";
		String actual = "Creator is unable to create book with qr code and send for review";
		String ContentsendPopup = null;

		try {
			DikshaUtils.waitToBeClickableAndClick(create.getHeaderDropdown());
			DikshaUtils.waitToBeClickableAndClick(create.getWorkspace());
			DikshaUtils.waitToBeClickableAndClick(create.getBook());

			String Name = DikshaUtils.set_Content_Name("eTextbook_");

			DikshaUtils.waitToBeClickableAndSendKeys(create.getBookname(), Name);
			DikshaUtils.waitToBeVisibleAndClick(create.getBookname());
			DikshaUtils.waitToBeVisibleAndClick(create.getStartCreating());
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", create.getYesQRCodeRequired());
			// js.executeScript("window.scrollBy(0, 900)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(create.getYesQRCodeRequired());
			DikshaUtils.waitToBeClickableAndSendKeys(create.getEnterQRCode(), "V9X1R7");
			DikshaUtils.waitToBeClickableAndClick(create.getQRCodeBlueTick());
			String id = DikshaUtils.generate_Do_id();
			excel.updateData("TestData", "ETextBook", Name, id);
			DikshaUtils.waitToBeVisibleAndClick(create.getSelectBoardSyllabus());
			DikshaUtils.waitToBeClickableAndClick(create.getBoardSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectMedium());
			DikshaUtils.waitToBeClickableAndClick(create.getMediumSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectClass());
			DikshaUtils.waitToBeClickableAndClick(create.getClassSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectSubject());
			DikshaUtils.waitToBeClickableAndClick(create.getSubjectSelected());

			js.executeScript("arguments[0].scrollIntoView(true);", create.getCopyright());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(create.getCopyright());
			create.getCopyright().sendKeys("2023");
			js.executeScript("window.scrollTo(0, 0)");
			DikshaUtils.waitToBeClickableAndClick(create.getSaveAsDraft());
			Thread.sleep(5000);
			String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
			Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(create.getAddChild());
			DikshaUtils.waitToBeVisibleAndClick(content.getAddFromLibraryButton());

			DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
			String textbook = excel.getContentName("PDF1");
			DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), "PDF_");
			content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
			DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
			DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());
			DikshaUtils.waitToBeClickableAndClick(create.getSubmitForreviewButton());
			Thread.sleep(3000);
			DikshaUtils.waitToBeClickableAndClick(create.getTermsAndConditionCheckbox());
			DikshaUtils.waitToBeClickableAndClick(create.getNewCoursesubmitButton());
			Thread.sleep(2000);
			ContentsendPopup = popup.getSendForReviewPopUp().getText();
			Assert.assertEquals(ContentsendPopup, "Content is sent for review");
			Thread.sleep(6000);

			actual = "Creator should be able to create book with qr code and send for review successfully";
			return Name;
		} finally {
			String Text = ContentsendPopup != null ? ContentsendPopup : "N/A";
			Listeners.customAssert(ContentsendPopup, Text, expect, actual);
		}

	}

	public static String CreatorAddAllTypeOfContent() throws Exception {

		CreateBook create = PageFactory.initElements(driver, CreateBook.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expected = "Verify creator should be able to add all type of content successfully";
		String actual = "Creator is unable to add all type of content";
		String SavedAsDraftPopup = null;

		try {

			DikshaUtils.waitToBeClickableAndClick(create.getHeaderDropdown());
			DikshaUtils.waitToBeClickableAndClick(create.getWorkspace());
			DikshaUtils.waitToBeClickableAndClick(create.getBook());

			String Name = DikshaUtils.set_Content_Name("eTextbook_");

			DikshaUtils.waitToBeClickableAndSendKeys(create.getBookname(), Name);
			DikshaUtils.waitToBeVisibleAndClick(create.getBookname());
			DikshaUtils.waitToBeVisibleAndClick(create.getStartCreating());

			JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("arguments[0].scrollIntoView(true);",Upload.getSelectBoardSyllabus());
			js.executeScript("window.scrollBy(0, 900)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(create.getSelectBoardSyllabus());
			DikshaUtils.waitToBeClickableAndClick(create.getBoardSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectMedium());
			DikshaUtils.waitToBeClickableAndClick(create.getMediumSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectClass());
			DikshaUtils.waitToBeClickableAndClick(create.getClassSelected());
			DikshaUtils.waitToBeClickableAndClick(create.getSelectSubject());
			DikshaUtils.waitToBeClickableAndClick(create.getSubjectSelected());

			js.executeScript("arguments[0].scrollIntoView(true);", create.getCopyright());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(create.getCopyright());
			create.getCopyright().sendKeys("2023");
			js.executeScript("window.scrollTo(0, 0)");
			DikshaUtils.waitToBeClickableAndClick(create.getSaveAsDraft());
			Thread.sleep(5000);
			DikshaUtils.waitToBeClickableAndClick(create.getAddChild());
			DikshaUtils.waitToBeVisibleAndClick(content.getAddFromLibraryButton());
			DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());

			String pdffile = excel.getContentName("PDF1");
			DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), pdffile);
			content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
			DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
			Thread.sleep(1000);

			DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
			content.getSearchContentFromLibrary().clear();
			String Mp4File = excel.getContentName("Mp41");
			DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), Mp4File);
			content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
			DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
			Thread.sleep(1000);

			DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
			content.getSearchContentFromLibrary().clear();
			String EpubFile = excel.getContentName("Epub1");
			DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), EpubFile);
			content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
			DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
			Thread.sleep(1000);

			DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
			content.getSearchContentFromLibrary().clear();
			String h5pFile = excel.getContentName("h5p1");
			DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), h5pFile);
			content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
			DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
			Thread.sleep(1000);

			DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
			content.getSearchContentFromLibrary().clear();
			String htmlFile = excel.getContentName("html1");
			DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), htmlFile);
			content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
			DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
			Thread.sleep(1000);

			DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
			content.getSearchContentFromLibrary().clear();
			String WebmFile = excel.getContentName("Webm1");
			DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), WebmFile);
			content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
			DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
			Thread.sleep(1000);

//			DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
//			content.getSearchContentFromLibrary().clear();
//		    String YTFile = excel.getContentName("YT");
//            DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(),YTFile);  
// 			content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
//			Thread.sleep(3000);
//			DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
//			DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
//			Thread.sleep(1000);

//			DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
//			content.getSearchContentFromLibrary().clear();
//		    String Collectionsfile = excel.getContentName("Collections");
//            DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(),Collectionsfile);  
// 			content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
//			Thread.sleep(3000);
//			DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
//			DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
//			Thread.sleep(1000);

//			DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
//			content.getSearchContentFromLibrary().clear();
//		    String Coursefile = excel.getContentName("Course");
//            DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(),Coursefile);  
// 			content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
//			Thread.sleep(3000);
//			DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
//			DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
//			Thread.sleep(1000);

			DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());
			Thread.sleep(3000);
			DikshaUtils.waitToBeClickableAndClick(create.getSaveAsDraft());
			Thread.sleep(5000);
			SavedAsDraftPopup = popup.getSaveAsDraftPopUp().getText();
			Assert.assertEquals(SavedAsDraftPopup, "Content is saved");
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(create.getBackButton());
			Thread.sleep(5000);

			actual = "Creator is able to add all type of content successfully";

			excel.updateData("TestData", "Collections", Name, "");
			return Name;

		} finally {

			String popupText = SavedAsDraftPopup != null ? SavedAsDraftPopup : "N/A";
			System.out.println(popupText);
			Listeners.customAssert("Content is saved", popupText, expected, actual);

		}
	}

	public static void SearchTheBookFromDraft(String fullname) throws Exception {

		Draft draft = PageFactory.initElements(driver, Draft.class);
		CreateBook create = PageFactory.initElements(driver, CreateBook.class);

		String expected = "Verify creator should be able to search the book from draft successfully ";
		String actual = "Creator is unable to search the book from draft ";

		boolean checkContent = false;
		String checkCondition = null;
		
		try {

			if (draft.getHeaderDropdown().isDisplayed()) {
				checkContent = true;
		
		DikshaUtils.waitToBeClickableAndClick(draft.getHeaderDropdown());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", draft.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(draft.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(draft.getDraft());
		DikshaUtils.waitToBeClickableAndClick(draft.getSearchForPublished());
		draft.getSearchForPublished().sendKeys(fullname);
		DikshaUtils.waitToBeClickableAndClick(draft.getSearchIcon());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(draft.getClickSearchContent());
		Thread.sleep(2000);
		
		actual = "Creator is able to search the book from draft successfully ";
		checkCondition = "True";
	}

} finally {

	Listeners.customAssert("True", checkCondition, expected, actual);
	
}

	}

	public static String CreatorAddAllTypeOfContentAndSendForReview() throws Exception {

		CreateBook create = PageFactory.initElements(driver, CreateBook.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);

		DikshaUtils.waitToBeClickableAndClick(create.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(create.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(create.getBook());

		String Name = DikshaUtils.set_Content_Name("eTextbook_");

		DikshaUtils.waitToBeClickableAndSendKeys(create.getBookname(), Name);
		DikshaUtils.waitToBeVisibleAndClick(create.getBookname());
		DikshaUtils.waitToBeVisibleAndClick(create.getStartCreating());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView(true);",Upload.getSelectBoardSyllabus());
		js.executeScript("window.scrollBy(0, 900)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(create.getSelectBoardSyllabus());
		DikshaUtils.waitToBeClickableAndClick(create.getBoardSelected());
		DikshaUtils.waitToBeClickableAndClick(create.getSelectMedium());
		DikshaUtils.waitToBeClickableAndClick(create.getMediumSelected());
		DikshaUtils.waitToBeClickableAndClick(create.getSelectClass());
		DikshaUtils.waitToBeClickableAndClick(create.getClassSelected());
		DikshaUtils.waitToBeClickableAndClick(create.getSelectSubject());
		DikshaUtils.waitToBeClickableAndClick(create.getSubjectSelected());

		js.executeScript("arguments[0].scrollIntoView(true);", create.getCopyright());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(create.getCopyright());
		create.getCopyright().sendKeys("2023");
		js.executeScript("window.scrollTo(0, 0)");
		DikshaUtils.waitToBeClickableAndClick(create.getSaveAsDraft());
		Thread.sleep(5000);
		DikshaUtils.waitToBeClickableAndClick(create.getAddChild());
		DikshaUtils.waitToBeVisibleAndClick(content.getAddFromLibraryButton());
		DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());

		String pdffile = excel.getContentName("PDF1");
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), pdffile);
		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
		content.getSearchContentFromLibrary().clear();
		String Mp4File = excel.getContentName("Mp41");
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), Mp4File);
		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
		content.getSearchContentFromLibrary().clear();
		String EpubFile = excel.getContentName("Epub1");
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), EpubFile);
		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
		content.getSearchContentFromLibrary().clear();
		String h5pFile = excel.getContentName("h5p1");
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), h5pFile);
		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
		content.getSearchContentFromLibrary().clear();
		String htmlFile = excel.getContentName("html1");
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), htmlFile);
		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
		content.getSearchContentFromLibrary().clear();
		String WebmFile = excel.getContentName("Webm1");
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), WebmFile);
		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(1000);

//		DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
//		content.getSearchContentFromLibrary().clear();
//	    String YTFile = excel.getContentName("YT");
//       DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(),YTFile);  
//		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
//		Thread.sleep(3000);
//		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
//		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
//		Thread.sleep(1000);

//		DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
//		content.getSearchContentFromLibrary().clear();
//	    String Collectionsfile = excel.getContentName("Collections");
//       DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(),Collectionsfile);  
//		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
//		Thread.sleep(3000);
//		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
//		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
//		Thread.sleep(1000);

//		DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
//		content.getSearchContentFromLibrary().clear();
//	    String Coursefile = excel.getContentName("Course");
//       DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(),Coursefile);  
//		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
//		Thread.sleep(3000);
//		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
//		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
//		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());
		DikshaUtils.waitToBeClickableAndClick(create.getSubmitForreviewButton());
		DikshaUtils.waitToBeClickableAndClick(create.getTermsAndConditionCheckbox());
		DikshaUtils.waitToBeClickableAndClick(create.getNewCoursesubmitButton());

		return Name;
	}

	public static String CreatorAddTwoTypeOfContentAndSendForReview() throws Exception {

		CreateBook create = PageFactory.initElements(driver, CreateBook.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);

		DikshaUtils.waitToBeClickableAndClick(create.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(create.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(create.getBook());

		String Name = DikshaUtils.set_Content_Name("eTextbook_");

		DikshaUtils.waitToBeClickableAndSendKeys(create.getBookname(), Name);
		DikshaUtils.waitToBeVisibleAndClick(create.getBookname());
		DikshaUtils.waitToBeVisibleAndClick(create.getStartCreating());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView(true);",Upload.getSelectBoardSyllabus());
		js.executeScript("window.scrollBy(0, 900)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(create.getSelectBoardSyllabus());
		DikshaUtils.waitToBeClickableAndClick(create.getBoardSelected());
		DikshaUtils.waitToBeClickableAndClick(create.getSelectMedium());
		DikshaUtils.waitToBeClickableAndClick(create.getMediumSelected());
		DikshaUtils.waitToBeClickableAndClick(create.getSelectClass());
		DikshaUtils.waitToBeClickableAndClick(create.getClassSelected());
		DikshaUtils.waitToBeClickableAndClick(create.getSelectSubject());
		DikshaUtils.waitToBeClickableAndClick(create.getSubjectSelected());

		js.executeScript("arguments[0].scrollIntoView(true);", create.getCopyright());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(create.getCopyright());
		create.getCopyright().sendKeys("2023");
		js.executeScript("window.scrollTo(0, 0)");
		DikshaUtils.waitToBeClickableAndClick(create.getSaveAsDraft());
		Thread.sleep(5000);
		DikshaUtils.waitToBeClickableAndClick(create.getAddChild());
		DikshaUtils.waitToBeVisibleAndClick(content.getAddFromLibraryButton());
		DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());

		String pdffile = excel.getContentName("PDF1");
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), pdffile);
		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(content.getSearchContentFromLibrary());
		content.getSearchContentFromLibrary().clear();
		String Mp4File = excel.getContentName("Mp41");
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), Mp4File);
		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());
		DikshaUtils.waitToBeClickableAndClick(create.getSubmitForreviewButton());
		DikshaUtils.waitToBeClickableAndClick(create.getTermsAndConditionCheckbox());
		DikshaUtils.waitToBeClickableAndClick(create.getNewCoursesubmitButton());

		Thread.sleep(5000);

		excel.updateData("TestData", "Collections", Name, "");

		return Name;

	}

}