package TPD;

import org.testng.annotations.Test;

import pageActions.CertificateCreation;
import pageActions.Course_Creation;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class TPDScenario extends BaseClass {

//	@Test
	public void userAbleToPerformKeyboardEventInNewTheme() throws Exception {

		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Public User1");
		TPDMethods.userPerformKeyboardEventInNewTheme();
	}

//	@Test
	public void userAbleToPerformKeyboardEventInOldTheme() throws Exception {

		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Public User1");
		TPDMethods.userPerformKeyboardEventInOldTheme();
	}

	// @Test
	public void VerifyHomeAndExploreTabsForLoggedAndNonLoggedInUser() throws Exception {

		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		TPDMethods.VerifyHomeAndExploreTabsForNonLoggedInUser();
		UserOnBoarding.login("Public User1");
		TPDMethods.VerifyHomeAndExploreTabsForLoggedInUser();

	}

	// @Test
	public void VerifyGuestUserPreferencesForBMCInHomePage() throws Exception {

		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Public User1");
		TPDMethods.VerifyGuestUserPreferencesForBMC();

	}

	// @Test
	public void validateShareIconInCourseToc() throws Exception {

		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("ETextBook");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.userShareCourseWithoutEnroll(course);
	}

//	@Test
	public void validateCourseDontHaveOpenBatchMessage() throws Exception {

		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Public User1");
		TPDMethods.userDisplayedExpireBatchMessage();
	}

	// @Test
	public void createCourseWithBatchDatesAndValidate() throws Exception {

		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("PDF");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.ValidateCourseBatchDate(course);

	}

	// @Test
	public void CreatorAbleToCloseTheBatchDetailsSection() throws Exception {

		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("PDF");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		TPDMethods.CreatorCloseBatchDetailsSection(course);

	}

	// @Test
	public void VerifyBatchNotAvailableForCourseThenBatchDetailsSectionNotDisplayedToUser() throws Exception {

		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("PDF");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.UserNotAbleToSeeBatchDetailSection(course);

	}

	@Test
	public void UserNotAbleToSeeCertificateCriteriaInTheCourse() throws Exception {

		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName = excel.getContentName("PDF");
		String course = Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(course);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.UserNotAbleToSeeCertificateCriteria(course);

	}

}
