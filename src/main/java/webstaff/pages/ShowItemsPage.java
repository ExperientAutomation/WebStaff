package webstaff.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import webstaff.base.TestBase;
import webstaff.util.TestUtil;

public class ShowItemsPage extends TestBase{
	
	TestUtil util = new TestUtil();
	MiscFunctions misc = new MiscFunctions();
	SingleRegInfoPage singleRegInfoPage = new SingleRegInfoPage();
	
	@FindBy(xpath="(//a[@exl-accordion-tab-tab-transclude='group.headingEl'])[2]")
	WebElement ShowItemTab;
	
	@FindBy(xpath="(//h3[@class='exl-top-padding'])[2]")
	WebElement ShowItemCompleted;
	
	@FindBy(xpath="(//button[@ng-click='ShopShowItemModal.showModal()'])[1]")
	WebElement ShowItemLink;
	
	@FindBy(xpath="//input[@ng-model='ShopShowItem.keyword']")
	WebElement ShowItemSearch;
	
	@FindBy(xpath="//h3/a[text()='ESP1 - ESP: Billy Wilder - Sunset Boulevard']")
	WebElement ShowItemSearchResult;
	
	@FindBy(xpath="//div[@ng-init='showItem = ShopShowItemAddButton.showItem']")
	WebElement ShowItemADD;
	
	@FindBy(xpath="//button[@data-ng-click='spinnerCtrl.increment()']")
	WebElement ShowItemIncrease;
	
	@FindBy(xpath="//button[@class='small dark']")
	WebElement ShowItemOkbtn;
	
	@FindBy(xpath="//tr/td/div/div/div/span[contains(.,'ESP1')]")
	WebElement ShowItemAdded;
	
	@FindBy(xpath="(//strong/span)[text()='ESP1 - ESP: Billy Wilder - Sunset Boulevard']")
	WebElement ShowItemCartText;	

	// Initializing Page Objects
	public ShowItemsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String ClickOnShowItemTab() {
		
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",singleRegInfoPage.RegType);
		ShowItemLink.click();	
		wait.until(ExpectedConditions.elementToBeClickable(ShowItemSearch));
		return misc.popuptitletext.getText();
	}
	
	public String SearchShowItem() {
		
		try {
			ShowItemSearch.sendKeys("ESP1");
			Thread.sleep(2000);	
			wait.until(ExpectedConditions.elementToBeClickable(ShowItemSearchResult));
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		return ShowItemSearchResult.getText();		
	}

	public String AddShowItem() {
		
		try {
			ShowItemADD.click();
			ShowItemIncrease.click();
			ShowItemOkbtn.click();		
			wait.until(ExpectedConditions.visibilityOf(misc.ToasterSuccessMsg));
		} catch (Exception e) {		
			e.printStackTrace();
		}
		return misc.ToasterSuccessMsg.getText();		
	}
	
	public String VerifyAddedShowItem() {		
		
		try {
			misc.Close.click();
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",singleRegInfoPage.RegisteredIDText);
			ShowItemTab.click();
		} catch (Exception e) {		
			e.printStackTrace();
		}
		return ShowItemAdded.getText();
	}
	
	public String CartShowItem() {
		
		try {
		misc.CartIcon.click();		
		Thread.sleep(2000);				
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		String result = ShowItemCartText.getText();
		misc.Close.click();
		return result;
	}
	
	public String VerifyShowItemTab() {
		
		ShowItemTab.click();
		return ShowItemCompleted.getText(); 
	}
	
	
	
	
}
