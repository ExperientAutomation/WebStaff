package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;
import webstaff.util.TestUtil;

public class HistoryPage extends TestBase {
	
	TestUtil util = new TestUtil();

	// Initializing Page Objects
	public HistoryPage() {
		PageFactory.initElements(driver, this);
	}

	//History Tab
	@FindBy(xpath="(//li[@class='tab-title'])[5]")
	WebElement History_Tab;
	
	//DropDown List
	@FindBy(xpath="//select[@data-ng-model='$ctrl.selectedView']")
	WebElement DropDownList;
	
	// HTML Confirmation text
	@FindBy(xpath="(//tbody/tr/td)[3]")
	WebElement HTML_text;
	
	// Sort ID Link
	@FindBy(xpath="(//i[@class='fa fa-sort-asc']/following::span)[1]")
	WebElement Sort_ID_text;
	
	//Transaction Item 'Authorized text' validation
	@FindBy(xpath="(//td/label[text()='Payment Status']/following-sibling::text())[1]")
	WebElement Authorized_text;
	
	// Confirmation Report Name
	@FindBy(xpath="(//tbody/tr/td)[3]")
	WebElement Confirm_letter;
	
	//Reservation Header
	@FindBy(xpath="//table[@class='table utility stretch']")
	WebElement Reservation_Head;
	
	//Actions
	public boolean clickHistory() {
		
		History_Tab.click();
		return DropDownList.isDisplayed();
	}
	
	public boolean SelectConfirmation() throws InterruptedException {
		
		util.SelectItem(DropDownList, "string:CONFIRMATION");
		Thread.sleep(2000);
		return HTML_text.getText().equals("HTML Confirmation - Attendee");
	}
	
	public boolean SelectReservation() throws InterruptedException {
		
		util.SelectItem(DropDownList, "string:RESERVATION");
		Thread.sleep(2000);
		return  Sort_ID_text.getText().equals("Reservation ID");
	}
	
	public boolean SelectRegistration() throws InterruptedException {
		
		util.SelectItem(DropDownList, "string:REGISTRANT");
		Thread.sleep(2000);
		return  Sort_ID_text.getText().equals("Registrant ID");
	}
	
	
	
	
		
}
