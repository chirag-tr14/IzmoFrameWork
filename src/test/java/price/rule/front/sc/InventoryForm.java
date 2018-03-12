package price.rule.front.sc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import factory.DataproviderFactory;

public class InventoryForm {
	WebDriver driver;

	public InventoryForm(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//input[@id='SearchKeyword']")
	WebElement SearchField;

	@FindBy(xpath = "//button[contains(@onclick,'doSearch')]")
	WebElement SubmitButton;

	@FindBy(xpath = "//button[@type='button' and contains(text(),'Soit')][1]")
	WebElement PrDropdown;

	@FindBy(xpath = "//button[contains(@onclick,'removeSearch')]")
	WebElement SerchRemoveButton;

	public void priceRuleValue() {
		SerchRemoveButton.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		SearchField.sendKeys(DataproviderFactory.getExcel().getData("Sheet4", 1, 1));

		SubmitButton.click();

		PrDropdown.click();
		
	}

	public void otherValue() {
		SearchField.sendKeys(DataproviderFactory.getExcel().getData("Sheet4", 2, 1));

		SubmitButton.click();

		PrDropdown.click();

	}

	public void MakepriceRuleValue() {
		SerchRemoveButton.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		SearchField.sendKeys(DataproviderFactory.getExcel().getData("Sheet4", 3, 1));

		SubmitButton.click();

		PrDropdown.click();

	}

	public void otherMakepriceRuleValue() {
		SerchRemoveButton.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		SearchField.sendKeys(DataproviderFactory.getExcel().getData("Sheet4", 4, 1));

		SubmitButton.click();

		PrDropdown.click();

	}

	public void citroenpriceRuleValue() {

		SearchField.sendKeys(DataproviderFactory.getExcel().getData("Sheet4", 6, 1));

		SubmitButton.click();

		PrDropdown.click();

	}
	
	public void inactivepriceRuleValue() {
		SearchField.sendKeys(DataproviderFactory.getExcel().getData("Sheet4", 1, 1));

		SubmitButton.click();

		PrDropdown.click();

	}

}
