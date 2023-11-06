package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateGroupNameErrorForMissingfield extends BaseClass{

	
	@Test
	public void verifyGroupNameErrorForMissingfield() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Public User1");
		//CreateGroups.verifyGroupNameErrorForMissingfield();
			
	}
	
	
}
