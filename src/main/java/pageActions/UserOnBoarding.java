package pageActions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import pageObject.BMCPopup;
import pageObject.ExplorePage;
import pageObject.HomePage;
import pageObject.LocationPopup;
import pageObject.LoginAsCustodian;
import pageObject.LoginPage;
import pageObject.Logout;
import pageObject.ManageUser;
import pageObject.SubmitDetails;
import pageObject.UpdateProfile;
import pageObject.UserHomeTab;
import pageObject.Useronboarding;
import pageObject.ValidatePopUp;
import pageObject.userProfile;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.ExcelDataProvider;
import utility.Library;
import utility.Listeners;

public class UserOnBoarding extends BaseClass {

	public static String SelectUserRole(String role) throws Exception {

		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);
		Useronboarding Ub = PageFactory.initElements(driver, Useronboarding.class);

		
		
		
		String expectedContinueButton = "NA";
		boolean checkRoles = false;
		boolean checkIfRoleIsSelected = false;
		String expectedRole = "NA";
		
		String expected1 = "Verify user should be able to see the roles";
		String actual1 = "User is not able to see the roles";

		String expected2 = "Verify user should be able to select one of the roles";
		String actual2 = "User is not able to select the roles";

		try {

			if (Ub.getWelcomeToDiksha().isDisplayed()) {
				checkRoles = true;

				Assert.assertTrue(Ub.getStudentIcon().isDisplayed());
				Assert.assertTrue(Ub.getTeacher().isDisplayed());
				Assert.assertTrue(Ub.getOther().isDisplayed());
				Assert.assertTrue(Ub.getParent().isDisplayed());
				Assert.assertTrue(Ub.getHeadteacher().isDisplayed());

				actual1 = "User is able to see the roles successfully";
				expectedRole = "True";
			}

			if (role.equals("Student")) {
				DikshaUtils.waitToBeClickableAndClick(Ub.getStudentIcon());
				DikshaUtils.waitToBeClickableAndClick(Ub.getContinueButton());
			}

			else if (role.equals("Teacher")) {
				DikshaUtils.waitToBeClickableAndClick(Ub.getTeacher());
				DikshaUtils.waitToBeClickableAndClick(Ub.getContinueButton());
			}

			else if (role.equals("Other")) {
				DikshaUtils.waitToBeClickableAndClick(Ub.getOther());
				DikshaUtils.waitToBeClickableAndClick(Ub.getContinueButton());
			}

			else if (role.equals("Parent")) {
				DikshaUtils.waitToBeClickableAndClick(Ub.getParent());
				DikshaUtils.waitToBeClickableAndClick(Ub.getContinueButton());
			}

			else if (role.equals("HT")) {
				DikshaUtils.waitToBeClickableAndClick(Ub.getHeadteacher());
				DikshaUtils.waitToBeClickableAndClick(Ub.getContinueButton());
			}

			if (bmcpopup.getBoard().isDisplayed()) {
				checkIfRoleIsSelected = true;
				// actual2 = "User is able to select the roles successfully";
				actual2 = " User select role as a " + role + " successfully";
				expectedContinueButton = "True";
			}

		} finally {

			Listeners.customAssert("True", expectedRole, expected1, actual1);
			Listeners.customAssert("True", expectedContinueButton, expected2, actual2);
		}
		return role;
	}

	public static void bmcpopuphandle() throws InterruptedException {

		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		String expected1 = "Verify user should be able to see BMC fields successfully";
		String actual1 = "User is not able to see BMC fields";

		String expected2 = "Verify user should be able to select BMC values successfully";
		String actual2 = "User is not able to select BMC values";

		boolean checkBMCValue = false;
		boolean checkIfBMCIsSelected = false;

		String expectedSubmitButton = "NA";
		String expectedBMC = "NA";
		String BMCPopup = "NA";

		try {

			if (bmcpopup.getBMCHeading().isDisplayed()) {
				checkBMCValue = true;

				Assert.assertTrue(bmcpopup.getBoard().isDisplayed());
				Assert.assertTrue(bmcpopup.getMedium().isDisplayed());
				Assert.assertTrue(bmcpopup.getClasss().isDisplayed());

				actual1 = "User is able to see the BMC value successfully";
				expectedBMC = "True";
			}

			DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getBoard());
			DikshaUtils.waitToBeClickableAndClick(bmcpopup.getCbsc());
			Thread.sleep(4000);
			DikshaUtils.waitToBeClickableAndClick(bmcpopup.getMedium());
			DikshaUtils.waitToBeClickableAndClick(bmcpopup.getEnglish());

			Actions act = new Actions(driver);
			act.moveByOffset(50, 100).click().build().perform();
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getClasss());
			DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getClass2());

			act.moveByOffset(50, 100).click().build().perform();
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getBMCSubmit());
			Thread.sleep(1000);
			BMCPopup = popup.getbMCPopUp().getText();
			Assert.assertEquals(BMCPopup, "User preference updated successfully");
			Thread.sleep(2000);

			if (BMCPopup.equals("User preference updated successfully")) {
				checkIfBMCIsSelected = true;
				actual2 = "User is able to selected the BMC values successfully";
				expectedSubmitButton = "True";
			}

		} finally {

			Listeners.customAssert("True", expectedBMC, expected1, actual1);
			Listeners.customAssert("True", expectedSubmitButton, expected2, actual2);
		}
	}

	public static void locationpopuphandle(String UserRole) throws Exception {

		Useronboarding Ub = PageFactory.initElements(driver, Useronboarding.class);
		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		String expected1 = "Verify user is able to see Name And Role fields successfully";
		String actual1 = "User is not able to see Name And Role fields";

		String expected2 = "Verify user is able to submit location details successfully";
		String actual2 = "User is not able to submit location details";

		boolean checkSubmitButtonIsSelected = false;
		boolean checkRoleAndName = false;
		String expectedRoleAndName = "NA";
		String expectedSubmitButton = "NA";
		Thread.sleep(2000);

		try {

			if (Ub.getWelcomeToDikshaLocation().isDisplayed()) {
				checkRoleAndName = true;

				Assert.assertTrue(locationpopup.getGuestNameTextField().isDisplayed());
				String nameText = locationpopup.getGuestNameTextField().getAttribute("value");
				Assert.assertEquals(nameText, "Guest");
				Assert.assertTrue(locationpopup.getguestRole().isDisplayed());
				String Guestrole = locationpopup.getguestRole().getText();
				Assert.assertEquals(Guestrole, UserRole);
				Assert.assertTrue(locationpopup.getState().isDisplayed());
				Assert.assertTrue(locationpopup.getDistrict().isDisplayed());

				actual1 = "User is able to see  Name And Role fields successfully";
				expectedRoleAndName = "True";
			}

			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getState());
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getMaharashtraState());
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getDistrict());
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getAkolaDistrict());
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getSubmitButton());

			if (home.getHomeTab().isDisplayed()) {
				checkSubmitButtonIsSelected = true;

				actual2 = "user is able to submit location details successfully";
				expectedSubmitButton = "True";
			}

		} finally {

			Listeners.customAssert("True", expectedRoleAndName, expected1, actual1);
			Listeners.customAssert("True", expectedSubmitButton, expected2, actual2);
		}
	}

	public static void locationpopuphandle() throws Exception {

		Useronboarding Ub = PageFactory.initElements(driver, Useronboarding.class);
		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		String expected1 = "Verify user is able to see location popup fields successfully";
		String actual1 = "User is not able to see location popup fields";

		String expected2 = "Verify user is able to submit location details successfully";
		String actual2 = "User is not able to submit location details";

		boolean checkSubmitButtonIsSelected = false;
		boolean checkRoleAndName = false;
		String expectedRoleAndName = "NA";
		String expectedSubmitButton = "NA";
		Thread.sleep(2000);

		try {

			if (Ub.getWelcomeToDikshaLocation().isDisplayed()) {
				checkRoleAndName = true;

				Assert.assertTrue(locationpopup.getGuestNameTextField().isDisplayed());
				String nameText = locationpopup.getGuestNameTextField().getAttribute("value");
				Assert.assertEquals(nameText, "Guest");
				Assert.assertTrue(locationpopup.getguestRole().isDisplayed());
				String Guestrole = locationpopup.getguestRole().getText();
				// Assert.assertEquals(Guestrole,UserRole);
				Assert.assertTrue(locationpopup.getState().isDisplayed());
				Assert.assertTrue(locationpopup.getDistrict().isDisplayed());

				actual1 = "User is able to see location popup fields successfully";
				expectedRoleAndName = "True";
			}

			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getState());
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getMaharashtraState());
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getDistrict());
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getAkolaDistrict());
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getSubmitButton());

			if (home.getHomeTab().isDisplayed()) {
				checkSubmitButtonIsSelected = true;

				actual2 = "user is able to submit location details successfully";
				expectedSubmitButton = "True";
			}

		} finally {

			Listeners.customAssert("True", expectedRoleAndName, expected1, actual1);
			Listeners.customAssert("True", expectedSubmitButton, expected2, actual2);
		}
	}

	public static void locationpopuphandleWithGuestName() throws Exception {

		String Expected = "user able to change guest name as well as state and district value and updated on profile successfully";
		String actual = "user not able to get updated name as well as state and district value on profile page ";

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);

		try {
			locationpopup.getGuestNameTextField().clear();
			DikshaUtils.waitToBeClickableAndSendKeys(locationpopup.getGuestNameTextField(), "Custodian");

			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getState());
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getMaharashtraState());
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getDistrict());
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getAkolaDistrict());
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getSubmitButton());
			Thread.sleep(1000);
			actual = "user able to see updated guest name as well as state and district value on profile page successfully ";

		} finally {
			String homeText = home.getHomeTab() != null ? home.getHomeTab().getText() : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Home", homeText, Expected, actual);
		}

	}

	public static void login(String user) throws Exception {

		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home=null;
		String expect = user + " should be able to login successfully";
		String actual = "Unable to login as " + user;

		try {
			LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

			DikshaUtils.waitToBeVisibleAndClick(loginpage.getHeaderDropdown());
			DikshaUtils.waitToBeClickableAndClick(loginpage.getLogintab());

			String cred[] = excel.getCredentails(user);
			String username = cred[0];
			String password = cred[1];

			DikshaUtils.waitToBeClickableAndSendKeys(loginpage.getUserName(), username);
			DikshaUtils.waitToBeClickableAndSendKeys(loginpage.getPassword(), password);
			DikshaUtils.waitToBeClickableAndClick(loginpage.getLogin());
			Thread.sleep(5000);
			 home=HomePage.getHomeTab().getText();
			actual = user + " is able to login successfully";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Home", homeText, expect, actual);
		}
	}

	public static void logout(String user) throws Exception {
		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);
		String Explorebutton = null;
		String expect = user + " should be able to logout Successfully";
		String actual = "Unable to logout";
		try {

			Logout log = PageFactory.initElements(driver, Logout.class);

			DikshaUtils.waitToBeClickableAndClick(log.getCreatorIcon());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", log.getLogout());
			DikshaUtils.waitToBeClickableAndClick(log.getLogout());
			Thread.sleep(2000);
			Explorebutton = explore.getExplorebutton().getText();
			DikshaUtils.waitToBeVisibleAndClick(explore.getExplorebutton());
			actual = user + " is able to logout Successfully";
		} finally {
			String ExplorebuttonText = Explorebutton != null ? Explorebutton : "N/A";
			Listeners.customAssert("EXPLORE DIKSHA", ExplorebuttonText, expect, actual);

		}

	}

	public static void logout() throws Exception {

		Logout log = PageFactory.initElements(driver, Logout.class);
		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);
		String Explorebutton = null;

		String expected = "User should logout Successfully";
		String actual = "Unable to logout";
		try {

			DikshaUtils.waitToBeClickableAndClick(log.getCreatorIcon());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", log.getLogout());
			DikshaUtils.waitToBeClickableAndClick(log.getLogout());
			Thread.sleep(2000);
			Explorebutton = explore.getExplorebutton().getText();
			DikshaUtils.waitToBeVisibleAndClick(explore.getExplorebutton());

			actual = "Successfully logout";

		} finally {
			String ExplorebuttonText = Explorebutton != null ? Explorebutton : "N/A";
			System.out.println(ExplorebuttonText);
			Listeners.customAssert("EXPLORE DIKSHA", ExplorebuttonText, expected, actual);

		}

	}

	public static void Verify_Guest_user_is_able_to_edit_BMC_Values() throws Exception {

		userProfile guest = PageFactory.initElements(driver, userProfile.class);
		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);
		UserHomeTab home = PageFactory.initElements(driver, UserHomeTab.class);

		String expected = "Verify user should be able to edit BMC values successfully";
		String actual = "User is not able to to edit BMC values successfully";

		boolean checkValue = false;
		String expectedValue = "NA";

		try {

			if (home.gethomeTab().isDisplayed()) {
				checkValue = true;

				DikshaUtils.waitToBeClickableAndClick(guest.headerDropdown());
				DikshaUtils.waitToBeClickableAndClick(guest.getProfilebutton());
				DikshaUtils.waitToBeClickableAndClick(locationpopup.getLocationeditbutton());
				DikshaUtils.waitToBeVisibleAndClick(locationpopup.getguestRole());
				DikshaUtils.waitToBeClickableAndClick(locationpopup.getTeacher());
				DikshaUtils.waitToBeVisibleAndClick(locationpopup.getDistrict());
				DikshaUtils.waitToBeClickableAndClick(locationpopup.getAmravati());
				DikshaUtils.waitToBeClickableAndClick(locationpopup.getLocationSubmitButton());

				Thread.sleep(2000);

				String actualRoleName = locationpopup.getTeacherprofile().getText();
				String actualDistrictName = locationpopup.getTextAmravati().getText();

				Thread.sleep(2000);

				System.out.println(actualRoleName);
				System.out.println(actualDistrictName);

				Assert.assertEquals(actualRoleName, "Teacher");
				Assert.assertEquals(actualDistrictName, "Amravati");

				Thread.sleep(2000);

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", bmcpopup.getBMCeditbutton());
				Library.custom_click(bmcpopup.getBMCeditbutton(), "BMCEditbutton");
				Thread.sleep(1000);

				DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getBoard());
				DikshaUtils.waitToBeClickableAndClick(bmcpopup.getIGOT_Health());
				Thread.sleep(4000);
				DikshaUtils.waitToBeClickableAndClick(bmcpopup.getMedium());
				DikshaUtils.waitToBeClickableAndClick(bmcpopup.getGujarati());
				Thread.sleep(1000);

				Actions act = new Actions(driver);
				act.moveByOffset(50, 100).click().build().perform();
				Thread.sleep(1000);

				DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getClasss());
				DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getPharmacist());
				act.moveByOffset(50, 100).click().build().perform();
				Thread.sleep(1000);
				Library.custom_click(bmcpopup.getBMCSubmit(), "bmcsubmit");
				Thread.sleep(2000);

				String actualBoardName = bmcpopup.getIGOT_Health().getText();
				String actualMediumName = bmcpopup.getGujarati().getText();
				String actualClassName = bmcpopup.getPharmacist().getText();

				System.out.println(actualBoardName);
				System.out.println(actualMediumName);
				System.out.println(actualClassName);

				Assert.assertEquals(actualBoardName, "IGOT-Health");
				Assert.assertEquals(actualMediumName, "Gujarati");
				Assert.assertEquals(actualClassName, "Pharmacist");

				actual = "User able to able to edit BMC values successfully";
				expectedValue = "True";
			}

		} finally {

			Listeners.customAssert("True", expectedValue, expected, actual);

		}
	}

	public static void ValidateBMCFilterValueAsPerOnBoarding() throws Exception {

		userProfile guest = PageFactory.initElements(driver, userProfile.class);
		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		DikshaUtils.waitToBeVisibleAndClick(home.getTVClassesTab());
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		String actualBoardName = bmcpopup.getBoardValue().getText();
		String actualMediumName = bmcpopup.getMediumValue().getText();
		String actualClassName = bmcpopup.getClassValue().getText();

		Assert.assertEquals(actualBoardName, "CBSE/NCERT");
		Assert.assertEquals(actualMediumName, "English");
		Assert.assertEquals(actualClassName, "Class 2");

		DikshaUtils.waitToBeVisibleAndClick(home.getdigitalTextbookTab());
		Thread.sleep(2000);
		actualBoardName = bmcpopup.getBoardValue().getText();
		actualMediumName = bmcpopup.getMediumValue().getText();
		actualClassName = bmcpopup.getClassValue().getText();

		Assert.assertEquals(actualBoardName, "CBSE/NCERT");
		Assert.assertEquals(actualMediumName, "English");
		Assert.assertEquals(actualClassName, "Class 2");
	}

	public static void ChangePreferenceAsCBSC() throws Exception {

		userProfile guest = PageFactory.initElements(driver, userProfile.class);
		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		DikshaUtils.waitToBeVisibleAndClick(home.getHomeTab());
		DikshaUtils.waitToBeVisibleAndClick(home.getChnagePreferences());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getBoard());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getCbsc());
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getMedium());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getSelectPreferenceEngilsh());

		Actions act = new Actions(driver);

		act.moveByOffset(50, 100).click().build().perform();
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getClasss());
		DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getClass1());
		DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getClass2());
		act.moveByOffset(50, 100).click().build().perform();
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getBMCSubmit());

	}

	public static void ChangePreferenceAsOther() throws Exception {

		userProfile guest = PageFactory.initElements(driver, userProfile.class);
		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		DikshaUtils.waitToBeVisibleAndClick(home.getHomeTab());
		DikshaUtils.waitToBeVisibleAndClick(home.getChnagePreferences());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getBoard());
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getOther());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getMedium());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getSelectPreferenceEngilsh());

		Actions act = new Actions(driver);
		Robot rb = new Robot();

		act.moveByOffset(50, 100).click().build().perform();
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getClasss());
		DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getClass1());
		DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getClass2());
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getBMCSubmit());

	}

	public static void VerifyTheUserShouldBeAbleToEditTheSubmittedDetailsOptionInProfile() throws Exception {

		userProfile user = PageFactory.initElements(driver, userProfile.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		SubmitDetails sumbitdetails = PageFactory.initElements(driver, SubmitDetails.class);
		Thread.sleep(1000);

		String RequiredDetailsText = null;
		String expected = "User Able To Edit Submit Details";
		String actual = "Unable To Edit Submit Details ";

		try {

			DikshaUtils.waitToBeClickableAndClick(user.headerDropdown());
			DikshaUtils.waitToBeClickableAndClick(user.getProfilebutton());

			JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("arguments[0].scrollIntoView(true);",user.getSubmitDetails());
			js.executeScript("window.scrollBy(0, 500)");
			Thread.sleep(2000);
			sumbitdetails.getSubmitDetails().isDisplayed();
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(sumbitdetails.getSubmitDetails());
			DikshaUtils.waitToBeVisibleAndClick(sumbitdetails.getInstitutionTab());
			DikshaUtils.waitToBeClickableAndClick(sumbitdetails.getCbscTab());
			DikshaUtils.waitToBeClickableAndClick(sumbitdetails.getSubmitDetailCheckbox());
			Thread.sleep(1000);
			System.out.println(sumbitdetails.getSubmitDetailCheckbox());
			sumbitdetails.getProfileSubmitbutton().isDisplayed();
			Thread.sleep(2000);
			js.executeScript("window.scrollTo(0, 0)");

			RequiredDetailsText = sumbitdetails.getRequiredDetails().getText();
			Thread.sleep(2000);
			actual = "Edit Submit Details Successfully";

		} finally {
			String ValidateText = RequiredDetailsText != null ? RequiredDetailsText : "N/A";
			System.out.println(ValidateText);
			Listeners.customAssert("Required details", ValidateText, expected, actual);
		}
	}

	public static void VerifyTheUserIsAbleToUpdateTheBMCAndLocationDetails() throws Exception {

		userProfile user = PageFactory.initElements(driver, userProfile.class);
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);
		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(user.headerDropdown());
		DikshaUtils.waitToBeClickableAndClick(user.getProfilebutton());
		DikshaUtils.waitToBeClickableAndClick(locationpopup.getLocationeditbutton());
		DikshaUtils.waitToBeVisibleAndClick(locationpopup.getRole());
		DikshaUtils.waitToBeClickableAndClick(locationpopup.getparent());
		DikshaUtils.waitToBeClickableAndClick(locationpopup.getState());
		DikshaUtils.waitToBeClickableAndClick(locationpopup.getAndhraPradesh());
		DikshaUtils.waitToBeClickableAndClick(locationpopup.getDistrict());
		DikshaUtils.waitToBeClickableAndClick(locationpopup.getDistrictAlluriSitaRamaRaju());
		DikshaUtils.waitToBeClickableAndClick(locationpopup.getLocationSubmitButton());
		Thread.sleep(2000);

		String actualRoleName = locationpopup.getTextParent().getText();
		String actualDistrictName = locationpopup.getTextDistrict().getText();
		String actualStateName = locationpopup.getTextAP().getText();

		System.out.println(actualRoleName);
		System.out.println(actualDistrictName);
		System.out.println(actualStateName);

		Assert.assertEquals(actualRoleName, "Parent");
		Assert.assertEquals(actualDistrictName, "Alluri Sita Rama Raju");
		Assert.assertEquals(actualStateName, "Andhra Pradesh");

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView(true);",user.getBMCeditbutton());
		js.executeScript("window.scrollBy(0, 500)");

		// Library.custom_click(user.getBMCeditbutton(), "BMCeditbutton");
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getBMCeditbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getBoard());
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getCbsc());
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getMedium());
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getHindi());
		Actions act = new Actions(driver);
		act.moveByOffset(50, 100).click().build().perform();
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getClasss());
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getClass4());
		act.moveByOffset(50, 100).click().build().perform();
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getBMCSubmit());
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(user.getBackButton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(home.getHomeTab());
		Thread.sleep(5000);
		DikshaUtils.waitToBeClickableAndClick(home.getChnagePreferences());
		DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getBoard());
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getCbsc());
		DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getMedium());
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getEnglish());
		act.moveByOffset(50, 100).click().build().perform();
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getClasss());
		DikshaUtils.waitToBeClickableAndClick(bmcpopup.getClass2());
		act.moveByOffset(50, 100).click().build().perform();
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(bmcpopup.getBMCSubmit());
		Thread.sleep(2000);

		String actualBoardName = bmcpopup.getTextCbsc().getText();
		String actualMediumName = bmcpopup.getTextEnglish().getText();
		String actualClassName = bmcpopup.getTextClass2().getText();

		System.out.println(actualBoardName);
		System.out.println(actualMediumName);
		System.out.println(actualClassName);
