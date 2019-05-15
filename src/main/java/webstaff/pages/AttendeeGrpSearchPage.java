package webstaff.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import webstaff.base.TestBase;
import webstaff.util.TestUtil;

public class AttendeeGrpSearchPage extends TestBase {

	TestUtil util = new TestUtil();
	MiscFunctions misc = new MiscFunctions();

	// Initializing Page Objects
	public AttendeeGrpSearchPage() {
		PageFactory.initElements(driver, this);
	}

	// Attendee Group Search
	@FindBy(xpath = "//button[@data-ng-click='submitButton.clickButtonFn()']")
	WebElement Attendee_Grp_Search;

	// Attendee Group Name
	@FindBy(id = "regGrpSearch_grpName")
	WebElement Grp_Name;

	// Expand Details link
	@FindBy(xpath = "(//div[@class='small-2 columns'])[1]")
	WebElement Details_link;
	
	//Attendee Group filter
	@FindBy(xpath="(//div/strong)[1]")
	WebElement Att_Grp_Search_Name;

	// Actions:
	public boolean AttendeeSearch() {

		util.mouseover(misc.Search);
		misc.AttendeeGrpSearch.click();
		return Grp_Name.isDisplayed();
	}
	
	public boolean EnterAttendeeGrp() {
		
		String Attgrp = prop.getProperty("AttendeeGrp");
		wait.until(ExpectedConditions.visibilityOf(Grp_Name));
		Grp_Name.sendKeys(Attgrp);
		Attendee_Grp_Search.click();
		wait.until(ExpectedConditions.visibilityOf(Att_Grp_Search_Name));
		return Att_Grp_Search_Name.getText().contains(Attgrp);
	}

}
