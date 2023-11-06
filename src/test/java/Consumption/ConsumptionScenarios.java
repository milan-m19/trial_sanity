package Consumption;

import org.testng.annotations.Test;

import pageActions.Book_Creation;

import pageActions.CertificateCreation;
import pageActions.CourseAssessmentMethods;
import pageActions.Course_Consumption;
import pageActions.Course_Creation;
import pageActions.SendForReviewMethods;
import pageActions.CourseConsumptionMethods;
import pageActions.Course_Creation;
import pageActions.TPDMethods;
import pageActions.UpForReviewMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.ExcelDataProvider;

public class ConsumptionScenarios extends BaseClass {

	@Test

	public void searchTvLessonWithNameAndDoidAndConsume() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Public User1");
		String name = excel.getContentName("TvLesson");
		String id = excel.getDoID("TvLesson");
		CourseConsumptionMethods.searchContentForConsumption(id);
		CourseConsumptionMethods.searchContentForConsumption(name);

	}

	@Test
	public void searchETextbookWithNameAndDoidAndQRCode() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String Bookname = Book_Creation.CreateBookWithQRCodeAndSendForReview();
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.eTextbook_up_For_Review(Bookname);
		UserOnBoarding.logout("Reviewer");
		UserOnBoarding.login("Public User1");
		String name = excel.getContentName("ETextBook");
		String id = excel.getDoID("ETextBook");
		String QRCode = "V9X1R7";
		CourseConsumptionMethods.searchEtextbookForConsumption(id);
		CourseConsumptionMethods.searchEtextbookForConsumption(name);
		CourseConsumptionMethods.searchEtextbookForConsumption(QRCode);
	}

	@Test
	public void VerifyUserClickOnViewAllAndCloseButtonForTheMyCoursesSectionAndCourseCardDetailIsDisplayed()
			throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Public User1");
		Course_Consumption.UserDisplayCourseCardDetailsAndViewAllAndCloseButttonInMyCourseSection();

	}

	@Test
	public void VerifyUserIsAbleToGetTheCompletionCertificate() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("PDF1");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout("Reviewer");
		UserOnBoarding.login("Creator");
		TPDMethods.createBatchAndAddCertificate(course);
		CertificateCreation.AddCompletionCertificateToCourse();
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Public User1");
		Course_Consumption.consumeCourseContent(course);

	}

	@Test
	public void VerifyUserSeeCeritificateCriteriaAndBatchDetailsInTheCourseTOC() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("PDF1");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout("Reviewer");
		UserOnBoarding.login("Creator");
		TPDMethods.createBatchAndAddCertificate(course);
		CertificateCreation.AddCompletionCertificateToCourse();
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Public User1");
		CertificateCreation.UserAbleToSeeCeritificateCriteriaAndBatchDetailsInCourseTOC(course);

	}

	@Test
	public void VerifyUserIsAbleToGetTheMeritCertificate() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("CourseAssessment");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout("Reviewer");
		UserOnBoarding.login("Creator");
		TPDMethods.createBatchAndAddCertificate(course);
		CertificateCreation.AddMeritCertificateToCourse();
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Public User1");
		Course_Consumption.VerifyAndConsumeCourseAssesment(course);
//		 Course_Consumption.consumeCourseAssesment(course);

	}

	@Test
	public void checkCourseExpiryMessageForUser() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("CourseAssessment");
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
		CourseConsumptionMethods.validateBatchExpiryMessage();
	}

	// @Test
	// Not in scope for now, will work on this later
	public void checkContentForDownloadedQRFile() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Public User1");
		String id = excel.readDataForDownloadedQRCodeFile();
		CourseConsumptionMethods.searchEtextbookForConsumption(id);

	}

}