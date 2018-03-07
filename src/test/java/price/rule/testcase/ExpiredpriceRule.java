package price.rule.testcase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.database.Database;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataproviderFactory;
import price.rule.front.sc.Login;
import price.rule.front.sc.PriceruleDealer;
import utility.Helper;

public class ExpiredpriceRule {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	AddingpriceRuleDlrWithReport pricerule = new AddingpriceRuleDlrWithReport();

	@BeforeMethod
	public void setUp1() {

		driver = BrowserFactory.getBrowser("chrome");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getConfig().applicationUrl());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		;
		report = new ExtentReports(".\\Reports\\PriceRuleAdd.html", true);
		logger = report.startTest("Login SC");
		logger.log(LogStatus.INFO, "Application is up and running");

	}

	@Test(enabled = false)
	public void expiredDatePriceRule() {

		Login login = PageFactory.initElements(driver, Login.class);
		PriceruleDealer Invt = PageFactory.initElements(driver, PriceruleDealer.class);
		login.loginApplication(DataproviderFactory.getExcel().getData("Sheet1", 1, 0),
				DataproviderFactory.getExcel().getData("Sheet1", 1, 1));
		login.selectDealer();
		login.searchDealerCitroen(DataproviderFactory.getExcel().getData("Sheet2", 3, 0));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Invt.expiredPriceRule();
		driver.get(DataproviderFactory.getExcel().getData("Sheet5", 1, 0));
	}

	@Test(priority = 2)
	public void inactivePriceRule() throws ClassNotFoundException, SQLException {

		Database databse = new Database();
		String Query = "select *from inventory_price_rules where level='DLR' and fk_dealer_id=103209 and status='ACTV';";
		ResultSet data = databse.getData(Query);
		// System.out.println(data);
		while (data.next()) {
			System.out.println(data.getString(1));

		}

		Login login = PageFactory.initElements(driver, Login.class);
		PriceruleDealer Invt = PageFactory.initElements(driver, PriceruleDealer.class);
		login.loginApplication(DataproviderFactory.getExcel().getData("Sheet1", 1, 0),
				DataproviderFactory.getExcel().getData("Sheet1", 1, 1));
		login.selectDealer();
		login.searchDealerRenault((DataproviderFactory.getExcel().getData("Sheet2", 1, 0)));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Invt.inactivePriceRule();

		// String ruleid=data.getString(1);

		// StringBuilder str=new StringBuilder(driver.getCurrentUrl());

		// str.replace(start, end, str)

		logger.log(LogStatus.INFO,
				logger.addScreenCapture(Helper.captureScreenshot(driver, "SuccesFully Inactive greenDiscount")));

		logger.log(LogStatus.INFO,
				logger.addScreenCapture(Helper.captureScreenshot(driver, "Inactive Tab  Price Rule List ")));

		// driver.get(DataproviderFactory.getExcel().getData("Sheet5", 1, 0));
	}
}
/*
 * @Test(priority = 4) public void deletePriceRule() {
 * 
 * Login login = PageFactory.initElements(driver, Login.class); PriceruleDealer
 * Invt = PageFactory.initElements(driver, PriceruleDealer.class);
 * login.loginApplication(DataproviderFactory.getExcel().getData("Sheet1", 1,
 * 0), DataproviderFactory.getExcel().getData("Sheet1", 1, 1));
 * login.selectDealer();
 * login.searchDealerCitroen(DataproviderFactory.getExcel().getData("Sheet2", 1,
 * 0)); driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
 * Invt.deletePriceRule();
 * 
 * }
 * 
 * @AfterMethod public void tearDown1() {
 * 
 * Login login = PageFactory.initElements(driver, Login.class);
 * 
 * login.logOut(); logger.log(LogStatus.INFO, "Logout the application ");
 * BrowserFactory.closeBrowser(driver); logger.log(LogStatus.INFO,
 * "Closing the Browser"); report.endTest(logger); report.flush(); } }
 */