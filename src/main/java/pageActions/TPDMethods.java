package pageActions;

import java.security.Key;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.CourseConsumption;
import pageObject.CreateBatchForCourse;
import pageObject.CreateBook;
import pageObject.CreateCertificate;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ValidatePopUp;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.Library;
import utility.Listeners;

public class TPDMethods extends BaseClass {

	public static void createBatchAndVerify(String course) throws InterruptedException {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Creator should be able to create batch for course successfully";
		String actual = "Creator is unable to create batch for course ";
		String BatchCreatedPopup = null;
		try {
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateBatchButton()));
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateBatchButton());
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getBatchName(), "Batch 1");
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getDescription(),"This course is created via Automation");
			Thread.sleep(2000);
			Library.custom_click(createBatch.getIssueCertificateNo(), "IssueCertificateNo");
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getStartDate());

			Date.setTomorrowDate(driver, createBatch.getStartDate());
			Thread.sleep(500);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("3").perform();
			Thread.sleep(500);

			DikshaUtils.waitToBeClickableAndClick(createBatch.getEndDate());

			Date.setDayAfterTomorrowDate(driver, createBatch.getEndDate());
			Thread.sleep(500);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("3").perform();
			Thread.sleep(500);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getCourseterms());
			wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateButton()));
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateButton());
			Thread.sleep(2000);
			BatchCreatedPopup = popup.getBatchCreatedPopUp().getText();
