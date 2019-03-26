package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;

public class ConfirmationPage extends TestBase {
	
	MiscFunctions misc = new MiscFunctions();

	@FindBy(xpath="(//li[@ng-click='groupTabClicked(group)'])[5]")
	WebElement ConfirmationTab;
	
	@FindBy(xpath="//button[@data-tooltip='Confirmation']")
	WebElement Preview_ConfLink;
	
	@FindBy(xpath="//table[@class='email-wrapper']") 
	WebElement PreviewTextArea;	
		
	// Initializing the page objects:
	public ConfirmationPage() {			
		PageFactory.initElements(driver, this);
	}

	//Actions:
	
	public boolean OpenConfirmationTab() {
		
		ConfirmationTab.click();
		return Preview_ConfLink.isDisplayed();
	}
	
	public boolean OpenConfirmationWindow() {
		
		Preview_ConfLink.click();
		misc.Yes.click();
		misc.Close_Save.click();
		boolean result = PreviewTextArea.isDisplayed();
		misc.X_close.click();
		return result;
	}
}
