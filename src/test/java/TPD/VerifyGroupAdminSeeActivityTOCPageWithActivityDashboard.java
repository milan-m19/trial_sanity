package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyGroupAdminSeeActivityTOCPageWithActivityDashboard extends BaseClass {

	
	@Test
	public void verifyGroupAdminSeeActivityTOCPageWithActivityDashboard() throws Exception {
		
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.UserAbleToAddMemberInGroup();
		CreateGroups.AdminAddActivityAsCourse();
		CreateGroups.ValidateActivityDashboard();

	}  

}
