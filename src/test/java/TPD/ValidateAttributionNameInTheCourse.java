package TPD;

import org.testng.annotations.Test;

import pageActions.Course_Consumption;
import pageActions.Course_Creation;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateAttributionNameInTheCourse extends BaseClass {

	@Test
	public void verifyAttributionNameInTheCourse() throws Exception {
		
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("PDF");
		String course=Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		Course_Creation.courseWithAttribution(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		Course_Consumption.verifyAttributNameInCourse(course);
	}
	
	
}
