package pageActions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.google.common.io.Resources;
import pageObject.CourseAssesment;
import pageObject.ResourcesPom;
import pageObject.UploadPdfContent;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.Listeners;

public class ResourcesMethods extends BaseClass {
public static String resourceWithECMLContent() throws Exception {
		
		String close = null;
		String expect = "Creator should be able create Resource With ECML Content Successfully";
		String actual = "Creator is unable to create Resource With ECML Content";
		try {
			
		ResourcesPom rs=PageFactory.initElements(driver, ResourcesPom.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		CourseAssesment assesment=PageFactory.initElements(driver, CourseAssesment.class);
		
		DikshaUtils.waitToBeClickableAndClick(Upload.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(Upload.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(rs.getResourceTab());
		Thread.sleep(5000);
		
		String randomName=DikshaUtils.set_Content_Name("TvLessonResource_");
		excel.updateData("TestData","TvLessonResource" ,randomName, "");
		
		DikshaUtils.waitToBeClickableAndSendKeys(rs.getResourceNameTextfield(),randomName);
		DikshaUtils.waitToBeClickableAndClick(rs.getSelectContentType());
		DikshaUtils.waitToBeClickableAndClick(rs.getContentTypeSelected());
		DikshaUtils.waitToBeClickableAndClick(rs.getStartCreatingButton());
		Thread.sleep(8000);
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		
		DikshaUtils.waitToBeClickableAndClick(assesment.getAddTextbutton());
		DikshaUtils.waitToBeVisibleAndClick(assesment.getAddTextbutton());
		DikshaUtils.waitToBeClickableAndSendKeys(assesment.getTextareaTextfield(), "Done Via Automation");
		DikshaUtils.waitToBeClickableAndClick(assesment.getDonebutton());
		
		DikshaUtils.waitToBeClickableAndClick(assesment.getAddSlideButton());
		DikshaUtils.waitToBeClickableAndClick(assesment.getAddShapebutton());
		DikshaUtils.waitToBeClickableAndClick(assesment.getAddingTriangleShape());
		
		DikshaUtils.waitToBeClickableAndClick(assesment.getAddSlideButton());
		DikshaUtils.waitToBeClickableAndClick(assesment.getAddVideoButton());
		DikshaUtils.waitToBeClickableAndClick(assesment.getselectVideoFromVideoList());
		DikshaUtils.waitToBeClickableAndClick(assesment.getSelectvideoButton());
		
		DikshaUtils.waitToBeClickableAndClick(assesment.getAddSlideButton());
		DikshaUtils.waitToBeClickableAndClick(assesment.getAddImagebutton());
		DikshaUtils.waitToBeClickableAndClick(Upload.getClickOnAllImage());
	    DikshaUtils.waitToBeClickableAndClick(Upload.getSelectImageFromAllImage());
	    DikshaUtils.waitToBeClickableAndClick(Upload.getSelectButton());
	    
	    DikshaUtils.waitToBeClickableAndClick(assesment.getAddSlideButton());
	    DikshaUtils.waitToBeClickableAndClick(assesment.getAddaudiobutton());
	    DikshaUtils.waitToBeClickableAndClick(assesment.getAllAudiobutton());
	    DikshaUtils.waitToBeClickableAndClick(assesment.getSelectaudiofromlist());
	    DikshaUtils.waitToBeClickableAndClick(assesment.getSelectaudioButton());
	    
	    DikshaUtils.waitToBeClickableAndClick(assesment.getAddSlideButton());
	    DikshaUtils.waitToBeClickableAndClick(assesment.getAddQuestionSetButton());
	    DikshaUtils.waitToBeClickableAndClick(assesment.getSelectQuestionCheckBox1());
	    DikshaUtils.waitToBeClickableAndClick(assesment.getNextButton());
	    DikshaUtils.waitToBeClickableAndSendKeys(assesment.getQuestionSetTitleTextfield(),"QA Questions");
	    DikshaUtils.waitToBeClickableAndClick(assesment.getAddButton());
	    DikshaUtils.waitToBeClickableAndClick(Upload.getSave());
	    Thread.sleep(2000);
	    close = Upload.getClose().getText();
	    DikshaUtils.waitToBeClickableAndClick(Upload.getClose());
	    
	    actual = "Creator is able create Resource With ECML Content Successfully";
	    return randomName;
		}finally {
			
			String closeText = close != null ? close : "N/A";
			Listeners.customAssert("Close", closeText, expect, actual);
		}
		
		
	}
	
	
	public static String resourceWithTVLesson() throws Exception {
		
		
		ResourcesPom rs=PageFactory.initElements(driver, ResourcesPom.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		CourseAssesment assesment=PageFactory.initElements(driver, CourseAssesment.class);
		
		String close = null;
		String expect = "Creator should be able create Resource With TV Lesson Successfully";
		String actual = "Creator is unable to create Resource With TV Lesson Content";
		try {
		
		DikshaUtils.waitToBeClickableAndClick(Upload.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(Upload.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(rs.getResourceTab());
		
		String randomName=DikshaUtils.set_Content_Name("Tv_Lesson_");
		
		
		DikshaUtils.waitToBeClickableAndSendKeys(rs.getResourceNameTextfield(),randomName);
		DikshaUtils.waitToBeClickableAndClick(rs.getSelectContentType());
		DikshaUtils.waitToBeVisibleAndClick(rs.getContentTypeSelected());
		DikshaUtils.waitToBeClickableAndClick(rs.getStartCreatingButton());
		Thread.sleep(8000);
		String id=DikshaUtils.generate_Do_id();
		excel.updateData("TestData","TvLesson" ,randomName, id);
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		DikshaUtils.waitToBeClickableAndClick(assesment.getAddVideoButton());
		DikshaUtils.waitToBeClickableAndClick(assesment.getselectVideoFromVideoList());
		DikshaUtils.waitToBeClickableAndClick(assesment.getSelectvideoButton());
	    DikshaUtils.waitToBeClickableAndClick(Upload.getSave());
	    Thread.sleep(2000);
	    close = Upload.getClose().getText();
	    DikshaUtils.waitToBeClickableAndClick(Upload.getClose());
	    actual = "Creator is able create Resource With TV Lesson Successfully";
	   
	    return randomName;
		}finally {
			String closeText = close != null ? close : "N/A";
			Listeners.customAssert("Close", closeText, expect, actual);
		}
		
	}
	
		public static String createAndEditQuestionsInQuestionSet() throws Exception {
		
		ResourcesPom rs=PageFactory.initElements(driver, ResourcesPom.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		CourseAssesment assesment=PageFactory.initElements(driver, CourseAssesment.class);
		
		String close = null;
		String expect = "Creator should be able to edit question set in Resource Successfully";
		String actual = "Creator is unable to edit question set in Resource";
		try {
		DikshaUtils.waitToBeClickableAndClick(Upload.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(Upload.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(rs.getResourceTab());
		
		String randomName=DikshaUtils.set_Content_Name("Resource_");
		excel.updateData("TestData","Resource" ,randomName, "");
		
		DikshaUtils.waitToBeClickableAndSendKeys(rs.getResourceNameTextfield(),randomName);
		DikshaUtils.waitToBeClickableAndClick(rs.getSelectContentType());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(rs.getContentTypeSelected());
		DikshaUtils.waitToBeClickableAndClick(rs.getStartCreatingButton());
		Thread.sleep(8000);
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		
		DikshaUtils.waitToBeClickableAndClick(assesment.getAddQuestionSetButton());
		DikshaUtils.waitToBeClickableAndClick(rs.getCreateQuestionButton());
		DikshaUtils.waitToBeClickableAndClick(rs.getSelectMCQButton());
		Thread.sleep(2000);
		WebElement iframe1 = driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor')]"));
		driver.switchTo().frame(iframe1);
	
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(rs.getEnterTheQuestionTextfield());
		DikshaUtils.waitToBeClickableAndSendKeys(rs.getEnterTheQuestionTextfield(),"Capital of India");
	
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		WebElement iframe2 = driver.findElement(By.xpath("//iframe[@class='iziModal-iframe']"));
		driver.switchTo().frame(iframe2);
		
		
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", rs.getTickCorrectAnswer());
		
		
		DikshaUtils.waitToBeClickableAndClick(rs.getTickCorrectAnswer());
		
		DikshaUtils.waitToBeClickableAndClick(rs.getAnswerNo1Textfield());
		DikshaUtils.waitToBeClickableAndSendKeys(rs.getAnswerNo1Textfield(),"Delhi");
		
		DikshaUtils.waitToBeClickableAndClick(rs.getAnswerNo2Textfield());
		DikshaUtils.waitToBeClickableAndSendKeys(rs.getAnswerNo2Textfield(),"Mumbai");
		DikshaUtils.waitToBeClickableAndClick(rs.getNextButton());
	
		DikshaUtils.waitToBeClickableAndClick(rs.getSelectBoardSyllabus());
		DikshaUtils.waitToBeClickableAndClick(rs.getBoardSelected());
		DikshaUtils.waitToBeClickableAndClick(rs.getSelectMedium());
		DikshaUtils.waitToBeClickableAndClick(rs.getMediumSelected());
		DikshaUtils.waitToBeClickableAndClick(rs.getSelectGrade());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(rs.getGradeSelected());
		DikshaUtils.waitToBeClickableAndClick(rs.getSelectSubject());
		DikshaUtils.waitToBeClickableAndClick(rs.getSubjectSelected());
		DikshaUtils.waitToBeClickableAndClick(rs.getSelectLevel());
		DikshaUtils.waitToBeClickableAndClick(rs.getLevelSelected());
		DikshaUtils.waitToBeClickableAndClick(rs.getSaveAndCreateButton());
		DikshaUtils.waitToBeClickableAndClick(rs.getCancelButton());
		DikshaUtils.waitToBeClickableAndClick(rs.getNextButtonAfterClickingCheckbox());
		
		DikshaUtils.waitToBeClickableAndSendKeys(assesment.getQuestionSetTitleTextfield(),"QA Questions");
	    DikshaUtils.waitToBeClickableAndClick(assesment.getAddButton());
//	    Thread.sleep(2000);
//	    driver.switchTo().frame(iframe);
//	    Thread.sleep(2000);
	    
	    DikshaUtils.waitToBeClickableAndClick(rs.getEditQuestionSetButton());
		Thread.sleep(1000);
	    DikshaUtils.waitToBeClickableAndClick(rs.getEditQuestionButton());
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView(true);", rs.getAddAnswerButton());
		DikshaUtils.waitToBeClickableAndClick(rs.getAddAnswerButton());
		DikshaUtils.waitToBeClickableAndClick(rs.getAnswerNo3Textfield());
		DikshaUtils.waitToBeClickableAndSendKeys(rs.getAnswerNo3Textfield(),"Bangalore");
		DikshaUtils.waitToBeClickableAndClick(rs.getNextButton());
	
		DikshaUtils.waitToBeClickableAndClick(rs.getSaveAndCreateButton());
		DikshaUtils.waitToBeClickableAndClick(rs.getCancelButton());
		DikshaUtils.waitToBeClickableAndClick(rs.getCrossIcon());
		DikshaUtils.waitToBeClickableAndClick(Upload.getSave());
		Thread.sleep(2000);
	    close = Upload.getClose().getText();
	    DikshaUtils.waitToBeClickableAndClick(Upload.getClose());
	    actual = "Creator is able to edit question set in Resource  Successfully";
	   
	
		return randomName;
		}finally {
			String closeText = close != null ? close : "N/A";
			Listeners.customAssert("Close", closeText, expect, actual);
		}
}
		
		public static String shuffleAndCopyQuestionsInQuestionSet() throws Exception {
			
			ResourcesPom rs=PageFactory.initElements(driver, ResourcesPom.class);
			UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
			CourseAssesment assesment=PageFactory.initElements(driver, CourseAssesment.class);
			
			String close = null;
			String expect = "Creator should be able to shuffle and copy questions in question set Resource Successfully";
			String actual = "Creator is unable to shuffle and copy questions in question set Resource";
			try {
			DikshaUtils.waitToBeClickableAndClick(Upload.getHeaderDropdown());
			DikshaUtils.waitToBeClickableAndClick(Upload.getWorkspace());
			DikshaUtils.waitToBeClickableAndClick(rs.getResourceTab());
			
			String randomName=DikshaUtils.set_Content_Name("Resource_");
		//	excel.updateData("TestData","Resource" ,randomName, "");
			
			DikshaUtils.waitToBeClickableAndSendKeys(rs.getResourceNameTextfield(),randomName);
			DikshaUtils.waitToBeClickableAndClick(rs.getSelectContentType());
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(rs.getContentTypeSelected());
			DikshaUtils.waitToBeClickableAndClick(rs.getStartCreatingButton());
			Thread.sleep(8000);
			WebElement iframe = driver.findElement(By.tagName("iframe"));
			driver.switchTo().frame(iframe);
			
			DikshaUtils.waitToBeClickableAndClick(assesment.getAddQuestionSetButton());
			DikshaUtils.waitToBeClickableAndClick(rs.getCopyQuestionButton());
			Thread.sleep(5000);
			DikshaUtils.waitToBeClickableAndClick(rs.getNextButton());
			
			DikshaUtils.waitToBeClickableAndClick(rs.getSelectBoardSyllabus());
			DikshaUtils.waitToBeClickableAndClick(rs.getBoardSelected());
			DikshaUtils.waitToBeClickableAndClick(rs.getSelectMedium());
			DikshaUtils.waitToBeClickableAndClick(rs.getMediumSelected());
			DikshaUtils.waitToBeClickableAndClick(rs.getSelectGrade());
			DikshaUtils.waitToBeClickableAndClick(rs.getGradeSelected());
			DikshaUtils.waitToBeClickableAndClick(rs.getSelectSubject());
			DikshaUtils.waitToBeClickableAndClick(rs.getSubjectSelected());
			
			DikshaUtils.waitToBeClickableAndClick(rs.getSubmitButton());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(assesment.getSelectQuestionCheckBox2());
			DikshaUtils.waitToBeClickableAndClick(assesment.getNextButton());
			DikshaUtils.waitToBeClickableAndSendKeys(assesment.getQuestionSetTitleTextfield(),"QA Questions");
			Thread.sleep(3000);
	//		DikshaUtils.waitToBeClickableAndClick(rs.getShuffleQuestionsButton());
		    DikshaUtils.waitToBeClickableAndClick(assesment.getAddButton());
		    DikshaUtils.waitToBeClickableAndClick(Upload.getSave());
		    Thread.sleep(2000);
		    close = Upload.getClose().getText();
		    DikshaUtils.waitToBeClickableAndClick(Upload.getClose());
		    actual = "Creator is able to shuffle and copy questions in question set Resource  Successfully";
		   
		
			return randomName;
			}finally {
				String closeText = close != null ? close : "N/A";
				Listeners.customAssert("Close", closeText, expect, actual);
			}
			
		}
		


	public static void userIsAbleToBundleEditAddQuestionAndSave() throws IOException, InterruptedException {


		String text= null;
	    String expect = "Creator Should Be able to add bundle questions, edit and save questions successfully";
	    String actual = "Creator is unable to add bundle questions, edit and save questions";
	    try {
//		ResourcesPom rs = PageFactory.initElements(driver, ResourcesPom.class);
//		UploadPdfContent Upload = PageFactory.initElements(driver, UploadPdfContent.class);
//		CourseAssesment assesment = PageFactory.initElements(driver, CourseAssesment.class);
//
//		DikshaUtils.waitToBeClickableAndClick(Upload.getHeaderDropdown());
//		DikshaUtils.waitToBeClickableAndClick(Upload.getWorkspace());
//		DikshaUtils.waitToBeClickableAndClick(rs.getResourceTab());
//
//		String randomName = DikshaUtils.set_Content_Name("Resource_");
//		String randomName1 = DikshaUtils.set_Content_Name("Question-");
//		excel.updateData("TestData", "Resource", randomName, "");
//
//		DikshaUtils.waitToBeClickableAndSendKeys(rs.getResourceNameTextfield(), randomName);
//		DikshaUtils.waitToBeClickableAndClick(rs.getSelectContentType());
//		Thread.sleep(1000);
//		DikshaUtils.waitToBeVisibleAndClick(rs.getContentTypeSelected());
//		DikshaUtils.waitToBeClickableAndClick(rs.getStartCreatingButton());
//		Thread.sleep(8000);
//		WebElement iframe = driver.findElement(By.tagName("iframe"));
//		driver.switchTo().frame(iframe);
//		DikshaUtils.waitToBeClickableAndClick(rs.getaddQuestionSet());
//
//		DikshaUtils.waitToBeClickableAndClick(rs.getselectQuestion1());
//
//		DikshaUtils.waitToBeClickableAndClick(rs.getselectQuestion2());
//
//		DikshaUtils.waitToBeClickableAndClick(rs.getselectQuestion3());
//
//		DikshaUtils.waitToBeClickableAndClick(rs.getNextButtonAfterClickingCheckbox());
//		Thread.sleep(2000);
//		DikshaUtils.waitToBeClickableAndSendKeys(rs.getenterQuestionSetName(), randomName1);
//
//		DikshaUtils.waitToBeClickableAndClick(rs.getbtnAdd());
//
//		DikshaUtils.waitToBeClickableAndClick(assesment.getAddQuestionSetButton());
//		DikshaUtils.waitToBeClickableAndClick(rs.getCopyQuestionButton());
//		Thread.sleep(5000);
//		DikshaUtils.waitToBeClickableAndClick(rs.getNextButton());
//
//		DikshaUtils.waitToBeClickableAndClick(rs.getSelectBoardSyllabus());
//		DikshaUtils.waitToBeClickableAndClick(rs.getBoardSelected());
//		DikshaUtils.waitToBeClickableAndClick(rs.getSelectMedium());
//		DikshaUtils.waitToBeClickableAndClick(rs.getMediumSelected());
//		DikshaUtils.waitToBeClickableAndClick(rs.getSelectGrade());
//		DikshaUtils.waitToBeClickableAndClick(rs.getGradeSelected());
//		DikshaUtils.waitToBeClickableAndClick(rs.getSelectSubject());
//		DikshaUtils.waitToBeClickableAndClick(rs.getSubjectSelected());
//		Thread.sleep(2000);
//		DikshaUtils.waitToBeClickableAndClick(rs.getSubmitButton());
//		Thread.sleep(2000);
//		DikshaUtils.waitToBeClickableAndClick(rs.getSubmitButton());
//		Thread.sleep(2000);
//		DikshaUtils.waitToBeClickableAndClick(assesment.getSelectQuestionCheckBox2());
//		DikshaUtils.waitToBeClickableAndClick(assesment.getNextButton());
//		DikshaUtils.waitToBeClickableAndSendKeys(assesment.getQuestionSetTitleTextfield(), "QA Questions");
//		Thread.sleep(3000);
//
//		DikshaUtils.waitToBeClickableAndClick(assesment.getAddButton());
//		DikshaUtils.waitToBeClickableAndClick(Upload.getSave());
//		DikshaUtils.waitToBeClickableAndClick(Upload.getClose());
//
//		DikshaUtils.waitToBeClickableAndClick(assesment.getAddQuestionSetButton());
//		DikshaUtils.waitToBeClickableAndClick(rs.getCreateQuestionButton());
//		DikshaUtils.waitToBeClickableAndClick(rs.getSelectMCQButton());
//		Thread.sleep(2000);
//		WebElement iframe1 = driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor')]"));
//		driver.switchTo().frame(iframe1);
//
//		Thread.sleep(2000);
//		DikshaUtils.waitToBeClickableAndClick(rs.getEnterTheQuestionTextfield());
//		DikshaUtils.waitToBeClickableAndSendKeys(rs.getEnterTheQuestionTextfield(), "Capital of India");
//
//		driver.switchTo().defaultContent();
//		Thread.sleep(1000);
//		WebElement iframe2 = driver.findElement(By.xpath("//iframe[@class='iziModal-iframe']"));
//		driver.switchTo().frame(iframe2);
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", rs.getTickCorrectAnswer());
//
//		DikshaUtils.waitToBeClickableAndClick(rs.getTickCorrectAnswer());
//
//		DikshaUtils.waitToBeClickableAndClick(rs.getAnswerNo1Textfield());
//		DikshaUtils.waitToBeClickableAndSendKeys(rs.getAnswerNo1Textfield(), "Delhi");
//
//		DikshaUtils.waitToBeClickableAndClick(rs.getAnswerNo2Textfield());
//		DikshaUtils.waitToBeClickableAndSendKeys(rs.getAnswerNo2Textfield(), "Mumbai");
//		DikshaUtils.waitToBeClickableAndClick(rs.getNextButton());
//
//		DikshaUtils.waitToBeClickableAndClick(rs.getSelectBoardSyllabus());
//		DikshaUtils.waitToBeClickableAndClick(rs.getBoardSelected());
//		DikshaUtils.waitToBeClickableAndClick(rs.getSelectMedium());
//		DikshaUtils.waitToBeClickableAndClick(rs.getMediumSelected());
//		DikshaUtils.waitToBeClickableAndClick(rs.getSelectGrade());
//		DikshaUtils.waitToBeClickableAndClick(rs.getGradeSelected());
//		DikshaUtils.waitToBeClickableAndClick(rs.getSelectSubject());
//		DikshaUtils.waitToBeClickableAndClick(rs.getSubjectSelected());
//		DikshaUtils.waitToBeClickableAndClick(rs.getSelectLevel());
//		DikshaUtils.waitToBeClickableAndClick(rs.getLevelSelected());
//		DikshaUtils.waitToBeClickableAndClick(rs.getSaveAndCreateButton());
//		DikshaUtils.waitToBeClickableAndClick(rs.getCancelButton());
//		DikshaUtils.waitToBeClickableAndClick(rs.getselectQuestion1());
//		DikshaUtils.waitToBeClickableAndClick(rs.getNextButtonAfterClickingCheckbox());
//
//		DikshaUtils.waitToBeClickableAndSendKeys(assesment.getQuestionSetTitleTextfield(), "QA Questions");
//		DikshaUtils.waitToBeClickableAndClick(assesment.getAddButton());
//
//		DikshaUtils.waitToBeClickableAndClick(Upload.getSave());
//		DikshaUtils.waitToBeClickableAndClick(Upload.getClose());
//
//		DikshaUtils.waitToBeClickableAndClick(assesment.getAddQuestionSetButton());
//
//		DikshaUtils.waitToBeClickableAndClick(rs.getclkDeleteQuetion());
//		DikshaUtils.waitToBeClickableAndClick(rs.getclkConfirmDelete());
//
//		DikshaUtils.waitToBeClickableAndClick(rs.getclkDeleteQuetion());
//		DikshaUtils.waitToBeClickableAndClick(rs.getclkConfirmDelete());
//
//		DikshaUtils.waitToBeClickableAndClick(rs.getclkDeleteQuetion());
//		DikshaUtils.waitToBeClickableAndClick(rs.getclkConfirmDelete());
//		
//		Deletion = driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
//        Thread.sleep(2000);
//        
//        actual = "User Is Able Delete Questions ";
	    	
	    	ResourcesPom rs = PageFactory.initElements(driver, ResourcesPom.class);
			UploadPdfContent Upload = PageFactory.initElements(driver, UploadPdfContent.class);
			CourseAssesment assesment = PageFactory.initElements(driver, CourseAssesment.class);

			DikshaUtils.waitToBeClickableAndClick(Upload.getHeaderDropdown());
			DikshaUtils.waitToBeClickableAndClick(Upload.getWorkspace());
			DikshaUtils.waitToBeClickableAndClick(rs.getResourceTab());

			String randomName = DikshaUtils.set_Content_Name("Resource_");
			String randomName1 = DikshaUtils.set_Content_Name("Question-");
			excel.updateData("TestData", "Resource", randomName, "");

			DikshaUtils.waitToBeClickableAndSendKeys(rs.getResourceNameTextfield(), randomName);
			DikshaUtils.waitToBeClickableAndClick(rs.getSelectContentType());
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(rs.getContentTypeSelected());
			DikshaUtils.waitToBeClickableAndClick(rs.getStartCreatingButton());
			Thread.sleep(8000);
			WebElement iframe = driver.findElement(By.tagName("iframe"));
			driver.switchTo().frame(iframe);
			DikshaUtils.waitToBeClickableAndClick(rs.getaddQuestionSet());

			DikshaUtils.waitToBeClickableAndClick(rs.getselectQuestion1());

			DikshaUtils.waitToBeClickableAndClick(rs.getselectQuestion2());

			DikshaUtils.waitToBeClickableAndClick(rs.getselectQuestion3());

			DikshaUtils.waitToBeClickableAndClick(rs.getNextButtonAfterClickingCheckbox());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndSendKeys(rs.getenterQuestionSetName(), randomName1);

			DikshaUtils.waitToBeClickableAndClick(rs.getbtnAdd());

			DikshaUtils.waitToBeClickableAndClick(assesment.getAddQuestionSetButton());
			DikshaUtils.waitToBeClickableAndClick(rs.getCopyQuestionButton());
			Thread.sleep(5000);
			DikshaUtils.waitToBeClickableAndClick(rs.getNextButton1());

//			DikshaUtils.waitToBeClickableAndClick(rs.getSelectBoardSyllabus());
//			DikshaUtils.waitToBeClickableAndClick(rs.getBoardSelected());
//			DikshaUtils.waitToBeClickableAndClick(rs.getSelectMedium());
//			DikshaUtils.waitToBeClickableAndClick(rs.getMediumSelected());
//			DikshaUtils.waitToBeClickableAndClick(rs.getSelectGrade());
//			DikshaUtils.waitToBeClickableAndClick(rs.getGradeSelected());
//			DikshaUtils.waitToBeClickableAndClick(rs.getSelectSubject());
//			DikshaUtils.waitToBeClickableAndClick(rs.getSubjectSelected());
//			Thread.sleep(2000);
//			DikshaUtils.waitToBeClickableAndClick(rs.getSubmitButton());
//			Thread.sleep(2000);
//			DikshaUtils.waitToBeClickableAndClick(rs.getSubmitButton());
//			Thread.sleep(2000);
//			DikshaUtils.waitToBeClickableAndClick(assesment.getSelectQuestionCheckBox2());
//			DikshaUtils.waitToBeClickableAndClick(assesment.getNextButton());
			
			Thread.sleep(3000);
			DikshaUtils.waitToBeClickableAndSendKeys(assesment.getQuestionSetTitleTextfield(), "QA Questions");
			Thread.sleep(3000);

			DikshaUtils.waitToBeClickableAndClick(assesment.getAddButton());
			DikshaUtils.waitToBeClickableAndClick(Upload.getSave());
			DikshaUtils.waitToBeClickableAndClick(Upload.getClose());
			
			text=Upload.getClose().getText();
			actual="Creator is able to add bundle questions, edit and save questions successfully";
	    }
	    finally {
	    	String DeletionText = text != null ? text : "N/A";
	        Listeners.customAssert(text, DeletionText, expect, actual);
	    }
	}
}