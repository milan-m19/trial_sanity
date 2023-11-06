package TPD;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.Course_Creation;
import pageActions.SendForReviewMethods;
import pageActions.UpForReviewMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import pageObject.ExplorePage;
import utility.BaseClass;

public class CreateCoursePublish extends BaseClass {
	@Test
	public void createCourseAndPublish() throws Exception {
		

		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName = UploadContentMethods.UploadPdf();
		SendForReviewMethods.sendPdf_For_Review(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.up_For_Review(contentName);
		UserOnBoarding.logout("Reviewer");
		UserOnBoarding.login("Creator");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);

	}
}