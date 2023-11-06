package TPD;

import org.testng.annotations.Test;

import pageActions.Course_Creation;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class verifyThatUserShouldBeDisplayedWithCourseCompletionMessage extends BaseClass {
	@Test
	public static void verifyThatUserDisplayedWithCourseCompletionMessage() throws Exception {
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		// ExplorePage explore=PageFactory.initElements(driver, ExplorePage.class);
		UserOnBoarding.login("Creator");
		String course = Course_Creation.createCourseWithAssessment();
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.userEnrollsInCourse(course);
		TPDMethods.verifyThatUserDisplayedWithCourseCompletionMessage();
		// TPDMethods.UserCanReviewAnsweredQuestionBeforeSubmitting();
	}
}
