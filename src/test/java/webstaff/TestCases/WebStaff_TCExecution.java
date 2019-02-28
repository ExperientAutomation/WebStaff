package webstaff.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import webstaff.base.TestBase;
import webstaff.pages.LoginPage;
import webstaff.pages.PeopleSearchPage;
import webstaff.pages.SingleRegInfoPage;

@Listeners(webstaff.util.WebEventListener.class)
public class WebStaff_TCExecution extends TestBase{
	
	LoginPage loginPage;
	PeopleSearchPage peopleSearchPage;
	SingleRegInfoPage singleRegInfoPage;
	
	
	public static int row =0;
	
	public WebStaff_TCExecution() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		initialization();
		loginPage = new LoginPage();	
		peopleSearchPage = new PeopleSearchPage();
		singleRegInfoPage = new SingleRegInfoPage();		
	}
	
	@Test(priority=1)
	public void LoginPageTest() {	
		
		row=2;
		Assert.assertTrue(loginPage.validateLoginButton(), "WebStaff Login page not displayed");		
	}
	
	@Test(priority=2)
	public void QCGroupselectAndLoginPage() {
		
		row=3;
		loginPage.SelectQCGroupAndLogin();
		Assert.assertTrue(peopleSearchPage.verifySearchPage(), "People Search page not dispalyed");		
	}
	
	@Test(priority=3)
	public void SingleRegFormVerification() {
		
		row=4;
		singleRegInfoPage.VerifyNewRegForm();
		Assert.assertTrue(singleRegInfoPage.VerifyNewRegForm(), "Single Reg Form page not displayed");
	}
	
	@Test(priority=4)
	public void ChangeRegForm() {
		
		row=5;
	
	}
	
	
	
	
	@AfterSuite
	public void tearDown() {
//		driver.get(System.getProperty("user.dir")+ "\\Report\\ReportSummary.html");
//		driver.quit();
	}
	

}
