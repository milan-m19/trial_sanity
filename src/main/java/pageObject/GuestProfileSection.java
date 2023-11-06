package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GuestProfileSection {

	@FindBy(how=How.XPATH,using="(//div[text()=' C '])[2]")
	private WebElement profileIcon;
	
	@FindBy(how=How.XPATH,using="//li[text()=' Profile ']")
	private WebElement profileTab;
	
	@FindBy(how=How.XPATH,using="//div[text()='Custodian ']")
	private WebElement profileName;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Teacher']")
	private WebElement role;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Akola ']")
	private WebElement district;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Maharashtra']")
	private WebElement state;
	
	@FindBy(how=How.XPATH,using="//span[text()='CBSE/NCERT']")
	private WebElement board;
	
	@FindBy(how=How.XPATH,using="(//span[text()='English'])[2]")
	private WebElement medium;
	
	@FindBy(how=How.XPATH,using="(//span[text()='Class 2'])[1]")
	private WebElement classs;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Student']")
	private WebElement role1;

	public WebElement getProfileTab() {
		return profileTab;
	}

	public WebElement getProfileName() {
		return profileName;
	}

	public WebElement getRole() {
		return role;
	}

	public WebElement getDistrict() {
		return district;
	}

	public WebElement getState() {
		return state;
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

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	
	public WebElement getRole1() {
		return role1;
	}
	
	
	
	
}
