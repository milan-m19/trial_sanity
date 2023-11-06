package contentCreation;

import org.testng.annotations.Test;

import pageActions.CreateCollections;
import pageActions.UpForReviewMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class CreateCollectionsAndPublish extends BaseClass {

	@Test
	public void VerifyCreatorCreateCollectionsAndSendForReviewAndPublish() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String collection = CreateCollections.CreateCollectionsFromBook();
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.Collections_up_For_Review(collection);

	}
}