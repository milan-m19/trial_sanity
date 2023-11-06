package TPD;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import pageObject.Groups;
import utility.BaseClass;
import utility.DikshaUtils;

public class GroupDiscussionForum extends BaseClass {
	@Test(enabled = false)
	public void verifyUpdatedPostIsDisplayedInDiscussionForumPostUpdatingSuccessfully() throws Exception {
	
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("GroupAdmin");
		CreateGroups.enableTheDiscussionForumOnCreatedCourse();
		CreateGroups.createDiscussionForExistingGroup();
		CreateGroups.DisableDiscussionForum();
	}

	@Test(enabled = false)
	public void createAndDeactivateGroup() throws Exception {

		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Public User2");
		// CreateGroups.createANewGroup();
		CreateGroups.DeactivateGroup();
	}

	@Test(enabled = false)
	public void verifyDeletedTopicMustBeRemovedFromTheDF() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("GroupAdmin");
		CreateGroups.enableTheDiscussionForumOnCreatedCourse();
		CreateGroups.verifDeletedTopicMustBeRemovedFromDF();
		CreateGroups.DisableDiscussionForum();
	}

	@Test(enabled = false)
	public static void verifyNamesOfAllTheGroupMembersAreDisplayed() throws Exception {
	
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("GroupAdmin");
		CreateGroups.openGroupAndVerifyMembersOfGroup();

	}

	@Test(enabled = false)
	public static void verifyGroupAdminIsAbleToClickOnTheViewActivityDashboard() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("GroupAdmin");
		CreateGroups.verifyViewDashBoardIsClickable();

	}

	@Test
	public static void verifyFTUEPopupRegardingGroupCreationShouldBeDisplayedPostClickingInformationIcon()
			throws Exception {
	
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("GroupAdmin");
		CreateGroups.verifyFTUEPopupOnGroupCreation();
	}

}