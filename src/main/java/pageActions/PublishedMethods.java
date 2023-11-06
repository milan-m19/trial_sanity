package pageActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObject.BMCPopup;
import pageObject.CreateBook;
import pageObject.HomePage;
import pageObject.Languages;
import pageObject.Published;
import pageObject.ResourcesPom;
import pageObject.UpForReview;
import pageObject.ValidatePopUp;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.Listeners;

public class PublishedMethods extends BaseClass {

	public static void AddCollaboratorInPublished_eTextbook(String fullname) throws Exception {

		Published published = PageFactory.initElements(driver, Published.class);
		CreateBook create = PageFactory.initElements(driver, CreateBook.class);

		String CollaboratorssuccessfullyPopup = null;
		String expected = "Verify creator should be able to add collaborator in published textbook successfully";
		String actual = "Creator is Unable to add collaborator in published textbook";

		try {
		
		DikshaUtils.waitToBeClickableAndClick(published.getHeaderDropdown());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", published.getWorkspace());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(published.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(published.getPublished());
		DikshaUtils.waitToBeClickableAndClick(published.getSearchForPublished());
		published.getSearchForPublished().sendKeys(fullname);
		DikshaUtils.waitToBeClickableAndClick(published.getSearchIcon());
		DikshaUtils.waitToBeClickableAndClick(published.getClickSearchContent());
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(create.getAddCollaborator());
		DikshaUtils.waitToBeClickableAndSendKeys(create.getSearchCollaborator(), "democontentcreator1");
		Thread.sleep(1000);
		create.getSearchCollaborator().sendKeys(Keys.ENTER);
		DikshaUtils.waitToBeVisibleAndClick(create.getSelectDemoCollaborator());
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(true);", create.getDoneButton());
		DikshaUtils.waitToBeVisibleAndClick(create.getDoneButton());
		Thread.sleep(2000);

		WebElement CollaboratorPopup = driver
				.findElement(By.xpath("//strong[text()='Collaborators updated successfully']"));
	    CollaboratorssuccessfullyPopup = CollaboratorPopup.getText();
		Assert.assertEquals(CollaboratorssuccessfullyPopup, "Collaborators updated successfully");
		Thread.sleep(1000);

		
		actual = "creator is able to add collaborator in published textbook successfully";

		
	} finally {

		String popupText = CollaboratorssuccessfullyPopup != null ? CollaboratorssuccessfullyPopup : "N/A";
		System.out.println(popupText);
		Listeners.customAssert("Collaborators updated successfully", popupText, expected, actual);
	}
}
	public static void VerifyContentIsInPublishedBucket(String fullname) throws Exception {

		Published published = PageFactory.initElements(driver, Published.class);

		String verifyCourse = null;
		String expect = "Creator should be able to verify the Published Content Sucessfully";
		String actual = "Creator is unable to verify the Published Content";
		try {
			DikshaUtils.waitToBeClickableAndClick(published.getHeaderDropdown());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", published.getWorkspace());
			Thread.sleep(1000);
			DikshaUtils.waitToBeClickableAndClick(published.getWorkspace());
			DikshaUtils.waitToBeClickableAndClick(published.getPublished());
			DikshaUtils.waitToBeClickableAndClick(published.getSearchForPublished());
			published.getSearchForPublished().sendKeys(fullname);
			DikshaUtils.waitToBeClickableAndClick(published.getSearchIcon());
			DikshaUtils.waitToBeClickableAndClick(published.getClickSearchContent());
			verifyCourse = published.getClickSearchContent().getText();
			actual = "Creator is able to verify the Published Content Sucessfully";
		} finally {

			String popupText = published.getClickSearchContent() != null ? verifyCourse : "N/A";
			Listeners.customAssert(verifyCourse, popupText, expect, actual);

		}
	}

	public static void VerifyLanguageChangeInUrdu(String coursename) throws Exception {

		UpForReview review = PageFactory.initElements(driver, UpForReview.class);
		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		DikshaUtils.waitToBeClickableAndClick(review.getHeaderDropdown());
		DikshaUtils.waitToBeClickableAndClick(review.getWorkspace());
		DikshaUtils.waitToBeClickableAndClick(review.getUpForReview());
		DikshaUtils.waitToBeClickableAndSendKeys(review.getSearchForReview(), coursename);
		DikshaUtils.waitToBeClickableAndClick(review.getSearchedContentForPublish());
		DikshaUtils.waitToBeClickableAndClick(review.getTaboncourse());
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(1000);
		String title = review.getCourseTitle().getText();
		Assert.assertEquals(coursename, title);

	}

}
