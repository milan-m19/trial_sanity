package TPD;

import org.testng.annotations.Test;

import pageActions.CertificateCreation;
import pageActions.Course_Consumption;
import pageActions.Course_Creation;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateCourseProgressAfterReEnrollToCourse extends BaseClass {


	@Test
	public void VerifyCourseProgressAfterReEnrollToCourse() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName=excel.getContentName("PDF");
		String course=Course_Creation.UploadPdfMp4AndAssessmentInCourse(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatchAndAddCertificate(course);
		CertificateCreation.AddCompletionCertificateToCourse();
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		Course_Consumption.consumePdfMp4AndAssessmentContent(course);
		TPDMethods.userUnenrollsInCourse(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.userReEnrollsInCourse(course);
		
	}
	
	
}
