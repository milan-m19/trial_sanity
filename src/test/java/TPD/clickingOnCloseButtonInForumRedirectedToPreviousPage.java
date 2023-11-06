package TPD;

import org.testng.annotations.Test;

import contentCreation.CreateCourseAndPublish;
import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class clickingOnCloseButtonInForumRedirectedToPreviousPage extends BaseClass {

	@Test
	public void verifyWhenMemberLeavesGroupNotifiedToAdmin() throws Exception {
	
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("groupAdmin2");
		CreateGroups.VerifyUserDisplayedEnableDiscussionsOption();
		UserOnBoarding.validatelogout();
//		UserOnBoarding.login("groupAdmin2");
//		CreateGroups.nonAdminAbleToSearchMember();
//		UserOnBoarding.validatelogout();
//		UserOnBoarding.login("groupMember2");
//		CreateGroups.validateMembersSideGroupNotoficationWhenMemberAddedByadmin();
//		UserOnBoarding.validatelogout();
//		UserOnBoarding.login("groupAdmin2");
//		CreateGroups.validateAdminSideGroupNotoficationWhenMemberLeaves();
//		UserOnBoarding.validatelogout();
	}
}