package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory
	@FindBy(xpath="//a[@class]")
	WebElement windows;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Loginbutton;

	@FindBy(xpath="//exl-select-list-modal[@itemlist='TypeaheadSelectListModal.itemlist']")
	WebElement QCGroupSelect;
	
	@FindBy(xpath="//li[1]/button")
	WebElement QCHousing;
	
	@FindBy(xpath="//footer[@class='text-right']/exl-template")
	WebElement Continue;
	
	
	//Initializing the page objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}	
	
	//Actions:
	public boolean validateLoginButton() {
		windows.click();
		return Loginbutton.isDisplayed();
	}

	public void SelectQCGroupAndLogin() {
		
		try {
		QCGroupSelect.click();
		QCHousing.click();
		Continue.click();
		Loginbutton.click();
		Thread.sleep(2000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
//		return new PeopleSearchPage();
	}
	
}
