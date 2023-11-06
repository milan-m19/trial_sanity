package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UpdateProfile {

	    @FindBy(how=How.XPATH,using="//button[text()='Update']")
		private WebElement BeforeUpdateButton;
	    
	    @FindBy(how=How.XPATH,using="//button[text()=' Update ']")
		private WebElement AfterUpdateButton;
	
	    @FindBy(how=How.XPATH,using="//input[@placeholder='Enter ID']")
		private WebElement Id;

	    @FindBy(how=How.XPATH,using="//div[text()=' Akash123']")
		private WebElement UpdateIdText;

		public WebElement getBeforeUpdateButton() {
			return BeforeUpdateButton;
		}

		public void setBeforeUpdateButton(WebElement beforeUpdateButton) {
			BeforeUpdateButton = beforeUpdateButton;
		}

		public WebElement getAfterUpdateButton() {
			return AfterUpdateButton;
		}

		public void setAfterUpdateButton(WebElement afterUpdateButton) {
			AfterUpdateButton = afterUpdateButton;
		}

		public WebElement getId() {
			return Id;
		}

		public void setId(WebElement id) {
			Id = id;
		}

		public WebElement getUpdateIdText() {
			return UpdateIdText;
		}

		public void setUpdateIdText(WebElement updateIdText) {
			UpdateIdText = updateIdText;
		}
	
}
