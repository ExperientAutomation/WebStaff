package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import webstaff.base.TestBase;
import webstaff.util.TestUtil;

public class PeopleSearchPage extends TestBase{
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SearchButton;
	
	@FindBy(id="regSearch_regID")
	WebElement RegID;
	
	@FindBy(xpath="//h2/button/strong")
	WebElement RegLink;	
	
	@FindBy(xpath="(//button[@data-ng-click='$ctrl.editRegistrant(registrant, $event)'])[2]")
	WebElement RegIDText;
			
	//Initializing Page Objects
	public PeopleSearchPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions:	
	public boolean verifySearchPage() {
		
		wait.until(ExpectedConditions.elementToBeClickable(SearchButton));
		return SearchButton.isDisplayed();
	}	
	
	public boolean EnterRegId(String varRegIDText) {
		
		RegID.sendKeys(varRegIDText);
		SearchButton.click();
		wait.until(ExpectedConditions.visibilityOf(RegIDText));
		System.out.println("New Value-"+RegIDText.getText());
		System.out.println("Values-"+varRegIDText);
		return RegIDText.getText().contains(varRegIDText);
	}
	
}
