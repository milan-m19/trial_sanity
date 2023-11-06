package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyAssignedAdminNotAbleToDeleteTheGroup extends BaseClass {

	@Test
	public void verifyAssignedAdminNotAbleToDeleteTheGroup() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.GroupAdminAddMemberAndAssignMemberAsAdmin();
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		CreateGroups.UserAbleToSelectGroup();
		CreateGroups.AssignAdminNotAbleToDeleteGroup();
	}      

}
