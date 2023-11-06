package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FiltersInDiffrentTabs {

	@FindBy(how=How.XPATH,using="//a[text()=' Digital textbooks ']")
	private WebElement digitalTextbookTab;
	
	@FindBy(how=How.XPATH,using="//a[text()=' TV classes ']")
	private WebElement TvClassesTab;
	
	@FindBy(how=How.XPATH,using="//a[text()=' Courses ']")
	private WebElement coursesTab;
	
	@FindBy(how=How.XPATH,using="//a[text()=' All ']")
	private WebElement AllTab;
	
	@FindBy(how=How.XPATH,using="//label[text()='Board']")
	private WebElement board;
	
	@FindBy(how=How.XPATH,using="//label[text()='Medium']")
	private WebElement medium;
	
	@FindBy(how=How.XPATH,using="//label[text()='Class']")
	private WebElement classs;
	
	@FindBy(how=How.XPATH,using="//label[text()='Subject']")
	private WebElement subject;
	
	@FindBy(how=How.XPATH,using="//label[text()='Published user type']")
	private WebElement Publishedusertype;

	@FindBy(how=How.XPATH,using="//span[text()='My courses']")
	private WebElement myCourseSection;
	
	@FindBy(how=How.XPATH,using="//button[text()=' View all ']")
	private WebElement viewAllButton;
	
	@FindBy(how=How.XPATH,using="//mat-select[@aria-label='CBSE/NCERT, selected ,Select Board']")
	private WebElement CBSENcert;
	
	@FindBy(how=How.XPATH,using="//mat-select[@aria-label='English, selected ,Select Medium']")
	private WebElement EnglishMedium;
	
	@FindBy(how=How.XPATH,using="//mat-select[@aria-label='Class 10, selected ,Select Class']")
	private WebElement class10;
	
	public WebElement getCBSENcert() {
		return CBSENcert;
	}

	public WebElement getEnglishMedium() {
		return EnglishMedium;
	}

	public WebElement getClass10() {
		return class10;
	}

	public WebElement getAllTab() {
		return AllTab;
	}

	public WebElement getMyCourseSection() {
		return myCourseSection;
	}


	@FindBy(how=How.XPATH,using="//li[@routerlink='profile']")
	private WebElement Profile;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),' View more')]")
	private WebElement ViewMore;
	
	@FindBy(how=How.XPATH,using="(//button[text()=' View all '])[2]")
	private WebElement ViewAllButton;

	public WebElement getViewAllButton() {
		return ViewAllButton;
	}
	
	public WebElement getViewMore() {
		return ViewMore;
	}

	public WebElement getProfile() {
		return Profile;
	}

	
	public WebElement getDigitalTextbookTab() {
		return digitalTextbookTab;
	}

	public WebElement getTvClassesTab() {
		return TvClassesTab;
	}

	public WebElement getCoursesTab() {
		return coursesTab;
	}

	public WebElement getBoard() {
		return board;
	}

	public WebElement getMedium() {
		return medium;
	}

	public WebElement getClasss() {
		return classs;
	}

	public WebElement getSubject() {
		return subject;
	}

	public WebElement getPublishedusertype() {
		return Publishedusertype;
	}
 
	
}
