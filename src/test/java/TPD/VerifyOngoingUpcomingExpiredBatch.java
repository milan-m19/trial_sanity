package TPD;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.Course_Creation;
import pageActions.TPDMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import pageObject.ExplorePage;
import utility.BaseClass;

public class VerifyOngoingUpcomingExpiredBatch extends BaseClass {

	@Test
	public void verifyOngoingUpcomingExpiredBatch() throws Exception {
		
		ExplorePage explore=PageFactory.initElements(driver,  ExplorePage.class);
		
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
		TPDMethods.verifyDiffrentBatchesInCourse(course);
	
	}	
}
