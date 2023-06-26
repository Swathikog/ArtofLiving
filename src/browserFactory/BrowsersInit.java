
package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowsersInit {

	static WebDriver driver;
	
	public static WebDriver startApplication(String browserName) {
		
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\SWATHI\\Desktop\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			 options.addArguments("--remote-allow-origins=*");
			 WebDriver driver=new ChromeDriver(options);
		}
		else if(browserName.equals("Firefox")) {
		System.setProperty("webdriver.firefox.driver", "C:\\Users\\SWATHI\\eclipse-workspace\\AOL\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		}
		else if(browserName.equals("Edge")) {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\SWATHI\\eclipse-workspace\\AOL\\drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
	}
		return driver;
		}
	
	public static void quitBrowser() {
		driver.close();
	}
	
}
