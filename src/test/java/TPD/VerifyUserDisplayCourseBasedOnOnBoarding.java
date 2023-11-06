package TPD;

import org.testng.annotations.Test;

import pageActions.Course_Creation;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyUserDisplayCourseBasedOnOnBoarding extends BaseClass {

	@Test
	public void verifyUserDisplayCourseBasedOnOnBoarding() throws Exception {
	
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		UserOnBoarding.ChangePreferenceAsCBSC();
		Course_Creation.ValidateCourseBasedOnCBSC();
		UserOnBoarding.ChangePreferenceAsOther();
		Course_Creation.ValidateCourseBasedOnOther();
	}

	
	
}
