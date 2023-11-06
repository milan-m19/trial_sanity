package testScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.CertificateCreation;
import pageActions.CourseConsumptionMethods;
import pageActions.Course_Consumption;
import pageActions.Course_Creation;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;
import utility.DikshaUtils;

public class Demo_Run extends BaseClass {

//@Test
//public void run() throws Exception {
//    UserOnBoarding.schoolheadicon();
//	UserOnBoarding.bmcpopuphandle();
//	UserOnBoarding.locationpopuphandle();
//	UserOnBoarding.loginascreator();
//	String contentName=UploadContentMethods.UploadPdf();
//	UploadContentMethods.sendPdf_For_Review(contentName);
//	UserOnBoarding.logout_As_Creator();
//	UserOnBoarding.loginasreviewer();
//	UpForReviewMethods.up_For_Review(contentName);
//	UserOnBoarding.logout_As_Reviewer();
//	UserOnBoarding.reLoginAsCreator();
//
//	String course=Course_Creation.UploadContentFromLibrary(contentName);
//	UserOnBoarding.logout_As_Creator();
//	UserOnBoarding.loginasreviewer();
//	UploadContentMethods.publishCourseFromUpForReview(course);
//	UserOnBoarding.logout_As_Reviewer();
//	UserOnBoarding.reLoginAsCreator();
//	TPD.createBatch(course);
//	UserOnBoarding.logout_As_Creator();
//	UserOnBoarding.loginasCustodian();
//	Course_Consumption.consume_PDF_Course_Content(course);
//		
//   }
//	

	//@Test
	public void VerifyUserIsAbleToGetTheMeritCertificate() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
//	String courseAssesment=CourseAssessmentMethods.createAssessmentWithQuestion();
//	SendForReviewMethods.sendCourseAssessment_For_Review(courseAssesment);
//	UserOnBoarding.logout();
//	UserOnBoarding.login("Reviewer");
//	UpForReviewMethods.up_For_Review(courseAssesment);
//	UserOnBoarding.logout();
//	UserOnBoarding.login("Creator");

		String contentName = excel.getContentName("CourseAssessment");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatchAndAddCertificate(course);
		CertificateCreation.AddMeritCertificateToCourse();
		;
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		Course_Consumption.consumeCourseAssesment(course);

	}

	@Test
	public void VerifyCustodianUsersAreGettingSubmitDetailsOptionInHisProfile() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Dont Use");
		UserOnBoarding.VerifyTheUserShouldBeAbleToEditTheSubmittedDetailsOptionInProfile();
		UserOnBoarding.login("AddUserCred");
		UserOnBoarding.VerifyUserShouldBeAbleToEditTheSubmittedDetails();

	}
}
