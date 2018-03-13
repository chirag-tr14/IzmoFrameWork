package price.rule.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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

public class FrontEndRenaultDealerPriceRule

{
	WebDriver driver;
	ExtentReports report1;
	ExtentTest logger1;

	@BeforeClass
	public void frontendReports() {
		report1 =ExtentReporterNG.getInstance();
				//new ExtentReports(".\\Reports\\FrontEndPriceRuleRenault.html", true);
		
	}

	@Test(priority = 7)
	public void renualtdealerinvtUrl() {
		logger1 = report1.startTest("Navigate to Renault Dealer New Inventory Page");
		driver = BrowserFactory.getBrowser("chrome");
		logger1.log(LogStatus.INFO, "BrowserLaunch");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getExcel().getData("Sheet4", 1, 0));
		logger1.log(LogStatus.INFO, "Navigate to Renault Dealer New Inventory Page");
		logger1.log(LogStatus.INFO, logger1
				.addScreenCapture(Helper.captureScreenshot(driver, "Renault Dealer New Inventory Page")));

	}

	@Test(priority = 8)
	// Without Price Rule Vehicle
	public void renaultwithOutPriceRule() {
		logger1 = report1.startTest("Tradein Discount Not Applied Vehicles");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.otherValue();
		WebElement Withouprice = driver
				.findElement(By.xpath("//ul[@class='dropdown-menu discountedprice-dropdown']//li[1]"));
		logger1.log(LogStatus.INFO, logger1
				.addScreenCapture(Helper.captureScreenshot(driver, "Tradein Discount is not applied Vehicle ")));
		Assert.assertFalse(false, Withouprice.getText());
		logger1.log(LogStatus.PASS, "Tradein Discount is not captured for other Dealerid but Same Provider");
	}

	@Test(priority = 9)
	public void withPriceRule() {

		logger1 = report1.startTest("Tradein Discount Applied Vehicles");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.priceRuleValue();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		logger1.log(LogStatus.INFO, "Calling priceRuleMethod");
		// WebElement price =
		// driver.findElement(By.xpath("//ul[@class='dropdown-menu
		// discountedprice-dropdown']//li[1]"));
		// Assert.assertFalse(pass, );
		logger1.log(LogStatus.INFO, logger1
				.addScreenCapture(Helper.captureScreenshot(driver, "Tradein Discount is applied  vehicles")));
		logger1.log(LogStatus.PASS, "Tradein Discount is applied for same provider and same dealerid vehicles");

	}

	@Test(priority = 10)
	public void MakePriceRule() {
		logger1 = report1.startTest("Override Dealer Discount Applied Vehicle");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.MakepriceRuleValue();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		logger1.log(LogStatus.INFO, "Calling priceRuleMethod");
		// WebElement price =
		// driver.findElement(By.xpath("//ul[@class='dropdown-menu
		// discountedprice-dropdown']//li[1]"));
		logger1.log(LogStatus.INFO, logger1
				.addScreenCapture(Helper.captureScreenshot(driver, "Override Dealer Discount for  Paricular Make,Model")));
		logger1.log(LogStatus.PASS, "Replacing Old Dealer Discount value and applied Price Rule for paricular Make");

	}

	@Test(priority = 11)
	public void otherMakePriceRule() {
		logger1 = report1.startTest("Override Dealer Discount Not Applied Vehicle");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.otherMakepriceRuleValue();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		logger1.log(LogStatus.INFO, "Calling priceRuleMethod");
		// WebElement price =
		// driver.findElement(By.xpath("//ul[@class='dropdown-menu
		// discountedprice-dropdown']//li[1]"));
		logger1.log(LogStatus.INFO, logger1
				.addScreenCapture(Helper.captureScreenshot(driver, "Not Override Dealer Discount for Other Make,Model")));
		logger1.log(LogStatus.PASS, "Not Replacing Old Dealer Discount value and  Not applied Price Rule for paricular Make");

	}

	@AfterClass
	public void closeBrowser() {
		logger1.log(LogStatus.INFO, "Closing Browsers");
		BrowserFactory.closeBrowser(driver);
		report1.endTest(logger1);
		report1.flush();

	}
}
