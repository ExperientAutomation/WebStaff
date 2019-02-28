package webstaff.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

import webstaff.TestCases.WebStaff_TCExecution;
import webstaff.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener,IResultListener{
	
	public final int usernamecolnumber = 5;
	public final int activitycolnumber = 3;
	public final int expectedresultcolnumber =4;
	
	XlsUtil xls = new XlsUtil();
	WebStaff_TCExecution WebStaff_test = new WebStaff_TCExecution (); 
	String sheetname = "WebStaff_TC";

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
	
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
	
		// Highlight before clicking on Element. 
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", element);
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		
		// Remove Highlighted after clicking on Element. 
//			JavascriptExecutor jse = (JavascriptExecutor) driver;
//			jse.executeScript("arguments[0].style.border=''", element);
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver,CharSequence[] keysToSend) {
		
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver,CharSequence[] keysToSend) {
		
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		
		
	}

	@Override
	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error);
		/*try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
	System.out.println(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test cases passed");
		xls.setCellData(sheetname, usernamecolnumber+1, WebStaff_TCExecution.row,"Pass");	
		xls.setCellData(sheetname, usernamecolnumber, WebStaff_TCExecution.row,System.getProperty("user.name"));
	}

	@Override
	public void onTestFailure(ITestResult result) {		
		System.out.println("Test cases failed");
		xls.setCellData(sheetname, usernamecolnumber+1, WebStaff_TCExecution.row,"Fail");	
		xls.setCellData(sheetname, usernamecolnumber, WebStaff_TCExecution.row,System.getProperty("user.name"));
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("WebStaff Execution started");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("WebStaff Execution ended");
		
	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

}
