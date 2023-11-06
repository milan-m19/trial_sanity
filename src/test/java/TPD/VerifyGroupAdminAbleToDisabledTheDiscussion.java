package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyGroupAdminAbleToDisabledTheDiscussion  extends BaseClass {

	@Test
	public void verifyGroupAdminAbleToDisabledTheDiscussion() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.SelectEnableDiscussionOption();
		CreateGroups.SelectDisabledDiscussionOption();
		
		
  }  

}
