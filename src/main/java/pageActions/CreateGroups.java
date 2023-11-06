package pageActions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObject.CourseConsumption;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import pageObject.Groups;
import pageObject.ValidatePopUp;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObject.CourseConsumption;
import pageObject.Groups;
import pageObject.UserHomeTab;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.Library;
import utility.Listeners;

public class CreateGroups extends BaseClass {

	public static void UserIsAbleTOCreateNewGroupsAndVerify() throws Exception {

		
		WebElement memberAdded = null;
		String expect = "Discussion Forum Is Disabled";
		String actual = "Discussion Forum Is Not Deleted";
		Groups groups = PageFactory.initElements(driver, Groups.class);

		try {
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());
		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
		String Groupname = DikshaUtils.set_Content_Name("GroupName_");
		groups.getGroupName().sendKeys(Groupname);

		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
		DikshaUtils.waitToBeClickableAndClick(groups.getDigitalTextbook());
		DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
//		 Actions actions = new Actions(driver);
//		 actions.moveToElement(groups.getOverTheBook()).perform();
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectBook());

		System.out.println("Group Created and Successfully TextBook Added");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(groups.getAddMember());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getIdCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getSearchId());
		Thread.sleep(1000);
		groups.getSearchId().sendKeys("creatorprod_uvae");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getVerifyId());
		DikshaUtils.waitToBeVisibleAndClick(groups.getIdSelected());

		System.out.println("Member Added Successfully");
		Thread.sleep(3000);

		memberAdded = driver.findElement(By.xpath("//span[text()='Contentcreatorprod‎']"));
		Thread.sleep(2000);

		actual = "Discussion Forum Is Deleted";
	} finally {
		String memberAddedText = memberAdded != null ? memberAdded.getText() : "N/A";
		System.out.println(memberAddedText);
		Listeners.customAssert("Contentcreatorprod", memberAddedText, expect, actual);
	}
	

	}

	public static void AdminAddActivityAsCourse() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Group admin should be able to add activity as course successfully";
		String actual = "Group admin is unable to add activity";
		String ActivityAddedPopup = null;

		try {

			DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
			DikshaUtils.waitToBeClickableAndClick(groups.getCourse());
			DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
			DikshaUtils.waitToBeVisibleAndClick(groups.getSelectBook());

			Thread.sleep(2000);
			ActivityAddedPopup = popup.getActivityAddedPopup().getText();
			// Assert.assertEquals(ActivityAddedPopup, "Activity added successfully");

			Thread.sleep(2000);
			actual = "Group admin is able to add activity as course successfully";

		} finally {
			String Text = popup.getActivityAddedPopup() != null ? popup.getActivityAddedPopup().getText() : "N/A";
			Listeners.customAssert(ActivityAddedPopup, Text, expect, actual);
		}

	}

	public static void AdminAddActivityAsPracticeQuestionSet() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Admin should be able to add activity as practice questionset successfully";
		String actual = "Admin is unable to add activity";
		String ActivityAddedPopup = null;

		try {

			DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
			DikshaUtils.waitToBeClickableAndClick(groups.getPractiseQuestionSet());
			DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
			DikshaUtils.waitToBeVisibleAndClick(groups.getSelectBook());

			Thread.sleep(2000);
			ActivityAddedPopup = popup.getActivityAddedPopup().getText();
			Assert.assertEquals(ActivityAddedPopup, "Activity added successfully");
			Thread.sleep(1000);

			actual = "Admin is able to add activity as practice questionset successfully";

		} finally {
			String Text = popup.getActivityAddedPopup() != null ? popup.getActivityAddedPopup().getText() : "N/A";
			Listeners.customAssert(ActivityAddedPopup, Text, expect, actual);
		}
	}

	public static void AdminAddActivityAsLearningModule() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Admin should be able to add activity as learning module successfully";
		String actual = "Admin is unable to add activity";
		String ActivityAddedPopup = null;

		try {

			DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
			DikshaUtils.waitToBeClickableAndClick(groups.getLearningModule());
			DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
			DikshaUtils.waitToBeVisibleAndClick(groups.getSelectBook());

			Thread.sleep(2000);
			ActivityAddedPopup = popup.getActivityAddedPopup().getText();
			Assert.assertEquals(ActivityAddedPopup, "Activity added successfully");
			Thread.sleep(1000);

			actual = "Admin is able to add activity as learning module successfully";

		} finally {
			String Text = popup.getActivityAddedPopup() != null ? popup.getActivityAddedPopup().getText() : "N/A";
			Listeners.customAssert(ActivityAddedPopup, Text, expect, actual);
		}
	}

	public static void AdminAddActivityAsExplanationContent() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Admin should be able to add activity as explanation content successfully";
		String actual = "Admin is unable to add activity";
		String ActivityAddedPopup = null;

		try {

			DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
			DikshaUtils.waitToBeClickableAndClick(groups.getExplanationContent());
			DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
			DikshaUtils.waitToBeVisibleAndClick(groups.getSelectBook());

			Thread.sleep(2000);
			ActivityAddedPopup = popup.getActivityAddedPopup().getText();
			Assert.assertEquals(ActivityAddedPopup, "Activity added successfully");
			Thread.sleep(1000);

			actual = "Admin is able to add activity as explanation content successfully";

		} finally {
			String Text = popup.getActivityAddedPopup() != null ? popup.getActivityAddedPopup().getText() : "N/A";
			Listeners.customAssert(ActivityAddedPopup, Text, expect, actual);
		}
	}

	public static void AdminAddActivityAsPDFTextbook() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Admin should be able to add activity as PDF textbook successfully";
		String actual = "Admin is unable to add activity";
		String ActivityAddedPopup = null;

		try {
			DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
			DikshaUtils.waitToBeClickableAndClick(groups.getPDFTextbook());
			DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
			DikshaUtils.waitToBeVisibleAndClick(groups.getSelectBook());

			Thread.sleep(2000);
			ActivityAddedPopup = popup.getActivityAddedPopup().getText();
			Assert.assertEquals(ActivityAddedPopup, "Activity added successfully");
			Thread.sleep(1000);

			actual = "Admin is able to add activity as PDF textbook successfully";

		} finally {
			String Text = popup.getActivityAddedPopup() != null ? popup.getActivityAddedPopup().getText() : "N/A";
			Listeners.customAssert(ActivityAddedPopup, Text, expect, actual);
		}
	}

	public static void AdminAddActivityAsTeachingResources() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Admin should be able to add activity as teaching resources successfully";
		String actual = "Admin is unable to add activity";
		String ActivityAddedPopup = null;

		try {
			DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
			DikshaUtils.waitToBeClickableAndClick(groups.getTeachingResource());
			DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
			DikshaUtils.waitToBeVisibleAndClick(groups.getSelectBook());

			Thread.sleep(2000);
			ActivityAddedPopup = popup.getActivityAddedPopup().getText();
			Assert.assertEquals(ActivityAddedPopup, "Activity added successfully");
			Thread.sleep(1000);

			actual = "Admin is able to add activity as teaching resources successfully";

		} finally {
			String Text = popup.getActivityAddedPopup() != null ? popup.getActivityAddedPopup().getText() : "N/A";
			Listeners.customAssert(ActivityAddedPopup, Text, expect, actual);
		}
	}

	public static void AdminAddActivityAsDigitalTextbook() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Admin should be able to add activity as digital textbook successfully";
		String actual = "Admin is unable to add activity";
		String ActivityAddedPopup = null;

		try {
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
			DikshaUtils.waitToBeClickableAndClick(groups.getDigitalTextbook());
			DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
			DikshaUtils.waitToBeVisibleAndClick(groups.getSelectBook());

			Thread.sleep(2000);
			ActivityAddedPopup = popup.getActivityAddedPopup().getText();
			Assert.assertEquals(ActivityAddedPopup, "Activity added successfully");
			Thread.sleep(1000);

			actual = "Admin is able to add activity as digital textbook successfully";

		} finally {
			String Text = popup.getActivityAddedPopup() != null ? popup.getActivityAddedPopup().getText() : "N/A";
			Listeners.customAssert(ActivityAddedPopup, Text, expect, actual);
		}
	}

	public static void AdminSearchActivityBasedOnDoId(String DoId) throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
		DikshaUtils.waitToBeClickableAndClick(groups.getCourse());
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getSearchActivity(), DoId);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSearchActivityButton());
		Thread.sleep(2000);
	}

	public static void AdminAddActivityBasedOnCourseName(String Name) throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
		DikshaUtils.waitToBeClickableAndClick(groups.getCourse());
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getSearchActivity(), Name);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSearchActivityButton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectBook());

	}

	public static void AdminSearchActivityBasedOnKeywords() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
		DikshaUtils.waitToBeClickableAndClick(groups.getCourse());
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getSearchActivity(), "b326epdf");
		DikshaUtils.waitToBeVisibleAndClick(groups.getSearchActivityButton());
		Thread.sleep(2000);

	}

	public static void AdminAbleToViewActivityOfTheCourse() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
		DikshaUtils.waitToBeClickableAndClick(groups.getCourse());
		DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
		DikshaUtils.waitToBeVisibleAndClick(groups.getViewActivity());

	}

	public static void AdminTryToConsumeCourseContentBeforeAddingInGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getJoinCourseContent());
		Thread.sleep(1000);
