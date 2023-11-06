package TPD;

import org.testng.annotations.Test;

import contentCreation.CreateCourseAndPublish;
import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class groupMemberNotifiedWhenAddedByAdminAndgroupAdminNotifiedWhenMemberLeaves extends BaseClass {

	@Test
	public void verifyWhenMemberLeavesGroupNotifiedToAdmin() throws Exception {
	
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("groupMember2");
		CreateGroups.copyUserId();
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("groupAdmin2");
		CreateGroups.UserIsAbleTOCreateNewGroupsAndVerifyAndMembers();
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("groupMember2");
		CreateGroups.validateMemberAddedToGroupNotification();
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("groupAdmin2");
		CreateGroups.removeMemberfromExistingGroup();
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("groupMember2");
		CreateGroups.validateMemberRemovednotification();
		UserOnBoarding.validatelogout();
	}
}