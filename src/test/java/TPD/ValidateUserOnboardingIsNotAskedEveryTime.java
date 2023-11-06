package TPD;

import org.testng.annotations.Test;

import pageActions.Guest_User_Methods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateUserOnboardingIsNotAskedEveryTime extends BaseClass {
	@Test
	public void VerifyUserOnboardingIsNotAskedEveryTime() throws Exception {
		
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Minor");
		Guest_User_Methods.validateBMCForMinor();
		UserOnBoarding.logout();
		UserOnBoarding.login("Minor");
		Guest_User_Methods.validateBMCForMinor();
	}
}