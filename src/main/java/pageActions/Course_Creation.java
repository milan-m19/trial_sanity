package pageActions;

import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObject.BMCPopup;
import pageObject.CourseCreation;
import pageObject.CreateBook;
import pageObject.Groups;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.UpForReview;
import pageObject.ValidatePopUp;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.Library;
import utility.Listeners;

public class Course_Creation extends BaseClass {

	public static String UploadContentFromLibrary(String contentName) throws Exception {
		
		 CourseCreation content=PageFactory.initElements(driver, CourseCreation.class);
		 ValidatePopUp popup=PageFactory.initElements(driver, ValidatePopUp.class);
		 
			String expect = "Creator should be able to add content from library and create course successfully";
			String actual = "Creator is unable to create course ";
			String ContentsendPopup=null;
		 
		 try {
		 DikshaUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
		 DikshaUtils.waitToBeClickableAndClick(content.getWorkspace());
		 DikshaUtils.waitToBeClickableAndClick(content.getCoursetab());
		 Thread.sleep(1000);
		 DikshaUtils.waitToBeClickableAndClick(content.getAddCourseTitle());
		 content.getAddCourseTitle().clear();
		 String randomname=DikshaUtils.set_Content_Name("Course_");
		 DikshaUtils.waitToBeClickableAndSendKeys(content.getAddCourseTitle(),randomname);
			
		 String id= DikshaUtils.generate_Do_id();
		 excel.updateData("TestData","Course" ,randomname, id);
	       
	     int scrollX = 0; // horizontal scroll amount
	     int scrollY = 200; // vertical scroll amount
	     JavascriptExecutor js=(JavascriptExecutor)driver;
	     js.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
	     DikshaUtils.waitToBeClickableAndClick(content.getCourseadditionalCategory());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectAdditionalCategory());
	     js.executeScript("arguments[0].scrollIntoView(true);",content.getCourseType());
	     DikshaUtils.waitToBeClickableAndClick(content.getCourseType());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType());
	    // DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType1());
	     DikshaUtils.waitToBeClickableAndClick(content.getSubjectCovered());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject());
	     
	     JavascriptExecutor js1=(JavascriptExecutor)driver;
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectBoardForcourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectBoardForcourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectBoard());
	     
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectMediumForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectMediumForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectMedium());
	     
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectClassForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectClassForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectclass());
		
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectSubjectForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubjectForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject2());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getSelectCopyRightYear(),"2023");
	     
	     js.executeScript("window.scrollTo(0, 0)");
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSaveAsDraft());
	     Thread.sleep(5000);
	     String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
	     Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
	     Thread.sleep(1000);
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getAddChild());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getChildDesc1(),"Created via Automation");
	     DikshaUtils.waitToBeClickableAndClick(content.getAddFromLibraryButton());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(),contentName);
		
	     content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
	     Thread.sleep(3000);
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
	     DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
	     Thread.sleep(2000);
	     String ContentsuccessfullyaddPopUp = popup.getContentAddFromLibraryPopup().getText();
	     Assert.assertEquals(ContentsuccessfullyaddPopUp, "Content is added to the folder");
	     Thread.sleep(2000);
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());
	     DikshaUtils.waitToBeClickableAndClick(content.getSubmitForreviewButton());
	     DikshaUtils.waitToBeClickableAndClick(content.getTermsAndConditionCheckbox());
	     DikshaUtils.waitToBeClickableAndClick(content.getNewCoursesubmitButton());
	     Thread.sleep(2000);
	     ContentsendPopup = popup.getSendForReviewPopUp().getText();
	     Thread.sleep(2000);
			actual="Creator is able to add content from library and create course successfully";
			
			return randomname;
		 } finally {
			 String Text = ContentsendPopup != null ? ContentsendPopup : "N/A";
				Listeners.customAssert("Content is sent for review", Text, expect, actual);
		}
		 
		}
	 
	 public static String addingCourseAssessmentFromLibrary(String contentName) throws Exception {
			
		 CourseCreation content=PageFactory.initElements(driver, CourseCreation.class);
		 ValidatePopUp popup=PageFactory.initElements(driver, ValidatePopUp.class);
		 
			String expect = "Creator should able be able to add course assessment from library and create course successfully";
			String actual = "Creator is  unable to add course assessment from library and create course successfully";
			String ContentsendPopup=null;
		 
		 try {
		 DikshaUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
		 DikshaUtils.waitToBeClickableAndClick(content.getWorkspace());
		 DikshaUtils.waitToBeClickableAndClick(content.getCoursetab());
		 Thread.sleep(1000);
		 DikshaUtils.waitToBeClickableAndClick(content.getAddCourseTitle());
		 content.getAddCourseTitle().clear();
		 String randomname=DikshaUtils.set_Content_Name("Course_");
		 DikshaUtils.waitToBeClickableAndSendKeys(content.getAddCourseTitle(),randomname);
			
		 String id= DikshaUtils.generate_Do_id();
		 excel.updateData("TestData","Course" ,randomname, id);
	       
	     int scrollX = 0; // horizontal scroll amount
	     int scrollY = 200; // vertical scroll amount
	     JavascriptExecutor js=(JavascriptExecutor)driver;
	     js.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
	     DikshaUtils.waitToBeClickableAndClick(content.getCourseadditionalCategory());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectAdditionalCategory());
	     DikshaUtils.waitToBeClickableAndClick(content.getCourseType());
	     //DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType1());
	     DikshaUtils.waitToBeClickableAndClick(content.getSubjectCovered());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject());
	     
	     JavascriptExecutor js1=(JavascriptExecutor)driver;
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectBoardForcourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectBoardForcourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectBoard());
	     
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectMediumForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectMediumForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectMedium());
	     
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectClassForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectClassForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectclass());
		
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectSubjectForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubjectForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject2());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getSelectCopyRightYear(),"2023");
	     
	     js.executeScript("window.scrollTo(0, 0)");
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSaveAsDraft());
	     Thread.sleep(5000);
	     String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
	     Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
	     Thread.sleep(1000);
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getAddChild());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getChildDesc1(),"Created via Automation");
	     DikshaUtils.waitToBeClickableAndClick(content.getAddFromLibraryButton());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(),contentName);
		
	     content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
	     Thread.sleep(3000);
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
	     DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
	     Thread.sleep(2000);
	     String ContentsuccessfullyaddPopUp = popup.getContentAddFromLibraryPopup().getText();
	     Assert.assertEquals(ContentsuccessfullyaddPopUp, "Content is added to the folder");
	     Thread.sleep(2000);
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());
	     DikshaUtils.waitToBeClickableAndClick(content.getSubmitForreviewButton());
	     DikshaUtils.waitToBeClickableAndClick(content.getTermsAndConditionCheckbox());
	     DikshaUtils.waitToBeClickableAndClick(content.getNewCoursesubmitButton());
	     Thread.sleep(2000);
	     ContentsendPopup = popup.getSendForReviewPopUp().getText();
	     Thread.sleep(2000);
			actual="Creator is able be able to add course assessment from library and create course successfully";
			
			return randomname;
		 } finally {
			 String Text = popup.getSendForReviewPopUp() != null ? popup.getSendForReviewPopUp().getText() : "N/A";
				Listeners.customAssert(ContentsendPopup, Text, expect, actual);
		}
		 
		}

	public static String UploadTwoTypeOfContentFromLibrary(String contentName) throws Exception {

		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(content.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(content.getCoursetab());
		DikshaUtils.waitToBeClickableAndClick(content.getAddCourseTitle());
		content.getAddCourseTitle().clear();
		String randomname = DikshaUtils.set_Content_Name("Course_");
		DikshaUtils.waitToBeClickableAndSendKeys(content.getAddCourseTitle(), randomname);

		String id = DikshaUtils.generate_Do_id();
		excel.updateData("TestData", "Course", randomname, id);

		int scrollX = 0; // horizontal scroll amount
		int scrollY = 200; // vertical scroll amount
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
		DikshaUtils.waitToBeClickableAndClick(content.getCourseadditionalCategory());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectAdditionalCategory());
		DikshaUtils.waitToBeClickableAndClick(content.getCourseType());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType());
		DikshaUtils.waitToBeClickableAndClick(content.getSubjectCovered());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject());

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectBoardForcourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectBoardForcourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectBoard());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectMediumForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectMediumForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectMedium());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectClassForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectClassForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectclass());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectSubjectForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubjectForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject2());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSelectCopyRightYear(), "2023");

		js.executeScript("window.scrollTo(0, 0)");

		DikshaUtils.waitToBeClickableAndClick(content.getSaveAsDraft());
		Thread.sleep(5000);
		String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
		Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(content.getAddChild());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getChildDesc1(), "Created via Automation");
		DikshaUtils.waitToBeClickableAndClick(content.getAddFromLibraryButton());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), contentName);

		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(2000);
		String ContentsuccessfullyaddPopup = popup.getContentAddFromLibraryPopup().getText();
		Assert.assertEquals(ContentsuccessfullyaddPopup, "Content is added to the folder");
		Thread.sleep(2000);

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
		DikshaUtils.waitToBeClickableAndClick(content.getSubmitForreviewButton());
		DikshaUtils.waitToBeClickableAndClick(content.getTermsAndConditionCheckbox());
		DikshaUtils.waitToBeClickableAndClick(content.getNewCoursesubmitButton());
		Thread.sleep(2000);
		String ContentsendPopup = popup.getSendForReviewPopUp().getText();
		Assert.assertEquals(ContentsendPopup, "Content is sent for review");
		Thread.sleep(2000);

		return randomname;

	}

	public static String courseWithAttribution(String contentName) throws Exception {

		String expect = "Creator should add attribution to course";
		String actual = "Unable to add attribution to course";
		String ContentsendPopup = null;
		try {

		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		UpForReview review = PageFactory.initElements(driver, UpForReview.class);

		DikshaUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(content.getWorkspace());
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getAllMyContentButton());
		DikshaUtils.waitToBeClickableAndSendKeys(review.getSearchForReview(), contentName);
		DikshaUtils.waitToBeClickableAndClick(review.getSearchedContentForPublish());
		DikshaUtils.waitToBeClickableAndClick(review.getTaboncourse());
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 800)");
		js.executeScript("arguments[0].scrollIntoView(true);", content.getAttributionTextField());
		DikshaUtils.waitToBeClickableAndClick(content.getAttributionTextField());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getAttributionTextField(), "One,Two,Three");
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(content.getSaveAsDraft());
		Thread.sleep(5000);
		String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
		Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(content.getSubmitForreviewButton());
		DikshaUtils.waitToBeClickableAndClick(content.getTermsAndConditionCheckbox());
		DikshaUtils.waitToBeClickableAndClick(content.getNewCoursesubmitButton());
		Thread.sleep(2000);
		ContentsendPopup = popup.getSendForReviewPopUp().getText();
		//Assert.assertEquals(ContentsendPopup, "Content is sent for review");
		Thread.sleep(2000);
		
		actual = "Attribution added to course successfully";

		return contentName;
		}finally {
			String Text = ContentsendPopup != null ? ContentsendPopup : "N/A";
			Listeners.customAssert("Content is sent for review", Text, expect, actual);
			
		}

	}
	public static String courseWithoutDescription(String contentName) throws Exception {

		 CourseCreation content=PageFactory.initElements(driver, CourseCreation.class);
		 LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		 ValidatePopUp popup=PageFactory.initElements(driver, ValidatePopUp.class);
		 
		 String expect = "Creator should be able to create course without description successfully";
		 String actual = "Creator is  unable to create course without description";
		 String ContentsendPopup=null;
		 
		 try {
		 DikshaUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
		 DikshaUtils.waitToBeClickableAndClick(content.getWorkspace());
		 DikshaUtils.waitToBeClickableAndClick(content.getCoursetab());
		 Thread.sleep(1000);
		 DikshaUtils.waitToBeClickableAndClick(content.getAddCourseTitle());
		 content.getAddCourseTitle().clear();
		 String randomname=DikshaUtils.set_Content_Name("Course_");
		 DikshaUtils.waitToBeClickableAndSendKeys(content.getAddCourseTitle(),randomname);
		 DikshaUtils.waitToBeClickableAndClick(content.getDescriptionTextfield());
		 Thread.sleep(1000);
		 Actions action=new Actions(driver);
		 for(int i=1;i<30;i++) {
			 action.sendKeys("\b").perform();
			}
			Thread.sleep(500);
		 String id= DikshaUtils.generate_Do_id();
		 excel.updateData("TestData","Course" ,randomname, id);
	       
	     int scrollX = 0; // horizontal scroll amount
	     int scrollY = 200; // vertical scroll amount
	     JavascriptExecutor js=(JavascriptExecutor)driver;
	     js.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
	     DikshaUtils.waitToBeClickableAndClick(content.getCourseadditionalCategory());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectAdditionalCategory());
	     DikshaUtils.waitToBeClickableAndClick(content.getCourseType());
	     //DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType1());
	     DikshaUtils.waitToBeClickableAndClick(content.getSubjectCovered());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject());
	     
	     JavascriptExecutor js1=(JavascriptExecutor)driver;
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectBoardForcourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectBoardForcourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectBoard());
	     
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectMediumForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectMediumForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectMedium());
	     
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectClassForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectClassForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectclass());
		
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectSubjectForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubjectForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject2());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getSelectCopyRightYear(),"2023");
	     
	     js.executeScript("window.scrollTo(0, 0)");
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSaveAsDraft());
	     Thread.sleep(5000);
	     String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
	     Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
	     Thread.sleep(1000);
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getAddChild());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getChildDesc1(),"Created via Automation");
	     DikshaUtils.waitToBeClickableAndClick(content.getAddFromLibraryButton());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(),contentName);
		
	     content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
	     Thread.sleep(3000);
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
	     DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
	     Thread.sleep(2000);
	     String ContentsuccessfullyaddPopup = popup.getContentAddFromLibraryPopup().getText();
	     Assert.assertEquals(ContentsuccessfullyaddPopup, "Content is added to the folder");
	     Thread.sleep(2000);
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());
	     DikshaUtils.waitToBeClickableAndClick(content.getSubmitForreviewButton());
	     DikshaUtils.waitToBeClickableAndClick(content.getTermsAndConditionCheckbox());
	     DikshaUtils.waitToBeClickableAndClick(content.getNewCoursesubmitButton());
	     Thread.sleep(2000);
	     ContentsendPopup = popup.getSendForReviewPopUp().getText();
	     Thread.sleep(2000);
			actual="Creator is able to create course without description successfully";
			
			return randomname;
		 } finally {
			 String Text = ContentsendPopup != null ? ContentsendPopup : "N/A";
				Listeners.customAssert(ContentsendPopup, Text, expect, actual);
		}
			
		}

	public static String verifyCheckBoxDescription(String contentName) throws Exception {

		String expect = "Creator should see terms & conditions description";
		String actual = "Unable to see terms & conditions description";
		String ContentsendPopup = null;
		try {

		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(content.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(content.getCoursetab());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(content.getAddCourseTitle());
		content.getAddCourseTitle().clear();
		String randomname = DikshaUtils.set_Content_Name("Course_");
		DikshaUtils.waitToBeClickableAndSendKeys(content.getAddCourseTitle(), randomname);

		String id = DikshaUtils.generate_Do_id();
		excel.updateData("TestData", "Course", randomname, id);

		int scrollX = 0; // horizontal scroll amount
		int scrollY = 200; // vertical scroll amount
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
		DikshaUtils.waitToBeClickableAndClick(content.getCourseadditionalCategory());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectAdditionalCategory());
		DikshaUtils.waitToBeClickableAndClick(content.getCourseType());
		// DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType1());
		DikshaUtils.waitToBeClickableAndClick(content.getSubjectCovered());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject());

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectBoardForcourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectBoardForcourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectBoard());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectMediumForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectMediumForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectMedium());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectClassForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectClassForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectclass());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectSubjectForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubjectForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject2());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSelectCopyRightYear(), "2023");

		js.executeScript("window.scrollTo(0, 0)");

		DikshaUtils.waitToBeClickableAndClick(content.getSaveAsDraft());
		Thread.sleep(5000);
		String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
		Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(content.getAddChild());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getChildDesc1(), "Created via Automation");
		DikshaUtils.waitToBeClickableAndClick(content.getAddFromLibraryButton());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), contentName);

		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(2000);
		String ContentsuccessfullyaddPopup = popup.getContentAddFromLibraryPopup().getText();
		Assert.assertEquals(ContentsuccessfullyaddPopup, "Content is added to the folder");
		Thread.sleep(2000);

		DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());
		DikshaUtils.waitToBeClickableAndClick(content.getSubmitForreviewButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(content.getTermsAndConditionCheckbox());
		String description = content.getCheckboxDescription().getText();
		Assert.assertEquals(description,
				"I confirm that this Content complies with prescribed guidelines, including the Terms of Use and Content Policy and that I consent to publish it under the Creative Commons Framework in accordance with the Content Policy. I have made sure that I do not violate others’ copyright or privacy rights.\"");
		DikshaUtils.waitToBeClickableAndClick(content.getNewCoursesubmitButton());
		Thread.sleep(2000);
		ContentsendPopup = popup.getSendForReviewPopUp().getText();
		//Assert.assertEquals(ContentsendPopup, "Content is sent for review");
		Thread.sleep(2000);
		actual = "Terms & conditions description is visible to creator";

		return randomname;
		}finally {
			String Text = ContentsendPopup != null ? ContentsendPopup : "N/A";
			System.out.println(Text);
			Listeners.customAssert("Content is sent for review", Text, expect, actual);
			
		}

	}
	public static String createCourseInHindiLanguage(String contentName) throws Exception {

		 CourseCreation content=PageFactory.initElements(driver, CourseCreation.class);
		 LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		 ValidatePopUp popup=PageFactory.initElements(driver, ValidatePopUp.class);
		 
		 String expect = "Creator should be able to create course in regional language successfully";
		 String actual = "Creator is  unable to create course in regional language";
		 String ContentsendPopup=null;
		 
		 try {
		 DikshaUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
		 DikshaUtils.waitToBeClickableAndClick(content.getWorkspace());
		 DikshaUtils.waitToBeClickableAndClick(content.getCoursetab());
		 Thread.sleep(1000);
		 DikshaUtils.waitToBeClickableAndClick(content.getAddCourseTitle());
		 content.getAddCourseTitle().clear();
		 String randomname=DikshaUtils.set_Content_Name("(हिन्दी)Course_");
		 DikshaUtils.waitToBeClickableAndSendKeys(content.getAddCourseTitle(),randomname);
			
		 String id= DikshaUtils.generate_Do_id();
		 excel.updateData("TestData","Course" ,randomname, id);
	       
	     int scrollX = 0; // horizontal scroll amount
	     int scrollY = 200; // vertical scroll amount
	     JavascriptExecutor js=(JavascriptExecutor)driver;
	     js.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
	     DikshaUtils.waitToBeClickableAndClick(content.getCourseadditionalCategory());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectAdditionalCategory());
	     DikshaUtils.waitToBeClickableAndClick(content.getCourseType());
	     //DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType1());
	     DikshaUtils.waitToBeClickableAndClick(content.getSubjectCovered());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject());
	     
	     JavascriptExecutor js1=(JavascriptExecutor)driver;
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectBoardForcourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectBoardForcourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectBoard());
	     
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectMediumForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectMediumForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectMedium());
	     
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectClassForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectClassForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectclass());
		
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectSubjectForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubjectForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject2());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getSelectCopyRightYear(),"2023");
	     
	     js.executeScript("window.scrollTo(0, 0)");
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSaveAsDraft());
	     Thread.sleep(5000);
	     String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
	     Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
	     Thread.sleep(1000);
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getAddChild());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getChildDesc1(),"Created via Automation");
	     DikshaUtils.waitToBeClickableAndClick(content.getAddFromLibraryButton());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(),contentName);
		
	     content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
	     Thread.sleep(3000);
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
	     DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
	     Thread.sleep(2000);
	     String ContentsuccessfullyaddPopup = popup.getContentAddFromLibraryPopup().getText();
	     Assert.assertEquals(ContentsuccessfullyaddPopup, "Content is added to the folder");
	     Thread.sleep(2000);
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());
	     DikshaUtils.waitToBeClickableAndClick(content.getSubmitForreviewButton());
	     DikshaUtils.waitToBeClickableAndClick(content.getTermsAndConditionCheckbox());
	     DikshaUtils.waitToBeClickableAndClick(content.getNewCoursesubmitButton());
	     Thread.sleep(2000);
	     ContentsendPopup = popup.getSendForReviewPopUp().getText();
	     Assert.assertEquals(ContentsendPopup, "Content is sent for review");
	     
	     Thread.sleep(2000);
			actual="Creator is able to create course in regional language successfully";
			
			return randomname;
		 } finally {
			 String Text = ContentsendPopup != null ?ContentsendPopup : "N/A";
				Listeners.customAssert(ContentsendPopup, Text, expect, actual);
		}
			
		}


	public static String createCourseInUrduLanguage(String contentName) throws Exception {
		 CourseCreation content=PageFactory.initElements(driver, CourseCreation.class);
		 LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		 ValidatePopUp popup=PageFactory.initElements(driver, ValidatePopUp.class);
		 String expect = "Creator should be able to create course in Urdu language successfully";
		 String actual = "Creator is  unable to create course in Urdu language";
		 String ContentsendPopup=null;
		 
		 try {
		 DikshaUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
		 DikshaUtils.waitToBeClickableAndClick(content.getWorkspace());
		 DikshaUtils.waitToBeClickableAndClick(content.getCoursetab());
		 Thread.sleep(1000);
		 DikshaUtils.waitToBeClickableAndClick(content.getAddCourseTitle());
		 content.getAddCourseTitle().clear();
		 String randomname=DikshaUtils.set_Content_Name("(لشکری ‍زبان)Course_");
		 DikshaUtils.waitToBeClickableAndSendKeys(content.getAddCourseTitle(),randomname);
			
		 String id= DikshaUtils.generate_Do_id();
		 excel.updateData("TestData","Course" ,randomname, id);
	       
	     int scrollX = 0; // horizontal scroll amount
	     int scrollY = 200; // vertical scroll amount
	     JavascriptExecutor js=(JavascriptExecutor)driver;
	     js.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
	     DikshaUtils.waitToBeClickableAndClick(content.getCourseadditionalCategory());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectAdditionalCategory());
	     DikshaUtils.waitToBeClickableAndClick(content.getCourseType());
	     //DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType1());
	     DikshaUtils.waitToBeClickableAndClick(content.getSubjectCovered());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject());
	     
	     JavascriptExecutor js1=(JavascriptExecutor)driver;
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectBoardForcourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectBoardForcourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectBoard());
	     
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectMediumForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectMediumForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectMedium());
	     
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectClassForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectClassForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectclass());
		
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectSubjectForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubjectForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject2());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getSelectCopyRightYear(),"2023");
	     
	     js.executeScript("window.scrollTo(0, 0)");
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSaveAsDraft());
	     Thread.sleep(5000);
	     String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
	     Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
	     Thread.sleep(1000);
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getAddChild());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getChildDesc1(),"Created via Automation");
	     DikshaUtils.waitToBeClickableAndClick(content.getAddFromLibraryButton());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(),contentName);
		
	     content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
	     Thread.sleep(3000);
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
	     DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
	     Thread.sleep(2000);
	     String ContentsuccessfullyaddPopup = popup.getContentAddFromLibraryPopup().getText();
	     Assert.assertEquals(ContentsuccessfullyaddPopup, "Content is added to the folder");
	     Thread.sleep(2000);
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());
	     DikshaUtils.waitToBeClickableAndClick(content.getSubmitForreviewButton());
	     DikshaUtils.waitToBeClickableAndClick(content.getTermsAndConditionCheckbox());
	     DikshaUtils.waitToBeClickableAndClick(content.getNewCoursesubmitButton());
	     ContentsendPopup = popup.getSendForReviewPopUp().getText();
	     Thread.sleep(2000);
			actual="Creator is able to create course in urdu language successfully";
			
			return randomname;
		 } finally {
			 String Text = ContentsendPopup != null ?ContentsendPopup : "N/A";
				Listeners.customAssert(ContentsendPopup, Text, expect, actual);
		}
			
		}

	public static String checkUploadContentFromLibrary(String contentName) throws Exception {
		
		 CourseCreation content=PageFactory.initElements(driver, CourseCreation.class);
		 LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		 ValidatePopUp popup=PageFactory.initElements(driver, ValidatePopUp.class);
		 
		 String expect = "Creator should be able to add content from library successfully";
			String actual = "Creator is unable to add content from library ";
			String ContentsuccessfullyaddPopup=null;
		 try {
		 DikshaUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
		 DikshaUtils.waitToBeClickableAndClick(content.getWorkspace());
		 DikshaUtils.waitToBeClickableAndClick(content.getCoursetab());
		 DikshaUtils.waitToBeClickableAndClick(content.getAddCourseTitle());
		 content.getAddCourseTitle().clear();
		 String randomname=DikshaUtils.set_Content_Name("Course_");
		 DikshaUtils.waitToBeClickableAndSendKeys(content.getAddCourseTitle(),randomname);
			
		 String id= DikshaUtils.generate_Do_id();
		 excel.updateData("TestData","Course" ,randomname, id);
	        
	     int scrollX = 0; // horizontal scroll amount
	     int scrollY = 200; // vertical scroll amount
	     JavascriptExecutor js=(JavascriptExecutor)driver;
	     js.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
	     DikshaUtils.waitToBeClickableAndClick(content.getCourseadditionalCategory());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectAdditionalCategory());
	     DikshaUtils.waitToBeClickableAndClick(content.getCourseType());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType());
	     DikshaUtils.waitToBeClickableAndClick(content.getSubjectCovered());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject());
	     
	     JavascriptExecutor js1=(JavascriptExecutor)driver;
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectBoardForcourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectBoardForcourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectBoard());
	     
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectMediumForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectMediumForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectMedium());
	     
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectClassForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectClassForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectclass());
		
	     js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectSubjectForCourse());
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubjectForCourse());
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject2());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getSelectCopyRightYear(),"2023");
	     
	     js.executeScript("window.scrollTo(0, 0)");
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getSaveAsDraft());
	     Thread.sleep(5000);
	     String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
	     Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
	     Thread.sleep(1000);
	     
	     DikshaUtils.waitToBeClickableAndClick(content.getAddChild());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getChildDesc1(),"Created via Automation");
	     DikshaUtils.waitToBeClickableAndClick(content.getAddFromLibraryButton());
	     DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(),contentName);
		
	     content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
	     Thread.sleep(3000);
	     DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
	     DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
	     Thread.sleep(2000);
	      ContentsuccessfullyaddPopup = popup.getContentAddFromLibraryPopup().getText();
	     Assert.assertEquals(ContentsuccessfullyaddPopup, "Content is added to the folder");
	     Thread.sleep(2000);
	     actual="Creator is able to add content from library successfully";
			return randomname;
		 }
		 finally {
			 String Text = popup.getContentAddFromLibraryPopup() != null ? popup.getContentAddFromLibraryPopup().getText() : "N/A";
				Listeners.customAssert(ContentsuccessfullyaddPopup, Text, expect, actual);
		 }
		}


	public static String addingTwoAssessmentInCourse(String contentName) throws Exception {
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(content.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(content.getCoursetab());
		DikshaUtils.waitToBeClickableAndClick(content.getAddCourseTitle());
		content.getAddCourseTitle().clear();
		String randomname = DikshaUtils.set_Content_Name("Course_");
		DikshaUtils.waitToBeClickableAndSendKeys(content.getAddCourseTitle(), randomname);

		String id = DikshaUtils.generate_Do_id();
		excel.updateData("TestData", "Course", randomname, id);

		int scrollX = 0; // horizontal scroll amount
		int scrollY = 200; // vertical scroll amount
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
		DikshaUtils.waitToBeClickableAndClick(content.getCourseadditionalCategory());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectAdditionalCategory());
		DikshaUtils.waitToBeClickableAndClick(content.getCourseType());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType());
		DikshaUtils.waitToBeClickableAndClick(content.getSubjectCovered());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject());

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectBoardForcourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectBoardForcourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectBoard());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectMediumForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectMediumForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectMedium());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectClassForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectClassForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectclass());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectSubjectForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubjectForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject2());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSelectCopyRightYear(), "2023");

		js.executeScript("window.scrollTo(0, 0)");

		DikshaUtils.waitToBeClickableAndClick(content.getSaveAsDraft());
		Thread.sleep(5000);
		String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
		Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(content.getAddChild());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getChildDesc1(), "Created via Automation");
		DikshaUtils.waitToBeClickableAndClick(content.getAddFromLibraryButton());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), contentName);

		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(2000);
		String ContentsuccessfullyaddPopup = popup.getContentAddFromLibraryPopup().getText();
		Assert.assertEquals(ContentsuccessfullyaddPopup, "Content is added to the folder");
		Thread.sleep(2000);
		content.getSearchContentFromLibrary().clear();
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), "CourseAssessment_");

		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(2000);
		Assert.assertEquals(ContentsuccessfullyaddPopup, "Content is added to the folder");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());
		DikshaUtils.waitToBeClickableAndClick(content.getSubmitForreviewButton());
		DikshaUtils.waitToBeClickableAndClick(content.getTermsAndConditionCheckbox());
		DikshaUtils.waitToBeClickableAndClick(content.getNewCoursesubmitButton());
		Thread.sleep(2000);
		String ContentsendPopup = popup.getSendForReviewPopUp().getText();
		Assert.assertEquals(ContentsendPopup, "Content is sent for review");
		Thread.sleep(2000);

		return randomname;

	}

	public static String UploadPdfMp4AndAssessmentInCourse(String contentName) throws Exception {

		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(content.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(content.getCoursetab());
		DikshaUtils.waitToBeClickableAndClick(content.getAddCourseTitle());
		content.getAddCourseTitle().clear();
		String randomname = DikshaUtils.set_Content_Name("Course_");
		DikshaUtils.waitToBeClickableAndSendKeys(content.getAddCourseTitle(), randomname);

		String id = DikshaUtils.generate_Do_id();
		excel.updateData("TestData", "Course", randomname, id);

		int scrollX = 0; // horizontal scroll amount
		int scrollY = 200; // vertical scroll amount
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
		DikshaUtils.waitToBeClickableAndClick(content.getCourseadditionalCategory());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectAdditionalCategory());
		DikshaUtils.waitToBeClickableAndClick(content.getCourseType());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType());
		DikshaUtils.waitToBeClickableAndClick(content.getSubjectCovered());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject());

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectBoardForcourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectBoardForcourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectBoard());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectMediumForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectMediumForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectMedium());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectClassForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectClassForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectclass());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectSubjectForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubjectForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject2());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSelectCopyRightYear(), "2023");

		js.executeScript("window.scrollTo(0, 0)");

		DikshaUtils.waitToBeClickableAndClick(content.getSaveAsDraft());
		Thread.sleep(5000);
		String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
		Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(content.getAddChild());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getChildDesc1(), "Created via Automation");
		DikshaUtils.waitToBeClickableAndClick(content.getAddFromLibraryButton());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), contentName);
		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(2000);
		String ContentsuccessfullyaddPopup = popup.getContentAddFromLibraryPopup().getText();
		Assert.assertEquals(ContentsuccessfullyaddPopup, "Content is added to the folder");
		Thread.sleep(2000);
		content.getSearchContentFromLibrary().clear();
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), "CourseAssessment_");

		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(2000);
		Assert.assertEquals(ContentsuccessfullyaddPopup, "Content is added to the folder");
		Thread.sleep(2000);
		content.getSearchContentFromLibrary().clear();
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), "Mp4_");

		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(2000);
		Assert.assertEquals(ContentsuccessfullyaddPopup, "Content is added to the folder");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());
		DikshaUtils.waitToBeClickableAndClick(content.getSubmitForreviewButton());
		DikshaUtils.waitToBeClickableAndClick(content.getTermsAndConditionCheckbox());
		DikshaUtils.waitToBeClickableAndClick(content.getNewCoursesubmitButton());
		Thread.sleep(2000);
		String ContentsendPopup = popup.getSendForReviewPopUp().getText();
		Assert.assertEquals(ContentsendPopup, "Content is sent for review");
		Thread.sleep(2000);

		return randomname;

	}

	public static String addCourseAssessmentInCourse(String contentName) throws Exception {

		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(content.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(content.getCoursetab());
		DikshaUtils.waitToBeClickableAndClick(content.getAddCourseTitle());
		content.getAddCourseTitle().clear();
		String randomname = DikshaUtils.set_Content_Name("Course_");
		DikshaUtils.waitToBeClickableAndSendKeys(content.getAddCourseTitle(), randomname);

		String id = DikshaUtils.generate_Do_id();
		excel.updateData("TestData", "Course", randomname, id);

		int scrollX = 0; // horizontal scroll amount
		int scrollY = 200; // vertical scroll amount
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
		DikshaUtils.waitToBeClickableAndClick(content.getCourseadditionalCategory());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectAdditionalCategory());
		DikshaUtils.waitToBeClickableAndClick(content.getCourseType());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType());
		DikshaUtils.waitToBeClickableAndClick(content.getSubjectCovered());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject());

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectBoardForcourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectBoardForcourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectBoard());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectMediumForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectMediumForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectMedium());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectClassForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectClassForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectclass());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectSubjectForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubjectForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject2());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSelectCopyRightYear(), "2023");

		js.executeScript("window.scrollTo(0, 0)");

		DikshaUtils.waitToBeClickableAndClick(content.getSaveAsDraft());
		Thread.sleep(5000);
		String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
		Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(content.getAddChild());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getChildDesc1(), "Created via Automation");
		DikshaUtils.waitToBeClickableAndClick(content.getAddFromLibraryButton());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), contentName);

		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(2000);
		String ContentsuccessfullyaddPopup = popup.getContentAddFromLibraryPopup().getText();
		Assert.assertEquals(ContentsuccessfullyaddPopup, "Content is added to the folder");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());
		DikshaUtils.waitToBeClickableAndClick(content.getSubmitForreviewButton());
		DikshaUtils.waitToBeClickableAndClick(content.getTermsAndConditionCheckbox());
		DikshaUtils.waitToBeClickableAndClick(content.getNewCoursesubmitButton());
		Thread.sleep(2000);
		String ContentsendPopup = popup.getSendForReviewPopUp().getText();
		Assert.assertEquals(ContentsendPopup, "Content is sent for review");
		Thread.sleep(2000);
		return randomname;

	}

	public static void CreateDiscussionFormForCourses() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());

		DikshaUtils.waitToBeClickableAndClick(content.getCreateDiscussionForum());
		DikshaUtils.waitToBeClickableAndClick(groups.getStartDiscussion());
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getDiscussionTopic(), "CrateDiscussionTopicForCourse");
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getDiscussionTopicDiscription(), "DiscussionTopicDiscription");
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getTagTopic(), "bookmark");
		groups.getTagTopic().sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionSubmitButton());
		Thread.sleep(2000);

		String ForumName = groups.getDiscussionTopicName().getText();
		Assert.assertEquals(ForumName, "CrateDiscussionTopicForCourse");
		Thread.sleep(1000);

		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);

	}

	public static void ValidateCourseBasedOnCBSC() throws Exception {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(home.getCourseTab());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(home.getHomeTab());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(home.getCourseTab());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(content.getSelectCBSCCourse());
		DikshaUtils.waitToBeVisibleAndClick(content.getCourseBackButton());
		Thread.sleep(1000);
		Assert.assertTrue(bmcpopup.getCbsc().isDisplayed());
		DikshaUtils.waitToBeVisibleAndClick(content.getCourseBackButton());
		Thread.sleep(1000);

	}

	public static void ValidateCourseBasedOnOther() throws Exception {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(home.getCourseTab());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(home.getHomeTab());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(home.getCourseTab());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(content.getSelectOtherCourse());
		Assert.assertTrue(bmcpopup.getOther().isDisplayed());
		DikshaUtils.waitToBeVisibleAndClick(content.getBackbutton());
		Thread.sleep(1000);

	}

	public static void UserAbleToSeeListOfAllPostInDiscussionForm() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);

		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		DikshaUtils.waitToBeClickableAndClick(groups.getCategories());
		Thread.sleep(1000);

		Assert.assertTrue(groups.getNoOfDiscussion().isDisplayed());
		Assert.assertTrue(groups.getNoOfPosts().isDisplayed());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(content.getbackbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(content.getbackbutton());
	}


	public static void UserAddPostInDiscussionForm() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);

		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());

		DikshaUtils.waitToBeClickableAndClick(content.getCreateDiscussionForum());
		DikshaUtils.waitToBeClickableAndClick(groups.getStartDiscussion());
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getDiscussionTopic(), "UserCrateDiscussionTopicForCourse");
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getDiscussionTopicDiscription(), "DiscussionTopicDiscription");

		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getDiscussionSubmitButton());
		Thread.sleep(2000);
		String ForumName = groups.getDiscussionTopicName().getText();
        Assert.assertEquals(ForumName, "UserCrateDiscussionTopicForCourse");
		Thread.sleep(1000);

		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(content.getbackbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(content.getbackbutton());

	}

	public static void ValidateDetailsInDiscussionForum() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);

		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyDiscussion());
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		Assert.assertTrue(groups.getProfileIcon().isDisplayed());
		Assert.assertTrue(groups.getUserName().isDisplayed());
		Assert.assertTrue(groups.getPostName().isDisplayed());
	}

	public static void UserAbleToReplyToAnyDiscussionTopic() throws Exception {
  	   
     	  Groups groups=PageFactory.initElements(driver, Groups.class);
     	   ValidatePopUp popup=PageFactory.initElements(driver, ValidatePopUp.class);
     	  CourseCreation content=PageFactory.initElements(driver, CourseCreation.class);
     		
  	    Thread.sleep(1000);
  	    DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
  	    Thread.sleep(1000);
  	    DikshaUtils.waitToBeClickableAndClick(content.getCreateDiscussionForum());
		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionTopicName());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getReplyToDiscussionTopic(),
				"Reply Successfully Send To Group Admin");
		DikshaUtils.waitToBeClickableAndClick(groups.getPostReply());
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");
		String ValidateReply = groups.getValidatePostReply().getText();
		Assert.assertEquals(ValidateReply, "Reply Successfully Send To Group Admin");
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(content.getbackbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(content.getbackbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(content.getbackbutton());

	}

	public static void UserAbleTOUpvotesToThePost() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());

		DikshaUtils.waitToBeClickableAndClick(content.getCreateDiscussionForum());
		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionTopicName());
		DikshaUtils.waitToBeClickableAndClick(groups.getUpvotedArrow());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getUpvotedCount().isDisplayed());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(content.getbackbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(content.getbackbutton());

	}

	public static void UserAbleTODownvotesToThePost() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());

		DikshaUtils.waitToBeClickableAndClick(content.getCreateDiscussionForum());
		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionTopicName());
		DikshaUtils.waitToBeClickableAndClick(groups.getDownvotedArrow());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getDownvotedCount().isDisplayed());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(content.getbackbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(content.getbackbutton());

	}

	public static void UserAbleToSeeCategoryDetailsInForum() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		DikshaUtils.waitToBeClickableAndClick(groups.getCategories());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getNoOfDiscussion().isDisplayed());
		Assert.assertTrue(groups.getNoOfPosts().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(groups.getbackbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getbackbutton());

	}

	public static void UserAbleToSeeTagList() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		DikshaUtils.waitToBeClickableAndClick(groups.getTags());
		Thread.sleep(1000);

		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		String Tagvalue = groups.getTagInput().getText();
		System.out.println(Tagvalue);
		Assert.assertEquals(Tagvalue, "bookmark");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getbackbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getbackbutton());

	}

	public static void UserAbleToSeeMyDiscussion() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyDiscussion());
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		Assert.assertTrue(groups.getDiscussionTopicName().isDisplayed());
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getbackbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getbackbutton());

	}


	public static void UserAbleTODeleteTheDiscussion() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());

		DikshaUtils.waitToBeClickableAndClick(content.getCreateDiscussionForum());
		DikshaUtils.waitToBeVisibleAndClick(groups.getDiscussionTopicName());
		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionTopicKababMenu());
		DikshaUtils.waitToBeClickableAndClick(groups.getDeleteTopic());

		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.switchTo().defaultContent();

	}

	public static String CreateCourseUsingTextbookAndSendForReview () throws Exception{
		 
		 CourseCreation content=PageFactory.initElements(driver, CourseCreation.class);
		 CreateBook create=PageFactory.initElements(driver, CreateBook.class);
		ValidatePopUp popup=PageFactory.initElements(driver, ValidatePopUp.class);
		
		String expect = "Creator should be able to add textbook from library and create course successfully";
		String actual = "Creator is unable to add textbook from library and create course ";
		String ContentsuccessfullyaddPopup=null;
	 try {
		    DikshaUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
		    DikshaUtils.waitToBeClickableAndClick(content.getWorkspace());
	        DikshaUtils.waitToBeClickableAndClick(content.getCoursetab());
			DikshaUtils.waitToBeClickableAndClick(content.getAddCourseTitle());
			content.getAddCourseTitle().clear();
			Thread.sleep(1000);
	        String randomname=DikshaUtils.set_Content_Name("CourseUsingTextbook_");
			content.getAddCourseTitle().sendKeys(randomname);
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			  js.executeScript("window.scrollBy(0, 700)");
			DikshaUtils.waitToBeClickableAndClick(content.getCourseType());
			DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(content.getSubjectCovered());
			DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject());
		 
			
			JavascriptExecutor js1=(JavascriptExecutor)driver;
	        js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectBoardForcourse());
			
	        DikshaUtils.waitToBeClickableAndClick(content.getSelectBoardForcourse());
			DikshaUtils.waitToBeClickableAndClick(content.getSelectBoard());
			
			js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectMediumForCourse());
			
			DikshaUtils.waitToBeClickableAndClick(content.getSelectMediumForCourse());
			DikshaUtils.waitToBeClickableAndClick(content.getSelectMedium());
			js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectClassForCourse());
			
			DikshaUtils.waitToBeClickableAndClick(content.getSelectClassForCourse());
			DikshaUtils.waitToBeClickableAndClick(content.getSelectclass());
			
			js1.executeScript("arguments[0].scrollIntoView(true);",content.getSelectSubjectForCourse());
			
			DikshaUtils.waitToBeClickableAndClick(content.getSelectSubjectForCourse());
			DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject2());
			
			Library.custom_sendkeys(content.getSelectCopyRightYear(),"2023","SelectCopyRightYear");
			Thread.sleep(1000);
			js.executeScript("window.scrollTo(0, 0)");
			DikshaUtils.waitToBeClickableAndClick(content.getSaveAsDraft());
			Thread.sleep(5000);
		     String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
		     Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
		     Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(content.getAddChild());
			DikshaUtils.waitToBeClickableAndClick(content.getChildDesc1());
			DikshaUtils.waitToBeClickableAndClick(content.getAddFromLibraryButton());
			
			DikshaUtils.waitToBeClickableAndClick(content.getSearchContentFromLibrary());
			content.getSearchContentFromLibrary().sendKeys("textbook");
			content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
			DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
			 Thread.sleep(2000);
		    ContentsuccessfullyaddPopup = popup.getContentAddFromLibraryPopup().getText();
		     Assert.assertEquals(ContentsuccessfullyaddPopup, "Content is added to the folder");
		     Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());
			DikshaUtils.waitToBeClickableAndClick(content.getSubmitForreviewButton());
			DikshaUtils.waitToBeVisibleAndClick(content.getTermsAndConditionCheckbox());
			DikshaUtils.waitToBeClickableAndClick(content.getNewCoursesubmitButton());
			 Thread.sleep(2000);
			ContentsuccessfullyaddPopup = popup.getSendForReviewPopUp().getText();
		     Thread.sleep(2000);
				actual="Creator is able to add content from library and create course successfully";
				
				return randomname;
			 } finally {
				 String Text = ContentsuccessfullyaddPopup!= null ? ContentsuccessfullyaddPopup : "N/A";
					Listeners.customAssert(ContentsuccessfullyaddPopup, Text, expect, actual);
			}
			
	   }

	public static String UploadContentsFromLibrary(String contentName, String contentName2) throws Exception {

		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		DikshaUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(content.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(content.getCoursetab());
		DikshaUtils.waitToBeClickableAndClick(content.getAddCourseTitle());
		content.getAddCourseTitle().clear();
		String randomname = DikshaUtils.set_Content_Name("Course_");
		DikshaUtils.waitToBeClickableAndSendKeys(content.getAddCourseTitle(), randomname);

		String id = DikshaUtils.generate_Do_id();
		excel.updateData("TestData", "Course", randomname, id);

		int scrollX = 0; // horizontal scroll amount
		int scrollY = 200; // vertical scroll amount
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
		DikshaUtils.waitToBeClickableAndClick(content.getCourseadditionalCategory());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectAdditionalCategory());
		DikshaUtils.waitToBeClickableAndClick(content.getCourseType());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType());
		DikshaUtils.waitToBeClickableAndClick(content.getSubjectCovered());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject());

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectBoardForcourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectBoardForcourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectBoard());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectMediumForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectMediumForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectMedium());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectClassForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectClassForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectclass());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectSubjectForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubjectForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject2());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSelectCopyRightYear(), "2023");

		js.executeScript("window.scrollTo(0, 0)");

		DikshaUtils.waitToBeClickableAndClick(content.getSaveAsDraft());
		Thread.sleep(5000);

		DikshaUtils.waitToBeClickableAndClick(content.getAddChild());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getChildDesc1(), "Created via Automation");
		DikshaUtils.waitToBeClickableAndClick(content.getAddFromLibraryButton());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), contentName);

		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());

		DikshaUtils.waitToBeClickableAndClick(content.getAddChild());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getChildDesc1(), "Created via Automation");
		DikshaUtils.waitToBeClickableAndClick(content.getAddFromLibraryButton());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(), contentName2);

		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());

		DikshaUtils.waitToBeClickableAndClick(content.getSubmitForreviewButton());
		Thread.sleep(5000);
		DikshaUtils.waitToBeClickableAndClick(content.getTermsAndConditionCheckbox());
		DikshaUtils.waitToBeClickableAndClick(content.getNewCoursesubmitButton());
		Thread.sleep(5000);
		Assert.assertTrue(loginpage.getHeaderDropdown().isDisplayed());

		return randomname;

	}

	public static String createCourseWithAssessment() throws Exception {

		CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(content.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(content.getCoursetab());
		DikshaUtils.waitToBeClickableAndClick(content.getAddCourseTitle());
		content.getAddCourseTitle().clear();
		String randomname = DikshaUtils.set_Content_Name("Course_");
		DikshaUtils.waitToBeClickableAndSendKeys(content.getAddCourseTitle(), randomname);

		String id = DikshaUtils.generate_Do_id();
		excel.updateData("TestData", "Course", randomname, id);

		int scrollX = 0; // horizontal scroll amount
		int scrollY = 200; // vertical scroll amount
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
		DikshaUtils.waitToBeClickableAndClick(content.getCourseadditionalCategory());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectAdditionalCategory());
		DikshaUtils.waitToBeClickableAndClick(content.getCourseType());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectcourseType());
		DikshaUtils.waitToBeClickableAndClick(content.getSubjectCovered());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject());

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectBoardForcourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectBoardForcourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectBoard());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectMediumForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectMediumForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectMedium());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectClassForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectClassForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectclass());

		js1.executeScript("arguments[0].scrollIntoView(true);", content.getSelectSubjectForCourse());

		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubjectForCourse());
		DikshaUtils.waitToBeClickableAndClick(content.getSelectSubject2());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSelectCopyRightYear(), "2023");

		js.executeScript("window.scrollTo(0, 0)");

		DikshaUtils.waitToBeClickableAndClick(content.getSaveAsDraft());
		Thread.sleep(5000);
		String ContentsuccessfullySavedPopup = popup.getSaveAsDraftPopUp().getText();
		Assert.assertEquals(ContentsuccessfullySavedPopup, "Content is saved");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(content.getAddChild());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getChildDesc1(), "Created via Automation");
		DikshaUtils.waitToBeClickableAndClick(content.getAddFromLibraryButton());
		DikshaUtils.waitToBeClickableAndSendKeys(content.getSearchContentFromLibrary(),
				excel.getContentName("AssesmentDoID"));

		content.getSearchContentFromLibrary().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(content.getSelectButton());
		DikshaUtils.waitToBeClickableAndClick(content.getAddContent());
		Thread.sleep(2000);
		String ContentsuccessfullyaddPopup = popup.getContentAddFromLibraryPopup().getText();
		Assert.assertEquals(ContentsuccessfullyaddPopup, "Content is added to the folder");
		Thread.sleep(2000);

		DikshaUtils.waitToBeClickableAndClick(content.getContentFromLibrayBackButton());
		DikshaUtils.waitToBeClickableAndClick(content.getSubmitForreviewButton());
		DikshaUtils.waitToBeClickableAndClick(content.getTermsAndConditionCheckbox());
		DikshaUtils.waitToBeClickableAndClick(content.getNewCoursesubmitButton());
		Thread.sleep(2000);
		String ContentsendPopup = popup.getSendForReviewPopUp().getText();
		Assert.assertEquals(ContentsendPopup, "Content is sent for review");
		Thread.sleep(2000);

		return randomname;

	}

}
