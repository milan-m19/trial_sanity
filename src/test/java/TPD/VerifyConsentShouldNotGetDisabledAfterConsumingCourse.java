package TPD;

import org.testng.annotations.Test;

import pageActions.CourseConsumptionMethods;
import pageActions.Course_Creation;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;
import utility.ExcelDataProvider;

public class VerifyConsentShouldNotGetDisabledAfterConsumingCourse extends BaseClass {

	@Test
	public void verifyConstentShouldNotGetDisabledAfterConsumingCourse() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("Mp4");
		String courseID = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(courseID);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		CourseConsumptionMethods.searchContentForConsumption(courseID);

	}

}