//	Alert alert = driver.switchTo().alert();
//	alert.accept();
		Assert.assertTrue(groups.getJoinCourseMessage().isDisplayed());

	}

	public static void AbleToAddTextbookInGroup() throws Exception {

		Groups groups=PageFactory.initElements(driver, Groups.class);
		ValidatePopUp validate=PageFactory.initElements(driver, ValidatePopUp.class);
		
		String expect = "Group admin should be able to add activity except the course successfully";
	 	String actual = "Group admin is unable to add activity except the course ";
	 	String AddPopUp=null;
	 	 try {
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeVisibleAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());
		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
		String Groupname=DikshaUtils.set_Content_Name("GroupName_");
		groups.getGroupName().sendKeys(Groupname);
		
		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
		DikshaUtils.waitToBeClickableAndClick(groups.getDigitalTextbook());
		DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectBook());
		Thread.sleep(1000);
		AddPopUp = validate.getActivityAddedPopup().getText();
		Assert.assertEquals(AddPopUp, "Activity added successfully");
		actual="Group admin is able to add activity except the course successfully";
		 }
		 finally {
			 String Text =AddPopUp != null ? AddPopUp : "N/A";
				Listeners.customAssert(AddPopUp, Text, expect, actual);
		 }
		
	}

	public static void VerifyUserDisplayedEnableDiscussionsOption() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());
		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
		String Groupname = DikshaUtils.set_Content_Name("GroupName_");
		groups.getGroupName().sendKeys(Groupname);
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getEnableOption().isDisplayed());
		System.out.println("Enabled discussion option is Displayed");

		DikshaUtils.waitToBeVisibleAndClick(groups.getEnableOption());
		Actions act = new Actions(driver);
		act.moveByOffset(50, 100).click().build().perform();
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		Thread.sleep(1000);

		Assert.assertTrue(groups.getCategories().isDisplayed());
		Assert.assertTrue(groups.getTags().isDisplayed());
		Assert.assertTrue(groups.getMyDiscussion().isDisplayed());

		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getMyDiscussion());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getRecentposts().isDisplayed());
		Assert.assertTrue(groups.getBestposts().isDisplayed());
		Assert.assertTrue(groups.getSavedposts().isDisplayed());
		Assert.assertTrue(groups.getUpvoted().isDisplayed());
		Assert.assertTrue(groups.getDownvoted().isDisplayed());

		DikshaUtils.waitToBeClickableAndClick(groups.getCloseButtoninForum());
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		DikshaUtils.waitToBeVisibleAndClick(groups.getDeleteGroup());
		DikshaUtils.waitToBeVisibleAndClick(groups.getDeleteButtonInDeleteGroupPopUp());

	}

	public static void ValidateFieldInsideTheDiscussionsOption() throws Exception {

		String expected = "Verify user should be able to see field inside the discussions option";
		String actual = "User is not able to see field inside the discussions option";

		boolean checkFields = false;
		String expectedField = null;

		Groups groups = PageFactory.initElements(driver, Groups.class);
		Thread.sleep(1000);

		try {

			if (groups.getForumOption().isDisplayed()) {
				checkFields = true;

				DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
				Thread.sleep(1000);
				Assert.assertTrue(groups.getCategories().isDisplayed());
				Assert.assertTrue(groups.getTags().isDisplayed());
				Assert.assertTrue(groups.getMyDiscussion().isDisplayed());
				Thread.sleep(1000);
				DikshaUtils.waitToBeVisibleAndClick(groups.getMyDiscussion());
				Thread.sleep(1000);
				Assert.assertTrue(groups.getRecentposts().isDisplayed());
				Assert.assertTrue(groups.getBestposts().isDisplayed());
				Assert.assertTrue(groups.getSavedposts().isDisplayed());
				Assert.assertTrue(groups.getUpvoted().isDisplayed());
				Assert.assertTrue(groups.getDownvoted().isDisplayed());

			}

			actual = "User is able to see field inside the discussions option successfully";
			expectedField = "True";

		} finally {

			Listeners.customAssert("True", expectedField, expected, actual);
		}
	}

	public static void VerifyUserDisplayedDisableDiscussionsOption() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());
		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
		String Groupname = DikshaUtils.set_Content_Name("GroupName_");
		groups.getGroupName().sendKeys(Groupname);

		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getEnableOption().isDisplayed());
		System.out.println("Enabled discussion option is Displayed");

		DikshaUtils.waitToBeVisibleAndClick(groups.getEnableOption());
		Actions act = new Actions(driver);
		act.moveByOffset(50, 100).click().build().perform();
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		DikshaUtils.waitToBeVisibleAndClick(groups.getDisableOption());
		DikshaUtils.waitToBeVisibleAndClick(groups.getDisableOptionPopup());
//		Thread.sleep(2000);
//		boolean ForumOptionNotDisplayed = !groups.getForumOption().isDisplayed();
//		if (ForumOptionNotDisplayed) {
//            System.out.println("Element is not displayed on the page.");
//		}
//		else {
//             System.out.println("Element is displayed on the page.");
//        }
//		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		DikshaUtils.waitToBeVisibleAndClick(groups.getEnableOption());

	}

	public static void VerifyCloseOptionIsDisplayed() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());
		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
		String Groupname = DikshaUtils.set_Content_Name("GroupName_");
		groups.getGroupName().sendKeys(Groupname);

		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getEnableOption().isDisplayed());
		System.out.println("Enabled discussion option is Displayed");

		DikshaUtils.waitToBeVisibleAndClick(groups.getEnableOption());
		Actions act = new Actions(driver);
		act.moveByOffset(50, 100).click().build().perform();
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getDiscussionCloseButton());
		System.out.println("Successfully clicked on Close Button");
		Thread.sleep(1000);
		Assert.assertTrue(groups.getAddActivity().isDisplayed());
	}

	public static void VerifyCloseOptionIsDisplayedInDiscussionForum() throws Exception {

		String expected1 = "Verify user should be able to see close option In discussion forum";
		String actual1 = "User is not able to see close option In discussion forum";

		boolean checkCloseButton = false;
		String expectedCloseButton = null;
		
		Groups groups = PageFactory.initElements(driver, Groups.class);

		try {
			DikshaUtils.waitForElementToBeVisible(groups.getForumOption());
			if (groups.getForumOption().isDisplayed()) {
				checkCloseButton = true;

				Thread.sleep(1000);
				DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
				Thread.sleep(1000);
				DikshaUtils.waitToBeVisibleAndClick(groups.getDiscussionCloseButton());
				System.out.println("Successfully clicked on Close Button");
//				Thread.sleep(1000);
//				Assert.assertTrue(groups.getAddActivity().isDisplayed());

			}

			actual1 = "User is able to see close option In discussion forum";
			expectedCloseButton = "True";

		} finally {

//			Listeners.customAssert("True", expectedCloseButton, expected1, actual1);
		}

	}

	public static void enableTheDiscussionForumOnCreatedCourse() throws InterruptedException {
		WebElement DForum = null;
		String expect = "Catagories option is Displayed Successfully";
		String actual = "Catagories option is Not Displayed Displayed";
		try {
			Groups groups = PageFactory.initElements(driver, Groups.class);
			DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
			DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
			DikshaUtils.waitToBeClickableAndClick(groups.getExistingGroup());
			DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
			Thread.sleep(1000);
			Assert.assertTrue(groups.getEnableOption().isDisplayed());
			System.out.println("Enabled discussion option is Displayed");
			DikshaUtils.waitToBeVisibleAndClick(groups.getEnableOption());
			Actions act = new Actions(driver);
			act.moveByOffset(50, 100).click().build().perform();
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
			Thread.sleep(1000);

			DForum = driver.findElement(By.xpath("//a[text()='Categories']"));
			Thread.sleep(2000);

			Assert.assertTrue(groups.getCategories().isDisplayed());
			System.out.println("Catagories option is Displayed");

			actual = "Catagories option is Displayed";

		} finally {

			String DFText = DForum != null ? DForum.getText() : "N/A";
			System.out.println(DFText);
			Listeners.customAssert("Categories", DFText, expect, actual);
		}

	}

	public static void createDiscussionForExistingGroup() throws InterruptedException {
		WebElement DFDeleted = null;
		String expect = "Discussion Forum Is Deleted Successfully";
		String actual = "Discussion Forum Is Not Deleted";
		try {
			Groups groups = PageFactory.initElements(driver, Groups.class);
			DikshaUtils.waitToBeVisibleAndClick(groups.getDF_ForGroup());
			DikshaUtils.waitToBeVisibleAndClick(groups.getbtnStrartDF());
			groups.getenterDFTopic().sendKeys("This is a Discussion Forum");
			groups.getenterElaborateQuestion().sendKeys("This is Elaborates Discussion Forum");
			groups.getenterTag().sendKeys("Discussion", Keys.ENTER);
			DikshaUtils.waitToBeVisibleAndClick(groups.getbtnSubmit());
			DikshaUtils.waitToBeVisibleAndClick(groups.getclkCreatedDiscussion());
			DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(groups.getbtnEdit());
			groups.getenterDFTopic().clear();
			groups.getenterDFTopic().sendKeys("This is a Discussion Forum Update");
			groups.getenterElaborateQuestion().clear();
			groups.getenterElaborateQuestion().sendKeys("This is Elaborates Discussion Forum Update");
			DikshaUtils.waitToBeVisibleAndClick(groups.getbtnUpdate());
			Thread.sleep(2000);
			Assert.assertTrue(groups.getAssertDFUpdated().isDisplayed());
			System.out.println("Discussion Forum Updated Successfully By Group Admin");
			Thread.sleep(2000);
			DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(groups.getbtnDelete());
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			Assert.assertTrue(groups.getAssertDFDeleted().isDisplayed());
			System.out.println("Discussion Forum Deleted Successfully By Group Admin");

			Thread.sleep(2000);

			DFDeleted = driver.findElement(By.xpath("//div[text()='No Data']"));
			Thread.sleep(2000);

			actual = "Discussion Forum Is Deleted";
		} finally {
			String NoDataText = DFDeleted != null ? DFDeleted.getText() : "N/A";
			System.out.println(NoDataText);
			Listeners.customAssert("No Data", NoDataText, expect, actual);
		}
	}

	public static void DisableDiscussionForum() throws InterruptedException {
		
		WebElement AddActivity = null;
		String expect = "Discussion Forum Is Disabled";
		String actual = "Discussion Forum Is Not Deleted";
//		Groups groups = PageFactory.initElements(driver, Groups.class);
//		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnEdit());
//		groups.getenterDFTopic().clear();
//		groups.getenterDFTopic().sendKeys("This is a Discussion Forum Update");
//		groups.getenterElaborateQuestion().clear();
//		groups.getenterElaborateQuestion().sendKeys("This is Elaborates Discussion Forum Update");
//		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnUpdate());
//		Thread.sleep(2000);
//		Assert.assertTrue(groups.getAssertDFUpdated().isDisplayed());
//		System.out.println("Discussion Forum Updated Successfully By Group Admin");
//		Thread.sleep(2000);
//		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
//		Thread.sleep(1000);
//		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnDelete());
//		driver.switchTo().alert().accept();
//		Thread.sleep(1000);
//		Assert.assertTrue(groups.getAssertDFDeleted().isDisplayed());
//		System.out.println("Discussion Forum Deleted Successfully By Group Admin");
		try {
		Groups groups=PageFactory.initElements(driver, Groups.class);
		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionCloseButton());
		DikshaUtils.waitToBeClickableAndClick(groups.getExistingGroup());
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getDisableOption().isDisplayed());
		System.out.println("Disabled discussion option is Displayed");
		DikshaUtils.waitToBeVisibleAndClick(groups.getDisableOption());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getDisableOptionPopup());
		
		Thread.sleep(3000);

		AddActivity = driver.findElement(By.xpath("//button[text()=' Add activity ']"));
		Thread.sleep(2000);

		actual = "Discussion Forum Is Deleted";
	} finally {
		String AddActivityText = AddActivity != null ? AddActivity.getText() : "N/A";
		System.out.println(AddActivityText);
		Listeners.customAssert("Add activity", AddActivityText, expect, actual);
	}
	}

	public static void GuestUserAbleTOSeeMyGroupsOption() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getMyGropus().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(groups.getCloseheaderDropdown());
		Thread.sleep(1000);

	}

	public static void UserAbleTOSeeMyGroupsOption() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getMyGropus().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		Thread.sleep(1000);

	}

	public static String ValidateCreateGroupsPopup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeVisibleAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());
		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
		String Groupname = DikshaUtils.set_Content_Name("GroupName_");
		groups.getGroupName().sendKeys(Groupname);

		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
		Thread.sleep(2000);

		String GroupCreatedsuccessfullyPopup = popup.getCreateGroupsPopup().getText();
		Assert.assertEquals(GroupCreatedsuccessfullyPopup, "Group created successfully");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());

		return Groupname;
	}

	public static void ValidateCreateGroupOption() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeVisibleAndClick(groups.getCrossTab());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getBeforeCreateGroupsButton().isDisplayed());

	}

	public static void ValidateCreateGroupPopupWithLabelText() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());

		Thread.sleep(1000);
		Assert.assertTrue(groups.getGroupName().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
		String Groupname = DikshaUtils.set_Content_Name("GroupName_");
		groups.getGroupName().sendKeys(Groupname);

		Thread.sleep(1000);
		Assert.assertTrue(groups.getDescription().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(groups.getDescription());
		groups.getDescription().sendKeys("Description");

		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
		Thread.sleep(2000);
		String GroupCreatedsuccessfullyPopup = popup.getCreateGroupsPopup().getText();
		Assert.assertEquals(GroupCreatedsuccessfullyPopup, "Group created successfully");
		Thread.sleep(1000);
	}

	public static void UserAbleToAddMemberInGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Group admin should be able to add member successfully";
		String actual = "Group admin is unable to add member";
		String GroupMemberAddedPopup = null;

		try {

			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(groups.getAddMember());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(groups.getIdCrossTab());
			DikshaUtils.waitToBeClickableAndClick(groups.getSearchId());

			Thread.sleep(1000);// ashishdubey_pzhh //creatorprod_uvae
			groups.getSearchId().sendKeys("creatorprod_uvae");
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(groups.getVerifyId());
			DikshaUtils.waitToBeVisibleAndClick(groups.getIdSelected());

			Thread.sleep(2000);

			GroupMemberAddedPopup = popup.getGroupMemberAddedPopup().getText();
			Assert.assertEquals(GroupMemberAddedPopup, "Contentcreatorprod added successfully");
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(groups.getGroupBackButton());
			actual = "Group admin is able to add member successfully";

		} finally {
			String Text = popup.getGroupMemberAddedPopup() != null ? popup.getGroupMemberAddedPopup().getText() : "N/A";
			Listeners.customAssert(GroupMemberAddedPopup, Text, expect, actual);
		}

	}

	public static void UserAbleToAddTwoMemberInGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getAddMember());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getIdCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getSearchId());
		Thread.sleep(1000);
		groups.getSearchId().sendKeys("produser1");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getVerifyId());
		DikshaUtils.waitToBeVisibleAndClick(groups.getIdSelected());

		Thread.sleep(2000);
