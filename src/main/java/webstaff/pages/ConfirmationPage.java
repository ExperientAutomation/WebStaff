package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;

public class ConfirmationPage extends TestBase {

	@FindBy(xpath="(//li[@ng-click='groupTabClicked(group)'])[5]")
	WebElement ConfirmationTab;
	
	@FindBy(xpath="//button[@data-tooltip='Confirmation']")
	WebElement Preview_ConfLink;
	
	@FindBy(xpath="(//td/h1)[1]")
	WebElement PreviewTextArea;
	
	
	
	// Initializing the page objects:
	public ConfirmationPage() {
			
			PageFactory.initElements(driver, this);
		}

}
