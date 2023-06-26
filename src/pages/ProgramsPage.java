package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProgramsPage {

	WebDriver driver;
	String url="https://www.artofliving.org/in-en";
	By programs=By.linkText("Programs");
	By utkarshaYoga=By.linkText("Utkarsha Yoga");
	
	
	public void proPage(WebDriver driver) {
		this.driver=driver;
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(programs).click();
		driver.findElement(utkarshaYoga).click();
		driver.findElement(By.id("has")).click();
		
	}
		
}
