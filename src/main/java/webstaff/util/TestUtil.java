package webstaff.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

import webstaff.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	// Method to TakeScreenshot
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		Files.copy(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	//Method for mouseover on object
	public void mouseover(WebElement element) {
		
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}	
	
	//Method to select dropdown list items.
	public void SelectItem(WebElement select, String itemName) {
		
		Select sc = new Select(select);
		sc.selectByValue(itemName);
	}
	
	
}