//			String GroupMemberAddedPopup = popup.getGroupMemberAddedPopup().getText();
//	        Assert.assertEquals(GroupMemberAddedPopup, "Contentcreatorprod added successfully");
//	        Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getGroupBackButton());

		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getAddMember());
		DikshaUtils.waitToBeClickableAndClick(groups.getSearchId());
		Thread.sleep(1000);
		groups.getSearchId().sendKeys("produser2");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getVerifyId());
		DikshaUtils.waitToBeVisibleAndClick(groups.getIdSelected());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getGroupBackButton());

	}

	public static void AdminAddAndRemoveActivityFromGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
		DikshaUtils.waitToBeClickableAndClick(groups.getDigitalTextbook());
		DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectBook());

		Thread.sleep(2000);
		String ActivityAddedPopup = popup.getActivityAddedPopup().getText();
		Assert.assertEquals(ActivityAddedPopup, "Activity added successfully");
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getKababMenuForTextbook());
		DikshaUtils.waitToBeClickableAndClick(groups.getRemoveActivity());
		DikshaUtils.waitToBeVisibleAndClick(groups.getConfirmRemoveActivity());

		Thread.sleep(2000);
		String ActivityRemovePopup = popup.getActivityRemovePopup().getText();
		Assert.assertEquals(ActivityRemovePopup, "Activity removed for the group successfully");
		Thread.sleep(1000);

	}

	public static void AdminAddActivityInTheGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Admin should be able to add activity in the group successfully";
		String actual = "Admin is unable to add activity in the group";
		String ActivityAddedPopup = null;

		try {

			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
			DikshaUtils.waitToBeClickableAndClick(groups.getDigitalTextbook());
			DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
			DikshaUtils.waitToBeVisibleAndClick(groups.getSelectBook());

			Thread.sleep(2000);
			ActivityAddedPopup = popup.getActivityAddedPopup().getText();
			Assert.assertEquals(ActivityAddedPopup, "Activity added successfully");
			Thread.sleep(1000);
			actual = "Admin is able to create group successfully";

		} finally {

			String Text = ActivityAddedPopup != null ? ActivityAddedPopup : "N/A";
			Listeners.customAssert(ActivityAddedPopup, Text, expect, actual);
		}
	}

	public static void AdminRemoveActivityFromGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		Thread.sleep(1000);

		String expect = "Admin should be able to remove activity from the group successfully";
		String actual = "Admin is unable to remove activity from the group";
		String ActivityRemovePopup = null;

		try {

			DikshaUtils.waitToBeVisibleAndClick(groups.getKababMenuForTextbook());
			DikshaUtils.waitToBeClickableAndClick(groups.getRemoveActivity());
			DikshaUtils.waitToBeVisibleAndClick(groups.getConfirmRemoveActivity());

			Thread.sleep(2000);
			ActivityRemovePopup = popup.getActivityRemovePopup().getText();
			Assert.assertEquals(ActivityRemovePopup, "Activity removed for the group successfully");
			Thread.sleep(1000);

			actual = "Admin is able to remove activity from the group successfully";

		} finally {

			String Text = ActivityRemovePopup != null ? ActivityRemovePopup : "N/A";
			Listeners.customAssert(ActivityRemovePopup, Text, expect, actual);
		}
	}

	public static void AdminAbleToSeeEditGroupDetailsAndDeleteGroupOption() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);

	}

	public static void startDiscussionForCourse() {
		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeVisibleAndClick(groups.getdiscussionForumIcon());
		DikshaUtils.waitToBeVisibleAndClick(groups.getdiscussionForCourse());
		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnStrartDF());
		groups.getenterDFTopic().sendKeys("This is a Discussion Forum");
		groups.getenterElaborateQuestion().sendKeys("This is Elaborates Discussion Forum");
		groups.getenterTag().sendKeys("Discussion", Keys.ENTER);
		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnSubmit());

		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnSubmit());

		Assert.assertTrue(groups.getassertDiscussionTopic().isDisplayed());
		System.out.println("Discussion Forum Topic Successfully Created By Admin and Displayed");

		Assert.assertTrue(groups.getassertDiscussionTag().isDisplayed());
		System.out.println("Discussion Forum Tag Successfully Created By Admin and Displayed");

		DikshaUtils.waitToBeVisibleAndClick(groups.getassertDiscussionTopic());

		Assert.assertTrue(groups.getassertDiscussionElaborates().isDisplayed());
		System.out.println("Discussion Forum Question Elaborates Successfully Created By Admin and Displayed");

	}
//	public static void startDiscussionForCourse1(String courseName) {
//		
//	}

	public static void AdminAbleToDeleteTheGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Admin should be able to delete the group successfully";
		String actual = "Admin is unable to delete the group";
		String DeleteGroupPopup = null;

		try {

			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(groups.getDeleteGroup());
			DikshaUtils.waitToBeClickableAndClick(groups.getConfirmDeleteGroup());

			Thread.sleep(2000);
			DeleteGroupPopup = popup.getDeleteGroupPopup().getText();
			Assert.assertEquals(DeleteGroupPopup, "Group deleted successfully");
			Thread.sleep(1000);

			actual = "Admin is able to delete the group successfully";

		} finally {

			String Text = DeleteGroupPopup != null ? DeleteGroupPopup : "N/A";
			Listeners.customAssert(DeleteGroupPopup, Text, expect, actual);
		}
	}

	public static void AdminAbleToEditTheGroupDetails(String Groupname) throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = " Group admin should be able to edit group details successfully";
		String actual = "Group admin is unable to edit group details";
		String GroupUpdatePopup = null;

		try {

			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(groups.getEditGroupDetails());
//		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
//		groups.getGroupName().clear();
//		Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndSendKeys(groups.getGroupName(), "_Updated");
			DikshaUtils.waitToBeClickableAndSendKeys(groups.getDescription(), "Description");
			DikshaUtils.waitToBeClickableAndClick(groups.getUpdateGroup());

			Thread.sleep(2000);
			GroupUpdatePopup = popup.getGroupUpdatePopup().getText();
			Assert.assertEquals(GroupUpdatePopup, "Group updated successfully");
			Thread.sleep(1000);

			String EditGroupDatail = groups.getEditGroupName().getText();
			Assert.assertEquals(EditGroupDatail, Groupname + "_Updated");
			Thread.sleep(1000);

			actual = "Group admin is able to edit group details successfully";

		} finally {
			String Text = GroupUpdatePopup != null ? GroupUpdatePopup : "N/A";
			Listeners.customAssert(GroupUpdatePopup, Text, expect, actual);
		}
	}

	public static void GroupAdminAddMemberAndAssignMemberAsAdmin() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getAddMember());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getIdCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getSearchId());
		Thread.sleep(1000);
		groups.getSearchId().sendKeys("creatorprod_uvae");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getVerifyId());
		DikshaUtils.waitToBeVisibleAndClick(groups.getIdSelected());

		Thread.sleep(2000);
		String GroupMemberAddedPopup = popup.getGroupMemberAddedPopup().getText();
		Assert.assertEquals(GroupMemberAddedPopup, "Contentcreatorprod added successfully");
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getGroupBackButton());
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(groups.getGroupMemberKababMenu());
		DikshaUtils.waitToBeClickableAndClick(groups.getMakeAdmin());
		DikshaUtils.waitToBeVisibleAndClick(groups.getConfirmMakeAdmin());
		Thread.sleep(2000);
		String MakeAsAdminPopup = popup.getMakeAsAdminPopup().getText();
		Assert.assertEquals(MakeAsAdminPopup, "contentcreatorprod is now the group admin");
		Thread.sleep(1000);

		js.executeScript("window.scrollTo(0, 0)");

