package TPD;

import org.openqa.selenium.WebElement;
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
import utility.ExcelDataProvider;
import pageActions.Course_Consumption;

public class verifyCourseHasMultipleModules extends BaseClass {
	@Test(enabled = false)
	public void verifyNextAndPrevModuleOnMultipleModule() throws Exception {
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
		String course = Course_Creation.UploadContentsFromLibrary(contentName, contentName2);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.userEnrollsInCourse(course);
		Course_Consumption.verifyNextAndPrevModulButton();
	}

	@Test(enabled = false)
	public void verifyConsentDetialsPopUp() throws Exception {
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
		String course = Course_Creation.UploadContentsFromLibrary(contentName, contentName2);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.verifyConsentPopUpDetails(course);
	}

	@Test(enabled = false)
	public void UserIsAbleToClickOnTheSyncProgressNowAndProgressIsSyn() throws Exception {
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
		TPDMethods.userEnrollsInCourse(course);
		Course_Consumption.ConsumeCousreAndSyncProgress();

	}

	@Test(enabled = false)
	public void verifyCourseProgressAndContinueLearning() throws Exception {
		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);

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
		String course = Course_Creation.UploadContentsFromLibrary(contentName, contentName2);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.userEnrollsInCourse(course);
		Course_Consumption.verifyCourseProgressContinueLearningButton();

	}

	@Test(enabled = false)
	public void verifyUserShouldBeAbleToConsumeTheCourse() throws Exception {
		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);

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
		String course = Course_Creation.UploadContentsFromLibrary(contentName, contentName2);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.userEnrollsInCourse(course);
		Course_Consumption.verifyUserCanBeAbleToConsumeTheCourseOnMyProfile(course);

	}

	@Test(enabled = false)
	public void verifyUserREDOTheAssessmentTillTheAttemptLeftForThatAssessment() throws Exception {
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);
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
		TPDMethods.verifyUserREDOTheAssessmentTillTheAttemptLeft();

	}

	@Test(enabled = false)
	public static void verifyOnCompletionOfAModuleInCourseYouHaveCompletedThisModuleDisplayed() throws Exception {
		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);
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
		String course = Course_Creation.UploadContentsFromLibrary(contentName, contentName2);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.userEnrollsInCourse(course);
		TPDMethods.verifyYouHaveCompletedThisModuleDisplayedMsgPostConsumption();
	}

	@Test(enabled = false)
	public static void verifyThatUserCanReviewAnsweredQuestionBeforeSubmittingTheAssessment() throws Exception {
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
		TPDMethods.UserCanReviewAnsweredQuestionBeforeSubmitting();
	}

	@Test(enabled = false)
	public static void verifyUserAfterJoiningTheCourseCanViewTheEndDate() throws Exception {
		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);

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
		String course = Course_Creation.UploadContentsFromLibrary(contentName, contentName2);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.userEnrollsInCourse(course);
		// Course_Consumption.verifyUserAfterJoiningTheCourseCanViewTheEndDate();

	}

	@Test
	public static void verifyWhenTheUserUnenrollAndEnrolsBack() throws Exception {
		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);

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
		String course = Course_Creation.UploadContentsFromLibrary(contentName, contentName2);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		// TPDMethods.userEnrollsInCourse(course);
		TPDMethods.enrollConumePartially(course);
		TPDMethods.userUnenrollsInCourse(course);
		// TPDMethods.reEnrollVerifyAndContinueLearning();

	}

}