package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyAssignedAdminAbleToLeaveGroup extends BaseClass {

	
	@Test
	public void verifyAssignedAdminAbleToLeaveGroup() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.UserAbleToAddMemberInGroup();
		CreateGroups.GroupAdminIsAbleToAssignMemberAsAdmin();
//		CreateGroups.GroupAdminAddMemberAndAssignMemberAsAdmin();
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		CreateGroups.UserAbleToSelectGroup();
		CreateGroups.AssignAdminAbleToLeaveTheGroup();
	
	  }   
 

  }
