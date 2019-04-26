package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import webstaff.base.TestBase;

public class PeopleSearchPage extends TestBase{
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SearchButton;
	
	@FindBy(id="regSearch_regID")
	WebElement RegID;
	
	@FindBy(xpath="//h2/button/strong")
	WebElement RegLink;	
	
	//Initializing Page Objects
	public PeopleSearchPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions:	
	public boolean verifySearchPage() {
		
		wait.until(ExpectedConditions.elementToBeClickable(SearchButton));
		return SearchButton.isDisplayed();
	}	
	
}
