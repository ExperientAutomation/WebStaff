package webstaff.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import webstaff.base.TestBase;
import webstaff.util.TestUtil;

public class PaymentPage extends TestBase {
	
	MiscFunctions misc  = new MiscFunctions();
	TestUtil util = new TestUtil();

	// Initializing Page Objects
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Payment Tab
	@FindBy(xpath="(//li[@class='tab-title'])[4]")
	WebElement Payment_Tab;
	
	//Select All Housing filter link
	@FindBy(id="btnSelectAllHousing")
	WebElement AllHousingLink;
	
	// Verify Housing Res ID checkbox
	@FindBy(xpath="(//input[@data-ng-click='$ctrl.checkItem($event, item2)'])[1]")
	WebElement Reservation_chkbox;
	
	// Verify Registration Reg ID Checkbox
	@FindBy(xpath="(//input[@data-ng-click='$ctrl.checkItem($event, item2)'])[3]")
	WebElement Reg_chkbox;
	
	//Select All Reg
	@FindBy(id="btnSelectAllReg")
	WebElement AllReg;
	
	//Make Payment Button
	@FindBy(xpath="//button[@data-ng-click='$ctrl.applyPayment()']")
	WebElement MakePayment;
	
	//Add Payment
	@FindBy(xpath="//button[@data-ng-click='modalCtrl.addPayment()']")
	WebElement Add_Payment;
	
	//Summary column Amount due
	@FindBy(id="ctl00_ContentMain_ShoppingCartControl1_LabelTotalDue")
	WebElement AmtDue;
	
	//Select Payor
	@FindBy(name="ctl00$ContentMain$CreditCardControl1$DropDownListPayor")
	WebElement Payor;
	
	//CC Number
	@FindBy(id="ctl00_ContentMain_CreditCardControl1_TextBoxAccountNumber")				
	WebElement CC_Number;
	
	//Exp Date
	@FindBy(id="ctl00_ContentMain_CreditCardControl1_DropDownListYear")
	WebElement Exp_Date;
	
	// Submit Payment
	@FindBy(id="ctl00_ContentMain_ButtonSubmit")
	WebElement Submit_Payment;
	
	//Continue Button
	@FindBy(id="ctl00_ContentMain_HyperLink1")
	WebElement Continue_but;	
	
	// Actions:
	public boolean ClickPaybutton() {
		
		misc.Pay.click();
		return AllHousingLink.isDisplayed();
	}
	
	public boolean SelectHousingLink() throws InterruptedException {
		
		AllHousingLink.click();
//		wait.until(ExpectedConditions.elementToBeClickable(Reservation_chkbox));
		Thread.sleep(2000);			
		return Reservation_chkbox.isSelected();
	}
	
	public boolean ClickMakePayment() {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MakePayment);
		MakePayment.click();
		return misc.popuptitletext.getText().equals("Apply Payment");
	}
	
	public boolean ClickAddPayment() {
		
		Add_Payment.click();
		wait.until(ExpectedConditions.elementToBeClickable(Payor));
		return AmtDue.isDisplayed();
	}
	
	public boolean EnterPaymentDetails() throws InterruptedException {
		
		Thread.sleep(2000);
		util.SelectItem(Payor, "Occupant Edit");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Payor);
		CC_Number.sendKeys("4111111111111111");
		util.SelectItem(Exp_Date, "25");
		Submit_Payment.click();
		wait.until(ExpectedConditions.elementToBeClickable(Continue_but));
		return Continue_but.isDisplayed();
	}
	
	public boolean ClickContinueButton() {
		
		Continue_but.click();
		return MakePayment.isDisplayed();
	}
	
	public boolean SelectRegLink() throws InterruptedException {
		
		AllReg.click();
		Thread.sleep(2000);
		return Reg_chkbox.isSelected();
	}	
}
