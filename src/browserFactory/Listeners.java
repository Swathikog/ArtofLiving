package browserFactory;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends Screenshot implements ITestListener {
	
	public void onTestFailure() {
		System.out.println("Test Failed");
		onTestFailure();
	}
		public void onTestSuccess() {
		System.out.println("Test Implemented successfully");
	}
		public void onTestSkipped() {
			System.out.println("Test skipped successfully");
		}
		
	
}
