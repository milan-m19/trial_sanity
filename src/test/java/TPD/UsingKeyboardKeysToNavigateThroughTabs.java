package TPD;

import org.testng.annotations.Test;

import pageActions.CertificateCreation;
import pageActions.Course_Creation;
import pageActions.Guest_User_Methods;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class UsingKeyboardKeysToNavigateThroughTabs extends BaseClass {

	@Test
	public void verifyKeyboardActionsForTabs() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		Guest_User_Methods.validateKeyboardActions();
		
			
		
	}
	
	
}
