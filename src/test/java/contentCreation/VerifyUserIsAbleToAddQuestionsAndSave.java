package contentCreation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.ResourcesMethods;
import pageActions.UserOnBoarding;
import pageObject.ExplorePage;
import utility.BaseClass;


public class VerifyUserIsAbleToAddQuestionsAndSave extends BaseClass {
	@Test
	 public void verifyUserIsAbleBundleQuestionsAndSave() throws Exception {
    	
    	
    	UserOnBoarding.SelectUserRole("Student");
  		UserOnBoarding.bmcpopuphandle();
  		UserOnBoarding.locationpopuphandle();
  		UserOnBoarding.login("Creator");
 		ResourcesMethods.userIsAbleToBundleEditAddQuestionAndSave();
  	}
}




