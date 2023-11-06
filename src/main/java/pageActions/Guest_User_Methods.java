package pageActions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObject.BMCPopup;
import pageObject.Filter;
import pageObject.FiltersInDiffrentTabs;
import pageObject.Groups;
import pageObject.GuestProfileSection;
import pageObject.HomePage;
import pageObject.LoginAsCustodian;
import pageObject.UserCourseCard;
import pageObject.UserHomeTab;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.Library;
import utility.Listeners;

public class Guest_User_Methods extends BaseClass {

	public static void validateLocationAndBMC() throws InterruptedException {

		String Expected = "verify user should see updated location and BMC value on profile page successfully";
		String actual = "user not able see updated location and BMC value on profile page  ";

		GuestProfileSection guest = PageFactory.initElements(driver, GuestProfileSection.class);
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		try {

			DikshaUtils.waitToBeVisibleAndClick(guest.getProfileIcon());
			DikshaUtils.waitToBeVisibleAndClick(guest.getProfileTab());

			Thread.sleep(2000);
			String actualProfileName = guest.getProfileName().getText();
			String actualRoleName = guest.getRole1().getText();
			String actualDistrictName = guest.getDistrict().getText();
			String actualStateName = guest.getState().getText();
			String actualBoardName = guest.getBoard().getText();
			String actualMediumName = guest.getMedium().getText();
			String actualClassName = guest.getClasss().getText();

			Assert.assertEquals(actualProfileName, "Custodian");
			Assert.assertEquals(actualRoleName, "Student");
			Assert.assertEquals(actualDistrictName, "Akola");
			Assert.assertEquals(actualStateName, "Maharashtra");
			Assert.assertEquals(actualBoardName, "CBSE/NCERT");
			Assert.assertEquals(actualMediumName, "English");
			Assert.assertEquals(actualClassName, "Class 2");

			actual = " updated location and BMC value on profile page verified successfully ";

		} finally {

			String ClassText = guest.getClasss() != null ? guest.getClasss().getText() : "N/A";
			System.out.println(ClassText);
			Listeners.customAssert("Class 2", ClassText, Expected, actual);
		}

	}

	public static void verifyPrimaryContentFilter() throws InterruptedException {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String expect = "Custodian user should be able to view primary filter Sucessfully";
		String actual = "Custodian user is unable to view primary filter  ";
		String verifyfilter = null;
		try {
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(home.getHomeTab());
		DikshaUtils.waitToBeClickableAndClick(home.getCbseTrainingsTab());
		DikshaUtils.waitToBeClickableAndClick(home.getSelectBoardDropdown());
		DikshaUtils.waitToBeClickableAndClick(home.getBoardSelectedCBSE());
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(home.getSelectPrimaryCategoryDropdown());
		DikshaUtils.waitToBeClickableAndClick(home.getPrimaryCategorySelected());
		Thread.sleep(1000);
		Assert.assertTrue(home.getVerifyCbseTrainingsFilter().isDisplayed());
		Assert.assertTrue(home.getVerifyContentPlaylistFilter().isDisplayed());
		Thread.sleep(1000);
		verifyfilter = home.getVerifyContentPlaylistFilter().getText();
		actual = "Custodian user is able to view primary filter Sucessfully";

	} finally {
		String Text =verifyfilter != null ? verifyfilter : "N/A";
		Listeners.customAssert(verifyfilter, Text, expect, actual);
	}
	}


