package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserCourseCard {

	@FindBy(how=How.XPATH,using="//a[text()=' Courses ']")
	private WebElement coursesTab;
	
	@FindBy(how=How.XPATH,using="(//div[@class='img-container'])[1]")
	private WebElement image;
	
	@FindBy(how=How.XPATH,using="(//h4[@class='sb--card__title sb__ellipsis sb__ellipsis--two text-left flex-basis-1'])[1]")
	private WebElement title;
	
	@FindBy(how=How.XPATH,using="(//span[text()='Subject: '])[1]")
	private WebElement subject;
	
	@FindBy(how=How.XPATH,using="(//span[text()='Publisher: '])[1]")
	private WebElement publisher;

	public WebElement getImage() {
		return image;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getSubject() {
		return subject;
	}

	public WebElement getPublisher() {
		return publisher;
	}

	public WebElement getCoursesTab() {
		return coursesTab;
	}
	
	
	
}
