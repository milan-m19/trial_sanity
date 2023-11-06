package TPD;

import org.testng.annotations.Test;

import contentCreation.CreateCourseAndPublish;
import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class memberIsNotifiedWhenGroupIsAssignedActivityAndRemoveActivity extends BaseClass {

	@Test
	public void verifyWhenMemberLeavesGroupNotifiedToAdmin() throws Exception {
	
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("groupMember2");
		CreateGroups.copyUserId();
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("groupAdmin2");
		CreateGroups.adminAddedActivityToAssignedMemberAndRemove();
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("groupMember2");
		CreateGroups.validateActivityAddedToGroupNotifiedToMember();
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("groupAdmin2");
		CreateGroups.removeActivityfromExistingGroup();
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("groupMember2");
		CreateGroups.validateUnassignedActivityFromGroupNotifiedToMember();
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("groupAdmin2");
		CreateGroups.deleteCreatedGroup();
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("groupMember2");
		CreateGroups.validateDeleteGroupNotifiedToMember();
		UserOnBoarding.validatelogout();
		
	}
}