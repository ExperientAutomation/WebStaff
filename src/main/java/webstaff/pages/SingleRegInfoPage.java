package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;
import webstaff.util.TestUtil;

public class SingleRegInfoPage extends TestBase {
	
	String Attendee = prop.getProperty("AttendeeFlow");
	
	TestUtil util = new TestUtil();
	MiscFunctions misc = new MiscFunctions();
		
	@FindBy(xpath="//h2[contains(.,' Reg ID: 0 ')]")
	WebElement NewPersonRegIDText;
	
	@FindBy(xpath="//i[@class='fa fa-fw fa-caret-down']")
	WebElement ChangeForm;
	
	@FindBy(xpath="//button[contains(.,'WebStaff Attendee Flow')]")
	WebElement Attendee_Flow;
	
	@FindBy(xpath="//button[contains(.,'Exhibitor Flow')]")
	WebElement Exhibitor_Flow;
	
	@FindBy(xpath="//button[@ng-click='ExhibitingCompanySearchModal.click()']")
	WebElement exhibitr_Cmp;
	
	@FindBy(xpath="//button[@class='primary']")
	WebElement FlowSelection_Continue;
	
	@FindBy(id="firstName")
	WebElement firstname;
	
	@FindBy(id="lastName")
	WebElement lastname;
	
	@FindBy(id="company")
	WebElement company;
	
	@FindBy(id="address")
	WebElement address;
	
	@FindBy(id="zipCode")
	WebElement zipcode;
	
	@FindBy(id="email")
	WebElement email;

	//Badege Fields
	@FindBy(xpath="//button[@class='button']/i")
	WebElement BadgeFieldsLink;
	
	@FindBy(id="badgeName")
	WebElement badgeName;
	
	@FindBy(id="badgeCompany")
	WebElement badgeCompany;
	
	@FindBy(id="badgeCity")
	WebElement badgeCity;
	
	@FindBy(id="badgeState")
	WebElement badgeState;
	
	@FindBy(id="badgeCountry")
	WebElement badgeCountry;
	
	//Special Accommodations
	@FindBy(xpath="//exl-ada-modal/button")
	WebElement SpcAcc;
	
	@FindBy(xpath="(//p/label)[2]")
	WebElement SpcAcc_ckbox;
	
	@FindBy(xpath="(//p/label)[4]/textarea")
	WebElement spcTextArea;
	
	@FindBy(xpath="(//p/label)[5]/textarea")
	WebElement spcTextHotel;
		
	
	//Demographics
	@FindBy(xpath="//a/exl-static-text[@id-code='WEBSTAFF_FIELDDETAIL_STAGE_LABEL']")
	WebElement StageAccordion;
	
	@FindBy(xpath="(//i[@class='fa fa-circle-thin'])[1]")
	WebElement Demo_Develop;
	
	@FindBy(xpath="//a/exl-static-text[@id-code='WEBSTAFF_FIELDDETAIL_SECJOB_LABEL']")
	WebElement AllJobAccordion;
	
	@FindBy(xpath="(//i[@class='fa fa-square-o'])[2]")
	WebElement Demo_Directing;
	
	//Guest
	@FindBy(xpath="//exl-guest-modal/button")
	WebElement Guest_link;
	
	@FindBy(id="firstName")
	WebElement GuestFristName;
	
	@FindBy(id="lastName")
	WebElement GuestLastName;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement GuestSave;
	
	@FindBy(xpath="//button[@aria-label='Edit']")
	WebElement Guesteditlink;
	
	@FindBy(xpath="(//span[@class='exl-tags']/span)[1]")
	WebElement Guestlabellink;
	
	//Move TO Form
	@FindBy(xpath="//button[@data-ng-click='formCtrl.moveToForm()']")
	WebElement MoveToForm;
	
	//Rule Overrides
	@FindBy(xpath="//button[@data-ng-click='formCtrl.displayRuleOverrides()']")
	WebElement Rule_Over;
	
	//Access Password
	@FindBy(id="password")
	WebElement Password_conf;
	
	// Rule Override list
	@FindBy(xpath="//ul[@class='select-list small-block-grid-1 medium-block-grid-2']/li")
	WebElement Rule_option;
	
	//Reset Link
	@FindBy(xpath="//button[@data-ng-click='formCtrl.emailPasswordResetUrl()']")
	WebElement reset_link;
	
	//Cancel Record
	@FindBy(xpath="//button[@data-ng-click='formCtrl.cancelRegistrant()']")
	WebElement Cancel_Record;
	
	//Cancelled Text
	@FindBy(xpath="//div/span[@class='alert label medium']")
	WebElement Cancelled_Text;
	
	
	//Initializing Page Objects
		public SingleRegInfoPage() {
			PageFactory.initElements(driver, this);
		}
		
		
	//	Actions:
		
	public Boolean VerifyNewRegForm() {
		
		util.mouseover(misc.NewLink);
		misc.Newperson.click();		
		return NewPersonRegIDText.isDisplayed();		
		
	}
		
		

}
