package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;

public class FindRoomPage extends TestBase {

	// Initializing Page Objects
	public FindRoomPage() {
		PageFactory.initElements(driver, this);
	}

	//FindRooms Tab;
	@FindBy(xpath = "(//li[@class='tab-title'])[2]")
	WebElement FindRoomsTab;
	
	//Number of Rooms
	@FindBy(name="numberOfRooms0")
	WebElement NumberOfRooms;
	
	// view Inventory
	@FindBy(xpath="//button[@data-ng-click='$ctrl.viewAll()']")
	WebElement ViewInventory;
	
	// Find Room
	@FindBy(xpath="//button[@data-ng-click='$ctrl.find()']")
	WebElement FindRoom;
	
	//Hold Rooms
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.holdRooms(subBlock, false)'])[1]")
	WebElement HoldRoom;
	
	//Book Rooms
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.holdRooms(subBlock, true)'])[2]")
	WebElement BookRooms;
	
	//Cancellation Policy
	@FindBy(xpath="")
	WebElement Cancellation;
	
	//First Hotel Accordion Expand
	@FindBy(xpath="(//dd[@is-open='reservation.isCurrent'])[1]")
	WebElement Hotel_First_Expand;
	
	
	
	

}
