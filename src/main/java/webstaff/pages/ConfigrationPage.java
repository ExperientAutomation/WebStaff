package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;

public class ConfigrationPage extends TestBase {

	// Initializing Page Objects
	public ConfigrationPage() {
		PageFactory.initElements(driver, this);
	}

	// Configuration Search
	@FindBy(xpath = "(//ul[@class='right']/li/a)[4]")
	WebElement Search;
	
	// Global Config page
	@FindBy(xpath="//a[@data-ng-click='webStaffCtrl.configureGlobal()']")
	WebElement Global_config;
	
	//Select Global Config
	@FindBy(xpath="//div[@class='input-group-button']")
	WebElement Global_Config_Select;
	
	//Select Reg Source
	@FindBy(xpath="//i[@class='fa fa-check-square-o fa-check-circle']")
	WebElement Select_RegSource;
	
	// Click Apply
	@FindBy(xpath="(//button[@data-ng-click='submitButton.clickButtonFn()'])[2]")
	WebElement Apply_but;
	
	// WorkStation Config.
	@FindBy(xpath="//a[@data-ng-click='webStaffCtrl.configureWorkstation()']")
	WebElement WorkStation_Config;
	
	// Verify Type Select
	@FindBy(xpath="//i[@class='fa fa-check-circle fa-check-square-o']")
	WebElement Verify_type;
	
	//Printer Name
	@FindBy(id="printerName")
	WebElement Printer_Name;
	
	// Is Onsite Checkbox
	@FindBy(name="isOnsite")
	WebElement IsOnsite_checkbox;
	
	// Sign Out Link
	@FindBy(xpath="//a[@data-ng-click='webStaffCtrl.signOut($event)']")
	WebElement SignOut;
	
	//Logged Out text
	@FindBy(xpath="//h3")
	WebElement Logged_Out_text;
	

}
