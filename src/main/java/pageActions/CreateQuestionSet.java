package pageActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import pageObject.Filter;
import pageObject.QuestionSet;
import pageObject.ValidatePopUp;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.Listeners;

public class CreateQuestionSet extends BaseClass {

	public static String CreateTwoTypesOfQuestionSetAndSendForReview() throws Exception {

		QuestionSet Que = PageFactory.initElements(driver, QuestionSet.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Creator should be able to create two types of questions in question set successfully";
		String actual = "Creator is unable to create two types of questions in question set";
		String ContentsuccessfullyaddPopup = null;
		try {
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(Que.getHeaderDropdown());
			DikshaUtils.waitToBeClickableAndClick(Que.getWorkspace());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 900)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(Que.getQuestionSetTab());
			Thread.sleep(1000);

			DikshaUtils.waitToBeClickableAndClick(Que.getQuestionSetName());
			Que.getQuestionSetName().clear();
			String name = DikshaUtils.set_Content_Name("QuestionSet_");
			Que.getQuestionSetName().sendKeys(name);

			String doid = DikshaUtils.generate_Do_id();
			excel.updateData("TestData", "QuestionSet", name, doid);

			DikshaUtils.waitToBeClickableAndClick(Que.getDescriptionTab());
			DikshaUtils.waitToBeClickableAndSendKeys(Que.getDescriptionTab(), "DescriptionTab");

			Thread.sleep(1000);
			// js.executeScript("arguments[0].scrollIntoView(true);",Que.getInstructionsTab());
			js.executeScript("window.scrollBy(0, 600)");
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(Que.getInstructionsTab());
			// DikshaUtils.waitToBeClickableAndSendKeys(Que.getQuestionSetName(),"InstructionsTab");
			Que.getInstructionsTab().sendKeys("InstructionsTab");

			Thread.sleep(2000);
			DikshaUtils.waitToBeVisibleAndClick(Que.getSelectBoardSyllabus());
			DikshaUtils.waitToBeClickableAndClick(Que.getBoardSelected());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(Que.getSelectMedium());
			DikshaUtils.waitToBeClickableAndClick(Que.getMediumSelected());
			DikshaUtils.waitToBeClickableAndClick(Que.getSelectClass());
			DikshaUtils.waitToBeClickableAndClick(Que.getClassSelected());
			DikshaUtils.waitToBeClickableAndClick(Que.getSelectSubject());
			DikshaUtils.waitToBeClickableAndClick(Que.getSubjectSelected());

			js.executeScript("window.scrollBy(0, 900)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(Que.getSelectAudience());
			DikshaUtils.waitToBeClickableAndClick(Que.getAudienceSelected());

			js.executeScript("window.scrollTo(0, 0)");
			DikshaUtils.waitToBeClickableAndClick(Que.getSaveAsDraft());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(Que.getaddChild());

			DikshaUtils.waitToBeVisibleAndClick(Que.getChildTitle());
			DikshaUtils.waitToBeVisibleAndSendKeys(Que.getChildTitle(), "FirstTitleName");
			DikshaUtils.waitToBeClickableAndClick(Que.getChildDescription());
			DikshaUtils.waitToBeVisibleAndSendKeys(Que.getChildDescription(), "Description");
			DikshaUtils.waitToBeClickableAndClick(Que.getCreateButton());
			DikshaUtils.waitToBeClickableAndClick(Que.getSelectMCQ());
			DikshaUtils.waitToBeClickableAndClick(Que.getNextButton());
			Thread.sleep(1000);

			DikshaUtils.waitToBeClickableAndClick(Que.getEnterQue());
			DikshaUtils.waitToBeVisibleAndSendKeys(Que.getEnterQue(), "What is the Capital of India");
			DikshaUtils.waitToBeClickableAndClick(Que.getEnterOptionFirst());
			DikshaUtils.waitToBeVisibleAndSendKeys(Que.getEnterOptionFirst(), "Mumbai");
			DikshaUtils.waitToBeClickableAndClick(Que.getEnterOptionSecond());
			DikshaUtils.waitToBeVisibleAndSendKeys(Que.getEnterOptionSecond(), "Delhi");
			DikshaUtils.waitToBeClickableAndClick(Que.getCorrectAns());

			js.executeScript("window.scrollBy(0,900)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(Que.getQueDetailTitle());
			DikshaUtils.waitToBeVisibleAndSendKeys(Que.getQueDetailTitle(), "Done");
			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(Que.getSaveButton());

			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(Que.getaddChild());

			DikshaUtils.waitToBeVisibleAndClick(Que.getChildTitle());
			DikshaUtils.waitToBeVisibleAndSendKeys(Que.getChildTitle(), "SecondTitleName");
			DikshaUtils.waitToBeClickableAndClick(Que.getChildDescription());
			DikshaUtils.waitToBeVisibleAndSendKeys(Que.getChildDescription(), "Description");
			DikshaUtils.waitToBeClickableAndClick(Que.getCreateButton());
			DikshaUtils.waitToBeClickableAndClick(Que.getSelectSubjectiveQue());
			DikshaUtils.waitToBeClickableAndClick(Que.getNextButton());
			Thread.sleep(1000);

			DikshaUtils.waitToBeClickableAndClick(Que.getEnterQue());
			DikshaUtils.waitToBeVisibleAndSendKeys(Que.getEnterQue(), "What is the Colour of Rose");
			DikshaUtils.waitToBeClickableAndClick(Que.getEnterOptionFirst());
			DikshaUtils.waitToBeVisibleAndSendKeys(Que.getEnterOptionFirst(), "Red");

			js.executeScript("window.scrollBy(0,900)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(Que.getQueDetailTitle());
			DikshaUtils.waitToBeVisibleAndSendKeys(Que.getQueDetailTitle(), "Done");
			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(Que.getSaveButton());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(Que.getsubmitForreviewButton());
			DikshaUtils.waitToBeClickableAndClick(Que.gettermsAndConditionCheckbox());
			DikshaUtils.waitToBeClickableAndClick(Que.getsubmitButton());
			Thread.sleep(2000);
			ContentsuccessfullyaddPopup = popup.getSendForReviewPopUp().getText();
			Thread.sleep(2000);
			actual = "Creator is able to create two types of questions in question set successfully";

			return doid;
		} finally {
			String Text = ContentsuccessfullyaddPopup != null ? ContentsuccessfullyaddPopup : "N/A";
			Listeners.customAssert(ContentsuccessfullyaddPopup, Text, expect, actual);

		}
	}


	public static String CreateQuestionSetAndSendForReview() throws Exception  {
		
		QuestionSet Que=PageFactory.initElements(driver, QuestionSet.class);
	
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(Que.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(Que.getWorkspace());
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 900)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(Que.getQuestionSetTab());
		Thread.sleep(1000);
		
		DikshaUtils.waitToBeClickableAndClick(Que.getQuestionSetName());
		Que.getQuestionSetName().clear();
		String name=DikshaUtils.set_Content_Name("QuestionSet_");
		Que.getQuestionSetName().sendKeys(name);
		
		String doid= DikshaUtils.generate_Do_id();
		excel.updateData("TestData","QuestionSet" ,name, doid);
		
		DikshaUtils.waitToBeClickableAndClick(Que.getDescriptionTab());
		DikshaUtils.waitToBeClickableAndSendKeys(Que.getDescriptionTab(),"DescriptionTab");
		
		Thread.sleep(1000);
		//js.executeScript("arguments[0].scrollIntoView(true);",Que.getInstructionsTab());
		js.executeScript("window.scrollBy(0, 600)");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(Que.getInstructionsTab());
	//  DikshaUtils.waitToBeClickableAndSendKeys(Que.getQuestionSetName(),"InstructionsTab");
		Que.getInstructionsTab().sendKeys("InstructionsTab");
	
		 Thread.sleep(2000);
		 DikshaUtils.waitToBeVisibleAndClick(Que.getSelectBoardSyllabus());
		 DikshaUtils.waitToBeClickableAndClick(Que.getBoardSelected());
		 Thread.sleep(1000);
	     DikshaUtils.waitToBeClickableAndClick(Que.getSelectMedium());
		 DikshaUtils.waitToBeClickableAndClick(Que.getMediumSelected());
		 DikshaUtils.waitToBeClickableAndClick(Que.getSelectClass());
		 DikshaUtils.waitToBeClickableAndClick(Que.getClassSelected());
		 DikshaUtils.waitToBeClickableAndClick(Que.getSelectSubject());
		 DikshaUtils.waitToBeClickableAndClick(Que.getSubjectSelected());
		
		 js.executeScript("window.scrollBy(0, 900)");
		 Thread.sleep(1000);
		 DikshaUtils.waitToBeClickableAndClick(Que.getSelectAudience());
		 DikshaUtils.waitToBeClickableAndClick(Que.getAudienceSelected());  
		 Thread.sleep(1000);
		 js.executeScript("window.scrollBy(0, 1100)");
		 Thread.sleep(1000);
		 DikshaUtils.waitToBeClickableAndClick(Que.getMaxAttempt());
		 DikshaUtils.waitToBeClickableAndClick(Que.getSelectMaxAttempt());  
		
		 
		 js.executeScript("window.scrollTo(0, 0)");
		 DikshaUtils.waitToBeClickableAndClick(Que.getSaveAsDraft());
		 Thread.sleep(1000);
	     DikshaUtils.waitToBeClickableAndClick(Que.getaddChild());
	     
	     DikshaUtils.waitToBeVisibleAndClick(Que.getChildTitle());
	     DikshaUtils.waitToBeVisibleAndSendKeys(Que.getChildTitle(),"FirstTitleName");
		 DikshaUtils.waitToBeClickableAndClick(Que.getChildDescription());
		 DikshaUtils.waitToBeVisibleAndSendKeys(Que.getChildDescription(),"Description");
		 DikshaUtils.waitToBeClickableAndClick(Que.getCreateButton());
		 DikshaUtils.waitToBeClickableAndClick(Que.getSelectMCQ());
		 DikshaUtils.waitToBeClickableAndClick(Que.getNextButton());
		 Thread.sleep(1000);
		 
		 DikshaUtils.waitToBeClickableAndClick(Que.getEnterQue());
		 DikshaUtils.waitToBeVisibleAndSendKeys(Que.getEnterQue(),"What is the Capital of India");
		 DikshaUtils.waitToBeClickableAndClick(Que.getEnterOptionFirst());
		 DikshaUtils.waitToBeVisibleAndSendKeys(Que.getEnterOptionFirst(),"Mumbai");
		 DikshaUtils.waitToBeClickableAndClick(Que.getEnterOptionSecond());
		 DikshaUtils.waitToBeVisibleAndSendKeys(Que.getEnterOptionSecond(),"Delhi");
		 DikshaUtils.waitToBeClickableAndClick(Que.getCorrectAns());  
	     
		 js.executeScript("window.scrollBy(0,900)");
		 Thread.sleep(1000);
		 DikshaUtils.waitToBeClickableAndClick(Que.getQueDetailTitle()); 
		 DikshaUtils.waitToBeVisibleAndSendKeys(Que.getQueDetailTitle(),"Done");
		 js.executeScript("window.scrollTo(0, 0)");
		 Thread.sleep(1000);
		 DikshaUtils.waitToBeClickableAndClick(Que.getSaveButton()); 
		 
		 Thread.sleep(1000);
		 DikshaUtils.waitToBeClickableAndClick(Que.getsubmitForreviewButton());
		 DikshaUtils.waitToBeClickableAndClick(Que.gettermsAndConditionCheckbox());
		 DikshaUtils.waitToBeClickableAndClick(Que.getsubmitButton());
		 Thread.sleep(6000);
		
		 
		 
		  
		
		  return doid;
	}

}
	
	
