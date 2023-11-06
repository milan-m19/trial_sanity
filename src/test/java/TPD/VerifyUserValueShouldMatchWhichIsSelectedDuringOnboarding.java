package TPD;

import org.testng.annotations.Test;

import pageActions.Course_Creation;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyUserValueShouldMatchWhichIsSelectedDuringOnboarding extends BaseClass  {

	@Test
	public void verifyUserValueShouldMatchWhichIsSelectedDuringOnboarding() throws Exception {
		
	
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		UserOnBoarding.ValidateBMCFilterValueAsPerOnBoarding();
	}

}
