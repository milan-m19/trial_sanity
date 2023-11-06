package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.TPDMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyUserAbleToSeeMyGroupsOption extends BaseClass {

	@Test
	public void verifyUserAbleToSeeMyGroupsOption() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		CreateGroups.GuestUserAbleTOSeeMyGroupsOption();
		UserOnBoarding.login("New User");
		CreateGroups.UserAbleTOSeeMyGroupsOption();
	
	
	} 
	
}
