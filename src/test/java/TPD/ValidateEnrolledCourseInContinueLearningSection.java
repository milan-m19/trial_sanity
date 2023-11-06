package TPD;

import org.testng.annotations.Test;

import pageActions.Guest_User_Methods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateEnrolledCourseInContinueLearningSection extends BaseClass {

	@Test
	public void verifyEnrolledCourseInContinueLearningSection() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Public User1");
		Guest_User_Methods.validateCourseUnderContinueLearning();
		
		
	}
	
}
