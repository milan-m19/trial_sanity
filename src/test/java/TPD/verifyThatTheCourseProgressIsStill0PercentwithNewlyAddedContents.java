package TPD;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.Course_Consumption;
import pageActions.Course_Creation;
import pageActions.SendForReviewMethods;
import pageActions.TPDMethods;
import pageActions.UpForReviewMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import pageObject.ExplorePage;
import utility.BaseClass;

public class verifyThatTheCourseProgressIsStill0PercentwithNewlyAddedContents extends BaseClass {
	ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);

	@Test
	public static void verifyCourseProgressIsStill0PercentwithNewlyAddedContents() throws Exception {
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = UploadContentMethods.UploadPdf();
		SendForReviewMethods.sendPdf_For_Review(contentName);
		String contentName2 = UploadContentMethods.UploadPdf();
		SendForReviewMethods.sendPdf_For_Review(contentName2);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.up_For_Review(contentName);
		UpForReviewMethods.up_For_Review(contentName2);
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
		TPDMethods.joincourseAndVerifyCourseProgress(course);
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("Creator");
		UploadContentMethods.openCousrseAddAContentAndSendForReview(course, contentName2);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.RejoincourseAndVerifyCourseProgressRemains0Percentage(course);

	}
}
