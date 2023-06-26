package secondPracticeSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Reports {
	
	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setExtent() {
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);	
	}
	@AfterTest
	public void endReport() {
		extent.flush();
	}
	
	@Test
	public void test() {
		test=extent.createTest("ArtOfLiving");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SWATHI\\Desktop\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.softwaretestingmaterial.com/generate-extent-reports");
		driver.close();
		  
	}	
}
