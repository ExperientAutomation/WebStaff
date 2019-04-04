package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;

public class AttendeeGrpSearchPage extends TestBase {

	// Initializing Page Objects
	public AttendeeGrpSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Attendee Group Search
	@FindBy(xpath="(//a[@data-ng-click='webStaffCtrl.attendeeGroupSearch()'])[1]")
	WebElement Attendee_Grp_Search;
	
	// Attendee Group Name
	@FindBy(id="regGrpSearch_grpName")
	WebElement Grp_Name;
	
	// Expand Details link
	@FindBy(xpath="(//div[@class='small-2 columns'])[1]")
	WebElement Details_link;
	
	
	
	

}
