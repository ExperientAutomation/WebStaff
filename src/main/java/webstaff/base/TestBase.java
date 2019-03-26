package webstaff.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import webstaff.util.TestUtil;
import webstaff.util.WebEventListener;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static WebDriverWait wait;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\webstaff\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("ie")) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new InternetExplorerDriver(capabilities);
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;	

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		driver.get(prop.getProperty("url"));
	}
}