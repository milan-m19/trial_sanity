package TPD;

import org.testng.annotations.Test;

import pageActions.CourseConsumptionMethods;
import pageActions.Course_Creation;
import pageActions.CreateGroups;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyGroupAdminAbleToSortCourseProgress extends BaseClass {

	
	@Test
	public void verifyGroupAdminAbleToSortCourseProgress() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName=excel.getContentName("PDF");

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
		CreateGroups.UserAbleToAddTwoMemberInGroup();
		CreateGroups.AdminAddActivityBasedOnCourseName(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		CreateGroups.UserAbleToSelectGroup();
		CourseConsumptionMethods.UserconsumeCourseFromGroup(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("New User");
		CreateGroups.UserAbleToSelectSameGroupSecondTime();
		CreateGroups.ValidateActivityDashboard();
		CreateGroups.GroupAdminAbleToSortProgress();
		
		
		
		
    }
}