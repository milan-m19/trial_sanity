package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyAdminIsAbleToSeeEditGroupDetailsAndDeleteGroupOption extends BaseClass {

	@Test
	public void verifyAdminIsAbleToSeeEditGroupDetailsAndDeleteGroupOption() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToSeeEditGroupDetailsAndDeleteGroupOption();
	
	
	}  

}
