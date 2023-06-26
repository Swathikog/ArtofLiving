package secondPracticeSession;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class PopUp {

	WebDriver driver;
	
	String url="https://www.artofliving.org/in-en";
	By ReadMore=By.xpath("//div[@class='most_popular_articles most_popular_articles_mob mpa_tabbed_layout']/div[2]/div[1]/ul/div[1]/div/div[6]/li/div[2]/span[2]/div/a");
	By ReadMore1=By.xpath("//*[@id=\"view1\"]/ul/div[1]/div/div[6]/li/div[2]/span[2]/div/a");
	@Test
	public void pop() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SWATHI\\Desktop\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		
		driver.get(url);
		driver.findElement(By.linkText("Sudarshan Kriya")).click();
		driver.manage().window().maximize();
		//Scroll down page Javascript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//div[@class='hb-modal-wrp']/div[3]")).click();
		WebElement wm=driver.findElement(ReadMore);
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", wm);
		driver.close();	
	}
	
}
//Element click intercepted exception is a common exception. An independent utility must be created to 
//handle such exceptions in any professional automation framework. There are multiple ways to handle 
//this exception:

//Method-1: JavascriptExecutor click can be used in cases like when there is a dropdown suggestion list
//and an element that needs to be clicked gets hidden behind. This solution will do a force click on 
//the required element and the sample code for performing this action is:

//JavascriptExecutor js = (JavascriptExecutor)driver;
//js.executeScript("arguments[0].click();", element);

//Method-2: Selenium wait until the element becomes clickable
//Sample Code: WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//wait.until(ExpectedConditions.elementToBeClickable(element))); element.click();

//Method-3: Element not visible due to requirement of scroll down
//Sample Code: WebElement element = driver.findElement(element locator);
//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); element.click();

//Method-4: Use action class
//Sample Code: WebElement element = driver.findElement(element Locator);
//Actions actions = new Actions(driver); actions.moveToElement(element).click().build().perform();

//Method-5: Use static class
//Sample Code : Thread.sleep(10000);