package contentCreation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.SendForReviewMethods;
import pageActions.UpForReviewMethods;
import pageActions.UploadContentMethods;
import pageActions.UserOnBoarding;
import pageObject.ExplorePage;
import utility.BaseClass;
import utility.DikshaUtils;

public class UploadAllContentsTypes extends BaseClass {
	

	
	  @Test
	public void uploadPdf() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName=UploadContentMethods.UploadPdf();
		SendForReviewMethods.sendPdf_For_Review(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.up_For_Review(contentName);
		
	}
	

  @Test

	public void uploadMp4() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName=UploadContentMethods.UploadMp4();
		SendForReviewMethods.sendMp4_For_Review(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.up_For_Review(contentName);
		
	}
   
   @Test
	public void uploadEpub() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName=UploadContentMethods.UploadEpub();
		SendForReviewMethods.sendEpub_For_Review(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.up_For_Review(contentName);
		
	}


  @Test
	public void uploadWebm() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName=UploadContentMethods.UploadWebm();
		SendForReviewMethods.sendWebm_For_Review(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.up_For_Review(contentName);
		
	}
    
   @Test
	public void uploadH5p() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName=UploadContentMethods.UploadH5p();
		SendForReviewMethods.sendH5p_For_Review(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.up_For_Review(contentName);
		
	}
    
   @Test
	public void uploadYTContent() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName=UploadContentMethods.UploadYoutubeContent();
		SendForReviewMethods.sendYoutubeContent_For_Review(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.up_For_Review(contentName);
		
	}
    


   @Test
	public void uploadHtmlContent() throws Exception {
		
		UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle();
		UserOnBoarding.login("Creator");
		String contentName=UploadContentMethods.UploadHtmlContent();
		SendForReviewMethods.sendHtmlContent_For_Review(contentName);
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.up_For_Review(contentName);
		
	}
    
	  @Test
		public void uploadMoreThan50MbContent() throws Exception {
			
			UserOnBoarding.SelectUserRole("Student");
			UserOnBoarding.bmcpopuphandle();
			UserOnBoarding.locationpopuphandle();
			UserOnBoarding.login("Creator");
			String contentName=UploadContentMethods.UploadMorethan50MbContent();
			SendForReviewMethods.sendMoreThan50MbContent_For_Review(contentName);
			UserOnBoarding.logout("Creator");
			UserOnBoarding.login("Reviewer");
			UpForReviewMethods.up_For_Review(contentName);
			
		}
	    
}