package webstaff.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import webstaff.base.TestBase;
import webstaff.util.TestUtil;

public class SummaryPage extends TestBase {
	
	MiscFunctions misc = new MiscFunctions();
	SingleRegInfoPage singleRegInfoPage = new SingleRegInfoPage();
	TestUtil util = new TestUtil();
	
	String lastRegId=null;
	public static String RegID_str =null;
	int regid =0;
	
	// Initializing Page Objects
	public SummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Summary Tab
	@FindBy(xpath="//li[@class='tab-title active']")
	WebElement SummaryTab;
	
	//Add new Person
	@FindBy(xpath="(//button[@data-dropdown-toggle='#ddlAddPerson'])[1]")
	WebElement AddNewPerson;
	
	//Create New
	@FindBy(xpath="//button[@data-ng-click='$ctrl.addPerson()']")
	WebElement CreateNewlink;
	
	//Find & Import
	@FindBy(xpath="//button[@data-ng-click='$ctrl.importPerson()']")
	WebElement FindBooking;
	
	//Booking Mode Reg ID
	@FindBy(xpath="(//tbody[@data-ng-repeat]/tr/td/a)[1]")
	WebElement RegId;
	
	//Added Reg Id
	@FindBy(xpath="(//a[@data-ng-click='::$ctrl.editRegistrant(r.registrant)'])[3]")
	WebElement RegIdTwo;
	
	//Search Reg ID
	@FindBy(id="regSearch_regID")
	WebElement SearchRegID;
	
	//Search Button
	@FindBy(xpath="//button[@data-ng-click='submitButton.clickButtonFn()']")
	WebElement Search_btn;
	
	//Select Button
	@FindBy(xpath="//button[@data-ng-if='$ctrl.regSelected']")
	WebElement Select_btn;
	
	// Yes Continue button
	@FindBy(xpath="//button[contains(.,'Yes, continue')]")
	WebElement Yes_Continue;
	
	//Remove Registrant
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.removeRegistrant($event, r)'])[1]")
	WebElement RemoveReg;
	
	// Select Contact Radio
	@FindBy(xpath="(//span[@data-ng-click='$ctrl.setContact($event, r)'])/i[1]")
	WebElement SelectContact;
	
	// Preview Email Icon
	@FindBy(xpath="(//button[@class='empty icon-button'])[1]")
	WebElement EmailIcon;
	
	// Click on Send Email Button
	@FindBy(xpath="//button[@data-ng-click='modalCtrl.sendConfirmation(modalCtrl)']")
	WebElement SendEmail_But;
	
	//Comments Link
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.editComments()'])[1]")
	WebElement Comments_link;
	
	//Booking Comments
	@FindBy(xpath="(//button[@data-ng-click='SelectListModal.clickme()'])[2]")
	WebElement Comments_Select_Occ_List;
	
	//Select Occupant
	@FindBy(xpath="(//button[@ng-click='SelectList.clickitem(item, $event)'])[2]/i")
	WebElement Comments_Select_Occ_One;
	
	@FindBy(xpath="(//button[@ng-click='SelectList.clickitem(item, $event)'])[3]/i")
	WebElement Comments_Select_Occ_Two;
	
	//Comment Type List
	@FindBy(xpath="(//div[@class='input-group-button'])[4]")
	WebElement Comments_Specific_Type_List;
	
	//Comment Type URGA Window
	@FindBy(xpath="(//button[@ng-click='SelectList.clickitem(item, $event)'])[5]/i")
	WebElement CommentType_URGA;
	
	//Comment Type URGO Window
	@FindBy(xpath="(//button[@ng-click='SelectList.clickitem(item, $event)'])[6]/i")
	WebElement CommentType_URGO;
		
	//Comment text area
	@FindBy(xpath="(//textarea)[1]")
	WebElement Comment_Area;
	
	//Comments History selection
	@FindBy(xpath="(//tbody[@class='highlight']/child::tr/td)[3]")
	WebElement Comment_Type_Text;	
	
	//Comment Save
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.save()'])[1]")
	WebElement Comment_Save;
	
	//Select All Occupants
	@FindBy(xpath="//input[@data-ng-click='$ctrl.checkAllBookingRegistrants($event)']")
	WebElement Comment_Select_All_Occupants;	
	
	// Both URGA and URGO text
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.select(item)']/../following::td)[2]")
	WebElement URGO_text;
	
	@FindBy(xpath="((//button[@data-ng-click='$ctrl.select(item)']/..)[2]/following::td)[2]")
	WebElement URGA_text;
	
	//Group Assignments
	@FindBy(xpath="(//div[@class='input-group-button'])[1]")
	WebElement Group_sel;
	
	//Registrant Group Assignment
	@FindBy(xpath="(//td/button[@data-ng-click='modalCtrl.selectRegistrantGroup(registrantGroup)'])[1]")
	WebElement Group_Reg_Select;
	
