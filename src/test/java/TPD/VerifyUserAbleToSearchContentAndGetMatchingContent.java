package TPD;

import org.testng.annotations.Test;

import pageActions.TPDMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyUserAbleToSearchContentAndGetMatchingContent extends BaseClass {

	@Test
	public void verifyUserAbleToSearchContentAndGetMatchingContent() throws Exception {
	
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User"); 
		TPDMethods.ValidateUserbleToSearchAndGetMatchingContent();
     
	
	   }

	}