package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyGroupAdminAndAssignedAdminAbleToEditGroupDetails extends BaseClass {

	
	@Test
	public void verifyGroupAdminAndAssignedAdminAbleToEditGroupDetails() throws Exception {
		
		String userRole =UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("New User");
	    String Groupname=CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.AdminAbleToEditTheGroupDetails(Groupname);
		CreateGroups.UserAbleToAddMemberInGroup();
		CreateGroups.GroupAdminIsAbleToAssignMemberAsAdmin();
//		CreateGroups.GroupAdminAddMemberAndAssignMemberAsAdmin();
		UserOnBoarding.logout("New User");
		UserOnBoarding.login("Creator");
		CreateGroups.AssignMemberAsAdminIsAbleToEditGroupDetails();
	
	}  

}
