package sc.front.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import factory.DataproviderFactory;

public class forms

{

	
	WebDriver driver;
	
    public forms(WebDriver ldriver)
    {
  	  this.driver=ldriver;
    }
	

	@FindBy(css="#pageType1") WebElement ContentPage;
	
	@FindBy(css="#pageType2") WebElement IfrmePage;
	
	@FindBy(css="#pageType3") WebElement CampignPage;
	
	@FindBy(css="#pageType5") WebElement SpecialPage;
	
	@FindBy(css="#pageType6") WebElement AboutusPage;
	
	@FindBy(css="#pageType6") WebElement PrivacyPage;
	
	@FindBy(css="#pageType8") WebElement RssPage;
	
	
	@FindBy(css="input[id*='pageTitle'][name^='pageTitle']") WebElement Title;
	
	@FindBy(css="input[id^='pageUrl'][name*='pageUrl']") WebElement Url;
	
	
	@FindBy(css="select[id*='pageDepartments'][name^='pageDepartments']") WebElement Deaprtments;
	
	@FindBy(xpath="//table[@id='cntContainer_editorobj1']") WebElement ResponsiveContent;
	
	@FindBy(xpath="//input[@value='Save Page']") WebElement SavePage;
	
	
	
	
	
		public void contentPage(){
	
			AboutusPage.click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				Title.sendKeys(DataproviderFactory.getExcel().getData("Sheet1", 1, 1));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Url.sendKeys(DataproviderFactory.getExcel().getData("Sheet1", 1, 2));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
				Select dropdown= new Select(driver.findElement(By.cssSelector("Deaprtments")));
				dropdown.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet1", 1, 3));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
				ResponsiveContent.sendKeys(DataproviderFactory.getExcel().getData("Sheet1", 1, 4));
		
				SavePage.click();
		}
		
		public void aboutUsPage(){
	
			ContentPage.click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				Title.sendKeys(DataproviderFactory.getExcel().getData("Sheet1", 5, 1));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Url.sendKeys(DataproviderFactory.getExcel().getData("Sheet1", 5, 2));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
				Select dropdown= new Select(driver.findElement(By.cssSelector("Deaprtments")));
				dropdown.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet1", 5, 3));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
				ResponsiveContent.sendKeys(DataproviderFactory.getExcel().getData("Sheet1", 5, 4));
		
				SavePage.click();
		}
	
		public void privacyPage(){
			PrivacyPage.click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				Title.sendKeys(DataproviderFactory.getExcel().getData("Sheet1", 10, 1));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Url.sendKeys(DataproviderFactory.getExcel().getData("Sheet1", 10, 2));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
				Select dropdown= new Select(driver.findElement(By.cssSelector("Deaprtments")));
				dropdown.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet1", 10, 3));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
				ResponsiveContent.sendKeys(DataproviderFactory.getExcel().getData("Sheet1", 10, 4));
		
				SavePage.click();
		}
	
	
	
	
}
