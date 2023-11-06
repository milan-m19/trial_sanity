package ExploreDikshaPage;

import org.testng.annotations.Test;

import pageActions.CreateGroups;
import pageActions.Explorestate;
import pageActions.UserOnBoarding;
import pageObject.ExploreState;
import utility.BaseClass;

public class ValidateState extends BaseClass {

	
	@Test
    public void  ValidateStateValues() throws Exception {
		
		Explorestate.ValidateExploreStateValues();
			
	}
	
	
	
	
	
	
	
}
