package price.rule.testcase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.database.Database;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import factory.BrowserFactory;
import factory.DataproviderFactory;
import price.rule.front.sc.Login;
import price.rule.front.sc.PriceruleDealer;
import utility.ExtentReporterNG;
import utility.Helper;

public class ExpiredpriceRule {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	AddingpriceRuleDlr pricerule = new AddingpriceRuleDlr();
	Database databse = new Database();

	@BeforeClass
	public void reports() {
		report =ExtentReporterNG.getInstance();
			//	new ExtentReports(".\\Reports\\BackendPriceRuleInActive.html", true);
	}

	@Test(priority = 12)
		public void loginSc() {
		driver = BrowserFactory.getBrowser("chrome");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getConfig().applicationUrl());
		Login login = PageFactory.initElements(driver, Login.class);
		login.loginApplication(DataproviderFactory.getExcel().getData("Sheet1", 1, 0),
		DataproviderFactory.getExcel().getData("Sheet1", 1, 1));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger = report.startTest("Login SC");
		logger.log(LogStatus.INFO, "Application is up and running");
		logger.log(LogStatus.INFO, "Welcome to site Admin");

	}

	@Test(priority = 13)
	public void expiredDatePriceRule() throws ClassNotFoundException, SQLException {
		logger = report.startTest("Expired PriceRule");
 
		String Query = "select *from inventory_price_rules where level='DLR' and fk_dealer_id=102878 and "
				+ "inv_provider='IZMOVN-PGA-CITROEN' and  status='ACTV'; ";
		ResultSet data = databse.getData(Query);
		boolean firstData = data.next();
		String ID = "";
		if (firstData) {
			ID = data.getString(1);
			// System.out.println(ID);
		}
		Login login = PageFactory.initElements(driver, Login.class);
		PriceruleDealer Invt = PageFactory.initElements(driver, PriceruleDealer.class);
		login.selectDealer();
		login.searchDealerCitroen(DataproviderFactory.getExcel().getData("Sheet2", 3, 0));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String PriceRuleURl = DataproviderFactory.getExcel().getData("Sheet6", 1, 1);
		String ScUrl = DataproviderFactory.getExcel().getData("Sheet6", 1, 0);

		driver.get(ScUrl + PriceRuleURl + ID);
		Invt.expiredPriceRule();
		logger.log(LogStatus.INFO,
				logger.addScreenCapture(Helper.captureScreenshot(driver, "Expire Tab  Price Rule List BackEnd ")));
		driver.get(DataproviderFactory.getExcel().getData("Sheet5", 1, 0));
		
	}

	@Test(priority = 14)
	public void inactivePriceRule() throws ClassNotFoundException, SQLException {
		logger = report.startTest("InActive PriceRule");
		String Query = "select *from inventory_price_rules where level='DLR' and fk_dealer_id=103209 and status='ACTV' ";
		ResultSet data = databse.getData(Query);
		boolean firstData = data.next();
		String ID = "";
		if (firstData) {
			ID = data.getString(1);
			System.out.println(ID);
		}
		Login login = PageFactory.initElements(driver, Login.class);
		PriceruleDealer Invt = PageFactory.initElements(driver, PriceruleDealer.class);
		login.selectDealer();
		login.searchDealerRenault((DataproviderFactory.getExcel().getData("Sheet2", 1, 0)));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		String PriceRuleURl = DataproviderFactory.getExcel().getData("Sheet6", 1, 1);
		String ScUrl = DataproviderFactory.getExcel().getData("Sheet6", 1, 0);

		driver.get(ScUrl + PriceRuleURl + ID);

		Invt.inactivePriceRule();
		logger.log(LogStatus.INFO,
				logger.addScreenCapture(Helper.captureScreenshot(driver, "Inactive Tab  Price Rule List BackEnd ")));

		driver.get(DataproviderFactory.getExcel().getData("Sheet5", 1, 0));
	}


	
	
	 @Test(priority =15)
	 public void deletePriceRule() throws ClassNotFoundException, SQLException {
		 
		 Login login = PageFactory.initElements(driver, Login.class);
		 login.selectDealer();
		 login.searchDealerCitroen(DataproviderFactory.getExcel().getData("Sheet2", 3, 0));
		  PriceruleDealer Invt = PageFactory.initElements(driver,PriceruleDealer.class);
	     Invt.deletePriceRule();
	     logger.log(LogStatus.INFO,
					logger.addScreenCapture(Helper.captureScreenshot(driver, "Deleted Price is not apearing in Price List BackEnd")));
	    
	 	  
	 }
	 
	 @AfterClass
		public void tearDown1() {
			Login login = PageFactory.initElements(driver, Login.class);
			login.logOut();
			logger.log(LogStatus.INFO, "Logout the application ");
			BrowserFactory.closeBrowser(driver);
			logger.log(LogStatus.INFO, "Closing the Browser");
			report.endTest(logger);
			report.flush();
		}
		
}
