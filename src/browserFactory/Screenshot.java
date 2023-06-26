package browserFactory;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class  Screenshot {
	
	WebDriver driver;
	public void onTestFailure() throws IOException {
		System.out.println("screenshot captured");
		
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dst=new File("C:\\Users\\SWATHI\\eclipse-workspace\\AOL\\Screenshots\\noelement.png");
			FileHandler.copy(src, dst);

		}

}
