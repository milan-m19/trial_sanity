package TPD;

import org.testng.annotations.Test;

import pageActions.Guest_User_Methods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateContentDisplayAsPerUserOnBoardingDetails extends BaseClass{
	@Test
	public void VerifyContentDisplayAsPerUserOnBoardingDetails() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Minor");
		Guest_User_Methods.VerifyContentDisplayAsPerUserOnBoardingDetails();
		
	}
	
	
	
}
