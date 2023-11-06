package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyGroupAdminAbleToEnableDiscussionFormThenGroupMemberAbleToOpenDiscussion extends BaseClass {

	@Test
	public void verifyGroupAdminAbleToEnableDiscussionFormThenGroupMemberAbleToOpenDiscussion() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.UserAbleToAddMemberInGroup();
		CreateGroups.SelectEnableDiscussionOption();
		UserOnBoarding.logout();
		UserOnBoarding.login("New User1");
		CreateGroups.UserAbleToSelectDiscussionFormOption();
		
	} 

}
