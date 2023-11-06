package TPD;

import org.testng.annotations.Test;

import pageActions.Course_Creation;
import pageActions.CreateQuestionSet;
import pageActions.QuestionSet_Consumption;
import pageActions.TPDMethods;
import pageActions.UpForReviewMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyUserNotAbleToConsumeQuestionSetAfterMaximumAttemptReached extends BaseClass {

	 @Test
    public void VerifyUserNotAbleToConsumeQuestionSetAfterMaximumAttempt() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName=excel.getContentName("QuestionSet");
		
//		String QuestionSet=CreateQuestionSet.CreateQuestionSetAndSendForReview();
//		UserOnBoarding.logout();
//		UserOnBoarding.login("Reviewer");
//		UpForReviewMethods.QuestionSet_up_For_Review(QuestionSet);
//		UserOnBoarding.logout();
		
		String questionset=Course_Creation.UploadContentFromLibrary(contentName);
		UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UploadContentMethods.publishCourseFromUpForReview(questionset);
		UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		TPDMethods.createBatch(questionset);
		UserOnBoarding.logout();
		UserOnBoarding.login("Public User1");
		TPDMethods.userEnrollsInCourse(questionset);
		QuestionSet_Consumption.consumeQuestionSet();
		
		
		
		
		
		
		
		
		
		

		
	 }
	
	


}
