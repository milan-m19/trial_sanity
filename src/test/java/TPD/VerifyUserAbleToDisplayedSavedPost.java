package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyUserAbleToDisplayedSavedPost extends BaseClass {

	@Test
	public void verifyUserAbleToDisplayedSavedPost() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.UserAbleToAddMemberInGroup();
		CreateGroups.SelectEnableDiscussionOption();
		CreateGroups.CreateDiscussionFormForGroup();
		UserOnBoarding.logout();
		UserOnBoarding.login("New User1");
		CreateGroups.UserAbleToSelectGroup();
		CreateGroups.UserAbleToSaveThePosts();
		CreateGroups.UserAbleToSeeSavedPosts();
			
	}      

}
