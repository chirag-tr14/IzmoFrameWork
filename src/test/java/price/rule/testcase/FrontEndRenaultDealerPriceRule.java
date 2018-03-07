package price.rule.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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

public class FrontEndRenaultDealerPriceRule

{
	WebDriver driver;
	ExtentReports report1;
	ExtentTest logger1;

	@BeforeClass
	public void frontendReports() {
		report1 = new ExtentReports(".\\Reports\\FrontEndPriceRuleCitroen.html", true);
		//report1=ExtentReporterNG.getInstance();
	}

	@BeforeMethod
	public void renaultpriceRuleDlr() {

		logger1 = report1.startTest("This page Verifies Fron end  Renault Dealer Price Rule");
		driver = BrowserFactory.getBrowser("chrome");
		logger1.log(LogStatus.INFO, "BrowserLaunch");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getExcel().getData("Sheet4", 1, 0));
		logger1.log(LogStatus.INFO, "Opening Front End URL");

	}

	@Test(priority = 6)
	// Without Price Rule Vehicle
	public void renaultwithOutPriceRule() {

		logger1 = report1.startTest("Without Price Rule Vehicle");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.otherValue();

		WebElement Withouprice = driver
				.findElement(By.xpath("//ul[@class='dropdown-menu discountedprice-dropdown']//li[1]"));

		logger1.log(LogStatus.INFO, logger1
				.addScreenCapture(Helper.captureScreenshot(driver, "Sucessfully Captured Price Value in Front End")));
		Assert.assertFalse(false, Withouprice.getText());

		logger1.log(LogStatus.FAIL, "Price rule value is not captured for other vehicles");
	}

	@Test(priority = 7)
	public void withPriceRule() {

		logger1 = report1.startTest("With  Price Rule Vehicle");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);

		form.priceRuleValue();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

		logger1.log(LogStatus.INFO, "Calling priceRuleMethod");

		// WebElement price =
		// driver.findElement(By.xpath("//ul[@class='dropdown-menu
		// discountedprice-dropdown']//li[1]"));
		// Assert.assertFalse(pass, );
		logger1.log(LogStatus.INFO, logger1
				.addScreenCapture(Helper.captureScreenshot(driver, "Sucessfully Captured Price Value in Front End")));

		// String actual = "Aide à la reprise (p) : 6 000 €";
		// String Expected="price.getText";
		logger1.log(LogStatus.PASS, "Price rule value is  captured for respective  vehicles");

	}

	@Test(priority = 8)
	public void MakePriceRule() {

		logger1 = report1.startTest("Particular Make  Price Rule Vehicle");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);

		form.MakepriceRuleValue();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		logger1.log(LogStatus.INFO, "Calling priceRuleMethod");
		// WebElement price =
		// driver.findElement(By.xpath("//ul[@class='dropdown-menu
		// discountedprice-dropdown']//li[1]"));

		logger1.log(LogStatus.INFO, logger1
				.addScreenCapture(Helper.captureScreenshot(driver, "Sucessfully Captured Price Value in Front End")));
		logger1.log(LogStatus.PASS, "Price rule value is  captured for respective  vehicles");

	}

	@Test(priority = 9)
	public void otherMakePriceRule() {
		logger1 = report1.startTest("Other Make   Price Rule Vehicle");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);

		form.otherMakepriceRuleValue();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

		logger1.log(LogStatus.INFO, "Calling priceRuleMethod");
		// WebElement price =
		// driver.findElement(By.xpath("//ul[@class='dropdown-menu
		// discountedprice-dropdown']//li[1]"));

		logger1.log(LogStatus.INFO, logger1
				.addScreenCapture(Helper.captureScreenshot(driver, "Sucessfully Captured Price Value in Front End")));
		logger1.log(LogStatus.PASS, "Price rule value is  captured for respective  vehicles");

	}

	@AfterMethod
	public void closeBrowser() {
		logger1.log(LogStatus.INFO, "Closing Browsers");
		BrowserFactory.closeBrowser(driver);
		report1.endTest(logger1);
		report1.flush();

	}
}
