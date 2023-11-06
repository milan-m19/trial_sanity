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

public class verifyElaborateSectionHasTypeHereAsPlaceholder extends BaseClass {
	@Test
	public void validatePlacehodersInStartDiscussion() throws Exception {
		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("groupAdmin2");
		CreateGroups.createDiscussionAndValidatePlaceholders();
		UserOnBoarding.validatelogout();
	}
}