package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import webstaff.base.TestBase;
import webstaff.util.TestUtil;

public class ConfigurationPage extends TestBase {

	TestUtil util = new TestUtil();
	MiscFunctions misc = new MiscFunctions();

	// Initializing Page Objects
	public ConfigurationPage() {
		PageFactory.initElements(driver, this);
	}

	// Configuration Search
	@FindBy(xpath = "(//ul[@class='right']/li/a)[3]")
	WebElement Config_hover;

	// Global Config. page
	@FindBy(xpath = "//a[@data-ng-click='webStaffCtrl.configureGlobal()']")
	WebElement Global_config;

	// Select Global Config
	@FindBy(xpath = "//div[@class='input-group-button']")
	WebElement Global_Config_Select;

	// Select Reg Source
	@FindBy(xpath = "//div[@class='input-group-button']")
	WebElement Select_RegSource;

	// Title Text
	@FindBy(xpath = "(//h1)[2]")
	WebElement Config_Text;

	// Click Apply
	@FindBy(xpath = "(//button[@data-ng-click='submitButton.clickButtonFn()'])[2]")
	WebElement Apply_but;

	// WorkStation Config.
	@FindBy(xpath = "//a[@data-ng-click='webStaffCtrl.configureWorkstation()']")
	WebElement WorkStation_Config;
	
	// Select Web REg Source
	@FindBy(xpath="(//i[@class='fa fa-circle-thin'])[1]")
	WebElement Select_Web;	
	
	// Verify Type Select
	@FindBy(xpath = "(//i[@class='fa fa-circle-thin'])[1]")
	WebElement Verify_type;

	// Printer Name
	@FindBy(id = "printerName")
	WebElement Printer_Name;

	// Is Onsite Checkbox
	@FindBy(name = "isOnsite")
	WebElement IsOnsite_checkbox;

	// Sign Out Link
	@FindBy(xpath = "//a[@data-ng-click='webStaffCtrl.signOut($event)']")
	WebElement SignOut;

	// Logged Out text
	@FindBy(xpath = "//h3")
	WebElement Logged_Out_text;

	// Actions:
	public boolean ClickGlobalConfig() {

		util.mouseover(Config_hover);
		Global_config.click();
		wait.until(ExpectedConditions.visibilityOf(Config_Text));
		return Config_Text.getText().contains("Configure Global");
	}
	
	public boolean SelectGlobalConfig() {
		
		Select_RegSource.click();
		Select_Web.click();
		misc.Continue.click();	
		Apply_but.click();
		return misc.ToasterSuccessMsg.getText().contains("The configuration settings have successfully been applied.");
	}
	
	public boolean ClickWorkstationConfig() {
		
		util.mouseover(Config_hover);
		WorkStation_Config.click();
		return Config_Text.getText().contains("Configure Workstation");	
	}
	
	public boolean EnterWorkStationDetial() {		
		
		Select_RegSource.click();
		Verify_type.click();
		misc.Continue.click();
		Printer_Name.sendKeys("Onsite Print");
		IsOnsite_checkbox.click();
		Apply_but.click();
		return misc.ToasterSuccessMsg.getText().contains("The configuration settings have successfully been applied.");
	}
	
	public boolean ClickOnLogOut() {
		
		util.mouseover(Config_hover);
		SignOut.click();
		return Logged_Out_text.getText().contains("You are now logged out");
	}
	
}
