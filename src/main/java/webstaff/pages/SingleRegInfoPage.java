package webstaff.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import webstaff.base.TestBase;
import webstaff.util.TestUtil;

public class SingleRegInfoPage extends TestBase {

	TestUtil util = new TestUtil();
	MiscFunctions misc = new MiscFunctions();
	
	@FindBy(xpath="(//li[@class='tab-title'])[1]")
	WebElement InfoTab;

	@FindBy(xpath = "(//div/h2)[1]")
	WebElement RegisteredIDText;

	@FindBy(xpath = "//div/h2[contains(.,'Reg ID: 0')]")
	WebElement NewPersonRegIDText;

	@FindBy(xpath = "//a[@data-ng-click='webStaffCtrl.changeRegForm()']")
	WebElement ChangeFlow;

	@FindBy(xpath = "(//div[@class='columns end'])")	
	WebElement Flows_List;	
	
	@FindBy(xpath="//button[@ng-click='MemberSearchModal.click()']")
	WebElement Member_LookUp;

	@FindBy(xpath = "//button[contains(.,'Exhibitor Flow')]")
	WebElement Exhibitor_Flow;
	
	@FindBy(xpath="//button[@ng-click='ExhibitingCompanySearchModal.click()']")
	WebElement Find_Cmp;

	@FindBy(xpath = "//button[@ng-click='ExhibitingCompanySearchModal.click()']")
	WebElement exhibitr_Cmp;

	@FindBy(xpath = "//button[@class='primary']")
	WebElement FlowSelection_Continue;

	@FindBy(id = "firstName")
	WebElement firstname;

	@FindBy(id = "middle")
	WebElement middle;

	@FindBy(id = "lastName")
	WebElement lastname;

	@FindBy(id = "prefix")
	WebElement prefix;

	@FindBy(id = "suffix")
	WebElement suffix;

	@FindBy(id = "company")
	WebElement company;

	@FindBy(id = "address")
	WebElement address;

	@FindBy(id = "zipCode")
	WebElement zipcode;

