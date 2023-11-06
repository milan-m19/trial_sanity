package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyAdminIsAbleToDeleteTheGroup extends BaseClass {

	@Test
	public void verifyAdminIsAbleToDeleteTheGroup() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.AdminAbleToDeleteTheGroup();

	}

}
