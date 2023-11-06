package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ExploreState {

	
	@FindBy(how=How.XPATH,using="//select[@id='state']")
	private WebElement SelectStateDropdown;
	
	public WebElement getSelectStateDropdown() {
		return SelectStateDropdown;
	}
 
	
}
