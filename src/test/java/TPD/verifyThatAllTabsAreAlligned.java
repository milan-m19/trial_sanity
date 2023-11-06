package TPD;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.TPDMethods;
import pageActions.UserOnBoarding;
import pageObject.ExplorePage;
import utility.BaseClass;

public class verifyThatAllTabsAreAlligned extends BaseClass {
	@Test
	public static void verifyAllTabsAreAlligned() throws Exception {
		// ExplorePage explore=PageFactory.initElements(driver, ExplorePage.class);

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Public User1");
		TPDMethods.verifyAllTabsOnUser();

	}

}
