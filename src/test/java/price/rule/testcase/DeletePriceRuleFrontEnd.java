package price.rule.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataproviderFactory;
import price.rule.front.sc.InventoryForm;
import utility.Helper;

public class DeletePriceRuleFrontEnd {

	WebDriver driver;
	ExtentReports report1;
	ExtentTest logger1;

	@BeforeMethod
	public void renaultpriceRuleDlr() {
		report1 = new ExtentReports(".\\Reports\\FrontEndPriceRuleAdd.html", true);
		logger1 = report1.startTest("This page Verifies Fron end  Price Rule");
		driver = BrowserFactory.getBrowser("chrome");
		logger1.log(LogStatus.INFO, "BrowserLaunch");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getExcel().getData("Sheet4", 1, 0));
		logger1.log(LogStatus.INFO, "Opening Front End URL");

	}

	@Test(priority = 7)
	public void deletePriceRuleRenaultDlr() {

		logger1 = report1.startTest("This page Verifies Fron end Deleted Price Rule");
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

	@Test(priority = 4)
	public void inactivePriceRuleCitroen() {
		logger1 = report1.startTest("This page Verifies Fron end  Price Rule");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);

		form.citroenpriceRuleValue();
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

		// Assert.assertEquals(actual, price.getText());

		logger1.log(LogStatus.PASS, "Price rule value is  captured for respective  vehicles");

	}

}
