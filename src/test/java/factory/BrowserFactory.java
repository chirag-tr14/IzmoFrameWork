package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory

{

	static WebDriver driver;

	public static WebDriver getBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", DataproviderFactory.getConfig().getFirefoxPath());
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", DataproviderFactory.getConfig().getChromePath());
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.edge.driver", DataproviderFactory.getConfig().getIePath());
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		return driver;
	}

	public static void closeBrowser(WebDriver ldriver) {
		ldriver.quit();
	}
}
