package TPD;

import org.testng.annotations.Test;

import contentCreation.CreateCourseAndPublish;
import pageActions.Course_Creation;
import pageActions.CreateGroups;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class verifyCreateGroupsAndaddActivityOfOpenBatches extends BaseClass {

	@Test
	public void VerifyUserIsAbleToCreateNewGroups() throws Exception {
		
		CreateCourseAndPublish content = new CreateCourseAndPublish();
		
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
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
		TPDMethods.userEnrollsInCourse(course);
		TPDMethods.userUnenrollsInCourse(course);
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("Public User1");
		CreateGroups.createGroupsAndValidateAddedActivity(contentName);
	}
}