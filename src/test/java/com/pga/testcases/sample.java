package com.pga.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class sample

{

	WebDriver driver;

	@Test
	public void ieBrowser() throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "F:\\TNR\\Driver\\MicrosoftWebDriver.exe");
		driver = new EdgeDriver();

		driver.get("qa.citroen-annecy.izdemosite.com\\contact-fr-fr.htm");
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("input[id='FirstName']")).sendKeys("Rajesh");

		// driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Rajesh");
	}
}
