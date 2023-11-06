package TPD;

import org.testng.annotations.Test;

import pageActions.AllMyContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

	public class ValidateSeeMoreOptionInNotification extends BaseClass{

	@Test
	public void verifySeeMoreOptionInNotification() throws Exception {
		
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Public User1");
		AllMyContentMethods.verifySeeMoreOptionInNotification();
	}
	
}
