package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;

public class MiscFunctions extends TestBase {

	// Initializing Page Objects
	public MiscFunctions() {
		PageFactory.initElements(driver, this);
	}

	// Top menu options:
	// New Link
	@FindBy(xpath = "(//ul[@class='right']/li/a)[1]")
	WebElement NewLink;

	// Search
	@FindBy(xpath = "(//ul[@class='right']/li/a)[2]")
	WebElement Search;

	// New Person
	@FindBy(xpath = "(//a[@data-ng-click='webStaffCtrl.newRegistrant()'])[1]")
	WebElement Newperson;

	// New Booking
	@FindBy(xpath = "(//a[@data-ng-click='webStaffCtrl.newBooking()'])[1]")
	WebElement NewBooking;
	
	// Exhibitor Search
	@FindBy(xpath="//a[@data-ng-click='webStaffCtrl.exhibitingCompanySearch()']")
	WebElement ExhibitorSearch;
	
	// Attendee Group
	@FindBy(xpath="//a[@data-ng-click='webStaffCtrl.attendeeGroupSearch()']")
	WebElement AttendeeGrpSearch;
	
	// Last Reg.ID
	@FindBy(xpath = "(//a[@data-ng-click='webStaffCtrl.previousRegistrant()'])[1]")
	public WebElement lastRegId;

	// Cart Icon
	@FindBy(xpath = "//a[@ng-show='WebStaffShoppingCartIcon.currentRegistrant']")
	WebElement CartIcon;

	// Popup header title text
	@FindBy(xpath = "//header/h2")
	WebElement popuptitletext;

	// Toaster message
	@FindBy(xpath = "//div[@ng-class='config.message']/div")
	WebElement ToasterSuccessMsg;

	// Toaster Message Close
	@FindBy(xpath = "//button[@class='toast-close-button']")
	WebElement Toaster_Msg_Close;

	// Popup message 'Yes' button
	@FindBy(xpath = "//button[@class='button success']")
	WebElement Yes;

	@FindBy(xpath = "//button[contains(.,'Yes')]")
	WebElement PopUpYes;

	// popup message 'Close' button
	@FindBy(xpath = "//button[@class='button dark']")
	WebElement Close_Save;

	// Change dates 'Save Changes'
	@FindBy(xpath = "//button[contains(.,'Save Changes')]")
	WebElement Save_Changes;

	// popup 'X' close
	@FindBy(xpath = "//header/button")
	WebElement X_close;

	// ShowItemModalWindow close
	@FindBy(xpath = "//button[contains(.,'Close')]")
	WebElement Close;

	// popup 'Continue' button
	@FindBy(xpath = "//button[@class='button small dark']")
	WebElement Continue;

	// Move To Form Continue button
	@FindBy(xpath = "//button[contains(.,'Continue')]")
	WebElement Continue_Flow;

	// Bottom of the page 'Save'
	@FindBy(xpath = "//button[@click-button='formCtrl.save()']")
	WebElement Save;

	// Change Date Save Button
	@FindBy(xpath = "//button[contains(.,'Save')]")
	WebElement Save_but;

	// Bottom of the page 'Payment'
	@FindBy(xpath = "//button[@class='success']")
	WebElement Payment;

	// Bottom of the page 'Undo'
	@FindBy(xpath = "//button[@class='secondary']")
	WebElement Undo;

	// Continue button
	@FindBy(xpath = "//button[@class='primary']")
	WebElement Flow_Continue;

	// Bottom of the page'Exit'
	@FindBy(xpath = "//button[@class='dark']")
	WebElement Exit;

	// Bottom Pay button
	@FindBy(xpath = "//button[@data-ng-click='formCtrl.displayPaymentControl()']")
	public	WebElement Pay;

	// Cancel popup window button
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement Cancel;

}
