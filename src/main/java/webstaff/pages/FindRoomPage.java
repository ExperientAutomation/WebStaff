package webstaff.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;
import webstaff.util.TestUtil;

public class FindRoomPage extends TestBase {
	
	MiscFunctions misc = new MiscFunctions();
	ReservationPage reserv = new ReservationPage();
	TestUtil util = new TestUtil();
	SummaryPage summary = new SummaryPage();
	
	
	// Initializing Page Objects
	public FindRoomPage() {
		PageFactory.initElements(driver, this);
	}

	//FindRooms Tab;
	@FindBy(xpath = "//li/a[text()='Find Rooms']")
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
	
	// Find Rooms Search Result
	@FindBy(xpath="//h3")
	WebElement FindRoomSearchReuslt;
	
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
	
	//Actions:
	public boolean ClickFindRoomsTab () {
		
		FindRoomsTab.click();
		return  NumberOfRooms.isDisplayed();
	}
	
	public String ClickOnViewInventory() {
		
		try {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");	     		
		ViewInventory.click();		
		Thread.sleep(3000);		
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		String ViewInventory = misc.popuptitletext.getText();
		misc.X_close.click();
		return ViewInventory;
	}
	
	public boolean ClickFindRooms() {
		
		FindRoom.click();
		return FindRoomSearchReuslt.getText().contains("Search Results");
	}
	
	public String ClickHoldRooms() {
		
		HoldRoom.click();
		return misc.ToasterSuccessMsg.getText();				
	}
	
	public boolean ClickBookRooms() {
		
		BookRooms.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reserv.Add_Occupant);
		return reserv.Add_Occupant.isDisplayed();
	}
	
	public String ClickReleaseRoom() {		
		
		try {
		misc.Toaster_Msg_Close.click();
		FindRoomsTab.click();
		BookRooms.click();			
		Thread.sleep(1000);		
		misc.Toaster_Msg_Close.click();		
		Thread.sleep(1000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		reserv.ReleaseRoom.click();
		return misc.ToasterSuccessMsg.getText();		
	}

}
