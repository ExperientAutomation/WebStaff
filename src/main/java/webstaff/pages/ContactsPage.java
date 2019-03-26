package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;

public class ContactsPage extends TestBase {

	// Initializing Page Objects
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	// Contact Tab;
	@FindBy(xpath = "(//li[@class='tab-title'])[1]")
	WebElement ContactTab;

	// New Contact
	@FindBy(xpath = "(//button[@data-ng-click='submitButton.clickButtonFn()'])[3]")
	WebElement NewContact;

	// FirstName
	@FindBy(id = "firstName")
	WebElement FirstName;

	// LastName
	@FindBy(id = "lastName")
	WebElement LastName;

	// Address
	@FindBy(id = "address")
	WebElement address;

	// Zip Code
	@FindBy(id = "zipCode")
	WebElement zipCode;

	// Email
	@FindBy(id = "email")
	WebElement Email;

	// Contact Save
	@FindBy(xpath = "(//button[@data-ng-click='submitButton.clickButtonFn()'])[1]")
	WebElement Contact_Save;

}