//        
//        DikshaUtils.waitToBeVisibleAndClick(groups.getGroupBackButton());
//        Thread.sleep(1000);
//        DikshaUtils.waitToBeVisibleAndClick(groups.getGroupBackButton());
//        Thread.sleep(2000);
//   
	}

	public static void GroupAdminIsAbleToAssignMemberAsAdmin() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Admin should be able to assign member as admin successfully";
		String actual = "Admin is unable to assign member as admin";
		String MakeAsAdminPopup = null;

		try {

			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(groups.getGroupMemberKababMenu());
			DikshaUtils.waitToBeClickableAndClick(groups.getMakeAdmin());
			DikshaUtils.waitToBeVisibleAndClick(groups.getConfirmMakeAdmin());
			Thread.sleep(2000);
			MakeAsAdminPopup = popup.getMakeAsAdminPopup().getText();
			Assert.assertEquals(MakeAsAdminPopup, "contentcreatorprod is now the group admin");
			Thread.sleep(1000);
			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
//		DikshaUtils.waitToBeVisibleAndClick(groups.getGroupBackButton());

			actual = "Admin is able to to assign member as admin successfully";

		} finally {
			String Text = MakeAsAdminPopup != null ? MakeAsAdminPopup : "N/A";
			Listeners.customAssert(MakeAsAdminPopup, Text, expect, actual);
		}

	}

	public static void AssignMemberAsAdminIsAbleToEditGroupDetails() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());

		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeVisibleAndClick(groups.getYesTab());

		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getEditGroupDetails());
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getGroupName(), "_Updated");
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getDescription(), "Description");
		DikshaUtils.waitToBeClickableAndClick(groups.getUpdateGroup());

		Thread.sleep(2000);
		String GroupUpdatePopup = popup.getGroupUpdatePopup().getText();
		Assert.assertEquals(GroupUpdatePopup, "Group updated successfully");
		Thread.sleep(1000);

	}

	public static String AdminAbleToCreateGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = " Group admin should be able to create group successfully";
		String actual = "Group admin is unable to create group";
		String GroupCreatedsuccessfullyPopup = null;

		try {

			DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
			DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(groups.getCrossTab());
			DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());
			DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
			String Groupname = DikshaUtils.set_Content_Name("GroupName_");
			groups.getGroupName().sendKeys(Groupname);
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
			DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
			Thread.sleep(1000);
			GroupCreatedsuccessfullyPopup = popup.getCreateGroupsPopup().getText();
			Assert.assertEquals(GroupCreatedsuccessfullyPopup, "Group created successfully");
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());

			Thread.sleep(2000);
			actual = "Group admin is able to create group successfully";
			return Groupname;

		} finally {
			String Text = popup.getCreateGroupsPopup() != null ? popup.getCreateGroupsPopup().getText() : "N/A";
			Listeners.customAssert(GroupCreatedsuccessfullyPopup, Text, expect, actual);
		}

	}

	public static void RemoveTheRoleAsAdminFromAssignedAdmin() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Group admin should be able to remove role as admin from assigned admin successfully";
		String actual = "Group admin is unable to remove role as admin from assigned admin";
		String DismissAsAdminPopup = null;

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");
			Thread.sleep(1000);

			DikshaUtils.waitToBeVisibleAndClick(groups.getDismissGroupMemberKababMenu());
			DikshaUtils.waitToBeClickableAndClick(groups.getDismissAsAdmin());
			DikshaUtils.waitToBeVisibleAndClick(groups.getConfirmDismissAsAdmin());
			Thread.sleep(2000);

			DismissAsAdminPopup = popup.getDismissAsAdminPopup().getText();
			Assert.assertEquals(DismissAsAdminPopup, "contentcreatorprod is no longer the group admin");
			Thread.sleep(1000);

			actual = "Group admin is able to remove role as admin from assigned admin successfully";

		} finally {
			String Text = DismissAsAdminPopup != null ? DismissAsAdminPopup : "N/A";
			Listeners.customAssert(DismissAsAdminPopup, Text, expect, actual);
		}
	}

	public static void AdminAbleToAddAndRemoveMemberFromGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getAddMember());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getIdCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getSearchId());
		Thread.sleep(1000);
		groups.getSearchId().sendKeys("creatorprod_uvae");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getVerifyId());
		DikshaUtils.waitToBeVisibleAndClick(groups.getIdSelected());

		Thread.sleep(2000);
		String GroupMemberAddedPopup = popup.getGroupMemberAddedPopup().getText();
		Assert.assertEquals(GroupMemberAddedPopup, "Contentcreatorprod added successfully");
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getGroupBackButton());
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(groups.getGroupMemberKababMenu());
		DikshaUtils.waitToBeClickableAndClick(groups.getRemoveMember());
		DikshaUtils.waitToBeVisibleAndClick(groups.getConfirmRemoveMember());
		Thread.sleep(2000);

		String RemoveGroupMemberPopup = popup.getRemoveGroupMemberPopup().getText();
		Assert.assertEquals(RemoveGroupMemberPopup, "contentcreatorprod is no longer part of the group");
		Thread.sleep(1000);

	}

	public static void ValidateAdminAbleToPasteCopiedDikshaId() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expected = "Verify group admin should be able to paste copied diksha id successfully";
		String actual = "group admin is unable to paste copied diksha id";

		String verifyId = null;
		boolean checkId = false;

		try {

			if (groups.getAddMember().isDisplayed()) {
				checkId = true;

				DikshaUtils.waitToBeClickableAndClick(groups.getAddMember());
				Thread.sleep(1000);
				DikshaUtils.waitToBeClickableAndClick(groups.getIdCrossTab());
				Thread.sleep(1000);
				Assert.assertTrue(groups.getSearchId().isDisplayed());
				DikshaUtils.waitToBeClickableAndClick(groups.getSearchId());
				Thread.sleep(1000);
				groups.getSearchId().sendKeys("creatorprod_uvae");
				Thread.sleep(1000);
				DikshaUtils.waitToBeVisibleAndClick(groups.getVerifyId());

				actual = "group admin is able to paste copied diksha id successfully";
				verifyId = "True";
			}

		} finally {

			Listeners.customAssert("True", verifyId, expected, actual);

		}
	}

	public static void UserNotAbleToSeeDiscussionFormOption() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeVisibleAndClick(groups.getYesTab());
		Thread.sleep(1000);

		WebElement ForumOption = groups.getForumOption();
		Assert.assertTrue((ForumOption != null));

		{
			System.out.println("Forum Option tab is not present.");

			System.out.println("Forum Option tab is present.");

		}
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");

		DikshaUtils.waitToBeVisibleAndClick(groups.getGroupBackButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getGroupBackButton());
		Thread.sleep(2000);
	}

	public static void AdminAbleToSelectEnableDiscussionOption() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Admin should be able to Select Enable Discussion Option successfully";
		String actual = "Admin is unable to Select Enable Discussion Option";

		String EnableOptionPopup = null;

		try {

			DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
			DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
			DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
			Thread.sleep(1000);
			Assert.assertTrue(groups.getEnableOption().isDisplayed());
			System.out.println("Enabled discussion option is Displayed");

			DikshaUtils.waitToBeVisibleAndClick(groups.getEnableOption());
			Actions act = new Actions(driver);
			act.moveByOffset(50, 100).click().build().perform();
			Thread.sleep(1000);
			EnableOptionPopup = popup.getEnabledDiscussionPopup().getText();

			Thread.sleep(1000);

			actual = "Admin is able to to Select Enable Discussion Option successfully";

		} finally {
			String Text = EnableOptionPopup != null ? EnableOptionPopup : "N/A";
			Listeners.customAssert(EnableOptionPopup, Text, expect, actual);
		}

	}

	public static void UserAbleToSeeDiscussionFormOption() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());

		Thread.sleep(1000);

		Assert.assertTrue(groups.getForumOption().isDisplayed());

	}

	public static void DeleteGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getDeleteGroup());
		DikshaUtils.waitToBeClickableAndClick(groups.getConfirmDeleteGroup());

		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getDeleteGroup());
		DikshaUtils.waitToBeClickableAndClick(groups.getConfirmDeleteGroup());

	}

	public static void SelectEnableDiscussionOption() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getclkBackBtn());
		Thread.sleep(2000);
		Assert.assertTrue(groups.getassertLoadingPage().isDisplayed());

		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getDF_ForGroup());

		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnStrartDF());

		groups.getenterDFTopic().sendKeys("This is a Discussion Forum");

		groups.getenterElaborateQuestion().sendKeys("This is Elaborates Discussion Forum");

		groups.getenterTag().sendKeys("Discussion", Keys.ENTER);
		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnSubmit());

		DikshaUtils.waitToBeVisibleAndClick(groups.getclkCreatedDiscussion());
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnEdit());

		groups.getenterDFTopic().clear();

		groups.getenterDFTopic().sendKeys("This is a Discussion Forum Update");

		groups.getenterElaborateQuestion().clear();

		groups.getenterElaborateQuestion().sendKeys("This is Elaborates Discussion Forum Update");

		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnUpdate());
		Thread.sleep(2000);

		Assert.assertTrue(groups.getAssertDFUpdated().isDisplayed());
		System.out.println("Discussion Forum Updated Successfully By Group Admin");

		Thread.sleep(2000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnDelete());

		driver.switchTo().alert().accept();
		Thread.sleep(1000);

		Assert.assertTrue(groups.getAssertDFDeleted().isDisplayed());
		System.out.println("Discussion Forum Deleted Successfully By Group Admin");

	}

	public static void verifyUpdatedUIForDiscussionForum() throws InterruptedException {
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());
		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
		String Groupname = DikshaUtils.set_Content_Name("GroupName_");
		groups.getGroupName().sendKeys(Groupname);

		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());

		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getEnableOption().isDisplayed());
		System.out.println("Enabled discussion option is Displayed");

		DikshaUtils.waitToBeVisibleAndClick(groups.getEnableOption());
		Actions act = new Actions(driver);
		act.moveByOffset(50, 100).click().build().perform();
		Thread.sleep(2000);

		String EnableDiscussionPopup = popup.getEnabledDiscussionPopup().getText();
		Assert.assertEquals(EnableDiscussionPopup, "Enabled discussion forum successfully");
		Thread.sleep(1000);

		Assert.assertTrue(groups.getForumOption().isDisplayed());

	}

	public static void UserAbleToSelectDiscussionFormOption() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeVisibleAndClick(groups.getYesTab());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getCreateDiscussionForum().isDisplayed());
		Assert.assertTrue(groups.getMyDiscussion().isDisplayed());

	}

	public static void UserAbleToSelectGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expected = "Verify user should be able to select group successfully";
		String actual = "User is unable to select the group";

		String expectedCondition = null;
		boolean selectGroup = false;

		try {

			if (groups.getHeaderDropdown().isDisplayed()) {
				selectGroup = true;

				DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
				DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());

				Thread.sleep(1000);
				// DikshaUtils.waitToBeVisibleAndClick(groups.getCrossTab());
				DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
				Thread.sleep(1000);

				DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
				DikshaUtils.waitToBeVisibleAndClick(groups.getYesTab());
				Thread.sleep(1000);

//		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
//		Thread.sleep(1000);
//		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
//		DikshaUtils.waitToBeVisibleAndClick(groups.getYesTab());
//		Thread.sleep(1000);

				actual = "user is able to select group successfully";
				expectedCondition = "True";
			}

		} finally {

			Listeners.customAssert("True", expectedCondition, expected, actual);

		}

	}

	public static void UserAbleToSelectSameGroupSecondTime() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		Thread.sleep(1000);

	}

	public static void CreateDiscussionFormForGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());

		DikshaUtils.waitToBeClickableAndClick(groups.getCreateDiscussionForum());
		DikshaUtils.waitToBeClickableAndClick(groups.getStartDiscussion());
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getDiscussionTopic(), "CreateDiscussionTopicForGroup");
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getDiscussionTopicDiscription(), "DiscussionTopicDiscription");
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getTagTopic(), "bookmark");
		groups.getTagTopic().sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionSubmitButton());
		Thread.sleep(2000);

		String ForumName = groups.getDiscussionTopicName().getText();
		Assert.assertEquals(ForumName, "CreateDiscussionTopicForGroup");
		Thread.sleep(1000);

		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);
	}

	public static void CreateDiscussionFormWithoutTagForGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());

		DikshaUtils.waitToBeClickableAndClick(groups.getCreateDiscussionForum());
		DikshaUtils.waitToBeClickableAndClick(groups.getStartDiscussion());
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getDiscussionTopic(), "CreateDiscussionTopicForGroup");
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getDiscussionTopicDiscription(), "DiscussionTopicDiscription");

		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionSubmitButton());
		Thread.sleep(2000);

		String ForumName = groups.getDiscussionTopicName().getText();
		Assert.assertEquals(ForumName, "CreateDiscussionTopicForGroup");
		Thread.sleep(1000);

		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);
	}

	public static void EditCreatedDiscussionFormForGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getDiscussionTopicName());

		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionTopicKababMenu());
		DikshaUtils.waitToBeClickableAndClick(groups.getEditButtonForDiscussionTopic());
		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionTopic());
		groups.getDiscussionTopic().clear();
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getDiscussionTopic(), "UpdatedCreateDiscussionTopicForGroup");
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getDiscussionTopicDiscription(), "DiscussionTopicDiscription");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionUpdateButton());
		Thread.sleep(2000);

		String UpdateForumName = groups.getUpdatedDiscussionTopicName().getText();
		Assert.assertEquals(UpdateForumName, "UpdatedCreateDiscussionTopicForGroup");
		Thread.sleep(1000);

	}

	public static void SelectDisabledDiscussionOption() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Admin should be able to Select Disabled Discussion Option successfully";
		String actual = "Admin is unable to Select Disabled Discussion Option";

		String DisableDiscussionPopup = null;

		try {

			Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
			Thread.sleep(1000);
			Assert.assertTrue(groups.getDisableOption().isDisplayed());
			System.out.println("Enabled discussion option is Displayed");

			DikshaUtils.waitToBeVisibleAndClick(groups.getDisableOption());
			DikshaUtils.waitToBeVisibleAndClick(groups.getDisableOptionPopup());
			Actions act = new Actions(driver);
			act.moveByOffset(50, 100).click().build().perform();
			Thread.sleep(2000);

			DisableDiscussionPopup = popup.getDisabledDiscussionPopup().getText();
			Assert.assertEquals(DisableDiscussionPopup, "Disabled discussion forum successfully");
			Thread.sleep(1000);

			actual = "Admin is able to to Select Disabled Discussion Option successfully";

		} finally {
			String Text = popup.getDisabledDiscussionPopup() != null ? popup.getDisabledDiscussionPopup().getText()
					: "N/A";
			Listeners.customAssert(DisableDiscussionPopup, Text, expect, actual);
		}

	}

	public static void ValidateDiscussionFormOptionIsDisabled() throws Exception {

		String expect = "Admin should not be able to see form option ";
		String actual = "Admin is able to see form option";
		String forum = null;

		Groups groups = PageFactory.initElements(driver, Groups.class);

		try {
			WebElement ForumOption = groups.getForumOption();
			if (ForumOption != null) {

				System.out.println("forum option is not present.");
			} else {
				forum = "forum option Is Present";
				Assert.assertFalse(groups.getForumOption().isDisplayed());

			}

			actual = "Admin not able to See form option ";

		} finally {

			String forumText = forum != null ? "forumoption" : "N/A";
			Listeners.customAssert("N/A", forumText, expect, actual);
		}
	}

	public static void GroupAdminAbleToSelectDiscussionFormOption() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getCreateDiscussionForum().isDisplayed());
		Assert.assertTrue(groups.getMyDiscussion().isDisplayed());

	}

	public static void UserAbleToReplyToAnyDiscussionTopic() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getCreateDiscussionForum());
		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionTopicName());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);

		Assert.assertTrue(groups.getReplyToDiscussionTopic().isDisplayed());
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getReplyToDiscussionTopic(),
				"Reply Successfully Send To Group Admin");
		DikshaUtils.waitToBeClickableAndClick(groups.getPostReply());
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");
		String ValidateReply = groups.getValidatePostReply().getText();
		Assert.assertEquals(ValidateReply, "Reply Successfully Send To Group Admin");
		Thread.sleep(1000);

		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionCloseButton());
	}

	public static void UserAbleToDeleteTheCommentFromDiscussionTopic() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getCreateDiscussionForum());
		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionTopicName());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(groups.getDeletePost());
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionCloseButton());
	}

	public static void UserAbleTOUpvotesToThePost() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());

		DikshaUtils.waitToBeClickableAndClick(groups.getCreateDiscussionForum());
		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionTopicName());
		DikshaUtils.waitToBeClickableAndClick(groups.getUpvotedArrow());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getUpvotedCount().isDisplayed());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getReplyToDiscussionTopic(),
				"Click On Upvoted Arrow Successfully ");
		DikshaUtils.waitToBeClickableAndClick(groups.getPostReply());
		Thread.sleep(1000);

		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);

	}

	public static void UserAbleTODownvotesToThePost() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());

		DikshaUtils.waitToBeClickableAndClick(groups.getCreateDiscussionForum());
		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionTopicName());
		DikshaUtils.waitToBeClickableAndClick(groups.getDownvotedArrow());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getDownvotedCount().isDisplayed());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getReplyToDiscussionTopic(),
				"Click On Downvoted Arrow Successfully ");
		DikshaUtils.waitToBeClickableAndClick(groups.getPostReply());
		Thread.sleep(1000);

		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);

	}

	public static void UserAbleToSeeTagList() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		DikshaUtils.waitToBeClickableAndClick(groups.getTags());
		Thread.sleep(1000);

		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		String Tagvalue = groups.getTagInput().getText();
		System.out.println(Tagvalue);
		Assert.assertEquals(Tagvalue, "bookmark");
		Thread.sleep(1000);

	}

	public static void UserAbleToSeeCategoryDetails() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		DikshaUtils.waitToBeClickableAndClick(groups.getCategories());
		Thread.sleep(1000);

		Assert.assertTrue(groups.getNoOfDiscussion().isDisplayed());
		Assert.assertTrue(groups.getNoOfPosts().isDisplayed());

	}

	public static void UserAbleToSeeValidMessageInTagMenu() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		DikshaUtils.waitToBeClickableAndClick(groups.getTags());
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);

		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		String Message = groups.getNoTagAvailable().getText();
		Assert.assertEquals(Message, "No tags Available !");
		Thread.sleep(1000);

	}

	public static void ValidateUserAbleToTagAnyTopic() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);

		String Tagvalue = groups.getUserTagInput().getText();
		Assert.assertEquals(Tagvalue, "bookmark");
		Thread.sleep(1000);

	}

	public static void UserAbleToSeeMyDiscussion() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyDiscussion());
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		Assert.assertTrue(groups.getDiscussionTopicName().isDisplayed());

	}

	public static void ValidateActiveGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getGroupBackButton());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getActivateGroupIcon().isDisplayed());

	}

	public static void DeactivateGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Group admin should be able to deactivate the group successfully";
		String actual = "Admin is unable to deactivate the group";
		String expectedMessage = null;
		boolean checkMessage = false;
		try {

			if (groups.getkababmenu().isDisplayed()) {
				checkMessage = true;

				Thread.sleep(1000);
				DikshaUtils.waitToBeClickableAndClick(groups.getkababmenu());
				DikshaUtils.waitToBeClickableAndClick(groups.getDeactivateGroup());
				DikshaUtils.waitToBeClickableAndClick(groups.getConfirmDeactivateGroup());

				actual = "Group admin is able to deactivate the group successfully";
				expectedMessage = "True";
			}

		} finally {

			Listeners.customAssert("True", expectedMessage, expect, actual);

		}

	}

	public static void ValidateDeactiveGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Group admin should be validate deactivate group successfully";
		String actual = "Group admin is unable to validate deactivate group";

		String expectedValidation = null;
		boolean validateGroup = false;

		try {

			if (groups.getGroupBackButton().isDisplayed()) {
				validateGroup = true;

				Thread.sleep(1000);
				DikshaUtils.waitToBeVisibleAndClick(groups.getGroupBackButton());
				Thread.sleep(1000);
				Assert.assertTrue(groups.getDeactivateGroupIcon().isDisplayed());

				actual = "Group admin is able to validate deactivate group successfully";
				expectedValidation = "True";
			}

		} finally {

			Listeners.customAssert("True", expectedValidation, expect, actual);

		}
	}

	public static void ValidateActivityDashboard() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expected = "Verify group admin should be able to see activity dashboard successfully";
		String actual = "Group admin is unable to see activity dashboard";

		boolean checkDashboard = false;
		String expectedCondition = null;
		
		try {

			if (groups.getSelectCourse().isDisplayed()) {
				checkDashboard = true;
				
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectCourse());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getActivityDashboard().isDisplayed());
		DikshaUtils.waitToBeVisibleAndClick(groups.getActivityDashboard());

		expectedCondition = "True";
			actual="group admin is able to see activity dashboard successfully";
			}
		} finally {

			Listeners.customAssert("True", expectedCondition, expected, actual);
			
		}
	}

	public static void ValidateCourseAssesmentActivityDashboard() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectCourse());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getActivityDashboard().isDisplayed());
		DikshaUtils.waitToBeVisibleAndClick(groups.getActivityDashboard());
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		Assert.assertTrue(groups.getCourseAssesmentColumn().isDisplayed());

	}

	public static void UserAbleToSeeGroupActivity() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectCourse());
		Thread.sleep(1000);

	}

	public static void GroupAdminAbleToSortProgress() throws Exception {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.SortingProgress());
		DikshaUtils.waitToBeVisibleAndClick(cc.SortingProgress());
		DikshaUtils.waitToBeVisibleAndClick(cc.SortingProgress());

	}

	public static void UserValidateUpdatedGroupDetail(String Groupname) throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String EditGroupDatail = groups.getEditGroupName().getText();
		Assert.assertEquals(EditGroupDatail, Groupname + "_Updated");
		Thread.sleep(1000);

	}

	public static void ValidateLastUpdateDateAndTime() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectCourse());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getActivityDashboard().isDisplayed());
		DikshaUtils.waitToBeVisibleAndClick(groups.getActivityDashboard());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getLastUpdateDateAndTime().isDisplayed());

	}

	public static void AssignAdminNotAbleToDeleteGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expected = "Verify assign admin should not be able to delete group successfully";
		String actual = "Assign admin is able to delete the roles";

		String expectedCondition = null;
		boolean checkCondition = false;

		try {

			if (groups.getkababmenu().isDisplayed()) {
				checkCondition = true;

				Thread.sleep(1000);
				DikshaUtils.waitToBeClickableAndClick(groups.getkababmenu());

				WebElement Deletegroup = groups.getDeleteGroup();
				Assert.assertTrue((Deletegroup != null));

				actual = "assign admin is not be able to delete group successfully";
				expectedCondition = "True";
			}

		} finally {

			Listeners.customAssert("True", expectedCondition, expected, actual);

		}
	}

	public static void UserAbleToSeeCountOfMember() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);

		Thread.sleep(1000);
		Assert.assertTrue(groups.getMemberCount().isDisplayed());
		Thread.sleep(1000);

		String count = groups.getMemberCount().getText();
		System.out.println(count);

	}

	public static void AssignAdminAbleToLeaveTheGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Verify assign admin should be able leave the group successfully";
		String actual = "assign admin is unable to leave the group";
		String LeaveGroupPopup = null;

		try {

			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(groups.getkababmenu());
			DikshaUtils.waitToBeClickableAndClick(groups.getLeaveGroup());
			DikshaUtils.waitToBeClickableAndClick(groups.getConfirmLeaveGroup());
			Thread.sleep(1000);
			LeaveGroupPopup = popup.getLeaveGroupPopup().getText();
			Assert.assertEquals(LeaveGroupPopup, "You are no longer part of this group");
			Thread.sleep(1000);

			actual = "assign admin is able to leave the group successfully";

		} finally {

			String Text = LeaveGroupPopup != null ? LeaveGroupPopup : "N/A";
			Listeners.customAssert(LeaveGroupPopup, Text, expect, actual);
		}
	}

	public static void UserAbleToSeeRecentPosts() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyDiscussion());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getRecentposts());
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		Assert.assertTrue(groups.getDiscussionTopicName().isDisplayed());

	}

	public static void UserAbleToSaveThePosts() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		DikshaUtils.waitToBeClickableAndClick(groups.getCreateDiscussionForum());
		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionTopicName());
		DikshaUtils.waitToBeClickableAndClick(groups.getBookmarkThePost());
		DikshaUtils.waitToBeClickableAndClick(groups.getDiscussionCloseButton());

	}

	public static void UserAbleToSeeSavedPosts() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyDiscussion());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getSavedposts());
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		Assert.assertTrue(groups.getDiscussionTopicName().isDisplayed());

		DikshaUtils.waitToBeVisibleAndClick(groups.getEnableOption());
		Actions act = new Actions(driver);
		act.moveByOffset(50, 100).click().build().perform();
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());

		Assert.assertTrue(groups.getCategories().isDisplayed());
		Assert.assertTrue(groups.getTags().isDisplayed());
		Assert.assertTrue(groups.getTags().isDisplayed());
		Assert.assertTrue(groups.getMyDiscussion().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyDiscussion());
		Assert.assertTrue(groups.getMyDiscussion().isDisplayed());
		Assert.assertTrue(groups.getRecentposts().isDisplayed());
		Assert.assertTrue(groups.getBestposts().isDisplayed());
		Assert.assertTrue(groups.getUpvoted().isDisplayed());
		Assert.assertTrue(groups.getDownvoted().isDisplayed());
		Assert.assertTrue(groups.getSavedposts().isDisplayed());

		DikshaUtils.waitToBeVisibleAndClick(groups.getDiscussionCloseButton());
		System.out.println("Successfully clicked on Close Button");
		Thread.sleep(1000);
		Assert.assertTrue(groups.getAddActivity().isDisplayed());

	}

	public static void createGroupsAndValidateAddedActivity(String content) throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());
		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
		String Groupname = DikshaUtils.set_Content_Name("GroupName_");
		groups.getGroupName().sendKeys(Groupname);
		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
		DikshaUtils.waitToBeClickableAndClick(groups.getcourseTabInGroupActivity());
		DikshaUtils.waitToBeClickableAndClick(groups.getSearchBoxContents());
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getSearchBoxContents(), content);
		DikshaUtils.waitToBeClickableAndClick(groups.getSearchButtonInAddActivity());
		DikshaUtils.dragAndDrop(groups.getContentCard());
		Assert.assertTrue(groups.getClickAddtoGroup().isDisplayed());
		Assert.assertTrue(groups.getclickViewActivity().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(groups.getclickViewActivity());
		Assert.assertTrue(groups.getValidateCourseModules().isDisplayed());
		Assert.assertTrue(groups.getValidateBatchDetails().isDisplayed());
		Assert.assertTrue(groups.getValidateCourseDetails().isDisplayed());
		// DikshaUtils.waitToBeClickableAndClick(groups.getBackButtonUi());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getClickAddtoGroup());
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView(true);", groups.getContentCard());
		Assert.assertTrue(groups.getContentCard().isDisplayed());
	}

	public static void verifyFlterByOption() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
