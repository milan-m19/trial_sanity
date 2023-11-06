package userOnBoarding;

import org.testng.annotations.Test;

import pageActions.Guest_User_Methods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class Guest_User extends BaseClass {

	 @Test
	public void verifyBMC_and_LocationPopUp_In_Profile_Section() throws Exception {

		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandleWithGuestName();
		Guest_User_Methods.validateLocationAndBMC();

	}

	 @Test
	public void verifyBMCS_Values_In_Diffrent_Tabs() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		Guest_User_Methods.validateBMCSForDiffrentTabs();

	}

	@Test
	public void verifyDiffrentSectionsInHomeTab() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		Guest_User_Methods.validateDiffrentSectionsUnderHomeTab();
		UserOnBoarding.login("New User");
		Guest_User_Methods.validateDiffrentSectionsUnderHomeTab();
	}

	@Test
	public void VerifyIfTheGuestUserEditBMCValuesAndSave() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.Verify_Guest_user_is_able_to_edit_BMC_Values();

	}

}
