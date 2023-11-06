package observation;

import org.testng.annotations.Test;

import pageActions.Observation;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyRoles extends BaseClass {

	@Test
	public void VerifyUserSelectsRoleHeadTeacherAndOfficial() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("New User");
		Observation.validateObservationTab();
		Observation.SelectRoleAsTeacher();

	}

}
