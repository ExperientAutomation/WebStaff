package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;

public class ReservationPage extends TestBase {

	// Initializing Page Objects
	public ReservationPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Reservation Tab
	@FindBy(xpath="(//li[@class='tab-title'])[4]")
	WebElement Reservation_Tab;
	
	// Add Occupant Button
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.addEditOccupant(reservation)'])[2]")
	WebElement Add_Occupant;
	
	//Room Occupant Form
	@FindBy(id="firstName")
	WebElement firstname;
	
	@FindBy(id="lastName")
	WebElement lastName;
	
	@FindBy(id="address")
	WebElement address;
	
	@FindBy(id="zipCode")
	WebElement zipCode;
	
	@FindBy(id="phone")
	WebElement phone;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(name="frequentGuestID")
	WebElement frequentGuestID;
	
	@FindBy(id="password")
	WebElement password;
	
	//Reservation Source
	@FindBy(xpath="//select[@data-ng-model='$ctrl.reservationOccupant.registrant.regSourceCode']")
	WebElement Reservation_Source;
	
	//Attendee Type
	@FindBy(xpath="//select[@data-ng-model='$ctrl.reservationOccupant.regTypeGroupCode']")
	WebElement AttendeeType;
	
	//Select Registrant
	@FindBy(xpath="//select[@data-ng-model='$ctrl.selectedRegistrantId']")
	WebElement Select_Reg;
	
	//Change Lead Occupant
	@FindBy(xpath="ata-ng-if='!occupant.isLeadOccupant']")
	WebElement Lead_radio;
	
	//Delete Occupant
	@FindBy(xpath="//button[@data-ng-click='$ctrl.deleteRoomOccupant(reservation, occupant)']")
	WebElement Delete_Occ;
	
	//Edit Occupant 
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.addEditOccupant(reservation, occupant)'])[1]")
	WebElement Edit_link;
	
	//Cancellation Policy
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.displayCancellationPolicy(reservation)'])[2]")
	WebElement Cancellation_Ply_Link;
	
	//Change Dates
	@FindBy(xpath="(//button[@data-exl-room-change-dates='reservation'])[3]")
	WebElement Change_Date;
	
	//Change Rooms
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.changeRooms(reservation)'])[2]")
	WebElement Change_Room;
	
	// Select Change Rooms
	@FindBy(xpath="//button[@data-ng-click='$ctrl.changeRooms(toReservation)']")
	WebElement Change_Select_Hotel;
	
	//Change Rates
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.changeRates(reservation)'])[1]")
	WebElement Change_Rate_Tab;
	
	//Change Rate plan
	@FindBy(xpath="(//tr[@data-ng-click='$ctrl.selectRatePlan(ratePlan)'])[1]")
	WebElement Change_Rate_Plan;
	
	//Release Room
	@FindBy(xpath="//button[@data-ng-click='v']")
	WebElement ReleaseRoom;
	
	// Hotel Conf. #
	@FindBy(xpath="//button[@data-ng-click='$ctrl.editHotelConfNum(reservation)']")
	WebElement Hotel_conf_Edit;
	
	//Hotel Conf Number
	@FindBy(name="hotelConfNum")
	WebElement EnterHotelConfNum;
		
	//Edit Night
	@FindBy(xpath="(//button[@data-exl-room-change-dates='reservation'])[2]")
	WebElement NightEdit;
	
	// Change Rate Edit Icon
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.changeRates(reservation)'])[2]")
	WebElement RateEditIcon;
	
	// Change Deposit Amount
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.editDeposit(reservation)'])")
	WebElement EditDepost;
	
	// Enter Deposit amt
	@FindBy(xpath="//input[@type='number']")
	WebElement DepositAmt;
	
	//Rewards Edit
	@FindBy(xpath="//button[@data-ng-click='$ctrl.editRewards(reservation, reservation.occupants[0])']")
	WebElement Rewards_Edit;
	
	//Rewards Input value
	@FindBy(xpath="//input[@type='text']")
	WebElement Rewards_Input;
	
	// Special Request
	@FindBy(xpath="//button[@data-ng-click='$ctrl.editSpecialRequests(reservation)']")
	WebElement SpecailRequest_Edit;
	
	//Specail Request Value
	@FindBy(xpath="//select[@data-ng-model='$ctrl.specialRequestsObj.beddingTypeCode']")
	WebElement Bedding_Type;
	
	//Specail Request Comments
	@FindBy(xpath="//textarea[@data-ng-model='$ctrl.specialRequestsObj.specialRequestComments']")
	WebElement Sp_Comments;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
