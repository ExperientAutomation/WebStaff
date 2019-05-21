package webstaff.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import webstaff.base.TestBase;
import webstaff.pages.AttendeeGrpSearchPage;
import webstaff.pages.ConfigurationPage;
import webstaff.pages.ConfirmationPage;
import webstaff.pages.ContactsPage;
import webstaff.pages.ExhibitorSearchPage;
import webstaff.pages.FindRoomPage;
import webstaff.pages.HistoryPage;
import webstaff.pages.LoginPage;
import webstaff.pages.MiscFunctions;
import webstaff.pages.PaymentPage;
import webstaff.pages.PendsPage;
import webstaff.pages.PeopleSearchPage;
import webstaff.pages.ReservationPage;
import webstaff.pages.ShowItemsPage;
import webstaff.pages.SingleRegInfoPage;
import webstaff.pages.SummaryPage;
import webstaff.pages.TransactionPage;
import webstaff.util.Email_Send;

@Listeners(webstaff.util.WebEventListener.class)
public class WebStaff_TCExecution extends TestBase{
	
	Email_Send email = new Email_Send();
	LoginPage loginPage;
	PeopleSearchPage peopleSearchPage;
	SingleRegInfoPage singleRegInfoPage;	
	MiscFunctions misc;
	ShowItemsPage showitem;
	TransactionPage transaction;
	PendsPage pends;
	ConfirmationPage confirmation;
	SummaryPage summary;
	ContactsPage contact;
	FindRoomPage FindRoom;
	ReservationPage reserv;
	PaymentPage payment;
	HistoryPage history;
	ExhibitorSearchPage exhibitorsearch;
	AttendeeGrpSearchPage attgrp;
	ConfigurationPage config;
		
	public static int row =0;
	
