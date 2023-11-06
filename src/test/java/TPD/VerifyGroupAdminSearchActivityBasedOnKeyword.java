package TPD;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.Course_Creation;
import pageActions.CreateGroups;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import pageObject.ExplorePage;
import utility.BaseClass;

public class VerifyGroupAdminSearchActivityBasedOnKeyword  extends BaseClass {

	
	@Test
	public void verifyGroupAdminSearchActivityBasedOnKeyword() throws Exception {
		
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.AdminSearchActivityBasedOnKeywords();
		

	} 
 

}
