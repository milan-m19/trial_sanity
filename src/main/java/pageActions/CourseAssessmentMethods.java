package pageActions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import pageObject.CourseAssesment;
import pageObject.ResourcesPom;
import pageObject.UploadPdfContent;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.Library;
import utility.Listeners;

public class CourseAssessmentMethods extends BaseClass {

	public static String createAssessmentWithAllTypeContent() throws InterruptedException, Exception {
		
		CourseAssesment assesment=PageFactory.initElements(driver, CourseAssesment.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		
		DikshaUtils.waitToBeClickableAndClick(Upload.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(Upload.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(assesment.getCourseAssesmentTab());
		String randomName=DikshaUtils.set_Content_Name("CourseAssessment_");
		excel.updateData("TestData","CourseAssessment" ,randomName, "");
		DikshaUtils.waitToBeClickableAndSendKeys(assesment.getNameTextField(), randomName);
		DikshaUtils.waitToBeClickableAndSendKeys(assesment.getMaxAttemptTextField(), "3");
		DikshaUtils.waitToBeVisibleAndClick(assesment.getStartCreatingButton());
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
	    
	    DikshaUtils.waitToBeClickableAndClick(assesment.getAddSlideButton());
	    DikshaUtils.waitToBeClickableAndClick(assesment.getAddActivityButton());
	    DikshaUtils.waitToBeClickableAndClick(assesment.getAddtimeAndClockButton());
	    
	    DikshaUtils.waitToBeClickableAndClick(Upload.getSave());
	    DikshaUtils.waitToBeClickableAndClick(Upload.getClose());
	   
	    return randomName;
	    
	}
	
	public static String createAssessmentWithQuestion() throws InterruptedException, Exception {
		ResourcesPom rs=PageFactory.initElements(driver, ResourcesPom.class);	
		CourseAssesment assesment=PageFactory.initElements(driver, CourseAssesment.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		
		String expect = "Creator should able to create course assessment successfully";
		String actual = "Creator is unable to create course assessment ";
		String closeButton=null;
	 
	 try {
		DikshaUtils.waitToBeClickableAndClick(Upload.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(Upload.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(assesment.getCourseAssesmentTab());
		String randomName=DikshaUtils.set_Content_Name("CourseAssessment_");
		excel.updateData("TestData","CourseAssessment" ,randomName, "");
		DikshaUtils.waitToBeClickableAndSendKeys(assesment.getNameTextField(), randomName);
		DikshaUtils.waitToBeClickableAndSendKeys(assesment.getMaxAttemptTextField(), "3");
		DikshaUtils.waitToBeVisibleAndClick(assesment.getStartCreatingButton());
		Thread.sleep(8000);
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		DikshaUtils.waitToBeClickableAndClick(assesment.getAddQuestionSetButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(rs.getCreateQuestionButton());
		Thread.sleep(1000);
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
	  
	    DikshaUtils.waitToBeClickableAndClick(Upload.getSave());
	    DikshaUtils.waitToBeClickableAndClick(Upload.getClose());
	    closeButton=Upload.getClose().getText();
	    actual="Creator is able to create course assessment successfully";
		return randomName;
		
	 } finally {
		 String Text = Upload.getClose() != null ? closeButton : "N/A";
			Listeners.customAssert(closeButton, Text, expect, actual);
	}
	} 
	}