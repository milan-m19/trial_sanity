package TPD;

import org.testng.annotations.Test;

import contentCreation.CreateCourseAndPublish;
import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class verifyCreateGroupsAndaddActivityValidateViewDashBoard extends BaseClass {


	@Test
	public void verifyGroupAdminAbleToValidateActivityDashBoard() throws Exception {
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("groupAdmin2");
		CreateGroups.validateActivityDashboardInAddActivity();
		UserOnBoarding.validatelogout();
	}
//
//	@Test
//	public void validatfilterByOption() throws Exception {
//		UserOnBoarding.studenticon();
//		UserOnBoarding.bmcpopuphandle();
//		UserOnBoarding.locationpopuphandle();
//		UserOnBoarding.login("groupAdmin1");
//		CreateGroups.verifyFlterByOption();
//	}
//
//	@Test
//	public void validateCloseButtonInSearchMemberEntryBox() throws Exception {
//		UserOnBoarding.studenticon();
//		UserOnBoarding.bmcpopuphandle();
//		UserOnBoarding.locationpopuphandle();
//		UserOnBoarding.login("groupAdmin1");
//		CreateGroups.validateCloseButtonInSearchMemberEntryBox("My group");
//	}
//	
//	
//
//	@Test
//	public void editAndUpdateGroupdetailPage() throws Exception {
//		UserOnBoarding.studenticon();
//		UserOnBoarding.bmcpopuphandle();
//		UserOnBoarding.locationpopuphandle();
//		UserOnBoarding.login("groupAdmin1");
//		CreateGroups.validateUpdateGroupButtonInsteadOfSubmitButton("groupEdited", "groupDesc");
//	}
//	
//	@Test
//	public void validateGroupInactiveMessage() throws Exception {
//		UserOnBoarding.studenticon();
//		UserOnBoarding.bmcpopuphandle();
//		UserOnBoarding.locationpopuphandle();
//		UserOnBoarding.login("groupAdmin1");
//		CreateGroups.validateDeactivateGroup();
//		UserOnBoarding.validatelogout();
//		UserOnBoarding.login("groupMember2");
//		CreateGroups.validateMemberDeactivateGroupMessage();
//		UserOnBoarding.validatelogout();
//		UserOnBoarding.login("groupAdmin1");
//		CreateGroups.validateReactivateGroup();
//		UserOnBoarding.validatelogout();
//	}
//	
	

//	@Test
//	public void deleteGroup() throws Exception {
//		UserOnBoarding.studenticon();
//		UserOnBoarding.bmcpopuphandle();
//		UserOnBoarding.locationpopuphandle();
//		UserOnBoarding.login("groupAdmin1");
//		CreateGroups.deleteCreatedGroup();
//	}
}