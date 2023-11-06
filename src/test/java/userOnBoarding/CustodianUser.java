package userOnBoarding;

import org.testng.annotations.Test;

import pageActions.Observation;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class CustodianUser extends BaseClass {

	// dependency on functional team new user is required
	 @Test
	public void VerifyCustodianUsersAreGettingSubmitDetailsOptionInHisProfile() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("New User");
		UserOnBoarding.VerifyTheUserShouldBeAbleToEditTheSubmittedDetailsOptionInProfile();
		UserOnBoarding.logout();
		UserOnBoarding.login("AddUserCred");
		UserOnBoarding.VerifyUserShouldBeAbleToEditTheSubmittedDetails();

	}

	// @Test
	// Application issue:- not able to select BMC value in one click
	public void VerifyTheUserIsAbleToUpdateTheBMCAndLocationDetails() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("New User");
		UserOnBoarding.VerifyTheUserIsAbleToUpdateTheBMCAndLocationDetails();
	}

	@Test
	public void VerifyUserSelectsHTAndOfficialRoleUserIsGettingObservationTab() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("New User");
		UserOnBoarding.validateObservationTab();
		Observation.SelectRoleAsTeacher();

	}

	// dependency on functional team new user is required
	// @Test
	public void VerifyUserAddMUAUserAndAbletoSwtichTheAccount() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("AddUserCred");
		UserOnBoarding.CustodianUserIsAableToAddTheMUAUser();

	}
}