//			Assert.assertEquals(BatchCreatedPopup, "Batch created successfully...");
			DikshaUtils.waitToBeClickableAndClick(createBatch.getBackAfterCreateBatchButton());
			Thread.sleep(2000);
			
			actual = "Creator is able to create batch for course successfully";
		} finally {
			String Text = BatchCreatedPopup != null ? BatchCreatedPopup : "N/A";
			Listeners.customAssert("Batch created successfully...", Text, expect, actual);
		}

	}

	public static void createBatch(String course) throws InterruptedException {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Creator should be able to create batch successfully";
		String actual = " Creator is unable to create batch for course ";
		String BatchCreatedPopup = null;
		try {
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateBatchButton()));

			DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateBatchButton());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getBatchName(), "Batch 1");
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getDescription(),
					"This course is created via Automation");
			Thread.sleep(2000);
			Library.custom_click(createBatch.getIssueCertificateNo(), "IssueCertificateNo");
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getStartDate());

			Date.setTodayDate(driver, createBatch.getStartDate());
			Thread.sleep(500);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("3").perform();
			Thread.sleep(500);

			DikshaUtils.waitToBeClickableAndClick(createBatch.getEndDate());

			Date.setTomorrowDate(driver, createBatch.getEndDate());
			Thread.sleep(500);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("3").perform();
			Thread.sleep(500);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getCourseterms());
			wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateButton()));
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateButton());
	//		Thread.sleep(2000);
	//		DikshaUtils.waitToBeVisibleAndClick(createBatch.getClosePopup());
			BatchCreatedPopup = popup.getBatchCreatedPopUp().getText();
	//		Assert.assertEquals(BatchCreatedPopup, "Batch created successfully...");
			Thread.sleep(1000);
	//		DikshaUtils.waitToBeClickableAndClick(createBatch.getBackAfterCreateBatchButton());
			actual = "Creator is able to create batch successfully";
		} finally {
			String Text = BatchCreatedPopup != null ? BatchCreatedPopup : "N/A";
			Listeners.customAssert("Batch created successfully...", Text, expect, actual);
		}

	}

	public static void verifyCourseTocAndDetail(String course) throws InterruptedException {

		String expect = "Course TOC and details should be display to creator";
		String actual = "Course TOC and details is not display to creator";
		String courseDetails = null;
		try {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);

		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());
		Thread.sleep(1000);
		String courseName = createBatch.getCourseName().getText();
		Assert.assertEquals(courseName, course);
		Assert.assertTrue(createBatch.getRatingsIcon().isDisplayed());
		Assert.assertTrue(createBatch.getCourseDetails().isDisplayed());
		courseDetails = createBatch.getCourseDetails().getText();
		actual = "Course TOC and details is display to creator";
		}finally {
			String Text = courseDetails != null ? courseDetails : "N/A";
			System.out.println(Text);
			Listeners.customAssert("Course details", Text, expect, actual);
			
		}
	}

	public static void verifyCourseModulesCollapseAllExpandAllFeature() throws InterruptedException {

		String expect = "Creator should collapse and expand course module";
		String actual = "Unable to collapse and expand course module";
		String collapseAllButton = null;
		try {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Assert.assertTrue(createBatch.getCourseModulesText().isDisplayed());
		Assert.assertTrue(createBatch.getCollapseAllButton().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCollapseAllButton());
		Assert.assertTrue(createBatch.getExpandAllButton().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getExpandAllButton());
		Assert.assertTrue(createBatch.getCollapseAllButton().isDisplayed());
		collapseAllButton = createBatch.getCollapseAllButton().getText();
		actual = "Creator collapse and expand course module successfully";
		}finally {
			String Text = collapseAllButton != null ? collapseAllButton : "N/A";
			System.out.println(Text);
			Listeners.customAssert("Collapse all", Text, expect, actual);
			
		}

	}

	public static void verifyDiffrentBatchesInCourse(String course) throws InterruptedException {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);


		String expect = "Creator should be able to create and verify batch successfully";
		String actual = " Creator is unable to create and verify batch for course ";
		String expiredBatchButton = null;
		try {
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateBatchButton()));

		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateBatchButton());
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getBatchName(), "Batch 1");
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getDescription(), "This course is created via Automation");
		Thread.sleep(2000);
		Library.custom_click(createBatch.getIssueCertificateNo(), "IssueCertificateNo");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getStartDate());

		Date.setTodayDate(driver, createBatch.getStartDate());
		Thread.sleep(500);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("3").perform();
		Thread.sleep(500);

		DikshaUtils.waitToBeClickableAndClick(createBatch.getEndDate());

		Date.setTomorrowDate(driver, createBatch.getEndDate());
		Thread.sleep(500);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("3").perform();
		Thread.sleep(500);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCourseterms());
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateButton()));
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateButton());
		Thread.sleep(2000);
		String BatchCreatedPopup = popup.getBatchCreatedPopUp().getText();
		Assert.assertEquals(BatchCreatedPopup, "Batch created successfully...");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getOngoingBatchButton());
		Assert.assertTrue(createBatch.getOngoingBatchButton().isDisplayed());
		Assert.assertTrue(createBatch.getUpcomingBatchButton().isDisplayed());
		Assert.assertTrue(createBatch.getExpiredBatchButton().isDisplayed());
		
		expiredBatchButton=createBatch.getExpiredBatchButton().getText();
		actual = "Creator is able to create and verify batch successfully";
		} finally {
			String Text = expiredBatchButton != null ? expiredBatchButton : "N/A";
			Listeners.customAssert("Expired", Text, expect, actual);
		}
	}

	public static void ChangeBatchStartDateForFutureBatch(String course) throws InterruptedException {

		String expect = "Creator should change batch start date for future batch";
		String actual = "Unable to change batch start date for future batch";
		String editBatchButton = null;
		try {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateBatchButton()));

		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateBatchButton());
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getBatchName(), "Batch 1");
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getDescription(), "This course is created via Automation");
		Thread.sleep(2000);
		Library.custom_click(createBatch.getIssueCertificateNo(), "IssueCertificateNo");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getStartDate());

		Date.setTomorrowDate(driver, createBatch.getStartDate());
		Thread.sleep(500);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("3").perform();
		Thread.sleep(500);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getEndDate());
		Date.setDayAfterTomorrowDate(driver, createBatch.getEndDate());
		Thread.sleep(500);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("3").perform();
		Thread.sleep(500);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCourseterms());
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateButton()));
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateButton());
		Thread.sleep(2000);
		String BatchCreatedPopup = popup.getBatchCreatedPopUp().getText();
		Assert.assertEquals(BatchCreatedPopup, "Batch created successfully...");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getBackAfterCreateBatchButton());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getOngoingBatchButton());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getUpcomingBatchButton());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getEditBatchButton());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getStartDate());

		Date.setTodayDate(driver, createBatch.getStartDate());
		Thread.sleep(500);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("3").perform();
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,50)");
		DikshaUtils.waitToBeClickableAndClick(createBatch.getUpdateBatchButton());
		Thread.sleep(5000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getUpcomingBatchButton());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getOngoingBatchButton());
		Assert.assertTrue(createBatch.getEditBatchButton().isDisplayed());
		editBatchButton = createBatch.getEditBatchButton().getText();
		actual = "Batch start date for future batch change successfully";
		}finally {
			String Text = editBatchButton != null ? editBatchButton : "N/A";
			System.out.println(Text);
			Listeners.customAssert("Edit", Text, expect, actual);
		}

	}
	public static void verifyreduceBatchEndDate(String course) throws InterruptedException {

		String expect = "Creator should reduce batch end date successfully";
		String actual = "Creator unable to reduce batch end adte";
		String editBatchButton = null;
		try {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateBatchButton()));

		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateBatchButton());
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getBatchName(), "Batch 1");
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getDescription(), "This course is created via Automation");
		Thread.sleep(2000);
		Library.custom_click(createBatch.getIssueCertificateNo(), "IssueCertificateNo");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getStartDate());

		Date.setTodayDate(driver, createBatch.getStartDate());
		Thread.sleep(500);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("3").perform();
		Thread.sleep(500);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getEndDate());
		Date.setDayAfterTomorrowDate(driver, createBatch.getEndDate());
		Thread.sleep(500);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("3").perform();
		Thread.sleep(500);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCourseterms());
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateButton()));
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateButton());
		Thread.sleep(2000);
		String BatchCreatedPopup = popup.getBatchCreatedPopUp().getText();
		Assert.assertEquals(BatchCreatedPopup, "Batch created successfully...");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getBackAfterCreateBatchButton());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getEditBatchButton());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getEndDate());

		Date.setTomorrowDate(driver, createBatch.getEndDate());
		Thread.sleep(500);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("3").perform();
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,50)");
		DikshaUtils.waitToBeClickableAndClick(createBatch.getUpdateBatchButton());
		Thread.sleep(5000);
		Assert.assertTrue(createBatch.getEditBatchButton().isDisplayed());
		editBatchButton = createBatch.getEditBatchButton().getText();
		actual = "Creator successfully reduce batch end date";
		}finally {
			String Text = editBatchButton != null ? editBatchButton : "N/A";
			System.out.println(Text);
			Listeners.customAssert("Edit", Text, expect, actual);			
		}

	}
	public static void enrollmentEndDateIsNotDisplayed(String course) throws InterruptedException {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateBatchButton()));

		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateBatchButton());
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getBatchName(), "Batch 1");
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getDescription(), "This course is created via Automation");
		Thread.sleep(2000);
		Library.custom_click(createBatch.getIssueCertificateNo(), "IssueCertificateNo");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getStartDate());

		Date.setTodayDate(driver, createBatch.getStartDate());
		Thread.sleep(500);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("3").perform();
		Thread.sleep(500);

		DikshaUtils.waitToBeClickableAndClick(createBatch.getEndDate());
		Date.setDayAfterTomorrowDate(driver, createBatch.getEndDate());
		Thread.sleep(500);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("3").perform();
		Thread.sleep(500);

		DikshaUtils.waitToBeClickableAndClick(createBatch.getCourseterms());
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateButton()));
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateButton());
		Thread.sleep(2000);
		String BatchCreatedPopup = popup.getBatchCreatedPopUp().getText();
		Assert.assertEquals(BatchCreatedPopup, "Batch created successfully...");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getBackAfterCreateBatchButton());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());
		Thread.sleep(1000);
		WebElement EnrollmentEndDate = createBatch.getVerifyEnrollmentEndDate();
		Assert.assertTrue((EnrollmentEndDate != null));

	}

	public static void userReEnrollsInCourse(String coursename) throws InterruptedException {
		String expect = "User should reenrolls in course";
		String actual = "Unable to reenrolls in course";
		String courseProgress = null;
		try {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		cc.getSearchtextfield().clear();
		Thread.sleep(2000);
		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(5000);
		Library.custom_click(cc.getSearchbutton(), "search button");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
		Thread.sleep(2000);
		Library.custom_click(cc.getJoincourse(), "Join course");
		Thread.sleep(2000);
		WebElement courseProgresstext = driver.findElement(By.xpath("//div[text()='66% ']"));
		courseProgress = courseProgresstext.getText();
		//Assert.assertEquals(courseProgress, "66% Completed");
		actual = "User reenrolls in course successfully";
		}finally {
			String Text = courseProgress != null ? courseProgress : "N/A";

            Listeners.customAssert("66% Completed", Text, expect, actual);
			
		}
	}

	public static void verifyDiscussionForumIsDefaultDisabled(String course) throws InterruptedException {

		String expect = "Discussion forum should be disable by default";
		String actual = "Discussion forum is not disable by default";
		String yesButton = null;
		try {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);

		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateBatchButton()));

		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateBatchButton());
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getBatchName(), "Batch 1");
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getDescription(), "This course is created via Automation");
		Thread.sleep(2000);
		Library.custom_click(createBatch.getIssueCertificateNo(), "IssueCertificateNo");
		Thread.sleep(2000);
		boolean DisableDF = createBatch.getDisableDiscussionsButton().isSelected();
		Assert.assertTrue(DisableDF);
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getEnableDiscussionsButton());
		Thread.sleep(1000);
		Assert.assertTrue(createBatch.getVerifyDFEnableButton().isSelected());
		yesButton = driver.findElement(By.xpath("//*[text()='Yes']")).getText();
		actual = "Discussion forum is disable by default";
		}finally {
			String Text = yesButton != null ? yesButton : "N/A";

            Listeners.customAssert("Yes", Text, expect, actual);
			
		}
	}

	public static void verifyDiscussionForumIsEnabled(String course) throws InterruptedException {

		String expect = "Discussion forum should be enabled";
		String actual = "Discussion forum is not enabled";
		String yesButton = null;
		try {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);

		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateBatchButton()));

		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateBatchButton());
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getBatchName(), "Batch 1");
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getDescription(), "This course is created via Automation");
		Thread.sleep(2000);
		Library.custom_click(createBatch.getIssueCertificateNo(), "IssueCertificateNo");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getEnableDiscussionsButton());
		Thread.sleep(1000);
		Assert.assertTrue(createBatch.getVerifyDFEnableButton().isSelected());
		yesButton = driver.findElement(By.xpath("//*[text()='Yes']")).getText();
		actual = "Discussion forum is enabled";
		}finally {
			String Text = yesButton != null ? yesButton : "N/A";

            Listeners.customAssert("Yes", Text, expect, actual);
			
		}
	}

	public static void createBatchAndAddCertificate(String course) throws InterruptedException {

		String expect = "Creator should be able to create batch for course successfully";
		String actual = "Creator is unable to create batch for course ";
		String BatchCreatedPopup = null;
		
		try {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateBatchButton()));

		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateBatchButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getBatchName(), "Batch 1");
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getDescription(), "This course is created via Automation");
		Thread.sleep(2000);
		Library.custom_click(createBatch.getIssueCertificateYes(), "IssueCertificateNo");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getStartDate());

		Date.setTodayDate(driver);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(1000);
		action.sendKeys("3").perform();
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(createBatch.getEndDate());

		Date.setTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(1000);
		action.sendKeys("3").perform();
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCourseterms());
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateButton()));
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateButton());
		BatchCreatedPopup = popup.getBatchCreatedPopUp().getText();
		Thread.sleep(5000);
		DikshaUtils.waitToBeVisibleAndClick(createBatch.getClosePopup());
		actual = "Creator is able to create batch for course successfully";
		} finally {
			String Text = BatchCreatedPopup != null ? BatchCreatedPopup : "N/A";
			Listeners.customAssert("Batch created successfully...", Text, expect, actual);
		}
	}
	

	public static void verifyOneBatchInCourse(String course) throws InterruptedException {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Creator should be able to verify that only one open batch is present";
		String actual = "Cerator is unable to verify one open batch only";
		String verifyOneBatch = null;
		try {
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
			Thread.sleep(5000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateBatchButton()));

			DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateBatchButton());
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getBatchName(), "Batch 1");
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getDescription(),
					"This course is created via Automation");
			Thread.sleep(2000);
			Library.custom_click(createBatch.getIssueCertificateNo(), "IssueCertificateNo");
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getStartDate());

			Date.setTodayDate(driver, createBatch.getStartDate());
			Thread.sleep(500);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("3").perform();
			Thread.sleep(500);

			DikshaUtils.waitToBeClickableAndClick(createBatch.getEndDate());

			Date.setTomorrowDate(driver, createBatch.getEndDate());
			Thread.sleep(500);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("3").perform();
			Thread.sleep(500);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getCourseterms());
			wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateButton()));
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateButton());
			Thread.sleep(2000);
			String BatchCreatedPopup = popup.getBatchCreatedPopUp().getText();
			Assert.assertEquals(BatchCreatedPopup, "Batch created successfully...");
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getOngoingBatchButton());
			DikshaUtils.waitToBeClickableAndClick(createBatch.getUpcomingBatchButton());
			DikshaUtils.waitForElementToBeVisible(createBatch.getNoBatchFoundMsg());
			Assert.assertTrue(createBatch.getNoBatchFoundMsg().isDisplayed());
			DikshaUtils.waitToBeClickableAndClick(createBatch.getUpcomingBatchButton());
			DikshaUtils.waitToBeClickableAndClick(createBatch.getExpiredBatchButton());
			DikshaUtils.waitForElementToBeVisible(createBatch.getNoBatchFoundMsg());
			Assert.assertTrue(createBatch.getNoBatchFoundMsg().isDisplayed());
			Thread.sleep(1000);
			verifyOneBatch = createBatch.getNoBatchFoundMsg().getText();
			Thread.sleep(1000);
			actual = "Creator is able to verify that only one open batch is present";
		} finally {
			String Text = createBatch.getNoBatchFoundMsg() != null ? verifyOneBatch : "N/A";
			Listeners.customAssert(verifyOneBatch, Text, expect, actual);
		}

	}



	public static void userEnrollsInCourse(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

 

        String expect = "Custodian User should be able to enroll in course successfully";

        String actual = "Custodian User is unable to enroll in course ";

        String StartLearningButton = null;

        try {

            cc.getSearchtextfield().clear();

            Thread.sleep(2000);

            Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");

            Thread.sleep(5000);

            Library.custom_click(cc.getSearchbutton(), "search button");

            Thread.sleep(1000);

 

            DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());

            Thread.sleep(2000);

            Library.custom_click(cc.getJoincourse(), "Join course");

            Thread.sleep(2000);

            DikshaUtils.waitToBeClickableAndClick(cc.getConsentcheckbox());

            Thread.sleep(2000);

            Library.custom_click(cc.getShareButton(), "Share Button");

            DikshaUtils.waitForElementToBeVisible(cc.getStartLearning());

            Assert.assertTrue(cc.getStartLearning().isDisplayed());

            Thread.sleep(3000);

            StartLearningButton = cc.getStartLearning().getText();

            Thread.sleep(1000);

            actual = "Custodian User is able to enroll in course successfully";

        } finally {

            String Text = StartLearningButton!= null ? StartLearningButton : "N/A";

            Listeners.customAssert("Start learning",Text, expect, actual);

        }

    }
	public static void ValidateuserIgnorNameChangePopup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		DikshaUtils.waitToBeVisibleAndClick(cc.getStartLearning());
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.CloseChangeNamePopup());
		DikshaUtils.waitToBeVisibleAndClick(cc.getStartLearning());
		Thread.sleep(1000);
		Assert.assertTrue(cc.CloseChangeNamePopup().isDisplayed());
		DikshaUtils.waitToBeVisibleAndClick(cc.DoNotShowMessageAgainCheckbox());
		DikshaUtils.waitToBeVisibleAndClick(cc.DoNotShowMessageAgainContinueButton());
		Thread.sleep(2000);
		DikshaUtils.waitForElementToBeVisible(cc.getStartLearning());
		Thread.sleep(1000);
		WebElement Checkbox = cc.DoNotShowMessageAgainCheckbox();
		Assert.assertTrue((Checkbox != null));

	}

	public static void userReEnrollInCourse(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		Thread.sleep(2000);
		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(5000);
		Library.custom_click(cc.getSearchbutton(), "search button");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
		Thread.sleep(2000);
		Library.custom_click(cc.getJoincourse(), "Join course");
		Thread.sleep(4000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getBackButton());
	}

	public static void ValidateCourseDetails(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		Thread.sleep(3000);
		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(3000);
		Library.custom_click(cc.getSearchbutton(), "search button");
		Thread.sleep(2000);

		String CourseName = cc.getSearchedcourse().getText();
		System.out.println(CourseName);
		Assert.assertEquals(CourseName, coursename);

		Assert.assertTrue(cc.getOrgName().isDisplayed());
		Assert.assertTrue(cc.getContentTypeAsCourse().isDisplayed());
	}

	public static void ValidateCreatedAndUpdatedDateInTOCPage() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 700)");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getCreditsAndlicenseinfo());
		Thread.sleep(2000);

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		String formattedDate = currentDate.format(formatter);

		WebElement Createddate = cc.getCreatedDate();
		WebElement Updateddate = cc.getUpdatedDate();

		String CeratedDateText = Createddate.getText();
		System.out.println(CeratedDateText);

		String UpdatedDateText = Updateddate.getText();
		System.out.println(UpdatedDateText);

		if (CeratedDateText.equals(formattedDate)) {
			System.out.println("Today's date matches the element text.");
		} else {
			System.out.println("Today's date does not match the element text.");
		}

		Thread.sleep(2000);
		Assert.assertTrue(CeratedDateText.equals(formattedDate));
		Assert.assertTrue(UpdatedDateText.equals(formattedDate));

	}

	public static void userAbleToSeeEntireDetails() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		Thread.sleep(2000);
		Assert.assertTrue(cc.getCourseModules().isDisplayed());
		Assert.assertTrue(cc.getCourseDetails().isDisplayed());
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		Assert.assertTrue(cc.getBatchDetails().isDisplayed());
		Assert.assertTrue(cc.getCreditsAndlicenseinfo().isDisplayed());

	}

	public static void userEnrollsInCourseWithDoNotShareButton(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		Thread.sleep(2000);
		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(5000);
		Library.custom_click(cc.getSearchbutton(), "search button");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
		Thread.sleep(2000);
		Library.custom_click(cc.getJoincourse(), "Join course");
		Thread.sleep(2000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(1000);
		Assert.assertTrue(cc.getDoNOtShareButton().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getDoNOtShareButton());
		DikshaUtils.waitForElementToBeVisible(cc.getStartLearning());
		Assert.assertTrue(cc.getStartLearning().isDisplayed());

	}

	public static void userUnenrollsInCourse(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		String expect = "User should able to unenrolls in course";
		String actual = "Unable to unenrolls in course";
		String unenroll = null;
		try {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
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
		WebElement unenrollPopup = driver.findElement(By.xpath("//strong[text()='updated successfully']"));
		unenroll = unenrollPopup.getText();
		Assert.assertEquals(unenroll, "updated successfully");
		actual = "User unenrolls in course successfully";
		}finally {
			String Text = unenroll != null ? unenroll : "N/A";
			System.out.println(Text);
			Listeners.customAssert("updated successfully", Text, expect, actual);
			
		}

	}


	public static void openDiscussionForum(String course) throws InterruptedException {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Creator should be able to open Discussion Forum for course successfully";
		String actual = "Creator is unable to open DiscussionForum for course";
		String DFforum = null;
		try {
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
			Thread.sleep(5000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateBatchButton()));

			DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateBatchButton());
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getBatchName(), "Batch 1");
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getDescription(),
					"This course is created via Automation");
			Thread.sleep(2000);
			Library.custom_click(createBatch.getIssueCertificateNo(), "IssueCertificateNo");
			Thread.sleep(2000);
			DikshaUtils.waitForElementToBeClickable(createBatch.getEnableDiscussionsButton());
			DikshaUtils.waitToBeClickableAndClick(createBatch.getEnableDiscussionsButton());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getStartDate());

			Date.setTodayDate(driver, createBatch.getStartDate());
			Thread.sleep(500);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("3").perform();
			Thread.sleep(500);

			DikshaUtils.waitToBeClickableAndClick(createBatch.getEndDate());

			Date.setTomorrowDate(driver, createBatch.getEndDate());
			Thread.sleep(500);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("3").perform();
			Thread.sleep(500);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getCourseterms());
			wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateButton()));
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateButton());
			Thread.sleep(5000);
			String BatchCreatedPopup = popup.getBatchCreatedPopUp().getText();
			Assert.assertEquals(BatchCreatedPopup, "Batch created successfully...");
			Thread.sleep(3000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getBackAfterCreateBatchButton());
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());
			DikshaUtils.waitForElementToBeVisible(createBatch.getViewDashboardButton());
			DikshaUtils.waitToBeClickableAndClick(createBatch.getViewDashboardButton());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSelectBatchDropdown());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getBatchSelected());
			Thread.sleep(5000);
			DikshaUtils.waitForElementToBeVisible(createBatch.getDiscussionForumIcon());
			Assert.assertTrue(createBatch.getDiscussionForumIcon().isDisplayed());
			Thread.sleep(1000);
			DFforum = createBatch.getDiscussionForumIcon().getText();
			Thread.sleep(1000);
			actual = "Creator is able to open Discussion Forum for course successfully";

		} finally {
			String Text = createBatch.getDiscussionForumIcon() != null ? DFforum : "N/A";
			Listeners.customAssert(DFforum, Text, expect, actual);
		}

	}

	public static void addMentor(String course) throws InterruptedException {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		String expect = "Creator should be able to add mentor for course successfully";
		String actual = "Creator is unable to add mentor for course";
		String mentorAdded = null;
		try {
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
			Thread.sleep(5000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateBatchButton()));

			DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateBatchButton());
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getBatchName(), "Batch 1");
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getDescription(),
					"This course is created via Automation");
			Thread.sleep(2000);
			Library.custom_click(createBatch.getIssueCertificateNo(), "IssueCertificateNo");
			Thread.sleep(2000);
			DikshaUtils.waitForElementToBeClickable(createBatch.getEnableDiscussionsButton());
			DikshaUtils.waitToBeClickableAndClick(createBatch.getEnableDiscussionsButton());
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getStartDate());

			Date.setTodayDate(driver, createBatch.getStartDate());
			Thread.sleep(500);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("3").perform();
			Thread.sleep(500);

			DikshaUtils.waitToBeClickableAndClick(createBatch.getEndDate());

			Date.setTomorrowDate(driver, createBatch.getEndDate());
			Thread.sleep(500);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("3").perform();
			Thread.sleep(500);
			int scrollX = 0; // horizontal scroll amount
			int scrollY = 150; // vertical scroll amount
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSelectMentorDropdown());

			js.executeScript("arguments[0].scrollIntoView(true);", createBatch.getMentorSelected());
			DikshaUtils.waitToBeClickableAndClick(createBatch.getMentorSelected());
			Thread.sleep(1000);
			mentorAdded = createBatch.getMentorSelected().getText();
			action.sendKeys(Keys.TAB).perform();
			DikshaUtils.waitToBeClickableAndClick(createBatch.getCourseterms());
			wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateButton()));
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateButton());
			Thread.sleep(2000);
			String BatchCreatedPopup = popup.getBatchCreatedPopUp().getText();
			Assert.assertEquals(BatchCreatedPopup, "Batch created successfully...");
			Thread.sleep(2000);
			DikshaUtils.waitToBeVisibleAndClick(createBatch.getBackAfterCreateBatchButton());
			Thread.sleep(5000);
			actual = "Creator is able to add mentor for course successfully";
		} finally {
			String Text = createBatch.getMentorSelected() != null ? mentorAdded : "N/A";
			Listeners.customAssert(mentorAdded, Text, expect, actual);
		}
	}

	public static void verifyAddMentor(String course) throws InterruptedException {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);

		String expect = "Creator should be able to verify added mentor for course successfully";
		String actual = "Creator is unable to verify added mentor for course";
		String verifymentorAdded = null;
		try {
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
			Thread.sleep(5000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());
			Thread.sleep(2000);
			Assert.assertTrue(createBatch.getViewDashboardButton().isDisplayed());
			Thread.sleep(2000);
			verifymentorAdded = createBatch.getViewDashboardButton().getText();
			actual = "Creator is able to verify added mentor for course successfully";
		} finally {
			String Text = createBatch.getViewDashboardButton() != null ? verifymentorAdded : "N/A";
			Listeners.customAssert(verifymentorAdded, Text, expect, actual);
		}
	}

	public static void userPerformKeyboardEventInNewTheme() throws Exception {

		CreateBook create = PageFactory.initElements(driver, CreateBook.class);
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		DikshaUtils.waitToBeClickableAndClick(create.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(home.getClassicTheme());
		DikshaUtils.waitToBeClickableAndClick(home.getHomeTab());
		Thread.sleep(1000);
		home.getHomeTab().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		home.getdigitalTextbookTab().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		home.getCourseTab().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		home.getTVClassesTab().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		home.getAllTab().sendKeys(Keys.TAB);
		Thread.sleep(1000);

	}


	public static void UserNotAbleToSeeCourseInMyCourseSection(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		Thread.sleep(2000);

		DikshaUtils.waitToBeClickableAndClick(cc.getCoursetab());
		DikshaUtils.waitToBeClickableAndClick(cc.getViewall());
		String dynamicValue = coursename;

		String xpath = String.format("//bdi[text()='%s']", dynamicValue);
		WebElement element = driver.findElement(By.xpath(xpath));
		Thread.sleep(2000);

		Assert.assertTrue((element == null));
	}

	public static void ValidateUserbleToSearchAndGetMatchingContent() throws InterruptedException {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
		Thread.sleep(2000);
		Assert.assertTrue(home.getAllTabText().isDisplayed());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(home.getHomeTab());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndSendKeys(cc.getSearchtextfield(), "Course Assesment");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
		Thread.sleep(2000);
		Assert.assertTrue(cc.CardNameAsCourse().isDisplayed());
		Assert.assertTrue(cc.CardNameAsCourseAssesment().isDisplayed());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(home.getHomeTab());
		DikshaUtils.waitToBeClickableAndSendKeys(cc.getSearchtextfield(), "Textbook");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
		Thread.sleep(2000);
		Assert.assertTrue(cc.CardNameAsTextbook().isDisplayed());

	}

	public static void UserAbleToSeeCourseInMyCourseSection(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(cc.getCoursetab());
		DikshaUtils.waitToBeClickableAndClick(cc.getViewall());
		Thread.sleep(1000);
		String dynamicValue = coursename;

		String xpath = String.format("//bdi[text()='%s']", dynamicValue);
		WebElement element = driver.findElement(By.xpath(xpath));
		Thread.sleep(2000);
		Assert.assertTrue(element.isDisplayed());

	}


	public static void createFutureBatchAndVerify(String course) throws InterruptedException {

		String expect = "Creator should create future batch successfully";
		String actual = "Creator unable create future batch successfully";
		String editBatchButton = null;
		
		try {
			
		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateBatchButton()));
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateBatchButton());
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getBatchName(), "Batch 1");
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getDescription(), "This course is created via Automation");
		Thread.sleep(2000);
		Library.custom_click(createBatch.getIssueCertificateNo(), "IssueCertificateNo");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getStartDate());

		Date.setTomorrowDate(driver, createBatch.getStartDate());
		Thread.sleep(500);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("3").perform();
		Thread.sleep(500);

		DikshaUtils.waitToBeClickableAndClick(createBatch.getEndDate());

		Date.setDayAfterTomorrowDate(driver, createBatch.getEndDate());
		Thread.sleep(500);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("3").perform();
		Thread.sleep(500);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCourseterms());
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateButton()));
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateButton());
		Thread.sleep(2000);
		String BatchCreatedPopup = popup.getBatchCreatedPopUp().getText();
		Assert.assertEquals(BatchCreatedPopup, "Batch created successfully...");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getBackAfterCreateBatchButton());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());
		DikshaUtils.waitForElementToBeVisible(createBatch.getViewDashboardButton());
		Assert.assertTrue(createBatch.getViewDashboardButton().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getOngoingBatchButton());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getUpcomingBatchButton());
		Assert.assertTrue(createBatch.getEditBatchButton().isDisplayed());
		editBatchButton = createBatch.getEditBatchButton().getText();
		actual = "Creator create future batch successfully";
		}finally {
			String Text = editBatchButton != null ? editBatchButton : "N/A";
			Listeners.customAssert("Edit", Text, expect, actual);
			
		}

	}

	public static void VerifyCreateBatchButtonIsDisable(String course) throws InterruptedException {
		String expect = "Create batch button should be disable if there is upcoming batch";
		String actual = "Create batch button is not disable";
		String editBatchButton = null;
		
		try {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateBatchButton()));
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateBatchButton());
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getBatchName(), "Batch 1");
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getDescription(), "This course is created via Automation");
		Thread.sleep(2000);
		Library.custom_click(createBatch.getIssueCertificateNo(), "IssueCertificateNo");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getStartDate());

		Date.setTomorrowDate(driver, createBatch.getStartDate());
		Thread.sleep(500);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("3").perform();
		Thread.sleep(500);

		DikshaUtils.waitToBeClickableAndClick(createBatch.getEndDate());

		Date.setDayAfterTomorrowDate(driver, createBatch.getEndDate());
		Thread.sleep(500);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("3").perform();
		Thread.sleep(500);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCourseterms());
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateButton()));
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateButton());
		Thread.sleep(2000);
		String BatchCreatedPopup = popup.getBatchCreatedPopUp().getText();
		Assert.assertEquals(BatchCreatedPopup, "Batch created successfully...");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getBackAfterCreateBatchButton());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());
		DikshaUtils.waitForElementToBeVisible(createBatch.getViewDashboardButton());
		Assert.assertTrue(createBatch.getViewDashboardButton().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getOngoingBatchButton());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getUpcomingBatchButton());
		Assert.assertTrue(createBatch.getEditBatchButton().isDisplayed());
		
		editBatchButton = createBatch.getEditBatchButton().getText();

		Thread.sleep(2000);
		WebElement createBatchButton = createBatch.getCreateBatchButton();
		if (createBatchButton == null) {
			System.out.println("createBatchButton is present.");
			// Perform further actions or assertions when the element is present
		} else {
			System.out.println("createBatchButton is not present.");
			// Perform alternative actions or assertions when the element is not present
		}
		actual = "Create batch button is disable";
		}finally {
			String Text = editBatchButton != null ? editBatchButton : "N/A";
			Listeners.customAssert("Edit", Text, expect, actual);
			
		}
	}

	public static void VerifyDFforUser(String course) throws InterruptedException {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
		Thread.sleep(7000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());
		DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		Thread.sleep(2000);
		Assert.assertTrue(createBatch.getDiscussionForumIcon().isDisplayed());

	}

	public static void mentorEditTheCourse(String course) throws InterruptedException {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);

		String expect = "Mentor should be able to edit the course successfully";
		String actual = "mentor is unable edit the course";
		String verifymentorAdded = null;
		try {
			DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
			Thread.sleep(5000);
			DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());
			Thread.sleep(2000);
			Assert.assertTrue(createBatch.getViewDashboardButton().isDisplayed());
			Thread.sleep(2000);
			verifymentorAdded = createBatch.getViewDashboardButton().getText();
			actual = "Mentor is able to edit the course successfully";
		} finally {
			String Text = createBatch.getViewDashboardButton() != null ? verifymentorAdded : "N/A";
			Listeners.customAssert(verifymentorAdded, Text, expect, actual);
		}

	}


	public static void viewDashboardAndRequestTheReport(String course) throws Exception {


//		WebElement home = null;
//	    String except = "View Dashboard and request report  " + course + " Successfully";
//	    String actual = "Unable to view dashboard ans request report " + course;
//	    try {
//
//		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
//
//		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
//		Thread.sleep(10000);
//		createBatch.getSearchtextfield().clear();
//		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
//		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
//		Thread.sleep(1000);
//		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());
//		DikshaUtils.waitForElementToBeVisible(createBatch.getViewDashboardButton());
//		Assert.assertTrue(createBatch.getViewDashboardButton().isDisplayed());
//		DikshaUtils.waitToBeClickableAndClick(createBatch.getViewDashboardButton());
//		Thread.sleep(1000);
//		DikshaUtils.waitToBeClickableAndClick(createBatch.getClickCertificateTabInViewDashboard());
//		DikshaUtils.waitToBeClickableAndClick(createBatch.getClickCertificateTabInViewDashboard());
//		DikshaUtils.waitToBeClickableAndClick(createBatch.getclickBatchesTabInViewDashboard());
//		DikshaUtils.waitToBeClickableAndClick(createBatch.getselectBatchDropdownInViewDashboard());
//		DikshaUtils.waitToBeClickableAndClick(createBatch.getclickBatchesDrpDwnValuesInViewDashboard());
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		int scrollX = 0; // horizontal scroll amount
//		int scrollY = 130; // vertical scroll amount
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		js1.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
//		Thread.sleep(3000);
//		DikshaUtils.waitToBeVisibleAndClick(createBatch.getclickChooseReportDropDwnInViewDashboard());
//		DikshaUtils.waitToBeClickableAndClick(createBatch.getclickBatchesDrpDwnValuesInViewDashboard());
//		// UserOnBoarding.usePasswordForReportRequest("Creator");
//		// commented the code usePasswordForReportRequest - to update after code push
//		Thread.sleep(3000);
//		String reportDate = createBatch.getValidateCurrentDateInReport().getText();
//		String date = Date.todayDate();
//		Assert.assertEquals(reportDate, date);
//		js1.executeScript("window.scrollBy(130,150);");
////		Assert.assertTrue(createBatch.getvalidateSuccessTabInReport().isDisplayed());
////		Thread.sleep(3000);
//		js.executeScript("window.scrollBy(0,-300);");
//		// DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getenterReportRequestPasswordInViewDashboard(),"");
//		 home = driver.findElement(By.xpath("//*[contains(text(),'Status')]//following::span[contains(text(),'SUBMITTED')]"));
//	        Thread.sleep(2000);
//	        
//	        actual = "Successfully viewed dashboard and requwsted report " + course;
//	    }  finally {
//	        String homeText = home != null ? home.getText() : "N/A";
//	        System.out.println(homeText);
//	        Listeners.customAssert("SUBMITTED", homeText, except, actual);
//	    }
		WebElement home = null;
        String except = "View Dashboard and request report  " + course + " Successfully";
        String actual = "Unable to view dashboard ans request report " + course;
        try {

 

            CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
            LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
            Thread.sleep(10000);
            createBatch.getSearchtextfield().clear();
            DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
            DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
            Thread.sleep(1000);
            DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());
            DikshaUtils.waitForElementToBeVisible(createBatch.getViewDashboardButton());
            Assert.assertTrue(createBatch.getViewDashboardButton().isDisplayed());
            DikshaUtils.waitToBeClickableAndClick(createBatch.getViewDashboardButton());
            Thread.sleep(1000);
            DikshaUtils.waitToBeClickableAndClick(createBatch.getClickCertificateTabInViewDashboard());
            DikshaUtils.waitToBeClickableAndClick(createBatch.getclickBatchesTabInViewDashboard());
            DikshaUtils.waitToBeClickableAndClick(createBatch.getselectBatchDropdownInViewDashboard());
            DikshaUtils.waitToBeClickableAndClick(createBatch.getclickBatchesDrpDwnValuesInViewDashboard());
            JavascriptExecutor js = (JavascriptExecutor) driver;
            int scrollX = 0; // horizontal scroll amount
            int scrollY = 130; // vertical scroll amount
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.scrollBy(" + scrollX + ", " + scrollY + ");");
            Thread.sleep(3000);
            DikshaUtils.waitToBeVisibleAndClick(createBatch.getclickChooseReportDropDwnInViewDashboard());
            DikshaUtils.waitToBeClickableAndClick(createBatch.getclickBatchesDrpDwnValuesInViewDashboard());
            UserOnBoarding.usePasswordForReportRequest("Creator");
            String reportDate = createBatch.getValidateCurrentDateInReport().getText();
            String date = Date.todayDate();
            Assert.assertEquals(reportDate, date);
            js1.executeScript("window.scrollBy(130,150);");
            Assert.assertTrue(createBatch.getvalidateSuccessTabInReport().isDisplayed());
            Thread.sleep(3000);
            DikshaUtils.waitToBeVisibleAndClick(createBatch.getclickChooseReportDropDwnInViewDashboard());
            DikshaUtils.waitToBeClickableAndClick(createBatch.getclickBatchesDrpDwnValuesInViewDashboard());
            UserOnBoarding.usePasswordForReportRequest("Creator");
            Assert.assertTrue(createBatch.getValidateRequestReportFailed().isDisplayed());
//        Thread.sleep(3000);
            js.executeScript("window.scrollBy(0,-300);");
            // DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getenterReportRequestPasswordInViewDashboard(),"");
            home = createBatch.getValidateRequestReportFailed();
            Thread.sleep(2000);

 

            actual = "Successfully EnabledDiscussionsOption ";
        } finally {
            String homeText = home != null ? home.getText() : "N/A";
            System.out.println(homeText);
            Listeners.customAssert("Home", homeText, except, actual);
        }
	}

	public static void userPerformKeyboardEventInOldTheme() throws Exception {

		CreateBook create = PageFactory.initElements(driver, CreateBook.class);
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		DikshaUtils.waitToBeClickableAndClick(home.getHomeTab());
		Thread.sleep(1000);
		home.getHomeTab().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		home.getdigitalTextbookTab().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		home.getCourseTab().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		home.getTVClassesTab().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		home.getAllTab().sendKeys(Keys.TAB);
		Thread.sleep(1000);

	}

	public static void VerifyHomeAndExploreTabsForNonLoggedInUser() throws Exception {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		Thread.sleep(1000);
		Assert.assertTrue(home.getHomeTab().isDisplayed());
		Assert.assertTrue(home.getdigitalTextbookTab().isDisplayed());
		Assert.assertTrue(home.getCourseTab().isDisplayed());
		Assert.assertTrue(home.getTVClassesTab().isDisplayed());
		Assert.assertTrue(home.getAllTab().isDisplayed());

	}

	public static void VerifyHomeAndExploreTabsForLoggedInUser() throws Exception {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		Thread.sleep(1000);
		Assert.assertTrue(home.getHomeTab().isDisplayed());
		Assert.assertTrue(home.getdigitalTextbookTab().isDisplayed());
		Assert.assertTrue(home.getCourseTab().isDisplayed());
		Assert.assertTrue(home.getTVClassesTab().isDisplayed());
		Assert.assertTrue(home.getAllTab().isDisplayed());

	}

	public static void VerifyGuestUserPreferencesForBMC() throws Exception {

		HomePage home = PageFactory.initElements(driver, HomePage.class);

		DikshaUtils.waitToBeClickableAndClick(home.getHomeTab());
		Thread.sleep(1000);
		Assert.assertTrue(home.getChnagePreferences().isDisplayed());
		Assert.assertTrue(home.getBoardValue().isDisplayed());
		Assert.assertTrue(home.getMediumValue().isDisplayed());
		Assert.assertTrue(home.getClassValue().isDisplayed());

	}

	public static void userShareCourseWithoutEnroll(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		Thread.sleep(2000);
		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(5000);
		Library.custom_click(cc.getSearchbutton(), "search button");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getBeforeShareButton().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(cc.getBeforeShareButton());

		System.out.println("User Share Course Without Enrolling The Course");

	}

	public static void userDisplayedExpireBatchMessage() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);

		Thread.sleep(5000);
		DikshaUtils.waitToBeClickableAndSendKeys(cc.getSearchtextfield(), "Sst_sem_3 deled");
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		DikshaUtils.waitToBeClickableAndClick(cc.getselectCourse());
		Thread.sleep(2000);

		String ExpireBatch = popup.getexpireBatchPopUp().getText();
		Assert.assertEquals(ExpireBatch, "This course does not have any open batches");
		UserOnBoarding.usePasswordForReportRequest("Creator");
		String reportDate = createBatch.getValidateCurrentDateInReport().getText();
		String date = Date.todayDate();
		Assert.assertEquals(reportDate, date);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(130,150);");
		Assert.assertTrue(createBatch.getvalidateSuccessTabInReport().isDisplayed());
		Thread.sleep(3000);
		DikshaUtils.waitToBeVisibleAndClick(createBatch.getclickChooseReportDropDwnInViewDashboard());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getclickBatchesDrpDwnValuesInViewDashboard());
		UserOnBoarding.usePasswordForReportRequest("Creator");
		Assert.assertTrue(createBatch.getValidateRequestReportFailed().isDisplayed());
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-300);");
		// DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getenterReportRequestPasswordInViewDashboard(),"");
	}

	public static void ValidateCourseBatchDate(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);

		Thread.sleep(2000);
		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(5000);
		Library.custom_click(cc.getSearchbutton(), "search button");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
		Thread.sleep(2000);
		Assert.assertTrue(createBatch.getBatchStartDate().isDisplayed());
		Assert.assertTrue(createBatch.getBatchEndDate().isDisplayed());

	}

	public static void CreatorCloseBatchDetailsSection(String coursename) throws Exception {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);

		Thread.sleep(2000);
		cc.getSearchtextfield().clear();
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndSendKeys(cc.getSearchtextfield(), coursename);
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
		Thread.sleep(1000);
		Assert.assertTrue(createBatch.getBatchDetailsOption().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getBatchDetailsOption());

	}

	public static void UserNotAbleToSeeBatchDetailSection(String coursename) throws Exception {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndSendKeys(cc.getSearchtextfield(), coursename);
		Thread.sleep(5000);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		Thread.sleep(2000);

		String DontHaveOpenBatch = popup.getDontHaveOpenBatch().getText();
		Assert.assertEquals(DontHaveOpenBatch, "This course does not have any open batches");
		Thread.sleep(2000);

		WebElement batchDetails = createBatch.getBatchDetailsOption();
		if (batchDetails != null) {
			System.out.println("Batch Details Option is not present.");

		} else {
			System.out.println("Batch Details Option is present.");
		}
	}

	public static void UserNotAbleToSeeCertificateCriteria(String coursename) throws Exception {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		CreateCertificate certificate = PageFactory.initElements(driver, CreateCertificate.class);

		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndSendKeys(cc.getSearchtextfield(), coursename);
		Thread.sleep(5000);
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
		Thread.sleep(2000);

		WebElement CertificateCriteria = certificate.getCertificateCriteriaTab();
		if (CertificateCriteria != null) {
			System.out.println("Certificate Criteria Option is not present.");

		} else {
			System.out.println("Certificate Criteria Option is present.");

		}
		DikshaUtils.waitToBeClickableAndClick(createBatch.getEditBatchButton());
	}

	public static void verifyTheForumOnceBatchIsSelected(String course) throws InterruptedException {
		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateBatchButton()));

		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateBatchButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getBatchName(), "Batch 1");
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getDescription(), "This course is created via Automation");
		Thread.sleep(2000);
		Library.custom_click(createBatch.getIssueCertificateNo(), "IssueCertificateNo");
		Thread.sleep(2000);

		DikshaUtils.waitToBeClickableAndClick(createBatch.getEnableDiscussionsButton());

		DikshaUtils.waitToBeClickableAndClick(createBatch.getStartDate());

		Date.setTodayDate(driver);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(1000);
		action.sendKeys("3").perform();
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(createBatch.getEndDate());

		Date.setTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(1000);
		action.sendKeys("3").perform();
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCourseterms());
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateButton()));
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateButton());
		Thread.sleep(2000);
		String BatchCreatedPopup = popup.getBatchCreatedPopUp().getText();
		Assert.assertEquals(BatchCreatedPopup, "Batch created successfully...");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getBackAfterCreateBatchButton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());
		// Assert.assertTrue(createBatch.getViewDashboardButton().isDisplayed());
		DikshaUtils.waitToBeClickableAndClick(createBatch.getViewDashboardButton());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSelectBatchDropdown());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getBatchSelected());
		Thread.sleep(2000);
		DikshaUtils.waitForElementToBeVisible(createBatch.getDiscussionForumIcon());
		Assert.assertTrue(createBatch.getDiscussionForumIcon().isDisplayed());
		System.out.println("Forum icon is displayed in the course dashboard once the batch is selected ");
	}

	public static void verifyConsentPopUpDetails(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		Thread.sleep(2000);
		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(5000);
		Library.custom_click(cc.getSearchbutton(), "search button");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
		Thread.sleep(2000);
		Library.custom_click(cc.getJoincourse(), "Join course");
		Thread.sleep(2000);
		// Library.custom_click(cc.getConsentcheckbox(), " Consent Checkbox");

		Assert.assertTrue(cc.getConsentcheckbox().isDisplayed());
		System.out.println("user gets the consent detials pop-up with checkbox when user enroll to course ");

		Assert.assertTrue(cc.getShareButton().isDisplayed());
		System.out.println("user gets the consent detials pop-up with share button when user enroll to course ");

		Assert.assertTrue(cc.getassertUserNameOnPopUp().isDisplayed());
		Assert.assertTrue(cc.getassertStateOnPopUp().isDisplayed());
		Assert.assertTrue(cc.getassertDistrictOnPopUp().isDisplayed());
		System.out.println("user gets the profile details on consent detials pop-up when user enroll to course ");
		Assert.assertTrue(cc.getassertMessageFollowedByCheckBox().isDisplayed());
		System.out.println(
				"'I consent to share my details with the administrators of this course. All course administrators are bound by the Privacy Policy and Course Terms in their use of my data.' Message Displayed");

		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		Library.custom_click(cc.getShareButton(), "Share Button");

		Assert.assertTrue(cc.getStartLearning().isDisplayed());
	}

	public static void verifyUserREDOTheAssessmentTillTheAttemptLeft() throws InterruptedException {
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnStartLearning());
		WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@aria-label,'Content Player')]"));
		driver.switchTo().frame(iframe);
		DikshaUtils.waitToBeClickableAndClick(cc.getclkCorrectAns1());
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNavigateToNxt());
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNextBtn());

		DikshaUtils.waitToBeClickableAndClick(cc.getclkCorrectAns2());
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNavigateToNxt());
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNextBtn());

		DikshaUtils.waitToBeClickableAndClick(cc.getclkCorrectAns3());
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNavigateToNxt());
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNextBtn());

		DikshaUtils.waitToBeClickableAndClick(cc.getclkCorrectAns4());
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNavigateToNxt());
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNextBtn());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());

		driver.switchTo().defaultContent();

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
		Thread.sleep(3000);

		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnClose());
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getclkbtnRedo());

		for (int i = 0; i < 2; i++) {
			// DikshaUtils.waitToBeClickableAndClick(cc.getbtnStartLearning());
			// WebElement iframe2 =
			// driver.findElement(By.xpath("//iframe[contains(@aria-label,'Content
			// Player')]"));
			// driver.switchTo().frame(iframe2);
			DikshaUtils.waitToBeClickableAndClick(cc.getclkCorrectAns1());
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNavigateToNxt());
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextBtn());

			DikshaUtils.waitToBeClickableAndClick(cc.getclkCorrectAns2());
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNavigateToNxt());
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextBtn());

			DikshaUtils.waitToBeClickableAndClick(cc.getclkCorrectAns3());
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNavigateToNxt());
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextBtn());

			DikshaUtils.waitToBeClickableAndClick(cc.getclkCorrectAns4());
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNavigateToNxt());
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextBtn());

			DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());

			driver.switchTo().defaultContent();

			DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());

			DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
			Thread.sleep(3000);

			Thread.sleep(2000);
			// DikshaUtils.waitToBeClickableAndClick(cc.getbtnClose());
			driver.switchTo().frame(iframe);
			Thread.sleep(2000);
			DikshaUtils.waitToBeClickableAndClick(cc.getclkbtnRedo());
		}
		DikshaUtils.waitToBeClickableAndClick(cc.getclkbtnRedo());
		Thread.sleep(2000);
	}

	public static void verifyYouHaveCompletedThisModuleDisplayedMsgPostConsumption() throws InterruptedException {
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnStartLearning());

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
		Thread.sleep(3000);

		Assert.assertTrue(cc.getassertModuleCompletion().isDisplayed());
		System.out.println("On completion of a module in course, 'You have completed this module' Message Displayed.");

	}

	public static void UserCanReviewAnsweredQuestionBeforeSubmitting() throws InterruptedException {
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnStartLearning());
		WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@aria-label,'Content Player')]"));
		driver.switchTo().frame(iframe);
		DikshaUtils.waitToBeClickableAndClick(cc.getclkCorrectAns1());
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNavigateToNxt());
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNextBtn());

		DikshaUtils.waitToBeClickableAndClick(cc.getclkCorrectAns2());
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNavigateToNxt());
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNextBtn());

		DikshaUtils.waitToBeClickableAndClick(cc.getclkCorrectAns3());
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNavigateToNxt());
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNextBtn());

		DikshaUtils.waitToBeClickableAndClick(cc.getclkCorrectAns4());
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNavigateToNxt());
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNextBtn());

		Assert.assertTrue(cc.getassertSubmitToCont().isDisplayed());

		Assert.assertTrue(cc.getassertTotalQuestions().isDisplayed());

		Assert.assertTrue(cc.getassertQuestionAnswered().isDisplayed());

		Assert.assertTrue(cc.getassertQuestionSkipped().isDisplayed());
		Assert.assertTrue(cc.getclkReview().isDisplayed());

		System.out.println("Assessment Details are displayed before submit");

		DikshaUtils.waitToBeClickableAndClick(cc.getclkReview());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getclkCorrectAns1().isDisplayed());

