package pageActions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import pageObject.CourseConsumption;
import pageObject.ExploreState;
import utility.BaseClass;
import utility.DikshaUtils;

public class Explorestate extends BaseClass {

	public static void ValidateExploreStateValues() throws Exception {
		
		ExploreState state=PageFactory.initElements(driver, ExploreState.class);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);",state.getSelectStateDropdown());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(state.getSelectStateDropdown());
	
	
		
	
	
	
	
	
	
	
	
	
	}
	
}
	/*	Select dropdown = new Select(state.getSelectStateDropdown());
        List<WebElement> options = dropdown.getOptions();

        int count = options.size();
       System.out.println("The total number of State is: " + count);
        
        // Create a list of expected State
        List<String> expectedValues = new ArrayList<>();
        
        expectedValues.add("Andaman & Nicobar Islands");
        expectedValues.add("Arunachal Pradesh");
        expectedValues.add("Andhra Pradesh");
        expectedValues.add("Assam");
        expectedValues.add("Bihar");
        expectedValues.add("Chhattisgarh");
        expectedValues.add("Chandigarh");
        expectedValues.add("Delhi");
        expectedValues.add("Goa");
        expectedValues.add("Gujarat");
        expectedValues.add("Himachal Pradesh");
        expectedValues.add("Haryana");
        expectedValues.add("Jharkhand");
        expectedValues.add("Jammu And Kashmir");
        expectedValues.add("Karnataka");
        expectedValues.add("Kerala");
        expectedValues.add("Maharashtra");
        expectedValues.add("Meghalaya");
        expectedValues.add("Manipur");
        expectedValues.add("Madhya Pradesh");
        expectedValues.add("Mizoram");
        expectedValues.add("Nagaland");
        expectedValues.add("Odisha");
        expectedValues.add("Punjab");
        expectedValues.add("Pondicherry");
        expectedValues.add("Rajasthan");
        expectedValues.add("Sikkim");
        expectedValues.add("Tamil Nadu");
        expectedValues.add("Tripura");
        expectedValues.add("Telangana");
        expectedValues.add("Uttarakhand");
        expectedValues.add("Uttar Pradesh");
        

        for (String expectedValue : expectedValues) {
            boolean isValuePresent = false;
            for (WebElement option : options) {
                if (option.getText().equals(expectedValue)) {
                    isValuePresent = true;
                    break;
                }
            }
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(isValuePresent, "State '" + expectedValue + "' is NOT present in the dropdown.");
        }
	
		
	}
	*/

