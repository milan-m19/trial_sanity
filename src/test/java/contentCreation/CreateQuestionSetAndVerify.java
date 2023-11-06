package contentCreation;

import org.testng.annotations.Test;

import pageActions.CreateCollections;
import pageActions.CreateQuestionSet;
import pageActions.UpForReviewMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class CreateQuestionSetAndVerify extends BaseClass {

	@Test
	public void VerifyCreatorCreateTwoTypesOfQuestionSetAndSendForReview() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String QuestionSet = CreateQuestionSet.CreateTwoTypesOfQuestionSetAndSendForReview();
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.QuestionSet_up_For_Review(QuestionSet);
	}

}