package TPD;

import org.testng.annotations.Test;

import pageActions.AllMyContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateUserAbleToClearAllNotification extends BaseClass {

	@Test
	public void verifyUserAbleToClearAllNotification() throws Exception {
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Public User1");
		AllMyContentMethods.verifyUserAbleToClearAllNotification();
	}
	
	
}
