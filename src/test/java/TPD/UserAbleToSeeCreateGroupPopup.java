package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class UserAbleToSeeCreateGroupPopup extends BaseClass {

	@Test
	public void userAbleToSeeCreateGroupPopup() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		
	//	CreateGroups.ValidateCreateGroupsPopup();;
	
	
	} 
	

}
