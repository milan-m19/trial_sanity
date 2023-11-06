package contentCreation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.CourseAssessmentMethods;
import pageActions.SendForReviewMethods;
import pageActions.UpForReviewMethods;
import pageActions.UserOnBoarding;
import pageObject.ExplorePage;
import utility.BaseClass;
import utility.DikshaUtils;

public class CreateCourseAssessmentAndSendForReview extends BaseClass {
	@Test
	public void CreateAssessmentAndSendForReview() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = CourseAssessmentMethods.createAssessmentWithQuestion();
		SendForReviewMethods.sendCourseAssessment_For_Review(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.up_For_Review(contentName);

	}

}
