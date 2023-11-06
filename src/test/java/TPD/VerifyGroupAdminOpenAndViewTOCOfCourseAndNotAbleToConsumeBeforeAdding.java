package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyGroupAdminOpenAndViewTOCOfCourseAndNotAbleToConsumeBeforeAdding  extends BaseClass {

	@Test
	public void vVerifyGroupAdminOpenAndViewTOCOfCours() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.AdminAddActivityAsCourse();
		CreateGroups.AdminAbleToViewActivityOfTheCourse();
		CreateGroups.AdminTryToConsumeCourseContentBeforeAddingInGroup();
	
	}       
 

}
