package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class verifyLoadingAnimationMustBeShownOnTheseScreens extends BaseClass {
	@Test
	public void GroupAdminAbleToEditAndDelete() throws Exception {
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("GroupAdmin");
		// CreateGroups.enableTheDiscussionForumOnCreatedCourse();
		CreateGroups.createDiscussionForExistingGroupAndLoadingPage();
		CreateGroups.DisableDiscussionForum();
	}
}