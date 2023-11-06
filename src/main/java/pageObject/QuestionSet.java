package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class QuestionSet {
	
	@FindBy(how=How.XPATH,using="(//div[@class='avatar-container'])[2]")
	private WebElement headerDropdown;
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Workspace')]")
	private WebElement Workspace;
	
	@FindBy(how=How.XPATH,using="//span[text()='QuestionSet']")
	private WebElement QuestionSetTab;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Enter Name']")
	private WebElement QuestionSetName;
	
	@FindBy(how=How.XPATH,using="//textarea[@placeholder='Enter Description']")
	private WebElement DescriptionTab;
	
	@FindBy(how=How.XPATH,using="//p[@data-placeholder='Enter Instructions']")
	private WebElement InstructionsTab;
	
	@FindBy(how=How.XPATH,using="//select[@name='sb-dropdown']/option[text()='Select Board/Syllabus ']")
	private WebElement selectBoardSyllabus;
	
	@FindBy(how=How.XPATH,using="//select[@name='sb-dropdown']/option[text()='Others']")
	private WebElement boardSelected;
	
	@FindBy(how=How.XPATH,using="(//*[@id=\"sb-dropdown\"])[2]")
	private WebElement selectMedium;
	//option[text()='Select Medium ']")
	
	@FindBy(how=How.XPATH,using="//option[text()='English']")
	private WebElement mediumSelected;
	
	@FindBy(how=How.XPATH,using="(//*[@id=\"sb-dropdown\"])[3]")
	private WebElement selectClass;
	
	@FindBy(how=How.XPATH,using="//option[text()='Class 1']")
	private WebElement classSelected;

	@FindBy(how=How.XPATH,using="(//*[@id=\"sb-dropdown\"])[4]")
	private WebElement selectSubject;
	
	@FindBy(how=How.XPATH,using="//option[text()='EVS']")
	private WebElement subjectSelected;
	
	
	@FindBy(how=How.XPATH,using="(//*[@id=\"sb-dropdown\"])[5]")
	private WebElement selectAudience;
	
	@FindBy(how=How.XPATH,using="//option[text()='Administrator']")
	private WebElement AudienceSelected;

	@FindBy(how=How.XPATH,using="//input[@placeholder='Title']")
	private WebElement ChildTitle;
	
	@FindBy(how=How.XPATH,using="//textarea[@placeholder='Description']")
	private WebElement ChildDescription;
	
	
	@FindBy(how=How.XPATH,using="//button[text()=' Create New ']")
	private WebElement CreateButton;
	
	@FindBy(how=How.XPATH,using="//img[@alt='Multiple Choice Questionicon']")
	private WebElement SelectMCQ;

	@FindBy(how=How.XPATH,using="//button[text()='Next ']")
	private WebElement NextButton;
	
	@FindBy(how=How.XPATH,using="(//div[@aria-label='Rich Text Editor, main'])[1]")
	private WebElement EnterQue;
	
	@FindBy(how=How.XPATH,using="(//div[@aria-label='Rich Text Editor, main'])[2]")
	private WebElement EnterOptionFirst;
	
	@FindBy(how=How.XPATH,using="(//div[@aria-label='Rich Text Editor, main'])[3]")
	private WebElement EnterOptionSecond;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Save as Draft ']")
	private WebElement SaveAsDraft;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Add Child')]")
	private WebElement addChild;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Send for Review')]")
	private WebElement submitForreviewButton;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'I agree that by submitting / publishing this Content,')]")
	private WebElement termsAndConditionCheckbox;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Submit ']")
	private WebElement submitButton;
	
	@FindBy(how=How.XPATH,using="(//*[@id='sb-dropdown'])[8]")
	private WebElement MaxAttempt;
	
	@FindBy(how=How.XPATH,using="(//*[@id='sb-dropdown']/option[3])[6]")
	private WebElement SelectMaxAttempt;
	
	public WebElement getSelectMaxAttempt() {
		return SelectMaxAttempt;
		
		
	}
	
	public WebElement getMaxAttempt() {
		return MaxAttempt;
		
		
	}
	
	public WebElement gettermsAndConditionCheckbox() {
		return termsAndConditionCheckbox;
		
		
	}
	public WebElement getsubmitButton() {
		return submitButton;
		
		
	}

	public WebElement getsubmitForreviewButton() {
		return submitForreviewButton;
		
		
	}
	public WebElement getaddChild() {
		return addChild;
	}
	
	public WebElement getSaveAsDraft() {
		return SaveAsDraft;
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

	public WebElement getQuestionSetTab() {
		return QuestionSetTab;
	}

	public void setQuestionSetTab(WebElement questionSetTab) {
		QuestionSetTab = questionSetTab;
	}

	public WebElement getQuestionSetName() {
		return QuestionSetName;
	}

	public void setQuestionSetName(WebElement questionSetName) {
		QuestionSetName = questionSetName;
	}

	public WebElement getDescriptionTab() {
		return DescriptionTab;
	}

	public void setDescriptionTab(WebElement descriptionTab) {
		DescriptionTab = descriptionTab;
	}

	public WebElement getInstructionsTab() {
		return InstructionsTab;
	}

	public void setInstructionsTab(WebElement instructionsTab) {
		InstructionsTab = instructionsTab;
	}

	public WebElement getSelectBoardSyllabus() {
		return selectBoardSyllabus;
	}

	public void setSelectBoardSyllabus(WebElement selectBoardSyllabus) {
		this.selectBoardSyllabus = selectBoardSyllabus;
	}

	public WebElement getBoardSelected() {
		return boardSelected;
	}

	public void setBoardSelected(WebElement boardSelected) {
		this.boardSelected = boardSelected;
	}

	public WebElement getSelectMedium() {
		return selectMedium;
	}

	public void setSelectMedium(WebElement selectMedium) {
		this.selectMedium = selectMedium;
	}

	public WebElement getMediumSelected() {
		return mediumSelected;
	}

	public void setMediumSelected(WebElement mediumSelected) {
		this.mediumSelected = mediumSelected;
	}

	public WebElement getSelectClass() {
		return selectClass;
	}

	public void setSelectClass(WebElement selectClass) {
		this.selectClass = selectClass;
	}

	public WebElement getClassSelected() {
		return classSelected;
	}

	public void setClassSelected(WebElement classSelected) {
		this.classSelected = classSelected;
	}

	public WebElement getSelectSubject() {
		return selectSubject;
	}

	public void setSelectSubject(WebElement selectSubject) {
		this.selectSubject = selectSubject;
	}

	public WebElement getSubjectSelected() {
		return subjectSelected;
	}

	public void setSubjectSelected(WebElement subjectSelected) {
		this.subjectSelected = subjectSelected;
	}

	public WebElement getSelectAudience() {
		return selectAudience;
	}

	public void setSelectAudience(WebElement selectAudience) {
		this.selectAudience = selectAudience;
	}

	public WebElement getAudienceSelected() {
		return AudienceSelected;
	}

	public void setAudienceSelected(WebElement audienceSelected) {
		AudienceSelected = audienceSelected;
	}

	public WebElement getChildTitle() {
		return ChildTitle;
	}

	public void setChildTitle(WebElement childTitle) {
		ChildTitle = childTitle;
	}

	public WebElement getChildDescription() {
		return ChildDescription;
	}

	public void setChildDescription(WebElement childDescription) {
		ChildDescription = childDescription;
	}

	public WebElement getCreateButton() {
		return CreateButton;
	}

	public void setCreateButton(WebElement createButton) {
		CreateButton = createButton;
	}

	public WebElement getSelectMCQ() {
		return SelectMCQ;
	}

	public void setSelectMCQ(WebElement selectMCQ) {
		SelectMCQ = selectMCQ;
	}

	public WebElement getNextButton() {
		return NextButton;
	}

	public void setNextButton(WebElement nextButton) {
		NextButton = nextButton;
	}

	public WebElement getEnterQue() {
		return EnterQue;
	}

	public void setEnterQue(WebElement enterQue) {
		EnterQue = enterQue;
	}

	public WebElement getEnterOptionFirst() {
		return EnterOptionFirst;
	}

	public void setEnterOptionFirst(WebElement enterOptionFirst) {
		EnterOptionFirst = enterOptionFirst;
	}

	public WebElement getEnterOptionSecond() {
		return EnterOptionSecond;
	}

	public void setEnterOptionSecond(WebElement enterOptionSecond) {
		EnterOptionSecond = enterOptionSecond;
	}

	public WebElement getCorrectAns() {
		return CorrectAns;
	}

	public void setCorrectAns(WebElement correctAns) {
		CorrectAns = correctAns;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public void setSaveButton(WebElement saveButton) {
		SaveButton = saveButton;
	}

	public WebElement getQueDetailTitle() {
		return QueDetailTitle;
	}

	public void setQueDetailTitle(WebElement queDetailTitle) {
		QueDetailTitle = queDetailTitle;
	}

	public WebElement getSelectSubjectiveQue() {
		return SelectSubjectiveQue;
	}

	public void setSelectSubjectiveQue(WebElement selectSubjectiveQue) {
		SelectSubjectiveQue = selectSubjectiveQue;
	}

	@FindBy(how=How.XPATH,using="//label[@for='answer_2']")
	private WebElement CorrectAns;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Save ']")
	private WebElement SaveButton;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Title']")
	private WebElement QueDetailTitle;
	
	@FindBy(how=How.XPATH,using="//img[@alt='Subjective Questionicon']")
	private WebElement SelectSubjectiveQue;
	
}
