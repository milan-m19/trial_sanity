package Groups;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyGroupAdminIsAbleToEditAndDelete extends BaseClass {
	@Test
	public void GroupAdminAbleToEditAndDelete() throws Exception {

		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("GroupAdmin");
		CreateGroups.enableTheDiscussionForumOnCreatedCourse();
		CreateGroups.createDiscussionForExistingGroup();
		CreateGroups.DisableDiscussionForum();
	}
}