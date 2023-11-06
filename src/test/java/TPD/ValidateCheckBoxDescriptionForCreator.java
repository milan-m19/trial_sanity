package TPD;

import org.testng.annotations.Test;

import pageActions.Course_Creation;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateCheckBoxDescriptionForCreator extends BaseClass {

	@Test
	public void verifyCheckBoxDescriptionForCreator() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("CourseAssessment");
		String course = Course_Creation.verifyCheckBoxDescription(contentName);

	}

}