//		DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());
//		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
//		String Groupname = DikshaUtils.set_Content_Name("GroupName_");
//		groups.getGroupName().sendKeys(Groupname);
//		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
//		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
//		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
		DikshaUtils.waitToBeClickableAndClick(groups.getcourseTabInGroupActivity());
		Assert.assertTrue(groups.getFilterByOption().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(groups.getFilterByOption());
		DikshaUtils.waitToBeClickableAndClick(groups.getClickSelectBoardDropDown());
		// js.executeScript("arguments[0].scrollIntoView(true);",
		// groups.getSelectboardValues());
		DikshaUtils.waitToBeClickableAndClick(groups.getSelectboardValues());
		DikshaUtils.dragAndDrop(groups.getContentCard());
		Assert.assertTrue(groups.getClickAddtoGroup().isDisplayed());
		Assert.assertTrue(groups.getclickViewActivity().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(groups.getClickAddtoGroup());
		Assert.assertTrue(groups.getContentCard().isDisplayed());
	}

	public static void validateActivityDashboardInAddActivity() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
//		Thread.sleep(2000);
//		js.executeScript("arguments[0].scrollIntoView(true);", groups.getContentCard());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getContentCard());
		Thread.sleep(2000);
		Assert.assertTrue(groups.getActivityDashBoard().isDisplayed());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getActivityDashBoard());
		Thread.sleep(2000);
		Assert.assertTrue(groups.getValidateNameColumnInactivityDashboard().isDisplayed());
		Assert.assertTrue(groups.getValidateProgressColumnInactivityDashboard().isDisplayed());
		Assert.assertTrue(groups.getDownloadAsCSVButton().isDisplayed());
	}

	public static void deleteCreatedGroup() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		DikshaUtils.waitToBeVisibleAndClick(groups.getDeleteGroup());
		Assert.assertTrue(groups.getDeleteGroupPopUpInstruction().isDisplayed());
		Assert.assertTrue(groups.getNoButtonInDeleteGroupPopUp().isDisplayed());
		Assert.assertTrue(groups.getDeleteButtonInDeleteGroupPopUp().isDisplayed());
		DikshaUtils.waitToBeVisibleAndClick(groups.getDeleteButtonInDeleteGroupPopUp());
	}

	public static void validateCloseButtonInSearchMemberEntryBox(String memberName) throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getSearchWithMember(), memberName);
		Assert.assertTrue(groups.getCloseIconInMemberSearchBox().isDisplayed());
		DikshaUtils.waitToBeVisibleAndClick(groups.getCloseIconInMemberSearchBox());
	}

	public static void validateUpdateGroupButtonInsteadOfSubmitButton(String groupName, String groupDescription)
			throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeClickableAndClick(groups.getkababmenu());
		DikshaUtils.waitToBeClickableAndClick(groups.getEditGroupDetailsPage());
		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
		groups.getGroupName().clear();
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getGroupName(), groupName);
		DikshaUtils.waitToBeClickableAndClick(groups.getEnterDescription());
		groups.getEnterDescription().clear();
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getEnterDescription(), groupDescription);
		Assert.assertTrue(groups.getUpdateGroupButton().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(groups.getUpdateGroupButton());
		System.out.println(
				"Verified that 'Reset' option is removed when Admin tries to Edit the Group details and Submit is replaced by Update Group");
	}

	public static void validateDeactivateGroup() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);
		String messageValidation = "This group is temporarily inactive. The group admin can re-activate the group if required. Group members can continue their discussions on the discussion forum.";
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeClickableAndClick(groups.getkababmenu());
		DikshaUtils.waitToBeClickableAndClick(groups.getDeactivateGroup());

		Assert.assertTrue(groups.getValidateDeactivateGroupPopUpInstructionText().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(groups.getDeactivateGroupPopUpButton());
		Thread.sleep(3000);
		String groupDeactivateMessage = groups.getValidateGroupTempInactivemessage().getText();
		Assert.assertEquals(groupDeactivateMessage, messageValidation);
		Thread.sleep(3000);
	}

	public static void validateMemberDeactivateGroupMessage() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);
		String messageValidation = "This group is temporarily inactive. The group admin can re-activate the group if required. Group members can continue their discussions on the discussion forum.";
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		// DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		// Assert.assertTrue(groups.getSelectMemberGroup().isDisplayed());
		Thread.sleep(3000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getmemberGroupContentCard());
		Thread.sleep(3000);
		// Assert.assertTrue(groups.getValidateDeactivateGroupPopUpInstructionText().isDisplayed());
		// DikshaUtils.waitToBeClickableAndClick(groups.getDeactivateGroupPopUpButton());
		String groupDeactivateMessage = groups.getValidateGroupMemberTempInactivemessage().getText();
		Assert.assertEquals(groupDeactivateMessage, messageValidation);
	}

	public static void validateReactivateGroup() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeClickableAndClick(groups.getkababmenu());
		DikshaUtils.waitToBeClickableAndClick(groups.getReactivateGroup());
		DikshaUtils.waitToBeClickableAndClick(groups.getReactivateGroupPopUp());
		Thread.sleep(3000);
	}

	public static void copyUserId() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getClickOnProfile());
		DikshaUtils.waitToBeClickableAndClick(groups.getcopyUserId());
	}

	public static void UserIsAbleTOCreateNewGroupsAndVerifyAndMembers() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());
		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
		String Groupname = DikshaUtils.set_Content_Name("GroupName_");
		groups.getGroupName().sendKeys(Groupname);

		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
		DikshaUtils.waitToBeClickableAndClick(groups.getDigitalTextbook());
		DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
