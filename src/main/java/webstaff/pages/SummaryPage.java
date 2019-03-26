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
	
	String lastRegId;
	int regid;
	
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
	//@FindBy(xpath="(//tbody[@data-ng-repeat]/tr/td/a)[1]")
//	@FindBy(xpath="//tr[@id='trRegId'"+lastRegId+"']/td/a")
	WebElement RegId;
	
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
	@FindBy(xpath="(//span[@data-ng-click='$ctrl.setContact($event, r)'])[1]")
	WebElement SelectContact;
	
	// Preview Email Icon
	@FindBy(xpath="(//button[@class='empty icon-button'])[1]")
	WebElement EmailIcon;
	
	//Comments Link
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.editComments()'])[1]")
	WebElement Comments_link;
	
	//Booking Comments
	@FindBy(xpath="(//button[@data-ng-click='SelectListModal.clickme()'])[2]")
	WebElement Select_Occ_List;
	
	//Select Occupant
	@FindBy(xpath="(//button[@ng-click='SelectList.clickitem(item, $event)'])[2]/i")
	WebElement Select_Occ;
	
	//Comment Type List
	@FindBy(xpath="(//div[@class='input-group-button'])[4]")
	WebElement Specific_Type_List;
	
	//Comment Type URGA Window
	@FindBy(xpath="(//button[@ng-click='SelectList.clickitem(item, $event)'])[5]/i")
	WebElement CommentType_URGA;
	
	//Comment Type URGO Window
	@FindBy(xpath="(//button[@ng-click='SelectList.clickitem(item, $event)'])[6]/i")
	WebElement CommentType_URGO;
		
	//Comment text area
	@FindBy(xpath="(//textarea)[1]")
	WebElement Comment_Area;
	
	//Comment Save
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.save()'])[1]")
	WebElement Comment_Save;
	
	//Select All Occupants
	@FindBy(xpath="//input[@data-ng-click='$ctrl.checkAllBookingRegistrants($event)']")
	WebElement Select_All_Occupants;
	
	
	
	
	
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
		
		singleRegInfoPage.Flows_List.findElement(By.xpath("//div[text()='"+prop.getProperty("AttendeeFlow")+"']"));
		misc.Continue_Flow.click();
		singleRegInfoPage.RegisterAndVerifyBalancePopUp();
		misc.Close_Save.click();
		lastRegId =misc.lastRegId.getText().substring(6, 11);	
		return lastRegId.contentEquals(RegId.getText());
	}
	
	public String OpenFindImportWindow() {
		
		AddNewPerson.click();
		FindBooking.click();
		return misc.popuptitletext.getText();				
	}
	
	public boolean SearchExisitingRegId() {
		
		regid = Integer.parseInt(lastRegId);
		regid= regid-1;
		String RegID_str = Integer.toString(regid);
		SearchRegID.sendKeys(RegID_str);
		Search_btn.click();
		wait.until(ExpectedConditions.elementToBeClickable(Select_btn));
		return Select_btn.isDisplayed();
	}
	
	public void SelectExistingReg() {
		
		Select_btn.click();
		Yes_Continue.click();		
	}
	
	
	
	
	
	
	
}
