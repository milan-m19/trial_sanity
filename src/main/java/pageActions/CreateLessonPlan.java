package pageActions;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageObject.LessonPlan;
import pageObject.UploadPdfContent;
import pageObject.ValidatePopUp;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.Library;
import utility.Listeners;

public class CreateLessonPlan extends BaseClass {

	public static String createLessonPlan() throws Exception {
		
		ValidatePopUp popup=PageFactory.initElements(driver, ValidatePopUp.class);
		LessonPlan lesson=PageFactory.initElements(driver, LessonPlan.class);
		String expect = "Creator should able to create lesson plan successfully";
		String actual = "Creator is unable to create lesson plan ";
		String ContentsuccessfullySavedPopup=null;
		try {
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(lesson.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(lesson.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(lesson.getLessonPlan());
		DikshaUtils.waitToBeClickableAndClick(lesson.getNameFeild());
		String name=DikshaUtils.set_Content_Name("LessonPlan_");
		lesson.getNameFeild().sendKeys(name);
		
		DikshaUtils.waitToBeClickableAndClick(lesson.getStartCreatingButton());
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(lesson.getNewChild());
		DikshaUtils.waitToBeClickableAndClick(lesson.getTitle());
		lesson.getTitle().clear();
		String tittle=DikshaUtils.set_Content_Name("LessonPlanTitle_");
		lesson.getTitle().sendKeys(tittle);
		DikshaUtils.waitToBeClickableAndClick(lesson.getAddResourceTab());
		Thread.sleep(1000);
		
		DikshaUtils.waitToBeClickableAndClick(lesson.getSelectResource());
		DikshaUtils.waitToBeVisibleAndClick(lesson.getProceedTab());
		DikshaUtils.waitToBeClickableAndClick(lesson.getSaveButton());
		Thread.sleep(4000);
		ContentsuccessfullySavedPopup = popup.getSaveLessonPlanPopUp().getText();
	     Assert.assertEquals(ContentsuccessfullySavedPopup, "Content saved successfully!");
	     Thread.sleep(1000);	
		 excel.updateData("TestData","LessonPlan" ,name, "");
		 actual="Creator is able to create lesson plan successfully";
			return name;
			
		 } finally {
			 String Text =popup.getSaveLessonPlanPopUp()!= null ? ContentsuccessfullySavedPopup : "N/A";
				Listeners.customAssert(ContentsuccessfullySavedPopup, Text, expect, actual);
		}
	}	
}