	//Exhibitor Company Name
	@FindBy(xpath="//input[@data-ng-model='$ctrl.summary.registrantGroup.groupName']")
	WebElement Exhibitor_Name;
	
	// Remove Exhibitor Link
	@FindBy(xpath="//a[@class='button tiny']")
	WebElement Remove_Exh_Link;
		
	//Actions:
	public String OpenBookingModeSummaryTab() {		
		
		util.mouseover(misc.NewLink);
		misc.NewLink.click();
		misc.NewBooking.click();
		return SummaryTab.getText();
	}

	public boolean NewPersonLink() {
		
		AddNewPerson.click();
		return CreateNewlink.isDisplayed();		
	}
	
	public boolean CreateNewPerson() {
		
		try {
		CreateNewlink.click();
		singleRegInfoPage.Flows_List.findElement(By.xpath("//div[text()='"+prop.getProperty("AttendeeFlow")+"']"));
		misc.Continue_Flow.click();
		singleRegInfoPage.RegisterAndVerifyBalancePopUp();
		misc.Close_Save.click();
		Thread.sleep(2000);		
		misc.lastRegId.getText().length();
		lastRegId =misc.lastRegId.getText().substring(6, 11);			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		return lastRegId.contentEquals(RegId.getText());
	}
	
	public String OpenFindImportWindow() {
		
		AddNewPerson.click();
		FindBooking.click();
		return misc.popuptitletext.getText();				
	}
	
	public boolean SearchExisitingRegId() {
		
		regid = Integer.parseInt(lastRegId);	
		regid= regid-2;	
		RegID_str = Integer.toString(regid);	
		System.out.println("Reg ID-"+RegID_str);
		SearchRegID.sendKeys(RegID_str);
		Search_btn.click();
		wait.until(ExpectedConditions.elementToBeClickable(Select_btn));
		return Select_btn.isDisplayed();
	}
	
	public boolean SelectExistingReg() {
		
		try {
		Select_btn.click();
		Thread.sleep(2000);
		Yes_Continue.click();	
		Thread.sleep(4000);		
		misc.Toaster_Msg_Close.click();	
		Thread.sleep(4000);	
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}		
		return RegID_str.contentEquals(RegId.getText());
	}
	
	public boolean RemoveRegistrant() {
		
		RemoveReg.click();
		misc.PopUpYes.click();
		return misc.ToasterSuccessMsg.getText().contains("has been moved");
	}
	
	public boolean AssignContactPerson() {
		
		try {
		OpenFindImportWindow();
		SearchExisitingRegId();
		SelectExistingReg();
		SelectContact.click();
		misc.PopUpYes.click();
		Thread.sleep(4000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
					
		return SelectContact.getAttribute("data-ng-if").equals("r.isContact"); 
	}
	
	public String ClickEmailIcon() {
				
		EmailIcon.click();
		return misc.popuptitletext.getText();
	}
	
	public String SendEmail() {		
		
		SendEmail_But.click();
		String EmailSentConf = misc.ToasterSuccessMsg.getText();
		misc.X_close.click();
		return EmailSentConf;				
	}
	
	public String Click_Comments() {
		
		Comments_link.click();
		return misc.popuptitletext.getText();
	}
	
	public String SelectCommentType_URGA() {
		
		try {
		Comments_Select_Occ_List.click();
		Thread.sleep(2000);
		Comments_Select_Occ_Two.click();
		misc.Continue.click();
		Comments_Specific_Type_List.click();
		Thread.sleep(2000);
		CommentType_URGA.click();
		misc.Continue.click();
		Comment_Area.sendKeys("Test URGA Auto comments");
		Comment_Save.click();		
		Thread.sleep(2000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		return Comment_Type_Text.getText();		
	}
	
	public String SelectCommentType_URGO() {
		
		try {
		Comments_Select_Occ_List.click();		
		Thread.sleep(2000);		
		Comments_Select_Occ_One.click();
		misc.Continue.click();
		Comments_Specific_Type_List.click();
		Thread.sleep(2000);
		CommentType_URGO.click();
		misc.Continue.click();
		Comment_Area.sendKeys("Test URGO Auto comments");
		Comment_Save.click();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}		
		return Comment_Type_Text.getText();		
	}
	
	public boolean All_Occupants(String URGA_exp, String URGO_exp) throws InterruptedException {
		
		Comment_Select_All_Occupants.click();		
		Thread.sleep(2000);
		String URGA_text_act = URGA_text.getText();
		String URGO_text_act = URGO_text.getText();
		boolean result = false;
		if ((URGA_text_act.contentEquals(URGA_exp)) && (URGO_text_act.contentEquals(URGO_exp)))
			result = true;	
		misc.X_close.click();
		return result;		
	}	
	
}
