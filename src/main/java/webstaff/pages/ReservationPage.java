package webstaff.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import webstaff.base.TestBase;
import webstaff.util.TestUtil;

public class ReservationPage extends TestBase {
	
	MiscFunctions misc = new MiscFunctions();
	TestUtil util = new TestUtil();
	SingleRegInfoPage singleRegInfoPage = new SingleRegInfoPage();
	SummaryPage summary = new SummaryPage();
	
	// Initializing Page Objects
	public ReservationPage() {
		PageFactory.initElements(driver, this);
	}

	// Reservation Tab
	@FindBy(xpath = "(//li[@class='tab-title'])[4]")
	WebElement Reservation_Tab;
	
	//Open first accordion
	@FindBy(xpath="(//div[@class='exl-top-margin-tiny'])[1]")
	WebElement OpenFirstAcc;

	// Add Occupant Button
	@FindBy(xpath = "(//button[@data-ng-click='$ctrl.addEditOccupant(reservation)'])[4]")
	WebElement Add_Occupant;
	
	//Add Another Occupant from Reg List
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.addEditOccupant(reservation)'])[3]")
	WebElement Add_Occ_Two;

	// Room Occupant Form
	@FindBy(id = "firstName")
	WebElement firstname;
	
	@FindBy(id="prefix")
	WebElement prefix;
	
	@FindBy(id="middle")
	WebElement middle;
	
	@FindBy(id="suffix")
	WebElement suffix;
	
	@FindBy(id="nickName")
	WebElement nickname;

	@FindBy(id = "lastName")
	WebElement lastName;
	
	@FindBy(id="title")
	WebElement title;
	
	@FindBy(id="company")
	WebElement company;
	
	@FindBy(id = "address")
	WebElement address;

	@FindBy(id = "zipCode")
	WebElement zipCode;

	@FindBy(id = "phone")
	WebElement phone;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(name = "frequentGuestID")
	WebElement frequentGuestID;

	@FindBy(id = "password")
	WebElement password;

	// Reservation Source
	@FindBy(xpath = "//select[@data-ng-model='$ctrl.reservationOccupant.registrant.regSourceCode']")
	WebElement Reservation_Source;

	// Attendee Type
	@FindBy(xpath = "//select[@data-ng-model='$ctrl.reservationOccupant.regTypeGroupCode']")
	WebElement AttendeeType;

	// Select Registrant
	@FindBy(xpath = "//select[@data-ng-model='$ctrl.selectedRegistrantId']")
	WebElement Select_Reg;

	//Lead Occupant Radio button
	@FindBy(xpath = "//button[@data-ng-if='occupant.isLeadOccupant']")
	WebElement Lead_radio;
	
	// Lead Occupant Reg ID text
	@FindBy(xpath="//button[@data-ng-if='occupant.isLeadOccupant']/../small")
	WebElement Lead_RegID_Text;
	
	//Without Lead Occupant Radio button
	@FindBy(xpath="//button[@data-ng-if='!occupant.isLeadOccupant']")
	WebElement NoLead_Occ_Radio;
	
	// Without Lead Occupant Reg ID text
	@FindBy(xpath="//button[@data-ng-if='!occupant.isLeadOccupant']/../small")
	WebElement NoLead_RegID_Text;	

	// Delete Occupant
	@FindBy(xpath = "//button[@data-ng-click='$ctrl.deleteRoomOccupant(reservation, occupant)']")
	WebElement Delete_Occ;

	// Edit Occupant
	@FindBy(xpath = "(//button[@data-ng-click='$ctrl.addEditOccupant(reservation, occupant)'])[1]")
	WebElement Edit_link;

	// Cancellation Policy
	@FindBy(xpath = "(//button[@data-ng-click='$ctrl.displayCancellationPolicy(reservation)'])[2]")
	WebElement Cancellation_Ply_Link;

	// Change Dates
	@FindBy(xpath = "(//button[@data-exl-room-change-dates='reservation'])[3]")
	WebElement Change_Date;

	// Change Rooms
	@FindBy(xpath = "(//button[@data-ng-click='$ctrl.changeRooms(reservation)'])[2]")
	WebElement Change_Room;

	// Select Change Rooms
	@FindBy(xpath = "//button[@data-ng-click='$ctrl.changeRooms(toReservation)']")
	WebElement Change_Select_Hotel;

	// Change Rates
	@FindBy(xpath = "(//button[@data-ng-click='$ctrl.changeRates(reservation)'])[1]")
	WebElement Change_Rate_Tab;

