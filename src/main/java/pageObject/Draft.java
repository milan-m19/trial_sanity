package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Draft {

	@FindBy(how=How.XPATH,using="(//div[@class='avatar-container'])[2]")
	private WebElement headerDropdown;
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Workspace')]")
	private WebElement Workspace;
	
	@FindBy(how=How.XPATH,using="//a[text()=' Drafts ']")
	private WebElement Draft;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Search content']")
    private WebElement searchForPublished;

	@FindBy(how=How.XPATH,using="//i[@Class='circular search link icon']")
	private WebElement searchIcon;

	@FindBy(how=How.XPATH,using="//div[@class='content']")
	private WebElement clickSearchContent;
	
	@FindBy(how=How.XPATH,using="//i[@class='trash large icon']")
	private WebElement DeleteContentFromDraft;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Yes ']")
	private WebElement ConfirmDeleteContentFromDraft;
	
	@FindBy(how=How.XPATH,using="//div[text()='Digital Textbook']//following::bdi")
	private WebElement clickSearchContent1;
	
	public WebElement getConfirmDeleteContentFromDraft() {
		return ConfirmDeleteContentFromDraft;
	}
	
	
	public WebElement getDeleteContentFromDraft() {
		return DeleteContentFromDraft;
	}
	
	public WebElement getHeaderDropdown() {
		return headerDropdown;
	}

	public void setHeaderDropdown(WebElement headerDropdown) {
		this.headerDropdown = headerDropdown;
	}

	public WebElement getWorkspace() {
		return Workspace;
	}

	public void setWorkspace(WebElement workspace) {
		Workspace = workspace;
	}

	public WebElement getDraft() {
		return Draft;
	}

	public void setDraft(WebElement draft) {
		Draft = draft;
	}

	public WebElement getSearchForPublished() {
		return searchForPublished;
	}

	public void setSearchForPublished(WebElement searchForPublished) {
		this.searchForPublished = searchForPublished;
	}

	public WebElement getSearchIcon() {
		return searchIcon;
	}

	public void setSearchIcon(WebElement searchIcon) {
		this.searchIcon = searchIcon;
	}

	public WebElement getClickSearchContent() {
		return clickSearchContent;
	}

	
	public void setClickSearchContent(WebElement clickSearchContent) {
		this.clickSearchContent = clickSearchContent;
	}
	
	public WebElement getClickSearchContent1() {
		return clickSearchContent1;
	}
}
