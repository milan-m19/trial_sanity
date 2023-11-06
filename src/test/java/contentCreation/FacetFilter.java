package contentCreation;

import org.testng.annotations.Test;


import pageActions.Guest_User_Methods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class FacetFilter extends BaseClass {

	@Test
	public void VerifyFiltersResetToProfileBMCValueswhenNavigatedToOtherTab() throws Exception {
		
		String userRole =UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("New User");
		Guest_User_Methods.VerifyProfileBMCValueForAnotherTab();
	
	
	}
	
}