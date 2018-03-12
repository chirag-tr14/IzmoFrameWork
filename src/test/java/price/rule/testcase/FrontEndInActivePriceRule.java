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
import utility.Helper;

public class FrontEndInActivePriceRule {

	
	WebDriver driver;
	ExtentReports report1;
	ExtentTest logger1;
	
	@BeforeClass
	public void frontendReports() {
		report1 = new ExtentReports(".\\Reports\\InactivePriceRule.html", true);
		//report=ExtentReporterNG.getInstance();
	}

	@Test(priority = 15)
	public void expiredPriceRule() {
		
		logger1 = report1.startTest("This page Verifies Fron end  Renault Dealer Price Rule");
		driver = BrowserFactory.getBrowser("chrome");
		logger1.log(LogStatus.INFO, "BrowserLaunch");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getExcel().getData("Sheet4", 6, 0));
		logger1.log(LogStatus.INFO, "Opening Front End URL");
		logger1 = report1.startTest("Expired Price Rule");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.citroenpriceRuleValue();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		logger1.log(LogStatus.INFO, "Calling priceRuleMethod");
		logger1.log(LogStatus.INFO, logger1
				.addScreenCapture(Helper.captureScreenshot(driver, " Expired Price value not Captured Front End")));
		logger1.log(LogStatus.PASS, "Expired price Rule Value Should not Capture for  respective  vehicles");
	
	}
	
	@Test(priority=16)
	public void inActivePriceRule(){
		logger1 = report1.startTest("This page Verifies Fron end  Renault Dealer Price Rule");
		driver = BrowserFactory.getBrowser("chrome");
		logger1.log(LogStatus.INFO, "BrowserLaunch");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getExcel().getData("Sheet4", 1, 0));
		logger1 = report1.startTest("With  Price Rule Vehicle");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.inactivepriceRuleValue();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		logger1.log(LogStatus.INFO, "Calling priceRuleMethod");
		logger1.log(LogStatus.INFO, logger1
			.addScreenCapture(Helper.captureScreenshot(driver, "InActive Price Value not Captured in Front End")));
		logger1.log(LogStatus.PASS, "InActive price Rule Value Not Capture for  respective  vehicles");
	}
	

	@AfterMethod
	public void closeBrowser() {
		logger1.log(LogStatus.INFO, "Closing Browsers");
		BrowserFactory.closeBrowser(driver);
		report1.endTest(logger1);
		report1.flush();

	}
}
