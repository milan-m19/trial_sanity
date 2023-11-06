package TPD;

import org.testng.annotations.Test;

import pageActions.AllMyContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateUserAbleToDeleteNotification extends BaseClass {

	@Test
	public void verifyUserAbleToDeleteNotification() throws Exception {
		
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Public User1");
		AllMyContentMethods.verifyUserAbleToDeleteNotification();
	}
	
	
}
