package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Collections {

	@FindBy(how=How.XPATH,using="(//div[@class='avatar-container'])[2]")
	private WebElement headerDropdown;
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Workspace')]")
	private WebElement Workspace;
	
	@FindBy(how=How.XPATH,using="//span[text()='Collection']")
	private WebElement Collections;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Name']")
	private WebElement NameFeild;
	
	@FindBy(how=How.XPATH,using="//sui-select[@id='primaryCategory']")
	private WebElement CollectionType;
	
	@FindBy(how=How.XPATH,using="//span[text()='Digital Textbook']")
	private WebElement Textbook;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Start creating ']")
	private WebElement StartCreatingTab;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Publish ']")
	private WebElement publishCollections;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Yes ']")
	private WebElement YesTab;
	
	@FindBy(how=How.XPATH,using="//select[@name='sb-dropdown']/option[text()='Select Board/Syllabus ']")
	private WebElement selectBoardSyllabus;
	
	@FindBy(how=How.XPATH,using="//select[@name='sb-dropdown']/option[text()='Others']")
	private WebElement boardSelected;
	
	@FindBy(how=How.XPATH,using="//li[text()='Select Medium']")
	private WebElement selectMedium;
	//li[text()='Select Medium']
	//div[text()='Select Medium']
	
	public WebElement getPublishCollections() {
		return publishCollections;
	}

	public void setPublishCollections(WebElement publishCollections) {
		this.publishCollections = publishCollections;
	}

	public WebElement getNoHateSpeech() {
		return noHateSpeech;
	}

	public void setNoHateSpeech(WebElement noHateSpeech) {
		this.noHateSpeech = noHateSpeech;
	}

	public WebElement getNoSexualContent() {
		return noSexualContent;
	}

	public void setNoSexualContent(WebElement noSexualContent) {
		this.noSexualContent = noSexualContent;
	}

	public WebElement getNoDiscrimination() {
		return noDiscrimination;
	}

	public void setNoDiscrimination(WebElement noDiscrimination) {
		this.noDiscrimination = noDiscrimination;
	}

	public WebElement getSuitableForChildren() {
		return suitableForChildren;
	}

	public void setSuitableForChildren(WebElement suitableForChildren) {
		this.suitableForChildren = suitableForChildren;
	}

	public WebElement getAppropriateTitle() {
		return appropriateTitle;
	}

	public void setAppropriateTitle(WebElement appropriateTitle) {
		this.appropriateTitle = appropriateTitle;
	}

	public WebElement getCorrectBMC() {
		return correctBMC;
	}

	public void setCorrectBMC(WebElement correctBMC) {
		this.correctBMC = correctBMC;
	}

	public WebElement getAppropriateTags() {
		return appropriateTags;
	}

	public void setAppropriateTags(WebElement appropriateTags) {
		this.appropriateTags = appropriateTags;
	}

	public WebElement getRelevantKeywords() {
		return relevantKeywords;
	}

	public void setRelevantKeywords(WebElement relevantKeywords) {
		this.relevantKeywords = relevantKeywords;
	}

	public WebElement getContentplayscorrectly() {
		return Contentplayscorrectly;
	}

	public void setContentplayscorrectly(WebElement contentplayscorrectly) {
		Contentplayscorrectly = contentplayscorrectly;
	}

	public WebElement getCanseethecontent() {
		return Canseethecontent;
	}

	public void setCanseethecontent(WebElement canseethecontent) {
		Canseethecontent = canseethecontent;
	}

	public WebElement getAudio() {
		return audio;
	}

	public void setAudio(WebElement audio) {
		this.audio = audio;
	}

	public WebElement getNoSpellingmistakes() {
		return NoSpellingmistakes;
	}

	public void setNoSpellingmistakes(WebElement noSpellingmistakes) {
		NoSpellingmistakes = noSpellingmistakes;
	}

	public WebElement getLanguage() {
		return language;
	}

	public void setLanguage(WebElement language) {
		this.language = language;
	}

	@FindBy(how=How.XPATH,using="//label[text()='English']")
	private WebElement mediumSelected;
	//label[text()='English']
//	(//div[text()='English'])[1]
	
	@FindBy(how=How.XPATH,using="//li[text()='Select Class']")
	private WebElement selectClass;
	//li[text()='Select Class']
	//div[text()='Select Class']
	
	@FindBy(how=How.XPATH,using="//label[text()='Class 1']")
	private WebElement classSelected;
	
	@FindBy(how=How.XPATH,using="//li[text()='Select Subject']")
	private WebElement selectSubject;
	
	@FindBy(how=How.XPATH,using="//label[text()='EVS']")
	private WebElement subjectSelected;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Copyright Year']")
	private WebElement copyright;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Save as Draft ']")
	private WebElement SaveAsDraft;
	
	@FindBy(how=How.XPATH,using="//input[@id='no-hate-speech-abuse-violence-profanity']")
    private WebElement noHateSpeech;

	@FindBy(how=How.XPATH,using="//input[@id='no-sexual-content-nudity-or-vulgarity']")
    private WebElement noSexualContent;
	
	@FindBy(how=How.XPATH,using="//input[@id='no-discrimination-or-defamation']")
    private WebElement noDiscrimination;
	 
	@FindBy(how=How.XPATH,using="//input[@id='is-suitable-for-children']")
    private WebElement suitableForChildren;
	
	@FindBy(how=How.XPATH,using="//input[@id='appropriate-title-description']")
    private WebElement appropriateTitle;
	
	@FindBy(how=How.XPATH,using="//input[@id='correct-board-grade-subject-medium']")
    private WebElement correctBMC;
	
	@FindBy(how=How.XPATH,using="//input[@id='appropriate-tags-such-as-resource-type-concepts']")
    private WebElement appropriateTags;
	
	@FindBy(how=How.XPATH,using="//input[@id='relevant-keywords']")
    private WebElement relevantKeywords;
	
	@FindBy(how=How.XPATH,using="//input[@id='content-plays-correctly']")
    private WebElement Contentplayscorrectly;
	

	@FindBy(how=How.XPATH,using="//input[@id='can-see-the-content-clearly-on-desktop-and-app']")
    private WebElement Canseethecontent;
	
	@FindBy(how=How.XPATH,using="//input[@id='audio-if-any-is-clear-and-easy-to-understand']")
    private WebElement audio;
	
	@FindBy(how=How.XPATH,using="//input[@id='no-spelling-mistakes-in-the-text']")
    private WebElement NoSpellingmistakes;
	
	@FindBy(how=How.XPATH,using="//input[@id='language-is-simple-to-understand']")
    private WebElement language;
	
	
	
	
	
	
	
	
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

	public WebElement getCopyright() {
		return copyright;
	}

	public void setCopyright(WebElement copyright) {
		this.copyright = copyright;
	}

	public WebElement getSaveAsDraft() {
		return SaveAsDraft;
	}

	public void setSaveAsDraft(WebElement saveAsDraft) {
		SaveAsDraft = saveAsDraft;
	}

	public WebElement getYesTab() {
		return YesTab;
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

	public WebElement getCollections() {
		return Collections;
	}

	public void setCollections(WebElement collections) {
		Collections = collections;
	}

	public WebElement getNameFeild() {
		return NameFeild;
	}

	public void setNameFeild(WebElement nameFeild) {
		NameFeild = nameFeild;
	}

	public WebElement getCollectionType() {
		return CollectionType;
	}

	public void setCollectionType(WebElement collectionType) {
		CollectionType = collectionType;
	}

	public WebElement getTextbook() {
		return Textbook;
	}

	public void setTextbook(WebElement textbook) {
		Textbook = textbook;
	}

	public WebElement getStartCreatingTab() {
		return StartCreatingTab;
	}

	public void setStartCreatingTab(WebElement startCreatingTab) {
		StartCreatingTab = startCreatingTab;
	}
	
	public WebElement getpublishCollections() {
		return publishCollections;
	}
	
	
}
