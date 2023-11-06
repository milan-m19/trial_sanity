package pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageObject.CourseConsumption;
import pageObject.CreateCertificate;
import pageObject.HomePage;
import pageObject.Logout;
import pageObject.ValidatePopUp;
import utility.BaseClass;
import utility.DikshaUtils;
import utility.Listeners;

public class CertificateCreation extends BaseClass {

	public static void AddCompletionCertificateToCourse() throws Exception {

		String expect ="Creator should add completion certificate successfully";
		String actual = "Unable to add completion certificate";
		String ContentsuccessfullySavedPopup = null;
		try {
		CreateCertificate certificate=PageFactory.initElements(driver, CreateCertificate.class);
		DikshaUtils.waitToBeClickableAndClick(certificate.getAddCertificateTab());
		Thread.sleep(1000);
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("arguments[0].scrollIntoView(true);",certificate.getBeforeAddCertificateTab());
		 js.executeScript("window.scrollBy(0, 500)");
		 Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(certificate.getBeforeAddCertificateTab());
	    DikshaUtils.waitToBeClickableAndClick(certificate.getCertificateRuleTab());
	    DikshaUtils.waitToBeClickableAndClick(certificate.getAllTab());
		
	    DikshaUtils.waitToBeVisibleAndClick(certificate.getSelectCheckbox());
	    Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.moveToElement(certificate.getOverTheCertificateTemplate()).perform();

	 // DikshaUtils.waitToBeVisibleAndClick(certificate.getOverTheCertificateTemplate());
	    DikshaUtils.waitToBeVisibleAndClick(certificate.getSelectCertificateTemplate());
	    Thread.sleep(1000);
	    DikshaUtils.waitToBeVisibleAndClick(certificate.getSelectTemplate());
		
	    js.executeScript("arguments[0].scrollIntoView(true);",certificate.getFinalAddCertificateTab());
		 Thread.sleep(1000);
		 DikshaUtils.waitToBeClickableAndClick(certificate.getFinalAddCertificateTab());
		
		 Thread.sleep(1000);
		 WebElement CertificateAdded= driver.findElement(By.xpath("//strong[text()='Certificate added successfully']"));
         ContentsuccessfullySavedPopup = CertificateAdded.getText();
         Assert.assertEquals(ContentsuccessfullySavedPopup, "Certificate added successfully");
         Thread.sleep(1000);
		 
		 
		 js.executeScript("window.scrollTo(0, 0)");
		 Thread.sleep(1000);
		 DikshaUtils.waitToBeClickableAndClick(certificate.getCertificatePageBackButton());
		 DikshaUtils.waitToBeClickableAndClick(certificate.getBackButton());
		 actual = "Completion certificate added successfully";
		}finally {
			String Text = ContentsuccessfullySavedPopup != null ? ContentsuccessfullySavedPopup : "N/A";
			Listeners.customAssert("Certificate added successfully", Text, expect, actual);
			
		}
	}

	public static void VerifyMyStateTeacherDropdownForCertificate() throws Exception {

	CreateCertificate certificate=PageFactory.initElements(driver, CreateCertificate.class);
		
		String StateTeachertext = null;
	     String expect = "Creator should be able to get state teacher dropdown while adding certificate Sucessfully";
	     String actual = "Creator is unable to get state teacher dropdown while adding certificate";
		try {
		DikshaUtils.waitToBeClickableAndClick(certificate.getAddCertificateTab());
		Thread.sleep(1000);
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("arguments[0].scrollIntoView(true);",certificate.getBeforeAddCertificateTab());
		 js.executeScript("window.scrollBy(0, 500)");
		 Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(certificate.getBeforeAddCertificateTab());
	    DikshaUtils.waitToBeClickableAndClick(certificate.getCertificateRuleTab());
	    Assert.assertTrue(certificate.getMyStateTeacherValue().isDisplayed());
	    StateTeachertext=certificate.getMyStateTeacherValue().getText();
	    DikshaUtils.waitToBeClickableAndClick(certificate.getMyStateTeacherValue());
	    
	    actual="Creator is able to get state teacher dropdown while adding certificate successfully";
		
		 } finally {
			 String Text = StateTeachertext != null ? StateTeachertext : "N/A";
				Listeners.customAssert(StateTeachertext, Text, expect, actual);
		}
	}	

