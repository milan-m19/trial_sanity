package TPD;

import org.testng.annotations.Test;

import pageActions.AllMyContentMethods;
import pageActions.Course_Consumption;
import pageActions.Course_Creation;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateLearnerPassbookSectionForUser extends BaseClass {
	@Test
	public void VerifyLearnerPassbookSectionForUser() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Public User1");
		//AllMyContentMethods.VerifyLearnerPassbookSection();

	}
	
}
