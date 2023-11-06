package TPD;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageActions.Course_Consumption;
import pageActions.Course_Creation;
import pageActions.SendForReviewMethods;
import pageActions.TPDMethods;
import pageActions.UpForReviewMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import pageObject.ExplorePage;
import utility.BaseClass;

public class VerifyEnrolmentDetailsBeforeJoiningCourse extends BaseClass {

	@Test
	public void verifyUserViewEnrolmentEndDateBeforeJoiningCourse() throws Exception {
		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);

		UserOnBoarding.login("Public User1");

		String course = excel.getContentName("Course");

		TPDMethods.userEnrollsInCourse(course);
		Course_Consumption.ConsumeTwoContents();
	}
}
