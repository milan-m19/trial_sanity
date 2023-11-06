package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyUserAbleToSeeUpdatedDataInGroup extends BaseClass {

	@Test
	public void verifyUserAbleToSeeUpdatedDataInGroup() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		String Groupname =CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.UserAbleToAddMemberInGroup();
		CreateGroups.AdminAbleToEditTheGroupDetails(Groupname);
		UserOnBoarding.logout();
		UserOnBoarding.login("New User1");
		CreateGroups.UserAbleToSelectGroup();
		CreateGroups.UserValidateUpdatedGroupDetail(Groupname);
  }  

}
