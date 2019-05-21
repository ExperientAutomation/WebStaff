package webstaff.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;
import webstaff.util.TestUtil;

public class ContactsPage extends TestBase {
	
	MiscFunctions misc = new MiscFunctions();
	SummaryPage summary = new SummaryPage();
	TestUtil util = new TestUtil();

	// Initializing Page Objects
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	// Contact Tab;
	@FindBy(xpath = "(//li[@class='tab-title'])[1]")
	WebElement ContactTab;
	
	// Contact Customer text
	@FindBy(xpath="(//h3)[1]")
	WebElement Contact_text;

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
	
	//Phone
	@FindBy(id = "phone")
	WebElement phone;
	
	// Email
	@FindBy(id = "email")
	WebElement Email;

	// Contact Save
	@FindBy(xpath = "(//button[@data-ng-click='submitButton.clickButtonFn()'])[1]")
	WebElement Contact_Save;
	
	//Actions:
	public boolean ClickContact_tab(String Contact) {	
				
		ContactTab.click();		
		return Contact_text.getText().contains(Contact);
	}
	
	public String New_Contact() throws InterruptedException {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Email);		
		NewContact.click();
		Thread.sleep(2000);
		FirstName.sendKeys("Contact Person");
		LastName.sendKeys("LN");
		address.sendKeys("Test Address");
		zipCode.sendKeys("22222");
		phone.sendKeys("1234567890");
		Email.sendKeys("testcontactperson@test.com");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Email);
		Contact_Save.click();		
		Thread.sleep(2000);
		return misc.ToasterSuccessMsg.getText();
	}
}
