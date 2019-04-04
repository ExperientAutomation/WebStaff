package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;

public class HistoryPage extends TestBase {

	// Initializing Page Objects
	public HistoryPage() {
		PageFactory.initElements(driver, this);
	}

	//History Tab
	@FindBy(xpath="(//li[@class='tab-title'])[5]")
	WebElement Payment_Tab;
	
	//DropDown List
	@FindBy(xpath="//select[@data-ng-model='$ctrl.selectedView']")
	WebElement DropDownList;
	
	//Transaction Item 'Authorized text' validation
	@FindBy(xpath="(//td/label[text()='Payment Status']/following-sibling::text())[1]")
	WebElement Authorized_text;
	
	// Confirmation Report Name
	@FindBy(xpath="(//tbody/tr/td)[3]")
	WebElement Confirm_letter;
	
	//Reservation Header
	@FindBy(xpath="//table[@class='table utility stretch']")
	WebElement Reservation_Head;
	
	
	
	
	
	
	
	
	
	
		
}
