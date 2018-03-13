package price.rule.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataproviderFactory;
import price.rule.front.sc.InventoryForm;
import utility.ExtentReporterNG;
import utility.Helper;

public class FrontEndInActivePriceRule {

	WebDriver driver;
	ExtentReports report1;
	ExtentTest logger1;

	@BeforeClass
	public void frontendReports() {
		report1 = ExtentReporterNG.getInstance();
		//report1 = new ExtentReports(".\\Reports\\InActivePriceRule.html", true);

	}

	@Test(priority = 16)
	public void expiredPriceRule() {

		logger1 = report1.startTest("Expired Price Rule");
		driver = BrowserFactory.getBrowser("chrome");
		logger1.log(LogStatus.INFO, "BrowserLaunch");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getExcel().getData("Sheet4", 6, 0));
		logger1.log(LogStatus.INFO, "Opening Front End URL");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.citroenExpiredpriceRuleValue();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		logger1.log(LogStatus.INFO, "Calling priceRuleMethod");
		logger1.log(LogStatus.INFO, logger1
				.addScreenCapture(Helper.captureScreenshot(driver, " Expired Price value not Captured Front End")));
		logger1.log(LogStatus.PASS, "Expired price Rule Value Should not Capture for  respective  vehicles");

	}

	@Test(priority = 17)
	public void inActivePriceRule() {
		logger1 = report1.startTest("Inactive Price rule for Renault Dealer ");
		driver = BrowserFactory.getBrowser("chrome");
		logger1.log(LogStatus.INFO, "BrowserLaunch");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getExcel().getData("Sheet4", 1, 0));
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.inactivepriceRuleValue();
		logger1.log(LogStatus.INFO, "Calling priceRuleMethod");
		logger1.log(LogStatus.INFO, logger1
				.addScreenCapture(Helper.captureScreenshot(driver, "InActive Price Value not Captured in Front End")));
		logger1.log(LogStatus.PASS, "InActive price Rule Value Not Capture for  respective  vehicles");
	}

	@Test(priority = 18)

	public void deletedPriceRule() {
		logger1 = report1.startTest("Deleted Price Rule for Citroen Dealer");
		driver = BrowserFactory.getBrowser("chrome");
		logger1.log(LogStatus.INFO, "BrowserLaunch");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getExcel().getData("Sheet4", 6, 0));
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.citroenpriceRuleValue();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		logger1.log(LogStatus.INFO, logger1
				.addScreenCapture(Helper.captureScreenshot(driver, "Deleted Price Value not Captured in Front End")));
		logger1.log(LogStatus.PASS, "Deleted price Rule Value Not Capture for  respective  vehicles");
	}

	@Test(priority = 19)
	public void withoutIsPrimary() {
		logger1 = report1.startTest("PriceRule is not applying Without isPrimary");
		driver = BrowserFactory.getBrowser("chrome");
		logger1.log(LogStatus.INFO, "BrowserLaunch");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getExcel().getData("Sheet4", 7, 0));
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.withousIsPrimary();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		logger1.log(LogStatus.INFO, logger1
				.addScreenCapture(Helper.captureScreenshot(driver, "Price Rule is not Applying without isPrimary")));
		logger1.log(LogStatus.PASS, "Price Rule is not Applying without isPrimary");
	}

	@AfterMethod
	public void closeBrowser() {
		logger1.log(LogStatus.INFO, "Closing Browsers");
		BrowserFactory.closeBrowser(driver);
		report1.endTest(logger1);
		report1.flush();

	}
}