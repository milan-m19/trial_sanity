package TPD;

import org.testng.annotations.Test;

import pageActions.Guest_User_Methods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class bmcSelectedDuringOnboardingIsSameAsHomeTabInChangePreference extends BaseClass {

	@Test
	public void VerifyFiltersResetToProfileBMCValueswhenNavigatedToOtherTab() throws Exception {

		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Public User1");
		Guest_User_Methods.vlidateChangePreference();
	}
}