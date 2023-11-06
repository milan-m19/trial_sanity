package contentCreation;

import org.testng.annotations.Test;

import pageActions.AllMyContentMethods;
import pageActions.UserOnBoarding;
import utility.BaseClass;

public class ValidateAllMyContentBucket extends BaseClass {
  @Test
	public void  validateContentsInAllMyContentsBucket() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String value = excel.getContentName("PDF");
	    AllMyContentMethods.searchContent(value);
		
	}
	
}
