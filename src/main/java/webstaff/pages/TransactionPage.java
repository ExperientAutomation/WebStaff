package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;

public class TransactionPage extends TestBase {
	
	
	@FindBy(xpath="(//li[@ng-click='groupTabClicked(group)'])[3]")
	WebElement TransactionTab;
	
	@FindBy(xpath="//div/table/thead")
	WebElement TransactionTable;
		
	
	//Initializing the page objects:
	public TransactionPage() {
		PageFactory.initElements(driver, this);
	}
	
	

}
