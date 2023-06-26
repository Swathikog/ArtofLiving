package secondPracticeSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserPS {

	public static WebDriver driver;
	@Parameters({"browser"})
	@BeforeTest
	public void browsin(String browser) {
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\SWATHI\\eclipse-workspace\\TestNGSample\\driverFolder\\geckodriver.exe");
			driver=new FirefoxDriver();
			}
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SWATHI\\eclipse-workspace\\TestNGSample\\driverFolder\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		if(browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\SWATHI\\Desktop\\Selenium\\drivers\\edgedriver_win64\\msedgedriver.exe");
			driver=new ChromeDriver();
		
	}
	}
	@Test
	public void create() throws InterruptedException {
		
		driver.get("https://www.amazon.com/");
		
	}
}
