package TPD;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.Course_Consumption;
import pageActions.Course_Creation;
import pageActions.PublishedMethods;
import pageActions.TPDMethods;
import pageActions.UpForReviewMethods;
import pageActions.UserOnBoarding;
import pageObject.ExplorePage;
import utility.BaseClass;
import utility.DikshaUtils;

public class validateDownloadAsCSVdisplayedOnDashboard extends BaseClass {

	@Test
	public void verifyGuestUserGettingLoginPopUpWhenClickedOnJoinCourseButtonForOpenBatch() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String CourseName = Course_Creation.CreateCourseUsingTextbookAndSendForReview();
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.eTextbookAddedInCourse_up_For_Review(CourseName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(CourseName);
		TPDMethods.viewDashboardAndRequestTheReport(CourseName);
		UserOnBoarding.logout();
		Course_Consumption.searchContentForConsumption(CourseName);
		UserOnBoarding.validateloginPopUpInGuestUse("Public User1");
		UserOnBoarding.validatelogout();
	}
}