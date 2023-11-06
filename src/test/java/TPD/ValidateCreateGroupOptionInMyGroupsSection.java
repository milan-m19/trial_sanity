package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateCreateGroupOptionInMyGroupsSection extends BaseClass {

	@Test
	public void validateCreateGroupOptionInMyGroupsSection() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		CreateGroups.ValidateCreateGroupOption();
	
	
	}  

}