//		 Actions actions = new Actions(driver);
//		 actions.moveToElement(groups.getOverTheBook()).perform();
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectBook());
		System.out.println("Group Created and Successfully TextBook Added");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getAddMember());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getIdCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getSearchId());
		Thread.sleep(1000);
		groups.getSearchId().sendKeys(Keys.CONTROL + "v");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getVerifyId());
		DikshaUtils.waitToBeVisibleAndClick(groups.getIdSelected());
		System.out.println("Member Added Successfully");
	}

	public static void deactivateGroupFromMemberSideAndValidateAdminSideNotification() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		DikshaUtils.waitToBeVisibleAndClick(groups.getleaveGroupButton());
		DikshaUtils.waitToBeVisibleAndClick(groups.getleaveGroupButtonPopUp());
	}

	public static void validateAdminSideGroupNotoficationWhenMemberLeaves() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeVisibleAndClick(groups.getnotificationsBell());
		Assert.assertTrue(groups.getValidateNotificationMessage().isDisplayed());
		DikshaUtils.waitToBeVisibleAndClick(groups.getValidateNotificationMessage());
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		DikshaUtils.waitToBeVisibleAndClick(groups.getDeleteGroup());
		DikshaUtils.waitToBeVisibleAndClick(groups.getDeleteButtonInDeleteGroupPopUp());
	}

	public static void validateMembersSideGroupNotoficationWhenMemberAddedByadmin() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeVisibleAndClick(groups.getnotificationsBell());
		Assert.assertTrue(groups.getValidateNotificationMessageInMemberSide().isDisplayed());
		DikshaUtils.waitToBeVisibleAndClick(groups.getValidateNotificationMessageInMemberSide());
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		DikshaUtils.waitToBeVisibleAndClick(groups.getleaveGroupButton());
		DikshaUtils.waitToBeVisibleAndClick(groups.getleaveGroupButtonPopUp());
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		Assert.assertTrue(groups.getvalidateMemberRemoved().isDisplayed());
	}

	public static void validateAssignedAdminNotGroupCreatorLeaveTheGroup() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		DikshaUtils.waitToBeVisibleAndClick(groups.getleaveGroupButton());
		DikshaUtils.waitToBeVisibleAndClick(groups.getleaveGroupButtonPopUp());
	}

	public static String nonAdminAbleToSearchMember() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());
		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
		String Groupname = DikshaUtils.set_Content_Name("DeleteGroup_");
		groups.getGroupName().sendKeys(Groupname);

		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
		DikshaUtils.waitToBeClickableAndClick(groups.getDigitalTextbook());
		DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
