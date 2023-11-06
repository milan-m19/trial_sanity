package TPD;

import org.testng.annotations.Test;

import pageActions.Course_Consumption;
import pageActions.Course_Creation;
import pageActions.PublishedMethods;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateUrduFontForReviewer extends BaseClass {
	@Test
	public void VerifyUrduFontForReviewer() throws Exception {
		
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName=excel.getContentName("PDF");
		String course=Course_Creation.createCourseInUrduLanguage(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		PublishedMethods.VerifyLanguageChangeInUrdu(course);
	
		
		
	}


}
