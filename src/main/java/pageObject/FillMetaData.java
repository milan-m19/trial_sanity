package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FillMetaData {

	@FindBy(how=How.XPATH,using="((//select[@name=\"sb-dropdown\"])[2]")
	private WebElement boardInQuestion;
	
	@FindBy(how=How.XPATH,using="(//div[text()='Select Board' or text()= 'Select Board/Syllabus' ])[2]/following::div/div[1]")
	private WebElement selectstate_tn;
	
	@FindBy(how=How.XPATH,using="(//div[.='Select Medium'])[2]")
	private WebElement mediumInQuestion ;
	
	@FindBy(how=How.XPATH,using="(//div[.='Select Medium'])[2]/following::div/div[1]")
	private WebElement selectEnglish;
	 
	@FindBy(how=How.XPATH,using="(//div[.='Select Grade'])")
	private WebElement  classInQuestion;
	
	@FindBy(how=How.XPATH,using="(//div[.='Select Grade'])/following::div/div[1]")
	private WebElement selectClass4 ;
	
	@FindBy(how=How.XPATH,using="(//div[.='Select Subject'])[2]")
	private WebElement subjectInQuestion;
	
	@FindBy(how=How.XPATH,using="(//div[.='Select Subject'])[2]/following::div/div[1]")
	private WebElement  selectMathematics;

	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Copyright Year']")
	private WebElement CopyrightYearInQuestion;
	
	
	
	
	
	
	
	
	
	
	
	
}
