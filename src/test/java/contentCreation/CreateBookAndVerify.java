package contentCreation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageActions.Book_Creation;
import pageActions.PublishedMethods;
import pageActions.UpForReviewMethods;
import pageActions.UserOnBoarding;
import pageObject.ExplorePage;
import utility.BaseClass;
import utility.DikshaUtils;

public class CreateBookAndVerify extends BaseClass {

	@Test
	public void VerifyCreatorGenerateAndDownloadQRCode() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		Book_Creation.VerifyCreatorAbleToGenerateAndDownloadQRCode();

	}

	@Test
	public void VerifyCreatorValidateQRCode() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		Book_Creation.VerifyCreatorAbleToValidateQRCode();

	}

	@Test
	public void VerifyCreatorAddCollaboratorInTextbook() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String Bookname = Book_Creation.VerifyCreatorAbleToAddCollaboratorInTextbook();
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.eTextbook_up_For_Review(Bookname);
		UserOnBoarding.logout("Reviewer");
		UserOnBoarding.login("Creator");
		PublishedMethods.AddCollaboratorInPublished_eTextbook(Bookname);

	}

	@Test
	public void VerifyAdminUdpateTextbookDetailsForDraftBookAndlive() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String Bookname = Book_Creation.CreatebookAndSaveAsDraft();
		Book_Creation.EditTheBookFromDraft(Bookname);
		UserOnBoarding.logout("Creator");

	}

	@Test
	public void VerifyCreatorCopyeTextbookAndSendForReviewAndPublishTheContents() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String Bookname = Book_Creation.CreateBookAndSendForReview();
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.eTextbook_up_For_Review(Bookname);
		UserOnBoarding.logout("Reviewer");
		//UserOnBoarding.logout();
		UserOnBoarding.login("Creator");
		Book_Creation.CopyThePublishedBookAndSendForReview(Bookname);
		UserOnBoarding.logout("Creator");
		//UserOnBoarding.logout();
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.eTextbook_up_For_Review(Bookname);

	}

	@Test
	public void VerifyReviewerPreviewAndRejecteTextbook() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String Bookname = Book_Creation.CreateBookAndSendForReview();
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.eTextbookPreviewAndRejectFrom_up_For_Review(Bookname);

	}

	// @Test
	// Currently known issue
	public void VerifyReviewerViewTheCollaboratorAddedToeTextbook() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String Bookname = Book_Creation.CreateBookAddCollaboratorAndSendForReview();
		UserOnBoarding.logout("Creator");
		UserOnBoarding.login("Reviewer");
		UpForReviewMethods.ReviwerViewCollaboratorAddedToeTextbookFrom_up_For_Review(Bookname);

	}

	@Test
	public void VerifyCreatorAddAllTypesOfContent() throws Exception {

		String userRole = UserOnBoarding.SelectUserRole("Student");
		UserOnBoarding.bmcpopuphandle();
		UserOnBoarding.locationpopuphandle(userRole);
		UserOnBoarding.login("Creator");
		String Bookname = Book_Creation.CreatorAddAllTypeOfContent();
		Book_Creation.SearchTheBookFromDraft(Bookname);

	}

}