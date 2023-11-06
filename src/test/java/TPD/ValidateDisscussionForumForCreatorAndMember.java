package TPD;

import org.testng.annotations.Test;

import pageActions.Course_Creation;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateDisscussionForumForCreatorAndMember extends BaseClass {

	@Test
	public void verifyDisscussionForumForCreatorAndMember() throws Exception {
	
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
		TPDMethods.openDiscussionForum(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.VerifyDFforUser(course);
		
	}
	
	
}