//			 getassert0Percentage() 
//			
//			 getassertCompleted() 

	}

	public static void verifyNextModuleAndPartialCompletionAfterConsumingOneContent() throws InterruptedException {
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnStartLearning());

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
		Thread.sleep(3000);

		Assert.assertTrue(cc.getassertModuleCompletion().isDisplayed());
		System.out.println("On completion of a module in course, 'You have completed this module' Message Displayed.");

		Assert.assertTrue(cc.getclkNextModule().isDisplayed());
		System.out.println(
				"when user is consuming the content in a module, then user should be displayed with 'Next Module' on top right corner");
		DikshaUtils.waitToBeClickableAndClick(cc.getclkNextModule());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getassertModuleProgress().isDisplayed());
		System.out.println(
				"user is consuming a content in the Module then user should be displayed with the Module Progress is displayed");

		Assert.assertTrue(cc.getassertXYcomplelted().isDisplayed());
		System.out.println(
				"user is consuming a content in the Module then user should be displayed with the Module Progress (x/y completed)");

	}

	public static void verifyThatUserDisplayedWithCourseCompletionMessage() throws InterruptedException {
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnStartLearning());

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
		Thread.sleep(2000);

//			Assert.assertTrue(cc.getassertModuleCompletion().isDisplayed());
//			System.out.println("On completion of a module in course, 'You have completed this module' Message Displayed.");
//			
//			Assert.assertTrue(cc.getclkNextModule().isDisplayed());
//			System.out.println("when user is consuming the content in a module, then user should be displayed with 'Next Module' on top right corner");
//			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextModule());
//			Thread.sleep(2000);
//			Assert.assertTrue(cc.getassertModuleProgress().isDisplayed());
//			System.out.println("user is consuming a content in the Module then user should be displayed with the Module Progress is displayed");
//			
//			Assert.assertTrue(cc.getassertXYcomplelted().isDisplayed());
//			System.out.println("user is consuming a content in the Module then user should be displayed with the Module Progress (x/y completed)");

	}

	public static void verifyAllTabsOnUser() {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		Assert.assertTrue(cc.getassertHome().isDisplayed());

		Assert.assertTrue(cc.getassertDigitalTextBooks().isDisplayed());

		Assert.assertTrue(cc.getassertCourse().isDisplayed());

		Assert.assertTrue(cc.getassertTVClasses().isDisplayed());

		Assert.assertTrue(cc.getassertAllTab().isDisplayed());

	}

	public static void createBatchWithEnrollDate(String course) throws InterruptedException {

		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getSearchtextfield(), course);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchbutton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getSearchedcourse());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateBatchButton()));

		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateBatchButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getBatchName(), "Batch 1");
		DikshaUtils.waitToBeClickableAndSendKeys(createBatch.getDescription(), "This course is created via Automation");
		Thread.sleep(2000);
		Library.custom_click(createBatch.getIssueCertificateNo(), "IssueCertificateNo");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getStartDate());

		Date.setTodayDate(driver);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(1000);
		action.sendKeys("3").perform();
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(createBatch.getEndDate());

		Date.setTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(1000);
		action.sendKeys("3").perform();
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(createBatch.getenrollmentEndDate());

		Date.setTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(1000);
		action.sendKeys("3").perform();
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(createBatch.getCourseterms());
		wait.until(ExpectedConditions.elementToBeClickable(createBatch.getCreateButton()));
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getCreateButton());
		Thread.sleep(2000);
		String BatchCreatedPopup = popup.getBatchCreatedPopUp().getText();
		Assert.assertEquals(BatchCreatedPopup, "Batch created successfully...");
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(createBatch.getBackAfterCreateBatchButton());

	}

	public static void verifyBatchStartDateAndEndDate(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		Thread.sleep(2000);
		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(5000);
		Library.custom_click(cc.getSearchbutton(), "search button");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getassertBatchStartDate().isDisplayed());
		Assert.assertTrue(cc.getassertBatchEndDate().isDisplayed());

	}

	public static void verifyBatchAndJoinCourseButtonChangedToStartLearning(String coursename)
			throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		Thread.sleep(2000);
		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(5000);
		Library.custom_click(cc.getSearchbutton(), "search button");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
		Thread.sleep(2000);
		Library.custom_click(cc.getJoincourse(), "Join course");
		Thread.sleep(2000);
		// Library.custom_click(cc.getConsentcheckbox(), " Consent Checkbox");

		Assert.assertTrue(cc.getConsentcheckbox().isDisplayed());
		System.out.println("user gets the consent detials pop-up with checkbox when user enroll to course ");

		Assert.assertTrue(cc.getShareButton().isDisplayed());
		System.out.println("user gets the consent detials pop-up with share button when user enroll to course ");

		Assert.assertTrue(cc.getassertUserNameOnPopUp().isDisplayed());
		Assert.assertTrue(cc.getassertStateOnPopUp().isDisplayed());
		Assert.assertTrue(cc.getassertDistrictOnPopUp().isDisplayed());
		System.out.println("user gets the profile details on consent detials pop-up when user enroll to course ");
		Assert.assertTrue(cc.getassertMessageFollowedByCheckBox().isDisplayed());
		System.out.println(
				"'I consent to share my details with the administrators of this course. All course administrators are bound by the Privacy Policy and Course Terms in their use of my data.' Message Displayed");

		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		Library.custom_click(cc.getShareButton(), "Share Button");

		Assert.assertTrue(cc.getStartLearning().isDisplayed());
	}

	public static void verifyAnonymousUserIsDisplayPopUpMessage(String coursename, String user)
			throws InterruptedException, IOException {

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
//			Thread.sleep(2000);
//			DikshaUtils.waitToBeClickableAndClick(cc.getbtnExplore());

		Thread.sleep(2000);
		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(5000);
		Library.custom_click(cc.getSearchbutton(), "search button");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
		Thread.sleep(2000);
		Library.custom_click(cc.getJoincourse(), "Join course");
		Thread.sleep(2000);

		Assert.assertTrue(cc.getassertPopUpMsg().isDisplayed());

		DikshaUtils.waitToBeClickableAndClick(cc.getclkLoginBtnOnPopUp());
		Thread.sleep(3000);

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

//			DikshaUtils.waitToBeVisibleAndClick(loginpage.getHeaderDropdown());
//			DikshaUtils.waitToBeClickableAndClick(loginpage.getLogintab());

		String cred[] = excel.getCredentails(user);
		String username = cred[0];
		String password = cred[1];

		DikshaUtils.waitToBeClickableAndSendKeys(loginpage.getUserName(), username);
		DikshaUtils.waitToBeClickableAndSendKeys(loginpage.getPassword(), password);
		DikshaUtils.waitToBeClickableAndClick(loginpage.getLogin());

		Thread.sleep(5000);

		Assert.assertTrue(cc.getJoincourse().isDisplayed());
//			DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
//		    Thread.sleep(2000);
		Library.custom_click(cc.getJoincourse(), "Join course");
		Thread.sleep(2000);

		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		Library.custom_click(cc.getShareButton(), "Share Button");
		DikshaUtils.waitForElementToBeVisible(cc.getStartLearning());
		Assert.assertTrue(cc.getStartLearning().isDisplayed());

	}

	public static void verifyUserSelectsOngoingFromMyCoursesAndUserSeeOngoingCourseBatch(String coursename)
			throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);

		Thread.sleep(2000);
		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(5000);
		Library.custom_click(cc.getSearchbutton(), "search button");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
		Thread.sleep(2000);
		Assert.assertTrue(cc.getJoincourse().isEnabled());
		Assert.assertTrue(cc.getassertBatchDetails().isDisplayed());
		Assert.assertTrue(cc.getassertBatchStartDate().isDisplayed());
		Assert.assertTrue(cc.getassertBatchEndDate().isDisplayed());
	}

	public static void verifyContentInTheModuleWhichIsDisplayedInTheContentPageTurnsWithTick()
			throws InterruptedException {
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnStartLearning());

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
		Thread.sleep(3000);

		Assert.assertTrue(cc.getassertModuleCompletion().isDisplayed());
		Thread.sleep(3000);

		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getbtnClose());

		DikshaUtils.waitToBeClickableAndClick(createBatch.getBackAfterCreateBatchButton());

		Assert.assertTrue(cc.getassertTickContent().isDisplayed());
		Assert.assertTrue(cc.getassertTickCourseUnit().isDisplayed());

		DikshaUtils.waitToBeClickableAndClick(createBatch.getBackAfterCreateBatchButton());

	}

	public static void joincourseAndVerifyCourseProgress(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);

		Thread.sleep(2000);
		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(5000);
		Library.custom_click(cc.getSearchbutton(), "search button");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
		Thread.sleep(2000);
		Library.custom_click(cc.getJoincourse(), "Join course");
		Thread.sleep(2000);
		// Library.custom_click(cc.getConsentcheckbox(), " Consent Checkbox");
		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		Library.custom_click(cc.getShareButton(), "Share Button");

		Assert.assertTrue(cc.getassert0Percentage().isDisplayed());
		Assert.assertTrue(cc.getassertCompleted().isDisplayed());

		DikshaUtils.waitToBeClickableAndClick(createBatch.getBackAfterCreateBatchButton());
		Thread.sleep(2000);
	}

	public static void RejoincourseAndVerifyCourseProgressRemains0Percentage(String coursename)
			throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);

		Thread.sleep(2000);
		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(5000);
		Library.custom_click(cc.getSearchbutton(), "search button");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
		Thread.sleep(2000);

		Assert.assertTrue(cc.getassert0Percentage().isDisplayed());
		Assert.assertTrue(cc.getassertCompleted().isDisplayed());
	}

	public static void enrollConumePartially(String coursename) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		Thread.sleep(2000);
		Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(5000);
		Library.custom_click(cc.getSearchbutton(), "search button");
		Thread.sleep(1000);

		DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
		Thread.sleep(2000);
		Library.custom_click(cc.getJoincourse(), "Join course");
		Thread.sleep(2000);
		// Library.custom_click(cc.getConsentcheckbox(), " Consent Checkbox");

		Assert.assertTrue(cc.getConsentcheckbox().isDisplayed());
		System.out.println("user gets the consent detials pop-up with checkbox when user enroll to course ");

		Assert.assertTrue(cc.getShareButton().isDisplayed());
		System.out.println("user gets the consent detials pop-up with share button when user enroll to course ");

		Assert.assertTrue(cc.getassertUserNameOnPopUp().isDisplayed());
		Assert.assertTrue(cc.getassertStateOnPopUp().isDisplayed());
		Assert.assertTrue(cc.getassertDistrictOnPopUp().isDisplayed());
		System.out.println("user gets the profile details on consent detials pop-up when user enroll to course ");
		Assert.assertTrue(cc.getassertMessageFollowedByCheckBox().isDisplayed());
		System.out.println(
				"'I consent to share my details with the administrators of this course. All course administrators are bound by the Privacy Policy and Course Terms in their use of my data.' Message Displayed");

		DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		Library.custom_click(cc.getShareButton(), "Share Button");

		Assert.assertTrue(cc.getStartLearning().isDisplayed());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnStartLearning());

		for (int i = 0; i < 8; i++) {
			DikshaUtils.waitToBeClickableAndClick(cc.getclkNextIcon());
		}

		DikshaUtils.waitToBeClickableAndClick(cc.getrateTheContent());

		DikshaUtils.waitToBeClickableAndClick(cc.getbtnSubmit());
		Thread.sleep(3000);

		DikshaUtils.waitToBeClickableAndClick(createBatch.getBackAfterCreateBatchButton());
	}

	public static void reEnrollVerifyAndContinueLearning() throws InterruptedException {
		CourseConsumption cc = PageFactory.initElements(driver, CourseConsumption.class);
		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
		Thread.sleep(2000);
//		    Library.custom_sendkeys(cc.getSearchtextfield(), coursename, "course name searched");
		Thread.sleep(5000);
//		    Library.custom_click(cc.getSearchbutton(), "search button");
//		    Thread.sleep(1000);

//		    DikshaUtils.waitToBeClickableAndClick(cc.getSearchedcourse());
//		    Thread.sleep(2000);
		Library.custom_click(cc.getJoincourse(), "Join course");
		Thread.sleep(2000);
	}
}