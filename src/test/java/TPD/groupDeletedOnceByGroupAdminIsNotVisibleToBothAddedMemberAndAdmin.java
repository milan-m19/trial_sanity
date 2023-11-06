package TPD;

import org.testng.annotations.Test;

import contentCreation.CreateCourseAndPublish;
import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class groupDeletedOnceByGroupAdminIsNotVisibleToBothAddedMemberAndAdmin extends BaseClass {

	@Test
	public void verifyWhenMemberLeavesGroupNotifiedToAdmin() throws Exception {
	
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("groupMember2");
		CreateGroups.copyUserId();
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("groupAdmin2");
		String deleteGroup = CreateGroups.nonAdminAbleToSearchMember();
		CreateGroups.deleteCreatedGroupWithoutCrossTab();
		CreateGroups.validateAfterDeletingAdminGroup(deleteGroup);
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("groupMember2");
		CreateGroups.validateAfterDeletingAdminGroup(deleteGroup);
		UserOnBoarding.validatelogout();
	}
}