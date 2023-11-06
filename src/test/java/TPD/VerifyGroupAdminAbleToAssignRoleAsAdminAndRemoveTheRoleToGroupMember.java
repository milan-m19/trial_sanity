package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyGroupAdminAbleToAssignRoleAsAdminAndRemoveTheRoleToGroupMember extends BaseClass {

	
	@Test
	public void verifyGroupAdminAbleToAssignRoleAsAdminAndRemoveTheRoleToGroupMember() throws Exception {
		
		String userRole =UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.UserAbleToAddMemberInGroup();
		CreateGroups.GroupAdminIsAbleToAssignMemberAsAdmin();
		CreateGroups.RemoveTheRoleAsAdminFromAssignedAdmin();
		
	
//		CreateGroups.GroupAdminAddMemberAndAssignMemberAsAdmin();
		
		
	
	
	}   

}
