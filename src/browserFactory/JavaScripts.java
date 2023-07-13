package browserFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScripts {

	WebDriver driver;
	WebElement element;
	@Test
	
	public void scrollPageDown() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
	
	public  void scrollIntoView(){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
	 public void clickElementByJS(){
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	    	js.executeScript("arguments[0].click();", element);
	 }
	 public void generateAlert(String message) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("alert('"+message+"')");
	 }
		
}
