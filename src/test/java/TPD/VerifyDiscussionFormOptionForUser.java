package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyDiscussionFormOptionForUser extends BaseClass {

	@Test
	public void verifyDiscussionFormOptionForUser() throws Exception {
		
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("New User");
		CreateGroups.UserIsAbleTOCreateNewGroupsAndVerify();
		UserOnBoarding.logout("New User");
		UserOnBoarding.login("Creator");
		CreateGroups.UserNotAbleToSeeDiscussionFormOption();
		UserOnBoarding.logout();
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToSelectEnableDiscussionOption();
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		CreateGroups.UserAbleToSeeDiscussionFormOption();
	}    

}
