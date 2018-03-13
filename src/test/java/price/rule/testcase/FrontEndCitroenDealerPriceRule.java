package price.rule.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import factory.BrowserFactory;
import factory.DataproviderFactory;
import price.rule.front.sc.InventoryForm;
import utility.ExtentReporterNG;
import utility.Helper;

public class FrontEndCitroenDealerPriceRule {

	WebDriver driver;
	ExtentReports report1;
	ExtentTest logger1;

	@BeforeClass
	public void frontendReports() {
		report1 =ExtentReporterNG.getInstance();
				//ExtentReports(".\\Reports\\FrontEndPriceRuleCitroen.html", true);
			}

	@BeforeMethod
	public void citroenpriceRuleDlr() {

		logger1 = report1.startTest("Navigate to Citroen Dealer New Inventory Page");
		driver = BrowserFactory.getBrowser("chrome");
		logger1.log(LogStatus.INFO, "BrowserLaunch");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getExcel().getData("Sheet4", 6, 0));
		logger1.log(LogStatus.INFO, "Navigate to Citroen Dlr New Inventory Page");
		logger1.log(LogStatus.INFO, logger1
				.addScreenCapture(Helper.captureScreenshot(driver, "Citroen Dealer New Inventory Page")));

	}

	@Test(priority=6)
	public void withPriceRule() {
		logger1 = report1.startTest("Applied OEM and Green Discount");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);

		form.citroenpriceRuleValue();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		logger1.log(LogStatus.INFO, "Calling priceRuleMethod");

		// WebElement price =
		// driver.findElement(By.xpath("//ul[@class='dropdown-menu
		// discountedprice-dropdown']//li[1]"));
		// Assert.assertFalse(pass, );

		logger1.log(LogStatus.INFO, logger1
				.addScreenCapture(Helper.captureScreenshot(driver, "Oem and Green Discount Values Applied for Citroen Make")));
		logger1.log(LogStatus.PASS, "OEM and Green Discount Values Applied for Citroen Make");
		
	}

	@AfterMethod
	public void closeBrowser() {
		logger1.log(LogStatus.INFO, "Closing Browsers");
		BrowserFactory.closeBrowser(driver);
		report1.endTest(logger1);
		report1.flush();

	}
}
