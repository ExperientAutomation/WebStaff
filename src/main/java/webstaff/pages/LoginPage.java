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

	@FindBy(xpath="//button[contains(.,'Please Select')]")
	WebElement QCGroupSelect;
	
	@FindBy(xpath="//li[1]/button")
	WebElement QCHousing;
	
	@FindBy(xpath="//button[text()='Continue']")
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
		QCGroupSelect.click();
		QCHousing.click();
		Continue.click();
		Loginbutton.click();
//		return new PeopleSearchPage();
	}
	
}
