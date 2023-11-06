package TPD;

import org.testng.annotations.Test;

import pageActions.CertificateCreation;
import pageActions.Course_Consumption;
import pageActions.Course_Creation;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyUserAbleToSeeNameChangePopup extends BaseClass{

	@Test
	public void verifyUserAbleToSeeNameChangePopup() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
//		String courseAssesment=CourseAssessmentMethods.createAssessmentWithQuestion();
//		SendForReviewMethods.sendCourseAssessment_For_Review(courseAssesment);
//		UserOnBoarding.logout();
//		UserOnBoarding.login("Reviewer");
//		UpForReviewMethods.up_For_Review(courseAssesment);
//		UserOnBoarding.logout();
//		UserOnBoarding.login("Creator");
		
		String contentName=excel.getContentName("CourseAssessment");
		String course=Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatchAndAddCertificate(course);
		CertificateCreation.AddMeritCertificateToCourse();;
		UserOnBoarding.logout();
		UserOnBoarding.login("New User");
		TPDMethods.userEnrollsInCourse(course);
		TPDMethods.ValidateuserIgnorNameChangePopup();
			
		
	}

}
