package pageActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageObject.CourseConsumption;
import pageObject.Logout;
import pageObject.QuestionsetConsumption;
import utility.BaseClass;
import utility.DikshaUtils;

public class QuestionSet_Consumption extends BaseClass {

	public static void consumeQuestionSet() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		QuestionsetConsumption Qs=PageFactory.initElements(driver, QuestionsetConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		CourseConsumption cc=PageFactory.initElements(driver, CourseConsumption.class);
		
		Thread.sleep(2000);
		

		DikshaUtils.waitToBeVisibleAndClick(cc.getStartLearning());
		
		DikshaUtils.waitToBeVisibleAndClick(Qs.getNextSlideButton());
		DikshaUtils.waitToBeVisibleAndClick(Qs.getNextSlideButton());
//		Thread.sleep(2000);
//	    DikshaUtils.waitToBeVisibleAndClick(Qs.getSelectAns());
	    Thread.sleep(1000);
	    DikshaUtils.waitToBeVisibleAndClick(Qs.getNextSlideButton());
	    Thread.sleep(1000);
	    DikshaUtils.waitToBeVisibleAndClick(cc.getCloseRatingPopup());
	    DikshaUtils.waitToBeVisibleAndClick(cc.getCloseCongratulations());
	    DikshaUtils.waitToBeVisibleAndClick(Qs.getReplayButton());
	    Thread.sleep(1000);
	    JavascriptExecutor js1=(JavascriptExecutor)driver;
	     js1.executeScript("window.scrollTo(0, 0)");
	     Thread.sleep(1000);
	    DikshaUtils.waitToBeVisibleAndClick(Qs.getNextSlideButton());
		DikshaUtils.waitToBeVisibleAndClick(Qs.getNextSlideButton()); 
//		Thread.sleep(2000);
//		DikshaUtils.waitToBeVisibleAndClick(Qs.getSelectAns());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(Qs.getNextSlideButton());
	    Thread.sleep(1000);
	    DikshaUtils.waitToBeVisibleAndClick(Qs.getMaxExceedCloseButton());
	    DikshaUtils.waitToBeVisibleAndClick(cc.getContinueLearning());
	    Thread.sleep(1000);
	    Assert.assertTrue(Qs.getMaxExceedCloseButton().isDisplayed());
	    DikshaUtils.waitToBeVisibleAndClick(Qs.getMaxExceedCloseButton());
	    
	}

}
