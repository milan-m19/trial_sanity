package contentCreation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.CourseAssessmentMethods;
import pageActions.CourseConsumptionMethods;
import pageActions.Course_Creation;
import pageActions.SendForReviewMethods;
import pageActions.TPDMethods;
import pageActions.UpForReviewMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import pageObject.ExplorePage;
import utility.BaseClass;
import utility.DikshaUtils;

public class CreateCourseAndPublish extends BaseClass {

	@Test
	public void createCourseSendForReviewAndPublish() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("Mp41");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);

	}

	@Test
	public void verifyAddFromLibraryInCourse() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("PDF");
		Course_Creation.checkUploadContentFromLibrary(contentName);

	}

	@Test
	public void CreateBatchWithFutureDate() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("PDF");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout("Reviewer");
		UserOnBoarding.login("Creator");
		TPDMethods.createBatchAndVerify(course);

	}

	@Test
	public void userJoinsTheCourse() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("PDF");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout("Reviewer");
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Public User1");
		TPDMethods.userEnrollsInCourse(course);
	}

	@Test
	public void verifyOnlyOneOpenBatch() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("PDF");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout("Reviewer");
		UserOnBoarding.login("Creator");
		TPDMethods.verifyOneBatchInCourse(course);

	}

	@Test
	public void verifyDiscussionForumForCourse() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("PDF");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout("Reviewer");
		UserOnBoarding.login("Creator");
		TPDMethods.openDiscussionForum(course);

	}

	@Test
	public void addMentorInCourseAndVerify() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("PDF");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout("Reviewer");
		UserOnBoarding.login("Creator");
		TPDMethods.addMentor(course);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Admin");
		TPDMethods.verifyAddMentor(course);
	}

	@Test
	public void verifyAddCourseAssessmentInCourse() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String Assessment = excel.getContentName("CourseAssessment");
		String course = Course_Creation.addingCourseAssessmentFromLibrary(Assessment);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout("Reviewer");

	}

	@Test
	public void verifyMentorCanCreateBatch() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("PDF");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout("Reviewer");
		UserOnBoarding.login("Creator");
		TPDMethods.addMentor(course);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Admin");
		TPDMethods.mentorEditTheCourse(course);
	}

	@Test
	public void userUnenrollsFromTheCourse() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("PDF");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout("Reviewer");
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Public User1");
		TPDMethods.userEnrollsInCourse(course);
		TPDMethods.userUnenrollsInCourse(course);
	}
}