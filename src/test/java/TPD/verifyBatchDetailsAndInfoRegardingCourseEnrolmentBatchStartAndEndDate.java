package TPD;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.Course_Creation;
import pageActions.SendForReviewMethods;
import pageActions.TPDMethods;
import pageActions.UpForReviewMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import pageObject.ExplorePage;
import utility.BaseClass;

public class verifyBatchDetailsAndInfoRegardingCourseEnrolmentBatchStartAndEndDate extends BaseClass {
	@Test
	public static void verifyCourseEnrolmentBatchStartAndEndDate() throws Exception {

		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = UploadContentMethods.UploadPdf();
		SendForReviewMethods.sendPdf_For_Review(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.up_For_Review(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.verifyBatchStartDateAndEndDate(course);
	}
}
