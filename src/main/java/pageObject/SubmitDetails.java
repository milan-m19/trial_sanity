package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SubmitDetails {

	@FindBy(how=How.XPATH,using="//button[text()=' Submit details ']")
	private WebElement SubmitDetails;
	
	@FindBy(how=How.XPATH,using="//div[@aria-label='Select State/Institution']")
	private WebElement InstitutionTab;
	
    @FindBy(how=How.XPATH,using="//input[@placeholder='Enter ID']")
	private WebElement Id;
    
    @FindBy(how=How.XPATH,using="//span[@class='checkmark']")
	private WebElement SubmitDetailCheckbox;
    
    @FindBy(how=How.XPATH,using="//span[text()='CBSE']")
	private WebElement CbscTab;
    
    @FindBy(how=How.XPATH,using="//button[text()=' Submit ']")
	private WebElement ProfileSubmitbutton;
    
    @FindBy(how=How.XPATH,using="(//span[text()='Required details '])[1]")
   	private WebElement RequiredDetails;

    public WebElement getRequiredDetails() {
		return RequiredDetails;
	}

    
	public WebElement getSubmitDetails() {
		return SubmitDetails;
	}

	public void setSubmitDetails(WebElement submitDetails) {
		SubmitDetails = submitDetails;
	}

	public WebElement getInstitutionTab() {
		return InstitutionTab;
	}

	public void setInstitutionTab(WebElement institutionTab) {
		InstitutionTab = institutionTab;
	}

	public WebElement getId() {
		return Id;
	}

	public void setId(WebElement id) {
		Id = id;
	}

	public WebElement getSubmitDetailCheckbox() {
		return SubmitDetailCheckbox;
	}

	public void setSubmitDetailCheckbox(WebElement submitDetailCheckbox) {
		SubmitDetailCheckbox = submitDetailCheckbox;
	}

	public WebElement getCbscTab() {
		return CbscTab;
	}

	public void setCbscTab(WebElement cbscTab) {
		CbscTab = cbscTab;
	}
	
	public WebElement getProfileSubmitbutton() {
		return ProfileSubmitbutton;
	}
	
	
	
	
}
