package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;

public class PaymentPage extends TestBase {

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
	
	//Select All Reg
	@FindBy(id="btnSelectAllReg")
	WebElement AllReg;
	
	//Make Payment Button
	@FindBy(xpath="//button[@data-ng-click='$ctrl.applyPayment()']")
	WebElement MakePayment;
	
	//Add Payment
	@FindBy(xpath="//button[@data-ng-click='modalCtrl.addPayment()']")
	WebElement Add_Payment;
	
	//Select Payor
	@FindBy(name="ctl00$ContentMain$CreditCardControl1$DropDownListPayor")
	WebElement Payor;
	
	//CC Number
	@FindBy(id="ctl00_ContentMain_CreditCardControl1_RequiredFieldValidatorCreditCardNumber")
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
	
	
	
	
	
}