	public static void verifyAdditionalCategoryFilter() throws InterruptedException {

		String expect = "Additional category filter should be displayed";
		String actual = "Additional category filter is not displayed";
		String additionalCategoryFilter = null;
		
		try {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(home.getHomeTab());
		DikshaUtils.waitToBeClickableAndClick(home.getCbseTrainingsTab());
		DikshaUtils.waitToBeClickableAndClick(home.getSelectBoardDropdown());
		DikshaUtils.waitToBeClickableAndClick(home.getBoardSelectedCBSE());
		js.executeScript("window.scrollBy(0, 400)");
		DikshaUtils.waitToBeClickableAndClick(home.getSelectPrimaryCategoryDropdown());
		DikshaUtils.waitToBeClickableAndClick(home.getPrimaryCategorySelected());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(home.getSelectAdditionalCategoryDropdown());
		DikshaUtils.waitToBeClickableAndClick(home.getAdditionalCategorySelected());
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0,0)");
		Assert.assertTrue(home.getVerifyCbseTrainingsFilter().isDisplayed());
		Assert.assertTrue(home.getVerifyContentPlaylistFilter().isDisplayed());
		Assert.assertTrue(home.getVerifyAdditionalCategoryFilter().isDisplayed());
		additionalCategoryFilter = home.getVerifyAdditionalCategoryFilter().getText();
		actual = "Additional category filter is displayed successfully";
		}finally {
			String Text = additionalCategoryFilter != null ? additionalCategoryFilter : "N/A";
			System.out.println(Text);
			Listeners.customAssert("Additional Categories", Text, expect, actual);
			
		}
	}

	public static void verifyAdditionalAndPrimaryContentTypeFilter() throws InterruptedException {

		String expect = "Additional and primary content type filter should be displayed";
		String actual = "Additional and primary content type filter are not displayed";
		String additionalCategoryFilter = null;
		try {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(home.getHomeTab());
		DikshaUtils.waitToBeClickableAndClick(home.getCbseTrainingsTab());
		DikshaUtils.waitToBeClickableAndClick(home.getSelectBoardDropdown());
		DikshaUtils.waitToBeClickableAndClick(home.getBoardSelectedCBSE());
		js.executeScript("window.scrollBy(0, 400)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(home.getSelectAdditionalCategoryDropdown());
		DikshaUtils.waitToBeClickableAndClick(home.getAdditionalCategorySelected());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(home.getSelectPrimaryCategoryDropdown());
		DikshaUtils.waitToBeClickableAndClick(home.getPrimaryCategorySelected());
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0,0)");
		Assert.assertTrue(home.getVerifyCbseTrainingsFilter().isDisplayed());
		Assert.assertTrue(home.getVerifyContentPlaylistFilter().isDisplayed());
		Assert.assertTrue(home.getVerifyAdditionalCategoryFilter().isDisplayed());
		additionalCategoryFilter = home.getVerifyAdditionalCategoryFilter().getText();
		actual = "Additional and primary content type filter are displayed successfully";
		}finally {
			String Text = additionalCategoryFilter != null ? additionalCategoryFilter : "N/A";
			System.out.println(Text);
			Listeners.customAssert("Additional Categories", Text, expect, actual);
			
		}
	}

	public static void validateBMCSForDiffrentTabs() throws Exception {

		String Expected = "verify user should see same facet filter in couses and Tv classes tab successfully";
		String actual = "user not able to see same facet filter in couses and Tv classes tab  ";

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		FiltersInDiffrentTabs filter = PageFactory.initElements(driver, FiltersInDiffrentTabs.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {

			Assert.assertTrue(filter.getBoard().isDisplayed());
			Assert.assertTrue(filter.getMedium().isDisplayed());
			Assert.assertTrue(filter.getClasss().isDisplayed());
			js.executeScript("window.scrollBy(0, 200)");
			Assert.assertTrue(filter.getSubject().isDisplayed());
			Assert.assertTrue(filter.getPublishedusertype().isDisplayed());
			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(filter.getCoursesTab());
			Thread.sleep(2000);
			Assert.assertTrue(filter.getBoard().isDisplayed());
			Assert.assertTrue(filter.getMedium().isDisplayed());
			Assert.assertTrue(filter.getClasss().isDisplayed());
			js.executeScript("window.scrollBy(0, 200)");
			Assert.assertTrue(filter.getSubject().isDisplayed());
			Assert.assertTrue(filter.getPublishedusertype().isDisplayed());
			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(filter.getTvClassesTab());
			Thread.sleep(2000);
			Assert.assertTrue(filter.getBoard().isDisplayed());
			Assert.assertTrue(filter.getMedium().isDisplayed());
			Assert.assertTrue(filter.getClasss().isDisplayed());
			js.executeScript("window.scrollBy(0, 200)");
			Assert.assertTrue(filter.getSubject().isDisplayed());
			Assert.assertTrue(filter.getPublishedusertype().isDisplayed());
			js.executeScript("window.scrollTo(0, 0)");

			actual = "user able to see same facet flter in couses and Tv classes tab successfully ";

		} finally {

			String homeText = home.getHomeTab() != null ? home.getHomeTab().getText() : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Home", homeText, Expected, actual);
		}
	}

	public static void validateBMCForMinor() throws Exception {
FiltersInDiffrentTabs filter = PageFactory.initElements(driver, FiltersInDiffrentTabs.class);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String expect = "Minor user should be able to validate BMC value Sucessfully";
		String actual = "Minor user is unable to validate BMC value  ";
		String verifyclass = null;
		try {
			DikshaUtils.waitToBeClickableAndClick(filter.getCoursesTab());
			Thread.sleep(3000);
			Assert.assertTrue(filter.getCBSENcert().isDisplayed());
			Assert.assertTrue(filter.getEnglishMedium().isDisplayed());
			js.executeScript("window.scrollBy(0, 50)");
			Assert.assertTrue(filter.getClass10().isDisplayed());
			js.executeScript("window.scrollTo(0, 0)");
			verifyclass = filter.getClass10().getText();
			actual = "Custodian user is able to validate BMC value Sucessfully";

		} finally {
			String Text = verifyclass != null ? verifyclass : "N/A";
			Listeners.customAssert(verifyclass, Text, expect, actual);
		}
	}

	public static void VerifyContentDisplayAsPerUserOnBoardingDetails() throws Exception {
		String expect = "Content should be displayed as per user on boarding details";
		String actual = "Content is not displayed as per user on boarding details";
		String Class10 = null;
		try {
		FiltersInDiffrentTabs filter = PageFactory.initElements(driver, FiltersInDiffrentTabs.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		DikshaUtils.waitToBeClickableAndClick(filter.getCoursesTab());
		Thread.sleep(1000);
		Assert.assertTrue(filter.getCBSENcert().isDisplayed());
		Assert.assertTrue(filter.getEnglishMedium().isDisplayed());
		js.executeScript("window.scrollBy(0, 50)");
		Assert.assertTrue(filter.getClass10().isDisplayed());
		js.executeScript("window.scrollTo(0, 0)");
		DikshaUtils.waitToBeClickableAndClick(filter.getTvClassesTab());
		Thread.sleep(1000);
		Assert.assertTrue(filter.getCBSENcert().isDisplayed());
		Assert.assertTrue(filter.getEnglishMedium().isDisplayed());
		js.executeScript("window.scrollBy(0, 50)");
		Assert.assertTrue(filter.getClass10().isDisplayed());
		js.executeScript("window.scrollTo(0, 0)");
		DikshaUtils.waitToBeClickableAndClick(filter.getDigitalTextbookTab());
		Thread.sleep(1000);
		Assert.assertTrue(filter.getCBSENcert().isDisplayed());
		Assert.assertTrue(filter.getEnglishMedium().isDisplayed());
		js.executeScript("window.scrollBy(0, 50)");
		Assert.assertTrue(filter.getClass10().isDisplayed());
		Class10 = filter.getClass10().getText();
		js.executeScript("window.scrollTo(0, 0)");
		actual = "Content's are displayed as per user on boarding details";
		}finally {
			String Text = Class10 != null ? Class10 : "N/A";
			System.out.println(Text);
			Listeners.customAssert("Class10", Text, expect, actual);
			
		}

	}

	public static void increaseScreenResolutionAndScrollTabs() throws Exception {

		String expect = "User should increase screen resolution and scrollTabs";
		String actual = "Unable to increase screen resolution and scrollTabs";
		String allTab = null;
		try {

		UserHomeTab home = PageFactory.initElements(driver, UserHomeTab.class);
		FiltersInDiffrentTabs filter = PageFactory.initElements(driver, FiltersInDiffrentTabs.class);
		Thread.sleep(1000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ADD);
		DikshaUtils.waitToBeClickableAndClick(home.gethomeTab());
		Thread.sleep(1000);
		Assert.assertTrue(home.getBrowseBySubject().isDisplayed());
		Thread.sleep(1000);
		Assert.assertTrue(filter.getDigitalTextbookTab().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(filter.getDigitalTextbookTab());
		Thread.sleep(1000);
		Assert.assertTrue(filter.getCoursesTab().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(filter.getCoursesTab());
		Thread.sleep(1000);
		Assert.assertTrue(filter.getTvClassesTab().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(filter.getTvClassesTab());
		Thread.sleep(1000);
		Assert.assertTrue(filter.getAllTab().isDisplayed());
		allTab = filter.getAllTab().getText();
		DikshaUtils.waitToBeClickableAndClick(filter.getAllTab());
		actual = "User increase screen resolution and scrollTabs successfully";
		}finally {
			String Text = allTab != null ? allTab : "N/A";
			System.out.println(Text);
			Listeners.customAssert("All", Text, expect, actual);
			
		}

	}

	public static void decreaseScreenResolutionAndScrollTabs() throws Exception {

		String expect = "User should decrease screen resolution and scrollTabs";
		String actual = "Unable to decrease screen resolution and scrollTabs";
		String allTab = null;
		try {

		UserHomeTab home = PageFactory.initElements(driver, UserHomeTab.class);
		FiltersInDiffrentTabs filter = PageFactory.initElements(driver, FiltersInDiffrentTabs.class);
		Thread.sleep(1000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_SUBTRACT);
		DikshaUtils.waitToBeClickableAndClick(home.gethomeTab());
		Thread.sleep(1000);
		Assert.assertTrue(home.getBrowseBySubject().isDisplayed());
		Thread.sleep(1000);
		Assert.assertTrue(filter.getDigitalTextbookTab().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(filter.getDigitalTextbookTab());
		Thread.sleep(1000);
		Assert.assertTrue(filter.getCoursesTab().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(filter.getCoursesTab());
		Thread.sleep(1000);
		Assert.assertTrue(filter.getTvClassesTab().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(filter.getTvClassesTab());
		Thread.sleep(1000);
		Assert.assertTrue(filter.getAllTab().isDisplayed());
		allTab = filter.getAllTab().getText();
		DikshaUtils.waitToBeClickableAndClick(filter.getAllTab());
		actual = "User decrease screen resolution and scrollTabs successfully";
		}finally {
			String Text = allTab != null ? allTab : "N/A";
			System.out.println(Text);
			Listeners.customAssert("All", Text, expect, actual);
			
		}

	}

	public static void verifyDetailsforCourseCard() throws Exception {
		String expect = "Image, Title, Subject, Publisher should display in course card";
		String actual = "Image, Title, Subject, Publisher is not display in course card";
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String homeTab = null;
		try {
		UserCourseCard course = PageFactory.initElements(driver, UserCourseCard.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(course.getCoursesTab());
		Thread.sleep(1000);
		Assert.assertTrue(course.getImage().isDisplayed());
		Assert.assertTrue(course.getTitle().isDisplayed());
		Assert.assertTrue(course.getSubject().isDisplayed());
		Assert.assertTrue(course.getPublisher().isDisplayed());
		homeTab = HomePage.getHomeTab().getText();
		actual = "Image, Title, Subject, Publisher is display in course card";
		}finally {
			String homeText = homeTab != null ? homeTab : "N/A";
			Listeners.customAssert("Home", homeText, expect, actual);
			
		}

	}

	public static void validateDiffrentSectionsUnderHomeTab() throws Exception {

		LoginAsCustodian Log = PageFactory.initElements(driver, LoginAsCustodian.class);
		UserHomeTab home = PageFactory.initElements(driver, UserHomeTab.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		String expected = "Verify user should be see diffrent sections under home tab successfully";
		String actual = "User is not able to see diffrent sections under home tab";

		boolean checkCategories = false;
		String expectedTab = null;
		try {

			if (home.gethomeTab().isDisplayed()) {
				checkCategories = true;

				DikshaUtils.waitToBeClickableAndClick(home.gethomeTab());
				Thread.sleep(2000);
				Assert.assertTrue(home.getBrowseBySubject().isDisplayed());
				js.executeScript("window.scrollBy(0, 200)");
				Assert.assertTrue(home.getBrowseByCategories().isDisplayed());
				js.executeScript("window.scrollBy(0, 400)");
				Thread.sleep(1000);
				// Assert.assertTrue(home.getBrowseByOtherCategories().isDisplayed());
				// js.executeScript("window.scrollBy(0, 200)");
				Assert.assertTrue(home.getRecentlyPublishedCourse().isDisplayed());
				js.executeScript("window.scrollTo(0, 0)");

				actual = "User able to see diffrent sections under home tab successfully";
				expectedTab = "True";
			}

		} finally {

			Listeners.customAssert("True", expectedTab, expected, actual);

		}
	}

	public static void validateCourseUnderContinueLearning() throws Exception {

		UserHomeTab home = PageFactory.initElements(driver, UserHomeTab.class);
		String verifyCourseName = null;
		String expect = "Custodian user should be able verify BMC value Sucessfully";
		String actual = "Custodian user is unable verify BMC value";
		try {
		Library.custom_click(home.gethomeTab(), "Home tab Click");
		Thread.sleep(2000);
		Assert.assertTrue(home.getContinueLearning().isDisplayed());
		Assert.assertTrue(home.getEnrolledCourseName().isDisplayed());
		verifyCourseName = home.getEnrolledCourseName().getText();

		actual = "Custodian user is able verify BMC value Sucessfully";
	} finally {

		String popupText = verifyCourseName != null ? verifyCourseName : "N/A";
		Listeners.customAssert(verifyCourseName, popupText, expect, actual);

	}
	}

	public static void VerifyProfileBMCValueForAnotherTab() throws Exception {

		FiltersInDiffrentTabs filter = PageFactory.initElements(driver, FiltersInDiffrentTabs.class);
		Filter filtertab = PageFactory.initElements(driver, Filter.class);
		LoginAsCustodian Log = PageFactory.initElements(driver, LoginAsCustodian.class);
		UserHomeTab home = PageFactory.initElements(driver, UserHomeTab.class);
		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);

		String expect = "Verify user should be able to see BMC value for another tab successfully";
		String actual = "user unable to see BMC value for another tab";
		String Home = null;
		
	
		try {

			DikshaUtils.waitToBeClickableAndClick(home.gethomeTab());
			DikshaUtils.waitToBeClickableAndClick(filter.getDigitalTextbookTab());
			Thread.sleep(1000);

			String BoardValue = bmcpopup.getBoardValue().getText();
			String MediumValue = bmcpopup.getMediumValue().getText();
			String ClassValue = bmcpopup.getClassValue().getText();

			Thread.sleep(1000);
			Assert.assertEquals(BoardValue, "CBSE/NCERT");
			Assert.assertEquals(MediumValue, "English");
			Assert.assertEquals(ClassValue, "Class 1");

			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(filtertab.getMedium());
			DikshaUtils.waitToBeClickableAndClick(filtertab.getMediumhindi());
			String BothMediumValue = bmcpopup.getMediumValueEnglishHIndi().getText();
			Thread.sleep(1000);
			Assert.assertEquals(BothMediumValue, "English, Hindi");
			DikshaUtils.waitToBeClickableAndClick(filter.getCoursesTab());
			Thread.sleep(1000);
			

			Assert.assertEquals(BoardValue, "CBSE/NCERT");
			Assert.assertEquals(MediumValue, "English");
			Assert.assertEquals(ClassValue, "Class 1");

			
			Home = home.gethomeTab().getText();
			actual = "user is able to see BMC value for another tab successfully";

		} finally {
			String homeText = Home != null ? Home : "N/A";
			Listeners.customAssert("Home", homeText, expect, actual);
		}

	}

	public static void validateKeyboardActions() throws Exception {

		String expect ="User should navigate using the keyboard keys inside every tab successfully";
		String actual ="Unable to navigate using the keyboard keys inside every tab";
		String allTab = null;
		try {

		UserHomeTab home = PageFactory.initElements(driver, UserHomeTab.class);
		FiltersInDiffrentTabs filter = PageFactory.initElements(driver, FiltersInDiffrentTabs.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(home.gethomeTab());
		Thread.sleep(1000);
		Robot r = new Robot();
		Assert.assertTrue(home.getBrowseBySubject().isDisplayed());

		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		Assert.assertTrue(filter.getDigitalTextbookTab().isDisplayed());
		r.keyRelease(KeyEvent.VK_ENTER);

		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		Assert.assertTrue(filter.getCoursesTab().isDisplayed());
		r.keyRelease(KeyEvent.VK_ENTER);

		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		Assert.assertTrue(filter.getTvClassesTab().isDisplayed());
		r.keyRelease(KeyEvent.VK_ENTER);

		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		Assert.assertTrue(filter.getAllTab().isDisplayed());
		r.keyRelease(KeyEvent.VK_ENTER);
		allTab = filter.getAllTab().getText();
		actual ="User successfully navigate using the keyboard keys inside every tab";
		}finally {
			String Text = allTab != null ? allTab : "N/A";
			System.out.println(Text);
			Listeners.customAssert("All", Text, expect, actual);
			
		}

	}

	public static void validateRecentlyPublishedCourse() throws Exception {
		LoginAsCustodian Log = PageFactory.initElements(driver, LoginAsCustodian.class);
		UserHomeTab home = PageFactory.initElements(driver, UserHomeTab.class);

		String recentlypublishedcoursesection = null;
		String expect = "Guest user should be able to view recently published course section Sucessfully";
		String actual = "Guest user is unable to view recently published course section ";
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			DikshaUtils.waitToBeClickableAndClick(home.gethomeTab());
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0, 1000)");
			Assert.assertTrue(home.getRecentlyPublishedCourse().isDisplayed());
			recentlypublishedcoursesection = home.getRecentlyPublishedCourse().getText();
			actual = "Guest user is able to view recently published course section Sucessfully";

		} finally {
			String Text = recentlypublishedcoursesection != null ? recentlypublishedcoursesection : "N/A";
			Listeners.customAssert(recentlypublishedcoursesection, Text, expect, actual);
		}
	}
	public static void vlidateChangePreference() throws Exception {

		UserHomeTab home = PageFactory.initElements(driver, UserHomeTab.class);

		BMCPopup changePref = new BMCPopup();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		DikshaUtils.waitToBeClickableAndClick(home.gethomeTab());
		// DikshaUtils.waitToBeClickableAndClick(home.getValidateClickChangePreference());
		// DikshaUtils.waitToBeClickableAndClick(home.getValidateClickChangePreference());
		DikshaUtils.waitWebDriver(3000);
		Assert.assertTrue(changePref.getValidateBoardInChangePref().isDisplayed());
		DikshaUtils.waitWebDriver(3000);
		Assert.assertTrue(changePref.getValidateMediumInChangePref().isDisplayed());
		DikshaUtils.waitWebDriver(3000);
		Assert.assertTrue(changePref.getValidateClassInChangePref().isDisplayed());
	}

	public static void myCourseSection() throws Exception {

		FiltersInDiffrentTabs filter = PageFactory.initElements(driver, FiltersInDiffrentTabs.class);
		String courseSection = null;
		String expect = "Custodian user should be able to see the course under my courses section Sucessfully";
		String actual = "Custodian user is unable to see the course under my courses section";
		try {
		
		DikshaUtils.waitToBeClickableAndClick(filter.getCoursesTab());
		Thread.sleep(1000);
		Assert.assertTrue(filter.getMyCourseSection().isDisplayed());
		courseSection=filter.getMyCourseSection().getText();
		actual = "Custodian user is able to see the course under my courses section Sucessfully";

		} finally {
			String Text =courseSection != null ? courseSection : "N/A";
			Listeners.customAssert(courseSection, Text, expect, actual);
		}
	}
	
public static void verifyGroupNameErrorForMissingfield() throws Exception {
		
		Groups groups=PageFactory.initElements(driver, Groups.class);
		
		String expect = "Group admin should be able to get group name error for missing field successfully";
	 	String actual = "Group admin is unable to get group name error for missing field ";
	 	String warningMsg=null;
	 	 try {
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
		Thread.sleep(1000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_SPACE);
		r.keyRelease(KeyEvent.VK_SPACE);
		Thread.sleep(1000);
		warningMsg = groups.getNameError().getText();
		Assert.assertEquals(warningMsg, "You have to enter the group name");
		 actual="Group admin is able to get group name error for missing field successfully";
		 }
		 finally {
			 String Text =warningMsg != null ? warningMsg : "N/A";
				Listeners.customAssert(warningMsg, Text, expect, actual);
		 }
	}
}
