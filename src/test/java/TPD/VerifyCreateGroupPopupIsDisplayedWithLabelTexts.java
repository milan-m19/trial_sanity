package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyCreateGroupPopupIsDisplayedWithLabelTexts extends BaseClass {

	
	@Test
	public void verifyCreateGroupPopupIsDisplayedWithLabelTexts() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		CreateGroups.ValidateCreateGroupPopupWithLabelText();
	
	
	}  
}

