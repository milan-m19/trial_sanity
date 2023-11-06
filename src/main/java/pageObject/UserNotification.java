package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserNotification {
	@FindBy(how=How.XPATH,using="(//div[@aria-label='Notifications'])[2]")
	private WebElement BellIcon;
	
	@FindBy(how=How.XPATH,using="(//div[@class='notification-bell d-flex flex-ai-center flex-jc-center'])[2]//following-sibling::div")
	private WebElement notificationCount;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'New Notification (s)')]")
	private WebElement newNotificationsText;
	
	@FindBy(how=How.XPATH,using="//a[text()='See more']")
	private WebElement seeMoreButton;

	@FindBy(how=How.XPATH,using="//a[text()='See less']")
	private WebElement seeLessButton;
	
	@FindBy(how=How.XPATH,using="//img[@class='Delete-gray']")
	private WebElement deleteNotificationIcon;
	
	@FindBy(how=How.XPATH,using="//a[text()='Clear']")
	private WebElement clearNotificationButton;
	
	public WebElement getClearNotificationButton() {
		return clearNotificationButton;
	}

	public WebElement getSeeMoreButton() {
		return seeMoreButton;
	}

	public WebElement getSeeLessButton() {
		return seeLessButton;
	}

	public WebElement getDeleteNotificationIcon() {
		return deleteNotificationIcon;
	}

	public WebElement getBellIcon() {
		return BellIcon;
	}

	public WebElement getNotificationCount() {
		return notificationCount;
	}

	public WebElement getNewNotificationsText() {
		return newNotificationsText;
	}

	
	
	
}
