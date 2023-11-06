package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LessonPlan {

	@FindBy(how=How.XPATH,using="(//div[@class='avatar-container'])[2]")
	private WebElement headerDropdown;
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Workspace')]")
	private WebElement Workspace;
	
	@FindBy(how=How.XPATH,using="//span[text()='Lesson Plan']")
	private WebElement LessonPlan;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Name']")
	private WebElement NameFeild;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Start creating ']")
	private WebElement StartCreatingButton;
	
	@FindBy(how=How.XPATH,using="//a[text()='New Child']")
	private WebElement NewChild;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Enter title for unit']")
	private WebElement Title;
	
	@FindBy(how=How.XPATH,using="//button[text()='ADD RESOURCE']")
	private WebElement AddResourceTab;
	
    @FindBy(how=How.XPATH,using="(//img[@class=\"resourceMetaImage \"])[1]")
	private WebElement SelectResource;
  //img[@class="resourceMetaImage "]
   // (//div[@class='image dimmable'])[1]
    @FindBy(how=How.XPATH,using="//button[text()=' PROCEED ']")
	private WebElement ProceedTab; 
  
    @FindBy(how=How.XPATH,using="//span[text()='Save']")
	private WebElement SaveButton;
    
    @FindBy(how=How.XPATH,using="//i[@class='send icon']")
	private WebElement SendforReview;

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

	public WebElement getLessonPlan() {
		return LessonPlan;
	}

	public void setLessonPlan(WebElement lessonPlan) {
		LessonPlan = lessonPlan;
	}

	public WebElement getNameFeild() {
		return NameFeild;
	}

	public void setNameFeild(WebElement nameFeild) {
		NameFeild = nameFeild;
	}

	public WebElement getStartCreatingButton() {
		return StartCreatingButton;
	}

	public void setStartCreatingButton(WebElement startCreatingButton) {
		StartCreatingButton = startCreatingButton;
	}

	public WebElement getNewChild() {
		return NewChild;
	}

	public void setNewChild(WebElement newChild) {
		NewChild = newChild;
	}

	public WebElement getTitle() {
		return Title;
	}

	public void setTitle(WebElement title) {
		Title = title;
	}

	public WebElement getAddResourceTab() {
		return AddResourceTab;
	}

	public void setAddResourceTab(WebElement addResourceTab) {
		AddResourceTab = addResourceTab;
	}

	public WebElement getSelectResource() {
		return SelectResource;
	}

	public void setSelectResource(WebElement selectResource) {
		SelectResource = selectResource;
	}

	public WebElement getProceedTab() {
		return ProceedTab;
	}

	public void setProceedTab(WebElement proceedTab) {
		ProceedTab = proceedTab;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public void setSaveButton(WebElement saveButton) {
		SaveButton = saveButton;
	}

	public WebElement getSendforReview() {
		return SendforReview;
	}

	public void setSendforReview(WebElement sendforReview) {
		SendforReview = sendforReview;
	}
	
	
	
}
