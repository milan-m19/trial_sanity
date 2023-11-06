package TPD;

import org.testng.annotations.Test;

import pageActions.Course_Consumption;
import pageActions.Course_Creation;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateCreditAndLicenceInfoDropdownForCourse extends BaseClass {
	@Test
	public void verifyCreditAndLicenceInfoDropdownForCourse() throws Exception {
	
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("CourseAssessment");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		Course_Consumption.verifyDifferentFieldsInCourseAssessment(course);

	}
}
