package price.rule.front.sc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import factory.DataproviderFactory;

public class PriceruleGroup {

	WebDriver driver;

	public PriceruleGroup(WebDriver ldriver) {
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

	@FindBy(id = "invProvider")
	WebElement GProvider;

	@FindBy(id = "invDealerid")
	WebElement Dealer;

	@FindBy(id = "invLocation")
	WebElement ILocation;

	@FindBy(xpath = "//input[@id='startDate']/..//img[@class='ui-datepicker-trigger']")
	WebElement Dateicon;

	@FindBy(xpath = "//input[@id='startDate']")
	WebElement SDate;

	@FindBy(id = "discountBy")
	WebElement Discount;

	@FindBy(xpath = "//input[@name='discountValue']")
	WebElement Discountvalue;

	@FindBy(xpath = "//input[@name='submit']")
	WebElement Button;

	@FindBy(css = "#make")
	WebElement CMake;

	public void manageInventory() {

		ivntMgmt.click();
		priceRule.click();
		RuleButton.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void delaerDiscountPriceRuleGroup() {

		Select cat = new Select(PriceCategory);
		cat.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 5, 0));

		Select type = new Select(VehicleType);
		type.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 5, 1));

		Select provider = new Select(GProvider);
		provider.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 5, 2));

		Select dealer = new Select(Dealer);
		dealer.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 5, 3));

		Select location = new Select(ILocation);
		location.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 5, 4));

		SDate.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 5, 8));

		Select discount = new Select(Discount);

		discount.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 5, 10));

		Discountvalue.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 5, 11));

		Button.click();

	}

	public void oemDiscountPriceRuleGroup() {

		Select cat = new Select(PriceCategory);
		cat.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 6, 0));

		Select type = new Select(VehicleType);
		type.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 6, 1));

		Select provider = new Select(GProvider);
		provider.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 6, 2));

		SDate.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 6, 8));

		Select discount = new Select(Discount);

		discount.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 6, 10));

		Discountvalue.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 6, 11));

		Button.click();

	}

	public void tradeinDiscountPriceRuleGroup() {

		Select cat = new Select(PriceCategory);
		cat.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 7, 0));

		Select type = new Select(VehicleType);
		type.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 7, 1));

		Select provider = new Select(GProvider);
		provider.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 7, 2));

		SDate.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 7, 8));

		Select discount = new Select(Discount);

		discount.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 7, 10));

		Discountvalue.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 7, 11));

		Button.click();

	}

	public void greenDiscountPriceRuleGroup() {

		Select cat = new Select(PriceCategory);
		cat.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 8, 0));

		Select type = new Select(VehicleType);
		type.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 8, 1));

		Select provider = new Select(GProvider);
		provider.selectByValue(DataproviderFactory.getExcel().getData("Sheet3", 8, 2));

		SDate.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 8, 8));

		Select discount = new Select(Discount);

		discount.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet3", 8, 10));

		Discountvalue.sendKeys(DataproviderFactory.getExcel().getData("Sheet3", 8, 11));

		Button.click();

	}

}
