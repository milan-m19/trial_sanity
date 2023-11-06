package TPD;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyGroupAdminAddAllTypeOfActivityInGroup extends BaseClass {

	
	@Test
	public void verifyGroupAdminAddAllTypeOfActivityInGroup() throws Exception {
		
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("New User");
		CreateGroups.AdminAbleToCreateGroup();
		CreateGroups.AdminAddActivityAsCourse();
		CreateGroups.AdminAddActivityAsExplanationContent();
		CreateGroups.AdminAddActivityAsLearningModule();
		CreateGroups.AdminAddActivityAsPracticeQuestionSet();
		CreateGroups.AdminAddActivityAsPDFTextbook();
		CreateGroups.AdminAddActivityAsTeachingResources();
		CreateGroups.AdminAddActivityAsDigitalTextbook();
	}   

}
