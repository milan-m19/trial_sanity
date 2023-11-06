package TPD;

import org.testng.annotations.Test;

import pageActions.AllMyContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateNotificationBellForGuestAndCustodianUser extends BaseClass {

	@Test
	public void verifyNotificationBellForGuestAndCustodianUser() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		//AllMyContentMethods.verifyNotificationForGuestUser();
		UserOnBoarding.login("Public User1");
		AllMyContentMethods.verifyUserSeeNotificationInBellIcon();
	}
	
}
