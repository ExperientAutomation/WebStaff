package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;

public class MiscFunctions extends TestBase{
	
	//Top menu options:	
	//New Link
	@FindBy(xpath="(//ul[@class='right']/li/a)[1]")
	WebElement NewLink;
	
	//New Person
	@FindBy(xpath="(//a[@data-ng-click='webStaffCtrl.newRegistrant()'])[1]")
	WebElement Newperson;
	
	//Last Reg.ID
	@FindBy(xpath="(//a[@data-ng-click='webStaffCtrl.previousRegistrant()'])[1]")
	WebElement lastRegId;
	
	//Cart Icon
	@FindBy(xpath="//a[@ng-show='WebStaffShoppingCartIcon.currentRegistrant']")
	WebElement CartIcon;	
	
	//Popup header title text
	@FindBy(xpath="//header/h2")
	WebElement popuptitletext;	
	
	// Toaster message
	@FindBy(xpath="//div[@ng-class='config.message']/div")
	WebElement ToasterSuccessMsg;
	
	// Popup message 'Yes' button
	@FindBy(xpath="//button[@class='button success']")
	WebElement Yes;

	// popup message 'Close' button
	@FindBy(xpath="//button[@class='button dark']")
	WebElement Close_Save;
	
	//popup 'X' close
	@FindBy(xpath="//header/button")
	WebElement X_close;
	
	//popup 'Continue' button
	@FindBy(xpath="//button[@class='button small dark']")
	WebElement Continue;	
		
	//Bottom of the page 'Save'
	@FindBy(xpath="//button[@click-button='formCtrl.save()']")
	WebElement Save;
	
	// Bottom of the page 'Payment'
	@FindBy(xpath="//button[@class='success']")
	WebElement Payment;
	
	// Bottom of the page 'Undo'
	@FindBy(xpath="//button[@class='secondary']")
	WebElement Undo;
	
	// Bottom of the page 'Exit'
	@FindBy(xpath="//button[@class='dark']")
	WebElement Exit;
	
	
	
	
	

	// Initializing Page Objects
	public MiscFunctions() {
		PageFactory.initElements(driver, this);
	}

}
