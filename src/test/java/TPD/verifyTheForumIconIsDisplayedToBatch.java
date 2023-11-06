package TPD;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.Course_Creation;
import pageActions.CreateGroups;
import pageActions.SendForReviewMethods;
import pageActions.TPDMethods;
import pageActions.UpForReviewMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import pageObject.ExplorePage;
import utility.BaseClass;

public class verifyTheForumIconIsDisplayedToBatch extends BaseClass {
	@Test(priority = 0)
	public static void verifyTheForumOnceBatchIsSelected() throws Exception {
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
		TPDMethods.verifyTheForumOnceBatchIsSelected(course);
		CreateGroups.startDiscussionForCourse();
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.userEnrollsInCourse(course);
		CreateGroups.startDiscussionForCourse();
		// return course;
//	
	}
//	@Test(priority=1)
//	public static void verifyForumIconIsDisplayedToBatchAdminCreatorAndTheMemberWhoJoinedTheCourse() throws Exception {
//		verifyTheForumIconIsDisplayedToBatch courseName = new verifyTheForumIconIsDisplayedToBatch();
//		String course = courseName.verifyTheForumOnceBatchIsSelected();
//		CreateGroups.startDiscussionForCourse();
//		UserOnBoarding.logout();
//		UserOnBoarding.login("Public User1");
//		TPDMethods.userEnrollsInCourse(course);
//		CreateGroups.startDiscussionForCourse();
//		
//	}
}