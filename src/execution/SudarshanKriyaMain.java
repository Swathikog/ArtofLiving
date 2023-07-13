package execution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pages.SudarshanKriya;

public class SudarshanKriyaMain extends BaseClass {
	//Execute from testng.xml
	@Test
	public void mm() throws InterruptedException {
		SudarshanKriya sk=new SudarshanKriya();
		sk.sudKriya(driver);
		SudarshanKriya title=new SudarshanKriya();
		title.secondcomponent(driver);
	System.out.println("");	
	}
	
}
