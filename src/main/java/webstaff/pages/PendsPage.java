package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;

public class PendsPage extends TestBase{
	
	@FindBy(xpath="(//li[@ng-click='groupTabClicked(group)'])[4]")
	WebElement PendsTab;
	
	@FindBy(xpath="//button[@data-ng-click='RegPend.addPend()']")
	WebElement AddPend;
	
	@FindBy(xpath="//exl-select-list-modal[@title='Pend Types']")
	WebElement PendList;
	
	@FindBy(xpath="(//ul[@class='select-list small-block-grid-1 medium-block-grid-']/li/button)[1]")
	WebElement selectPendTypes;
	
	@FindBy(xpath="//dd[@data-ng-repeat='pend in RegPend.profile.pendArray']")
	WebElement Accordion_Incomplete;
	
	@FindBy(xpath="//button[@class='button success exl-top-margin']")
	WebElement Resolve;
	
	@FindBy(xpath="//dd[@data-ng-repeat='pend in RegPend.profile.pendArray']/a/span")
	WebElement Resolved_text;
		
	//Initializing the page objects:
	public PendsPage() {
		
		PageFactory.initElements(driver, this);
	}

}
