package TPD;

import org.testng.annotations.Test;

import Consumption.ConsumptionScenarios;
import pageActions.CertificateCreation;
import pageActions.CourseConsumptionMethods;
import pageActions.Course_Creation;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateNoCertifcatePopUpForCourse extends BaseClass{

	@Test
	public void VerifyNoCertifcatePopUpForCourse() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");		
		String contentName=excel.getContentName("PDF");
		String course=Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		CourseConsumptionMethods.verifyNoCertificateNoteForCourseInCongratulationPopUp(course);
		
			
		
	}
	
}
