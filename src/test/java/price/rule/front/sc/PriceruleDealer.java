package price.rule.front.sc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import factory.DataproviderFactory;

public class PriceruleDealer

{
	WebDriver driver;

	public PriceruleDealer(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//a[text()='Inventory Management']")
	WebElement ivntMgmt;

	@FindBy(xpath = "//a[text()='Manage Price Rules']")
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
	WebElement Dateicon;

	@FindBy(xpath = "//input[@id='startDate']")
	WebElement StartDate;

	@FindBy(id = "discountBy")
	WebElement Discount;

	@FindBy(xpath = "//input[@name='discountValue']")
	WebElement Discountvalue;

	@FindBy(xpath = "//input[@name='submit']")
	WebElement UpdateButton;

	@FindBy(xpath = "//select[@id='make']")
	WebElement Make;

	@FindBy(css = "#model")
	WebElement Model;

	@FindBy(css = "#trim")
	WebElement Trim;

	@FindBy(xpath = "//input[@id='endDate']")
	WebElement EndDate;

	@FindBy(css = "#overrideCustom")
	WebElement CustomChekBox;

	@FindBy(css = "a[href$='RuleId=714']>img")
	WebElement PriceRuleEditButton;

	@FindBy(xpath = "//a[@href='javascript:confirmDelete(717)']//img[@title='Delete']")
	WebElement PriceRuleDeleteButton;

	@FindBy(xpath = "//select[@id='status']")
	WebElement Status;

	@FindBy(xpath = "//li[@id='tab-id-2']//a[text()='Inactive & Expired Rules']")
	WebElement InExTab;

	public void manageInventory() {

		ivntMgmt.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		priceRule.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		RuleButton.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void expiredPriceRule() {

		ivntMgmt.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		priceRule.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		PriceRuleEditButton.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		EndDate.sendKeys("28/03/2018");

		// sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 4, 9));
		// System.out.println(EndDate);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		UpdateButton.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void inactivePriceRule() {
		ivntMgmt.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		priceRule.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		/*//PriceRuleEditButton.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// EndDate.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 4,
		// 9));
		//System.out.println(EndDate);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		Select status = new Select(Status);
		status.selectByValue("ICTV");
		UpdateButton.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);*/

		/*
		 * Actions act=new Actions(driver);
		 * act.moveToElement(InExTab).build().perform();
		 */

		//InExTab.click();

	}

	public void deletePriceRule() {
		ivntMgmt.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		priceRule.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		PriceRuleDeleteButton.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void renaultDlrTradeinDiscount() {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Select cat = new Select(PriceCategory);
		cat.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 1, 0));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select type = new Select(VehicleType);
		type.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 1, 1));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select provider = new Select(Provider);

		provider.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 1, 2));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		StartDate.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 1, 8));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Discountvalue.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 1, 11));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		UpdateButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void renaultDlrDealerDiscount() {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Select cat = new Select(PriceCategory);
		cat.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 3, 0));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select type = new Select(VehicleType);
		type.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 3, 1));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select provider = new Select(Provider);
		provider.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 3, 2));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		Make.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 3, 5));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Model.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 3, 6));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Trim.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 3, 7));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		StartDate.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 3, 8));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// EndDate.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 3,
		// 9));

		Select discount = new Select(Discount);
		discount.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 3, 10));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Discountvalue.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 3, 11));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CustomChekBox.click();

		UpdateButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void citroentDlrOemDiscount() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Select cat = new Select(PriceCategory);
		cat.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 2, 0));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select type = new Select(VehicleType);
		type.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 2, 1));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select provider = new Select(Provider);
		provider.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 2, 2));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Make.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 2, 5));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		StartDate.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 2, 8));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select discount = new Select(Discount);
		discount.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 2, 10));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Discountvalue.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 2, 11));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select provider = new Select(Provider);
		provider.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 4, 2));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		StartDate.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 4, 8));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select discount = new Select(Discount);
		discount.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 4, 10));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Discountvalue.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 4, 11));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		UpdateButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public String applicationTitile() {

		return driver.getTitle();
	}

}