	@FindBy(id = "phone")
	WebElement phone;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "regType")
	public WebElement RegType;	
	
	// Badege Fields
	@FindBy(xpath = "//button[@ng-click='WizardFormSubGroupModal.click()']")
	WebElement BadgeFieldsLink;

	@FindBy(id = "badgeName")
	WebElement badgeName;

	@FindBy(id = "badgeCompany")
	WebElement badgeCompany;

	@FindBy(id = "badgeCity")
	WebElement badgeCity;

	@FindBy(id = "badgeState")
	WebElement badgeState;

	@FindBy(id = "badgeCountry")
	WebElement badgeCountry;
	
	@FindBy(id="badgeDescription")
	WebElement badgeDesc;

	// Special Accommodations
	@FindBy(xpath = "//exl-ada-modal/button")
	WebElement SpcAcc;

	@FindBy(xpath = "(//p/label/input)[2]")
	WebElement SpcAcc_ckbox;

	@FindBy(xpath = "(//p/label)[4]/textarea")
	WebElement spcTextArea;

	@FindBy(xpath = "(//p/label)[5]/textarea")
	WebElement spcTextHotel;

	//Demographics
	@FindBy(xpath = "//a/exl-static-text[@id-code='WEBSTAFF_FIELDDETAIL_STAGE_LABEL']")
	WebElement StageAccordion;

	@FindBy(xpath = "(//i[@class='fa fa-circle-thin'])[1]")
	WebElement Demo_Develop;

	@FindBy(xpath = "//a/exl-static-text[@id-code='WEBSTAFF_FIELDDETAIL_SECJOB_LABEL']")
	WebElement AllJobAccordion;

	@FindBy(xpath = "(//i[@class='fa fa-square-o'])[2]")
	WebElement Demo_Directing;

	// Guest
	@FindBy(xpath = "//exl-guest-modal/button")
	WebElement Guest_link;

	@FindBy(xpath="(//input[@id='firstName'])[2]")
	WebElement GuestFristName;

	@FindBy(xpath="(//input[@id='lastName'])[2]")
	WebElement GuestLastName;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement GuestSave;

	@FindBy(xpath = "//button[@aria-label='Edit']")
	WebElement GuestEditlink;

	@FindBy(xpath = "(//span[@class='exl-tags']/span)[1]")
	WebElement Guestlabellink;

	// Move TO Form
	@FindBy(xpath = "//button[@data-ng-click='formCtrl.moveToForm()']")
	WebElement MoveToForm;

	// Rule Overrides
	@FindBy(xpath = "//button[@data-ng-click='formCtrl.displayRuleOverrides()']")
	WebElement Rule_OverrideLink;

	// Access Password
	@FindBy(id = "password")
	WebElement Password_conf;

	// Rule Override list
	@FindBy(xpath = "(//ul[@class='select-list small-block-grid-1 medium-block-grid-2']/li/button)[8]")
	WebElement Rule_option;

	// Reset Link
	@FindBy(xpath = "//button[@data-ng-click='formCtrl.emailPasswordResetUrl()']")
	WebElement reset_link;

	// Cancel Record
	@FindBy(xpath = "//button[@data-ng-click='formCtrl.cancelRegistrant()']")
	WebElement Cancel_Record;
	
	//Cancel Button
	@FindBy(xpath="//button[contains(.,'Cancel Registration Items Only')]")
	WebElement Cancel_Reg_but;

	// Cancelled Text
	@FindBy(xpath = "//div/span[@class='alert label medium']")
	WebElement Cancelled_Text;

	// Note link
	@FindBy(xpath = "//button[@data-ng-click='formCtrl.displaySpecialInfo(formCtrl.specialInfoTypes.Note)']")
	WebElement Note_link;

	// Append to Notes area
	@FindBy(xpath = "(//textarea)[2]")
	WebElement Appendtextarea;

	// Saved Append Notes area
	@FindBy(xpath = "(//textarea)[1]")
	WebElement NotesSavedtextarea;

	// Initializing Page Objects
	public SingleRegInfoPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public boolean VerifyNewRegForm() {

		util.mouseover(misc.NewLink);
		misc.Newperson.click();
		return NewPersonRegIDText.isDisplayed();
	}

	public boolean ChangeFlow() {

		try {
			ChangeFlow.click();
			Flows_List.findElement(By.xpath("//div[text()='"+prop.getProperty("AttendeeFlow")+"']")).click();
			misc.Flow_Continue.click();
			Thread.sleep(2000);		
			wait.until(ExpectedConditions.elementToBeClickable(misc.Yes));
			misc.Yes.click(); 
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return RegType.isDisplayed();
	}

	public String RegisterAndVerifyBalancePopUp() {

		int RND = (int) (Math.random() * 10000);

		firstname.sendKeys("Auto" + RND);
		middle.sendKeys("Mr");
		lastname.sendKeys("LN" + RND);
		prefix.sendKeys("Pre_test");
		suffix.sendKeys("Suf_text");
		company.sendKeys("Test Company");
		address.sendKeys("Test Address");
		zipcode.sendKeys("22222");
		phone.sendKeys("9874322109");
		email.sendKeys("automationtestemailtext" + RND + "@test.com");

		// Scroll to Demographics
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView(true);", RegType);
		StageAccordion.click();
		Demo_Develop.click();
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", StageAccordion);
		AllJobAccordion.click();
		Demo_Directing.click();

		misc.Save.click();
		wait.until(ExpectedConditions.elementToBeClickable(misc.Close_Save));
		return misc.popuptitletext.getText();
	}

	public boolean LastRegId() {

		misc.Close_Save.click();
		wait.until(ExpectedConditions.elementToBeClickable(misc.lastRegId));
		return misc.lastRegId.isDisplayed();
	}

	public boolean clickOnLastRegId() {

		try {									
			misc.lastRegId.click();
			Thread.sleep(2000);	
			wait.until(ExpectedConditions.elementToBeClickable(misc.Yes));
			misc.Yes.click();
			Thread.sleep(2000);				
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Last Reg ID-"+misc.lastRegId.getText().substring(6, 10));
		System.out.println("Registered ID-"+RegisteredIDText.getText().substring(8, 12));
		return misc.lastRegId.getText().substring(6, 10)
				.equalsIgnoreCase(RegisteredIDText.getText().substring(8, 12));
		
	}
	
	public String ClickOnGuestLink() {
		
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", StageAccordion); 
		Guest_link.click();
		return misc.popuptitletext.getText();
	}
	
	public boolean EnterGuestNameAndSave() {
		
		GuestFristName.sendKeys("Guest_FN");
		GuestLastName.sendKeys("Guest_LN");
		GuestSave.click();				
		return GuestEditlink.isDisplayed();
	}
	
	public boolean CloseGuestModal() {
		
		misc.Close_Save.click();		
		return Guestlabellink.isDisplayed();		
	}
	
	public String ClickBadgeLink() {
		
		InfoTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(BadgeFieldsLink));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2000)");
		BadgeFieldsLink.click();		
		return misc.popuptitletext.getText();		
	}
	
	public boolean EnterBadgeFieldsAndSave() {
		
		String badgename = "Test Badge Name";
		badgeName.sendKeys(badgename);
		badgeCompany.sendKeys("Test Company");
		badgeCity.sendKeys("Test Badge City");
		badgeState.sendKeys("Texas");
		badgeCountry.sendKeys("US");
		badgeDesc.sendKeys("Test Badge Desc");
		misc.Close_Save.click();
		BadgeFieldsLink.click();
		boolean result = badgeName.getAttribute("value").contains(badgename);
		misc.Close_Save.click();
		return result;
	}
	
	public String ClickSpecialAcc() {		
		
		SpcAcc.click();
		return misc.popuptitletext.getText();
	}
	
	public boolean EnterSpecailAcc() {
		
		SpcAcc_ckbox.click();
		spcTextArea.sendKeys("Test Event Location");
		spcTextHotel.sendKeys("Test Hotel Acc");
		misc.Close_Save.click();
		SpcAcc.click();		
		boolean result = SpcAcc_ckbox.isSelected();
		misc.Close_Save.click();
		return result;
	}

	public String ClickNoteLink() {		
		
		((JavascriptExecutor) driver).executeScript("scroll(0,-250);");
		Note_link.click();
		return misc.popuptitletext.getText();
	}

	public boolean EnterNotes() {
		
		try {
		Appendtextarea.sendKeys("Test Special Info");
		misc.Close.click();
		misc.Save.click();
		Thread.sleep(2000);	
		wait.until(ExpectedConditions.elementToBeClickable(misc.Close_Save));
		misc.Close_Save.click();		
		Thread.sleep(2000);		
		wait.until(ExpectedConditions.visibilityOf(firstname));
		misc.lastRegId.click();
		Thread.sleep(2000);
		misc.Yes.click();	
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Note_link));
		Note_link.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		boolean result = NotesSavedtextarea.isDisplayed();	
		misc.Close.click();		
		return result;	
	}
	
	public String ClickMoveToForm() {		
		
		MoveToForm.click();
		return misc.popuptitletext.getText();
	}
	
	public String ChangeForm() {
		
		Flows_List.findElement(By.xpath("//div[text()='"+prop.getProperty("ExhibitorFlow")+"']")).click();
		misc.Continue_Flow.click();
		misc.Yes.click();
		wait.until(ExpectedConditions.visibilityOf(Find_Cmp));
		return Find_Cmp.getText();
	}
	
	public String ClickUndo() {
		
		misc.Undo.click();
		misc.Yes.click();
		wait.until(ExpectedConditions.visibilityOf(Member_LookUp));
		return Member_LookUp.getText();
	}
	
	public String OpenRuleOverrides() {
		
		try {
		Rule_OverrideLink.click();
		Password_conf.sendKeys("galaxy");
		misc.Close_Save.click();
		  Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return misc.popuptitletext.getText();
	}
	
	public boolean VerifyRuleOverrideOption() {
		
		try {
		Rule_option.click();
		Thread.sleep(2000);	
		misc.X_close.click();		
		Thread.sleep(2000);		
		Rule_OverrideLink.click();
		Password_conf.sendKeys("galaxy");
		misc.Close_Save.click();
		Thread.sleep(2000);
		} 
		catch (InterruptedException e) {			
				e.printStackTrace();
		} 
		boolean result = Rule_option.getAttribute("class").contentEquals("empty selected");	
		misc.X_close.click();
		return result;
	}
	
	public String ClickOnResetLink() {
		
		reset_link.click();
		wait.until(ExpectedConditions.visibilityOf(misc.ToasterSuccessMsg));
		return misc.ToasterSuccessMsg.getText();
	}
	
	public String ClickOnCancel() {
		
		Cancel_Record.click();
		return misc.popuptitletext.getText();
	}
	
	public String VerifyCancelledText() {
		
		Cancel_Reg_but.click();
		wait.until(ExpectedConditions.visibilityOf(Cancelled_Text));
		return Cancelled_Text.getText();
	}
	
	public String UnCancelRecordPopUpMsg() {
		
		try {
		misc.Save.click();		
		Thread.sleep(2000);		
		wait.until(ExpectedConditions.elementToBeClickable(misc.Close_Save));
		misc.Close_Save.click();
		Thread.sleep(2000);
		misc.lastRegId.click();
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		return misc.popuptitletext.getText();		
	}
	
	public boolean UnCancelRecord() {
		
		try {
		misc.PopUpYes.click();		
		Thread.sleep(2000);		
		misc.Save.click();
		Thread.sleep(2000);	
		wait.until(ExpectedConditions.elementToBeClickable(misc.Close_Save));
		misc.Close_Save.click();
		Thread.sleep(2000);	
		misc.lastRegId.click();
		wait.until(ExpectedConditions.visibilityOf(RegType));
		Thread.sleep(2000);	
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		return Cancel_Record.isDisplayed();
	}
	
	
}
