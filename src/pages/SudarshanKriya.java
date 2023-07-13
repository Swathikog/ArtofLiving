package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import browserFactory.JavaScripts;

public class SudarshanKriya {

	public static WebDriver driver;
	String url="https://www.artofliving.org/in-en";
	By ReadMore=By.xpath("//div[@class='most_popular_articles most_popular_articles_mob mpa_tabbed_layout']/div[2]/div[1]/ul/div[1]/div/div[6]/li/div[2]/span[2]/div/a");
	
	
	public void sudKriya(WebDriver driver) {
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
		driver.quit();	
	}	
	
	public void secondcomponent(WebDriver driver) throws InterruptedException {
		driver.get(url);
		driver.findElement(By.linkText("Sudarshan Kriya")).click();
		driver.manage().window().maximize();
		//Scroll down page Javascript
//		JavaScripts md=new JavaScripts();
//		md.scrollPageDown();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement ws=driver.findElement(By.linkText("Sudarshan Kriya"));
		String sde=ws.getText();
		if(sde.equals("Sudarshan Kriya")) {
			System.out.println("Correct title displayed");
		}
		else {
			System.out.println("Incorrect title is displayed");
		}
		
		WebElement wm1=driver.findElement(By.linkText("Studies"));
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", wm1);
		WebElement wm2=driver.findElement(By.partialLinkText("Research on Sudarshan Kriya"));
		String researchTitle=wm2.getText();
		
		if(researchTitle.equals("Research on Sudarshan Kriya")) {
			System.out.println("Title is valid");
		}else {
			System.out.println("title is Invalid");
		}
		driver.navigate().back();
		
		WebElement wm3=driver.findElement(By.linkText("45 million people in 180 countries"));
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("arguments[0].click();", wm3);
		Thread.sleep(3000);
		driver.navigate().back();
		
		WebElement wm4=driver.findElement(By.linkText("Join a Free Webinar"));
		JavascriptExecutor js4 = (JavascriptExecutor)driver;
		js4.executeScript("arguments[0].click();", wm4);
		Thread.sleep(3000);
		driver.navigate().back();
		
		WebElement wm5=driver.findElement(By.linkText("SCHEDULE"));
		JavascriptExecutor js5=(JavascriptExecutor)driver;
		js5.executeScript("arguments[0].click();", wm5);
		Thread.sleep(3000);
		driver.navigate().back();		
		
		driver.quit();
		}
		
}