	// Change Rate plan
	@FindBy(xpath = "(//tr[@data-ng-click='$ctrl.selectRatePlan(ratePlan)'])[1]")
	WebElement Change_Rate_Plan;

	// Release Room
	@FindBy(xpath = "//button[text()='Release Room']")
	WebElement ReleaseRoom;

	// Hotel Conf. #
	@FindBy(xpath = "//button[@data-ng-click='$ctrl.editHotelConfNum(reservation)']")
	WebElement Hotel_conf_Edit;

	// Hotel Conf Number
	@FindBy(name = "hotelConfNum")
	WebElement EnterHotelConfNum;

	// Edit Night
	@FindBy(xpath = "(//button[@data-exl-room-change-dates='reservation'])[2]")
	WebElement NightEdit;

	// Change Rate Edit Icon
	@FindBy(xpath = "(//button[@data-ng-click='$ctrl.changeRates(reservation)'])[2]")
	WebElement RateEditIcon;

	// Change Deposit Amount
	@FindBy(xpath = "(//button[@data-ng-click='$ctrl.editDeposit(reservation)'])")
	WebElement EditDepost;

	// Enter Deposit amt
	@FindBy(xpath = "//input[@type='number']")
	WebElement DepositAmt;
	
	// Deposit Manual edit text
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.editDeposit(reservation)'])[1]")
	WebElement DepositManualtext;

	// Rewards Edit
	@FindBy(xpath = "//button[@data-ng-click='$ctrl.editRewards(reservation, reservation.occupants[0])']")
	WebElement Rewards_Edit;

	// Rewards Input value
	@FindBy(xpath = "//input[@type='text']")
	WebElement Rewards_Input;

	// Special Request
	@FindBy(xpath = "(//button[@data-ng-click='$ctrl.editSpecialRequests(reservation)'])[1]")
	WebElement SpecailRequest_Edit;

	// Specail Request Value
	@FindBy(xpath = "//select[@data-ng-model='$ctrl.specialRequestsObj.beddingTypeCode']")
	WebElement Bedding_Type;

	// Specail Request Comments
	@FindBy(xpath = "//textarea[@data-ng-model='$ctrl.specialRequestsObj.specialRequestComments']")
	WebElement Sp_Comments;
	
	// Edit Billing Comments
	@FindBy(xpath="(//li/label[text()='Billing']/../div/button)[1]")
	WebElement EditBilling;
	
	// Enter Billing Comments
	@FindBy(xpath="//textarea[@data-ng-model='modalCtrl.comments']")
	WebElement EnterBilling;
	
	// Edit Web Comments
	@FindBy(xpath="(//li/label[text()='Web']/../div/button)[1]")
	WebElement EditWeb;	
	
	// Reservation first occupant
	@FindBy(xpath="(//a[@href='javascript:void(0);'])[1]")
	WebElement FirstHotelAcc;
	

	//Actions:
	public boolean ClickAddOccupant() {
		
		Add_Occupant.click();		
		return misc.popuptitletext.getText().contains("Add / Edit Occupant to Reservation");
	}
	
	public boolean EnterLeadOccupant() {
		
		int RND = (int) (Math.random() * 10000);
		
		firstname.sendKeys("Lead Occ"+RND);
		prefix.sendKeys("pre_test");
		middle.sendKeys("middle test");
		lastName.sendKeys("LN"+RND);
		suffix.sendKeys("Test Suffix");
		nickname.sendKeys("Auto test");
		title.sendKeys("Test title");
		company.sendKeys("Test Cmp");
		zipCode.sendKeys("22222");
		phone.sendKeys("9876543210");
		email.sendKeys("testautomationleadocc"+RND+"@test.com");
		frequentGuestID.sendKeys("REW1234");
		password.sendKeys("testtest");			
		util.SelectItem(Reservation_Source, "WEB");
		misc.Yes.click();		
		wait.until(ExpectedConditions.elementToBeClickable(Lead_radio));
		return Lead_radio.getAttribute("data-ng-if").equals("occupant.isLeadOccupant");
	}
	
