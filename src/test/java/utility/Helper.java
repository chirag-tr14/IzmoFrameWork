package utility;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper

{
	public static String captureScreenshot(WebDriver driver, String screenshotName) {

		// String datename=new SimpleDateFormat("yyyyMMddhhmmss").format(newDate());
	
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String destination = "C:\\Users\\rajesh.n\\git\\IzmoFrameWork\\Screenshots\\" + screenshotName
				+ System.currentTimeMillis() + ".png";
		
		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e) {
			System.out.println("Failed to capture screenshots" + e.getMessage());
		}

		return destination;
	}

}
