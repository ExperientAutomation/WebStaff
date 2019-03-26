package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webstaff.base.TestBase;

public class PendsPage extends TestBase{	
	
	MiscFunctions misc = new MiscFunctions();
	
	@FindBy(xpath="(//li[@ng-click='groupTabClicked(group)'])[4]")
	WebElement PendsTab;
	
	@FindBy(xpath="//button[@data-ng-click='RegPend.addPend()']")
	WebElement PendAdd;
	
	@FindBy(xpath="//button[@data-ng-click='RegPend.addNote(pend)']")
	WebElement PendAddNote;
	
	@FindBy(xpath="//exl-select-list-modal[@title='Pend Types']")
	WebElement PendList;
	
	@FindBy(xpath="(//ul[@class='select-list small-block-grid-1 medium-block-grid-']/li/button)[1]")
	WebElement PendselectTypes;
	
	@FindBy(xpath="//dd[@data-ng-repeat='pend in RegPend.profile.pendArray']")
	WebElement PendAccordion_Incomplete;
	
	@FindBy(xpath="//button[@class='button success exl-top-margin']")
	WebElement PendResolve;
	
	@FindBy(xpath="//textarea")
	WebElement PendEnterNote;
	
	@FindBy(xpath="//dd[@data-ng-repeat='pend in RegPend.profile.pendArray']/a/span")
	WebElement PendResolved_text;
		
	//Initializing the page objects:
	public PendsPage() {		
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public boolean clickPendTab() {
		PendsTab.click();
		return PendAdd.isDisplayed();			
	}
	
	public boolean SelectPendTypeList() {
		
		PendList.click();
		PendselectTypes.click();
		misc.Continue.click();
		PendAdd.click();
		return PendAccordion_Incomplete.isDisplayed();		
	}
	
	public String PendResolved() {
		
		try {
		PendAccordion_Incomplete.click();
		PendEnterNote.sendKeys("Test Pend notes added here");	
		PendResolve.click();
		misc.PopUpYes.click();
		Thread.sleep(2000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		return PendResolved_text.getText();
	}
}