	public String ClickDeleteOcc() {
		
		try {
		
		Thread.sleep(3000);				
		Delete_Occ.click();
		misc.PopUpYes.click();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		return misc.ToasterSuccessMsg.getText();		
	}
	
	public boolean SelectExistingReg() {
		
		try {
		misc.Toaster_Msg_Close.click();	
		Add_Occ_Two.click();
		System.out.println("RegID to add reservation-"+SummaryPage.RegID_str);
		util.SelectItem(Select_Reg, SummaryPage.RegID_str);			
		Thread.sleep(2000);
		util.SelectItem(Reservation_Source, "WEB");
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		misc.Yes.click();
		return NoLead_Occ_Radio.getAttribute("data-ng-if").equals("!occupant.isLeadOccupant");
	}
	
	public boolean ChangeLeadOccupant() {
		
		String NoLeadRegID = NoLead_RegID_Text.getText();
		try {
		NoLead_Occ_Radio.click();
		Thread.sleep(2000);
		misc.Yes.click();			
		Thread.sleep(2000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		return NoLeadRegID.equals(Lead_RegID_Text.getText());		
	}
	
	public boolean EditOccupant() {
		
		Edit_link.click();
		String FN ="Occupant";
		String LN ="Edit";	
		firstname.clear();
		firstname.sendKeys(FN);
		lastName.clear();
		lastName.sendKeys(LN);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", frequentGuestID);
		singleRegInfoPage.SpcAcc.click();
		singleRegInfoPage.EnterSpecailAcc();
		misc.Yes.click();			
		String FNLN = "\""+FN+" "+(LN)+"\" saved.";	
		return misc.ToasterSuccessMsg.getText().contains(FNLN);		
	}
	
	public String ClickCancellationPolicy() throws InterruptedException {
		
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
		Cancellation_Ply_Link.click();
		Thread.sleep(2000);
		String CancellationTitleText = misc.popuptitletext.getText();
		misc.X_close.click();
		return CancellationTitleText;
	}
	 
	public String ClickChangeDates() {
		
		try {
		Thread.sleep(2000);
		Change_Date.click();
		misc.Save_Changes.click();
		Thread.sleep(2000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		String Changedate = misc.ToasterSuccessMsg.getText();
		misc.Toaster_Msg_Close.click();
		misc.Toaster_Msg_Close.click();
		return Changedate;
	}
	
	public boolean ClickChangeRoom() {
		
		Change_Room.click();
		return Change_Select_Hotel.isDisplayed();		
	}
	
	public String SelectChangeRoom() {
		
		try {
		Change_Select_Hotel.click();	
		Thread.sleep(2000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		return misc.ToasterSuccessMsg.getText();
	}
	
	public String ClickChangeRates() {		
		
		try {
		OpenFirstAcc.click();
		Change_Rate_Tab.click();
		password.sendKeys("galaxy");
		misc.Close_Save.click();
		Thread.sleep(2000);
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return misc.popuptitletext.getText();
	}
	
	public String SelectRatePlan() {	
		
		try {
		misc.Toaster_Msg_Close.click();		
		Thread.sleep(2000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		Change_Rate_Plan.click();
		misc.Save_but.click();	
		return misc.ToasterSuccessMsg.getText();
	}	
	
	public String EnterHotelCONF() {
		
		try {
		misc.Toaster_Msg_Close.click();
		misc.Toaster_Msg_Close.click();
		FirstHotelAcc.click();
		Hotel_conf_Edit.click();
		Thread.sleep(2000);		
		EnterHotelConfNum.sendKeys("CONF12345");
		misc.Yes.click();
		Thread.sleep(1000);		
		} catch (InterruptedException e) {
			  e.printStackTrace();
			}
		return misc.ToasterSuccessMsg.getText();		
	}
	
	public String EnterDeposit() throws InterruptedException {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Change_Rate_Tab);
		EditDepost.click();
		DepositAmt.sendKeys("150");
		misc.Yes.click();
		Thread.sleep(2000);
		return DepositManualtext.getText();		
	}
	
	public boolean SelectSpecailRequest() throws InterruptedException {
		
		SpecailRequest_Edit.click();
		String selectedtext = util.SelectItem(Bedding_Type, "TWO");
		Sp_Comments.sendKeys("Test Request");
		misc.Yes.click();
		Thread.sleep(2000);
		SpecailRequest_Edit.click();		
		return selectedtext.contains("TWO");
	}
	
	public boolean EnterBillingComments() throws InterruptedException {
		
		misc.Cancel.click();
		EditBilling.click();
		String billingcomm = "Test Billing Comments";
		EnterBilling.sendKeys(billingcomm);
		misc.Yes.click();	
		Thread.sleep(2000);	
		return EditBilling.getText().equals(billingcomm);
	}
	
	public boolean EnterWebComments() throws InterruptedException {		
		
		EditWeb.click();
		String webcomm = "Test Web Comments";
		EnterBilling.sendKeys(webcomm);
		misc.Yes.click();
		Thread.sleep(2000);		
		return EditWeb.getText().equals(webcomm);
	}
	
}
