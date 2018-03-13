package price.rule.front.sc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.database.Database;

import factory.DataproviderFactory;

public class PriceruleDealer

{
	WebDriver driver;

	public PriceruleDealer(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//a[text()='Inventory Management']")
	WebElement ivntMgmt;

	@FindBy(xpath = "//a[@id='sd3'][text()='Manage Price Rules']")
	WebElement priceRule;

	@FindBy(xpath = "//a[text()='Add Inventory Rule']")
	WebElement RuleButton;

	// AddingPriceRule

	@FindBy(xpath = "//select[@id='categoryId']")
	WebElement PriceCategory;

	@FindBy(id = "inventoryType")
	WebElement VehicleType;

	@FindBy(id = "providerInfo")
	WebElement Provider;

	@FindBy(id = "invProvider")
	WebElement GProvider;

	@FindBy(id = "invDealerid")
	WebElement Dealer;

	@FindBy(id = "invLocation")
	WebElement ILocation;

	@FindBy(xpath = "//input[@id='startDate']/..//img[@class='ui-datepicker-trigger']")
	WebElement StartDateicon;

	@FindBy(xpath = "//input[@id='endDate']/..//img[@class='ui-datepicker-trigger']")
	WebElement EndDateicon;

	@FindBy(xpath = "//input[@id='startDate']")
	WebElement StartDate;

	@FindBy(id = "discountBy")
	WebElement Discount;

	@FindBy(xpath = "//input[@name='discountValue']")
	WebElement Discountvalue;

	@FindBy(xpath = "//input[@name='submit'][@type='submit']")
	WebElement UpdateButton;

	@FindBy(xpath = "//input[@value='Save'][@type='submit']")
	WebElement Save;

	@FindBy(xpath = "//select[@id='make']")
	WebElement Make;

	@FindBy(css = "#model")
	WebElement Model;

	@FindBy(css = "#trim")
	WebElement Trim;

	@FindBy(xpath = "//input[@id='endDate'][@name='endDate']")
	WebElement EndDate;

	@FindBy(xpath = "//span[text()='Prev']")
	WebElement PrevMonth;

	@FindBy(xpath = "//a[text()='8']")
	WebElement SelecDate;

	@FindBy(css = "#overrideCustom")
	WebElement CustomChekBox;

	@FindBy(xpath = "//a[@href='javascript:confirmDelete(717)']//img[@title='Delete']")
	WebElement PriceRuleDeleteButton;

	@FindBy(xpath = "//select[@id='status']")
	WebElement Status;

	@FindBy(xpath = "//li[@id='tab-id-2']//a[text()='Inactive & Expired Rules']")
	WebElement InExTab;

	public void manageInventory() {

		ivntMgmt.click();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		priceRule.click();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RuleButton.click();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void expiredPriceRule() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='endDate'][@name='endDate']")));
		EndDateicon.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PrevMonth.click();
		SelecDate.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select status = new Select(Status);
		status.getFirstSelectedOption();
		UpdateButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		InExTab.click();
	}

	public void inactivePriceRule() {

		Select status = new Select(Status);
		status.selectByValue("ICTV");
		UpdateButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		InExTab.click();

	}

	public void deletePriceRule() throws ClassNotFoundException, SQLException {
		Database databse = new Database();
		String Query = "select *from inventory_price_rules  where level='DLR' and fk_dealer_id=102878 "
				+ " and  discount_by='FLAT'  and status='ACTV'; ";
		ResultSet data = databse.getData(Query);
		boolean firstData = data.next();
		String ID = "";
		if (firstData) {
			ID = data.getString(1);
			// System.out.println(ID);
		}

		ivntMgmt.click();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		priceRule.click();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("//a[contains(@href,'javascript:confirmDelete(" + (ID) + ")')]//img[@title='Delete']"))
				.click();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void renaultDlrTradeinDiscount() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select cat = new Select(PriceCategory);
		cat.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 1, 0));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select type = new Select(VehicleType);
		type.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 1, 1));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select provider = new Select(Provider);

		provider.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 1, 2));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		StartDate.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 1, 8));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript(
		 * "document.getElementById('startDate').value='15/02/2018'");
		 */

		/*
		 * List<WebElement> allDates=driver.findElements
		 * (By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[5]/a"))
		 * ;
		 * 
		 * for(WebElement ele:allDates) {
		 * 
		 * String date=ele.getText();
		 * 
		 * if(date.equalsIgnoreCase("8")) { ele.click(); break; }
		 * 
		 * }
		 */
		Select discount = new Select(Discount);
		// discount.selectByValue("FLAT");
		discount.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 1, 10));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Discountvalue.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 1, 11));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		UpdateButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void renaultDlrDealerDiscount() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select cat = new Select(PriceCategory);
		cat.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 3, 0));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select type = new Select(VehicleType);
		type.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 3, 1));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select provider = new Select(Provider);
		provider.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 3, 2));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Make.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 3, 5));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Model.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 3, 6));

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Trim.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 3, 7));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		StartDate.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 3, 8));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// EndDate.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 3,
		// 9));

		Select discount = new Select(Discount);
		discount.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 3, 10));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Discountvalue.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 3, 11));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CustomChekBox.click();

		UpdateButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void citroentDlrOemDiscount() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Select cat = new Select(PriceCategory);
		cat.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 2, 0));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select type = new Select(VehicleType);
		type.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 2, 1));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select provider = new Select(Provider);
		provider.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 2, 2));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Make.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 2, 5));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		StartDate.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 2, 8));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select discount = new Select(Discount);
		discount.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 2, 10));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Discountvalue.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 2, 11));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		UpdateButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void citroentDlrGreenDiscount() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Select cat = new Select(PriceCategory);
		cat.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 4, 0));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select type = new Select(VehicleType);
		type.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 4, 1));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select provider = new Select(Provider);
		provider.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 4, 2));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		StartDate.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 4, 8));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select discount = new Select(Discount);
		discount.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 4, 10));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Discountvalue.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 4, 11));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		UpdateButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public String applicationTitile() {

		return driver.getTitle();
	}

}
