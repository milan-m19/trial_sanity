package TPD;

import org.testng.annotations.Test;

import pageActions.Guest_User_Methods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidatePrimaryContentTypeFilter extends BaseClass{

	@Test
	public void verifyPrimaryContentTypeFilter() throws Exception {
		
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		Guest_User_Methods.verifyPrimaryContentFilter();
		
		
	}
}
