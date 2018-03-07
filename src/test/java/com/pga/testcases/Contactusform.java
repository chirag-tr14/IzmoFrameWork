package com.pga.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import factory.BrowserFactory;
import factory.DataproviderFactory;

public class Contactusform

{
	WebDriver driver;

	ExtentReports report;
	ExtentTest logger;

	@FindBy(css = "input[id='FirstName']")
	WebElement FirstName;

	@FindBy(css = "input[name='lastName']")
	WebElement LastName;

	@FindBy(css = "input[class='required validzip'][id='Zip2']")
	WebElement Postalcode;

	@FindBy(css = "input#city")
	WebElement City;

	@FindBy(css = "input#Email")
	WebElement Email;

	@FindBy(css = "input[id*='OffP']")
	WebElement Telephone;

	@FindBy(css = "select[name^='dept']")
	WebElement Department;

	@FindBy(css = "textarea[name^='Comments']")
	WebElement Comments;

	@BeforeSuite()
	public void setUp() {
		driver = BrowserFactory.getBrowser("chrome");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getConfig().contactusFormUrl());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		report = new ExtentReports("./Reports/Contactus form.html", true);

	}

	@Test(dataProvider = "contactusForm")
	public void submitForm(String FName, String LName, String Postal, String City, String Email, String Telephone,
			String Department, String Comments)

	{

		/*
		 * driver= BrowserFactory.getBrowser("chrome");
		 * driver.manage().deleteAllCookies();
		 * driver.get(DataproviderFactory.getConfig().contactusFormUrl());
		 * driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 */

		WebElement Button = driver.findElement(By.cssSelector("button[type='submit']"));

		/*
		 * WebDriverWait wait = new WebDriverWait(driver,20);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated((By)
		 * Button));
		 */
		Button.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		driver.findElement(By.cssSelector("input[id='FirstName']")).sendKeys(FName);

		Button.click();
		alert.accept();
		driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(LName);
		Button.click();
		alert.accept();
		driver.findElement(By.cssSelector("input[class='required validzip'][id='Zip2']")).sendKeys(Postal);
		Button.click();
		alert.accept();
		driver.findElement(By.cssSelector("input#city")).sendKeys(City);
		Button.click();
		alert.accept();
		driver.findElement(By.cssSelector("input#Email")).sendKeys(Email);
		Button.click();
		alert.accept();
		driver.findElement(By.cssSelector("input[id*='OffP']")).sendKeys(Telephone);
		Button.click();
		alert.accept();
		driver.findElement(By.cssSelector("select[name^='dept']")).sendKeys(Department);

		WebElement Comment = driver.findElement(By.cssSelector("textarea[name^='Comments']"));
		Comment.click();
		Comment.sendKeys(Comments);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement Checkbox1 = driver
				.findElement(By.xpath(".//*[@id='sky-form4']/fieldset/section[8]/div/div[2]/label/i"));
		Checkbox1.click();

		WebElement Checkbox2 = driver.findElement(By.cssSelector(
				"input[value*='Si vous ne souhaitez pas recevoir nos offres et nos promotions, cochez cette case']"));
		Checkbox2.click();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Button.click();

	}

	@AfterMethod()
	public void tearDown() {
		driver.close();
	}

	@DataProvider(name = "contactusForm")
	public Object[][] passData() {
		int rows = DataproviderFactory.contactusExcel().getRowCount(0);
		// int columns=DataproviderFactory.contactusExcel()

		Object[][] data = new Object[rows][8];

		for (int i = 1; i < rows; i++) {

			data[i - 1][0] = DataproviderFactory.contactusExcel().getData(0, i, 0);
			data[i - 1][1] = DataproviderFactory.contactusExcel().getData(0, i, 1);
			data[i - 1][2] = DataproviderFactory.contactusExcel().getData(0, i, 2);
			data[i - 1][3] = DataproviderFactory.contactusExcel().getData(0, i, 3);
			data[i - 1][4] = DataproviderFactory.contactusExcel().getData(0, i, 4);
			data[i - 1][5] = DataproviderFactory.contactusExcel().getData(0, i, 5);
			data[i - 1][6] = DataproviderFactory.contactusExcel().getData(0, i, 6);
			data[i - 1][7] = DataproviderFactory.contactusExcel().getData(0, i, 7);

		}

		return data;
	}
}
/*
 * public Object[][] passData() { int
 * rows=DataproviderFactory.contactusExcel().getRowCount(0); //int
 * columns=DataproviderFactory.contactusExcel();
 * 
 * 
 * Object[][] data= new Object[rows][7];
 * 
 * for(int i=0;i<rows;i++) {
 * 
 * 
 * data[i][0]=DataproviderFactory.contactusExcel().getData(0, i, 0);
 * data[i][1]=DataproviderFactory.contactusExcel().getData(0, i, 1);
 * 
 * }
 * 
 * return data;
 * 
 * 
 * public static Object[][] getTableArray(String FilePath, String SheetName)
 * throws Exception {
 * 
 * String[][] tabArray = null;
 * 
 * }
 */
