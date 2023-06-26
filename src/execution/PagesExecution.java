package execution;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import browserFactory.BrowsersInit;
import pages.HomePage;

public class PagesExecution {

	 WebDriver driver;
	
	@BeforeTest
	 public void launch() {
		driver=BrowsersInit.startApplication("Firefox");	
	}
	
	@BeforeClass
	public void openurl() {
		driver.get("https://www.artofliving.org/in-en");
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
	
	@Test
	public void execution() throws InterruptedException, IOException {
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.links();
		hp.BGColor();
		
	}

	
}
