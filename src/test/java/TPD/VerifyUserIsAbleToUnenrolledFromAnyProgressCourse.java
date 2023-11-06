package TPD;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.CourseConsumptionMethods;
import pageActions.Course_Creation;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import pageObject.ExplorePage;
import utility.BaseClass;

public class VerifyUserIsAbleToUnenrolledFromAnyProgressCourse extends BaseClass {

	@Test
	public void verifyUserIsAbleToUnenrolledFromAnyProgressCourse() throws Exception {
		
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName=excel.getContentName("PDF");

//		String contentName=UploadContentMethods.UploadPdf();
//		SendForReviewMethods.sendPdf_For_Review(contentName);
//		UserOnBoarding.logout();
//		UserOnBoarding.login("Reviewer");
//		UpForReviewMethods.up_For_Review(contentName);
//		UserOnBoarding.logout();
//		UserOnBoarding.login("Creator");
		String course=Course_Creation.UploadTwoTypeOfContentFromLibrary(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		CourseConsumptionMethods.Partiallyconsume_PDF_Course_Content(course);
		TPDMethods.userUnenrollsInCourse(course);
	}

}
