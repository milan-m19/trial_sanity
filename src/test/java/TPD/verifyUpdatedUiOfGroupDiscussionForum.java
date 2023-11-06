package TPD;

import org.testng.annotations.Test;

import contentCreation.CreateCourseAndPublish;
import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class verifyUpdatedUiOfGroupDiscussionForum extends BaseClass {

	@Test
	public void validatfilterByOption() throws Exception {
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("groupAdmin1");
		CreateGroups.VerifyUserDisplayedEnableDiscussionsOption();
	}
}