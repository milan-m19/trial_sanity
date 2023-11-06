package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Groups {

	@FindBy(how = How.XPATH, using = "(//div[@class='avatar-container'])[2]")
	private WebElement headerDropdown;

	@FindBy(how = How.XPATH, using = "//li[text()=' My Groups ']")
	private WebElement MyGropus;

	@FindBy(how = How.XPATH, using = "//button[text()=' Create group ']")
	private WebElement BeforeCreateGroupsButton;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter group name']")
	private WebElement GroupName;

	@FindBy(how = How.XPATH, using = "//input[@role='checkbox']")
	private WebElement IAgreeCheckbox;

	@FindBy(how = How.XPATH, using = "//button[@aria-label='Back']")
	private WebElement GroupBackButton;

	@FindBy(how = How.XPATH, using = "//button[@class='sb-btn sb-btn-primary sb-btn-normal flex-ai-jc-center mb-8 ng-star-inserted']")
	private WebElement AfterCreateGroupsButton;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'GroupName_')]")
	private WebElement Selectgroup;
//	(//div[@Class='sb--card sb--card--course--curiculum ng-star-inserted'])[1]

	// div[contains(text(),'GroupName_')]
	@FindBy(how = How.XPATH, using = "//div[text()=' Add member ']")
	private WebElement AddMember;

	@FindBy(how = How.XPATH, using = "//a[@aria-label='Close Welcome dialog']")
	private WebElement CrossTab;

	@FindBy(how = How.XPATH, using = "//a[@aria-label='Close Member dialog']")
	private WebElement IdCrossTab;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter DIKSHA ID']")
	private WebElement SearchId;

	@FindBy(how = How.XPATH, using = "(//button[text()='Verify'])[1]")
	private WebElement VerifyId;
	// button[text()=' Add to group ']
	@FindBy(how = How.XPATH, using = "//button[text()=' Add to group ']")
	private WebElement IdSelected;

	@FindBy(how = How.XPATH, using = "//button[text()=' Add activity ']")
	private WebElement AddActivity;

	@FindBy(how = How.XPATH, using = "//h4[@title='Digital textbooks']")
	private WebElement DigitalTextbook;

	@FindBy(how = How.XPATH, using = "//span[text()='Add to group']")
	private WebElement SelectBook;

	@FindBy(how = How.XPATH, using = "(//div[@Class='sb--card sb--card--theme2 sb--card--recently-viewed ng-star-inserted'])[1]")
	private WebElement OverTheBook;

	@FindBy(how = How.XPATH, using = "//div[@Class='kabab-menu']")
	private WebElement kababmenu;

	@FindBy(how = How.XPATH, using = "//div[text()=' Enable discussions ']")
	private WebElement EnableOption;

	@FindBy(how = How.XPATH, using = "//div[text()=' Disable discussions ']")
	private WebElement DisableOption;

	@FindBy(how = How.XPATH, using = "//button[text()='Disable discussions']")
	private WebElement DisableOptionPopup;

	@FindBy(how = How.XPATH, using = "//button[@title='Forum']")
	private WebElement ForumOption;

	@FindBy(how = How.XPATH, using = "//a[text()='Categories']")
	private WebElement categories;

	@FindBy(how = How.XPATH, using = "//a[text()='Tags']")
	private WebElement tags;

	@FindBy(how = How.XPATH, using = "//a[text()='My discussion']")
	private WebElement MyDiscussion;

	@FindBy(how = How.XPATH, using = "//a[text()=' Recent posts ']")
	private WebElement Recentposts;

	@FindBy(how = How.XPATH, using = "//a[text()=' Best posts ']")
	private WebElement Bestposts;

	@FindBy(how = How.XPATH, using = "//a[text()=' Saved posts ']")
	private WebElement Savedposts;

	@FindBy(how = How.XPATH, using = "//a[text()=' Upvoted ']")
	private WebElement Upvoted;

	@FindBy(how = How.XPATH, using = "//a[text()=' Downvoted ']")
	private WebElement Downvoted;

	@FindBy(how = How.XPATH, using = "//button[@id='close-discussion-forum']")
	private WebElement DiscussionCloseButton;

	@FindBy(how = How.XPATH, using = "//em[@title='Close sidebar']")
	private WebElement CloseheaderDropdown;

	@FindBy(how = How.XPATH, using = "//textarea[@id='group-description-input']")
	private WebElement Description;

	@FindBy(how = How.XPATH, using = "//a[@class='menu ng-star-inserted']")
	private WebElement KababMenuForTextbook;

	@FindBy(how = How.XPATH, using = "//span[text()='Remove activity']")
	private WebElement RemoveActivity;

	@FindBy(how = How.XPATH, using = "//button[text()='Remove']")
	private WebElement ConfirmRemoveActivity;

	@FindBy(how = How.XPATH, using = "//div[text()=' Edit group details ']")
	private WebElement EditGroupDetails;

	@FindBy(how = How.XPATH, using = "//div[text()='Delete group ']")
	private WebElement DeleteGroup;

	@FindBy(how = How.XPATH, using = "//button[text()='Delete']")
	private WebElement ConfirmDeleteGroup;

	@FindBy(how = How.XPATH, using = "//button[text()=' Update group ']")
	private WebElement UpdateGroup;

	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'GroupName_')]")
	private WebElement EditGroupName;

	@FindBy(how = How.XPATH, using = "(//div[@style='visibility: visible;'])[2]")
	private WebElement GroupMemberKababMenu;

	@FindBy(how = How.XPATH, using = "(//div[@style='visibility: visible;'])[3]")
	private WebElement DismissGroupMemberKababMenu;

	@FindBy(how = How.XPATH, using = "//span[text()='Make admin']")
	private WebElement MakeAdmin;

	@FindBy(how = How.XPATH, using = "//button[text()='Make admin']")
	private WebElement ConfirmMakeAdmin;

	@FindBy(how = How.XPATH, using = "//span[text()='Dismiss as admin']")
	private WebElement DismissAsAdmin;

	@FindBy(how = How.XPATH, using = "//button[text()='Dismiss as admin']")
	private WebElement ConfirmDismissAsAdmin;

	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	private WebElement SelectCheckbox;

	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	private WebElement YesTab;

	@FindBy(how = How.XPATH, using = "//span[text()='Remove member']")
	private WebElement RemoveMember;

	@FindBy(how = How.XPATH, using = "//button[text()='Remove member']")
	private WebElement ConfirmRemoveMember;

	@FindBy(how = How.XPATH, using = "//div[text()='Discussion Forum for Groups']")
	private WebElement CreateDiscussionForum;

	@FindBy(how = How.XPATH, using = "//button[@id='start-discussion']")
	private WebElement StartDiscussion;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='question']")
	private WebElement DiscussionTopic;

	@FindBy(how = How.XPATH, using = "//textarea[@id='description']")
	private WebElement DiscussionTopicDiscription;

	@FindBy(how = How.XPATH, using = "//span[text()='Submit']")
	private WebElement DiscussionSubmitButton;

	@FindBy(how = How.XPATH, using = "//h3[@class='discuss-card-title ng-star-inserted']")
	private WebElement DiscussionTopicName;

	@FindBy(how = How.XPATH, using = "//div[@class='kabab-menu']")
	private WebElement DiscussionTopicKababMenu;

	@FindBy(how = How.XPATH, using = "//div[text()='Edit ']")
	private WebElement EditButtonForDiscussionTopic;

	@FindBy(how = How.XPATH, using = "//span[text()='Update']")
	private WebElement DiscussionUpdateButton;

	@FindBy(how = How.XPATH, using = "//h3[@class='discussion-card-title df-label-color']")
	private WebElement UpdatedDiscussionTopicName;

	// @FindBy(how=How.XPATH,using="//textarea[@placeholder='Type here (minimum 10
	// characters)']")

	@FindBy(how = How.XPATH, using = "//textarea[@aria-label='Type your message here']")
	private WebElement ReplyToDiscussionTopic;

	@FindBy(how = How.XPATH, using = "//span[text()='Post Reply']")
	private WebElement PostReply;

	@FindBy(how = How.XPATH, using = "(//p[@dir='auto'])[2]")
	private WebElement ValidatePostReply;

	@FindBy(how = How.XPATH, using = "//img[@alt='up arrow icon for like the post']")
	private WebElement UpvotedArrow;

	@FindBy(how = How.XPATH, using = "//img[@alt='down arrow icon for unlike post']")
	private WebElement DownvotedArrow;

	@FindBy(how = How.XPATH, using = "//span[text()='1']")
	private WebElement UpvotedCount;

	@FindBy(how = How.XPATH, using = "//span[text()='1']")
	private WebElement DownvotedCount;

	@FindBy(how = How.XPATH, using = "//input[@aria-label='Add a tag and press Enter']")
	private WebElement TagTopic;

	@FindBy(how = How.XPATH, using = "//span[text()='bookmark']")
	private WebElement TagInput;

	@FindBy(how = How.XPATH, using = "//span[text()=' bookmark ']")
	private WebElement UserTagInput;

	@FindBy(how = How.XPATH, using = "//label[text()='No tags Available !']")
	private WebElement NoTagAvailable;

	@FindBy(how = How.XPATH, using = "//div[text()='1 Discussions']")
	private WebElement NoOfDiscussion;

	@FindBy(how = How.XPATH, using = "//div[text()='1 Discussions']")
	private WebElement NoOfPosts;

	@FindBy(how = How.XPATH, using = "//div[@id='delete-topic']")
	private WebElement DeleteTopic;

	@FindBy(how = How.XPATH, using = "//span[@id='bookmark']")
	private WebElement BookmarkThePost;

	@FindBy(how = How.XPATH, using = "//button[text()=' Back ']")
	private WebElement backbutton;

	@FindBy(how = How.XPATH, using = "//img[@id='delete-post']")
	private WebElement DeletePost;

	@FindBy(how = How.XPATH, using = "//div[text()=' Deactivate group ']")
	private WebElement DeactivateGroup;

	@FindBy(how = How.XPATH, using = "//button[text()='Deactivate group']")
	private WebElement ConfirmDeactivateGroup;

	@FindBy(how = How.XPATH, using = "//div[@class='img-container img-container--label']")
	private WebElement ActivateGroupIcon;

	@FindBy(how = How.XPATH, using = "//div[text()='Deactivated']")
	private WebElement DeactivateGroupIcon;

	@FindBy(how = How.XPATH, using = "//h4[text()='Course']")
	private WebElement Course;

	@FindBy(how = How.XPATH, using = "//div[@class='sb--card__info']")
	private WebElement SelectCourse;

	@FindBy(how = How.XPATH, using = "//button[text()=' Activity Dashboard']")
	private WebElement ActivityDashboard;

	@FindBy(how = How.XPATH, using = "//label[@class='last-update-label px-8']")
	private WebElement LastUpdateDateAndTime;

	@FindBy(how = How.XPATH, using = "//span[@class='badge ng-star-inserted']")
	private WebElement MemberCount;

	@FindBy(how = How.XPATH, using = "//div[text()=' Leave group ']")
	private WebElement LeaveGroup;

	@FindBy(how = How.XPATH, using = "//button[text()='Leave group']")
	private WebElement ConfirmLeaveGroup;

	@FindBy(how = How.XPATH, using = "(//span[text()='View activity'])[1]")
	private WebElement ViewActivity;

	@FindBy(how = How.XPATH, using = "//div[@class='certificate-course-content pl-8']")
	private WebElement JoinCourseContent;

	@FindBy(how = How.XPATH, using = "//p[text()='You must join the course to get complete access to content']")
	private WebElement JoinCourseMessage;

	@FindBy(how = How.XPATH, using = "//input[@id='search-for-content-group']")
	private WebElement SearchActivity;

	@FindBy(how = How.XPATH, using = "(//button[text()='Search'])[2]")
	private WebElement SearchActivityButton;

	@FindBy(how = How.XPATH, using = "//h4[text()='Practice question set']")
	private WebElement PractiseQuestionSet;

	@FindBy(how = How.XPATH, using = "//h4[text()='Learning module']")
	private WebElement LearningModule;

	@FindBy(how = How.XPATH, using = "//h4[text()='Explanation Content']")
	private WebElement ExplanationContent;

	@FindBy(how = How.XPATH, using = "//h4[text()='PDF TextBook']")
	private WebElement PDFTextbook;

	@FindBy(how = How.XPATH, using = "//h4[text()='Teaching Resource']")
	private WebElement TeachingResource;

	@FindBy(how = How.XPATH, using = "//div[@class='profile-header-image']")
	private WebElement ProfileIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='profile-label name']")
	private WebElement UserName;

	@FindBy(how = How.XPATH, using = "//h3[@class='discuss-card-title ng-star-inserted']")
	private WebElement PostName;

	@FindBy(how = How.XPATH, using = "//th[contains(text(),'CourseAssessment')]")
	private WebElement CourseAssesmentColumn;

	public WebElement getCourseAssesmentColumn() {
		return CourseAssesmentColumn;
	}

	public WebElement getKababmenu() {
		return kababmenu;
	}

	public WebElement getProfileIcon() {
		return ProfileIcon;
	}

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPostName() {
		return PostName;
	}

	public WebElement getTeachingResource() {
		return TeachingResource;
	}

	public WebElement getPDFTextbook() {
		return PDFTextbook;
	}

	public WebElement getExplanationContent() {
		return ExplanationContent;
	}

	public WebElement getLearningModule() {
		return LearningModule;
	}

	public WebElement getPractiseQuestionSet() {
		return PractiseQuestionSet;
	}

	public WebElement getSearchActivityButton() {
		return SearchActivityButton;
	}

	public WebElement getSearchActivity() {
		return SearchActivity;
	}

	public WebElement getJoinCourseMessage() {
		return JoinCourseMessage;
	}

	public WebElement getJoinCourseContent() {
		return JoinCourseContent;
	}

	public WebElement getViewActivity() {
		return ViewActivity;
	}

	public WebElement getConfirmLeaveGroup() {
		return ConfirmLeaveGroup;
	}

	public WebElement getLeaveGroup() {
		return LeaveGroup;
	}

	public WebElement getMemberCount() {
		return MemberCount;
	}

	public WebElement getLastUpdateDateAndTime() {
		return LastUpdateDateAndTime;
	}

	public WebElement getActivityDashboard() {
		return ActivityDashboard;
	}

	public WebElement getSelectCourse() {
		return SelectCourse;
	}

	public WebElement getCourse() {
		return Course;
	}

	public WebElement getDeactivateGroupIcon() {
		return DeactivateGroupIcon;
	}

	public WebElement getActivateGroupIcon() {
		return ActivateGroupIcon;
	}

	public WebElement getConfirmDeactivateGroup() {
		return ConfirmDeactivateGroup;
	}

	public WebElement getDeletePost() {
		return DeletePost;
	}

	public WebElement getbackbutton() {
		return backbutton;
	}

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Course')]")
	private WebElement courseTabInGroupActivity;

	@FindBy(how = How.XPATH, using = "//*[contains(@placeholder,'Type to search for content')]")
	private WebElement searchBoxContents;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Add Course')]//following::button[contains(text(),'Search')]")
	private WebElement searchButtonInAddActivity;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Add to group')]")
	private WebElement clickAddtoGroup;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'View activity')]")
	private WebElement clickViewActivity;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),' Course modules')]")
	private WebElement validateCourseModules;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Course details')]")
	private WebElement validateCourseDetails;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Batch Details')]")
	private WebElement validateBatchDetails;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Course')]//following::div[contains(@class,'sb--card__')][1]")
	private WebElement contentCard;

	@FindBy(how = How.XPATH, using = "//button[@aria-label='Back']")
	private WebElement backButtonUi;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Activity Dashboard')]")
	private WebElement activityDashBoard;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Name')]")
	private WebElement validateNameColumnInactivityDashboard;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Progress%')]")
	private WebElement validateProgressColumnInactivityDashboard;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Download as CSV')]")
	private WebElement downloadAsCSVButton;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Delete group ')]")
	private WebElement deleteGroup;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'permanently remove the group from the application ?')]")
	private WebElement deleteGroupPopUpInstruction;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'No')]")
	private WebElement noButtonInDeleteGroupPopUp;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Delete')]")
	private WebElement deleteButtonInDeleteGroupPopUp;

	@FindBy(how = How.XPATH, using = "//input[@id='search-within-group']//following::i")
	private WebElement closeIconInMemberSearchBox;

	@FindBy(how = How.XPATH, using = "//input[@id='search-within-group']")
	private WebElement searchWithMember;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Edit group details')]")
	private WebElement editGroupDetailsPage;

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Enter group name')]")
	private WebElement enterGroupName;

	@FindBy(how = How.XPATH, using = "//*[contains(@id,'group-description-input')]")
	private WebElement enterDescription;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Update group')]")
	private WebElement updateGroupButton;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Filter by ')]")
	private WebElement filterByOption;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Select Board')]//..")
	private WebElement clickSelectBoardDropDown;

	@FindBy(how = How.XPATH, using = "//*[contains(@aria-label,'CBSE/NCERT')]//child::mat-pseudo-checkbox")
	private WebElement selectboardValues;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),' Deactivate group ')]")
	private WebElement deactivateGroup;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Deactivating the group removes your access. You cannot add activities or members to the group. You also cannot track member progress. ?')]")
	private WebElement deactivateGroupPopUpInstructionText;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Deactivate group')]")
	private WebElement deactivateGroupPopUpButton;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'This group is temporarily inactive')]")
	private WebElement validateGroupTempInactivemessage;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Admin Group')]")
	private WebElement memberGroupContentCard;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Deactivated')]")
	private WebElement selectMemberGroup;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),' This group is temporarily inactive. The group admin can re-activate the group if required. Group members can continue their discussions on the discussion forum. ')]")
	private WebElement validateGroupMemberTempInactivemessage;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Activate group')]")
	private WebElement reactivateGroup;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'No')]//../button[contains(text(),'Activate group')]")
	private WebElement reactivateGroupPopUp;

	@FindBy(how = How.XPATH, using = "//*[contains(@routerlink,'profile')]//child::i")
	private WebElement clickOnProfile;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Copy')]")
	private WebElement copyUserID;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Leave group')]")
	private WebElement leaveGroupButton;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Leave group')]")
	private WebElement leaveGroupButtonPopUp;

	@FindBy(how = How.XPATH, using = "(//div[contains(@aria-label,'Notifications')])[2]")
	private WebElement notificationsBell;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'has left the')]")
	private WebElement validateNotificationMessage;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'you have been added to GroupName')]")
	private WebElement validateNotificationMessageInMemberSide;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Close')]")
	private WebElement closeButtoninForum;

	@FindBy(how = How.XPATH, using = "//button[contains(@aria-label,'Back')]")
	private WebElement UIbackButton;

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Search within group')]")
	private WebElement searchGroupMember;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'You are just a step away from creating a group')]//..")
	private WebElement validateMemberRemoved;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Dikshamygroupmember')]")
	private WebElement validateGroupMemberSearched;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'status')]//following::div[contains(@class,'menu ml-8')][2]")
	private WebElement removeMemberHamburgermenu;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Remove member')]")
	private WebElement removeMemberFromGroup;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Remove member')]")
	private WebElement removeMemberFromGroupPopUp;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'you have been removed')]")
	private WebElement validateMemberRemovedNotification;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'has been assigned to')]")
	private WebElement validateAssignedAdminNotification;

	@FindBy(how = How.XPATH, using = "//*[contains(@aria-label,'View more actions menu')]")
	private WebElement activityHamburgerMenu;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Remove activity')]")
	private WebElement removeActivity;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Remove')]")
	private WebElement removeActivityPopUp;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'has been unassigned to')]")
	private WebElement validateUnassignedNotification;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'has been deleted by')]")
	private WebElement validateDeletedGroupNotificationMessage;

	@FindBy(how = How.XPATH, using = "//button[@class='close-btn']")
	private WebElement notificationCloseButton;

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Type here (minimum 8 characters)')]")
	private WebElement discussionTopicPlaceholder;

	@FindBy(how = How.XPATH, using = "//textarea[contains(@placeholder,'Type here (minimum 8 characters)')]")
	private WebElement questionIdeaPlaceholder;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Discussion Forum for Groups')]")
	private WebElement clickDiscussionforum;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Start Discussion')]")
	private WebElement clickStartMyDiscussion;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Cancel ')]")
	private WebElement cancelButtonInMydiscussion;

	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	private WebElement tickCheckBox;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Yes')]")
	private WebElement clickYesButton;

	@FindBy(how = How.XPATH, using = "(//div[contains(text(),'Course')]//following::div[contains(@class,'sb--card__')]//..)[1]")
	private WebElement clickContentCardInMemberGroup;

	@FindBy(how = How.XPATH, using = "//button[@aria-label='Back']//following::h5[1]")
	private WebElement recentlyPublishedCourseName;

	@FindBy(how = How.XPATH, using = "//a[text()=' Home ']")
	private WebElement homeTab;

	@FindBy(how = How.XPATH, using = "//div[@role='link']")
	private WebElement clickContentCardRecentlyPublishedCourse;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'DeleteGroup')]")
	private WebElement validateGroupIsSuccessfullyDeleted;

	public WebElement getBookmarkThePost() {
		return BookmarkThePost;
	}

	public WebElement getDeleteTopic() {
		return DeleteTopic;
	}

	public WebElement getNoOfPosts() {
		return NoOfPosts;
	}

	public WebElement getNoOfDiscussion() {
		return NoOfDiscussion;
	}

	public WebElement getNoTagAvailable() {
		return NoTagAvailable;
	}

	public WebElement getUserTagInput() {
		return UserTagInput;
	}

	public WebElement getTagInput() {
		return TagInput;
	}

	public WebElement getTagTopic() {
		return TagTopic;
	}

	public WebElement getDownvotedCount() {
		return DownvotedCount;
	}

	public WebElement getUpvotedCount() {
		return UpvotedCount;
	}

	public WebElement getDownvotedArrow() {
		return DownvotedArrow;
	}

	public WebElement getUpvotedArrow() {
		return UpvotedArrow;
	}

	public WebElement getValidatePostReply() {
		return ValidatePostReply;
	}

	public WebElement getPostReply() {
		return PostReply;
	}

	public WebElement getReplyToDiscussionTopic() {
		return ReplyToDiscussionTopic;
	}

	public WebElement getUpdatedDiscussionTopicName() {
		return UpdatedDiscussionTopicName;
	}

	public WebElement getDiscussionUpdateButton() {
		return DiscussionUpdateButton;
	}

	public WebElement getEditButtonForDiscussionTopic() {
		return EditButtonForDiscussionTopic;
	}

	public WebElement getDiscussionTopicKababMenu() {
		return DiscussionTopicKababMenu;
	}

	public WebElement getDiscussionTopicName() {
		return DiscussionTopicName;
	}

	public WebElement getDiscussionSubmitButton() {
		return DiscussionSubmitButton;
	}

	public WebElement getDiscussionTopicDiscription() {
		return DiscussionTopicDiscription;
	}

	public WebElement getDiscussionTopic() {
		return DiscussionTopic;
	}

	public WebElement getStartDiscussion() {
		return StartDiscussion;
	}

	public WebElement getCreateDiscussionForum() {
		return CreateDiscussionForum;
	}

	public WebElement getConfirmRemoveMember() {
		return ConfirmRemoveMember;
	}

	public WebElement getRemoveMember() {
		return RemoveMember;
	}

	public WebElement getDismissGroupMemberKababMenu() {
		return DismissGroupMemberKababMenu;
	}

	public WebElement getConfirmDismissAsAdmin() {
		return ConfirmDismissAsAdmin;
	}

	public WebElement getDismissAsAdmin() {
		return DismissAsAdmin;
	}

	public WebElement getYesTab() {
		return YesTab;
	}

	public WebElement getSelectCheckbox() {
		return SelectCheckbox;
	}

	public WebElement getConfirmMakeAdmin() {
		return ConfirmMakeAdmin;
	}

	public WebElement getMakeAdmin() {
		return MakeAdmin;
	}

	public WebElement getGroupMemberKababMenu() {
		return GroupMemberKababMenu;
	}

	public WebElement getEditGroupName() {
		return EditGroupName;
	}

	public WebElement getUpdateGroup() {
		return UpdateGroup;
	}

	public WebElement getConfirmDeleteGroup() {
		return ConfirmDeleteGroup;
	}

	public WebElement getEditGroupDetails() {
		return EditGroupDetails;
	}

	public WebElement getConfirmRemoveActivity() {
		return ConfirmRemoveActivity;
	}

	public WebElement getRemoveActivity() {
		return RemoveActivity;
	}

	public WebElement getKababMenuForTextbook() {
		return KababMenuForTextbook;
	}

	public WebElement getDescription() {
		return Description;
	}

	public WebElement getCloseheaderDropdown() {
		return CloseheaderDropdown;
	}

	@FindBy(how = How.XPATH, using = "(//div[contains(text(),'GroupName')])[1]")
	private WebElement groupName;

	public WebElement getDiscussionCloseButton() {
		return DiscussionCloseButton;
	}

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='Discussion Forum for Courses']")
	private WebElement discussionForCourse;

	@FindBy(how = How.XPATH, using = "//h3[text()='This is a Discussion Forum']")
	private WebElement assertDiscussionTopic;

	@FindBy(how = How.XPATH, using = "//span[text()=' discussion ']")
	private WebElement assertDiscussionTag;

	@FindBy(how = How.XPATH, using = "//p[text()='This is Elaborates Discussion Forum']")
	private WebElement assertDiscussionElaborates;

	@FindBy(how = How.XPATH, using = "//button[@title='Forum']")
	private WebElement discussionForumIcon;

	@FindBy(how = How.XPATH, using = "//div[text()=' Deactivate group ']")
	private WebElement clkDeactivateGroup;

	@FindBy(how = How.XPATH, using = "//button[text()='Deactivate group']")
	private WebElement clkDeactivatePopUp;

	@FindBy(how = How.XPATH, using = "//button[text()=' Back ']")
	private WebElement clkBackBtn;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex flex-dc flex-jc-center flex-ai-center text-center']")
	private WebElement assertLoadingPage;

	@FindBy(how = How.XPATH, using = "//textarea[@placeholder='Type here (minimum 10 characters)']")
	private WebElement clkReplyMsg1;

	@FindBy(how = How.XPATH, using = "//button[@id='update-post']")
	private WebElement clkPostReply;

	@FindBy(how = How.XPATH, using = "//button[text()=' Reply ']")
	private WebElement clkReply;

	@FindBy(how = How.XPATH, using = "(//textarea[@placeholder='Type here (minimum 10 characters)'])[2]")
	private WebElement clkReplyMsg2;

	@FindBy(how = How.XPATH, using = "(//button[@id='update-post'])[2]")
	private WebElement clkPostReply2;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'reply(s)')]")
	private WebElement assertRelies;

	@FindBy(how = How.XPATH, using = "//span[text()='Test mentior (You)‎']")
	private WebElement assertGroupAdmin;

	@FindBy(how = How.XPATH, using = "//span[text()='Test mentior (You)‎']//following::span[text()='Contentcreatorprod‎']")
	private WebElement assertMember1;

	@FindBy(how = How.XPATH, using = "//span[text()='Test mentior (You)‎']//following::span[text()='Contentcreatorprod‎']//following::span[text()='Prod user1‎']")
	private WebElement assertMember2;

	@FindBy(how = How.XPATH, using = "//button[text()=' Add activity ']")
	private WebElement addActivity;

	@FindBy(how = How.XPATH, using = "//h4[text()='Course']")
	private WebElement selectCourse;

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Type to search for content. e.g')]")
	private WebElement sendCouresId;

	@FindBy(how = How.XPATH, using = "(//button[text()='Search'])[2]")
	private WebElement searchBtn;

	@FindBy(how = How.XPATH, using = "//div[text()='Course']")
	private WebElement selectCourse1;

	@FindBy(how = How.XPATH, using = "//span[text()='Add to group']")
	private WebElement addCourseToGrp;

	@FindBy(how = How.XPATH, using = "//span[text()='Add to group']")
	private WebElement addCourse;

	@FindBy(how = How.XPATH, using = "//div[text()=' Course ']//following::img[1]")
	private WebElement selectedCourse;

	@FindBy(how = How.XPATH, using = "//button[text()=' Activity Dashboard']")
	private WebElement assertActivityDashBoard;

	@FindBy(how = How.XPATH, using = "//button[@aria-label='showFtuPopup']")
	private WebElement clkGroupIcon;

	@FindBy(how = How.XPATH, using = "//h4[text()='Have you explored the potential of groups yet?']")
	private WebElement assertFTUEPopUp;

	@FindBy(how = How.XPATH, using = "//small[text()='You have to enter the group name']")
	private WebElement NameError;
	
	public WebElement getNameError() {
		return NameError;
	}
	

	public WebElement getDisableOptionPopup() {
		return DisableOptionPopup;
	}

	public WebElement getDisableOption() {
		return DisableOption;
	}

	public WebElement getCategories() {
		return categories;
	}

	public void setCategories(WebElement categories) {
		this.categories = categories;
	}

	public WebElement getTags() {
		return tags;
	}

	public void setTags(WebElement tags) {
		this.tags = tags;
	}

	public WebElement getMyDiscussion() {
		return MyDiscussion;
	}

	public void setMyDiscussion(WebElement myDiscussion) {
		MyDiscussion = myDiscussion;
	}

	public WebElement getRecentposts() {
		return Recentposts;
	}

	public void setRecentposts(WebElement recentposts) {
		Recentposts = recentposts;
	}

	public WebElement getBestposts() {
		return Bestposts;
	}

	public void setBestposts(WebElement bestposts) {
		Bestposts = bestposts;
	}

	public WebElement getSavedposts() {
		return Savedposts;
	}

	public void setSavedposts(WebElement savedposts) {
		Savedposts = savedposts;
	}

	public WebElement getUpvoted() {
		return Upvoted;
	}

	public void setUpvoted(WebElement upvoted) {
		Upvoted = upvoted;
	}

	public WebElement getDownvoted() {
		return Downvoted;
	}

	public void setDownvoted(WebElement downvoted) {
		Downvoted = downvoted;
	}

	public WebElement getForumOption() {
		return ForumOption;
	}

	public WebElement getEnableOption() {
		return EnableOption;
	}

	public WebElement getkababmenu() {
		return kababmenu;
	}

	public WebElement getIdCrossTab() {
		return IdCrossTab;
	}

	public WebElement getOverTheBook() {
		return OverTheBook;
	}

	public WebElement getHeaderDropdown() {
		return headerDropdown;
	}

	public void setHeaderDropdown(WebElement headerDropdown) {
		this.headerDropdown = headerDropdown;
	}

	public WebElement getMyGropus() {
		return MyGropus;
	}

	public void setMyGropus(WebElement myGropus) {
		MyGropus = myGropus;
	}

	public WebElement getBeforeCreateGroupsButton() {
		return BeforeCreateGroupsButton;
	}

	public WebElement getIAgreeCheckbox() {
		return IAgreeCheckbox;
	}

	public void setBeforeCreateGroupsButton(WebElement beforeCreateGroupsButton) {
		BeforeCreateGroupsButton = beforeCreateGroupsButton;
	}

	public WebElement getGroupName() {
		return GroupName;
	}

	public void setGroupName(WebElement groupName) {
		GroupName = groupName;
	}

	public WebElement getAfterCreateGroupsButton() {
		return AfterCreateGroupsButton;
	}

	public void setAfterCreateGroupsButton(WebElement afterCreateGroupsButton) {
		AfterCreateGroupsButton = afterCreateGroupsButton;
	}

	public WebElement getGroupBackButton() {
		return GroupBackButton;
	}

	public WebElement getSelectgroup() {
		return Selectgroup;
	}

	public void setSelectgroup(WebElement selectgroup) {
		Selectgroup = selectgroup;
	}

	public WebElement getAddMember() {
		return AddMember;
	}

	public void setAddMember(WebElement addMember) {
		AddMember = addMember;
	}

	public WebElement getCrossTab() {
		return CrossTab;
	}

	public void setCrossTab(WebElement crossTab) {
		CrossTab = crossTab;
	}

	public WebElement getSearchId() {
		return SearchId;
	}

	public void setSearchId(WebElement searchId) {
		SearchId = searchId;
	}

	public WebElement getVerifyId() {
		return VerifyId;
	}

	public void setVerifyId(WebElement verifyId) {
		VerifyId = verifyId;
	}

	public WebElement getIdSelected() {
		return IdSelected;
	}

	public void setIdSelected(WebElement idSelected) {
		IdSelected = idSelected;
	}

	public WebElement getAddActivity() {
		return AddActivity;
	}

	public void setAddActivity(WebElement addActivity) {
		AddActivity = addActivity;
	}

	public WebElement getDigitalTextbook() {
		return DigitalTextbook;
	}

	public void setDigitalTextbook(WebElement digitalTextbook) {
		DigitalTextbook = digitalTextbook;
	}

	public WebElement getSelectBook() {
		return SelectBook;
	}

	public void setSelectBook(WebElement selectBook) {
		SelectBook = selectBook;
	}

	public WebElement getcourseTabInGroupActivity() {
		return courseTabInGroupActivity;
	}

	public WebElement getSearchBoxContents() {
		return searchBoxContents;
	}

	public WebElement getSearchButtonInAddActivity() {
		return searchButtonInAddActivity;
	}

	public WebElement getClickAddtoGroup() {
		return clickAddtoGroup;
	}

	public WebElement getclickViewActivity() {
		return clickViewActivity;
	}

	public WebElement getValidateCourseModules() {
		return validateCourseModules;
	}

	public WebElement getValidateCourseDetails() {
		return validateCourseDetails;
	}

	public WebElement getValidateBatchDetails() {
		return validateBatchDetails;
	}

	public WebElement getContentCard() {
		return contentCard;
	}

	public WebElement getBackButtonUi() {
		return backButtonUi;
	}

	public WebElement getActivityDashBoard() {
		return activityDashBoard;
	}

	public WebElement getValidateNameColumnInactivityDashboard() {
		return validateNameColumnInactivityDashboard;
	}

	public WebElement getValidateProgressColumnInactivityDashboard() {
		return validateProgressColumnInactivityDashboard;
	}

	public WebElement getDownloadAsCSVButton() {
		return downloadAsCSVButton;
	}

	public WebElement getDeleteGroup() {
		return deleteGroup;
	}

	public WebElement getDeleteGroupPopUpInstruction() {
		return deleteGroupPopUpInstruction;
	}

	public WebElement getNoButtonInDeleteGroupPopUp() {
		return noButtonInDeleteGroupPopUp;
	}

	public WebElement getDeleteButtonInDeleteGroupPopUp() {
		return deleteButtonInDeleteGroupPopUp;
	}

	public WebElement getCloseIconInMemberSearchBox() {
		return closeIconInMemberSearchBox;
	}

	public WebElement getSearchWithMember() {
		return searchWithMember;
	}

	public WebElement getEditGroupDetailsPage() {
		return editGroupDetailsPage;
	}

	public WebElement getEnterGroupName() {
		return enterGroupName;
	}

	public WebElement getEnterDescription() {
		return enterDescription;
	}

	public WebElement getUpdateGroupButton() {
		return updateGroupButton;
	}

	public WebElement getFilterByOption() {
		return filterByOption;
	}

	public WebElement getClickSelectBoardDropDown() {
		return clickSelectBoardDropDown;
	}

	public WebElement getSelectboardValues() {
		return selectboardValues;
	}

	public WebElement getDeactivateGroup() {
		return deactivateGroup;
	}

	public WebElement getValidateDeactivateGroupPopUpInstructionText() {
		return deactivateGroupPopUpInstructionText;
	}

	public WebElement getDeactivateGroupPopUpButton() {
		return deactivateGroupPopUpButton;
	}

	public WebElement getValidateGroupTempInactivemessage() {
		return validateGroupTempInactivemessage;
	}

	public WebElement getSelectMemberGroup() {
		return selectMemberGroup;
	}

	public WebElement getmemberGroupContentCard() {
		return memberGroupContentCard;
	}

	public WebElement getValidateGroupMemberTempInactivemessage() {
		return validateGroupMemberTempInactivemessage;
	}

	public WebElement getReactivateGroup() {
		return reactivateGroup;
	}

	public WebElement getReactivateGroupPopUp() {
		return reactivateGroupPopUp;
	}

	public WebElement getClickOnProfile() {
		return clickOnProfile;
	}

	public WebElement getcopyUserId() {
		return copyUserID;
	}

	public WebElement getleaveGroupButton() {
		return leaveGroupButton;
	}

	public WebElement getleaveGroupButtonPopUp() {
		return leaveGroupButtonPopUp;
	}

	public WebElement getnotificationsBell() {
		return notificationsBell;
	}

	public WebElement getValidateNotificationMessage() {
		return validateNotificationMessage;
	}

	public WebElement getValidateNotificationMessageInMemberSide() {
		return validateNotificationMessageInMemberSide;
	}

	public WebElement getCloseButtoninForum() {
		return closeButtoninForum;
	}

	public WebElement getUIbackButton() {
		return UIbackButton;
	}

	public WebElement getSearchGroupMember() {
		return searchGroupMember;
	}

	public WebElement getvalidateMemberRemoved() {
		return validateMemberRemoved;
	}

	public WebElement getvalidateGroupMemberSearched() {
		return validateGroupMemberSearched;
	}

	public WebElement getRemoveMemberHamburgermenu() {
		return removeMemberHamburgermenu;
	}

	public WebElement getremoveMemberFromGroup() {
		return removeMemberFromGroup;
	}

	public WebElement getremoveMemberFromGroupPopUp() {
		return removeMemberFromGroupPopUp;
	}

	public WebElement getvalidateMemberRemovedNotification() {
		return validateMemberRemovedNotification;
	}

	public WebElement getValidateAssignedAdminNotification() {
		return validateAssignedAdminNotification;
	}

	public WebElement getActivityHamburgerMenu() {
		return activityHamburgerMenu;
	}

	public WebElement getremoveActivity() {
		return removeActivity;
	}

	public WebElement getremoveActivityPopUp() {
		return removeActivityPopUp;
	}

	public WebElement getValidateUnassignedNotification() {
		return validateUnassignedNotification;
	}

	public WebElement getValidateDeletedGroupNotificationMessage() {
		return validateDeletedGroupNotificationMessage;
	}

	public WebElement getValidateNotificationCloseButton() {
		return notificationCloseButton;
	}

	public WebElement getDiscussionTopicPlaceholder() {
		return discussionTopicPlaceholder;
	}

	public WebElement getquestionIdeaPlaceholder() {
		return questionIdeaPlaceholder;
	}

	public WebElement getclickDiscussionforum() {
		return clickDiscussionforum;
	}

	public WebElement getclickStartMyDiscussion() {
		return clickStartMyDiscussion;
	}

	public WebElement getcancelButtonInMydiscussion() {
		return cancelButtonInMydiscussion;
	}

	public WebElement getValidateTickCheckBox() {
		return tickCheckBox;
	}

	public WebElement getValidateClickYesButton() {
		return clickYesButton;
	}

	@FindBy(how = How.XPATH, using = "//div[text()='Auto_Group']")
	private WebElement existingGroup;

	@FindBy(how = How.XPATH, using = "//div[text()='Discussion Forum for Groups']")
	private WebElement DF_ForGroup;

	@FindBy(how = How.XPATH, using = "//button[text()='Start Discussion']")
	private WebElement btnStrartDF;

	@FindBy(how = How.XPATH, using = "//label[text()='Discussion topic*']//following::input[@placeholder='Type here (minimum 8 characters)']")
	private WebElement enterDFTopic;

	@FindBy(how = How.XPATH, using = "//label[text()='Please elaborate your question or idea here*']//following::textarea[@placeholder='Type here (minimum 8 characters)']")
	private WebElement enterElaborateQuestion;

	@FindBy(how = How.XPATH, using = "//label[text()='Tags']//following::input[@placeholder='Add a tag and press Enter']")
	private WebElement enterTag;

	@FindBy(how = How.XPATH, using = "//span[text()='Submit']")
	private WebElement btnSubmit;

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='Discussion Forum for Groups']")
	private WebElement clkCreatedDiscussion;

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='Edit']")
	private WebElement btnEdit;

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='Delete']")
	private WebElement btnDelete;

	@FindBy(how = How.XPATH, using = "//span[text()='Update']")
	private WebElement btnUpdate;

	@FindBy(how = How.XPATH, using = "//div[text()='No Data']")
	private WebElement assertDFDeleted;

	@FindBy(how = How.XPATH, using = "//h3[text()='This is a Discussion Forum Update']")
	private WebElement assertDFUpdated;

	public WebElement getClickContentCardInMemberGroup() {
		return clickContentCardInMemberGroup;
	}

	public WebElement getRecentlyPublishedCourseName() {
		return recentlyPublishedCourseName;
	}

	public WebElement gethomeTab() {
		return homeTab;
	}

	public WebElement getclickContentCardRecentlyPublishedCourse() {
		return clickContentCardRecentlyPublishedCourse;
	}

	public WebElement getValidateGroupIsSuccessfullyDeleted() {
		return validateGroupIsSuccessfullyDeleted;
	}

	public WebElement getValidateGroupName() {
		return groupName;
	}

	public WebElement getExistingGroup() {
		return existingGroup;
	}

	public WebElement getDF_ForGroup() {
		return DF_ForGroup;
	}

	public WebElement getbtnStrartDF() {
		return btnStrartDF;
	}

	public WebElement getenterDFTopic() {
		return enterDFTopic;
	}

	public WebElement getenterElaborateQuestion() {
		return enterElaborateQuestion;
	}

	public WebElement getenterTag() {
		return enterTag;
	}

	public WebElement getbtnSubmit() {
		return btnSubmit;
	}

	public WebElement getclkCreatedDiscussion() {
		return clkCreatedDiscussion;
	}

	public WebElement getbtnEdit() {
		return btnEdit;
	}

	public WebElement getbtnDelete() {
		return btnDelete;
	}

	public WebElement getbtnUpdate() {
		return btnUpdate;
	}

	public WebElement getAssertDFDeleted() {
		return assertDFDeleted;
	}

	public WebElement getAssertDFUpdated() {
		return assertDFUpdated;
	}

	public WebElement getdiscussionForCourse() {
		return discussionForCourse;
	}

	public WebElement getassertDiscussionTopic() {
		return assertDiscussionTopic;
	}

	public WebElement getassertDiscussionTag() {
		return assertDiscussionTag;
	}

	public WebElement getassertDiscussionElaborates() {
		return assertDiscussionElaborates;
	}

	public WebElement getdiscussionForumIcon() {
		return discussionForumIcon;
	}

	public WebElement getclkDeactivateGroup() {
		return clkDeactivateGroup;
	}

	public WebElement getclkDeactivatePopUp() {
		return clkDeactivatePopUp;
	}

	public WebElement getclkBackBtn() {
		return clkBackBtn;
	}

	public WebElement getassertLoadingPage() {
		return assertLoadingPage;
	}

	public WebElement getclkReplyMsg1() {
		return clkReplyMsg1;
	}

	public WebElement getclkPostReply() {
		return clkPostReply;
	}

	public WebElement getclkReply() {
		return clkReply;
	}

	public WebElement getclkReplyMsg2() {
		return clkReplyMsg2;
	}

	public WebElement getclkPostReply2() {
		return clkPostReply2;
	}

	public WebElement getassertRelies() {
		return assertRelies;
	}

	public WebElement getassertGroupAdmin() {
		return assertGroupAdmin;
	}

	public WebElement getassertMember1() {
		return assertMember1;
	}

	public WebElement getassertMember2() {
		return assertMember2;
	}

	public WebElement getaddActivity() {
		return addActivity;
	}

	public WebElement getselectCourse() {
		return selectCourse;
	}

	public WebElement getsendCouresId() {
		return sendCouresId;
	}

	public WebElement getsearchBtn() {
		return searchBtn;
	}

	public WebElement getselectCourse1() {
		return selectCourse1;
	}

	public WebElement getaddCourseToGrp() {
		return addCourseToGrp;
	}

	public WebElement getaddCourse() {
		return addCourse;
	}

	public WebElement getselectedCourse() {
		return selectedCourse;
	}

	public WebElement getassertActivityDashBoard() {
		return assertActivityDashBoard;
	}

	public WebElement getclkGroupIcon() {
		return clkGroupIcon;
	}

	public WebElement getassertFTUEPopUp() {
		return assertFTUEPopUp;
	}
}