//	        
//	        Assert.assertEquals(actualBoardName, "CBSE/NCERT");
//	        Assert.assertEquals(actualMediumName, "English");
//	        Assert.assertEquals(actualClassName, "Class 2"); 
//		  
//		 	 	 	 
	}

	public static void VerifyBMCUnderChangePreference() throws Exception {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);

		String expected = "Verify user should be able to change preference successfully";
		String actual = "User is unable to change preference";

		String validateBMC = "NA";
		boolean checkBMC = false;

		try {

			if (home.getHomeTab().isDisplayed()) {
				checkBMC = true;

				Thread.sleep(1000);
				DikshaUtils.waitToBeClickableAndClick(home.getHomeTab());
				Thread.sleep(2000);
				DikshaUtils.waitToBeClickableAndClick(home.getChnagePreferences());
				Thread.sleep(2000);
				String actualBoardName = bmcpopup.getCbsccheck().getText();
				String actualMediumName = bmcpopup.getEnglishcheck().getText();
				String actualClassName = bmcpopup.getClass2check().getText();

				Assert.assertEquals(actualBoardName, "CBSE");
				Assert.assertEquals(actualMediumName, "English");
				Assert.assertEquals(actualClassName, "Class 2");

				actual = "user is be able to change preference successfully";
				validateBMC = "True";
			}

		} finally {

			Listeners.customAssert("True", validateBMC, expected, actual);

		}

	}

	public static void VerifyUserShouldBeAbleToEditTheSubmittedDetails() throws Exception {

		userProfile user = PageFactory.initElements(driver, userProfile.class);
		UpdateProfile update = PageFactory.initElements(driver, UpdateProfile.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String updatedPopUp = null;
		String expected = "User should Update Details Successfully";
		String actual = "Unable to Update Details";
		try {

			DikshaUtils.waitToBeClickableAndClick(user.headerDropdown());
			DikshaUtils.waitToBeClickableAndClick(user.getProfilebutton());
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 1200)");

			// js.executeScript("arguments[0].scrollIntoView(true);",user.getBeforeUpdateButton());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(update.getBeforeUpdateButton());
			DikshaUtils.waitToBeClickableAndClick(update.getId());
			update.getId().clear();
			String Id = DikshaUtils.set_Content_Name("Updated_");
			DikshaUtils.waitToBeClickableAndSendKeys(update.getId(), Id);
			DikshaUtils.waitToBeClickableAndClick(update.getAfterUpdateButton());
			Thread.sleep(1000);
			// js.executeScript("arguments[0].scrollIntoView(true);",update.getUpdateIdText());
			// Thread.sleep(1000);

			// String actualIdName =update.getUpdateIdText().getText();
			// Assert.assertEquals(actualIdName, "Akash123");

			updatedPopUp = popup.getUpdatedPopup().getText();
			actual = "Update Details Successfully";
		} finally {

			String popupText = updatedPopUp != null ? updatedPopUp : "N/A";
			System.out.println(popupText);
			Listeners.customAssert("updated successfully", popupText, expected, actual);

		}

	}

	public static void validateObservationTab() throws Exception {

		String except = "User Should Able To See Observation Tab Successfully";
		String actual = "User Should Not Able To See Observation Tab Successfully";
		String Tab = null;

		userProfile user = PageFactory.initElements(driver, userProfile.class);
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
		Thread.sleep(1000);

		try {
			DikshaUtils.waitToBeClickableAndClick(user.headerDropdown());
			DikshaUtils.waitToBeClickableAndClick(user.getProfilebutton());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(locationpopup.getLocationeditbutton());
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getRole());
			DikshaUtils.waitToBeClickableAndClick(locationpopup.getHTOfficial());
			Thread.sleep(2000);
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getSubRole());
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getPrinciple());
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, 1000)");
			DikshaUtils.waitToBeClickableAndClick(locationpopup.getPersonalDetailSubmitButton());
			Thread.sleep(2000);

			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(user.getBackButton());
			Thread.sleep(2000);
			Assert.assertTrue(home.getObservationTab().isDisplayed());

			Tab = home.getObservationTab().getText();
			actual = "User Successfully See Observation Tab ";
		} finally {
			String observationtab = Tab != null ? Tab : "N/A";
			Listeners.customAssert("Observation", observationtab, except, actual);
		}
	}

	public static String addManagedUser() throws Exception {

		ManageUser adduser = PageFactory.initElements(driver, ManageUser.class);

		DikshaUtils.waitToBeClickableAndClick(adduser.getEnterName());
		String name = DikshaUtils.set_Content_Name("Abc_");
		adduser.getEnterName().sendKeys(name);
		DikshaUtils.waitToBeClickableAndClick(adduser.getAddUserTab());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(adduser.getAddUserTab());

		return name;
	}

	public static void CustodianUserIsAableToAddTheMUAUser() throws Exception {

		userProfile user = PageFactory.initElements(driver, userProfile.class);

		DikshaUtils.waitToBeClickableAndClick(user.headerDropdown());
		DikshaUtils.waitToBeClickableAndClick(user.getAddAnotherUserTab());

		for (int i = 0; i < 30; i++) {

			UserOnBoarding.addManagedUser();
		}

	}

	public static void validatelogout() throws Exception {
		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		LoginAsCustodian Log = PageFactory.initElements(driver, LoginAsCustodian.class);

		DikshaUtils.waitToBeClickableAndClick(Log.getHeaderDropdown());
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", log.getLogout());
		DikshaUtils.waitToBeClickableAndClick(log.getLogout());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(explore.getExplorebutton());
	}

	public static void registerHerePage() throws Exception {

		// ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);
		// Logout log = PageFactory.initElements(driver, Logout.class);
		LoginAsCustodian Log = PageFactory.initElements(driver, LoginAsCustodian.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		DikshaUtils.waitToBeClickableAndClick(Log.getHeaderDropdown());
		js.executeScript("arguments[0].scrollIntoView(true);", Log.getLogintab());
		Library.custom_click(Log.getLogintab(), "logintab");
		DikshaUtils.waitToBeClickableAndClick(Log.getRegisterHereButton());

	}

	public static String fakerEmail() throws Exception {
		ExcelDataProvider data = new ExcelDataProvider();
		String randomFakeEmail = "diksa##@yopmail.com";
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
		String email = fakeValuesService.bothify(randomFakeEmail);
//		data.updateData("TestData", email, "", "");
//		String readData = data.getExcelData(email, 1, 3);
//		System.out.println(readData);
		return email;
	}

	public static void ragisterWithDikshaUsingAnyEmails() throws Exception {

//		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		// UserOnBoarding enterFullName = new UserOnBoarding();
//		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);
//		Logout log = PageFactory.initElements(driver, Logout.class);

		LoginAsCustodian Log = PageFactory.initElements(driver, LoginAsCustodian.class);
		ExcelDataProvider emailPass = new ExcelDataProvider();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String year = "//div[contains(@role,'listbox')]//following::span";

//		DikshaUtils.waitToBeClickableAndClick(Log.getRegisterHereButton());
//		Thread.sleep(3000);
		String emailId = UserOnBoarding.fakerEmail();
		DikshaUtils.waitToBeClickableAndClick(Log.getEnterFullNameInRegisterPage());
		Thread.sleep(3000);
		DikshaUtils.waitToBeClickableAndSendKeys(Log.getEnterFullNameInRegisterPage(), emailId);
		DikshaUtils.waitToBeClickableAndClick(Log.getSelectYearDropdown());
		DikshaUtils.selectValueFromDropdown(driver, year, "1990");
		DikshaUtils.waitToBeClickableAndClick(Log.getContinueButton());
		DikshaUtils.waitToBeClickableAndClick(Log.getSubmitButton());
		DikshaUtils.waitToBeClickableAndClick(Log.getEmailRadioButton());
		DikshaUtils.waitToBeClickableAndSendKeys(Log.getEnterEmail(), emailId);
		String data = emailPass.getExcelData("TestData", 362, 1);
		System.out.println(data);
		DikshaUtils.waitToBeClickableAndSendKeys(Log.getSignUpPassWord(), data);
		DikshaUtils.waitToBeClickableAndSendKeys(Log.getSignUpReEnterPassWord(), data);
		js.executeScript("arguments[0].scrollIntoView(true);", Log.getContinueButton());
		DikshaUtils.waitToBeClickableAndClick(Log.getContinueButton());
		DikshaUtils.waitToBeClickableAndClick(Log.getContinueButton());
		Thread.sleep(3000);
		String url = config.get_yopmail_test_data();
		driver.switchTo().newWindow(WindowType.WINDOW);
		DikshaUtils.waitWebDriver(3000);
		driver.get(url);
		DikshaUtils.waitWebDriver(3000);
		DikshaUtils.waitToBeClickableAndSendKeys(Log.getEnterEmailToYopmail(), emailId);
		DikshaUtils.waitWebDriver(3000);
		DikshaUtils.waitToBeClickableAndClick(Log.getClickSearchInYopMail());
		DikshaUtils.waitWebDriver(3000);
		DikshaUtils.waitToBeClickableAndClick(Log.getRefreshButtonInYopmail());
		DikshaUtils.waitWebDriver(3000);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(0));
//		DikshaUtils.waitWebDriver(3000);
//		driver.switchTo().window(tabs.get(1));
//		DikshaUtils.waitWebDriver(3000);
		DikshaUtils.waitToBeClickableAndClick(Log.getRefreshButtonInYopmail());
		DikshaUtils.waitWebDriver(3000);
		driver.switchTo().frame(Log.getOtpFrame());
		DikshaUtils.waitWebDriver(3000);
		String otpSent = Log.getEmailOtpSentence().getText();
		System.out.println(otpSent);

	}

	public static void usePasswordForReportRequest(String user) throws Exception {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

		String cred[] = excel.getCredentails(user);
		String password = cred[1];

		 DikshaUtils.waitToBeClickableAndSendKeys(loginpage.getEnterReportPassword(),
		 password);
		 DikshaUtils.waitToBeClickableAndClick(loginpage.getReportRequestPassword());
		Thread.sleep(2000);
	}

	public static void validateloginPopUpInGuestUse(String user) throws Exception {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

		DikshaUtils.waitToBeClickableAndClick(loginpage.getvalidateLoginPopUpInGuestUser());

		String cred[] = excel.getCredentails(user);
		String username = cred[0];
		String password = cred[1];

		DikshaUtils.waitToBeClickableAndSendKeys(loginpage.getUserName(), username);
		DikshaUtils.waitToBeClickableAndSendKeys(loginpage.getPassword(), password);
		DikshaUtils.waitToBeClickableAndClick(loginpage.getLogin());
		Thread.sleep(2000);
	}
	
	public static void logoutWithOutExploreTab() throws Exception {

		 

        ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);
        Logout log = PageFactory.initElements(driver, Logout.class);

 

        // DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
        DikshaUtils.waitToBeClickableAndClick(log.getCreatorIcon());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", log.getLogout());
        DikshaUtils.waitToBeClickableAndClick(log.getLogout());
        Thread.sleep(2000);
        DikshaUtils.waitToBeVisibleAndClick(explore.getExplorebutton());
    }
}
