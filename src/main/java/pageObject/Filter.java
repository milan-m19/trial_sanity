package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Filter {

	@FindBy(how=How.XPATH,using="(//div[@class='mat-select-arrow'])[3]")
	private WebElement medium;
	
	@FindBy(how=How.XPATH,using="//mat-option[@aria-label='Hindi']")
	private WebElement mediumhindi;
	
	@FindBy(how=How.XPATH,using="//span[text()=' English ']")
	private WebElement mediumenglish;
	
	@FindBy(how=How.XPATH,using="//mat-form-field[@id='gradeLevel']")
	private WebElement classs;
	
	public WebElement getMedium() {
		return medium;
	}

	public void setMedium(WebElement medium) {
		this.medium = medium;
	}

	public WebElement getMediumhindi() {
		return mediumhindi;
	}

	public void setMediumhindi(WebElement mediumhindi) {
		this.mediumhindi = mediumhindi;
	}

	public WebElement getMediumenglish() {
		return mediumenglish;
	}

	public void setMediumenglish(WebElement mediumenglish) {
		this.mediumenglish = mediumenglish;
	}

	public WebElement getClasss() {
		return classs;
	}

	public void setClasss(WebElement classs) {
		this.classs = classs;
	}

	public WebElement getSelectclasss1() {
		return Selectclasss1;
	}

	public void setSelectclasss1(WebElement selectclasss1) {
		Selectclasss1 = selectclasss1;
	}

	public WebElement getSelectclasss2() {
		return Selectclasss2;
	}

	public void setSelectclasss2(WebElement selectclasss2) {
		Selectclasss2 = selectclasss2;
	}

	@FindBy(how=How.XPATH,using="//label[text()='Class']")
	private WebElement Selectclasss1;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Class 2 ']")
	private WebElement Selectclasss2;
	
	
	
	
	
	
	
	
	
	
	
	
}
