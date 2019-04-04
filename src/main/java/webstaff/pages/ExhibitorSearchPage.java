package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webstaff.base.TestBase;

public class ExhibitorSearchPage extends TestBase {

	// Initializing Page Objects
	public ExhibitorSearchPage() {
		PageFactory.initElements(driver, this);
	}

	//Exhibitor Search
	@FindBy(xpath = "(//a[@data-ng-click='webStaffCtrl.exhibitingCompanySearch()'])[1]")
	WebElement Exhibitor_Search;
	
	//Exhibitor Company Search
	@FindBy(xpath="//input[@data-ng-model='ExhibitingCompanySearchForm.searchCriteria.company']")
	WebElement Company_name;
	
	//Exhibitor Search Button
	@FindBy(xpath="//button[@data-ng-click='submitButton.clickButtonFn()']")
	WebElement Exh_Search_But;
	
	//Exhibitor Company Name filter
	@FindBy(xpath="(//div/strong)[1]")
	WebElement Search_Name;
	
	

}
