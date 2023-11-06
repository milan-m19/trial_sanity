package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class QuestionsetConsumption {

	@FindBy(how=How.XPATH,using="//div[@title='next slide']")
	private WebElement NextSlideButton;
	
	
	@FindBy(how=How.XPATH,using="(//span[@class='radiomark'])[1]")
	private WebElement SelectAns;
	
	
	@FindBy(how=How.XPATH,using="//button[text()='Search']")
	private WebElement searchbutton;
	
	@FindBy(how=How.XPATH,using="//div[@class='replay-section']")
	private WebElement ReplayButton;
	
	@FindBy(how=How.XPATH,using="//a[text()=' Close ']")
	private WebElement MaxExceedCloseButton;

	public WebElement getMaxExceedCloseButton() {
		return MaxExceedCloseButton;
	}
	
	public WebElement getReplayButton() {
		return ReplayButton;
	}
	
	public WebElement getNextSlideButton() {
		return NextSlideButton;
	}


	public WebElement getSelectAns() {
		return SelectAns;
	}


	public WebElement getSearchbutton() {
		return searchbutton;
	}


	
}
