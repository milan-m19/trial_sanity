package TPD;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.Course_Consumption;
import pageActions.Course_Creation;
import pageActions.CreateGroups;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import pageObject.ExplorePage;
import utility.BaseClass;

public class VerifyGroupAdminSeeMemberAssesmentProgress  extends BaseClass{

	
	@Test
	public void verifyGroupAdminSeeMemberAssesmentProgress() throws Exception {
		
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		
		UserOnBoarding.login("Creator");
		String contentName=excel.getContentName("CourseAssessment");

//		String contentName=UploadContentMethods.UploadPdf();
//		SendForReviewMethods.sendPdf_For_Review(contentName);
//		UserOnBoarding.logout();
//		UserOnBoarding.login("Reviewer");
//		UpForReviewMethods.up_For_Review(contentName);
//		UserOnBoarding.logout();
//		UserOnBoarding.login("Creator");
		
		String course=Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout();
		
		
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.UserAbleToAddMemberInGroup();
		CreateGroups.AdminAddActivityBasedOnCourseName(course);
		UserOnBoarding.logout();
		
		UserOnBoarding.login("New User1");
		Course_Consumption.consumeCourseAssesment(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("New User");
		CreateGroups.UserAbleToSelectGroup();
		CreateGroups.ValidateCourseAssesmentActivityDashboard();
	
	
		
	}
	
		
}
