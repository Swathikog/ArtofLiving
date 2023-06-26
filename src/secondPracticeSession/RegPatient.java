package secondPracticeSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegPatient {

	WebDriver driver;
	String url="https://demo.openmrs.org/openmrs/login.htm";
	
	By textField_Username=By.id("username");
	By pwd=By.id("password");
	By Inpat=By.id("Inpatient Ward");
	By lgnBtn=By.id("loginButton");
	By Regpat=By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension");
	By txtFieldName1 = By.xpath("//input[@name='givenName']");
	By txtFieldName2 = By.name("middleName");
	By txtFieldName3 = By.name("familyName");
	
	@BeforeTest
	public void browserlaunch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SWATHI\\git\\aol\\AOL\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
	}

	@AfterTest
	public void browserclose(WebDriver driver) {
		driver.close();
	}
	@BeforeClass
	public void login(WebDriver driver) {
		driver.findElement(textField_Username).sendKeys("admin");
		driver.findElement(pwd).sendKeys("Admin123");
		driver.findElement(Inpat).click();
		driver.findElement(lgnBtn).click();
			}
	@AfterClass
	public void logout() {
		driver.findElement(By.xpath("//li[@class='nav-item logout']/a")).click();
	}
	
	@Test(dataProvider="patData")
	public void Stn(WebDriver driver,String fname,String mname,String lname) {
		driver.findElement(Regpat).click();
		driver.findElement(txtFieldName1).sendKeys(fname);
		driver.findElement(txtFieldName2).sendKeys(fname);
		driver.findElement(txtFieldName3).sendKeys(fname);	
	}
	
	@DataProvider
	public Object[][] patData(){
		return new Object[][] {
			{"frisco","dallas","texas"},
			{"edison","nj","ny"}
			
		};
	}
	}
