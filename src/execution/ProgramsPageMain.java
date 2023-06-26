package execution;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import pages.ProgramsPage;

public class ProgramsPageMain {

	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeMethod
	public void setExtent() {
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);	
	}
	@AfterMethod
	public void endReport() {
		extent.flush();
	}
	
	@BeforeTest
	@Parameters({"browser"})
	public static WebDriver utk(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\SWATHI\\Desktop\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\SWATHI\\Desktop\\Selenium\\drivers\\geckodriver-v0.32.0-win64\\geckodriver.exe");;
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.edge.driver", "C:\\Users\\SWATHI\\eclipse-workspace\\AOL\\drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		return driver;
	}
	
	@Test
	public void ppage() {
		test=extent.createTest("ArtOfLiving_ProgramsPage");
		ProgramsPage pp=new ProgramsPage();
		pp.proPage(driver);
		driver_terminate();
	}
	public void driver_terminate() {
		driver.close();
	}
	@AfterMethod
	public void screenshot(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			System.out.println("Test Failed");
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dst=new File("C:\\Users\\SWATHI\\git\\aol\\AOL\\Screenshots\\noelement.png");
			FileHandler.copy(src, dst);
			
		}	
	}
}