//		 Actions actions = new Actions(driver);
//		 actions.moveToElement(groups.getOverTheBook()).perform();
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectBook());
		System.out.println("Group Created and Successfully TextBook Added");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getAddMember());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getIdCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getSearchId());
		Thread.sleep(1000);
		groups.getSearchId().sendKeys(Keys.CONTROL + "v");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getVerifyId());
		DikshaUtils.waitToBeVisibleAndClick(groups.getIdSelected());
		System.out.println("Member Added Successfully");
		DikshaUtils.waitToBeVisibleAndClick(groups.getUIbackButton());
		DikshaUtils.waitWebDriver(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSearchGroupMember());
		DikshaUtils.waitWebDriver(2000);
		DikshaUtils.waitToBeClickableAndSendKeys(groups.getSearchGroupMember(), "dikshamygroupmember");
		DikshaUtils.waitWebDriver(2000);
		Assert.assertTrue(groups.getvalidateGroupMemberSearched().isDisplayed());
		return Groupname;
	}

	public static void validateMemberAddedToGroupNotification() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeVisibleAndClick(groups.getnotificationsBell());
		Thread.sleep(2000);
		Assert.assertTrue(groups.getValidateNotificationMessageInMemberSide().isDisplayed());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getValidateNotificationMessageInMemberSide());
		Thread.sleep(2000);
	}

	public static void removeMemberfromExistingGroup() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		Actions actions = new Actions(driver);

		String expect = "Admin should be able to remove member from group successfully";
		String actual = "Admin is unable to remove member from group";
		String RemoveGroupMemberPopup = null;

		try {

			DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
			DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
			Thread.sleep(2000);
			DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
			Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView(true);", groups.getRemoveMemberHamburgermenu());
			DikshaUtils.waitToBeVisibleAndClick(groups.getRemoveMemberHamburgermenu());
			DikshaUtils.waitToBeVisibleAndClick(groups.getremoveMemberFromGroup());
			DikshaUtils.waitToBeVisibleAndClick(groups.getremoveMemberFromGroupPopUp());
			actions.sendKeys(Keys.HOME).build().perform();
			Thread.sleep(2000);

			RemoveGroupMemberPopup = popup.getRemoveGroupMemberPopup().getText();
			Assert.assertEquals(RemoveGroupMemberPopup, "contentcreatorprod is no longer part of the group");
			Thread.sleep(1000);

			actual = "Admin is able to remove member from group successfully";

		} finally {
			String Text = RemoveGroupMemberPopup != null ? RemoveGroupMemberPopup : "N/A";
			Listeners.customAssert(RemoveGroupMemberPopup, Text, expect, actual);
		}
	}

	public static void validateMemberRemovednotification() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeVisibleAndClick(groups.getnotificationsBell());
		Assert.assertTrue(groups.getvalidateMemberRemovedNotification().isDisplayed());
//		DikshaUtils.waitToBeVisibleAndClick(groups.getvalidateMemberRemovedNotification());
	}

	public static void adminAddedActivityToAssignedMemberAndRemove() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);
		Actions actions = new Actions(driver);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());
		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
		String Groupname = DikshaUtils.set_Content_Name("GroupName_");
		groups.getGroupName().sendKeys(Groupname);

		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeClickableAndClick(groups.getAddMember());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getIdCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getSearchId());
		Thread.sleep(1000);
		groups.getSearchId().sendKeys(Keys.CONTROL + "v");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getVerifyId());
		DikshaUtils.waitToBeVisibleAndClick(groups.getIdSelected());
		System.out.println("Member Added Successfully");
		DikshaUtils.waitToBeVisibleAndClick(groups.getUIbackButton());
		DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
		DikshaUtils.waitToBeClickableAndClick(groups.getDigitalTextbook());
		DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
//		 Actions actions = new Actions(driver);
//		 actions.moveToElement(groups.getOverTheBook()).perform();
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectBook());
		System.out.println("Group Created and Successfully TextBook Added");
		actions.sendKeys(Keys.HOME).build().perform();
		Thread.sleep(1000);
	}

	public static void validateActivityAddedToGroupNotifiedToMember() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeVisibleAndClick(groups.getnotificationsBell());
		Thread.sleep(2000);
		Assert.assertTrue(groups.getValidateAssignedAdminNotification().isDisplayed());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getValidateAssignedAdminNotification());
		DikshaUtils.waitToBeVisibleAndClick(groups.getValidateNotificationCloseButton());
		Thread.sleep(2000);
	}

	public static void validateUnassignedActivityFromGroupNotifiedToMember() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeVisibleAndClick(groups.getnotificationsBell());
		Thread.sleep(2000);
		Assert.assertTrue(groups.getValidateUnassignedNotification().isDisplayed());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getValidateUnassignedNotification());
		Thread.sleep(2000);
	}

	public static void validateDeleteGroupNotifiedToMember() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);

		DikshaUtils.waitToBeVisibleAndClick(groups.getnotificationsBell());
		Thread.sleep(2000);
		Assert.assertTrue(groups.getValidateDeletedGroupNotificationMessage().isDisplayed());
		Thread.sleep(2000);

	}

	public static void removeActivityfromExistingGroup() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", groups.getActivityHamburgerMenu());
		DikshaUtils.waitToBeVisibleAndClick(groups.getActivityHamburgerMenu());
		DikshaUtils.waitToBeVisibleAndClick(groups.getremoveActivity());
		DikshaUtils.waitToBeVisibleAndClick(groups.getremoveActivityPopUp());
		DikshaUtils.waitWebDriver(2000);
		actions.sendKeys(Keys.HOME).build().perform();
		DikshaUtils.waitWebDriver(2000);
	}

	public static void deleteCreatedGroupWithoutCrossTab() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(groups.getSelectgroup());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(groups.getkababmenu());
		DikshaUtils.waitToBeClickableAndClick(groups.getDeleteGroup());
		Assert.assertTrue(groups.getDeleteGroupPopUpInstruction().isDisplayed());
		Thread.sleep(3000);
		Assert.assertTrue(groups.getNoButtonInDeleteGroupPopUp().isDisplayed());
		Thread.sleep(3000);
		Assert.assertTrue(groups.getDeleteButtonInDeleteGroupPopUp().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(groups.getDeleteButtonInDeleteGroupPopUp());
	}

	public static void createDiscussionAndValidatePlaceholders() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());
		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
		String Groupname = DikshaUtils.set_Content_Name("GroupName_");
		groups.getGroupName().sendKeys(Groupname);

		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		groups.getGroupName().sendKeys(Groupname);

		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
		Thread.sleep(1000);
