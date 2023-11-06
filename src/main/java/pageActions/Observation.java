package pageActions;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageObject.HomePage;
import pageObject.LocationPopup;
import pageObject.userProfile;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.Listeners;

public class Observation extends BaseClass {

	public static void validateObservationTab() throws Exception {

		String expected = "Verify user should be able to See observation tab successfully";
		String actual = "User is not able to See observation tab";

		boolean checkTab = false;
		String expectedTab = null;

		try {

			userProfile user = PageFactory.initElements(driver, userProfile.class);
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
			Thread.sleep(1000);

			DikshaUtils.waitToBeClickableAndClick(user.headerDropdown());
			DikshaUtils.waitToBeClickableAndClick(user.getProfilebutton());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(locationpopup.getLocationeditbutton());
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getRole());
			DikshaUtils.waitToBeClickableAndClick(locationpopup.getHTOfficial());
			Thread.sleep(2000);
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getSubRole());
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getPrinciple());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 1000)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(locationpopup.getPersonalDetailSubmitButton());
			Thread.sleep(2000);

			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(user.getBackButton());
			Thread.sleep(2000);

			if (home.getObservationTab().isDisplayed()) {
				checkTab = true;
				actual = "User is able to see observation tab successfully";
				expectedTab = "True";
			}

		} finally {

			Listeners.customAssert("True", expectedTab, expected, actual);
		}
	}

	public static void SelectRoleAsTeacher() throws Exception {

		String expect = "User Select Role As Teacher Successfully";
		String actual = "User Not Able To Select Role As Teacher Successfully";
		String observationTab = null;

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
			DikshaUtils.waitToBeVisibleAndClick(locationpopup.getTeacher());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 1000)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(locationpopup.getPersonalDetailSubmitButton());
			Thread.sleep(2000);

			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(user.getBackButton());
			Thread.sleep(2000);

			WebElement observation = home.getObservationTab();
			if (observation != null) {
				System.out.println("Observation tab is not present.");
			} else {
				observationTab = "Observation Tab Is Present";
				System.out.println(observationTab);

				Assert.assertFalse(home.getObservationTab().isDisplayed());
			}

			actual = "User Should Not Able To See Observation Tab While Selecting Teacher Role";

		} finally {

			String ObservationTab = observationTab != null ? "observationTab" : "N/A";
			Listeners.customAssert("N/A", ObservationTab, expect, actual);
		}

	}

}
