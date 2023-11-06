package TPD;

import org.testng.annotations.Test;

import pageActions.AllMyContentMethods;
import pageActions.CertificateCreation;
import pageActions.Course_Consumption;
import pageActions.Course_Creation;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateRatingPopupAndCourseUnderMyCourseSection extends BaseClass{

	@Test
	public void VerifyRatingPopupAndCourseUnderMyCourseSection() throws Exception {
		
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
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
		Course_Consumption.addDiffrentContentAndValidateRatingPopup(course);
		AllMyContentMethods.CourseUnderMyCoursesSection(course);
		
	}
	
	
}