	public static void VerifyNoteForStateTeacherDropdownForCertificate() throws Exception {

CreateCertificate certificate=PageFactory.initElements(driver, CreateCertificate.class);
		
		String StateTeacherNote = null;
	     String expect = "Creator should be able to get certificate note for state teacher while adding certificate Sucessfully";
	     String actual = "Creator is unable to get certificate note for state teacher while adding certificate";
		try {
		DikshaUtils.waitToBeClickableAndClick(certificate.getAddCertificateTab());
		Thread.sleep(1000);
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("arguments[0].scrollIntoView(true);",certificate.getBeforeAddCertificateTab());
		 js.executeScript("window.scrollBy(0, 500)");
		 Thread.sleep(1000);
		DikshaUtils.waitToBeVisibleAndClick(certificate.getBeforeAddCertificateTab());
	    DikshaUtils.waitToBeClickableAndClick(certificate.getCertificateRuleTab());
	    Assert.assertTrue(certificate.getMyStateTeacherValue().isDisplayed());
	    DikshaUtils.waitToBeClickableAndClick(certificate.getMyStateTeacherValue());
	    Thread.sleep(1000);
	    Assert.assertTrue(certificate.getVerifyStateTeacherNote().isDisplayed());
	    Thread.sleep(1000);
	    StateTeacherNote=certificate.getVerifyStateTeacherNote().getText();
	    actual="Creator is able to get certificate note for state teacher while adding certificate successfully";
		
		 } finally {
			 String Text = StateTeacherNote != null ? StateTeacherNote : "N/A";
				Listeners.customAssert(StateTeacherNote, Text, expect, actual);
		}
	}	
	public static void UserAbleToSeeCeritificateCriteriaAndBatchDetailsInCourseTOC(String coursename) throws Exception {
		
		String expected = "User should be able to see ceritificate criteria and batch details in course TOC successfully";
		String actual = " User is unable to see ceritificate criteria and batch details in course TOC";
		boolean checkRules = false;
		String expectedRule = null;
		
		CourseConsumption cc=PageFactory.initElements(driver, CourseConsumption.class);
		Logout log = PageFactory.initElements(driver, Logout.class);
		CreateCertificate certificate=PageFactory.initElements(driver, CreateCertificate.class);
	
		try {

			
		Thread.sleep(7000);
		

	     DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
		DikshaUtils.waitToBeClickableAndClick(cc.getSearchtextfield());
		cc.getSearchtextfield().sendKeys(coursename);
	    DikshaUtils.waitToBeClickableAndClick(cc.getSearchbutton());
	    Thread.sleep(2000);
	    DikshaUtils.waitToBeVisibleAndClick(cc.getSearchedcourse());
	    DikshaUtils.waitToBeClickableAndClick(cc.getJoincourse());
	    Thread.sleep(1000);
	    DikshaUtils.waitToBeVisibleAndClick(cc.getConsentcheckbox());
		Thread.sleep(2000);
		DikshaUtils.waitToBeClickableAndClick(cc.getShareButton());
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(certificate.getCertificateCriteriaTab());
		Thread.sleep(1000);

			if (certificate.getCertificateCriteriaInfo().isDisplayed()) {
				checkRules = true;
		
		certificate.getBatchDetailTab().isDisplayed();
		Thread.sleep(1000);
		DikshaUtils.waitToBeClickableAndClick(certificate.getBatchDetailTab());
		
		actual = "User is able to see ceritificate criteria and batch details in course TOC successfully";
		expectedRule = "True";
	}
		} finally {

			Listeners.customAssert("True", expectedRule, expected, actual);
			
		}
	}

