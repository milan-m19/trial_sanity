package TPD;

import org.testng.annotations.Test;


import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateBMCPreference extends BaseClass {

	@Test
	public void verifyBMCPreferenceUnderHomeTab() throws Exception {
	
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.VerifyBMCUnderChangePreference();
		
	
	
	
}
}