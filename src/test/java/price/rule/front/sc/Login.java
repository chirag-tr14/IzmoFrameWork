package price.rule.front.sc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	public WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = "//input[@name='loginId']")
	WebElement userName;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passWord;

	@FindBy(xpath = "//input[@name='Submit']")
	WebElement LoginButton;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement LogoutButton;

	@FindBy(xpath = "//a[@id='dealerbutton']")
	WebElement SelectOrganization;

	@FindBy(xpath = "//span[text()='SiteList']")
	WebElement SiteList;

	@FindBy(xpath = "//div[@id='dataTableGrid_filter']//input[@type='text']")
	WebElement Dlrsearch;

	@FindBy(xpath = "//td[@class=' sorting_1'][.//a[text()='RENAULT ANNEMASSE']]")
	WebElement RDealer;

	@FindBy(xpath = "//a[contains(@onclick,'return select1')]")
	WebElement CDealer;

	@FindBy(xpath = "//input[@name='search']")
	WebElement GroupSearch;

	@FindBy(xpath = "//a[contains(@onclick,'102863')]")
	WebElement Group;

	public void loginApplication(String user, String pass) {
		userName.sendKeys(user);
		passWord.sendKeys(pass);
		LoginButton.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void selectDealer() {

		SelectOrganization.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	public void searchDealerRenault(String dealer) {

		SiteList.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Dlrsearch.sendKeys(dealer);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		RDealer.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void searchDealerCitroen(String dealer) {

		SiteList.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Dlrsearch.sendKeys(dealer);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		CDealer.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void pgagroupSearch(String group) {

		GroupSearch.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		GroupSearch.sendKeys(group);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Group.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void logOut() {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		LogoutButton.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public String getApplicationTitile() {

		return driver.getTitle();
	}

}
