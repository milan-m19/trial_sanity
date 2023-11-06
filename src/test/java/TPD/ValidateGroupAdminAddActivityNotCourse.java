package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateGroupAdminAddActivityNotCourse extends BaseClass {

	@Test
	public void VerifyGroupAdminAddActivityNotCourse() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Public User1");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.AdminAddActivityAsDigitalTextbook();
		
		
		//CreateGroups.AbleToAddTextbookInGroup();
			
	}
	
	
}