	public WebStaff_TCExecution() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		
		initialization();
		loginPage = new LoginPage();	
		peopleSearchPage = new PeopleSearchPage();
		singleRegInfoPage = new SingleRegInfoPage();	
		misc = new MiscFunctions();
		showitem = new ShowItemsPage();
		transaction = new TransactionPage();
		pends = new PendsPage();
		confirmation = new ConfirmationPage();
		summary = new SummaryPage();
		contact = new ContactsPage();
		FindRoom = new FindRoomPage();
		reserv = new ReservationPage();
		payment = new PaymentPage();
		history = new HistoryPage();
		exhibitorsearch = new ExhibitorSearchPage();
		attgrp = new AttendeeGrpSearchPage();
		config= new ConfigurationPage();
	}
	
	
	@Test(priority=1)
	public void LoginPageTest() {	
		
		row=2;
		Assert.assertTrue(loginPage.validateLoginButton(), "WebStaff Login page not displayed");		
	}
	
	@Test(priority=2)
	public void QCGroupselectAndLoginPage() {
		
		row=3;
		loginPage.SelectQCGroupAndLogin();
		Assert.assertTrue(peopleSearchPage.verifySearchPage(), "People Search page did not dispalyed");		
	}
	
	@Test(priority=3)
	public void VerifySingleRegForm() {
		
		row=4;
		Assert.assertTrue(singleRegInfoPage.VerifyNewRegForm(), "Single Reg Form page did not displayed");
	}
	
	@Test(priority=4)
	public void VerifyChangeRegForm() {
		
		row=5;
		Assert.assertTrue(singleRegInfoPage.ChangeFlow(), "The selected Attendee flow did not display");		
	}
	
	@Test(priority=5)
	public void VerifyRegisterRecord() {
		
		row=6;
		Assert.assertEquals(singleRegInfoPage.RegisterAndVerifyBalancePopUp(), "Balance/Refund Due Check","Balance popup message did not display");
	}
	
	@Test(priority=6)
	public void VerifyLastRegIDTest() {
		
		row=7;
		Assert.assertTrue(singleRegInfoPage.LastRegId() ,"LastReg ID did not display");
	}
	
	@Test(priority=7)
	public void VerifyReOpenRegisteredRecord() {
		
		row=8;
		Assert.assertTrue(singleRegInfoPage.clickOnLastRegId());
	}	
	
	@Test(priority=8)
	public void EnterGuestTest() {
		
		row=9;
		Assert.assertEquals(singleRegInfoPage.ClickOnGuestLink(), "Guests","Guest page did not open");
	}
	
	@Test(priority=9)
	public void VerifyEnterGuestAndSave() {
		
		row=10;
		Assert.assertTrue(singleRegInfoPage.EnterGuestNameAndSave());
	}
	
	@Test(priority=10)
	public void VerifyGuestLabel() {
		
		row=11;
		Assert.assertTrue(singleRegInfoPage.CloseGuestModal());
	}
	
	@Test(priority=11)
	public void VerifyOpenShowItems() {
		
		row=12;
		Assert.assertEquals(showitem.ClickOnShowItemTab(), "Shop for ShowItems");
	}
	
	@Test(priority=12)
	public void VerifySearchShowItem() {
		
		row=13;
		Assert.assertEquals(showitem.SearchShowItem(), "ESP1 - ESP: Billy Wilder - Sunset Boulevard");
	}
	
	@Test(priority=13)
	public void VerifyAddShowItemsToCart() {
		
		row=14;
		Assert.assertEquals(showitem.AddShowItem(), "ESP1 - ESP: Billy Wilder - Sunset Boulevard added.");		
	}
	
	@Test(priority=14)
	public void VerifyShowItemTab() {
		
		row=15;
		Assert.assertEquals(showitem.VerifyAddedShowItem(), "ESP1 - ESP: Billy Wilder - Sunset Boulevard");
	}
		
	@Test(priority=15)	
	public void VerifyInCart() {
		
		row=16;
		Assert.assertEquals(showitem.CartShowItem(), "ESP1 - ESP: Billy Wilder - Sunset Boulevard");		
	}
	
	@Test(priority=16)
	public void VerifyOpenBadgeFields() {
		
		row=17;
		Assert.assertEquals(singleRegInfoPage.ClickBadgeLink(), "Badge Fields");		
	}
	
	@Test(priority=17)
	public void VerifyEnterBadgeFields() {
		
		row=18;
		Assert.assertTrue(singleRegInfoPage.EnterBadgeFieldsAndSave());
	}
	
	@Test(priority=18)
	public void VerifyOpenSpecailAccModal() {
		
		row=19;
		Assert.assertEquals(singleRegInfoPage.ClickSpecialAcc(), "Special Accommodations");
	}
	
	@Test(priority=19)
	public void VerifyvEnterSpecialAcc() {
		
		row=20;
		Assert.assertTrue(singleRegInfoPage.EnterSpecailAcc());
	}
	
	@Test(priority=20)
	public void VerifyOpenNoteWindow() {
		
		row=21;
		Assert.assertEquals(singleRegInfoPage.ClickNoteLink(), "Special Information");
	}
	
	@Test(priority=21)
	public void VerifyEnterSpecailNotes() {
		
		row=22;
		Assert.assertTrue(singleRegInfoPage.EnterNotes());
	}
	
	@Test(priority=22)
	public void VerifyOpenMoveToForm() {
		
		row=23;
		Assert.assertEquals(singleRegInfoPage.ClickMoveToForm(), "Move Registrant To Form");
	}
	
	@Test(priority=23)
	public void VerifyChangeFlowToExhibitor() {
		
		row=24;
		Assert.assertEquals(singleRegInfoPage.ChangeForm(), "Find Company");
	}
	
	@Test(priority=24)
	public void VerifyUndoChanges() {
		
		row=25;
		Assert.assertEquals(singleRegInfoPage.ClickUndo(), "Member Lookup");
	}
	
	@Test(priority=25)
	public void VerifyRuleOverrides() {
		
		row=26;
		Assert.assertEquals(singleRegInfoPage.OpenRuleOverrides(), "Rule Override");
	}
	
	@Test(priority=26)
	public void RuleOverrideSelect() {
		
		row=27;
		Assert.assertTrue(singleRegInfoPage.VerifyRuleOverrideOption());		
	}
	
	@Test(priority=27)
	public void verifyResetLink() {
		
		row=28;
		Assert.assertEquals(singleRegInfoPage.ClickOnResetLink(), "The password reset message was successfully sent to your email.");
	}
	
	@Test(priority=28)
	public void verifyCancelRecordWindow() {
		
		row=29;
		Assert.assertEquals(singleRegInfoPage.ClickOnCancel(), "Cancellation Options");
	}
	
	@Test(priority=29)
	public void VerifyCancelledText() {
		
		row=30;
		Assert.assertEquals(singleRegInfoPage.VerifyCancelledText(), "CANCELLED");
	}
	
	@Test(priority=30)
	public void VerifyUnCancelRecordPopupMsg() {
		
		row=31;
		Assert.assertEquals(singleRegInfoPage.UnCancelRecordPopUpMsg(), "Cancelled Registrant");		
	}
	
	@Test(priority=31)
	public void VerifyUnCancelAndSave() {
		
		row=32;
		Assert.assertTrue(singleRegInfoPage.UnCancelRecord());		
	}	
	
	@Test(priority=32)
	public void VerifyShowItemTabTest() {
		
		row=33;
		Assert.assertEquals(showitem.VerifyShowItemTab(),"Completed Items");
	}
	
	@Test(priority=33)
	public void VerifyTransactionTab() {
		
		row=34;
		Assert.assertTrue(transaction.ClickOnTransactionPage());		
	}
	
	@Test(priority=34)
	public void OpenPendsTab() {
		
		row=35;
		Assert.assertTrue(pends.clickPendTab());
	}
	
	@Test(priority=35)
	public void SelectPendTypeList() {
		
		row=36;
		Assert.assertTrue(pends.SelectPendTypeList());
	}
	
	@Test(priority=36)
	public void VerifyPendResolved() {
		
		row=37;
		Assert.assertEquals(pends.PendResolved(), "RESOLVED");
	}
	
	@Test(priority=37)
	public void OpenConfirmationTab() {
		
		row=38;
		Assert.assertTrue(confirmation.OpenConfirmationTab());
	}
	
	@Test(priority=38)
	public void VerifyConfirmationPreviewWindow() {
		
		row=39;
		Assert.assertTrue(confirmation.OpenConfirmationWindow());
	}
	
	@Test(priority=39)
	public void BookingMode() {
		
		row=40;
		Assert.assertEquals(summary.OpenBookingModeSummaryTab(), "Summary");
	}
	
	@Test(priority =40)
	public void AddNewPerson() {
		
		row=41;
		Assert.assertTrue(summary.NewPersonLink());
	}
	
	@Test(priority=41)
	public void ClickCreateNewlink() {
		
		row=42;
		Assert.assertTrue(summary.CreateNewPerson());
	}
	
	@Test(priority=42)
	public void AddExistingPerson() {
		
		row=43;
		Assert.assertEquals(summary.OpenFindImportWindow(),"Find & Import Registrant");
	}
	
	@Test(priority=43)
	public void EnterAlreadyRegIdAndSearch() {
		
		row=44;
		Assert.assertTrue(summary.SearchExisitingRegId());
	}
	
	@Test(priority=44)
	public void SelectRegisteredReg() {
		
		row=45;	
		Assert.assertTrue(summary.SelectExistingReg());		
	}
	
	@Test(priority=45)
	public void VerifyRemoveRegistrant() {
		
		row=46;
		Assert.assertTrue(summary.RemoveRegistrant());
	}
			
	@Test(priority=46)
	public void VerifySelectContactPerson() {
		
		row=47;
		Assert.assertTrue(summary.AssignContactPerson());		
	}
	
	@Test(priority=47)
	public void VerifyPreviewConfirmation() {
		
		row=48;
		Assert.assertEquals(summary.ClickEmailIcon(), "Confirmation Preview");
	}
	
	@Test(priority=48)
	public void VerifySendEmail() {
		
		row=49;
		Assert.assertEquals(summary.SendEmail(), "Confirmation letter has been sent.");
	}
	
	@Test(priority=49)
	public void VerifyComments() {
		
		row=50;
		Assert.assertEquals(summary.Click_Comments(), "Booking Comments");
	}
	
	@Test(priority=50)
	public void VerifyCommentTypeURGO() {
		
		row=51;
		Assert.assertEquals(summary.SelectCommentType_URGO(), "URGO");
	}
	
	@Test(priority=51)
	public void VerifyCommentTypeURGA() {
		
		row=52;
		Assert.assertEquals(summary.SelectCommentType_URGA(), "URGA");
	}
	
	@Test(priority=52)
	public void VerifyBothCommentTypeURGOnURGA() throws InterruptedException {
		
		row=53;		
		Assert.assertTrue(summary.All_Occupants("URGA", "URGO"));		
	} 
	
	@Test(priority=53)
	public void VerifyContactTab() {
		
		row=54;
		Assert.assertTrue(contact.ClickContact_tab("Contact Customer"));
	}
	
	@Test(priority=54)
	public void EnterNewContact() throws InterruptedException {
		
		row=55;
		Assert.assertEquals(contact.New_Contact(), "Contact was successfully saved");
	} 
	
	@Test(priority=55)
	public void VerifyFindRoomsTab() {
		
		row=56;
		Assert.assertTrue(FindRoom.ClickFindRoomsTab());
	}
	
	@Test(priority=56)
	public void VerifyViewInventory() {
		
		row=57;
		Assert.assertEquals(FindRoom.ClickOnViewInventory(), "View All Inventory");
	}
	
	@Test(priority=57)
	public void VerifyFindRooms() {
		
		row=58;
		Assert.assertTrue(FindRoom.ClickFindRooms());		
	}
	
	@Test(priority=58)
	public void VerifyHoldRoom() {
		
		row=59;
		Assert.assertEquals(FindRoom.ClickHoldRooms(), "1 room(s) were successfully held");
	}
	
	@Test(priority=59)
	public void VerifyBookRoom() {
		
		row=60;
		Assert.assertTrue(FindRoom.ClickBookRooms());
	}
	
	@Test(priority=60)
	public void VerifyAddOccupant() {
		
		row=61;
		Assert.assertTrue(reserv.ClickAddOccupant());
	}
	
	@Test(priority=61)
	public void EnterLeadOccdetails() {
		
		row=62;
		Assert.assertTrue(reserv.EnterLeadOccupant());
	}
	
	@Test(priority=62)
	public void VerifyDeleteOcc() {
		
		row=63;
		Assert.assertEquals(reserv.ClickDeleteOcc(), "Cannot delete this lead occupant. There are no other occupants in this reservation to assume the lead role.");		
	}
	
	@Test(priority=63)
	public void VerifyExistingOcc() {
		
		row=64;
		Assert.assertTrue(reserv.SelectExistingReg());			
	}

	@Test(priority=64)
	public void VerifyChangeLead() {
		
		row=65;
		Assert.assertTrue(reserv.ChangeLeadOccupant());
	}
	
	@Test(priority=65)
	public void VerifyEditOccupant() {
		
		row=66;
		Assert.assertTrue(reserv.EditOccupant());		
	}
	
	@Test(priority=66)
	public void VerifyCancellationPolicy() throws InterruptedException {
		
		row=67;		
		Assert.assertEquals(reserv.ClickCancellationPolicy(), "Cancellation Policy");
	}
	
	@Test(priority=67)
	public void VerifyChangeDates() {
		
		row=68;
		Assert.assertEquals(reserv.ClickChangeDates(), "Reservation dates were not changed.");		
	}
	
	@Test(priority=68)
	public void VerifyChangeRoomspopup() {
		
		row=69;
		Assert.assertTrue(reserv.ClickChangeRoom());
	}
	
	@Test(priority=69)
	public void VerifyChangeRoom() {
		
		row=70;
		Assert.assertEquals(reserv.SelectChangeRoom(),"Reservation successfully changed.");
	}
	
	@Test(priority=70)
	public void VerifyChangeRatesPopup() {
		
		row=71;
		Assert.assertEquals(reserv.ClickChangeRates(), "Change Room Rates");
	}
	
	@Test(priority=71)
	public void VerifyChangeRate() {
		
		row=72;
		Assert.assertEquals(reserv.SelectRatePlan(), "Reservation rates were successfully changed.");		
	}
 
	@Test(priority=72)
	public void VerifyReleaseRoom() {
		
		row=73;
		Assert.assertEquals(FindRoom.ClickReleaseRoom(), "Room has been sucessfully released.");
	}
	
	@Test(priority=73)
	public void VerifyHotelCONF() {
		
		row=74;
		Assert.assertEquals(reserv.EnterHotelCONF(), "Hotel Confirmation Number: successfully updated.");
	}
	
	@Test(priority=74)
	public void VerifyDeposit() throws InterruptedException {
		
		row=75;
		Assert.assertEquals(reserv.EnterDeposit(),"MANUAL $150.00");		
	}
	
	@Test(priority=75)
	public void VerifySpecialRequest() throws InterruptedException {
		
		row=76;
		Assert.assertTrue(reserv.SelectSpecailRequest());
	}
	
	@Test(priority=76)
	public void verifyBillingComments() throws InterruptedException {
		
		row=77;
		Assert.assertTrue(reserv.EnterBillingComments());
	}
	
	@Test(priority=77)
	public void verifyWebComments() throws InterruptedException {
		
		row=78;
		Assert.assertTrue(reserv.EnterWebComments());
	}
	
	@Test(priority=78)
	public void verifyPaymentTab() throws InterruptedException {
				
		row=79;
		Assert.assertTrue(payment.ClickPaybutton());
	}
	
	@Test(priority=79)
	public void verifyAllHousing() throws InterruptedException {
		
		row=80;
		Assert.assertTrue(payment.SelectHousingLink());
	}
	
	@Test(priority=80)
	public void verifyMakePayment() {
		
		
		row=81;
		Assert.assertTrue(payment.ClickMakePayment());
	}
	
	@Test(priority=81)
	public void verifyAddPayment() {
		
		row=82;		
		Assert.assertTrue(payment.ClickAddPayment());				
	}
	
	@Test(priority=82)
	public void verifyEnterPaymentDetails() throws InterruptedException {		
		
		row=83;
		Assert.assertTrue(payment.EnterPaymentDetails());
	}
	
	@Test(priority=83)
	public void verifyContinueButt() {
		
		row=84;
		Assert.assertTrue(payment.ClickContinueButton());
	}
	
	@Test(priority=84)
	public void verifySelectRegLink() throws InterruptedException {
		
		row=85;
		Assert.assertTrue(payment.SelectRegLink());		
	}
	
	@Test(priority=85)
	public void verifyRegAddPayment() throws InterruptedException {
		
		row=86;
		payment.ClickMakePayment();
		Assert.assertTrue(payment.ClickAddPayment());							
	}
	
	@Test(priority=86)
	public void verifyRegPaymentdetails() throws InterruptedException {
		
		row=87;
		payment.EnterPaymentDetails();
		Assert.assertTrue(payment.ClickContinueButton());
	} 
	
	@Test(priority=87)
	public void verifyHistoryTab() throws InterruptedException {		
	
		row=88;
		Assert.assertTrue(history.clickHistory());
	}
	
	@Test(priority=88)
	public void verifyConfirmation() throws InterruptedException {
		
		row=89;
		Assert.assertTrue(history.SelectConfirmation());
	}
	
	@Test(priority=89)
	public void verifyReservation() throws InterruptedException {
		
		row=90;
		Assert.assertTrue(history.SelectReservation());
	}
	
	@Test(priority=90)
	public void verifyRegistrant() throws InterruptedException {
		
		row=91;
		Assert.assertTrue(history.SelectRegistration());
	}
	
	@Test(priority=91)
	public void verifyGroupAssignment() throws InterruptedException {		
		
		row=92;
		Assert.assertEquals(summary.clickonGroupAssignment(), "Registrant Group Assignment");
	}
	
	@Test(priority=92)
	public void VerifySearchandSelectRegGrp() {
		
		row=93;
		Assert.assertTrue(summary.SearchExhibitorGroup());
	}
	
	@Test(priority=93)
	public void verifyRemoveRegGrp() throws InterruptedException {
		
		row=94;
		Assert.assertFalse(summary.ClickRemoveExhibitor());
	}
	
	@Test(priority=94)
	public void verifyExitAndConfirmationWindow() throws InterruptedException {
		
		row=95;
		Assert.assertTrue(summary.ClickExit());
	}
	
	@Test(priority=95)
	public void verifySearchReturn() {
		
		row=96;
		Assert.assertTrue(summary.ClickContinueButton());
	}
	
	@Test(priority=96)
	public void verifySearchPage() {	
		
		row=97;
		Assert.assertTrue(peopleSearchPage.EnterRegId(SummaryPage.RegID_str));	
	}
	
	@Test(priority=97)
	public void verifyExhibitorSearch() {
		
		row=98;
		Assert.assertTrue(exhibitorsearch.ExhibitorSearch());
	}
	
	@Test(priority=98)
	public void verifyEnterExhibitorSearch() {
		
		row=99;
		Assert.assertTrue(exhibitorsearch.EnterExhibitorSearch());
	} 
	
	@Test(priority=99)
	public void verifyAttendeeSearch() {				
		
		row=100;
		Assert.assertTrue(attgrp.AttendeeSearch());
	}
	
	@Test(priority=100)
	public void verifyEnterAttendeeGrp() {
		
		row=101;
		Assert.assertTrue(attgrp.EnterAttendeeGrp());
	}
	
	@Test(priority=101)
	public void verifyGlobalConfigpage() {	
		
		row=102;
		Assert.assertTrue(config.ClickGlobalConfig());
	}
	
	@Test(priority=102)
	public void verifyGlobalSettings() {
		
		row=103;
		Assert.assertTrue(config.SelectGlobalConfig());		
	}
	
	@Test(priority=103)
	public void verifyWorkstationPage() {		
				
		row=104;
		Assert.assertTrue(config.ClickWorkstationConfig());
	}
	
	@Test(priority=104)
	public void verifyWorkstation() {
		
		row=105;
		Assert.assertTrue(config.EnterWorkStationDetial());
	}	
	
	@Test(priority=105)
	public void verifyLogOut() {
		
		row=106;
		Assert.assertTrue(config.ClickOnLogOut());
	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException {
		
//		driver.get(System.getProperty("user.dir")+ "\\Report\\ReportSummary.html");
//		driver.quit();		
	}
	

}