//		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
//		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
//		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getEnableOption().isDisplayed());
		System.out.println("Enabled discussion option is Displayed");

		DikshaUtils.waitToBeVisibleAndClick(groups.getEnableOption());
		Actions act = new Actions(driver);
		act.moveByOffset(50, 100).click().build().perform();
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		Thread.sleep(1000);

		Assert.assertTrue(groups.getCategories().isDisplayed());
		Assert.assertTrue(groups.getTags().isDisplayed());
		Assert.assertTrue(groups.getMyDiscussion().isDisplayed());

		Thread.sleep(1000);
	}

	public static void verifDeletedTopicMustBeRemovedFromDF() throws InterruptedException {
		Groups groups = PageFactory.initElements(driver, Groups.class);
		DikshaUtils.waitToBeVisibleAndClick(groups.getDF_ForGroup());
		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnStrartDF());

		groups.getenterDFTopic().sendKeys("This is a Discussion Forum");

		groups.getenterElaborateQuestion().sendKeys("This is Elaborates Discussion Forum");

		groups.getenterTag().sendKeys("Discussion", Keys.ENTER);
		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnSubmit());

		DikshaUtils.waitToBeVisibleAndClick(groups.getclkCreatedDiscussion());
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnEdit());

		groups.getenterDFTopic().clear();

		groups.getenterDFTopic().sendKeys("This is a Discussion Forum Update");

		groups.getenterElaborateQuestion().clear();

		groups.getenterElaborateQuestion().sendKeys("This is Elaborates Discussion Forum Update");

		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnUpdate());
		Thread.sleep(2000);

		Assert.assertTrue(groups.getAssertDFUpdated().isDisplayed());
		System.out.println("Discussion Forum Updated Successfully By Group Admin");

		Thread.sleep(2000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnDelete());

		driver.switchTo().alert().accept();
		Thread.sleep(1000);

		Assert.assertTrue(groups.getAssertDFDeleted().isDisplayed());
		System.out.println("Discussion Forum Deleted Successfully By Group Admin");
	}

	public static void createDiscussionForExistingGroupAndLoadingPage() throws InterruptedException {
		Groups groups = PageFactory.initElements(driver, Groups.class);
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getExistingGroup());
		JavascriptExecutor js = (JavascriptExecutor) driver;

		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getEnableOption().isDisplayed());
		System.out.println("Enabled discussion option is Displayed");

		DikshaUtils.waitToBeVisibleAndClick(groups.getEnableOption());
		Actions act = new Actions(driver);

		act.moveByOffset(50, 100).click().build().perform();
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getForumOption());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getCategories().isDisplayed());
		Assert.assertTrue(groups.getTags().isDisplayed());
		Assert.assertTrue(groups.getMyDiscussion().isDisplayed());
		DikshaUtils.waitToBeVisibleAndClick(groups.getclickDiscussionforum());
		DikshaUtils.waitToBeVisibleAndClick(groups.getclickStartMyDiscussion());
		Assert.assertTrue(groups.getDiscussionTopicPlaceholder().isDisplayed());
		Assert.assertTrue(groups.getquestionIdeaPlaceholder().isDisplayed());
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView(true);", groups.getcancelButtonInMydiscussion());
		DikshaUtils.waitToBeVisibleAndClick(groups.getcancelButtonInMydiscussion());
		DikshaUtils.waitToBeClickableAndClick(groups.getCloseButtoninForum());
		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		DikshaUtils.waitToBeVisibleAndClick(groups.getDeleteGroup());
		DikshaUtils.waitToBeVisibleAndClick(groups.getDeleteButtonInDeleteGroupPopUp());
	}

	public static void UserIsAbleVerifyAddMembers() throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.HOME).build().perform();
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		// DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
//		DikshaUtils.waitToBeClickableAndClick(groups.getBeforeCreateGroupsButton());
//		DikshaUtils.waitToBeClickableAndClick(groups.getGroupName());
//		String Groupname = DikshaUtils.set_Content_Name("GroupName_");
//		groups.getGroupName().sendKeys(Groupname);
//		DikshaUtils.waitToBeClickableAndClick(groups.getIAgreeCheckbox());
//		DikshaUtils.waitToBeClickableAndClick(groups.getAfterCreateGroupsButton());
//		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
//		DikshaUtils.waitToBeClickableAndClick(groups.getAddActivity());
//		DikshaUtils.waitToBeClickableAndClick(groups.getDigitalTextbook());
//		DikshaUtils.waitToBeClickableAndClick(groups.getOverTheBook());
//		 Actions actions = new Actions(driver);
//		 actions.moveToElement(groups.getOverTheBook()).perform();
//		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectBook());
		System.out.println("Group Created and Successfully TextBook Added");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getAddMember());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getIdCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getSearchId());
		Thread.sleep(1000);
		groups.getSearchId().sendKeys(Keys.CONTROL + "v");
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getVerifyId());
		DikshaUtils.waitToBeVisibleAndClick(groups.getIdSelected());
		System.out.println("Member Added Successfully");

	}

	public static void validateGroupMemberEnrollCourse() throws Exception {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		// DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		// js.executeScript("arguments[0].scrollIntoView(true);",
		// groups.getSelectgroup());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(groups.getValidateTickCheckBox());
		DikshaUtils.waitToBeClickableAndClick(groups.getValidateClickYesButton());
		// DikshaUtils.waitToBeVisibleAndClick(groups.getSelectgroup());
//		Thread.sleep(2000);
////		js.executeScript("arguments[0].scrollIntoView(true);", groups.getContentCard());
//		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getClickContentCardInMemberGroup());
		Thread.sleep(2000);

//		Assert.assertTrue(groups.getActivityDashBoard().isDisplayed());
//		Thread.sleep(2000);
//		DikshaUtils.waitToBeVisibleAndClick(groups.getActivityDashBoard());
//		Thread.sleep(2000);
//		Assert.assertTrue(groups.getValidateNameColumnInactivityDashboard().isDisplayed());
//		Assert.assertTrue(groups.getValidateProgressColumnInactivityDashboard().isDisplayed());
//		Assert.assertTrue(groups.getDownloadAsCSVButton().isDisplayed());
	}

	public static void userEnrollsInCourse() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		Library.custom_click(cc.getShareButton(), "Share Button");
		DikshaUtils.waitForElementToBeVisible(cc.getStartLearning());
		Thread.sleep(2000);
		int scrollX = 0; // horizontal scroll amount
		int scrollY = 400; // vertical scroll amount
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
		Thread.sleep(5000);
		DikshaUtils.waitToBeClickableAndClick(cc.getLeaveCoursetab());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getConfirmLeavebutton());
		Thread.sleep(2000);
	}

	public static void validateRecentlyPublishedCourse(String contentName) throws Exception {
		Groups groups = PageFactory.initElements(driver, Groups.class);
		UserHomeTab homeTab = new UserHomeTab();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(3000);
		groups.gethomeTab().click();
		Thread.sleep(3000);

		// js.executeScript("arguments[0].scrollIntoView(true);",
		// homeTab.getRecentlyPublishedCourse());
		js.executeScript("window.scrollBy('0', '1100')");
		DikshaUtils.waitWebDriver(3000);
//		Assert.assertTrue(homeTab.getRecentlyPublishedCourse().isDisplayed());
//		DikshaUtils.waitWebDriver(3000);
		groups.getclickContentCardRecentlyPublishedCourse().click();
		DikshaUtils.waitWebDriver(3000);
		String courseName = groups.getRecentlyPublishedCourseName().getText();
		Assert.assertEquals(courseName, contentName);
	}

	public static void validateAfterDeletingAdminGroup(String groupname) {

		Groups groups = PageFactory.initElements(driver, Groups.class);
		DikshaUtils.waitWebDriver(3000);
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitWebDriver(3000);
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		// Assert.assertFalse(groups.getValidateGroupIsSuccessfullyDeleted().isDisplayed());
		DikshaUtils.waitWebDriver(3000);
		String nameOfGroup = groups.getValidateGroupName().getText();
		Assert.assertEquals(groupname != "DeleteGroup", nameOfGroup != groupname);
		DikshaUtils.waitWebDriver(3000);
	}

	public static void createDiscussionForExistingGroupAndReplyToAnyDiscussion() throws InterruptedException {
		Groups groups = PageFactory.initElements(driver, Groups.class);
		DikshaUtils.waitToBeVisibleAndClick(groups.getDF_ForGroup());
		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnStrartDF());

		groups.getenterDFTopic().sendKeys("This is a Discussion Forum");

		groups.getenterElaborateQuestion().sendKeys("This is Elaborates Discussion Forum");

		groups.getenterTag().sendKeys("Discussion", Keys.ENTER);
		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnSubmit());
		DikshaUtils.waitToBeVisibleAndClick(groups.getclkCreatedDiscussion());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(groups.getclkReplyMsg1());

		groups.getclkReplyMsg1().sendKeys("Reply Message1", Keys.TAB, Keys.RETURN);
		Thread.sleep(10000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getclkPostReply());
		Thread.sleep(2000);

		Assert.assertTrue(groups.getclkReply().isDisplayed());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");

		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnEdit());

		groups.getenterDFTopic().clear();

		groups.getenterDFTopic().sendKeys("This is a Discussion Forum Update");

		groups.getenterElaborateQuestion().clear();

		groups.getenterElaborateQuestion().sendKeys("This is Elaborates Discussion Forum Update");

		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnUpdate());
		Thread.sleep(2000);

		Assert.assertTrue(groups.getAssertDFUpdated().isDisplayed());
		System.out.println("Discussion Forum Updated Successfully By Group Admin");

		Thread.sleep(2000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getkababmenu());
		Thread.sleep(1000);

		DikshaUtils.waitToBeVisibleAndClick(groups.getbtnDelete());

		driver.switchTo().alert().accept();
		Thread.sleep(1000);

		Assert.assertTrue(groups.getAssertDFDeleted().isDisplayed());
		System.out.println("Discussion Forum Deleted Successfully By Group Admin");

	}

	public static void openGroupAndVerifyMembersOfGroup() throws InterruptedException {
		Groups groups = PageFactory.initElements(driver, Groups.class);
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getExistingGroup());
		Thread.sleep(3000);
		Assert.assertTrue(groups.getassertGroupAdmin().isDisplayed());
		Assert.assertTrue(groups.getassertMember1().isDisplayed());
		Assert.assertTrue(groups.getassertMember2().isDisplayed());

	}

	public static void verifyViewDashBoardIsClickable() throws InterruptedException, IOException {
		Groups groups = PageFactory.initElements(driver, Groups.class);
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());
		DikshaUtils.waitToBeClickableAndClick(groups.getExistingGroup());
		Thread.sleep(3000);

		DikshaUtils.waitToBeClickableAndClick(groups.getaddActivity());
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(groups.getselectCourse());
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndSendKeys(groups.getsendCouresId(), excel.getContentName("CourseDoID"));
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(groups.getsearchBtn());
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(groups.getselectCourse1());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getaddCourseToGrp());
		Thread.sleep(1000);
		// DikshaUtils.waitToBeClickableAndClick(groups.getaddCourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(groups.getselectedCourse());
		Thread.sleep(1000);
		Assert.assertTrue(groups.getassertActivityDashBoard().isDisplayed());

	}

	public static void verifyFTUEPopupOnGroupCreation() throws InterruptedException {
		Groups groups = PageFactory.initElements(driver, Groups.class);
		DikshaUtils.waitToBeClickableAndClick(groups.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(groups.getMyGropus());
		DikshaUtils.waitToBeClickableAndClick(groups.getCrossTab());

		DikshaUtils.waitToBeClickableAndClick(groups.getclkGroupIcon());
		Thread.sleep(2000);
		Assert.assertTrue(groups.getassertFTUEPopUp().isDisplayed());
	}

}
