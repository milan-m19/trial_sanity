package TPD;

import org.testng.annotations.Test;

import pageActions.Guest_User_Methods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateAdditionalAndPrimaryContentTypeFilter extends BaseClass{

	@Test
	public void verifyAdditionalAndPrimaryContentTypeFilter () throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		Guest_User_Methods.verifyAdditionalAndPrimaryContentTypeFilter();
		
		
	}
}
