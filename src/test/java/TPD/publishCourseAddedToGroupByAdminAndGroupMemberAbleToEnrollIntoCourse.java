package TPD;

import org.testng.annotations.Test;

import contentCreation.CreateCourseAndPublish;
import pageActions.Course_Creation;
import pageActions.CreateGroups;
import pageActions.SendForReviewMethods;
import pageActions.TPDMethods;
import pageActions.UpForReviewMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class publishCourseAddedToGroupByAdminAndGroupMemberAbleToEnrollIntoCourse extends BaseClass {

	@Test
	public void VerifyUserIsAbleToCreateNewGroups() throws Exception {


		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName=UploadContentMethods.UploadPdf();
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
		TPDMethods.createBatch(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("groupMember2");
		CreateGroups.copyUserId();
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("groupAdmin2");
		CreateGroups.createGroupsAndValidateAddedActivity(course);
		CreateGroups.UserIsAbleVerifyAddMembers();
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("groupMember2");
		CreateGroups.validateGroupMemberEnrollCourse();
		CreateGroups.userEnrollsInCourse();
		UserOnBoarding.validatelogout();
		UserOnBoarding.login("groupAdmin2");
		CreateGroups.deleteCreatedGroupWithoutCrossTab();;
		UserOnBoarding.validatelogout();
	}
}