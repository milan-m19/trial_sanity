package TPD;

import org.testng.annotations.Test;

import pageActions.AllMyContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateMyCoursesSection extends BaseClass{

	

	@Test
	public void validateMyCoursesSection() throws Exception {
		
		
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Public User1");
		AllMyContentMethods.myCourseSection();
	
	
}
}
