package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyAdminAbleToAddAndRemoveMemberFromGroup extends BaseClass {

	@Test
	public void verifyAdminAbleToAddAndRemoveMemberFromGroup() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.UserAbleToAddMemberInGroup();
		CreateGroups.removeMemberfromExistingGroup();
		
	//	CreateGroups.AdminAbleToAddAndRemoveMemberFromGroup();
		
	
	
	}  

}
