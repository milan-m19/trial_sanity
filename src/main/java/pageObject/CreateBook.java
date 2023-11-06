package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


	
	public class CreateBook {
		
		@FindBy(how=How.XPATH,using="(//div[@class='avatar-container'])[2]")
		private WebElement headerDropdown;
		
		@FindBy(how=How.XPATH,using="//*[contains(text(),'Workspace')]")
		private WebElement Workspace;
		
		@FindBy(how=How.XPATH,using="//div[@class='content']/..//span[.='Book']")
		private WebElement book;
		
		@FindBy(how=How.XPATH,using="//input[@placeholder='Name']")
		private WebElement bookname;
		
		@FindBy(how=How.XPATH,using="//button[contains(text(),'Start creating')]")
		private WebElement startCreating;
		
		@FindBy(how=How.XPATH,using="//select[@name='sb-dropdown']/option[text()='Select Board/Syllabus ']")
		private WebElement selectBoardSyllabus;
		
		@FindBy(how=How.XPATH,using="//select[@name='sb-dropdown']/option[text()='Others']")
		private WebElement boardSelected;
		
		@FindBy(how=How.XPATH,using="//li[text()='Select Medium']")
		private WebElement selectMedium;
		
		@FindBy(how=How.XPATH,using="//label[text()='English']")
		private WebElement mediumSelected;
		
		@FindBy(how=How.XPATH,using="//li[text()='Select Class']")
		private WebElement selectClass;
		
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
		
		@FindBy(how=How.XPATH,using="//div[@data-title='Add collaborator']")
		private WebElement AddCollaborator;
		
		@FindBy(how=How.XPATH,using="//input[@placeholder='Search...']")
		private WebElement SearchCollaborator;
		
		@FindBy(how=How.XPATH,using="//li[@class='searchResult ng-star-inserted']")
		private WebElement SelectCollaborator;
		
		@FindBy(how=How.XPATH,using="//button[text()=' Done ']")
		private WebElement DoneButton;
		
		@FindBy(how=How.XPATH,using="//button[contains(text(),'Send for Review')]")
		private WebElement submitForreviewButton;
		
		@FindBy(how=How.XPATH,using="//span[contains(text(),'I agree that by submitting / publishing this Content,')]")
		private WebElement termsAndConditionCheckbox;
		
		@FindBy(how=How.XPATH,using="(//button[@type='button'])[7]")
		private WebElement NewCoursesubmitButton;
		
		@FindBy(how=How.XPATH,using="//button[text()=' Back ']")
		private WebElement BackButton;
		
		@FindBy(how=How.XPATH,using="//p[text()='ContentCreator2.0']")
		private WebElement SelectContentCollaborator;
		
		public WebElement getSelectContentCollaborator() {
			return SelectContentCollaborator;
		}
		
		
		
		
		public WebElement getBackButton() {
			return BackButton;
		}
		
		
		public WebElement getSubmitForreviewButton() {
			return submitForreviewButton;
		}

		public void setSubmitForreviewButton(WebElement submitForreviewButton) {
			this.submitForreviewButton = submitForreviewButton;
		}

		public WebElement getTermsAndConditionCheckbox() {
			return termsAndConditionCheckbox;
		}

		public void setTermsAndConditionCheckbox(WebElement termsAndConditionCheckbox) {
			this.termsAndConditionCheckbox = termsAndConditionCheckbox;
		}

		public WebElement getNewCoursesubmitButton() {
			return NewCoursesubmitButton;
		}

		public void setNewCoursesubmitButton(WebElement newCoursesubmitButton) {
			NewCoursesubmitButton = newCoursesubmitButton;
		}

		public WebElement getAddCollaborator() {
			return AddCollaborator;
		}

		public void setAddCollaborator(WebElement addCollaborator) {
			AddCollaborator = addCollaborator;
		}

		public WebElement getSearchCollaborator() {
			return SearchCollaborator;
		}

		public void setSearchCollaborator(WebElement searchCollaborator) {
			SearchCollaborator = searchCollaborator;
		}

		public WebElement getSelectCollaborator() {
			return SelectCollaborator;
		}

		public void setSelectCollaborator(WebElement selectCollaborator) {
			SelectCollaborator = selectCollaborator;
		}

		public WebElement getDoneButton() {
			return DoneButton;
		}

		public void setDoneButton(WebElement doneButton) {
			DoneButton = doneButton;
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


		@FindBy(how=How.XPATH,using="//i[@Class='icon caret down']")
		private WebElement QRCodeDropdown;
		
		@FindBy(how=How.XPATH,using="//span[text()=' Generate  QR Codes ']")
		private WebElement GenerateQRCode;
		
		@FindBy(how=How.XPATH,using="//input[@inputmode='numeric']")
		private WebElement NoOfQRCode;
		
		@FindBy(how=How.XPATH,using="//button[text()='Request']")
		private WebElement RequestButton;
		
		@FindBy(how=How.XPATH,using="//a[text()=' Download 1 +1 QR codes ']")
		private WebElement DownloadQRCode;
		
		@FindBy(how=How.XPATH,using="//label[text()='Yes']")
		private WebElement YesQRCodeRequired;
		
		@FindBy(how=How.XPATH,using="//input[@placeholder='Enter code here']")
		private WebElement EnterQRCode;
		
		@FindBy(how=How.XPATH,using="//i[@class='large blue check circle icon']")
		private WebElement QRCodeBlueTick;
		
		@FindBy(how=How.XPATH,using="//i[@class='green check icon ng-star-inserted']")
		private WebElement ConfirmQRCodeBlueTick;
		
		@FindBy(how=How.XPATH,using="//button[text()=' Add Child ']")
		private WebElement AddChild;
		
		
		@FindBy(how=How.XPATH,using="//button[text()=' Send for Review ']")
		private WebElement SendForReview;
		

		@FindBy(how=How.XPATH,using="//input[@placeholder='Search or enter QR code']")
		private WebElement HomeSearchField;
		
		@FindBy(how=How.XPATH,using="//button[@title='Search in undefined']")
		private WebElement HomeSearchIcon;
		//button[text()='Search']
		@FindBy(how=How.XPATH,using="//a[text()=' Digital textbooks ']")
		private WebElement DigitalTextbook;
		
		@FindBy(how=How.XPATH,using="//div[@class='sb--card sb--card--theme2 ng-star-inserted']")
		private WebElement ClickSearchedbook;
		
		@FindBy(how=How.XPATH,using="//button[text()=' Copy ']")
		private WebElement CopyButton;
		
		@FindBy(how=How.XPATH,using="//div[@data-title='View collaborator']")
		private WebElement ViewCollaborator;
		
		
		@FindBy(how=How.XPATH,using="//p[text()='democontentcreator1']")
		private WebElement SelectDemoCollaborator;
		
		
		public WebElement getSelectDemoCollaborator() {
			return SelectDemoCollaborator;
		}
		
		public WebElement getViewCollaborator() {
			return ViewCollaborator;
		}
		
		
		public WebElement getCopyButton() {
			return CopyButton;
		}
		
		public WebElement getClickSearchedbook() {
			return ClickSearchedbook;
		}
		
		public WebElement getDigitalTextbook() {
			return DigitalTextbook;
		}
		
		public WebElement getHomeSearchField() {
			return HomeSearchField;
		}
		
		public WebElement getHomeSearchIcon() {
			return HomeSearchIcon;
		}
		
		public WebElement getSendForReview() {
			return SendForReview;
		}
		
		
		public WebElement getYesQRCodeRequired() {
			return YesQRCodeRequired;
		}

		public void setYesQRCodeRequired(WebElement yesQRCodeRequired) {
			YesQRCodeRequired = yesQRCodeRequired;
		}

		public WebElement getEnterQRCode() {
			return EnterQRCode;
		}

		public void setEnterQRCode(WebElement enterQRCode) {
			EnterQRCode = enterQRCode;
		}

		public WebElement getQRCodeBlueTick() {
			return QRCodeBlueTick;
		}

		public void setQRCodeBlueTick(WebElement qRCodeBlueTick) {
			QRCodeBlueTick = qRCodeBlueTick;
		}

		public WebElement getConfirmQRCodeBlueTick() {
			return ConfirmQRCodeBlueTick;
		}

		public void setConfirmQRCodeBlueTick(WebElement confirmQRCodeBlueTick) {
			ConfirmQRCodeBlueTick = confirmQRCodeBlueTick;
		}

		public WebElement getAddChild() {
			return AddChild;
		}

		public void setAddChild(WebElement addChild) {
			AddChild = addChild;
		}

		public WebElement getQRCodeDropdown() {
			return QRCodeDropdown;
		}

		public void setQRCodeDropdown(WebElement qRCodeDropdown) {
			QRCodeDropdown = qRCodeDropdown;
		}

		public WebElement getGenerateQRCode() {
			return GenerateQRCode;
		}

		public void setGenerateQRCode(WebElement generateQRCode) {
			GenerateQRCode = generateQRCode;
		}

		public WebElement getNoOfQRCode() {
			return NoOfQRCode;
		}

		public void setNoOfQRCode(WebElement noOfQRCode) {
			NoOfQRCode = noOfQRCode;
		}

		public WebElement getRequestButton() {
			return RequestButton;
		}

		public void setRequestButton(WebElement requestButton) {
			RequestButton = requestButton;
		}

		public WebElement getDownloadQRCode() {
			return DownloadQRCode;
		}

		public void setDownloadQRCode(WebElement downloadQRCode) {
			DownloadQRCode = downloadQRCode;
		}

		public WebElement getHeaderDropdown() {
			return headerDropdown;
		}

		public WebElement getWorkspace() {
			return Workspace;
		}

		public WebElement getBook() {
			return book;
		}


		public WebElement getBookname() {
			return bookname;
		}


		public WebElement getStartCreating() {
			return startCreating;
		}
		
	}	

	
