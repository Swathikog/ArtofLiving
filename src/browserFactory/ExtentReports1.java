package browserFactory;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports1 {

	public static WebDriver driver;
	//Initializing the global variables
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setExtent() {
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/myReport.html"); 
		//System.getProperty("user.dir") is standard statement to create folder
		//This line creates a test-output folder in the project after refresh. and creates new document myReport under the folder
//		sparkReporter.config().setDocumentTitle("Automation Report");	//To set document title.This is user defined
//		sparkReporter.config().setReportName("Functional Report");		//To set Report name.This is user defined
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);			
//		extent.setSystemInfo("OS", "windows10");		//These are user defined. we can write whatever we want as names
//		extent.setSystemInfo("TesterName", "Swathi");	//These are user defined. we can write whatever we want as names
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
	
	@Test
	public void create() throws InterruptedException {
		test=extent.createTest("ArtOfLiving");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SWATHI\\Desktop\\Selenium\\drivers\\geckodriver-v0.32.0-win64\\geckodriver.exe");;
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.artofliving.org/in-en");
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-left unity_menu']/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"element-660521\"]/div/div/div/div[2]/div[2]/a.."));//wrong xpath written on purpose
		Thread.sleep(3000);
		driver.close();
	}
	
	@AfterMethod
	public void status(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test case failed is "+result.getName());
			//capture screenshot
			
			String screenshotpath=ExtentReports1.onTestFailure();
			test.addScreenCaptureFromPath(screenshotpath);
			}
		else if (result.getStatus()==ITestResult.SKIP){
			test.log(Status.SKIP, "Test case skipped is "+result.getName());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "test case name is "+result.getName());
			}
		
	}
	public static String onTestFailure() throws IOException {
		System.out.println("screenshot captured");
		//Screenshots folder inside project should be created before executing.
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			String dst="C:\\Users\\SWATHI\\eclipse-workspace\\AOL\\Screenshots\\noelement.png";
			File dst1=new File(dst);
			FileHandler.copy(src, dst1);
			return dst;
			
	}
}
