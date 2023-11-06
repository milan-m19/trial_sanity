package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Published {

	@FindBy(how=How.XPATH,using="(//div[@class='avatar-container'])[2]")
	private WebElement headerDropdown;

	
    @FindBy(how=How.XPATH,using="//*[contains(text(),'Workspace')]")
	private WebElement Workspace;
    
    @FindBy(how=How.XPATH,using="//i[@class='icon-svg icon-svg--sm icon-workspace mr-8']")
	private WebElement WorkspaceIcon;

	@FindBy(how=How.XPATH,using="//a[text()=' Published ']")
	private WebElement Published;

	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Search content']")
    private WebElement searchForPublished;

	@FindBy(how=How.XPATH,using="//i[@Class='circular search link icon']")
	private WebElement searchIcon;

	@FindBy(how=How.XPATH,using="//div[@Class='ui image']")
	private WebElement clickSearchContent;
	//div[@Class='ui image']
	//div[@class='ui link cards mb-0 ng-star-inserted']
	

	@FindBy(how=How.XPATH,using="//i[@class='circular search link icon']")
	private WebElement SearchTheCourse;
	
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Course')]")
	private WebElement SearchedCourse;
	
	public WebElement getSearchedCourse() {
		return SearchedCourse;
	}

	
	public WebElement getHeaderDropdown() {
		return headerDropdown;
	}

	public WebElement getWorkspaceIcon() {
		return WorkspaceIcon;
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

	public WebElement getPublished() {
		return Published;
	}

	public void setPublished(WebElement published) {
		Published = published;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