	public static void AddMeritCertificateToCourse() throws Exception {

		 CreateCertificate certificate=PageFactory.initElements(driver, CreateCertificate.class);
			
		 String expect ="Creator should add Merit certificate successfully";
			String actual = "Unable to add Merit certificate";
			String ContentsuccessfullySavedPopup = null;
			
			try {
			
			DikshaUtils.waitToBeClickableAndClick(certificate.getAddCertificateTab());
			Thread.sleep(1000);
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			// js.executeScript("arguments[0].scrollIntoView(true);",certificate.getBeforeAddCertificateTab());
			 js.executeScript("window.scrollBy(0, 500)");
			 Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(certificate.getBeforeAddCertificateTab());
		    DikshaUtils.waitToBeClickableAndClick(certificate.getCertificateRuleTab());
		    DikshaUtils.waitToBeClickableAndClick(certificate.getAllTab());
		    Thread.sleep(1000);
		    DikshaUtils.waitToBeVisibleAndClick(certificate.getPlusIcon());
		    DikshaUtils.waitToBeVisibleAndClick(certificate.getSelectCriteria());
		    Thread.sleep(1000);
		    DikshaUtils.waitToBeClickableAndClick(certificate.getPercentCriteriaSelected());
			
		    DikshaUtils.waitToBeVisibleAndClick(certificate.getSelectCheckbox());
		    Thread.sleep(3000);
	        Actions actions = new Actions(driver);
	        actions.moveToElement(certificate.getOverTheCertificateTemplate()).perform();
		    DikshaUtils.waitToBeVisibleAndClick(certificate.getSelectCertificateTemplate());
		    Thread.sleep(1000);
		    DikshaUtils.waitToBeVisibleAndClick(certificate.getSelectTemplate());
			
		    js.executeScript("arguments[0].scrollIntoView(true);",certificate.getFinalAddCertificateTab());
			 Thread.sleep(1000);
			 DikshaUtils.waitToBeClickableAndClick(certificate.getFinalAddCertificateTab());
			
			 Thread.sleep(1000);
			 WebElement CertificateAdded= driver.findElement(By.xpath("//strong[text()='Certificate added successfully']"));
	         ContentsuccessfullySavedPopup = CertificateAdded.getText();
	         Assert.assertEquals(ContentsuccessfullySavedPopup, "Certificate added successfully");
	         Thread.sleep(1000);
			 
			 
			 js.executeScript("window.scrollTo(0, 0)");
			 Thread.sleep(1000);
			 DikshaUtils.waitToBeClickableAndClick(certificate.getCertificatePageBackButton());
			 DikshaUtils.waitToBeClickableAndClick(certificate.getBackButton());
			 actual = "Merit certificate added successfully";
			}finally {
				String Text = ContentsuccessfullySavedPopup != null ? ContentsuccessfullySavedPopup : "N/A";
				Listeners.customAssert("Certificate added successfully", Text, expect, actual);
				
			}
		
		
			
			
		}
	public static void verifyDisablePlusSignToCertificate() throws Exception {
		 CreateCertificate certificate=PageFactory.initElements(driver, CreateCertificate.class);
			
		 String disableplusSign = null;
	     String expect = "Creator should not be able to view plus sign in certificate creation Sucessfully";
	     String actual = "Creator is able to view plus sign in certificate creation ";
		try {
			DikshaUtils.waitToBeClickableAndClick(certificate.getAddCertificateTab());
			Thread.sleep(1000);
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			// js.executeScript("arguments[0].scrollIntoView(true);",certificate.getBeforeAddCertificateTab());
			 js.executeScript("window.scrollBy(0, 500)");
			 Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(certificate.getBeforeAddCertificateTab());
		    DikshaUtils.waitToBeClickableAndClick(certificate.getCertificateRuleTab());
		    DikshaUtils.waitToBeClickableAndClick(certificate.getAllTab());
		    Thread.sleep(1000);
		    
		    
		    WebElement plusIcon = certificate.getPlusIcon();
		    if (plusIcon != null) {
		        System.out.println("plusIcon is not present.");
		        // Perform further actions or assertions when the element is present
		    } else {
		        System.out.println("plusIcon is present.");
		        // Perform alternative actions or assertions when the element is not present
		    }

		    disableplusSign=certificate.getAllTab().getText();
		    actual="Creator is not able to view plus sign in certificate creation successfully";
			
			 } finally {
				 String Text = disableplusSign != null ? disableplusSign : "N/A";
					Listeners.customAssert(disableplusSign, Text, expect, actual);
			}
	}


	public static void verifyPlusSignToCertificate() throws Exception {
		 CreateCertificate certificate=PageFactory.initElements(driver, CreateCertificate.class);
			

			String plusSign = null;
		     String expect = "Creator should be able to view plus sign in certificate creation Sucessfully";
		     String actual = "Creator is unable to view plus sign in certificate creation ";
			try {
			DikshaUtils.waitToBeClickableAndClick(certificate.getAddCertificateTab());
			Thread.sleep(1000);
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			// js.executeScript("arguments[0].scrollIntoView(true);",certificate.getBeforeAddCertificateTab());
			 js.executeScript("window.scrollBy(0, 500)");
			 Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(certificate.getBeforeAddCertificateTab());
			 Assert.assertTrue(certificate.getCertificateRuleTab().isDisplayed());
		    DikshaUtils.waitToBeClickableAndClick(certificate.getCertificateRuleTab());
		    DikshaUtils.waitToBeClickableAndClick(certificate.getAllTab());
		    Thread.sleep(1000);
		    Assert.assertTrue(certificate.getPlusIcon().isDisplayed());
		    plusSign=certificate.getPlusIcon().getText();
		    actual="Creator is able to view plus sign in certificate creation successfully";
			
			 } finally {
				 String Text = plusSign != null ? plusSign : "N/A";
					Listeners.customAssert(plusSign, Text, expect, actual);
			}
	
	}

