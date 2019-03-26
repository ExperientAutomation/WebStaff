package webstaff.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import webstaff.base.TestBase;
import webstaff.pages.ConfirmationPage;
import webstaff.pages.LoginPage;
import webstaff.pages.MiscFunctions;
import webstaff.pages.PendsPage;
import webstaff.pages.PeopleSearchPage;
import webstaff.pages.ShowItemsPage;
import webstaff.pages.SingleRegInfoPage;
import webstaff.pages.TransactionPage;

@Listeners(webstaff.util.WebEventListener.class)
public class WebStaff_TCExecution extends TestBase{
	
	LoginPage loginPage;
	PeopleSearchPage peopleSearchPage;
	SingleRegInfoPage singleRegInfoPage;	
	MiscFunctions misc;
	ShowItemsPage showitem;
	TransactionPage transaction;
	PendsPage pends;
	ConfirmationPage confirmation;
		
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
	public void SingleRegFormVerification() {
		
		row=4;
		Assert.assertTrue(singleRegInfoPage.VerifyNewRegForm(), "Single Reg Form page did not displayed");
	}
	
	@Test(priority=4)
	public void ChangeRegForm() {
		
		row=5;
		Assert.assertTrue(singleRegInfoPage.ChangeFlow(), "The selected Attendee flow did not display");		
	}
	
	@Test(priority=5)
	public void RegisterRecord() {
		
		row=6;
		Assert.assertEquals(singleRegInfoPage.RegisterAndVerifyBalancePopUp(), "Balance/Refund Due Check","Balance popup message did not display");
	}
	
	@Test(priority=6)
	public void LastRegIDTest() {
		
		row=7;
		Assert.assertTrue(singleRegInfoPage.LastRegId() ,"LastReg ID did not display");
	}
	
	@Test(priority=7)
	public void ReOpenRegisteredRecord() {
		
		row=8;
		Assert.assertTrue(singleRegInfoPage.clickOnLastRegId());
	}	
	
	@Test(priority=8)
	public void EnterGuestTest() {
		
		row=9;
		Assert.assertEquals(singleRegInfoPage.ClickOnGuestLink(), "Guests","Guest page did not open");
	}
	
	@Test(priority=9)
	public void EnterGuestAndSave() {
		
		row=10;
		Assert.assertTrue(singleRegInfoPage.EnterGuestNameAndSave());
	}
	
	@Test(priority=10)
	public void VerifyGuestLabel() {
		
		row=11;
		Assert.assertTrue(singleRegInfoPage.CloseGuestModal());
	}
	
	@Test(priority=11)
	public void OpenShowItems() {
		
		row=12;
		Assert.assertEquals(showitem.ClickOnShowItemTab(), "Shop for ShowItems");
	}
	
	@Test(priority=12)
	public void SearchShowItem() {
		
		row=13;
		Assert.assertEquals(showitem.SearchShowItem(), "ESP1 - ESP: Billy Wilder - Sunset Boulevard");
	}
	
	@Test(priority=13)
	public void AddShowItemsToCart() {
		
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
	public void OpenBadgeFields() {
		
		row=17;
		Assert.assertEquals(singleRegInfoPage.ClickBadgeLink(), "Badge Fields");		
	}
	
	@Test(priority=17)
	public void EnterBadgeFields() {
		
		row=18;
		Assert.assertTrue(singleRegInfoPage.EnterBadgeFieldsAndSave());
	}
	
	@Test(priority=18)
	public void OpenSpecailAccModal() {
		
		row=19;
		Assert.assertEquals(singleRegInfoPage.ClickSpecialAcc(), "Special Accommodations");
	}
	
	@Test(priority=19)
	public void EnterSpecialAcc() {
		
		row=20;
		Assert.assertTrue(singleRegInfoPage.EnterSpecailAcc());
	}
	
	@Test(priority=20)
	public void OpenNoteWindow() {
		
		row=21;
		Assert.assertEquals(singleRegInfoPage.ClickNoteLink(), "Special Information");
	}
	
	@Test(priority=21)
	public void EnterSpecailNotes() {
		
		row=22;
		Assert.assertTrue(singleRegInfoPage.EnterNotes());
	}
	
	@Test(priority=22)
	public void OpenMoveToForm() {
		
		row=23;
		Assert.assertEquals(singleRegInfoPage.ClickMoveToForm(), "Move Registrant To Form");
	}
	
	@Test(priority=23)
	public void ChangeFlowToExhibitor() {
		
		row=24;
		Assert.assertEquals(singleRegInfoPage.ChangeForm(), "Find Company");
	}
	
	@Test(priority=24)
	public void UndoChanges() {
		
		row=25;
		Assert.assertEquals(singleRegInfoPage.ClickUndo(), "Member Lookup");
	}
	
	@Test(priority=25)
	public void RuleOverrides() {
		
		row=26;
		Assert.assertEquals(singleRegInfoPage.OpenRuleOverrides(), "Rule Override");
	}
	
	@Test(priority=26)
	public void RuleOverrideSelect() {
		
		row=27;
		Assert.assertTrue(singleRegInfoPage.VerifyRuleOverrideOption());		
	}
	
	@Test(priority=27)
	public void ResetLink() {
		
		row=28;
		Assert.assertEquals(singleRegInfoPage.ClickOnResetLink(), "The password reset message was successfully sent to your email.");
	}
	
	@Test(priority=28)
	public void CancelRecordWindow() {
		
		row=29;
		Assert.assertEquals(singleRegInfoPage.ClickOnCancel(), "Cancellation Options");
	}
	
	@Test(priority=29)
	public void VerifyCancelledText() {
		
		row=30;
		Assert.assertEquals(singleRegInfoPage.VerifyCancelledText(), "CANCELLED");
	}
	
	@Test(priority=30)
	public void UnCancelRecordPopupMsg() {
		
		row=31;
		Assert.assertEquals(singleRegInfoPage.UnCancelRecordPopUpMsg(), "Cancelled Registrant");		
	}
	
	@Test(priority=31)
	public void UnCancelAndSave() {
		
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
	
	
	
	
	
	
	@AfterSuite
	public void tearDown() {
//		driver.get(System.getProperty("user.dir")+ "\\Report\\ReportSummary.html");
//		driver.quit();
	}
	

}
