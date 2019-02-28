package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;

public class ShowItemsPage extends TestBase{
	
	@FindBy(xpath="(//a[@exl-accordion-tab-tab-transclude='group.headingEl'])[2]")
	WebElement ShowItemTab;
	
	@FindBy(xpath="(//button[@ng-click='ShopShowItemModal.showModal()'])[1]")
	WebElement ShowItemLink;
	
	@FindBy(xpath="//input[@ng-model='ShopShowItem.keyword']")
	WebElement ShowItemSearch;
	
	@FindBy(xpath="//div[@ng-init='showItem = ShopShowItemAddButton.showItem']")
	WebElement ADD;
	
	@FindBy(xpath="//button[@data-ng-click='spinnerCtrl.increment()']")
	WebElement IncreaseShowItem;
	
	@FindBy(xpath="//button[@class='small dark']")
	WebElement ShowItemOkbtn;
	
	@FindBy(xpath="//strong/span")
	WebElement CartShowItemText;
	
	
	

	// Initializing Page Objects
	public ShowItemsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

}
