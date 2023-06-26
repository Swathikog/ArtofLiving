package secondPracticeSession;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class screen {

	public void dd() throws IOException {
		WebDriver driver;
		
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\SWATHI\\eclipse-workspace\\TestNGSample\\driverFolder\\geckodriver.exe");
	driver=new FirefoxDriver();
	driver.get("https://www.amazon.com");
	
	TakesScreenshot ts= (TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dst=new File("C:\\Users\\SWATHI\\eclipse-workspace\\TestNGSample\\Screenshots\\ans.png");
	FileHandler.copy(src,dst);

	}
	
}
