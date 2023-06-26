package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePage {

	 WebDriver driver;

	public HomePage(WebDriver driver) {// created constructor needed for POM model.   Constructor cannot be static
		this.driver = driver;
	}

	public void links() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"element-660521\"]/div/div/div/div[2]/div/a")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.findElement(
				By.xpath("//div[@class='row-inner service_initiatives_sec']/div[2]/div/div/div/a[1]/div/div[2]/h6"))
				.click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
	}

	public void BGColor() {
		String actcolor = driver
				.findElement(By.xpath("//div[@id='block-system-main']/div/article/div/div/div/div/div[9]/div/div"))
				.getCssValue("background-color");
		String expcolor = "rgba(237, 237, 237, 1)";
		System.out.println(actcolor);
		if (actcolor.contentEquals(expcolor)) {
			System.out.println("same color");
		} else {
			System.out.println("not same color");
		}

	}

}