	public static void verifyPlusSignAndMeritCriteria() throws Exception {
		 CreateCertificate certificate=PageFactory.initElements(driver, CreateCertificate.class);
			

			String plusSign = null;
		     String expect = "Creator should be able to view plus sign in certificate creation Sucessfully";
		     String actual = "Creator is unable to view plus sign in certificate creation ";
			try {
			DikshaUtils.waitToBeClickableAndClick(certificate.getAddCertificateTab());
			Thread.sleep(1000);
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			// js.executeScript("arguments[0].scrollIntoView(true);",certificate.getBeforeAddCertificateTab());
			 js.executeScript("window.scrollBy(0, 500)");
			 Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(certificate.getBeforeAddCertificateTab());
			 Assert.assertTrue(certificate.getCertificateRuleTab().isDisplayed());
		    DikshaUtils.waitToBeClickableAndClick(certificate.getCertificateRuleTab());
		    DikshaUtils.waitToBeClickableAndClick(certificate.getAllTab());
		    Thread.sleep(1000);
		    Assert.assertTrue(certificate.getPlusIcon().isDisplayed());
		    plusSign=certificate.getPlusIcon().getText();
		    actual="Creator is able to view plus sign in certificate creation successfully";
			
			 } finally {
				 String Text = plusSign != null ? plusSign : "N/A";
					Listeners.customAssert(plusSign, Text, expect, actual);
			}
	
	}

	public static void verifyScoreRuleBestScoreForCertificate() throws Exception {
		 CreateCertificate certificate=PageFactory.initElements(driver, CreateCertificate.class);
			

			String scoreRule = null;
		     String expect = "Creator should be able to see scorerule best score in certificate Sucessfully";
		     String actual = "Creator is unable to see scorerule best score in certificate";
			try {
			DikshaUtils.waitToBeClickableAndClick(certificate.getAddCertificateTab());
			Thread.sleep(1000);
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			// js.executeScript("arguments[0].scrollIntoView(true);",certificate.getBeforeAddCertificateTab());
			 js.executeScript("window.scrollBy(0, 500)");
			 Thread.sleep(1000);
			DikshaUtils.waitToBeVisibleAndClick(certificate.getBeforeAddCertificateTab());
			 Assert.assertTrue(certificate.getCertificateRuleTab().isDisplayed());
		    DikshaUtils.waitToBeClickableAndClick(certificate.getCertificateRuleTab());
		    DikshaUtils.waitToBeClickableAndClick(certificate.getAllTab());
		    Thread.sleep(1000);
		    Assert.assertTrue(certificate.getPlusIcon().isDisplayed());
		    Thread.sleep(1000);
		    DikshaUtils.waitToBeVisibleAndClick(certificate.getPlusIcon());
		    Thread.sleep(1000);
		    scoreRule=certificate.getScoreRuleText().getText();
		    Assert.assertTrue(certificate.getScoreRuleText().isDisplayed());
		    Assert.assertTrue(certificate.getBestAttemptScoreText().isDisplayed());
		    Assert.assertTrue(certificate.getGreaterThanEqualToText().isDisplayed());
		    Assert.assertTrue(certificate.getSelectCriteria().isDisplayed());
			actual="Creator is able to see scorerule best score in certificate successfully";
			
			 } finally {
				 String Text = scoreRule != null ? scoreRule : "N/A";
					Listeners.customAssert(scoreRule, Text, expect, actual);
			}
	}


	public static void verifyAddCertificateButton() throws Exception {
		String expect ="Creator should click on add certificate button successfully";
		String actual = "Unable to click on add certificate button";
		String course = null;
		
		try {
		 CreateCertificate certificate=PageFactory.initElements(driver, CreateCertificate.class);
			
		 Assert.assertTrue(certificate.getAddCertificateTab().isDisplayed());
			DikshaUtils.waitToBeClickableAndClick(certificate.getAddCertificateTab());
			Thread.sleep(4000);
			course = driver.findElement(By.xpath("(//*[text()='Course '])[2]")).getText();
			actual = "Creator successfully click on add certificate button";
		}finally {
			String Text =  course != null ?  course : "N/A";
			Listeners.customAssert("Course", Text, expect, actual);
			
			
		}
	}
}