package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
