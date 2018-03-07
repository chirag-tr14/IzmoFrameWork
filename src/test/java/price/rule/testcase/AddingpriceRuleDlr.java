package price.rule.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataproviderFactory;
import price.rule.front.sc.Login;
import price.rule.front.sc.PriceruleDealer;
import utility.Helper;

public class AddingpriceRuleDlr

{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	String Expatected = "https:/hkg,ghl,hj/qadealeradminv2fr.izmocars.com/inventoryPriceRulesList.htm?successMsg=inventory_price_rules_saved";

	/*
	 * @BeforeClass public void extentsReport { report =new
	 * ExtentReports(".\\Reports\\PriceRuleAdd.html",true);
	 * 
	 * }
	 */

	@BeforeMethod
	public void setUp1() {

		driver = BrowserFactory.getBrowser("chrome");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getConfig().applicationUrl());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			logger = report.startTest("Login SC");
		logger.log(LogStatus.INFO, "Application is up and running");
		logger.log(LogStatus.INFO, "Welcome to site Admin");

	}

	// @Test(enabled=false)
	@Test(priority = 1)
	public void tradeinDiscount() {

		Login login = PageFactory.initElements(driver, Login.class);
		PriceruleDealer Invt = PageFactory.initElements(driver, PriceruleDealer.class);
		login.loginApplication(DataproviderFactory.getExcel().getData("Sheet1", 1, 0),
				DataproviderFactory.getExcel().getData("Sheet1", 1, 1));

		logger = report.startTest("PriceRule Trade");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		login.selectDealer();

		login.searchDealerRenault(DataproviderFactory.getExcel().getData("Sheet2", 1, 0));
		logger.log(LogStatus.INFO, "Passed Dealer Name");

		Invt.manageInventory();

		Invt.renaultDlrTradeinDiscount();

		logger.log(LogStatus.INFO,
				logger.addScreenCapture(Helper.captureScreenshot(driver, "SuccesFullyAdded Trade in Discount")));

		String Actual = driver.getCurrentUrl();
		Assert.assertEquals(Actual, Expatected);

	}

	// @Test(enabled=false)
	@Test(priority = 2)
	public void oemDiscount() {

		Login login = PageFactory.initElements(driver, Login.class);
		PriceruleDealer Invt = PageFactory.initElements(driver, PriceruleDealer.class);
		login.loginApplication(DataproviderFactory.getExcel().getData("Sheet1", 1, 0),
				DataproviderFactory.getExcel().getData("Sheet1", 1, 1));

		logger = report.startTest("Adding OEM Discount");

		String title = login.getApplicationTitile();
		Assert.assertTrue(title.contains("Welcome to your"));

		logger.log(LogStatus.PASS, "Getting Application Title");

		// Selecting Dealer
		login.selectDealer();

		logger.log(LogStatus.INFO, "Clicking Select Organization Button");
		login.searchDealerCitroen(DataproviderFactory.getExcel().getData("Sheet2", 3, 0));
		logger.log(LogStatus.INFO, "Passed Dealer Name");

		// Calling InventoryManager
		Invt.manageInventory();

		logger.log(LogStatus.INFO, "Calling AddPrice Rule Methodr");
		Invt.citroentDlrOemDiscount();

		logger.log(LogStatus.INFO,
				logger.addScreenCapture(Helper.captureScreenshot(driver, "SuccesFullyAdded Oem Discount")));

		String Actual = driver.getCurrentUrl();
		Assert.assertEquals(Actual, Expatected);

		logger.log(LogStatus.FAIL, "Getting Application Title");

	}

	// @Test(enabled=false)
	@Test(priority = 3)
	public void greenDiscount() {

		Login login = PageFactory.initElements(driver, Login.class);
		PriceruleDealer Invt = PageFactory.initElements(driver, PriceruleDealer.class);
		login.loginApplication(DataproviderFactory.getExcel().getData("Sheet1", 1, 0),
				DataproviderFactory.getExcel().getData("Sheet1", 1, 1));

		logger = report.startTest("Adding GreenDiscount");

		String title = login.getApplicationTitile();
		Assert.assertTrue(title.contains("Welcome to your"));

		logger.log(LogStatus.PASS, "Getting Application Title");

		// Selecting Dealer
		login.selectDealer();

		logger.log(LogStatus.INFO, "Clicking Select Organization Button");
		login.searchDealerCitroen(DataproviderFactory.getExcel().getData("Sheet2", 3, 0));
		logger.log(LogStatus.INFO, "Passed Dealer Name");

		// Calling InventoryManager
		Invt.manageInventory();
		String priceUrl = driver.getTitle();
		Assert.assertTrue(priceUrl.contains(priceUrl));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		logger.log(LogStatus.INFO, "Calling AddPrice Rule Methodr");
		Invt.citroentDlrGreenDiscount();

		logger.log(LogStatus.INFO,
				logger.addScreenCapture(Helper.captureScreenshot(driver, "SuccesFully Added Grenn Discount")));

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// driver.get(DataproviderFactory.getExcel().getData("Sheet5", 1, 0));
		String Actual = driver.getCurrentUrl();
		Assert.assertEquals(Actual, Expatected);

		logger.log(LogStatus.FAIL, "Getting Application Title");

	}

	// @Test(enabled=false)
	@Test(priority = 4)
	public void dealerDiscount() {

		Login login = PageFactory.initElements(driver, Login.class);
		PriceruleDealer Invt = PageFactory.initElements(driver, PriceruleDealer.class);
		login.loginApplication(DataproviderFactory.getExcel().getData("Sheet1", 1, 0),
				DataproviderFactory.getExcel().getData("Sheet1", 1, 1));

		logger = report.startTest("Adding DealerDiscount");

		String title = login.getApplicationTitile();
		Assert.assertTrue(title.contains("Welcome to your"));
		logger.log(LogStatus.PASS, "Getting Application Title");
		// Selecting Dealer
		login.selectDealer();
		logger.log(LogStatus.INFO, "Clicking Select Organization Button");
		login.searchDealerRenault(DataproviderFactory.getExcel().getData("Sheet2", 1, 0));
		logger.log(LogStatus.INFO, "Passed Dealer Name");

		// Calling InventoryManager
		Invt.manageInventory();
		String priceUrl = driver.getTitle();
		Assert.assertTrue(priceUrl.contains(priceUrl));

		logger.log(LogStatus.INFO, "Calling AddPrice Rule Method");
		Invt.renaultDlrDealerDiscount();

		logger.log(LogStatus.INFO,
				logger.addScreenCapture(Helper.captureScreenshot(driver, "SuccesFully Added Dealer Discount")));

		// driver.get(DataproviderFactory.getExcel().getData("Sheet5", 1, 0));

		String Actual = driver.getCurrentUrl();
		System.out.println(Actual);
		Assert.assertEquals(Actual, Expatected);

		logger.log(LogStatus.FAIL, "Getting Application Title");

	}

	// @Test(enabled=false)
	@AfterMethod
	public void tearDown() {
		Login login = PageFactory.initElements(driver, Login.class);
		login.logOut();
		logger.log(LogStatus.INFO, "Logout the application ");
		BrowserFactory.closeBrowser(driver);
		logger.log(LogStatus.INFO, "Closing the Browser");

		report.endTest(logger);
		report.flush();

	}

	/*
	 * @Test public void tearDown(ITestResult result){
	 * 
	 * Login login=PageFactory.initElements(driver, Login.class);
	 * if(result.getStatus()==ITestResult.FAILURE) { String path=
	 * Helper.captureScreenshot(driver, result.getName());
	 * 
	 * logger.log(LogStatus.FAIL, logger.addScreenCapture(path)); }
	 * 
	 * login.logOut(); BrowserFactory.closeBrowser(driver);
	 * report.endTest(logger); report.flush();
	 * 
	 * }
	 */
}
