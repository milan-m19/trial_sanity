package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyAdminAbleToAddAndRemoveTheActivityInTheGroup extends BaseClass {

	@Test
	public void verifyAdminAbleToAddAndRemoveTheActivityInTheGroup() throws Exception {
		
		String userRole=UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.AdminAddActivityInTheGroup();
		CreateGroups.AdminRemoveActivityFromGroup();
		
		
	//	CreateGroups.AdminAddAndRemoveActivityFromGroup();;
	
	
	} 

}
