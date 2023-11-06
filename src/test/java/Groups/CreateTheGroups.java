package Groups;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class CreateTheGroups extends BaseClass {

	@Test
	public void VerifyUserIsAbleToCreateNewGroups() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.AdminAddActivityAsCourse();
		CreateGroups.UserAbleToAddMemberInGroup();
		CreateGroups.AdminAbleToDeleteTheGroup();

	}

	@Test
	public void VerifyUserDisplayedWithEnableDiscussionsOption() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.AdminAbleToSelectEnableDiscussionOption();
		CreateGroups.ValidateFieldInsideTheDiscussionsOption();

	}

	@Test
	public void VerifyUserDisplayedwithDisableDiscussionsOption() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.AdminAbleToSelectEnableDiscussionOption();
		CreateGroups.SelectDisabledDiscussionOption();
		CreateGroups.ValidateDiscussionFormOptionIsDisabled();

		// CreateGroups.VerifyUserDisplayedDisableDiscussionsOption();

	}

	@Test
	public void VerifyCloseOptionDisplayedAfterOpenDiscussionForumOption() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.UserAbleToAddMemberInGroup();
		CreateGroups.AdminAbleToSelectEnableDiscussionOption();
		UserOnBoarding.logout("New User");
		UserOnBoarding.login("Creator");
		CreateGroups.UserAbleToSelectGroup();
		CreateGroups.VerifyCloseOptionIsDisplayedInDiscussionForum();

		// CreateGroups.VerifyCloseOptionIsDisplayed();
	}
}
